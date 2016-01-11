package FindWordsPackage;
import java.util.*;

/**
 * @author Jefferson Vivanco NetID: JV1019 Date: 10-10-2015 
 * Class: This class defines a dictionary object.It implements the Dictionary Interface. A dictionary object represents a list of all the words in the input file
 * 		  (Dictionary) and the methods to get a prefix and word. 
 *
 */
public class Dictionary implements DictionaryInterface{

	private ArrayList<String>ListOfWords = new ArrayList<>();//WHERE ALL THE WORDS FROM THE FILE ARE
	private String[] ARListOfWords;
	
	/**
	 * DEFAULT CONSTRUCTOR TO MAKE A DICTIONARY OBJECT 
	 */
	public Dictionary()
	{
		//Default 
	}

	/**
	 * @param word is the word that you want to add to the dictionary object. 
	 */
	public void addWord(String word)
	{
		ListOfWords.add(word); 
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String repres=""; 
		for(int i=0; i<this.ListOfWords.size(); i++)
		{
			repres = repres+this.ListOfWords.get(i)+"\n"; 
		}
		return repres; 
	}
	/**
	 * This method makes a copy of the original ArrayList used in the Dictionary Object. We make a copy so we can use it
	 * in the findWord and findPrefix methods.
	 */
	public void copy(){
		ArrayList<String> list2 = new ArrayList<>(this.ListOfWords);
		
		this.ARListOfWords = new String[list2.size()];
		for(int i=0; i<list2.size();i++)
		{
			ARListOfWords[i] = list2.get(i); 
		}
		
	}
	/* (non-Javadoc)
	 * @see FindWordsPackage.DictionaryInterface#findWord(java.lang.String)
	 */
	public boolean findWord(String word) {
		return findWord(this.ARListOfWords,word,0,this.ARListOfWords.length-1); //Calling Private Method 
	}
	
	/**
	 * Method: This method finds a word in the dictionary. This private method overrides the original findWord method. We
	 * 		   did it like this so we would be able to implement the binary search method. 
	 * @param ARlistOfWords is the array that the method will look in to find the word 
	 * @param word is the word the method is looking for 
	 * @param beg is beginning index of the array 
	 * @param end is the ending index of the array
	 * @return true if the word is found, false otherwise. 
	 */
	private boolean findWord(String[] ARlistOfWords,String word,int beg, int end) 
	{
		if(beg<=end){
			int mid = (beg+end)/2; 
			if(ARlistOfWords[mid].compareToIgnoreCase(word)==0)return true; 
			else if(ARlistOfWords[mid].compareToIgnoreCase(word)<0)
				return findWord(ARlistOfWords,word,mid+1,end);
			else
				return findWord(ARlistOfWords, word, beg, mid-1); 
		}
		else
			return false;

	}

	/* (non-Javadoc)
	 * @see FindWordsPackage.DictionaryInterface#findPrefix(java.lang.String)
	 */
	public boolean findPrefix(String prefix) {
		return findPrefix(this.ARListOfWords,prefix,0,this.ARListOfWords.length); //Calling the private method
	}
	
	/**
	 * Method: This method finds a prefix in the dictionary. This private method overrides the original findPrefix method. We 
	 * 		   did it like this so we would be able to implement the binary search method.
	 * @param dic is the array that holds all the words in the dictionary. Since the binary search method looks through an 
	 * 		  array, we copied the words in the dictionary into a new array and then pass this new array to this method
	 * 		  so it can search through it.  
	 * @param prefix is the prefix we are looking for.
	 * @param beg is the beginning index of the array 
	 * @param end is the ending index of the array 
	 * @return true if the prefix is found, false otherwise.
	 */
	private boolean findPrefix(String[] dic, String prefix, int beg, int end)
	{
		if(beg<=end){
			int mid = (beg+end)/2; 
			int checkL = dic[mid].length();
			int pL = prefix.length();
			if(pL<=checkL)//We are checking this so we don't compare two uneven strings and then receive a method. 
			{
				if(dic[mid].substring(0, prefix.length()).compareToIgnoreCase(prefix)==0)return true; 
				else if(dic[mid].substring(0, prefix.length()).compareToIgnoreCase(prefix)<0)
					return findPrefix(dic,prefix,mid+1,end); 
				else
					return findPrefix(dic,prefix,beg,mid-1);
			}
			else{//We need this to keep looking through the array 
				if(dic[mid].compareToIgnoreCase(prefix)<0)			
					return findPrefix(dic, prefix,mid+1,end); 
				else
					return findPrefix(dic,prefix,beg,mid-1);
			    }
		}
		else
			return false;
	}

}
