import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Project 10
 * Implement a spell checker with a randomized dictionary composed of Binary Search Trees.
 * 7/27/22
 * Zachary Nelson
 */
public class bstDictionary {
    static long wordsFound = 0;
    static long wordsNotFound = 0;
    static long compsFound = 0;
    static long compsNotFound = 0;
    static String[] word = new String[0];
    static String[] srcWord = new String[0];


    /**
     * Create an array of 26 Binary Search Trees.
     * Impliment comparisons using DictionaryReader and FileReader
     * Calculate averages.
     * @param args
     */
    public static void main(String[] args) {

        //Create and instansiate an array of 26 Binary Search Trees.
        BinarySearchTree [] dictionary = new BinarySearchTree[26];
        for (int i = 0; i < dictionary.length; i++)
            dictionary[i] = new BinarySearchTree<String>();

        DictionaryReader();
        for (int i = 0; i < word.length; i++) {
            dictionary[(int) wordstr.charAt(0) - 97].insert(wordstr);

        }
        FileReader();
        for (int i = 0; i < srcWord.length; i++) {
            if (srcWord[i] == null) {
                System.out.println("Reached the end of the file");
                break;

            } else {

                int dictIndex = (srcWord[i].charAt(0) - 97);
                if (list[dictIndex].contains(srcWord[i])) {
                    //System.out.println(dictIndex);
                    wordsFound++;
                    compsFound += i;
                } else {
                    wordsNotFound++;
                    compsNotFound += i;
                }

            }
        }

        //Calculate the averages.
        long avgcompswordsfound = compsFound / wordsFound;
        long avgcompswordsnotfound = compsNotFound / wordsNotFound;
        System.out.print("The average words found is " + avgcompswordsfound + " and the average words not found is " + avgcompswordsnotfound);
    }
    //Parse the dictionary, return an array of words used in the search.
    public static String[] DictionaryReader() {
        //File Reading
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\Zach\\IdeaProjects\\newBSTDictionary\\src\\random_dictionary.txt"));
            int i = 0;
            String row;

            while ((row = csvReader.readLine()) != null) {
                word[i] = row.toLowerCase();
                i++;
            }

        } catch (IOException ex) { //print error here.
            ex.printStackTrace();
        }
        return word;
    }
    //Parses the file to be read using the method in Project 4.
    //Returns an array of words to be searched.
    public static String[] FileReader() {
        try {
            BufferedReader inf = new BufferedReader(new FileReader("C:\\Users\\Zach\\IdeaProjects\\Project1\\src\\oliver.txt"));
            char let;
            String str = "";
            int n = 0;
            int i = 0;

            while ((n = inf.read()) != -1) { //read one character as an ASCII int from input file ( remember try/catch in file processing!!!)
                let = (char) n; //convert the int to a char
                if (Character.isLetter(let)) {// See Character class (Chapter 4.3, Edition 11)
                    //convert the let to lowercase and concatenate to the variable str
                    let = Character.toLowerCase(let);
                    //Character.toString(let);
                    str = str + let;
                } else if ((Character.isWhitespace(let) || let == '-') && !str.isEmpty()) {
                    //process str; variable str is a single word now.
                    //comparisons occur per word inside the RecursiveBinarySearch
                    //Fix should add let into string into word is formed.
                    srcWord[i] = str;
                    i++;


                    str = ""; //reset str to empty
                }
            }
        } catch (IOException ex) { //print error here.
            ex.printStackTrace();
        }
        return srcWord;
    }
}
