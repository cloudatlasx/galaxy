package onem.learn.pattern.service_locator;

/**
 * 解析工厂
 */
public interface ParserFactory {
    Parser getParser(ContentType contentType);
}
