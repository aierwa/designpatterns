package flyweight.scene1;

/**
 * chess piece
 * this class can be designed to flyweight, because there are only 30
 * unchangeable chess unit. Each chess board can ref them.
 *
 * @author xuxiang
 */
public class ChessPieceUnit {
    private int id;
    private String text;
    private Color color;

    public ChessPieceUnit(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }

    public enum Color {
        RED, BLACK;
    }
}
