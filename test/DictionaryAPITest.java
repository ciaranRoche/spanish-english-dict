import controllers.DictionaryAPI;
import models.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by ciaran on 16/02/2017.
 */
public class DictionaryAPITest {
    DictionaryAPI dicAPI;
    Word word;
    Fixtures fixtures;

    @Before
    public void setup(){
        dicAPI = new DictionaryAPI();
    }

    @After
    public void tearDown(){
        dicAPI = null;
    }

    @Test
    public void testWords(){

    }
}
