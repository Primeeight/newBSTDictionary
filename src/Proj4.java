import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *Project4
 * @author Zachary Nelson
 * 11/10/21
 */
public class Proj4 {
    static int compCount = 0;
    static String[] dictionary = new String[235886];
    //incorrectly spelled words.
    static int incwords = 0;
    //correctly spelled words.
    static int corwords = 0;
    static long compFound =0;
    static long compNotfound =0;
    public static void main(String[] args) {
        // call the first method to read the dictionary
        DictionaryReader();
        // call the second method to read the file.
        FileReader();
        System.out.println("incorrect words :" +incwords);
        System.out.println("correct words :" + corwords);
        System.out.println("comparisons for correct words: " +compFound);
        System.out.println("comparisons for incorrect words: " +compNotfound);
        System.out.println("The average comparisons per words found: " +(double)compFound/corwords);
        System.out.println("The average comparisons per words not found: " +(double)compNotfound/incwords);

        // see below for descriptions of the two methods
        // output the counters and the two averages (see assignment)

    }

    public static String[] DictionaryReader() {//parses the dictionary, and returns the words used in the search.
        //File Reading
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\dddwe\\IdeaProjects\\Project4\\dictionary.txt"
            ));
            int i = 0;
            String row;

            while ((row = csvReader.readLine()) != null) {
                dictionary[i] = row.toLowerCase();
                i++;
            }
            // System.out.println(dictionary[dictionary.length-1]);
        } catch (IOException ex) { //print error here.
            ex.printStackTrace();
        }
        return dictionary;
    }

    public static void FileReader() {
        try {
            BufferedReader inf = new BufferedReader(new FileReader("C:\\Users\\dddwe\\IdeaProjects\\Project4\\oliver.txt"
            ));
            char let;
            String str = "";
            int n = 0;

            while ((n = inf.read()) != -1) { //read one character as an ASCII int from input file ( remember try/catch in file processing!!!)
                let = (char) n; //convert the int to a char
                if (Character.isLetter(let)){// See Character class (Chapter 4.3, Edition 11)
                    //convert the let to lowercase and concatenate to the variable str
                    let = Character.toLowerCase(let);
                    //Character.toString(let);
                    str = str + let;
                }
                else if ((Character.isWhitespace(let) || let == '-') && !str.isEmpty()){
                    //process str; variable str is a single word now.
                    //comparisons occur per word inside the RecursiveBinarySearch
                    //Fix should add let into string into word is formed. Then check that against Recursive Binary
                    //Set compCount to 0 before search.
                    compCount = 0;
                    if (RecursiveBinarySearch(str) < 0) {
                        //word is not in the dictionary and count it as a word not found
                        incwords++;
                        compNotfound+= compCount;
                    } else {
                        //count it as a word found.
                        corwords++;
                        compFound+= compCount;
                    }
                    str = ""; //reset str to empty
                }

            }
        } catch (IOException ex) { //print error here.
            ex.printStackTrace();
        }
    }
    public static int RecursiveBinarySearch (String key){//Finds the key in the whole list
        int low = 0;
        int high = dictionary.length - 1;
        return RecursiveBinarySearch(key, low, high);
    }

    public static int RecursiveBinarySearch ( String key, int low, int high){//Finds the key in the subset
        if (low > high) {//The list has been exhausted without a match.
            return -low - 1;
        }
        int mid = (low + high) / 2;
        if (key.compareTo(dictionary[mid])<0 ) {//compare to method.
            compCount ++;
            return RecursiveBinarySearch( key, low, mid - 1);
        } else if (key.compareTo(dictionary[mid])== 0) {
            compCount ++;
            return mid;
        } else {
            return RecursiveBinarySearch(key, mid + 1, high);
        }
    }
}