public interface DistanceMetric<V> {

    public double calculateDistance(V val1, V val2) throws DBSCANClusteringException;

}