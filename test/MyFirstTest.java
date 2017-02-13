import models.Word;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by ciaran on 13/02/2017.
 */
public class MyFirstTest {
    Word test1 = new Word("testspan", "testeng");

    @Test
    public void testCreate(){
        assertEquals("testspan", test1.spanishWord);
    }

}

