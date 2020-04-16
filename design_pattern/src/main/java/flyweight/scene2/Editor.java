package flyweight.scene2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxiang
 */
public class Editor {
    List<Character> characters = new ArrayList<>();

    public void append(char c, Font font, int size, int colorRGB) {
        characters.add(new Character(c, CharacterStyleFactory.getStyleInMap(font, size, colorRGB)));
    }
}
