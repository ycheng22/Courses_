
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter {
    
    private Location location;
    private float maxDistance;
    
    public DistanceFilter(Location loc, float maxDist) {
        location = loc;
        maxDistance = maxDist;
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        return qe.getLocation().distanceTo(location) < maxDistance; 
    }
    
    public String getName() {
        return "Distance";
    }
}
