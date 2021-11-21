
/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagnitudeFilter implements Filter{
    private double minimumMagnitude;
    private double maximumMagnitude;

    public MagnitudeFilter(double minMag, double maxMag) {
        minimumMagnitude = minMag;
        maximumMagnitude = maxMag;
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        return minimumMagnitude <= qe.getMagnitude()
                && qe.getMagnitude() <= maximumMagnitude; 
    } 
    
    public String getName() {
        return "Magnitude";
    }
}
