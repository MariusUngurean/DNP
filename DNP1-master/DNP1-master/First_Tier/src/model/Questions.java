package model;

public enum Questions {

	Question_zero("Write a JAVA method which prints the string \"Hello World\" to "
			+ "\nthe console and leaves the cursor on the next line."
			+ "\nWARNING: Your answer is case sensitive!"), 
	Question_one("Declare and initialize a variable of type String named "
			+ "\n\"example\" with text \"Hello World\"."
			+ "\nWARNING: Your answer is case sensitive!\n"), 
	Question_two("Consider that a variable of type String named \"example \"is "
			+ "\ndeclared and initialized containing text \"Hello World\"."
			+ "\nWrite a JAVA method which prints the content of this variable "
			+ "\nto the console and leaves the cursor on the next line."
			+ "\nWARNING: Your answer is case sensitive!"), 
	Question_three("Considering the following class named Test."
			+ "\n\n            public class Test"
			+ "\n            {"
			+ "\n                 public boolean compare(String a, String b)"
			+ "\n                 {"
			+ "\nLine 5:              return a == b;"
			+ "\n                 }"
			+ "\n            }"
			+ "\n"
			+ "\nThe purpose of the method named \"compare\" is to compare the "
			+ "\ncontent of two objects of type String given as arguments."
			+ "\nRewrite the line number 5 into a form which will fit our requirement."
			+ "\nWARNING: Your answer is case sensitive!"), 
	Question_four("Declare and initialize an array of variables of type integer "
			+ "\nnamed \"intArray\" containing elements \"1,2,3,4,5\""
			+ "\nWARNING: Your answer is case sensitive!"), 
	Question_five("Considering the following class named TestAgain."
			+ "\n"
			+ "\n            public class TestAgain"
			+ "\n            {"
			+ "\n                 public boolean compare(String a, String b)"
			+ "\n                 {"
			+ "\nLine 5:              return a == b;"
			+ "\n                 }"
			+ "\n            }"
			+ "\n"
			+ "\nThe purpose of the method named \"compare\" is to compare the "
			+ "\nreferences of two objects of type String given as arguments."
			+ "\nRewrite the line number 5 into a form which will fit our requirement."
			+ "\nWARNING: Your answer is case sensitive!");
	
	

	private final String question;

	Questions(final String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return question;
	}

	public static String[] QuestionsToStringArray(Questions[] questions) {

		int i = 0;
		String[] result = new String[questions.length];
		for (Questions question : questions) {
			result[i++] = question.toString();
		}
		return result;
	}

}
