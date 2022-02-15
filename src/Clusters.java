import java.util.ArrayList;
import com.opencsv.CSVWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Clusters extends ArrayList<Cluster> {

    public void printClusters(String Filename) {


        Writer writer;
        try {
            writer = Files.newBufferedWriter(Paths.get(Filename));
            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            String[] headerRecord = { "Latitude", "Longitude", "Size" };
            csvWriter.writeNext(headerRecord);

            for (Cluster c : this) {
                String[] clu = c.printCluster();
                csvWriter.writeNext(clu);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
