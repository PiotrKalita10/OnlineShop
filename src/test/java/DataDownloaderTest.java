
import org.example.DataDownloader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataDownloaderTest {
    @Test
    void shouldThrowRuntimeExceptionWhenPathInGetDateIsWrong() {
        assertThrows(RuntimeException.class, () -> DataDownloader.getData("WRONG"));
    }

}