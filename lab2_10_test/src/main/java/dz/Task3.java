package dz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Stack;

public class Task3 {


    public static int correctJSON(String file) throws Exception {
        if (file == null || file.isBlank()) {
            throw new NullPointerException();
        }

        Path path = Paths.get(file);

        if (!Files.exists(path)) {
            throw new FileNotFoundException();
        }

        if (!isTextFile(Path.of(file))){
            throw new Exception("Не текстовый файл");
        }

        String str = Files.readString(path);
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()){
            if (ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if (ch == '}'){
                    if (stack.empty() || stack.pop() != '{'){
                        return -1;
                    }
                }

                if (ch == ']'){
                    if (stack.empty() || stack.pop() != '['){
                        return -1;
                    }
                }
            }
        }
        if (!stack.isEmpty()){
            return -1;
        }
        return 0;
    }

    public static boolean isTextFile(Path path) throws IOException{

        byte[] arr = Files.readAllBytes(path);

        int length = Math.min(arr.length, 1024);

        for (int i = 0; i < length; ++i){

            byte b = arr[i];

            if (b >= 0x20 && b <= 0x7E) continue;
            if (b == 0x09 || b == 0x0A || b == 0x0D) continue;


            if (b < 0x20 || b > 0x7E){
                return false;
            }
        }
        return true;

    }

}