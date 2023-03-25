import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileBasic {
    public static void main(String[] args) {
        File file;
        file = createAFile("testbuffer.txt");
        // fileWriterTest(file);
        // fileReadTest(file);
        // fileReadTest2(file);
        // deletedFiles(file);
        // readAll(file);
        // readAllLine(file);
        // bufferFileWriter(file);
        // bufferFileReader(file);
        // bufferFileReader3(file);
        // copyFile(file);
    }

    public static File createAFile(String fileNameAndPath) {
        File create = new File(fileNameAndPath);
        try {
            if (create.createNewFile()) {
                System.out.println("created file success\n");
            }
            else {
                System.out.println("file's exist");
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return create;
    }

    public static void fileWriterTest(File file) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Header1\n");
            writer.write("Header2\nBODY\nEND");
            System.out.println("writed");
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("file invalid");
        }
    }
    
    //using FileReader
    public static void fileReadTest(File file) {
        try (FileReader reader = new FileReader(file)) {
            int data;
            while ((data = reader.read()) != -1 ) {
                System.out.printf("%c", data);
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // using Scanner
    public static void fileReadTest2(File file) {
        String dataS;
        try (Scanner reader = new Scanner(file)) { //try with resource is auto close 
            while (reader.hasNextLine()) {
                dataS = reader.nextLine();
                System.out.print(dataS + "\n");
            }
            // reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    
    public static void deletedFiles(File file) {
        if (file.delete()) { 
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        } 
    }

    // real all in text
    public static void readAll(File file) {
        try {
            byte[] readAllBytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
            String string = new String(readAllBytes);
            System.out.println(string);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // read all line 
    public static void readAllLine(File file) {
        try {
            List<String> readAllLineS = Files.readAllLines(Paths.get(file.getAbsolutePath()));
            for (String lstring : readAllLineS) {
                System.out.println(lstring);
            }

            // String StringPerLine = lines.get(0);
            // System.out.println(StringPerLine);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //using buffer for write file
    public static void bufferFileWriter(File file) {
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(file)); // ChainStream
            String ls = System.getProperty("line.separator");

            for (int i = 0; i < 2000; i++) {
                bWriter.write("asume this is a large file text "+ i + ls);
            }
            
            bWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //using buffer for read 
    public static void bufferFileReader(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int data;
            while ((data = reader.read()) != -1 ) {
                System.out.printf("%c", data);
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void bufferFileReader2(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // read per line
            // String lines = reader.readLine();
            // System.out.println(lines);
            // lines = reader.readLine();
            // System.out.println(lines);

            //read all line in text
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void bufferFileReader3(File file) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void copyFile(File file) {
        try {
            BufferedReader readForCopy = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
            BufferedWriter writeAcopy = Files.newBufferedWriter(Paths.get("A copy of " + file.getName()));
            String copy;
            String ls = System.getProperty("line.separator");
            while((copy = readForCopy.readLine()) != null){
                writeAcopy.write(copy + ls);
            }
            readForCopy.close();
            writeAcopy.close();
            System.out.println("copy success!");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
