package prototype;

/**
 * @author xuxiang
 */
public class SearchWord {
    private String keyWord;
    private Long timestamp;

    public SearchWord(String keyWord, Long timestamp) {
        this.keyWord = keyWord;
        this.timestamp = timestamp;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SearchWord{" +
                "keyWord='" + keyWord + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
