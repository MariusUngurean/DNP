package code_validator;

import java.util.ArrayList;
import java.util.Arrays;

public class Splitter
    {

        public Splitter()
            {

            }

        public ArrayList<String> split(String textToSplit)
            {
                //return  new ArrayList<String>(Arrays.asList(textToSplit.split("\\s+")));
                return  new ArrayList<String>(Arrays.asList(textToSplit.split("[()\\s\\.]+")));
            }
    }
