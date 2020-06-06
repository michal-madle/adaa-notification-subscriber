package cz.kb.openbanking.adaa.notification_subscriber.rest.configuration;

import cz.kb.openbanking.adaa.notification_subscriber.rest.PackageNameHolder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for the REST module.
 *
 * @author <a href="mailto:michal_madle@kb.cz">Michal Madle</a>
 * @since 1.0
 */
@Configuration
@ComponentScan(basePackageClasses = PackageNameHolder.class)
public class RestConfig {
}
