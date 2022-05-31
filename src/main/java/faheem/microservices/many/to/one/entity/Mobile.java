package faheem.microservices.many.to.one.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mobileId;
    private String mobileName;
    private String processorName;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "person_id",
            referencedColumnName = "personId"
    )
    private Person person;

    public Mobile(String name, String processorName) {
        this.mobileName=name;
        this.processorName=processorName;
    }
}
