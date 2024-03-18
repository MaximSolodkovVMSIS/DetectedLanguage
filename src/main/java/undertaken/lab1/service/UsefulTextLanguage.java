package undertaken.lab1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import undertaken.lab1.entity.LanguageEntity;
import undertaken.lab1.entity.TextEntity;
import undertaken.lab1.repository.LanguageRepository;
import undertaken.lab1.repository.TextRepository;

@Service
public class UsefulTextLanguage {
    private final TextRepository textRepository;
    private final LanguageRepository languageRepository;

    public List <TextEntity> getAllTexts() {
        return textRepository.findAll();
    }

    public List<LanguageEntity> getAllLanguage() {
        return languageRepository.findAll();
    }

    public UsefulTextLanguage(TextRepository textRepository, LanguageRepository languageRepository) {
        this.textRepository = textRepository;
        this.languageRepository = languageRepository;
    }

    public List<TextEntity> getAllTextByLanguage(String languageName) {
        return textRepository.findAllByTextLanguageName(languageName);
    }

    public Optional<TextEntity> getTextById(Long id) {
        return textRepository.findById(id);
    }

    public Optional<LanguageEntity> getLanguageById(Long id) {
        return languageRepository.findById(id);
    }
}
