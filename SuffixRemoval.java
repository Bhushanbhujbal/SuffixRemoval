import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SuffixRemoval {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            File outputFile = new File("output.txt");

            List<String> suffixesToRemove = new ArrayList<>();
            suffixesToRemove.add("ly");
            suffixesToRemove.add("tion");
            suffixesToRemove.add("ed");
            suffixesToRemove.add("ing");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    for (String suffix : suffixesToRemove) {
                        if (word.endsWith(suffix)) {
                            word = word.substring(0, word.length() - suffix.length());
                        }
                    }
                    writer.write(word + " ");
                }
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("Suffixes removed successfully. Modified content saved to output.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
