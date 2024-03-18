package undertaken.lab1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import undertaken.lab1.entity.TextEntity;
import undertaken.lab1.service.UsefulTextLanguage;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/texts")
public class TextController {
    private final UsefulTextLanguage usefulTextLanguage;

    public TextController(UsefulTextLanguage usefulTextLanguage) {
        this.usefulTextLanguage = usefulTextLanguage;
    }

    @GetMapping()
    public List<TextEntity> getTextByLanguage(@RequestParam("language") String languageName) {
        return usefulTextLanguage.getAllTextByLanguage(languageName);
    }

    @GetMapping("/all")
    public List<TextEntity> getAllTexts() {
        return usefulTextLanguage.getAllTexts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TextEntity>> getTextById(@PathVariable Long id) {
        Optional<TextEntity> textLanguage = usefulTextLanguage.getTextById(id);
        if (textLanguage.isPresent()) {
            return ResponseEntity.ok().body(textLanguage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
