package faheem.microservices.many.to.one.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cycle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cycleId;
    private String cycleName;
    private String cycleColor;
}
