package test.integration.recepies.transactional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.integration.recepies.transactional.entity.HistoricalEntity;

import java.util.List;

@Repository
public interface HistoricalRepository extends JpaRepository<HistoricalEntity,String > {


}
