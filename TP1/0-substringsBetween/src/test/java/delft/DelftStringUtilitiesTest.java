package delft;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;


class DelftStringUtilitiesTest {
    @Test
    void nullStr(){
        // Arrange
        final String str = null;
        final String open = "";
        final String close = "";
        // Act
        String[] substrings = delft.DelftStringUtilities.substringsBetween(str, open, close);
        // Assert
        assertEquals(null, substrings);
    }
}
