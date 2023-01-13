package himedia.joinme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JoinmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoinmeApplication.class, args);
	}

}
