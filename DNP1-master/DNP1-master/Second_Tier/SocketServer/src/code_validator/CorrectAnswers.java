package code_validator;

import java.util.ArrayList;

public class CorrectAnswers
    {
        private static ArrayList<String> answers;
        private static final String ONE = "System.out.println(\"Hello World\")";
        private static final String TWO = "String example = \"Hello World\"";
        private static final String THREE = "System.out.println(example)";
        private static final String FOUR = "return a.equals(b);";
        private static final String FIVE = "int[] intArray = new int[]{1,2,3,4,5};";
        private static final String SIX = "";

        public CorrectAnswers()
            {
                answers = new ArrayList<String>();
                answers.add(ONE);
                answers.add(TWO);
                answers.add(THREE);
                answers.add(FOUR);
                answers.add(FIVE);
                answers.add(SIX);
            }

        public static String getCorrectAnswer(int index)
            {
                return answers.get(index);
            }


    }
