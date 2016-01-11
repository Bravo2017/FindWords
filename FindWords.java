package FindWordsPackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * @author Jefferson Vivanco NetID: JV1019 Date: 10-10-2015 
 * Class: This class is the runnable program. This class reads the words from the words file and adds them to a dictionary
 * 		  object. Also, this class is in charge of asking the user for a set of letters and then creating a letter bag of these
 * 		  sequences. Finally, this class prints to the console the result of the getAllWords method. 
 */
public class FindWords {
	
	/**
	 * @param args is the string array of command line arguments, there should only be one for this program
	 * @throws FileNotFoundException if a file cannot be found 
	 */
	public static void main(String[] args) throws FileNotFoundException 
	{
		if(args.length!=1)//Making sure the user entered at least one command line argument 
		{
			System.err.print("Please make sure you entered the name of a file");
			System.exit(-1);
		}
		//------------------------------------//CREATING FILE & CHECKING IF FILE EXISTS AND READABLE 
		
		
		File userFile = new File(args[0]);//Creating File object using first argument  
		
		if (!userFile.exists() || !userFile.canRead() )//Checking file if it's exists and if it's readable 
		{
			System.err.printf("ERROR: cannot read file %s.\n\n", args[0]);
			System.exit(-1);
		}
		//------------------------------------//READING INPUT FILE 
		Scanner readFile = new Scanner(userFile); //Setting up scanner to read the input file 
		Dictionary ListOfWords = new Dictionary(); //Creating a dictionary to add the words from the input file
		while(readFile.hasNext())
		{
			String word = readFile.next();
			if(!word.isEmpty())ListOfWords.addWord(word);//Checking if the string is not empty and then adding it to dictionary
		}
		readFile.close();//Closing the scanner read file
		//-------------------------------------//READING USER'S INPUT
		Scanner userInput = new Scanner(System.in); //Setting up scanner to read letters from the user
		System.out.println("Please enter a set of letters:");
		String letters = userInput.next(); 
		if(!letters.matches("[a-zA-Z]+"))//Checking if what the user entered are letters and not other characters 
		{
			System.err.print("Please make sure you typed letters and only letters");
			System.exit(-1);
		}
		
		userInput.close();//closing the user input scanner
		LetterBag userLetters = new LetterBag(letters.toLowerCase()); //Creating a letterbag object from the letters the user
																	 //entered, converting them first to lowercase
		ListOfWords.copy();//Calling the copy function, it is used to help the dictionary class work 
		ArrayList<String> words2 = userLetters.getAllWords(ListOfWords);//Getting the ArrayList of sorted elements from the 
																	//getAllWords method
		System.out.print("\n"+"Words computed:"+"\n\n");
		for(int i=words2.size()-1; i>=0;i--)//Printing out each element of the ArrayList
		{
			System.out.println(words2.get(i));
		}
		System.out.println("\n"+userLetters.getArSize());//Printing out the size of the ArrayList 
		//------------------------------------//

	}

}
