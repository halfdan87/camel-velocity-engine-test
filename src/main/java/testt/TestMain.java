package testt;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("testt")
public class TestMain {

	public static void main(String[] args) {
		SpringApplication.run(TestMain.class, args);
	}

}

