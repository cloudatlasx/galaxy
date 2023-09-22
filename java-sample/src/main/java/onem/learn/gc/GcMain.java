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
public class GcMain {
    public static void main(String[] args) {
        List<Byte[]> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            log.info("i: " + i);
            list.add(new Byte[1024 * 1024]);
        }
    }
}
