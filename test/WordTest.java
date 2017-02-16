import models.Word;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ciaran on 16/02/2017.
 */
public class WordTest {

    Word test1 = new Word("testspanish", "testenglish");

    @Test
    public void createWord(){
        assertEquals("testspanish", test1.spanishWord);
        assertEquals("testenglish", test1.englishWord);
    }

    @Test
    public void testToString(){
        assertEquals(test1.spanishWord+ " : " +test1.englishWord,test1.toString());
    }

    @Test
    public void testEquals(){
        Word test2 = new Word("notspanish", "notenglish");

        assertEquals(test1, test1);
        assertEquals(test2, test2);
        assertNotEquals(test1, test2);
    }
}
