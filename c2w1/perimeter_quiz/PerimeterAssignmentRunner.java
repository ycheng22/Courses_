import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int cnt = 0;
        for (Point currPt : s.getPoints()) {
            cnt = cnt + 1;
        }
        return cnt;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double aveLen = length / numPoints;
        return aveLen;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double LargestSide = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            if (currDist > LargestSide) {
                LargestSide = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        
        
        return LargestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double LargestX = 0.0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            double x = currPt.getX();
            if (x > LargestX) {
                LargestX = x;
            }
        }
        
        return LargestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPeriMulFiles = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (length > largestPeriMulFiles) {
                largestPeriMulFiles = length;
            }
        }
        
        return largestPeriMulFiles;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        
        double largestPeriMulFiles = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (length > largestPeriMulFiles) {
                largestPeriMulFiles = length;
                temp = f;
            }
        }

        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPoints = getNumPoints(s);
        System.out.println("number of points = " + numPoints);
        double aveLength = getAverageLength(s);
        System.out.println("average length = " + aveLength);
        double LargestSide = getLargestSide(s);
        System.out.println("Largest Side = " + LargestSide);
        double LargestX = getLargestX(s);
        System.out.println("Largest X = " + LargestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestPeriMulFiles = getLargestPerimeterMultipleFiles();
        System.out.println("largestPeriMulFiles = " + largestPeriMulFiles);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String fileName = getFileWithLargestPerimeter();
        System.out.println("FileWithLargestPerimeter = " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
