package onem.learn.pattern.service_locator;

import org.springframework.stereotype.Component;

import java.io.Reader;
import java.util.List;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/6/30
 * @Version V1.0
 */
@Component("CSV")

public class CSVParser implements Parser {
    @Override
    public List parse(Reader r) {
        return null;
    }
}
