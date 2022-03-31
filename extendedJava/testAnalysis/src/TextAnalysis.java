import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TextAnalysis implements TextCompare{
    String text;
    public TextAnalysis(String t){
        text = t;
    }

    //returns the number of words in the text
    @Override
    public int numberOfWords() {
        Scanner scan = new Scanner(text);
        int words = 0;
        while (scan.hasNextLine()) {
            if (scan.hasNext()) {
                String word = scan.next();
                words++;
            }
        }
        return words;
    }

    //returns true if a word is in the text
    @Override
    public boolean wordInText(String word) {
        return text.contains(word);
    }

    //finds the longest word length and returns the length
    @Override
    public int getLongestWordLength() {
        String longestWord = Arrays.stream(text.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

        System.out.println("The longest word is: "+longestWord);
        if (longestWord != null) {
            return longestWord.length();
        }
       return 0;
    }

    //returns true if Text has more words in it than the text provided as an argument
    @Override
    public boolean longestByWord(String otherText) {
        Scanner sc = new Scanner(otherText);
        int wordsNumber = 0;
        while (sc.hasNextLine()){
            if(sc.hasNext()){
                String words = sc.next();
                wordsNumber++;
            }
        }
        return wordsNumber<numberOfWords();
    }
}

interface TextCompare{
    //returns the number of words in the text
    public int numberOfWords();

    //returns true if a word is in the text
    public boolean wordInText(String word);

    //finds the longest word length and returns the length
    public int getLongestWordLength();

    //returns true if Text has more words in it than the text provided as an argument
    public boolean longestByWord(String otherText);

}

class testText{
    public static void main(String[] args) {
        TextAnalysis ta = new TextAnalysis(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod "
                +"tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation "
                +"ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in "
                +"voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, "
                +"sunt in culpa qui officia deserunt mollit anim id est laborum.");

       // you can write some testing code here...
        TextAnalysis t2 = new TextAnalysis("Okay so which is the biggest word");
        System.out.println(t2.longestByWord("Okay so which is the biggest"));
    }
}
