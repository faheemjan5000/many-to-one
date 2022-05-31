package faheem.microservices.many.to.one.repository;

import faheem.microservices.many.to.one.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MobileRepository extends JpaRepository<Mobile,Integer> {

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE mobile SET person_id = ?1 WHERE mobile_id = ?2" ,
            nativeQuery = true
    )
    void addMobileForSpecificPerson(int personId, int mobileId);
}
