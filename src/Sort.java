import java.io.FileWriter;
import java.util.ArrayList;

public class Sort extends Dictionary {
    public Sort() {
        String[] words = getDictionaryMap().keySet().toArray(new String[0]);
        String temp;
        ArrayList<String> sortedWords = new ArrayList<>();
        ArrayList<String> sortedMeanings = new ArrayList<>();
        for (int i=0; i<words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].compareTo(words[j]) > 0) {
                    // swapping
                    temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        for (String word : words) {
            sortedWords.add(word);
            sortedMeanings.add(getDictionaryMap().get(word));
//            System.out.println(word);
        }
//        System.out.println(sortedWords.get(0));
//        System.out.println(sortedMeanings.get(0));

        try{
            FileWriter fw = new FileWriter("/PATH/TO/YOUR/dictionary.txt");
            for (int w=0; w<sortedWords.size(); w++) {
                fw.write(sortedWords.get(w) + " " + sortedMeanings.get(w) + "\n");
            }
            fw.close();
        }catch(Exception e){System.out.println(e);}
        System.out.println("Success...");

}

    public static void main(String[] args) {
        new Sort();
    }
}
