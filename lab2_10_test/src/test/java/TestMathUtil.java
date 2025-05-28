import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.itis.inf403.test.MathUtil;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class TestMathUtil {

    static MathUtil mathUtil;

    @BeforeAll
    static void init(){
        mathUtil = new MathUtil();
    }


    @Test
    public void testSum(){
        int expectedValue =  10;
        int actual = MathUtil.sum(5, 5);

        assertEquals(expectedValue, actual);
        assertEquals(-2, MathUtil.sum(-1, -1));
        assertEquals(0, MathUtil.sum(-5, 5));
        assertEquals(-1, MathUtil.sum(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

//    @Test
//    public void testDivide(){
//        assertThrows(IllegalAccessError.class,
//                () -> {
//            MathUtil.divide(7, 0);
//        });
//    }


    @Test
    public void testSort(){

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8},
                          mathUtil.sort(new int[]{1, 2, 3, 5, 4, 6, 7, 8}));
    }

    @AfterAll
    static void destroy(){
        String s = new String();

    }
}

