package faheem.microservices.many.to.one;

import faheem.microservices.many.to.one.entity.Cycle;
import faheem.microservices.many.to.one.repository.CycleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CycleRepositoryTest {

    @Autowired
    private CycleRepository cycleRepository;

    @Test
    public void addCycle(){
        Cycle cycle = Cycle.builder()
                .cycleName("sports")
                .cycleColor("blue")
                .build();
        cycleRepository.save(cycle);
    }
}
