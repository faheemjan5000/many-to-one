package faheem.microservices.many.to.one;

import faheem.microservices.many.to.one.entity.Cycle;
import faheem.microservices.many.to.one.entity.Mobile;
import faheem.microservices.many.to.one.entity.Person;
import faheem.microservices.many.to.one.repository.CycleRepository;
import faheem.microservices.many.to.one.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void getPersonWithMobileByPersonId(){
        int personId = 8;
        Person person = personRepository.findById(personId).get();
        log.info("person : {}",person.getName());
        if(person.getMobiles().size()!=0) {
            for (Mobile mobile : person.getMobiles()) {
               log.info("mobileName : {}",mobile.getMobileName());
            }
        }
        else{
            log.info("There is no mobile for this user");
        }
    }

    @Test
    public void addPerson(){
        Person person = new Person("lorenza","lorenzao@gmail.com");
        personRepository.save(person);
    }

    @Test
    public void addNewPersonWithListOfMobiles(){
        Person person = new Person("zain","zain@gmail.com");
        Mobile nokia = new Mobile("nokia","classic");
        Mobile oppo = new Mobile("oppo","oppo-processor");
         List<Mobile> mobiles = new ArrayList<>();
         mobiles.add(nokia);
         mobiles.add(oppo);
         person.setMobiles(mobiles);
        personRepository.save(person);
    }

    @Test
    public void addPersonWithCycle(){
        Cycle cycle = Cycle.builder()
                .cycleName("professional")
                .cycleColor("white")
                .build();
        List<Cycle> cycles = new ArrayList<>();
        cycles.add(cycle);
        Person person = Person.builder()
                       .name("xyz")
                       .email("xyz@gmail.com")
                       .cycles(cycles)
                       .build();
        personRepository.save(person);


    }


}
