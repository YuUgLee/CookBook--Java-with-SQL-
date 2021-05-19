package csulb.cecs323.model;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;
import javax.persistence.*;

/**
 * Duration Converter Class which converts it to minutes. Based on Piazza post @203 using the reference
 * https://thorben-janssen.com/jpa-tips-map-duration-attribute/
 * @Author: XanMikhailYakov.Balayan@student.csulb.edu
 */

@Converter(autoApply = true)
public class DurationConverter implements AttributeConverter<Duration, Long> {

    Logger log = Logger.getLogger(DurationConverter.class.getSimpleName());

    /**
     * Converts the duration attribute to ChronoUnit minutes.
     * @param attribute - duration attribute
     * @return minutes
     */
    @Override
    public Long convertToDatabaseColumn(Duration attribute) {
        log.info("Convert to Long");
        return attribute.toMinutes();
    }

    /**
     * Converts the ChronoUnit minutes to duration attribute.
     * @param duration - ChronoUnit attribute.
     * @return duration
     */
    @Override
    public Duration convertToEntityAttribute(Long duration) {
        log.info("Convert to Duration");
        return Duration.of(duration, ChronoUnit.MINUTES);
    }
}
