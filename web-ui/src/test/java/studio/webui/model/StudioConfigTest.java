package studio.webui.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class StudioConfigTest {

    @ConfigProperty(name = "studio.host")
    String host;
    @ConfigProperty(name = "studio.port")
    String port;

    @ConfigProperty(name = "studio.library")
    Path libraryPath;
    @ConfigProperty(name = "studio.tmpdir")
    Path tmpdirPath;

    @ConfigProperty(name = "studio.db.official")
    Path officialDbPath;
    @ConfigProperty(name = "studio.db.unofficial")
    Path unofficialDbPath;

    @ConfigProperty(name = "version")
    String version;
    @ConfigProperty(name = "timestamp")
    String timestamp;

    @ConfigProperty(name = "studio.mock.device")
    Path devicePath;

    @ConfigProperty(name = "studio.open.browser", defaultValue = "false")
    boolean openBrowser;

    @Test
    void testConfig() {
        Path target = Path.of("./target/studio");
        assertAll("StudioConfig", //
                () -> assertEquals("localhost", host, "Different host"), //
                () -> assertEquals("8080", port, "Different port"), //
                () -> assertEquals(target.resolve("library"), libraryPath, "Different libraryPath"), //
                () -> assertEquals(target.resolve("tmp"), tmpdirPath, "Different tmpdirPath"), //
                () -> assertEquals(target.resolve("device"), devicePath, "Different devicePath"), //
                () -> assertEquals(target.resolve("db/official.json"), officialDbPath, "Different officialDbPath"), //
                () -> assertEquals(target.resolve("db/unofficial.json"), unofficialDbPath, "Different unofficialDbPath") //
        );
    }

}