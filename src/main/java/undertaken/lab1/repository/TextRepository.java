package undertaken.lab1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import undertaken.lab1.entity.Text;

public interface TextRepository extends JpaRepository<Text, Long> {
    @Query("SELECT tl FROM Text tl WHERE tl.language.name = :languageName")
    List<Text> findAllByTextLanguageName(@Param("languageName") String languageName);

    Text findByText(String text);
}


