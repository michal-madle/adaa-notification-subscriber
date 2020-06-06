package cz.kb.openbanking.adaa.notification_subscriber.server;

import cz.kb.openbanking.adaa.notification_subscriber.PackageNameHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Application's entry point.
 *
 * @author <a href="mailto:michal_madle@kb.cz">Michal Madle</a>
 * @since 1.0
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = PackageNameHolder.class,
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
    useDefaultFilters = false)
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    /**
     * Entry-point of the application.
     *
     * @param args application arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
