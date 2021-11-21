
/**
 * Write a description of BabyBirths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class BabyBirths {
    public void totalBirths (FileResource fr) {
	int totalBirths = 0;
	int totalBoys = 0;
	int totalGirls = 0;
	int totalNames = 0;
	int totalBoysNames = 0;
	int totalGirlsName = 0;
	for (CSVRecord rec : fr.getCSVParser(false)) {
    	    int numBorn = Integer.parseInt(rec.get(2));
    	    totalBirths += numBorn;
    	    totalNames++;
    	    if (rec.get(1).equals("M")) {
    	        totalBoys += numBorn;
    	        totalBoysNames++;
    	    } else {
    	        totalGirls += numBorn;
    	        totalGirlsName++;
    	    }
	}
	System.out.println("total births = " + totalBirths);
	System.out.println("total boys = " + totalBoys);
	System.out.println("ottal girls = " + totalGirls);
	System.out.println("total names = " + totalNames);
	System.out.println("total boys names = " + totalBoysNames);
	System.out.println("ottal girls names = " + totalGirlsName);
    }
    
    public int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob" 
                                            + year + ".csv");
        int rank = 0;
        for (CSVRecord record: fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                rank++;
                if (record.get(0).equals(name)) {
                    return rank;
                }
            }
        }
        return -1;
    }
    
    public String getName(int year, int rank, String gender) {
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob" 
                                            + year + ".csv");
        int rankInGender = 0;
        for (CSVRecord record: fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                rankInGender++;
                if (rankInGender == rank) {
                    return record.get(0);
                }
            }
        }
        return "NO NAME";                                    
    }
    
    public String whatIsNameInYear(String name, int year, int newYear, String gender) {
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        return newName;
    }
    
    public int yearOfHighestRank(String name, String gender) {
        int highestRank = 0;
        int yearOfHighestRank = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            String filename = f.getName();
            //String year = filename.substring(3,7);
            int year = Integer.parseInt(filename.substring(3,7));
            int currentRank = getRank(year, name, gender);
            if ((highestRank > currentRank || highestRank == 0) && (currentRank != -1)) {
                highestRank = currentRank;
                yearOfHighestRank = year;
            }
        }
        
        if (highestRank == 0) {
            return -1;
        }
        return yearOfHighestRank;
    }
    
    public double getAverageRank(String name, String gender) {
        double totalFiles = 0;
        int totalRank = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            String filename = f.getName();
            int year = Integer.parseInt(filename.substring(3,7));
            int currentRank = getRank(year, name, gender);
            totalFiles++;
            if (currentRank != -1) {
                totalRank += currentRank;
            }
        }
        if (totalRank == 0) {
            return -1.0;
        }
        return totalRank / totalFiles;
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob" + year + ".csv");
        //FileResource fr = new FileResource();
        int totalBirthRankHigher = 0;
        int baseRank = getRank(year, name, gender);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)) {
                String currentName = rec.get(0);
                int currentRank = getRank(year, currentName, gender);
                if (currentRank < baseRank) {
                    int numBorn = Integer.parseInt(rec.get(2));
                    System.out.println("Name " + currentName + " has higher rank with numBorn " + numBorn);
                    totalBirthRankHigher += numBorn;
                } else {
                    break;
                }
            }
        }
        if (totalBirthRankHigher == 0) {
            return -1;
        }
        return totalBirthRankHigher;
    }
    

    public void testTotalBirths () {
    	FileResource fr = new FileResource();
    	//FileResource fr = new FileResource("data/yob2014.csv");
    	totalBirths(fr);
    }
    
    public void testGetRank () {
        int year = 1971;
        String name = "Frank";
        String gender = "M";
        int rank = getRank(year, name, gender);
        System.out.println("Search with " + name + ", gender is " + gender
                            + " in " + year);
        System.out.println("rank = " + rank);
    }
    
    public void testGetName () {
        int year = 1982;
        int rank = 450;
        String gender = "M";
        String name = getName(year, rank, gender);
        System.out.println("Search at " + rank + " rank, gender is " + gender
                            + " in " + year);
        System.out.println("name = " + name); //Mason
    }
    
    public void testWhatIsNameInYear () {
        String name = "Susan";
        int year = 1972;
        int newYear = 2014;
        String gender = "F";
        String newName = whatIsNameInYear(name ,year, newYear, gender);
        System.out.println(name + " born in " + year + " would be " + newName
                            + " if she was born in " + newYear);
    }
    
    public void testYearOfHighestRank () {
        String name = "Mich";
        String gender = "M";
        int yearOfHighestRank = yearOfHighestRank(name, gender);
        System.out.println("name is " + name);
        System.out.println("gender is " + gender);
        System.out.println("year of highest ranking is " + yearOfHighestRank);
        
        // the case there is no name
        //name = "noName";
        //gender = "F";
        //yearOfHighestRank = yearOfHighestRank(name, gender);
        //System.out.println("name is " + name);
        //System.out.println("gender is " + gender);
        //System.out.println("year of highest ranking is " + yearOfHighestRank);
    }
    
    public void testGetAverageRank () {
        String name = "Susan";
        String gender = "F";
        double averageRank = getAverageRank(name, gender);
        System.out.println("name is " + name);
        System.out.println("gender is " + gender);
        System.out.println("average ranking is " + averageRank);
        
        name = "Robert";
        gender = "M";
        averageRank = getAverageRank(name, gender);
        System.out.println("name is " + name);
        System.out.println("gender is " + gender);
        System.out.println("average ranking is " + averageRank);
    }
    
    public void testGetTotalBirthsRankedHigher () {
        int year = 1990;
        String name = "Drew";
        String gender = "M";
        int totalBirthsRankedHigher = getTotalBirthsRankedHigher(year, name, gender);
        System.out.println("year is " + year);
        System.out.println("name is " + name);
        System.out.println("gender is " + gender);
        System.out.println("total births ranked higher = " + totalBirthsRankedHigher);
    }
}
