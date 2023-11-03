package onem.learn.gc;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import lombok.extern.slf4j.Slf4j;

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
        List<Byte[]> smaller = Runner.getSmaller();
        log.info("smaller size: {}", ObjectSizeCalculator.getObjectSize(smaller));
        List<Byte[]> bigger = Runner.getBigger();
        log.info("bigger size: {}", ObjectSizeCalculator.getObjectSize(bigger));
    }
}
