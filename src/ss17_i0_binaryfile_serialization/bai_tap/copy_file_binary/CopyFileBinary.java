package ss17_i0_binaryfile_serialization.bai_tap.copy_file_binary;

import java.io.*;

public class CopyFileBinary {
    public static void main(String[] args) {
        try {
            File source = new File("src/ss17_i0_binaryfile_serialization/bai_tap/copy_file_binary/source.csv");
            File target = new File("src/ss17_i0_binaryfile_serialization/bai_tap/copy_file_binary/taget.csv");
            if (!source.exists()) {
                throw new FileNotFoundException();
            } else {
                int count = 0;
                FileInputStream inputStream = new FileInputStream(source);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                FileOutputStream outputStream = new FileOutputStream(target);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = bufferedInputStream.read(buffer)) > 0) {
                    bufferedOutputStream.write(buffer, 0, length);
                    count++;
                }
                bufferedInputStream.close();
                bufferedOutputStream.close();
                System.out.println("Number of bytes used: " + count + " byte.");
            }
        } catch (IOException e) {
            System.err.printf("Source is not found");
        }
    }
}
