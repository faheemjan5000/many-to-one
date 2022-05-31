package faheem.microservices.many.to.one.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
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

    @OneToMany(
            mappedBy = "person" //Bidirectional relation
    )
    private List<Mobile> mobiles;  //here i guess its not needed.

}
