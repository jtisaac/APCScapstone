package USCFGraphsByJosephIsaac;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.Arrays;
import org.jsoup.Jsoup.*;

/**
 * This class reads data from the member's file and creates arrays based on this data.
 * 
 * @author (Joseph Isaac) 
 * @version (4/17/16)
 */
public class Parser
{
    private static String memberID; //the Id of the member
    private ArrayList<Integer> ratings; // the array of the member's ratings
    private ArrayList<String> memberStr; // the memberdata split into individual words
    private String memberdata; // the webpage fo that member's data 

    private ArrayList<Integer> year; // the year of tournament
    private ArrayList<Integer> month; // the month of tournament
    private ArrayList<Integer> day; // the day of tournament
    /**
     * Constructor for objects of class CapstoneFileReader
     * @param the memberdata string, the webpage for that member
     */
    public Parser(String memberdata)
    {
        // initialise instance variables
        ratings = new ArrayList<Integer>();
        year = new ArrayList<Integer>();
        month = new ArrayList<Integer>();
        day = new ArrayList<Integer>();
        memberStr = new ArrayList<String>();
        
        String[] temp = memberdata.split(" "); //temporary
        for (int x= 0; x < temp.length; x++)
        {
            memberStr.add(temp[x]); // split returns an array, not an arraylist
        }
        
        memberdata = memberdata;
    }
    /**
     * parses the webpage for the rating, day, month year, of each tournament. This is where the bulk of the program functions. Sadly, the US chess site did not have an api to run off of, so I had to create my own.
     */
    public void parse() throws FileNotFoundException, IOException
    {
        int[] tempNum = new int[3]; // where the year, month, and day will initially be held as integers (temp)
        String[] tempString = new String[3]; // where the year, month, and day will initially be held (temp)
        ArrayList<String> cal = new ArrayList<String>(); // the list of dates preserved so that the dates don't repeat
        boolean same = false; //if the dates are the same
        int count = 0; //the # of dates
        boolean yes = false; // a boolean variable where yes = true allows it to become a date
        
        for (int x = memberStr.size() - 1; x >= 0; x--) //going from the bottom of the file so that the earliest dates are read first
        {
            for (String s : cal) // makes sure that no dates repeat
            { 
                if (memberStr.get(x).compareTo(s) == 0)
                {
                    same = true;
                }
                else
                {
                    same = false;
                }
            }
            yes = true;
            if ( (Pattern.matches("[1-2][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9]",memberStr.get(x))) && memberStr.get(x).compareTo("2003-10-16") != 0 && same == false)  //http://stackoverflow.com/questions/4475619/java-regular-expression-with-hyphen <--this line is the regex for finding a date
            {
                for (int a = x; a < memberStr.size(); a++) // checking if it is an online (ONL) rating. if it is , it does not include the date for that rating
                {
                    if (memberStr.get(a).contains("=>")) // The => is the pattern where the rating after it is the rating for that date
                    {
                        if (memberStr.get(a-3).contains(" ") || memberStr.get(a-1).contains("ONL:"))
                        {
                            yes = false;
                        }
                        a = memberStr.size(); // ending the for loop
                    }
                }
                if (yes == true) //if it truly is a date (not duplicated) that we must add
                {
                    tempString = memberStr.get(x).split("-",3);
                    for (int y = 0; y < tempString.length; y ++) // adding the date to tempNum
                    {
                        tempNum[y] = Integer.parseInt(tempString[y]); //http://imagejdocu.tudor.lu/doku.php?id=howto:java:how_to_convert_data_type_x_into_type_y_in_java
                    }
                    //adding to the arrays (the TimeSeries class actually does not accept Dates, but it accepts the year, month and day each seperately. So, I had to make 3 different arraylists for each
                    year.add(tempNum[0]); // adding to the year array
                    month.add(tempNum[1]); // adding to the month array
                    day.add(tempNum[2]); // adding to the day array
                    cal.add(memberStr.get(x)); // cal is only used as a verification arraylist that is used in the first if statement at the top of this method
                    count ++;
                }
            }

        }
        System.out.println("This player has played in " + count + " tournaments"); //trace + check
        System.out.println(memberStr);
        int first = 0;
        int ratingcount = 0;
        System.out.println(year);
        System.out.println(year.size());
        // now for the ratings
        for (int z = 0; z < year.size(); z++) //going through the size of dates, starting at 0
        {
            for (int y = memberStr.size() - 1; y >= 0; y--) //going through the data
            {
                if (cal.get(z).compareTo(memberStr.get(y)) == 0) // if they are ==
                {
                    for (int k = y; k < memberStr.size(); k ++) // now they shall look for the closest => sign - that will be the attained rating
                    {
                        if (first == 0 && memberStr.get(k-1).contains("=>") && memberStr.get(k-3).compareTo(" ") != 0 && !(memberStr.get(k-3).contains("ONL:")) && !(memberStr.get(k-2).contains("ONL:")))
                        {
                            ratings.add(Integer.parseInt(memberStr.get(k)));
                            k = memberStr.size();
                            y = -1;
                            ratingcount ++;
                        }
                    }                    
                }
            }
        }
    }

    /**
     * ACCESSOR
     * @return     the list of ratings
     */

    public ArrayList<Integer> getRatings() throws IOException
    {
        return ratings;
    }
    /**
     * ACCESSOR
     * @return     the year
     */
    public ArrayList<Integer> getYear() throws IOException
    {
        return year;
    }
    /**
     * ACCESSOR
     * @return     the month 
     */
    public ArrayList<Integer> getMonth() throws IOException
    {
        return month;
    }
    /**
     * ACCESSOR
     * @return     the day
     */
    public ArrayList<Integer> getDay() throws IOException
    {
        return day;
    }

    /**
     * Runs the parser method
     */
    public void main() throws IOException
    {
        this.parse();
    }
}
