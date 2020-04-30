package memento.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxiang
 * 2020/4/30
 */
public class TextStorage {
    private StringBuilder text;
    private List<Integer> lengthRecords;


    public TextStorage() {
        text = new StringBuilder();
        lengthRecords = new ArrayList<>(128);
        lengthRecords.add(0);
    }

    public void append(String content) {
        text.append(content);
        lengthRecords.add(text.length());
    }

    public void undo() {
        if (lengthRecords.size() < 2) {
            System.out.println("nothing undo");
            return;
        }
        text.delete(lengthRecords.get(lengthRecords.size() - 2), text.length());
        lengthRecords.remove(lengthRecords.size() - 1);
    }

    public String list() {
        return text.toString();
    }

}
