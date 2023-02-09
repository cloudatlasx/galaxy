package onem.learn.javasample.multiple;

import lombok.Data;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/12/26
 * @Version V1.0
 */
@Data
public abstract class AbsClass {
    public Slot slot;

    public abstract void apply();
}
