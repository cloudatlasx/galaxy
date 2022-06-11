package com.learn.galaxy.thread.lifecycle;

/**
 * @Description:
 * @Author liuming
 * @Date 2022/6/10
 * @Version V1.0
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new WaitingTime(), "WaitingTimeThread").start(); // TIMED_WAITING
        new Thread(new WaitingState(), "WaitingStateThread").start(); // WAITING
        //BlockedThread-01线程会抢到锁，BlockedThread-02线程会阻塞
        new Thread(new BlockedThread(), "BlockedThread-01").start(); // TIMED_WAITING
        new Thread(new BlockedThread(), "BlockedThread-02").start(); // BLOCKED
    }
}
