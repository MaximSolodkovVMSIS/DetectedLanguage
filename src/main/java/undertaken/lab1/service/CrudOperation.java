package undertaken.lab1.service;

import jakarta.transaction.Transactional;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import undertaken.lab1.dto.LanguageDetectionRequest;
import undertaken.lab1.entity.LanguageEntity;
import undertaken.lab1.entity.TextEntity;
import undertaken.lab1.repository.LanguageRepository;
import undertaken.lab1.repository.TextRepository;

@Service
public class CrudOperation {
    private final TextLanguageService textLanguageService;
    private final LanguageDetectiveService languageDetectiveService;
    private final NameLanguageService nameLanguageService;
    private final ServiceApiKey serviceApiKey;

    private final TextRepository textRepository;

    private final LanguageRepository languageRepository;

    public CrudOperation(TextLanguageService textLanguageService,
                         LanguageDetectiveService languageDetectiveService,
                         NameLanguageService nameLanguageService,
                         ServiceApiKey serviceApiKey,
                         TextRepository textRepository,
                         LanguageRepository languageRepository) {
        this.textLanguageService = textLanguageService;
        this.nameLanguageService = nameLanguageService;
        this.languageDetectiveService = languageDetectiveService;
        this.serviceApiKey = serviceApiKey;
        this.textRepository = textRepository;
        this.languageRepository = languageRepository;
    }

    public String addTextAndDetectLanguage(String text) {
        String apiKey = serviceApiKey.getApiKey();
        String detectedLanguage = languageDetectiveService.detectLanguage(new LanguageDetectionRequest(text), apiKey);
        LanguageEntity language = nameLanguageService.findByName(detectedLanguage);
    if (language == null) {
        language = nameLanguageService.save(detectedLanguage);
    }
        TextEntity textLanguage = new TextEntity();
        textLanguage.setText(text);
        textLanguage.setLanguage(language);
        textLanguageService.save(textLanguage);

        return "Text and language saved successfully";
    }

    public String deleteText(String text) {
        TextEntity textLanguage = textRepository.findByText(text);
        textRepository.delete(textLanguage);
        return "Text deleted successfully";
    }

    @Transactional
//из-за lazy подгрузки сеанс Hibernate(обычный сеанс который управляет чтением и записью) закрыт, избегаем ошибки LazyInitializationException
    public String deleteLanguageAndText(String languageName) {
        LanguageEntity language = languageRepository.findByName(languageName);
        if (language != null) {
            Hibernate.initialize(language.getTextLanguages()); //метод должен выполняться в рамках транзакции, заставляя Hibernate извлечь данные из базы данных до того, как сеанс будет закрыт
            List<TextEntity> texts = language.getTextLanguages();
            textRepository.deleteAll(texts);
            languageRepository.delete(language);
            return "Language and associated texts deleted successfully";
        }
        else {
            return "Language not found";
        }
    }

    public String updateText(Long id, String newText) {
        TextEntity text = textRepository.findById(id).orElse(null);

        if (text != null) {
            text.setText(newText);
            textRepository.save(text);
            return "Text updated successfully";
        }
        else {
            return "Text not found";
        }
    }
}