import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo {

	String text;

	RegExDemo(String text) {
		this.text = text;
	}

	public static void main(String[] args) {
		RegExDemo re1 = new RegExDemo("The quick brown fox jumps over the lazy dog");
		RegExDemo re2 = new RegExDemo("1234567890");
		RegExDemo re3 = new RegExDemo("This is a sample text with text, sample@email.com and some numbers 123!");
		RegExDemo re4 = new RegExDemo("The date today is 2018-09-12, and it's a Wednesday.");

		re1.findWordsFromText();
		re4.findInstancesMatchingText();
		re4.findInstancesMatchingTextAtTheBeginning();
		re4.findWordsMatchingTextAtTheBeginning();
		re4.findWordsContainingTextButNotAtTheBeginning();
		re1.findInstancesMatchingTextAtTheEnd();
		re4.findWordsContainingText();
	}

	static void splitOnMatchAndPrint(String text, String pattern) {
		String[] matches = text.split(pattern);
		for(String match : matches) {
			System.out.println(match);
		}
		System.out.println("*****");
	}

	static void printOccurrencesOfPattern(String text, String regExText) {
		Pattern pattern = Pattern.compile(regExText);
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
			System.out.print("Start Index: " + matcher.start() + ", ");
			System.out.print("Stop Index: " + matcher.end() + ", ");
			System.out.println("text: " + matcher.group());
		}
		System.out.println("*****");
	}

	void findWordsFromText() {
		String pattern = "\\s+";
		splitOnMatchAndPrint(this.text, pattern);
	}

	void findInstancesMatchingText() {
		String pattern = "da";
		printOccurrencesOfPattern(this.text, pattern);
	}

	void findInstancesMatchingTextAtTheBeginning() {
		String pattern = "\\bda";
		printOccurrencesOfPattern(this.text, pattern);
	}

	void findWordsMatchingTextAtTheBeginning() {
		String pattern = "\\b(da[a-zA-Z]+)";
		printOccurrencesOfPattern(this.text, pattern);
	}

	void findWordsContainingTextButNotAtTheBeginning() {
		String pattern = "[a-zA-Z]+da[a-zA-Z]+";
		printOccurrencesOfPattern(this.text, pattern);
	}

	void findInstancesMatchingTextAtTheEnd() {
		String pattern = "[a-zA-Z]+r\\b";
		printOccurrencesOfPattern(this.text, pattern);
	}

	void findWordsContainingText() {
		String pattern = "\\bda[a-zA-Z]+|[a-zA-Z]+da[a-zA-Z]+|[a-zA-Z]+da\\b";
		printOccurrencesOfPattern(this.text, pattern);
		
	}
}