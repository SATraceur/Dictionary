package dictionary;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dictionary {

    private Map<String, DictionaryData> dictionaryMap;

    public Dictionary() { 
        dictionaryMap = new TreeMap<String, DictionaryData>();
    }

    public void insert(String s, DictionaryData data) { 
        dictionaryMap.put(s.toLowerCase(), data); 
    }

    public DictionaryData remove(String s) {
        dictionaryMap.remove(s.toLowerCase());
        return null;
    }

    public DictionaryData lookup(String s) { 
       return dictionaryMap.get(s.toLowerCase());
    }

    public boolean contains(String key) {
        return dictionaryMap.containsKey(key.toLowerCase()) ? true : false;
    }

    public static Dictionary readInDictionary(String fileName) {
        Dictionary d = new Dictionary();
        Scanner fileScanner;

        try {
            // use a FileInputStream to ensure correct reading end-of-file
            fileScanner = new Scanner(new FileInputStream(fileName));

            while (fileScanner.hasNextLine()) {
                String nextLine = fileScanner.nextLine();
                DictionaryData data = new DictionaryData(nextLine);
                d.insert(data.getWord(), data);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return d;
    }

    public List<String> spellCheck(String fileName) {
        Scanner fileScanner;
        List<String> names = new ArrayList<>();
        
        try {
            fileScanner = new Scanner(new FileInputStream(fileName));

            while (fileScanner.hasNextLine()) {
                String nextLine = fileScanner.nextLine();
              
                if (nextLine.length() == 0) {continue;} // If line is whitespace, restart loop skipping processing 
                String[] info = nextLine.split(" ");   
                
                for(int i = 0; i < info.length; i++) {
                    if(!dictionaryMap.containsKey(info[i].toLowerCase())) {
                        names.add(info[i]);
                    }
                } 
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return names;
    }

    public Collection<DictionaryData> alphabeticalList() {
        List<DictionaryData> list = new ArrayList<>(dictionaryMap.values());
        return list;
    }

    public Collection<DictionaryData> frequencyOrderedList() {
        List<DictionaryData> list = new ArrayList<>(dictionaryMap.values());
        Collections.sort(list);
        return list;
    }

}
