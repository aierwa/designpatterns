package flyweight.scene2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuxiang
 */
public class CharacterStyleFactory {
    /**
     * save the existed styles.
     */
    private static List<CharacterStyle> styleList = new ArrayList<>();

    /**
     * save the existed styles using map.
     */
    private static Map<CharacterStyle, CharacterStyle> styleMap = new HashMap<>();


    /**
     * This method use styleList to loop through every time.
     * So we can refactor it using map, be careful overwrite the hash() of CharacterStyle.
     *
     * @param font
     * @param size
     * @param colorRGB
     * @return
     */
    public static CharacterStyle getStyle(Font font, int size, int colorRGB) {
        CharacterStyle newStyle = new CharacterStyle(font, size, colorRGB);
        for (CharacterStyle style : styleList) {
            if (style.equals(newStyle)) {
                return style;
            }
        }
        styleList.add(newStyle);
        return newStyle;
    }

    public static CharacterStyle getStyleInMap(Font font, int size, int colorRGB) {
        CharacterStyle newStyle = new CharacterStyle(font, size, colorRGB);
        if (styleMap.containsKey(newStyle)) {
            return styleMap.get(newStyle);
        }
        styleMap.put(newStyle, newStyle);
        return newStyle;
    }
}
