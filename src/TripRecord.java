public class TripRecord implements DistanceMetric<TripRecord> {

    String pickup_DateTime;
    GPScoord pickup_Location, dropoff_Location;
    float trip_Distance;

    @Override
    public double calculateDistance(TripRecord val1, TripRecord val2) throws DBSCANClusteringException {
        return val1.calcDistance(val2);
    }

    public double calcDistance(TripRecord p2){
        return pickup_Location.calcDistance(p2.pickup_Location);
    }

    public String getpickupDateTime(){
        return pickup_DateTime;
    }

    public GPScoord getpickupLocation(){
        return pickup_Location;
    }

    public GPScoord getdropoffLocation(){
        return dropoff_Location;
    }

    public float gettripDistance(){
        return trip_Distance;
    }

    public void setpickupDateTime(String newpickupDate){
        pickup_DateTime = newpickupDate;
    }

    public void setpickupLocation(GPScoord newpickuplocation){
        pickup_Location = newpickuplocation;
    }

    public void setdropoffLocation(GPScoord newdropofflocation){
        dropoff_Location = newdropofflocation;
    }

    public void settripDistance(float newtripdistance){
        trip_Distance = newtripdistance;
    }

  
}
