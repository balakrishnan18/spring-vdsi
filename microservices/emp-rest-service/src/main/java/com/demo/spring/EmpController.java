package com.demo.spring;

import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.model.Emp;

@RestController
public class EmpController {
	static HashMap<Integer, Emp> empDb = new HashMap<>();
	static {
		empDb.put(100, new Emp(100, "Kabir", "Hyderabad", 34000));
		empDb.put(101, new Emp(101, "James", "Bangalore", 56000));
		empDb.put(102, new Emp(102, "Scott", "Hyderabad", 54000));
		empDb.put(103, new Emp(103, "Kirti", "Pune", 34000));
		empDb.put(104, new Emp(104, "Ketan", "Hyderabad", 45000));
	}

	@RequestMapping(path = "/find", method = RequestMethod.GET, produces = "application/json")
	// http://host:port/find?empid=101
	public ResponseEntity getEmpById(@RequestParam("empid") int id) {

		if (empDb.containsKey(id)) {
			return ResponseEntity.ok(empDb.get(id));
		} else {
			return ResponseEntity.ok("Employee Not Found");
		}
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveEmp(@RequestBody Emp e) {
		if (empDb.containsKey(e.getEmpId())) {
			return "Emp exists";
		} else {
			empDb.put(e.getEmpId(), e);
			return "Emp Saved";
		}
	}

	@RequestMapping(path = "/info", method = RequestMethod.GET)
	public String getInfo() {
		return "This is a demo REST Service in Spring";
	}
}
