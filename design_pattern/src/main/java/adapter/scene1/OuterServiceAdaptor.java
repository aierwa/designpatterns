package adapter.scene1;

/**
 * @author xuxiang
 * 2020/4/13
 */
public class OuterServiceAdaptor extends OuterService implements ITarget {

    public void function1() {
        OuterService.staticFunction1();
    }

    public void function2() {
        super.uglyNamingFunction2();
    }

    public void function3(ParamBean paramBean) {
        super.tooManyParamsFunction3(paramBean.getParamA(), paramBean.getParamB(),
                paramBean.getParamC(), paramBean.getParamD());
    }

    public void function4() {
        // reimplement it...
    }
}
