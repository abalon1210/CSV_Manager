import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) {
        String base = System.getProperty("user.dir") + "\\";
        System.out.println(System.getProperty("user.dir"));
        List<String[]> list = new ArrayList<>();

        String file_path = base + "HyperparameterAnalysis_temp.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))){

            String line = "";
            while((line = reader.readLine()) != null){
                line = line.substring(1, line.length()-2);
                String[] array = line.split(",");
                list.add(array);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        file_path = base + "HyperparameterAnalysis_temp_new.csv";
        try (FileWriter writer = new FileWriter(file_path)){
            for (String[] strings : list) {
                for (int i = 0; i < strings.length; i++) {
                    System.out.println(strings[i]);
                    writer.append(strings[i]);
                    if(i < (strings.length-1))
                        writer.append(",");
                }
                writer.append(System.lineSeparator());
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
