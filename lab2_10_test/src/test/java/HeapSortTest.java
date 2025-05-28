import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import dz.Task2;
import java.util.Arrays;
import java.util.Random;


public class HeapSortTest {

    static Task2 task2;

    @Test
    public void testSort(){
        Random r = new Random();
        int[] arr = new int[1000];

        for (int i = 0; i < arr.length; ++i){
            arr[i] = r.nextInt(1000);
        }

        int[] expected = arr.clone();
        Arrays.sort(expected);

        Assertions.assertArrayEquals(expected, task2.sort(arr));
    }
}
