import java.lang.Math;

public class GPScoord {
    double lat, lon;

    public double getLat(){
        return lat;
    }

    public double getLon(){
        return lon;
    }

    public void setLat(double newLat){
        lat = newLat;
    }

    public void setLon(double newLon){
        lon = newLon;
    }
    
    public String[] print(){
        String[] ret = new String[2];
        ret[0] = Double.toString(lat);
        ret[1] = Double.toString(lon);
        return ret;
    }


    // source : https://cloud.google.com/blog/products/maps-platform/how-calculate-distances-map-maps-javascript-api
    public double calcDistance(GPScoord p2){
        double R = 3958.8f; // Radius of the Earth in miles
        double rlat1 = lat * (Math.PI/180f); // Convert degrees to radians
        double rlat2 = p2.lat * (Math.PI/180f); // Convert degrees to radians
        double difflat = rlat2-rlat1; // Radian difference (latitudes)
        double difflon = (p2.lon-lon) * (Math.PI/180); // Radian difference (longitudes)

        double d = 2 * R * Math.asin(Math.sqrt(Math.sin(difflat/2)*Math.sin(difflat/2)+Math.cos(rlat1)*Math.cos(rlat2)*Math.sin(difflon/2)*Math.sin(difflon/2)));
        return d;
    }
}

    