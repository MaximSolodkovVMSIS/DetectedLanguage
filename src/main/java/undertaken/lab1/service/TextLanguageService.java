package undertaken.lab1.service;

import org.springframework.stereotype.Service;
import undertaken.lab1.entity.TextEntity;
import undertaken.lab1.repository.TextRepository;

@Service
public class TextLanguageService {
    private final TextRepository textRepository;

    public TextLanguageService(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    public void save(TextEntity textLanguage) {
        textRepository.save(textLanguage);
    }
}