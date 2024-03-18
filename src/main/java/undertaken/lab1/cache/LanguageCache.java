package undertaken.lab1.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LanguageCache {
    private final Map<String, String> cache = new ConcurrentHashMap<>();

    private final Logger logger = LoggerFactory.getLogger(LanguageCache.class);

    public String get(String text) {
        return cache.get(text);
    }

    public void put(String text, String language) {
        cache.put(text, language);
    }

    public void printCache() {
        logger.info("Cache content: ");
        for (Map.Entry<String, String> entry : cache.entrySet()) {
            logger.info("Text: {}, Language {} ", entry.getKey(), entry.getValue());
        }
    }
}
