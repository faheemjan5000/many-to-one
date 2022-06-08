package faheem.microservices.many.to.one.repository;

import faheem.microservices.many.to.one.entity.Cycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CycleRepository extends JpaRepository<Cycle,Integer> {
}
