package factory.dependency_injection_container;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuxiang
 */
public class BeansFactory {
    /**
     * Save all bean definitions.
     */
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    /**
     * Save all singletons.
     */
    private ConcurrentHashMap<String, Object> singletonMap = new ConcurrentHashMap<>();
    /**
     * Save the creating bean definitions to avoid circular reference.
     */
    private ConcurrentHashMap<String, BeanDefinition> creatingBeanDefinitionMap = new ConcurrentHashMap<>();

    public void addBeanDefinitions(List<BeanDefinition> beanDefinitions) {

        // Firstly put all bean definitions to map,
        // because maybe there are other bean refs when create a bean.
        for (BeanDefinition beanDefinition : beanDefinitions) {
            beanDefinitionMap.putIfAbsent(beanDefinition.getId(), beanDefinition);
        }

        for (BeanDefinition beanDefinition : beanDefinitions) {
            if (beanDefinition.isLazyInit() || !beanDefinition.isSingleton()) {
                continue;
            }
            createBean(beanDefinition);
        }
    }

    /**
     * Create bean using java reflection.
     * Get from singletonMap if the scope was set as singleton and already existed.
     * Otherwise it will create a new instance.
     *
     * @param beanDefinition
     * @return bean
     */
    public Object createBean(BeanDefinition beanDefinition) {
        if (beanDefinition.isSingleton() && singletonMap.containsKey(beanDefinition.getId())) {
            return singletonMap.get(beanDefinition.getId());
        }

        Object bean = null;
        try {
            creatingBeanDefinitionMap.putIfAbsent(beanDefinition.getId(), beanDefinition);

            Class beanClass = Class.forName(beanDefinition.getClassName());
            List<BeanDefinition.ConstructArg> args = beanDefinition.getConstructArgs();

            if (args.isEmpty()) {
                bean = beanClass.newInstance();
            } else {
                Class[] argClasses = new Class[args.size()];
                Object[] argObjects = new Object[args.size()];
                for (int i = 0; i < args.size(); i++) {
                    BeanDefinition.ConstructArg arg = args.get(i);
                    if (arg.isRef()) {
                        BeanDefinition refBeanDef = beanDefinitionMap.get(arg.getArg());
                        if (refBeanDef == null) {
                            throw new NoSuchBeanDefinitionException("Bean is not defined: " + arg.getArg());
                        }
                        argClasses[i] = Class.forName(refBeanDef.getClassName());
                        // solve circular reference!
                        if (creatingBeanDefinitionMap.containsKey(refBeanDef.getId())) {
                            throw new BeanCreateFailException("circular reference " + refBeanDef.getId());
                        }
                        argObjects[i] = createBean(refBeanDef);

                    } else {
                        argClasses[i] = arg.getType();
                        argObjects[i] = arg.getArg();
                    }
                }

                bean = beanClass.getConstructor(argClasses).newInstance(argObjects);
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            throw new BeanCreateFailException("", e);
        }

        if (bean != null && beanDefinition.isSingleton()) {
            singletonMap.putIfAbsent(beanDefinition.getId(), bean);
        }
        creatingBeanDefinitionMap.clear();
        return bean;
    }

    /**
     * Get bean from factory by beanId.
     * Throw NuSuchBeanDefinitionException if beanId if not defined.
     *
     * @param beanId
     * @return bean
     */
    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanId);
        if (beanDefinition == null) {
            throw new NoSuchBeanDefinitionException("Bean is not defined: " + beanId);
        }
        return createBean(beanDefinition);
    }
}
