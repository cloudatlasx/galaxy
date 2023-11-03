package onem.learn.gc;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/9/22
 * @Version V1.0
 */
@Slf4j
public class Runner {
    public static List<Byte[]> getSmaller() {
        List<Byte[]> smaller = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            log.info("smaller index: {}", i);
            smaller.add(Smaller.init());
        }
        return smaller;
    }
    public static List<Byte[]> getBigger() {
        List<Byte[]> bigger = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            log.info("bigger index: {}", i);
            bigger.add(Bigger.init());
        }
        return bigger;
    }
}
