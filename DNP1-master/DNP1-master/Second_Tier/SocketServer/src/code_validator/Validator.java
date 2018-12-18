package code_validator;

import java.util.ArrayList;

public class Validator
    {
        private CorrectAnswers lisOfCorrectAnswers;
        private Splitter splitter;

        public Validator()
            {
                lisOfCorrectAnswers = new CorrectAnswers();
                splitter = new Splitter();
            }

        public int validate(int userStage, String answer)
            {
                int points = 0;
                ArrayList<String> answerSplit = splitter.split(answer);
                System.out.println("Answer from me after split: " + answerSplit);
                ArrayList<String> correctAnswerSplit = splitter.split(lisOfCorrectAnswers.getCorrectAnswer(userStage - 1));
                System.out.println("Correct answer after split: " + correctAnswerSplit);
                for (int i = 0; i < correctAnswerSplit.size(); i++)
                    {
                        if (correctAnswerSplit.get(i).equals(answerSplit.get(i)))
                            {
                                points++;
                            }
                    }

                return points;
            }



    }
