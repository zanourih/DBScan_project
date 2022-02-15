import java.util.ArrayList;

public class TaxiClusters {

    public static void main(String[] args) throws Exception {
        TaxiCSVReader reader = new TaxiCSVReader();
        ArrayList<TripRecord> triplist = reader.readData("C:\\Users\\zanou\\Downloads\\yellow_tripdata_2009-01-15_1hour_clean.csv");
        TripRecord metrics = new TripRecord();
        DBSCANClusterer<TripRecord> dbscan = new DBSCANClusterer<TripRecord>(triplist, 10, 1f, metrics);
        ArrayList<ArrayList<TripRecord>> clustersList = dbscan.performClustering();
        Clusters clusters = dbscan.converttoClusters(clustersList);
        clusters.printClusters("clusters.csv");

        System.out.println("done");
    }
}
