package onem.learn.sample;

import lombok.extern.slf4j.Slf4j;
import onem.learn.sample.multiple.AbsClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class JavaSampleApplicationTests {

    @Autowired
    private List<AbsClass> absList;

    @Test
    void contextLoads() {
        System.out.println("test");
    }

    @Test
    void absTest() {
        System.out.println(absList.get(1).slot.order);
        absList = absList.stream().sorted(
                Comparator.comparing((AbsClass e) -> e.slot.forced).reversed()
                        .thenComparing((AbsClass e) -> e.slot.order)
        ).collect(Collectors.toList());
        absList.forEach(e -> e.apply());
    }

    @Test
    public void exceptionTest() {
        try {
            new Thread(() -> {absList.get(0).getException();} ).start();
        } catch (Exception e) {
            log.error("Exception", e);
        }
        absList.get(0).getException();
    }

}
