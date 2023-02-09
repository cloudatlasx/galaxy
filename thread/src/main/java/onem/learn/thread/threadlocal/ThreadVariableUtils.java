package onem.learn.thread.threadlocal;

import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/16
 * @Version V1.0
 */
public class ThreadVariableUtils {
    private ThreadVariableUtils() {
    }

    private static final ThreadLocal<Map<String, String>> MAP_THREAD_LOCAL = new ThreadLocal();

    public static void put(String k, String v) {
        if (Objects.isNull(MAP_THREAD_LOCAL.get())) {
            Map<String, String> cache = new HashMap<>();
            cache.put(k, v);
            MAP_THREAD_LOCAL.set(cache);
            return;
        }
        MAP_THREAD_LOCAL.get().put(k, v);
    }

    public static String get(String k) {
        if (Objects.isNull(MAP_THREAD_LOCAL.get())) {
            return null;
        }
        return MAP_THREAD_LOCAL.get().get(k);
    }

    public static void remove(String k) {
        if (Objects.isNull(MAP_THREAD_LOCAL.get())) {
            return;
        }
        MAP_THREAD_LOCAL.get().remove(k);
        if (MapUtils.isEmpty(MAP_THREAD_LOCAL.get())) {
            MAP_THREAD_LOCAL.remove();
        }
    }

    public static void clear() {
        MAP_THREAD_LOCAL.remove();
    }

    public static boolean contains(String k) {
        if (Objects.isNull(MAP_THREAD_LOCAL.get())) {
            return false;
        }
        return MAP_THREAD_LOCAL.get().containsKey(k);
    }

}
