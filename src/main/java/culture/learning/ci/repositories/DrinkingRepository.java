package culture.learning.ci.repositories;

import culture.learning.ci.entities.Drinking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkingRepository extends JpaRepository<Drinking, Long> {
}
