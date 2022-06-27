import java.io.*;
import java.nio.channels.FileLockInterruptionException;

public class CopyFile {
    public static void main(String[] args) {
        readFile("src/input", "src/output");
    }

    public static void readFile(String filePath, String fileOut) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            File file2 = new File(fileOut);
            BufferedReader inStream = new BufferedReader(new FileReader(file));
            BufferedWriter outStream = new BufferedWriter(new FileWriter(file2));
            String line;
            while ((line = inStream.readLine()) != null) {
                outStream.write(line);
            }
            inStream.close();
            outStream.close();

        } catch (Exception e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
    }
}
