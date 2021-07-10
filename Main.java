import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "input.txt";
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        RequestParser parser = new RequestParser();
        while ((line = br.readLine()) != null) {
            try {
                parser.parseRequest(line);
            } catch (RequestNotFoundException | ParkingException e) {
                e.printStackTrace();
            }
        }
    }
}