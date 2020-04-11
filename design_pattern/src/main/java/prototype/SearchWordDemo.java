package prototype;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuxiang
 */
public class SearchWordDemo {
    private ConcurrentHashMap<String, SearchWord> searchWordMap = new ConcurrentHashMap<>();
    // searchWordMap3 was defined for test of refresh3()
    private Map<String, SearchWord> searchWordMap3 = new HashMap<>();
    // searchWordMap4 was defined for test of refresh4()
    private HashMap<String, SearchWord> searchWordMap4 = new HashMap<>();
    private long lastUpdateTime = -1;

    /**
     * 刷新实现 1： 存在 key 则对 searchWordMap 进行更新，否则插入
     * 该实现中， searchWordMap 中的数据在使用中可能是上次更新的，可能是这次更新的，如果不关注就行
     */
    public void refresh() {
        List<SearchWord> searchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : searchWords) {
            if (searchWord.getTimestamp() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getTimestamp();
            }
            // 我觉得这里没必要用 containsKey 以及 replace 等操作，直接 put，存在就替换，不存在就插入。
            searchWordMap.put(searchWord.getKeyWord(), searchWord);
        }

        // 将最近一次的更新时间置为 所有记录中的最大更新时间
        lastUpdateTime = maxNewUpdatedTime;

    }

    /**
     * 刷新实现 2： 新建一个 map，等所有值构建完毕后替换该 map 到 旧 map
     * 该实现中， 保证使用 searchWordMap 时，总是同一个版本更新的记录
     * 此方法缺点： newSearchWordMap 构建耗时，假如 10 万条数据，就会有 10 万次 hash 计算等
     */
    public void refresh2() {
        // 直接取出所有数据
        List<SearchWord> searchWords = getSearchWords(-1);
        ConcurrentHashMap<String, SearchWord> newSearchWordMap = new ConcurrentHashMap<>();
        for (SearchWord searchWord : searchWords) {
            newSearchWordMap.put(searchWord.getKeyWord(), searchWord);
        }

        searchWordMap = newSearchWordMap;
    }

    /**
     * 刷新实现 3： 使用 prototype 模型深拷贝重构 refresh2()
     * prototype： 拷贝已有对象的数据，更新少量差值
     * 使用原型主要考虑到： 搜索关键词更新的数量其实并不大，绝大部分都和以前是一样的
     */
    public void refresh3() {
        // 深拷贝
        Map<String, SearchWord> newSearchWordMap = new HashMap<>();
        for (Map.Entry<String, SearchWord> entry : searchWordMap3.entrySet()) {
            SearchWord searchWord = entry.getValue();
            newSearchWordMap.put(entry.getKey(), new SearchWord(searchWord.getKeyWord(), searchWord.getTimestamp()));
        }

        // 另一种深拷贝
//        Map<String, SearchWord> newSearchWordMap = (Map<String, SearchWord>) deepCopy(searchWordMap3);


        List<SearchWord> searchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : searchWords) {
            if (searchWord.getTimestamp() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getTimestamp();
            }
            newSearchWordMap.put(searchWord.getKeyWord(), searchWord);
        }

        lastUpdateTime = maxNewUpdatedTime;

        searchWordMap3 = newSearchWordMap;
    }


    /**
     * 刷新实现 4： 使用 prototype 模型浅拷贝重构 refresh3()
     * 深拷贝比较占内存，结合业务，可以考虑浅拷贝（只拷贝引用，不拷贝对象数据）
     * 也就是说，我们先浅拷贝 searchWordMap，再对需要更新的对象记录进行深拷贝
     */
    public void refresh4() {
        // 浅拷贝
        Map<String, SearchWord> newSearchWordMap = (Map<String, SearchWord>) searchWordMap4.clone();

        List<SearchWord> searchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : searchWords) {
            if (searchWord.getTimestamp() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getTimestamp();
            }
            // 注意：这里 remove ?
            // 经测试，这里不 remove 直接 put 的话，原 searchWordMap4 的值并不会受影响
            newSearchWordMap.remove(searchWord.getKeyWord());
            newSearchWordMap.put(searchWord.getKeyWord(), searchWord);
        }

        lastUpdateTime = maxNewUpdatedTime;

        searchWordMap3 = newSearchWordMap;
    }


    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // todo 从数据库获取 更新时间大于 lastUpdateTime 的 记录
        return null;
    }

    /**
     * deep copy for object using serialization and deserialization
     *
     * @param o source object, must implements Serializable.
     * @return a new object
     */
    private Object deepCopy(Object o) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(o);

            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            return oi.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        HashMap<String, SearchWord> map1 = new HashMap<>();
        map1.put("xx", new SearchWord("xx", 1L));
        map1.put("yy", new SearchWord("yy", 2L));

        HashMap<String, SearchWord> map2 = (HashMap<String, SearchWord>) map1.clone();
        System.out.println(map2.get("xx"));
        map2.remove("xx");
        map2.put("xx", new SearchWord("xx", 1111L));

        map1 = map2;

        System.out.println(map1.get("xx"));
        System.out.println(map2.get("xx"));
    }


}
