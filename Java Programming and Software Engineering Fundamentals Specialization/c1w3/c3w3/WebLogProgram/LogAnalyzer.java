
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         for (String line: fr.lines()) {
             LogEntry le = WebLogParser.parseEntry(line);
             records.add(le);
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le: records) {
            String ipAddress = le.getIpAddress();
            if (!uniqueIPs.contains(ipAddress)) {
                uniqueIPs.add(ipAddress);
            }
        }
        return uniqueIPs.size();
    }
    
    public void printAllHigherThanNum(int num)  {
        for (LogEntry le : records) {
            if (le.getStatusCode() > num) {
                System.out.println(le);
            }
        }
    }
    
    public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueIPVisitsOnDay = new ArrayList<String>();
        for (LogEntry le: records) {
            String date = le.getAccessTime().toString();
            String ipAddress = le.getIpAddress();
            if (date.contains(someday) && !uniqueIPVisitsOnDay.contains(ipAddress)) {
                uniqueIPVisitsOnDay.add(ipAddress);
            }
        }
        return uniqueIPVisitsOnDay;
    }
    
    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> uniqueIPsInRange = new ArrayList<String>();
        for (LogEntry le : records) {
            int status = le.getStatusCode();
            String ipAddress = le.getIpAddress();
            if (status >= low && status <= high && !uniqueIPsInRange.contains(ipAddress)) {
                uniqueIPsInRange.add(ipAddress);
            }
        }
        return uniqueIPsInRange.size();
    }
    
    public HashMap<String, Integer> countVisitsPerIP() {
        HashMap<String, Integer> countVisitsPerIP = new HashMap<String, Integer>();
        for (LogEntry le : records) {
            String ip = le.getIpAddress();
            if (!countVisitsPerIP.containsKey(ip)) {
                countVisitsPerIP.put(ip, 1);
            } else {
                countVisitsPerIP.put(ip, countVisitsPerIP.get(ip) + 1);
            }
        }
        return countVisitsPerIP;
    }
    
    public int mostNumberVisitsByIP(HashMap<String, Integer> countVisitsPerIP) {
        int maxNumVistByIP = 0;
        for (int num: countVisitsPerIP.values()) {
            if (num > maxNumVistByIP) {
                maxNumVistByIP = num;
            }
        }
        return maxNumVistByIP;
    }
    
    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> countVisitsPerIP) {
        int maxNumVistByIP = mostNumberVisitsByIP(countVisitsPerIP);
        ArrayList<String> iPsMostVisits = new ArrayList<String>();
        for (String ip: countVisitsPerIP.keySet()) {
            if (countVisitsPerIP.get(ip).equals(maxNumVistByIP)) {
                iPsMostVisits.add(ip);
            }
        }
        return iPsMostVisits;
    }
    
    public HashMap<String, ArrayList<String>> iPsForDays() {
        HashMap<String, ArrayList<String>> iPsForDays = new HashMap<String, ArrayList<String>>();
        for (LogEntry le : records) {
            String date = le.getAccessTime().toString().substring(4,10);
            String ipAddress = le.getIpAddress();
            if (!iPsForDays.containsKey(date)) {
                ArrayList<String> iPsMostVisits = new ArrayList<String>();
                iPsMostVisits.add(ipAddress);
                iPsForDays.put(date, iPsMostVisits);
            }
            else {
                iPsForDays.get(date).add(ipAddress);
                iPsForDays.put(date, iPsForDays.get(date));
            }
        }
        return iPsForDays;
    }
    
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> iPsForDays) {
        String dayWithMostIPVisits = "";
        int maxNum = 0;
        for (String date: iPsForDays.keySet()) {
            int numIPs = iPsForDays.get(date).size();
            if (numIPs > maxNum) {
                maxNum = numIPs;
                dayWithMostIPVisits = date;
            }
        }
        return dayWithMostIPVisits;
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> iPsForDays, String date) {
        ArrayList<String> iPsForGivenDate= iPsForDays.get(date);
        HashMap<String, Integer> countVisitsPerIP = new HashMap<String, Integer>();
        for (String ip: iPsForGivenDate) {
            if (!countVisitsPerIP.containsKey(ip)) {
                countVisitsPerIP.put(ip, 1);
            } else {
                countVisitsPerIP.put(ip, countVisitsPerIP.get(ip) + 1);
            }
        }
        return iPsMostVisits(countVisitsPerIP);
    }
    
}
