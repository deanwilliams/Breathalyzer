import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class breathalyzer {

	private static final String acceptedWordListFileName = "./src/twl06.txt"; // needs to be /var/tmp/twl06.txt for submission

	private String[] words;
	private String[] acceptedWords;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Missing argument");
			System.exit(1);
		}
		breathalyzer b = new breathalyzer(args[0]);
		int total = b.getTotalEditDistance();
		System.out.println(total);
	}

	/**
	 * Constructor
	 *
	 * @param fileName
	 */
	public breathalyzer(String fileName) {
		try {
			words = getWords(fileName);
			acceptedWords = getAcceptedWords();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file");
		}
	}

	/**
	 * Get the total edit distance
	 *
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 */
	public int getTotalEditDistance() {
		int total = 0;
		for (String line : words) {
			int wordScore = 100;
			for (String word : acceptedWords) {
				if (line.equalsIgnoreCase(word)) {
					wordScore = 0;
				} else {
					int i = LD(line, word);
					wordScore = Math.min(wordScore, i);
				}
				if (wordScore == 0) {
					break;
				}
			}
			total += wordScore;
		}
		return total;
	}

	/**
	 * Get the words list
	 *
	 * @return String[]
	 * @throws FileNotFoundException
	 */
	public String[] getWords(String fileName) throws FileNotFoundException {
		LinkedList<String> wordList = new LinkedList<String>();
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			wordList.add(scanner.next().toLowerCase());
		}
		words = new String[wordList.size()];
		return wordList.toArray(words);
	}

	/**
	 * Get the accepted words list
	 *
	 * @return String[]
	 * @throws FileNotFoundException
	 */
	private String[] getAcceptedWords() throws FileNotFoundException {
		LinkedList<String> wordList = new LinkedList<String>();
		File file = new File(acceptedWordListFileName);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			wordList.add(scanner.next().toLowerCase());
		}
		acceptedWords = new String[wordList.size()];
		return wordList.toArray(acceptedWords);
	}

	/**
	 * Calculate minimum from three ints
	 *
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static int Minimum(int a, int b, int c) {
		int mi;
		mi = a;
		if (b < mi) {
			mi = b;
		}
		if (c < mi) {
			mi = c;
		}
		return mi;
	}

	/**
	 * Get the Levenshtein Distance
	 *
	 * @param s
	 * @param t
	 * @return
	 */
	public static int LD(String s, String t) {
		int d[][]; // matrix
		int n; // length of s
		int m; // length of t
		int i; // iterates through s
		int j; // iterates through t
		char s_i; // ith character of s
		char t_j; // jth character of t
		int cost; // cost
		// Step 1
		n = s.length();
		m = t.length();
		if (n == 0) {
			return m;
		}
		if (m == 0) {
			return n;
		}
		d = new int[n + 1][m + 1];
		// Step 2
		for (i = 0; i <= n; i++) {
			d[i][0] = i;
		}
		for (j = 0; j <= m; j++) {
			d[0][j] = j;
		}
		// Step 3
		for (i = 1; i <= n; i++) {
			s_i = s.charAt(i - 1);
			// Step 4
			for (j = 1; j <= m; j++) {
				t_j = t.charAt(j - 1);
				// Step 5
				if (s_i == t_j) {
					cost = 0;
				} else {
					cost = 1;
				}
				// Step 6
				d[i][j] = Minimum(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + cost);
			}
		}
		// Step 7
		return d[n][m];
	}

}
