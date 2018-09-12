import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo {

	String text;

	RegExDemo(String text) {
		this.text = text;
	}

	public static void main(String[] args) {
		RegExDemo re1 = new RegExDemo("The quick brown fox jumps over the lazy dog");
		RegExDemo re2 = new RegExDemo("This is a sample text with text, sample@email.com and some numbers 123!");
		RegExDemo re3 = new RegExDemo("The date today is 2018-09-12, and it's a Wednesday.");

		re1.findWordsFromText();
		re3.findInstancesMatchingText();
		re3.findInstancesMatchingTextAtTheBeginning();
		re3.findWordsMatchingTextAtTheBeginning();
		re3.findWordsContainingTextButNotAtTheBeginning();
		re1.findInstancesMatchingTextAtTheEnd();
		re3.findWordsContainingText();
		re3.extractDate();
		re2.extractNonAlphabetsExcludingSpaces();
		re2.extractNonEmailText();
	}

	static void splitOnMatchAndPrint(String text, String pattern) {
		String[] matches = text.split(pattern);
		for(String match : matches) {
			System.out.println(match);
		}
		System.out.println("");
	}

	static void printOccurrencesOfPattern(String text, String regExText) {
		Pattern pattern = Pattern.compile(regExText);
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
			System.out.print("Start Index: " + matcher.start() + ", ");
			System.out.print("Stop Index: " + matcher.end() + ", ");
			System.out.println("text: " + matcher.group());
		}
		System.out.println("");
	}

	void findWordsFromText() {
		System.out.println("###Finding words from text###");
		String pattern = "\\s+";
		splitOnMatchAndPrint(this.text, pattern);
	}

	void findInstancesMatchingText() {
		System.out.println("###Finding instances of occurrence of 'da'###");
		String pattern = "da";
		printOccurrencesOfPattern(this.text, pattern);
	}

	void findInstancesMatchingTextAtTheBeginning() {
		System.out.println("###Finding instances of occurrence of 'da' at the beginning###");
		String pattern = "\\bda";
		printOccurrencesOfPattern(this.text, pattern);
	}

	void findWordsMatchingTextAtTheBeginning() {
		System.out.println("###Finding words containing 'da' at the beginning###");
		String pattern = "\\b(da[a-zA-Z]+)";
		printOccurrencesOfPattern(this.text, pattern);
	}

	void findWordsContainingTextButNotAtTheBeginning() {
		System.out.println("###Finding words containing 'da' but not at the beginning###");
		String pattern = "[a-zA-Z]+da[a-zA-Z]+";
		printOccurrencesOfPattern(this.text, pattern);
	}

	void findInstancesMatchingTextAtTheEnd() {
		System.out.println("###Finding words containing 'r' at the end###");
		String pattern = "[a-zA-Z]+r\\b";
		printOccurrencesOfPattern(this.text, pattern);
	}

	void findWordsContainingText() {
		System.out.println("###Finding words containing 'da'###");
		String pattern = "\\bda[a-zA-Z]+|[a-zA-Z]+da[a-zA-Z]+|[a-zA-Z]+da\\b";
		printOccurrencesOfPattern(this.text, pattern);
	}

	void extractDate() {
		System.out.println("###Extracting Date###");
		String pattern = "\\d{4}-\\d{2}-\\d{2}";
		printOccurrencesOfPattern(this.text, pattern);	
	}

	void extractNonAlphabetsExcludingSpaces() {
		System.out.println("###Extracting non-alphabet characters excluding spaces###");
		String pattern = "[^a-zA-Z\\s]+";
		printOccurrencesOfPattern(this.text, pattern);
	}

	void extractNonEmailText() {
		System.out.println("###Extracting non-email text (Negative Lookahead)###");
		String pattern = "sample(?!@)";
		printOccurrencesOfPattern(this.text, pattern);	
	}
}