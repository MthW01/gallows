import java.io.*;

public class Drawer {
    public static void DrawCondition(int condition) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(String.format("src/source/condition%s.txt", condition)));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);
        } finally {
            br.close();
        }
    }
}
