package com.trafficfines.trafficfinesdemo.trafficfinescontroller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trafficfines.trafficfinesdemo.trafficfinesexception.TrafficfinesException;
import com.trafficfines.trafficfinesdemo.trafficfinesmodel.TrafficfinesModel;
import com.trafficfines.trafficfinesdemo.trafficfinesrepository.TrafficfinesRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class TrafficfinesController {

	@Autowired
	private TrafficfinesRepository akRepository;

	// get all sales
	@GetMapping("/fines")
	public List<TrafficfinesModel> getAllTrafficfinesModel() {
		return akRepository.findAll();
	}
	
	// create sales rest api
	@PostMapping("/fines")
	public TrafficfinesModel createTrafficfinesModel(@RequestBody TrafficfinesModel fines) {
		return akRepository.save(fines);
	}
	// get employee by id rest api
		@GetMapping("/fines/{id}")
		public ResponseEntity<TrafficfinesModel> getTrafficfinesModelById(@PathVariable Long id) {
			TrafficfinesModel fines = akRepository.findById(id)
					.orElseThrow(() -> new TrafficfinesException("order not exist with id :" + id));
			return ResponseEntity.ok(fines);
		}
		@GetMapping("/finesor")
		public ResponseEntity<List<TrafficfinesModel>> getTrafficfinesModelByOnameOrVnum(@RequestParam String o, @RequestParam String v) {
			List<TrafficfinesModel> fines = akRepository.findByOnameOrVnum(o,v);
			return ResponseEntity.ok(fines);
		}
		
		
	// update sales rest api

	@PutMapping("/fines/{id}")
	public ResponseEntity<TrafficfinesModel> updateTrafficfinesModel(@PathVariable Long id, @RequestBody TrafficfinesModel fines) {
		TrafficfinesModel fines1 = akRepository.findById(id)
				.orElseThrow(() -> new TrafficfinesException("id does not exist with  :" + id));
		TrafficfinesModel updatedTrafficfinesModel = akRepository.save(fines);
		return ResponseEntity.ok(updatedTrafficfinesModel);
	}
	
	// delete sales rest api
	@DeleteMapping("/fines/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTrafficfinesModel(@PathVariable Long id) {
		TrafficfinesModel fines = akRepository.findById(id)
				.orElseThrow(() -> new TrafficfinesException("id does not exist with  :" + id));

		akRepository.delete(fines);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
