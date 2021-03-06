package clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class GetClient {

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();
		UriComponentsBuilder uribuilder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/spring-rest-1/")
				.path("emp");
		ResponseEntity<String> resp = rt.getForEntity(uribuilder.toUriString(), String.class);
		System.out.println(resp.getBody());
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Accept","application/json");
		
		HttpEntity et=new HttpEntity<>(headers);
		ResponseEntity<String> resp1=
				rt.exchange("http://localhost:8080/spring-rest-1/emp",
						HttpMethod.GET, et, String.class);

		System.out.println(resp1.getBody());
	}

}
