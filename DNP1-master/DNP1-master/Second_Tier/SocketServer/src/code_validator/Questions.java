package code_validator;

import java.util.ArrayList;

public class Questions
    {
        private static ArrayList<String> questions;
        private static final String ONE = "Write a JAVA method which prints the string \"Hello World\" to the console and leaves the cursor on the next line.\n" +
                "WARNING: Your answer is case sensitive!";
        private static final String TWO = "Declare and initialize a variable of type String named \"example\" with text \"Hello World\".\n" +
                "WARNING: Your answer is case sensitive!";
        private static final String THREE = "Consider that a variable of type String named \"example \"is declared and initialized containing text \"Hello World\".\n" +
                "Write a JAVA method which prints the content of this variable to the console and leaves the cursor on the next line.\n" +
                "WARNING: Your answer is case sensitive!";
        private static final String FOUR = "Considering the following class named Test.\n" +
                "\n" +
                "            public class Test\n" +
                "            {\n" +
                "                 public boolean compare(String a, String b)\n" +
                "                 {\n" +
                "Line 5:              return a == b;\n" +
                "                 }\n" +
                "            }\n" +
                "\n" +
                "The purpose of the method named \"compare\" is to compare the content of two objects of type String given as arguments.\n" +
                "Unfortunately, this method does not return the result we are expecting.\n" +
                "Rewrite the line number 5 into a form which will fit our requirement.\n" +
                "WARNING: Your answer is case sensitive!";
        private static final String FIVE = "Declare and initialize an array of variables of type integer named \"intArray\" containing elements \"1,2,3,4,5\".\n" +
                "WARNING: Your answer is case sensitive!";
        private static final String SIX = "Considering the following class named TestAgain.\n" +
                "\n" +
                "            public class TestAgain\n" +
                "            {\n" +
                "                 public boolean compare(String a, String b)\n" +
                "                 {\n" +
                "Line 5:              return a == b;\n" +
                "                 }\n" +
                "            }\n" +
                "\n" +
                "The purpose of the method named \"compare\" is to compare the references of two objects of type String given as arguments.\n" +
                "Rewrite the line number 5 into a form which will fit our requirement.\n" +
                "WARNING: Your answer is case sensitive!";

        public Questions()
            {
                questions = new ArrayList<>();
                questions.add(ONE);
                questions.add(TWO);
                questions.add(THREE);
                questions.add(FOUR);
                questions.add(FIVE);
                questions.add(SIX);
            }

        public static String getQuestion(int index)
            {
                return questions.get(index);
            }
    }
