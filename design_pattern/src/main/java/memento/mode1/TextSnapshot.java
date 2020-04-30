package memento.mode1;

/**
 * @author xuxiang
 * 2020/4/30
 */
public class TextSnapshot {
    private String text;

    public TextSnapshot(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
