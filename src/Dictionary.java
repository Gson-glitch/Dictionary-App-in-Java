import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
    public static Map<String, String> dictionary = new HashMap<>();
    public Dictionary() {
        try
        {
            String PATH_TO_TXT_FILE = "/home/gson/IdeaProjects/Java Projects/src/dictionary.txt";
            FileInputStream fis = new FileInputStream(PATH_TO_TXT_FILE);
            Scanner sc=new Scanner(fis);
            while(sc.hasNextLine())
            {
                String arr[] = sc.nextLine().split(" ", 2);
                dictionary.put(arr[0], arr[1]);
            }
            sc.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
//        System.out.println("First dictionary: " + dictionary.size());
    }

    public static Map<String, String> getDictionaryMap() {
        return dictionary;
    }

//        public static void main(String args[]) {
//
//        Dictionary D = new Dictionary();
//        insertWord("word", "meaning");
//        searchWord("word");
//
//    }
    public static String insertWord( String word, String definition) {
        if(dictionary.containsKey(word)) {
            return MessageFormat.format("Insertion failed. {0} already exists in the dictionary",word);
        }
        else {
//        System.out.println("I have been invoked.");
//            System.out.println(dictionary.size());
            dictionary.put(word, definition);
//            System.out.println(dictionary.size());
            return MessageFormat.format("{0} inserted successfully",word);
        }
    }
    public static String searchWord(String wordToSearch) {
        if (dictionary.containsKey(wordToSearch)) {
//            System.out.println(MessageFormat.format("Word: {0}\nDefinition: {1}",wordToSearch, dictionary.get(wordToSearch)));
            return dictionary.get(wordToSearch);
        }
        else {
//            System.out.println(MessageFormat.format("{0} is not in the dictionary.", wordToSearch));
            return MessageFormat.format("{0} is not in the dictionary.", wordToSearch);
        }
    }

    public static String deleteWord(String wordToDelete) {
        if(dictionary.containsKey(wordToDelete)) {
//            System.out.println("Deletion. Start" +dictionary.size());
            dictionary.remove(wordToDelete);
//            System.out.println("Deletion. End" +dictionary.size());
            return MessageFormat.format("{0} deleted successfully", wordToDelete);
        }
        else {
//            System.out.println(MessageFormat.format("{0} does not exist in the dictionary.", wordToDelete));
            return MessageFormat.format("{0} is not in the dictionary", wordToDelete);
        }
    }
    public static String modifyWord(String wordToModify, String newMeaning) {
        if (dictionary.containsKey(wordToModify)) {
            dictionary.replace(wordToModify, newMeaning);
            return MessageFormat.format("{0} has been modified successfully",wordToModify);
        }
        else {
//            System.out.println(MessageFormat.format("{0} does not exist in the dictionary.", wordToModify));
            return MessageFormat.format("{0} does not exist in the dictionary.",wordToModify);
        }
    }
}
