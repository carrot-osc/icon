package org.optaplanner.examples.icon.parser;

import java.io.File;
import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.optaplanner.examples.icon.domain.Forecast;

public class ForecastParserTest extends AbstractParserTest {

    public ForecastParserTest(final File fileUnderTest) {
        super(new File(fileUnderTest, "forecast.txt"));
    }

    @Test
    public void testParsing() {
        try {
            final Forecast f = ForecastParser.parse(this.getFileUnderTest());
            Assertions.assertThat(f).isNotNull();
        } catch (final IOException e) {
            Assertions.fail("Failed parsing forecast file.", e);
        }
    }

}
