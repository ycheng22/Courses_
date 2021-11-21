
/**
 * Write a description of ParsingWeatherData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class ParsingWeatherData {

    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord coldestSoFar = null;
        for (CSVRecord currentRow: parser) {
            coldestSoFar = getSmallestOfTwo(currentRow, coldestSoFar);
        }
        return coldestSoFar;
    }
    
    public CSVRecord getSmallestOfTwo(CSVRecord currentRow, CSVRecord coldestSoFar) {
        if (coldestSoFar == null) {
            coldestSoFar = currentRow;
        } else {
            double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            if (currentTemp < coldestTemp && currentTemp != -9999) {
                coldestSoFar = currentRow;
            }
        }
        return coldestSoFar;
    }
    
    public String fileWithColdestTemperature() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestSoFar = null;
        String coldestDay = "";
        for (File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if (coldestSoFar == null) {
                coldestSoFar = currentRow;
                coldestDay = f.toString();
            } else {
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                if (currentTemp < coldestTemp && currentTemp != -9999) {
                    coldestSoFar = currentRow;
                    coldestDay = f.toString();
                }
            } 
        }
        return coldestDay;
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestHumidityRecord = null;
        for (CSVRecord currentRecord: parser) {
            if (!currentRecord.get("Humidity").equals("N/A")) {
                if (lowestHumidityRecord == null) {
                    lowestHumidityRecord = currentRecord;
                } else {
                    double lowest = Double.parseDouble(lowestHumidityRecord.get("Humidity"));
                    double current = Double.parseDouble(currentRecord.get("Humidity"));
                    if (lowest > current) {
                        lowestHumidityRecord = currentRecord;
                    }
                }
            }
        }
        return lowestHumidityRecord;
    }
    
    public CSVRecord lowestHumidityInManyFiles() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestHumidityRecord  = null;
        for (File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRecord = lowestHumidityInFile(fr.getCSVParser());
            if (!currentRecord.get("Humidity").equals("N/A")) {
                if (lowestHumidityRecord == null) {
                    lowestHumidityRecord = currentRecord;
                } else {
                    double lowest = Double.parseDouble(lowestHumidityRecord.get("Humidity"));
                    double current = Double.parseDouble(currentRecord.get("Humidity"));
                    if (lowest > current) {
                        lowestHumidityRecord = currentRecord;
                    }
                }
            }
        }
    return lowestHumidityRecord;
    }
    
    public double averageTemperatureInFile(CSVParser parser) {
        double totalTemp = 0.0;
        int count = 0;
        for (CSVRecord currentRecord: parser) {
            double currentTemp = Double.parseDouble(currentRecord.get("TemperatureF"));
            if (currentTemp != -9999) {
                totalTemp += currentTemp;
                count++;
            }
        }
        return totalTemp / count;
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double totalTemp = 0.0;
        int count = 0;
        for (CSVRecord currentRecord: parser) {
            if (!currentRecord.get("Humidity").equals("N/A")) {
                double currentTemp = Double.parseDouble(currentRecord.get("TemperatureF"));
                double currentHumidity = Double.parseDouble(currentRecord.get("Humidity"));
                if (currentTemp != -9999 && currentHumidity >= value) {
                    totalTemp += currentTemp;
                    count++;
                }
            }
        }
        if (totalTemp == 0) {
            return -9999.0;
        }
        return totalTemp / count;
    }
    
    
    public void testColdestHourInFile() {
        // weather-2015-01-01.csv
        FileResource fr = new FileResource();
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + coldest.get("TemperatureF") +
                            " at " + coldest.get("DateUTC"));

    }
    
    public void testFileWithColdestTemperature() {
        String coldestDay = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + coldestDay);
        FileResource fr = new FileResource(coldestDay);
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature on that day was " + coldest.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        for (CSVRecord current : fr.getCSVParser()) {
            System.out.println( current.get("DateUTC") + ": " + current.get("TemperatureF"));
        }
    }
    
    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumidityRecord = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + lowestHumidityRecord.get("Humidity") +
                            " at " + lowestHumidityRecord.get("DateUTC"));
    }
    
    public void testLowestHumidityInManyFiles () {
        CSVRecord lowestHumidityDay = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowestHumidityDay.get("Humidity") +
                            " at " + lowestHumidityDay.get("DateUTC"));
    }
    
    public void testAverageTemperatureInFile () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemperature = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is " + averageTemperature);
    }
    
    public void testAverageTemperatureWithHighHumidityInFile () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        int valueOfHumidity = 80;
        double averageTemperature = averageTemperatureWithHighHumidityInFile(parser, valueOfHumidity);
        if (averageTemperature == -9999.0) {
            System.out.println("No temperatures with that humidity");
        }
        else {
            System.out.println("Average Temp when high Humidity is " + averageTemperature);
        }
    }
}
