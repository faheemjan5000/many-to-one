package faheem.microservices.many.to.one.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personId;
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name=name;
        this.email=email;
    }

    //person has many cycles
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "person_id",
            referencedColumnName = "personId"
    )
    private List<Cycle> cycles;

    private void addCycle(Cycle cycle){
        if(cycles==null)
            cycles = new ArrayList<>();
        cycles.add(cycle);
    }

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "person" //Bidirectional relation

    )
    private List<Mobile> mobiles;  //here i guess its not needed.
/*
    public void addMobile(Mobile mobile){
        if(mobiles==null){
            mobiles = new ArrayList<>();
        }
        mobiles.add(mobile);
    }
 */
}
