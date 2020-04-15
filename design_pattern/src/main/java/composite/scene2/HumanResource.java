package composite.scene2;

/**
 * base class
 * @author xuxiang
 * 2020/4/15
 */
public abstract class HumanResource {
    protected long id;
    protected  double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public abstract double calculateSalary();
}
