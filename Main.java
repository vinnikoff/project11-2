import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("do", "fa");
        map.put("re", "mi");

        replacer(map);
    }

    private static File replacer(Map <String, String> map) {
        Set<String> keys = map.keySet();
        File file1 = new File("text2.txt");
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt")); BufferedWriter bw = new BufferedWriter(new FileWriter("test2.txt"))) {

            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s+"\n");
            }
                String new_str=sb.toString();
            System.out.println(new_str);
               for (String key : keys) {

                   new_str = new_str.replaceAll (key, map.get(key));

                }
            bw.write(new_str);
            bw.flush();

        }
        catch (IOException e) {
            System.out.println("read failed");
        }
        return file1;
    }

}