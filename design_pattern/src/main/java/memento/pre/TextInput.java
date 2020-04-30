package memento.pre;

import java.util.Scanner;

/**
 * @author xuxiang
 * 2020/4/30
 */
public class TextInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TextStorage textStorage = new TextStorage();
        String inputStr;
        while (scan.hasNext()) {
            inputStr = scan.next();
            if (":list".equals(inputStr)) {
                System.out.println(textStorage.list());
            } else if (":undo".equals(inputStr)) {
                textStorage.undo();
            } else {
                textStorage.append(inputStr);
            }
        }
    }
}
