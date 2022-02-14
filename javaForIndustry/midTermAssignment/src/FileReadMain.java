/*THIS IS QUESTION 2 OF THE ASSIGNMENT!!!!

I'VE COMPLETED ALL THE QUESTIONS AND PARTS EXCEPT FOR THE EXTENSION AND HAVE WRITTEN ALL THE COMMENTS ACCURATELY.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileReadMain {
    //Using Scanner to read the file
    //Path of the file
    public static File fileName = new File("./Metamorphosis.txt");
    static Scanner scan = null; //Setting it up to null at the beginning

    public static void main(String[] args) throws IOException {
        //Creating integers to store the number of occurrences
        int letters = countLetters(scan);
        int words = countWords(scan);
        int sentences = 0;
        int paragraphs = 0;
        int characters = 0;


        FileInputStream fileInputStream = new FileInputStream(fileName);//Obtains input bytes from fileName
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);//Returns next byte of input
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//Reads text from inputStreamReader

        //Line which keeps on updating as we go through the loop
        String line;
        while ((line = bufferedReader.readLine()) != null) {//While the line is not null, run this loop
            //If the next line is empty, there's a paragraph
            if (line.equals("")) {
                paragraphs++;
            } else { //else, check for the number of sentence ends
                //Create an array of strings where elements are seperated into different indices after end of each sentence.
                String[] sentence = line.split("[!?.]");//Sentences end at !, ? or . only according to https://www.grammarly.com/blog/end-sentence-punctuation/
                sentences += sentence.length; //Add the sentence.length to sentences.
                characters+=line.length();
            }
        }
        //If there's only more than one paragraph, add 1 as the last paragraph won't have an empty line at the end
        if (sentences >= 1) {
            paragraphs++;
        }

        System.out.println("Number of charcters in this file are " + characters);
        System.out.println("Number of letters in this file are " + letters);
        System.out.println("Number of words in this file are " + words);
        System.out.println("Number of sentences in this file are " + sentences);
        System.out.println("Number of paragraphs in this file are " + paragraphs);

        //Calling the word frequency list
        frequencyList("./Metamorphosis.txt");

    }

    /**
    * Prints out the frequency of each word in the file
    * @param filePath: The path of the file in your device
    * */
    public static void frequencyList(String filePath) throws IOException {
        //Create input stream and scanner
        FileInputStream fin = new FileInputStream(filePath);
        Scanner fileInput= new Scanner(fin);

        //Creat an arraylist
        ArrayList<String> words= new ArrayList<String>();
        ArrayList<Integer> count = new ArrayList<Integer>();

        //Read through file and find the words
        while (fileInput.hasNext()){
            //Get the next word
            String nextWord = fileInput.next();

            //Replace all the apostrophes and the s next to it with empty space
            nextWord = nextWord.replaceAll("[’]", "");

            //Replace all the punctuation marks with empty string except "-" which is a compound word and is
            //considered to be a single word according to https://www.grammarly.com/blog/open-and-closed-compound-words/
            nextWord = nextWord.replaceAll("[^a-zA-Z0-9\\—]", " ");

            //Replace all the extra spaces with one space
            nextWord = nextWord.trim().replaceAll(" +", " ");

            //Lower-casing the word to make words like Hello=hello
            nextWord = nextWord.toLowerCase(Locale.ROOT);

            //Determine if the word is in the arraylist already
            if(words.contains(nextWord)){
                int index = words.indexOf(nextWord);//Find the index where the word is located
                count.set(index, count.get(index) + 1);//Sets the value at count's index to the current value+1
            } else { //If it isn't already a word added, we add a new word
                words.add(nextWord); //Add the word into the arraylist
                count.add(1); //Increase count
            }
        }

        for(int i = 0; i<words.size(); i++){
            //Uncomment the below to see the frequency list
//            System.out.println("The word: " + words.get(i) + " occurred " + count.get(i) + " times");
        }
    }

    /**
     * Returns the number of letters in a file
     * @param scan: Counts letters of the scanner provided
     * @returns: int letters: Number of letters in the file
     **/
    public static int countLetters(Scanner scan) {
        try { //Scanning the file
            scan = new Scanner(fileName);
        } catch (FileNotFoundException e) { //If file isn't found, do this:
            System.out.println("Can't find the file. Try changing the filePath");
            e.printStackTrace();
        }
        //Initialising letters = 0
        int letters = 0;

        while (scan.hasNext()) {//While there is a next line, run this loop
            String s = scan.nextLine();//Stores the next line in s
            char[] analysis = s.toCharArray();//Reducing the whole string s to characters.
            for (char element : analysis) {//For each character,
                if (Character.isLetter(element)) {//If the character is a letter,
                    letters++;//Add a letter
                }
            }
        }
        return letters;
    }

    /**
     *  Returns the number of words in the file
     * @param scan: Counts letters of the scanner provided
     * @returns: int words: Number of words in the file
    **/
    public static int countWords(Scanner scan) {
        try { //Scanning the file
            scan = new Scanner(fileName);
        } catch (FileNotFoundException e) { //If file isn't found, do this:
            System.out.println("Can't find the file. Try changing the filePath");
        }
        int words = 0;
        while (scan.hasNextLine()) {
            if (scan.hasNext()) {
                String word = scan.next();
                words++;
            }
        }
        return words;
    }
}