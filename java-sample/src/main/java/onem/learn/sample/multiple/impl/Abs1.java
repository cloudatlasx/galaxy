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
public class Abs1 extends AbsClass {

    public Abs1() {
        slot = new Slot();
        slot.order = 1;
        slot.forced = false;
    }

    @Override
    public void apply() {
        System.out.println("打印ABS1 ORDER：" + slot.order + " FORCED：" + slot.forced);
    }

    @Override
    public int getException() {
        return 1/0;
    }

}
