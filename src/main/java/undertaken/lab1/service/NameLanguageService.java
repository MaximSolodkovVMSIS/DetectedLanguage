package undertaken.lab1.service;

import org.springframework.stereotype.Service;
import undertaken.lab1.entity.LanguageEntity;
import undertaken.lab1.repository.LanguageRepository;


@Service
public class NameLanguageService {
    private final LanguageRepository languageRepository;

    public NameLanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public LanguageEntity findByName(String name) {
        return languageRepository.findByName(name);
    }

    public LanguageEntity save(String name) {
        LanguageEntity language = new LanguageEntity();
        language.setName(name);
        return languageRepository.save(language);
    }
}
