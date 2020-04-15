package composite.scene2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxiang
 * 2020/4/15
 */
public class Department extends HumanResource {
    private List<HumanResource> subNodes = new ArrayList<>();

    public Department(long id) {
        super(id);
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0;
        for (HumanResource node : subNodes) {
            totalSalary += node.calculateSalary();
        }
        return totalSalary;
    }

    /**
     * add a sub node.
     *
     * @param humanResource employee or sub-department.
     */
    public void addSubNode(HumanResource humanResource) {
        subNodes.add(humanResource);
    }
}
