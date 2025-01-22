#Program that converts an NFA to a DFA and minimizes it.

#Synopsis

This program converts an NFA into a minimized DFA.

#Usage

You can run this program by compiling with QT libraries included in Eclipse, or compiling separately and then setting "Class-Path:" line in JAR manifest file. 
For Eclipse:
First download QT Jambi libraries for your OS:
http://qtjambi.org/downloads
And extract the zip. 

Then Import the Java files here as a new project in Eclipse. In properties of project, select "Java Build Path". Click on " Libraries" , and select " Add External JARs" , to add two JARs from the extracted QT Jambi zip: 

1. qtjamb-4*.jar
2. qtjambi-native*
Then you can just run the project in eclipse, or export as a JAR. 

For manually running:
Compile the project as a JAR, and include the two files mentioned above as a class-path.

You can use the included JAR to run without a need to download QT jambi libraries, as they are included in it .
Note: That JAR file has only the Linux 64 bit QT Jambi libraries for now. Other platforms will be included soon

# Screenshots
User has 4 choices : Converting an NFA to a minimized DFA, Minimizing a DFA and displaying a DFA.
![choices](http://ouissalart.com/nfa-project/NFA-Screenshots.jpeg)

First menu has 4 choices : Add a symbol, delete a symbol, display the alphabet and display the alphabet's size.
![alt tag](http://ouissalart.com/nfa-project/NFA-Screenshots1.jpeg)

You can enter any character as a symbol except "q" as that will be used for the states' names :
![alt tag](http://ouissalart.com/nfa-project/NFA-Screenshots2.jpeg)

You have the ability to delete a previously entered symbol :
![alt tag](http://ouissalart.com/nfa-project/NFA-Screenshots3.jpeg)

You can display your alphabet :
![alt tag](http://ouissalart.com/nfa-project/NFA-Screenshots5.jpeg)

This menu let you enter how many states are in your automaton and display them :
![alt tag](http://ouissalart.com/nfa-project/NFA-Screenshots6.jpeg)
![alt tag](http://ouissalart.com/nfa-project/NFA-Screenshots7.jpeg)

Select the final states : 
![alt tag](http://ouissalart.com/nfa-project/NFA-Screenshots10.jpeg)

Enter the transition function:
![alt tag](http://ouissalart.com/nfa-project/NFA-Screenshots12.jpeg)

![alt tag](http://ouissalart.com/nfa-project/NFA-Screenshots15.jpeg)

#Developers
This is a project for the languages theory class.

By :
Ouissal B.,Oumaima K. and Charaf B. under the supervision of Dr. Youssef Baddi.


 
