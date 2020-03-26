/**
 * @author xuxiang
 * 2020/3/26
 */
public class SortedDynamicArray extends DynamicArray {
    @Override
    public void add(Integer element) {
        ensureCapacity();
        // compare from last one
        int i;
        for(i = this.size - 1; i >= 0; i--) {
            if (element.compareTo(elements[i]) < 0) {
                elements[i + 1] = elements[i];
            } else {
                break;
            }
        }
        elements[i+1] = element;
        size++;
    }
}