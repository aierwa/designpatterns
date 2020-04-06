package factory.dependency_injection_container;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxiang
 */
public class BeanDefinition {
    private String id;
    private String className;
    private List<ConstructArg> constructArgs = new ArrayList<>();
    private Scope scope = Scope.PROTOTYPE;
    private boolean lazyInit = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ConstructArg> getConstructArgs() {
        return constructArgs;
    }

    public void setConstructArgs(List<ConstructArg> constructArgs) {
        this.constructArgs = constructArgs;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public boolean isSingleton() {
        return this.scope == Scope.SINGLETON;
    }

    public static enum Scope {
        SINGLETON,
        PROTOTYPE;
    }

    public static class ConstructArg {
        private boolean isRef;
        private Class type;
        private Object arg;

        public boolean isRef() {
            return isRef;
        }

        public void setRef(boolean ref) {
            isRef = ref;
        }

        public Class getType() {
            return type;
        }

        public void setType(Class type) {
            this.type = type;
        }

        public Object getArg() {
            return arg;
        }

        public void setArg(Object arg) {
            this.arg = arg;
        }
    }
}
