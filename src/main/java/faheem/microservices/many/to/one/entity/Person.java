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
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "person"
    )
    private List<Mobile> mobiles;

    public void addMobile(Mobile mobile){
        if(mobiles==null){
            mobiles=new ArrayList<>();
        }
        mobiles.add(mobile);
    }
}
