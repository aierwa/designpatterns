package flyweight.scene1;

import java.util.HashMap;
import java.util.Map;

/**
 * chess board
 * there is one board for one game.
 * but using flyweight, the chessPieceUnit just have 30 instances all the while.
 *
 * @author xuxiang
 */
public class ChessBoard {
    private Map<Integer, ChessPiece> chessPieceMap = new HashMap<>();

    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieceMap.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(1), 0, 0));
        chessPieceMap.put(2, new ChessPiece(ChessPieceUnitFactory.getChessPiece(2), 1, 0));
        // add other chess piece...
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        //...
    }
}
