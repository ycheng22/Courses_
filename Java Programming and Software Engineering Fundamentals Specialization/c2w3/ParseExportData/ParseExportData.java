
/**
 * Write a description of ParseExportData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class ParseExportData {
    
    
    
    public void listExporters(CSVParser parser, String exportOfInterest) {
        //for each row in the CSV File
	for (CSVRecord record : parser) {
            //Look at the "Exports" column
            String export = record.get("Exports");
            //Check if it contains exportOfInterest
            if (export.contains(exportOfInterest)) {
                //If so, write down the "Country" from that row
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    public String countryInfo(CSVParser parser, String country) {
        for (CSVRecord record: parser) {
            String CountryName = record.get("Country");
            if (CountryName.equals(country)) {
                return CountryName + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
            }
        }
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record: parser) {
            String CountryName = record.get("Country");
            String exports = record.get("Exports");
            if ((exports.contains(exportItem1)) && (exports.contains(exportItem2))) {
                System.out.println(CountryName);
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        
        for (CSVRecord record: parser) {
            String CountryName = record.get("Country");
            String exports = record.get("Exports");
            if (exports.contains(exportItem)) {
                count++;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record: parser) {
            String CountryName = record.get("Country");
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()) {
                System.out.println(CountryName + " " + value);
            }
        }
    }
    
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        //countryInfo
        String country = "Nauru";
        System.out.println("Look info for " + country);
        System.out.println("country info: " + countryInfo(parser, country));
        System.out.println("-------------------------------------------------------");
        
        //listExportersTwoProducts
        // reset the parser
        //parser = fr.getCSVParser();
        String exportItem1 = "cotton";
        String exportItem2 = "flowers";
        System.out.println("Exports items are " + exportItem1 +" and " + exportItem2);
        listExportersTwoProducts(parser, exportItem1, exportItem2);
        System.out.println("-------------------------------------------------------");
        
        //numberOfExporters
        parser = fr.getCSVParser();
        String exportItem = "cocoa";
        System.out.println("The number of exporters of " + exportItem + " is "
                            + numberOfExporters(parser, exportItem));
        System.out.println("-------------------------------------------------------");                    
                            
        // test bigExporters
        // reset the parser
        parser = fr.getCSVParser();
        String amount = "$999,999,999,999";
        System.out.println("amout is " + amount);
        bigExporters(parser, amount);     
        System.out.println("-------------------------------------------------------");
    }
	
    public void whoExportsCoffee() {
    	FileResource fr = new FileResource();
    	CSVParser parser = fr.getCSVParser();
    	listExporters(parser, "coffee");
    }
    
}
