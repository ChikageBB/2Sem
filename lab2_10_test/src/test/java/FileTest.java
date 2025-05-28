
import dz.Task1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class FileTest {

    @Test
    public void testMergeFiles() throws IOException {
        File file1 = new File("D:\\itis\\javaProject\\2Sem\\lab2_10_test\\src\\main\\java\\dz\\file1.bin");
        File file2 = new File("D:\\itis\\javaProject\\2Sem\\lab2_10_test\\src\\main\\java\\dz\\file2.txt");
        File res = new File("D:\\itis\\javaProject\\2Sem\\lab2_10_test\\src\\main\\java\\dz\\res.txt");

        Task1.mergeFiles(file1, file2, res);

        byte[] resBytes = Files.readAllBytes(res.toPath());
        byte[] file1Bytes = Files.readAllBytes(file1.toPath());
        byte[] file2Bytes = Files.readAllBytes(file2.toPath());

        Assertions.assertEquals(file1Bytes.length + file2Bytes.length, resBytes.length);
        Assertions.assertArrayEquals(file1Bytes, Arrays.copyOfRange(resBytes, 0, file1Bytes.length));
        Assertions.assertArrayEquals(file2Bytes, Arrays.copyOfRange(resBytes, file1Bytes.length, resBytes.length));
    }
}
