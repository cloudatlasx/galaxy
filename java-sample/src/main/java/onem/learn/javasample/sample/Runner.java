package onem.learn.javasample.sample;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/8
 * @Version V1.0
 */
public class Runner {
    public static void main(String[] args) {
        Map<Long, String> cache = new HashMap<>();
        Long key = 40753L;
        cache.put(key, "BHDDTY250SSD128G01");
        if (cache.containsKey(key)) {
            System.out.println("cache containsKey " + key);
        } else {
            cache.put(key, "BHDDTY250SSD128G02");
        }
        System.out.println(cache.get(key));
    }
}
