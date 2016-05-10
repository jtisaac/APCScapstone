package isaac.joseph.uscfgraphs;

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

    private static String memberID;
    private ArrayList<String> names;
    private ArrayList<Integer> ratings;
    
    private ArrayList<String> data;
    private ArrayList<String> memberStr;
    private String memberdata;

    private ArrayList<Integer> year;
    private ArrayList<Integer> month;
    private ArrayList<Integer> day;
    /**
     * Constructor for objects of class CapstoneFileReader
     */
    public Parser(String memberdata)
    {
        // initialise instance variables

        names = new ArrayList<String>();
        ratings = new ArrayList<Integer>();
        

        year = new ArrayList<Integer>();
        month = new ArrayList<Integer>();
        day = new ArrayList<Integer>();

        memberStr = new ArrayList<String>();
        String[] temp = memberdata.split(" "); //?<="\S"
        for (int x= 0; x < temp.length; x++)
        {
            memberStr.add(temp[x]);

        }
        //System.out.println(memberdata);
        memberdata = memberdata;
    }

    public void parse() throws FileNotFoundException, IOException
    {
        int[] tempNum = new int[3];
        String[] tempString = new String[3];
        ArrayList<String> cal = new ArrayList<String>();
        boolean same = false;
        int count = 0;
        boolean yes = false;
        String tempstr = "";
        int match = 0;
        for (int x = memberStr.size() - 1; x >= 0; x--)
        {
            for (String s : cal) 
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
            match = 0;
            if ( (Pattern.matches("[1-2][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9]",memberStr.get(x))) && memberStr.get(x).compareTo("2003-10-16") != 0 && same == false)//http://stackoverflow.com/questions/4475619/java-regular-expression-with-hyphen 
            {

                for (int a = x; a < memberStr.size(); a++)
                {
                    if (memberStr.get(a).contains("=>"))
                    {

                        if (memberStr.get(a-3).contains(" ") || memberStr.get(a-1).contains("ONL:"))
                        {
                            yes = false;
                        }
                        a = memberStr.size();
                    }

                    
                }
                if (yes == true)
                {

                    tempString = memberStr.get(x).split("-",3);

                    for (int y = 0; y < tempString.length; y ++)
                    {
                        tempNum[y] = Integer.parseInt(tempString[y]); //http://imagejdocu.tudor.lu/doku.php?id=howto:java:how_to_convert_data_type_x_into_type_y_in_java
                    }

                    year.add(tempNum[0]); //-1900
                    month.add(tempNum[1]);
                    day.add(tempNum[2]);
                    //System.out.print(year + " " + month + " " + day + " ");
                    count ++;

                    cal.add(memberStr.get(x));
                }
            }

        }

        System.out.println("This player has played in " + count + " tournaments");
        System.out.println(memberStr);
        int first = 0;
        int ratingcount = 0;

        System.out.println(year);
        System.out.println(year.size());

        for (int z = 0; z < year.size(); z++)
        {
            //System.out.println(z);
            for (int y = memberStr.size() - 1; y >= 0; y--)
            {
                //System.out.println(y);
                if (cal.get(z).compareTo(memberStr.get(y)) == 0)
                {
                    for (int k = y; k < memberStr.size(); k ++)
                    {
                        if (first == 0 && memberStr.get(k-1).contains("=>") && memberStr.get(k-3).compareTo(" ") != 0 && !(memberStr.get(k-3).contains("ONL:")) && !(memberStr.get(k-2).contains("ONL:")))
                        {
                            ratings.add(Integer.parseInt(memberStr.get(k)));
                            k = memberStr.size();
                            y = -1;
                            ratingcount ++;
                        }
                        //                         else if (memberStr.get(k-1).compareTo("=>") == 0 && memberStr.get(k-3).compareTo(" ") == 0 || first == 1)
                        //                         {
                        //                             //year.remove(z);
                        //                             //month.remove(z);
                        //                             //.remove(z);
                        //                             System.out.println("Phemerwitz");
                        //                         }
                    }
                    
                }

            }
        }
        System.out.println(ratings);
        System.out.println(ratingcount);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */

    public ArrayList<Integer> getRatings() throws IOException
    {
        return ratings;
    }
    public ArrayList<Integer> getYear() throws IOException
    {
        return year;
    }

    public ArrayList<Integer> getMonth() throws IOException
    {
        return month;
    }

    public ArrayList<Integer> getDay() throws IOException
    {
        return day;
    }

    /**
     * Method that fetches the name of the member.
     */
    public String fetchName()
    {
        return memberdata.split(memberID + ": ")[1].split(" Events")[0];
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void main() throws IOException
    {
        this.parse();
    }
}
