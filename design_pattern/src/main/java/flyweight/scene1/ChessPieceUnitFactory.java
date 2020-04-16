package flyweight.scene1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuxiang
 */
public class ChessPieceUnitFactory {
    private static final Map<Integer, ChessPieceUnit> pieces = new HashMap<>();

    static {
        pieces.put(1, new ChessPieceUnit(1, "車", ChessPieceUnit.Color.BLACK));
        pieces.put(2, new ChessPieceUnit(2, "馬", ChessPieceUnit.Color.BLACK));
        // add other pieces...
    }

    public static ChessPieceUnit getChessPiece(int pieceId) {
        return pieces.get(pieceId);
    }
}
