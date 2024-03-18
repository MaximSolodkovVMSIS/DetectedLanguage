package undertaken.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import undertaken.lab1.entity.LanguageEntity;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> { //тип идентификатора(id)
    LanguageEntity findByName(String name);
}
