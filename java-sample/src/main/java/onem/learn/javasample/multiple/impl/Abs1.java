package onem.learn.javasample.multiple.impl;

import onem.learn.javasample.multiple.AbsClass;
import onem.learn.javasample.multiple.Slot;
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

}
