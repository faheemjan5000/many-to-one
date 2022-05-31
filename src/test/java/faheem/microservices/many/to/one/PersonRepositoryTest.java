package faheem.microservices.many.to.one;

import faheem.microservices.many.to.one.entity.Mobile;
import faheem.microservices.many.to.one.entity.Person;
import faheem.microservices.many.to.one.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void getPersonByPersonId(){
        int personId = 2;
        Person person = personRepository.findById(personId).get();
        log.info("person : {}",person.getName());
        for(Mobile mobile : person.getMobiles()){
            System.out.println("mobileName : "+mobile.getMobileName());
        }
    }

}
