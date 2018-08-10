A convenience class for launching a Spring Boot app with retry and
backoff if it fails. While the main app is failing the backoff brings
up a web endpoint on `/actuator/info` and `/actuator/health`. The
`health` endpoint will show as "DOWN" until the main application
context comes up successfully.

Usage:

```java
@SpringBootApplication
@RestController
public class StarterApplication {

	public static void main(String[] args) {
		BackoffSpringApplication.run(StarterApplication.class, args);
	}
    
}
```

(Just use `BackoffSpringApplication` to run the main method.)
