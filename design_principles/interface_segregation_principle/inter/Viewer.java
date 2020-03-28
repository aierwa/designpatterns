package interface_segregation_principle.inter;

import java.util.Map;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public interface Viewer {
    String outputPlainText();
    Map<String, Object> output();
}
