package undertaken.lab1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import undertaken.lab1.entity.LanguageEntity;
import undertaken.lab1.service.UsefulTextLanguage;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/languages")
public class LanguageController {
    private final UsefulTextLanguage usefulTextLanguage;

    public LanguageController(UsefulTextLanguage usefulTextLanguage) {
        this.usefulTextLanguage = usefulTextLanguage;
    }

    @GetMapping("/all")
    public List<LanguageEntity> getAllLanguages() {
        return usefulTextLanguage.getAllLanguage();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LanguageEntity>> getNameLanguageById(@PathVariable Long id) {
        Optional<LanguageEntity> nameLanguage = usefulTextLanguage.getLanguageById(id);
        if (nameLanguage.isPresent()) {
            return ResponseEntity.ok().body(nameLanguage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
