package test.integration.recepies.testinaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.integration.recepies.testinaction.entity.SimpleEntity;

import java.util.List;

@Repository
public interface SimpleEntityRepository extends JpaRepository<SimpleEntity,String > {



    @Query(value = "select * from simple_entity e WHERE to_tsvector(e.id) @@ to_tsquery(:word);",
            nativeQuery = true)
    List<SimpleEntity> search(String word);

    @Query("DELETE FROM SimpleEntity")
    @Modifying
    void clear();
}
