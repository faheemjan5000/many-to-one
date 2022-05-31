package faheem.microservices.many.to.one.repository;

import faheem.microservices.many.to.one.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepository extends JpaRepository<Mobile,Integer> {
}
