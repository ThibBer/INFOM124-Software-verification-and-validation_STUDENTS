package delft;

import static org.assertj.core.api.Assertions.assertThat;
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
        final String open = "open";
        final String close = "close";
        // Act
        String[] substrings = DelftStringUtilities.substringsBetween(str, open, close);
        // Assert
        assertThat(substrings).isNull();
    }

    @Test
    void emptyStr(){
        // Arrange
        final String str = "";
        final String open = "open";
        final String close = "close";
        // Act
        String[] substrings = DelftStringUtilities.substringsBetween(str, open, close);
        // Assert
        assertThat(substrings).isEmpty();
    }

    @Test
    void nullOpen(){
        // Arrange
        final String str = "str";
        final String open = null;
        final String close = "close";
        // Act
        String[] substrings = DelftStringUtilities.substringsBetween(str, open, close);
        // Assert
        assertThat(substrings).isNull();
    }

    @Test
    void emptyOpen(){
        // Arrange
        final String str = "str";
        final String open = "";
        final String close = "close";
        // Act
        String[] substrings = DelftStringUtilities.substringsBetween(str, open, close);
        // Assert
        assertThat(substrings).isNull();
    }

    @Test
    void nullClose(){
        // Arrange
        final String str = "str";
        final String open = "open";
        final String close = null;
        // Act
        String[] substrings = DelftStringUtilities.substringsBetween(str, open, close);
        // Assert
        assertThat(substrings).isNull();
    }

    @Test
    void emptyClose(){
        // Arrange
        final String str = "str";
        final String open = "open";
        final String close = "";
        // Act
        String[] substrings = DelftStringUtilities.substringsBetween(str, open, close);
        // Assert
        assertThat(substrings).isNull();
    }

    @Test
    void singleCharInStrMatchOpen(){
        // Arrange
        final String str = "Aloj";
        final String open = "o";
        final String close = "c";
        // Act
        String[] substrings = DelftStringUtilities.substringsBetween(str, open, close);
        // Assert
        assertThat(substrings).isNull();
    }

    @Test
    void singleCharInStrMatchClose(){
        // Arrange
        final String str = "Alcj";
        final String open = "o";
        final String close = "c";
        // Act
        String[] substrings = DelftStringUtilities.substringsBetween(str, open, close);
        // Assert
        assertThat(substrings).isNull();
    }

    @Test
    void strContainsOpenAndNotClose(){
        // Arrange
        final String str = "TestABTest";
        final String open = "A";
        final String close = "R";
        // Act
        String[] substrings = DelftStringUtilities.substringsBetween(str, open, close);
        // Assert
        assertThat(substrings).isNull();
    }

    @Test
    void strContainsCloseAndNotOpen(){
        // Arrange
        final String str = "TestABTest";
        final String open = "R";
        final String close = "B";
        // Act
        String[] substrings = DelftStringUtilities.substringsBetween(str, open, close);
        // Assert
        assertThat(substrings).isNull();
    }

    @Test
    void strContainsOpenAndClose(){
        // Arrange
        final String str = "TestA123BTest";
        final String open = "A";
        final String close = "B";
        // Act
        String[] substrings = DelftStringUtilities.substringsBetween(str, open, close);
        // Assert
        assertThat(substrings);
    }
}
