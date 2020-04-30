package memento.mode1;


import java.util.Scanner;

/**
 * @author xuxiang
 * 2020/4/30
 */
public class TextInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TextStorage textStorage = new TextStorage();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        String inputStr;
        while (scan.hasNext()) {
            inputStr = scan.next();
            if (":list".equals(inputStr)) {
                System.out.println(textStorage.list());
            } else if (":undo".equals(inputStr)) {
                textStorage.restoreSnapshot(snapshotHolder.popSnapshot());
            } else {
                snapshotHolder.pushSnapshot(textStorage.createSnapshot());
                textStorage.append(inputStr);
            }
        }
    }
}
