package undertaken.lab1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import undertaken.lab1.entity.TextEntity;

public interface TextRepository extends JpaRepository<TextEntity, Long> {
    @Query("SELECT tl FROM TextEntity tl WHERE tl.language.name = :languageName")
    List<TextEntity> findAllByTextLanguageName(@Param("languageName") String languageName);

    TextEntity findByText(String text);
}


