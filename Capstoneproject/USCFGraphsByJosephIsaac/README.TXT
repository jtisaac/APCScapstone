------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: USCF Graphs by Joseph Isaac
PURPOSE OF PROJECT: To graph chess rating data of a player over time and compare it with other players.
VERSION or DATE: Version 1.2, May 10, 2016
DEPENDENCIES: Uses data from USChess.org. Each member's data is found from "http://www.uschess.org/msa/MbrDtlTnmtHst.php?" + [that member's id] + "." + [if the member has more than 50 tournaments, for many players this is 0]
PRIOR KNOWLEDGE: USChess.org is the data hub for chess in the USA. all chessplayers who have registered 
                 with them have an ID that links them to their file. With an ID, you can see their statistics. A sample member file page is 
                 @ http://www.uschess.org/msa/MbrDtlMain.php?14733522. Click on "TNMT. HIST". This is where I get the rating data from. 
                 At each tournament that the player plays at, their rating(s) are updated and shown in that tab.
                 *My program may not correctly use data from members who have tournaments before 2002 because they may have tournaments entered out of order.
                 *
HOW TO START THIS PROJECT: Open Bluej. Go to CapstoneProject and click on the "CapstoneProject" Bluej file. 
                           (There are 2 examples from jfreecharts (available only to premium members of David Gilbert's jfree doc site for jfreecharts @ http://www.object-refinery.com/jfreechart/premium/index.html) that I did copy the format of for RatingsGraph. This is in the capstone_examples folder. Right now, they don't seem to run, but that's where I got some inspiration. Any other files there,
                           if you see it in the commits, are NOT part of the project. Some of them may not run, and they may represent previous failed attemps at starting the capstone OR examples which I do not eventually use).
                           [Do this before starting the program for the first time: MAKE SURE in Bluej Preferences -> Libraries to add the JAR files located in the jarfiles folder. These are jsoup, jfreecharts, and jcommon
                           These are required to run the program.]
                           Go back to CapstoneProject and click the package "USCFGraphsByJosephIsaac". 
                           The WebpageReader reads data from a USChess.org member file webpage.
                           The Parser parses this data.
                           The ParserTester tests the parser with sample data.
                           The RatingsGraph runs the WebpageReader and the Parser to display the graph.
                           
                           Follow instructions below.
                           
AUTHOR: Joseph Isaac

USER INSTRUCTIONS:RUN RatingsGraph main() method. PRESS ok. Bluej terminal should pop up. 
                  
                  When it asks if you want to add more players, type "y" for more and "n" to stop and display graph.
                  
                  If you type "y", the terminal will prompt you for that member's id. You can add members by inserting
                  member ids separated by commas (Comma-Separated-Values). EX: enter two player's data by entering [14733522,14994563]
                  or just one player's data by [14733522]. *: after you enter each member's data, the terminal will print out that member's
                  data (to look cool and also debug)
                  
                  When you type "n" or any other character after that, The program will display the graphs of those members' ratings in respect to
                  time. per JFreeCharts, you can zoom in by moving the mouse downward diagonally from left to right to highlight a certain
                  region to zoom in upon. to zoom back out, move the mouse any direction. Additionally, JfreeCharts provides a tooltip function.
                  If you hover over a point on the graph (a pointy point) for about three seconds, it will display the name and rating. Pretty cool!
                  
                  *If you want a sample ID Key (a key is composed of several member IDs), here it is: 
                  *14733522,14994563,14468490,12935418,13511620,15389923,15340692,15129577,13582071,13556528,12870813,13750922,15146482,15293091,14895066,15436823,14006780,13660146,15465657,14375064,12773441,15761416