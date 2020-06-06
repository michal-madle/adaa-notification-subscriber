package cz.kb.openbanking.adaa.notification_subscriber.rest.controller;

import cz.kb.openbanking.adaa.notification_subscriber.rest.api.v1.generated.EventsApi;
import cz.kb.openbanking.adaa.notification_subscriber.rest.model.v1.generated.EventPayloadGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Controller for EventsApi.
 *
 * @author <a href="mailto:michal_madle@kb.cz">Michal Madle</a>
 * @since 1.0
 */
@RestController
public class EventsApiController implements EventsApi {

    private static final Logger log = LoggerFactory.getLogger(EventsApiController.class);

    @Override
    @Valid
    public ResponseEntity<Void> receiveEvent(final String xCorrelationId, final String subscriptionId, final Optional<String> acceptLanguage,
                                             final EventPayloadGen eventPayloadGen)
    {
        log.info("subscriptionId: {}, xCorrelationId = {}, acceptLanguage = {}, eventPayloadGen.eventCount = {}",
            subscriptionId, xCorrelationId, acceptLanguage.orElse(null), eventPayloadGen == null ? null : eventPayloadGen.getEventCount());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
