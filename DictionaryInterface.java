package FindWordsPackage;

/**
 * @author Jefferson Vivanco NetID: JV1019 Date: 10-10-2015 
 * Interface: This interface defines the requirements for a dictionary class. It requires the class have the methods findWord
 * 			  and findPrefix.
 * Note: This interface was taken from the homework assignment. 
 */
public interface DictionaryInterface {
	/**
	 * This method determines if a given word is in the Dictionary. 
	 * @oaram word is the word to be checked 
	 * @return true if the word is in this Dictionary, false otherwise 
	 */
	boolean findWord(String word); 
	
	/**
	 * This method determines if a given prefix is a prefix of a word that exists in this Dictionary. 
	 * @param prefix is the prefix to be checked 
	 * @return true if the prefix is in this Dictionary. false otherwise 
	 */
	boolean findPrefix(String prefix); 
}
