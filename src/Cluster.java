import java.util.ArrayList;

public class Cluster extends ArrayList<TripRecord> {

    public String[] printCluster(){
        String[] ret = new String[3];
        GPScoord a = calculateAverage();
        String[] pntPrint = a.print();
        ret[0] = pntPrint[0];
        ret[1] = pntPrint[1];
        ret[2] = Integer.toString(this.size());
        return ret;
    }


    private GPScoord calculateAverage(){
        double averageLat = 0f;
        double averageLon = 0f;
        for(TripRecord t : this){
            averageLat += t.pickup_Location.getLat();
            averageLon += t.pickup_Location.getLon();
        }
        GPScoord averageCoord = new GPScoord();
        averageCoord.setLat(averageLat/this.size());
        averageCoord.setLon(averageLon/this.size());

        return averageCoord;
    }
}

