package com.trafficfines.trafficfinesdemo.trafficfinesrepository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trafficfines.trafficfinesdemo.trafficfinesmodel.TrafficfinesModel;

@Repository
public interface TrafficfinesRepository extends JpaRepository<TrafficfinesModel, Long> {

	



	

	List<TrafficfinesModel> findByOnameOrVnum(String o, String v);

	

}