import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpellChecker {

    private final String CORRECT_MSG = " correct";
    private final String WRONG_MSG = " not found - nearest neighbour(s) ";

    /**
     * The main method which is used to run the program.
     * @param args is the argument that need to be inputted
     */
    public static void main(String args[]) {
        int length = args.length;
        zero_arg(length);

        SpellChecker spellChecker = new SpellChecker();
        for (String i : args) {
            spellChecker.search(i);
        }
    }

    /**
     * The method which is used to judge the exact number of program.
     * @param length is the size of the argument
     */
    private static void zero_arg(int length) {
        if (length == 0) {
            System.out.println("Usage: java SpellChecker <word_to_check>");
            System.exit(0);
        }
    }

    /**
     * The method which is used to print message.
     * @param word is the word being inputted
     */
    public void search(String word) {
        SpellCheckResult result = spellCheckResults(word);

        if (result.isCorrect()) System.out.println(word + CORRECT_MSG);
        else System.out.println(word + WRONG_MSG + result.getBefore() + " and " + result.getAfter());
    }

    /**
     * The logic is like this:
     * find exact word -> if yes -> set is correct as true
     *                  -> if no -> add the word to new dictionary -> sort -> get before and after word
     * -> add iscorrect, before and after (default is null) to Spell Checker result class
     * @param word is the word being inputted
     * @return the spell check result which will be use in search()
     */
    private SpellCheckResult spellCheckResults(String word) {
        DictionaryLoader dictionaryLoader = DictionaryLoader.getInstance();
        String[] dictionary = dictionaryLoader.loadDictionary();
        String before = null, after = null;
        boolean iscorrect = false;

        for (String i : dictionary) {
            if (i.equals(word)) {
                iscorrect = true;
            }
        }

        if (!iscorrect) {
            List<String> newDic = newDictionary(dictionary);
            newDic.add(word);
            Collections.sort(newDic);
            for (int i = 0; i < newDic.size(); i++) {
                if (newDic.get(i).equals(word)) {
                    if (i == 0) after = newDic.get(i + 1);
                    else if (i == newDic.size() - 1) before = newDic.get(i - 1);
                    else {
                        after = newDic.get(i + 1);
                        before = newDic.get(i - 1);
                    }
                }
            }
        }

        return new SpellCheckResult(iscorrect, before, after);
    }

    /**
     * This method is to get the new dictionary to sort the order to fit the alphabetical order
     * @param dictionary is the dictionary from dictionary loader class
     * @return the array list that the wrong word being added
     */
    private List<String> newDictionary(String[] dictionary) {
        return new ArrayList<String>(Arrays.asList(dictionary));
    }



}
