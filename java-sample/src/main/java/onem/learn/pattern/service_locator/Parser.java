package onem.learn.pattern.service_locator;

import java.io.Reader;
import java.util.List;

/**
 * 解析接口
 */
public interface Parser {
    List parse(Reader r);
}
