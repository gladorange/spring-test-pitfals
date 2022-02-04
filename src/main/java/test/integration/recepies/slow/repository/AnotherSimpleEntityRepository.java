package test.integration.recepies.slow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.integration.recepies.slow.entity.AnotherSimpleEntity;

import java.util.List;

@Repository
public interface AnotherSimpleEntityRepository extends JpaRepository<AnotherSimpleEntity,String > {



    @Query(value = "select * from another_simple_entity e WHERE to_tsvector(e.id) @@ to_tsquery(:word);",
            nativeQuery = true)
    List<AnotherSimpleEntity> search(String word);

    @Query("DELETE FROM AnotherSimpleEntity")
    @Modifying
    void clear();
}
