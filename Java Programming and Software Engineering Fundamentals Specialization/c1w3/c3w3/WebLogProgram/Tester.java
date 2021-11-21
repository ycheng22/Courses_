
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }
    
    public void testUniqueIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println("Num of unique IP address: " + la.countUniqueIPs());
    }
    
    public void testPrintAllHigherThanNum() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        la.printAllHigherThanNum(400);
    }
    
    public void testuniqueIPVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        String date = "Sep 27";
        ArrayList<String> list = la.uniqueIPVisitsOnDay(date);
        System.out.println("Num of uniqueIPVisitsOnDay : " + list.size());
    }
    
    public void testCountUniqueIPsInRange () {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        int low = 400;
        int high = 499;
        System.out.println("CountUniqueIPsInRange in [" + low + ", " + high + "] is " 
                                + la.countUniqueIPsInRange(low, high));
    }
        
    public void testCountVisitsPerIP () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        // read from the file short-test_log
        la.readFile("short-test_log");
        System.out.println(la.countVisitsPerIP());
    }
    
    public void testMostNumberVisitsByIP () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String, Integer> countVisitsPerIP = la.countVisitsPerIP();
        System.out.println("mostNumberVisitsByIP: "
                        + la.mostNumberVisitsByIP(countVisitsPerIP));
    }
    
    
    public void testIPsMostVisits () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String, Integer> countVisitsPerIP = la.countVisitsPerIP();
        System.out.println(la.iPsMostVisits(countVisitsPerIP));
    }
    
    public void testIPsForDays () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        // read from the file short-test_log
        la.readFile("weblog3-short_log");
        System.out.println(la.iPsForDays());
    }
    
    public void testDayWithMostIPVisits () {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> iPsForDays = la.iPsForDays();
        System.out.println(la.dayWithMostIPVisits(iPsForDays));
    }
    
    public void testIPsWithMostVisitsOnDay () {
        // create a LogAnalyzer
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> iPsForDays = la.iPsForDays();
        System.out.println(la.iPsWithMostVisitsOnDay(iPsForDays, "Sep 29"));
    }
}
