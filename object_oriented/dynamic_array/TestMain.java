/**
 * @author xuxiang
 * 2020/3/26
 */
public class TestMain {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        DynamicArray sortedDynamicArray = new SortedDynamicArray();
        test(dynamicArray);
        test(sortedDynamicArray);
    }

    private static void test(DynamicArray dynamicArray) {
        dynamicArray.add(3);
        dynamicArray.add(1);
        dynamicArray.add(10);
        dynamicArray.add(8);
        System.out.println(dynamicArray.toString());
        System.out.println(dynamicArray.get(3));
    }
}
