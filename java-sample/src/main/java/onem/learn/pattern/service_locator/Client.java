package onem.learn.pattern.service_locator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author liuming
 * @Date 2023/6/30
 * @Version V1.0
 */
@Service
public class Client {
    private ParserFactory parserFactory;
    @Autowired
    public Client(ParserFactory parserFactory) {
        this.parserFactory = parserFactory;
    }
    public List getAll(ContentType contentType) {
        // 关键点，直接根据类型获取
        return parserFactory
                .getParser(contentType)
                .parse(null);
    }
}