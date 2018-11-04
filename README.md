# CSX42: Assignment 4
## Name: Aaditya Sakharam Patil
-----------------------------------------------------------------------
-----------------------------------------------------------------------
###Assuming you are in the directory containing this README
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on project.
#### Note: build.xml is present in airportSecurityState/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile airportSecurityState/src/build.xml clean

Description: It cleans up all the .class files that were generated when 
you compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile airportSecurityState/src/build.xml all

Description: Compiles code and generates .class files inside the BUILD 
folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile airportSecurityState/src/build.xml run -Darg0=src/input.txt -Darg1=src/output.txt -Darg2=DEBUG_VALUE

Note: For this command to work correctly place all the files in src directory. 
else, Arguments accept the absolute path of the files.

DEBUG_VALUE is between 0 to 4.
DEBUG_VALUE=4 [Prints to stdout everytime a constructor is called]
DEBUG_VALUE=3 [Prints to stdout everytime prohibited item is found]
DEBUG_VALUE=2 [Prints to stdout everytime a state is changesd]
DEBUG_VALUE=1 [Prints to stdout everytime an entry is made to Results's data structutre]
DEBUG_VALUE=0 [Prints output or errors/exceptions to stdout]

-----------------------------------------------------------------------
## Description:

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 11/04/2018

