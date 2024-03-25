package undertaken.lab1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import undertaken.lab1.entity.Text;
import undertaken.lab1.service.UsefulTextLanguage;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/texts")
public class ControllerText {
    private final UsefulTextLanguage usefulTextLanguage;

    public ControllerText(UsefulTextLanguage usefulTextLanguage) {
        this.usefulTextLanguage = usefulTextLanguage;
    }

    @GetMapping()
    public List<Text> getTextByLanguage(@RequestParam("language") String languageName) {
        return usefulTextLanguage.getAllTextByLanguage(languageName);
    }

    @GetMapping("/all")
    public List<Text> getAllTexts() {
        return usefulTextLanguage.getAllTexts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Text>> getTextById(@PathVariable Long id) {
        Optional<Text> textLanguage = usefulTextLanguage.getTextById(id);
        if (textLanguage.isPresent()) {
            return ResponseEntity.ok().body(textLanguage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
