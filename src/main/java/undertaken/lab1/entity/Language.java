package undertaken.lab1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Text> textLanguages;

    public Language() {
        //zxc
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Text> getTextLanguages() {
        return textLanguages;
    }

    public void setTextLanguages(List<Text> textLanguages) {
        this.textLanguages = textLanguages;
    }
}
