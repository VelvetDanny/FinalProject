import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void saveList(ArrayList<String> list, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String item : list) {
                writer.write(item + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static ArrayList<String> loadList(String filename) {
        ArrayList<String> list = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) {
            return list; // return empty list if file not found
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return list;
    }
}
