package flyweight.scene2;

/**
 * @author xuxiang
 */
public class CharacterStyle {
    private Font font;
    private int size;
    private int colorRGB;

    public CharacterStyle(Font font, int size, int colorRGB) {
        this.font = font;
        this.size = size;
        this.colorRGB = colorRGB;
    }


    @Override
    public int hashCode() {
        return font.hashCode() + size * 31 + colorRGB * 31;
    }

    @Override
    public boolean equals(Object obj) {
        CharacterStyle style = (CharacterStyle) obj;
        return font.equals(style.getFont())
                && style.getSize() == size
                && style.getColorRGB() == colorRGB;
    }

    public Font getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    public int getColorRGB() {
        return colorRGB;
    }
}
