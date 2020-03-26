import java.util.Arrays;

/**
 * @author xuxiang
 * 2020/3/26
 */
public class DynamicArray {
    private static final int DEFAULT_CAPACITY = 10;
    protected int size = 0;
    protected float factor = 0.75f;
    protected int capacity = DEFAULT_CAPACITY;
    protected Integer[] elements = new Integer[capacity];

    public DynamicArray(){}
    public DynamicArray(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException("invalid capacity: " + capacity);
        }
        this.capacity = capacity;
        elements = new Integer[capacity];
    }

    public int size() {
        return this.size;
    }

    public Integer get(int index) {
        return elements[index];
    }

    public void add(Integer element) {
        ensureCapacity();
        elements[size++] = element;
    }

    protected void ensureCapacity() {
        if (this.size > capacity - 1 ) {
            elements = Arrays.copyOf(elements, (int) (this.size / factor) + 1);
        }
    }

    @Override
    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        StringBuilder stringBuilder= new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(elements[i]);
            if (i == size - 1) {
                return stringBuilder.append("]").toString();
            }
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }
}
