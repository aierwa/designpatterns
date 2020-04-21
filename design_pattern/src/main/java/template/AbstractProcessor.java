package template;

/**
 * @author xuxiang
 * 2020/4/21
 */
public abstract class AbstractProcessor {
    /**
     * process entry
     * use final to avoid sub-class overwrite it.
     */
    public final void process() {
        preProcess();
        // do some logic...
        afterProcess();
    }

    /**
     * use abstract to force sub-class overwrite it.
     */
    protected abstract void preProcess();

    protected abstract void afterProcess();
}
