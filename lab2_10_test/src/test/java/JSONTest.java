import dz.Task3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

public class JSONTest {

    static Task3 task3;

    @Test ()
    public void testJSON() throws Exception{
        Assertions.assertEquals(0, task3.correctJSON("D:\\itis\\javaProject\\2Sem\\lab2_10_test\\src\\main\\java\\dz\\file.json") );
    }
}
