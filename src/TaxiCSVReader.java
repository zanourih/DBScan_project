import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
// source : https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/

public class TaxiCSVReader {
    public ArrayList<TripRecord> readData(String file)
{
    ArrayList<TripRecord> list = new ArrayList<TripRecord>();

     try {

        // Create an object of filereader
        // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);
 
        // create csvReader object passing
        // file reader as a parameter
        CSVReader csvReader = new CSVReader(filereader);
        String[] nextRecord;
        boolean firstline = true;

        // we are going to read data line by line
        while ((nextRecord = csvReader.readNext()) != null) {
            if (firstline){
                firstline = false;
                continue;
            }
            int column = 0;
            double lon=0;
            TripRecord trip = new TripRecord();
            list.add(trip);
            for (String cell : nextRecord) {
                if(column == 4){
                    trip.setpickupDateTime(cell);
                }
                if(column == 7){
                    trip.settripDistance(Float.parseFloat(cell));
                }
                if(column == 8){
                    lon = Double.parseDouble(cell);
                }
                if(column == 9){
                    GPScoord pickupGPS = new GPScoord();
                    pickupGPS.setLat(Double.parseDouble(cell));
                    pickupGPS.setLon(lon);
                    trip.setpickupLocation(pickupGPS);
                }

                if(column == 12){
                    lon = Double.parseDouble(cell);
                }
                if(column == 13){
                    GPScoord dropoffGPS = new GPScoord();
                    dropoffGPS.setLat(Double.parseDouble(cell));
                    dropoffGPS.setLon(lon);
                    trip.setdropoffLocation(dropoffGPS);
                }
                column++;

            }
        }
        
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
}
