package diospringsecurity;

import java.util.function.UnaryOperator;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping
	public String welcome() {
		return "Welcome to My Spring Boot Web API";
	}
	
	@GetMapping("/users")
	@PreAuthorize("hasAnyRole('MANAGERS', 'USERS')")
	public String users() {
		UnaryOperator<Integer> calcular = valor -> valor * 3;
		
		return "Authorized user";
	}
	
	@GetMapping("/managers")
	@PreAuthorize("hasRole('MANAGERS')")
	public String managers() {
		return "Authorized Managers";
	}	
}
