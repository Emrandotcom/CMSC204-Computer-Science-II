
/**
 * @author Emran Abbamacha
 */

import java.io.*;
import java.util.*;

public class MorseCodeConverter {

	static MorseCodeTree tree = new MorseCodeTree();

	/**
	 * Constructor -
	 */
	public MorseCodeConverter() {
		MorseCodeTree tree = new MorseCodeTree();
	}

	/**
	 * Returns a string with all the data in the tree in LNR order with an space in
	 * between them.
	 * 
	 * @return the data in the tree in LNR order separated by a space.
	 * 
	 */
	public static String printTree() {
		if (tree == null)
			return "";

		ArrayList<String> arrayList = tree.toArrayList();
		String data = "";

		for (String letter : arrayList) {
			data += letter + " ";
		}

		return data.trim();
	}

	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘).
	 * Each word is delimited by a ‘/’.
	 * 
	 * @param code - the morse code
	 * @return the English translation
	 * 
	 */
	public static String convertToEnglish(String code) {

		if (!(code.contains(".") || code.contains("-")))
			System.out.println("Unacceptable morse code, please enter valid morse code value");

		String englishResult = "";
		String[] words = code.split(" / ");

		for (String word : words) {

			String[] letters = word.split(" ");

			for (String letter : letters) {
				englishResult += MorseCodeConverter.tree.fetch(letter);
			}

			englishResult += " ";
		}

		return englishResult.trim();
	}

	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘).
	 * Each word is delimited by a ‘/’.
	 * 
	 * @param codeFile - name of the File that contains Morse Code
	 * @return the English translation
	 * 
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		if (codeFile == null) {
			throw new FileNotFoundException("File not found");
		}

		ArrayList<String> arrayList = new ArrayList<String>();
		Scanner keyboard = new Scanner(codeFile);
		String result = "";

		while (keyboard.hasNext()) {
			arrayList.add(keyboard.nextLine());
		}
		for (int i = 0; i < arrayList.size(); i++) {
			result += MorseCodeConverter.convertToEnglish(arrayList.get(i));
		}

		keyboard.close();
		return result.trim();
	}

}
