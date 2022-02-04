package test.integration.recepies.slow.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// никогда так не делайте
@ToString
public class AnotherSimpleEntity {

    @Id
    String id;


}
