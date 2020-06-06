package cz.kb.openbanking.adaa.notification_subscriber.rest.controller;

import cz.kb.openbanking.adaa.notification_subscriber.rest.api.v1.generated.DiagnosticsApi;
import cz.kb.openbanking.adaa.notification_subscriber.rest.model.v1.generated.VersionResponseGen;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Controller for DiagnosticsApi.
 *
 * @author <a href="mailto:michal_madle@kb.cz">Michal Madle</a>
 * @since 1.0
 */
@RestController
public class DiagnosticsApiController implements DiagnosticsApi {

    private final VersionResponseGen versionResponseGen;

    private static final Pattern VERSION_PATTERN = Pattern.compile("^\\d+\\.\\d+");

    /**
     * Constructor.
     * Reads version from pom.xml and returns major and minor version (i.e. 1.0).
     * If no version found in pom.xml, 'UNK' is returned.
     *
     * <p>Creates {@link VersionResponseGen} instance for faster response in {@link #getApiVersion}.
     */
    public DiagnosticsApiController() {
        Model model;
        try {
            model = new MavenXpp3Reader().read(new FileReader("pom.xml"));
        } catch (final Exception e) {
            model = null;
        }

        final Matcher matcher = model.getVersion() == null ? null : VERSION_PATTERN.matcher(model.getVersion());

        this.versionResponseGen = new VersionResponseGen();
        this.versionResponseGen.setVersion(
            matcher != null && matcher.find() ? matcher.group(0) : "UNK"); // abbreviated to fulfill response pattern 3-5 characters
    }

    @Override
    @Valid
    public ResponseEntity<VersionResponseGen> getApiVersion(final String xCorrelationId) {
        return new ResponseEntity<>(versionResponseGen, HttpStatus.OK);
    }
}
