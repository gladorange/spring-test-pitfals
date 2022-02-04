package test.integration.recepies.transactional.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// никогда так не делайте
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HistoricalEntity {

    @Id
    @EqualsAndHashCode.Include
    String id;

    @Column
    String value;

    public HistoricalEntity(String id, String value) {
        this.id = id;
        this.value = value;
    }

    @ElementCollection
    Set<String> relatedEntities = new HashSet<>();

}
