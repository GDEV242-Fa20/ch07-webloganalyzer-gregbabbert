/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author Greg Babbert
 * @version    2020.10.19
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    // Question 7.12
    private LogfileReader file;

    /**
     * Create an object to analyze hourly web accesses.
     * The String logFile should be in quotes and have .log at the end
     */
    public LogAnalyzer(String logFile)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader("demo.log");
        // Creates log file for question 7.12
        file = new LogfileReader(logFile); 
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    /**
     * Returns the number of accesses to a log file
     */
    public int numberOfAccesses()
    {
        int total = 0;
        for (int index = 0; index < hourCounts.length; ++index) {
              total = total + hourCounts[index];
        }
     return total;
    }
}
