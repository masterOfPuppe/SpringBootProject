package bookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/* It's important specify the EntityScan because in default mode all
    models are searched in main package, but, like in this case, if
    you use put them in an other package, you should indicate in this
    way using @EntityScan("package") */
@SpringBootApplication
@EntityScan("bookStore.models")
public class BookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

}
