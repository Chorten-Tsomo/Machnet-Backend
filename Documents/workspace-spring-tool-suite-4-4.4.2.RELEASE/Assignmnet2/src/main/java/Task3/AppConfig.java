package Task3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "Task3")
@PropertySource("classpath:application.properties")
public class AppConfig {
	
}
