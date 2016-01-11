# FindWords

Project Description: 

This program produces all possible words given a set of letters and a dictionary. The program produces all anagrams of a given set of letters that are valid words in the provided dictionary. For example if the letters are "recounts", the program prints--> construe, counters, and recounts; assuming those words are valid words in the provided dictionary. To run the program, the user must provide a dictionary file (this file must contain a sorted list of words, one per line). Once the program starts running, the user will be prompted to enter a string of letters. After this, the program will display all the possible words that can be made from that set of letters that exist in the dictionary. 

Program Files: 

Dictionary.java - This class represents the collection of words read from the input file. 

DictionaryInterface.java - This class provides the interface that the Dictionary class must implement. 

LetterBag.java - This class represents the letters entered by the user. This class is also responsible for creating all the different anagrams from the letters entered by the user. 

LetterBagInterface - This class provides the interface that the letterBag class must implement. 

FindWords.java - This is the runnable program. This class is responsible for reading the input file and then computing results to the console. 

Sample input file: This file can be used to test the program. --> dictionary_400_Z_only.txt
