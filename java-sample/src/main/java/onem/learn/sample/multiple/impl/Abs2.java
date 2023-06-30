package onem.learn.sample.multiple.impl;

import onem.learn.sample.multiple.AbsClass;
import onem.learn.sample.multiple.Slot;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/12/26
 * @Version V1.0
 */
@Service
public class Abs2 extends AbsClass {

    public Abs2() {
        slot = new Slot();
        slot.order = 2;
        slot.forced = true;
    }

    @Override
    public void apply() {
        System.out.println("打印ABS2 ORDER：" + slot.order + " FORCED：" + slot.forced);
    }
}
