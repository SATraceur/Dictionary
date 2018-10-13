package dictionary;

public class DictionaryData  implements Comparable<DictionaryData> {

    private String word;
    private int frequency;
    
    public DictionaryData(String line)
    {
        String[] info = line.split(" ");  
        word = info[1];
        frequency = Integer.valueOf(info[2]); 
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }
    
    @Override
    public String toString() {
        return word + ": frequency = " + frequency;
    }

    @Override
    public int compareTo(DictionaryData o) { 
        if(frequency > o.frequency) { return 1;}
        else if(frequency < o.frequency) { return -1;}
        else {
            if(word.compareTo(o.word) < 0) {return 1;}
            else if(word.compareTo(o.word) > 0) {return -1;}
            else {return 0;}
        }  
    }    
}
