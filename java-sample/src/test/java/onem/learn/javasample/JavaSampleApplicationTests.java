package onem.learn.javasample;

import onem.learn.javasample.multiple.AbsClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
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

}
