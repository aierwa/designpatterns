package memento.mode1;


/**
 * @author xuxiang
 * 2020/4/30
 */
public class TextStorage {
    private StringBuilder text;

    public TextStorage() {
        text = new StringBuilder();
    }

    public void append(String content) {
        text.append(content);
    }

    public String list() {
        return text.toString();
    }

    public TextSnapshot createSnapshot() {
        return new TextSnapshot(text.toString());
    }

    public void restoreSnapshot(TextSnapshot textSnapshot) {
        text.replace(0, text.length(), textSnapshot.getText());
    }

}
