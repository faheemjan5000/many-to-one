package faheem.microservices.many.to.one;

import faheem.microservices.many.to.one.entity.Mobile;
import faheem.microservices.many.to.one.entity.Person;
import faheem.microservices.many.to.one.repository.MobileRepository;

import faheem.microservices.many.to.one.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MobileRepositoryTest {

    @Autowired
    private MobileRepository mobileRepository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void addMobileWithPerson(){
        Person person = new Person("faheem","faheemjan@gmail.com");
        Mobile samsung = new Mobile("samsung","snapdragon");
        samsung.setPerson(person);
        mobileRepository.save(samsung);
    }

    @Test
   public void addMobileForSpecificPerson(){
        int personId =2;
        int mobileId = 4;
        mobileRepository.addMobileForSpecificPerson(personId,mobileId);
   }


}
