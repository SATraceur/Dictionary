package dictionary;

import java.util.Collection;
import java.util.Iterator;

public class DictionaryTest {

    public static void main(String[] args) {
        
        String testNumber = args[0];
        System.out.println("Performing Test: " + testNumber);

        switch (testNumber) {
            case "1":
                testcp1(args[1],args[2]);
                break;
            case "2":
                testcp2(args[1]);
                break;
            case "3":
                // DictionaryTest 3 word-freq.txt "there more appertain orange I i aaaarrrrghh" there aaaarrrrghh "0 aaaarrrrghh 1222422"
                testcp3(args[1],args[2],args[3],args[4],args[5]);
                break;
            case "4":
                testcp4(args[1], args[2]);
                break;
            case "5":
                testcp5(args[1]);
                break;
            case "6":
                testcp6(args[1]);
                break;
            default:
                System.out.println("invalid test number");
                break;

        }
    }

    private static void testcp1(String fileName, String word) {
        Dictionary d = Dictionary.readInDictionary(fileName); 
        System.out.println(d.lookup(word));
    }
    
    private static void testcp2(String input)
    {
        
        DictionaryData data = new DictionaryData(input);
        System.out.println(data);
    }
    
    private static void testcp3(String fileName, String words, String removeWord, String newWord, String newWordData) {
        
        Dictionary d = Dictionary.readInDictionary(fileName);
        
        String[] keys = words.split(" ");

        // lookup each of the keys and print out what you find
        System.out.println("Testing contains...");
        for (String key : keys) {
            System.out.println(key + ": " +d.contains(key));
        }
        
        DictionaryData data = null;
        // lookup each of the keys and print out what you find
        System.out.println("Testing lookup...");
        for (String key : keys) {
            data = d.lookup(key);
            if (data != null) {
                System.out.println(data);
            } else {
                System.out.println(key + ": Not found");
            }
        }

        
        System.out.println("Testing remove...");
        // remove one of them
        d.remove(removeWord);

        // now do it again
        for (String key : keys) {
            data = d.lookup(key);
            if (data != null) {
                System.out.println(data);
            } else {
                System.out.println(key + ": Not found");
            }
        }

        System.out.println("Testing insert...");
        DictionaryData newD = new DictionaryData(newWordData);
	d.insert(newWord, newD);
        
        // now do it again
        for (String key : keys) {
            data = d.lookup(key);
            if (data != null) {
                System.out.println(data);
            } else {
                System.out.println(key + ": Not found");
            }
        }

    }

    private static void testcp4(String filename, String fileToCheck) {
        
        Dictionary d = Dictionary.readInDictionary(filename);
        
        System.out.println(d.spellCheck(fileToCheck));
    }

    private static void testcp5(String fileName) {
        
        Dictionary d = Dictionary.readInDictionary(fileName);
        
        // print out the first 20 words in alphabetical order
        DictionaryData data = null;
        Collection<DictionaryData> lA = d.alphabeticalList();
        if (lA != null) {
            Iterator<DictionaryData> itA = lA.iterator();
            for (int i = 0; i < 20; i++) {
                data = itA.next();
                System.out.println(data);
            }
        }
    }

    private static void testcp6(String fileName) {
        
        Dictionary d = Dictionary.readInDictionary(fileName);
        
        DictionaryData data = null;
        
        // print out the first 20 words in frequency order
        Collection<DictionaryData> lF = d.frequencyOrderedList();
        if (lF != null) {
            Iterator<DictionaryData> itF = lF.iterator();
            for (int i = 0; i < 20; i++) {
                data = itF.next();
                System.out.println(data);
            }
        }
    }

    
}
