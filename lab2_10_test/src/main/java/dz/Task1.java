package dz;



//1. Протестировать работоспособность программы соединяющей 2 файла (текстовый, бинарный)
//   - итог: файл, 1 часть которого совпадает с 1-м файлом, 2-я часть - со 2-м файлом
//   - тестируете итоговый размер = сумма размеров 2-х файлов
//   - заранее готовите 3 файла, считываете 1-й файл в массив, читаете часть 3-го файла и сравниваете два массива


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Task1 {

    public static void main(String[] args) throws IOException {
//        mergeFiles("D:\\itis\\javaProject\\2Sem\\lab2_10_test\\src\\main\\java\\dz\\file1.bin",
//                "D:\\itis\\javaProject\\2Sem\\lab2_10_test\\src\\main\\java\\dz\\file2.txt",
//                "D:\\itis\\javaProject\\2Sem\\lab2_10_test\\src\\main\\java\\dz\\res.txt");

        System.out.println(
                check2("D:\\itis\\javaProject\\2Sem\\lab2_10_test\\src\\main\\java\\dz\\file1.bin",
                "D:\\itis\\javaProject\\2Sem\\lab2_10_test\\src\\main\\java\\dz\\file2.txt",
                "D:\\itis\\javaProject\\2Sem\\lab2_10_test\\src\\main\\java\\dz\\res.txt")

        );

        System.out.println(
                check3("D:\\itis\\javaProject\\2Sem\\lab2_10_test\\src\\main\\java\\dz\\file1.bin",
                "D:\\itis\\javaProject\\2Sem\\lab2_10_test\\src\\main\\java\\dz\\file2.txt",
                "D:\\itis\\javaProject\\2Sem\\lab2_10_test\\src\\main\\java\\dz\\res.txt")

        );
    }

    public static void mergeFiles(File file1, File file2, File result){
        try (
                FileInputStream fis1 = new FileInputStream(file1);
                FileInputStream fis2 = new FileInputStream(file2);
                FileOutputStream fos = new FileOutputStream(result);
                ){

            fis1.transferTo(fos);
            fis2.transferTo(fos);

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static boolean check2(String file1, String file2, String result){
        File f1 = new File(file1);
        File f2 = new File(file2);
        File res = new File(result);


        return f1.length() + f2.length() == res.length();
    }


    public static boolean check3(String file1, String file2, String result) throws IOException {

        byte[] arrFile1 = Files.readAllBytes(Path.of(file1));
        byte[] arrFile2 = Files.readAllBytes(Path.of(file2));
        byte[] arrRes = Files.readAllBytes(Path.of(result));


        if (arrFile1.length + arrFile2.length != arrRes.length){
            return false;
        }

        for (int i = 0; i < arrFile1.length; ++i){
            if (arrRes[i] != arrFile1[i]){
                return false;
            }
        }


        for (int i = 0; i < arrFile2.length; ++i){
            if (arrFile2[i] != arrRes[i + arrFile1.length]){
                return false;
            }
        }

        return true;
    }

}


