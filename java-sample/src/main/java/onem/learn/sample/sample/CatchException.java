package onem.learn.sample.sample;

import lombok.extern.slf4j.Slf4j;
import onem.learn.sample.multiple.Slot;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/8/18
 * @Version V1.0
 */
@Slf4j
public class CatchException {
    public static void main(String[] args) {
        Slot slot = new Slot();
        try {
            slot.getException();
        } catch (Exception e) {
            log.info("getException", e);
        }
        try {
            slot.getException();
        } catch (Exception e) {
            log.error("getException", e);
        }
        slot.getException();
    }
}
