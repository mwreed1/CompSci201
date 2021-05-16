import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class EfficientWordMarkov  extends BaseWordMarkov {
        private Map<WordGram, ArrayList<String>> myMap;


        public EfficientWordMarkov(int order) {
            super(order);
            myMap =  new HashMap<WordGram, ArrayList<String>>();
        }
        public EfficientWordMarkov() {
            this(3);
            this.myMap = myMap;
        }
    @Override
    public ArrayList<String> getFollows(WordGram key){
        ArrayList<String> follows = new ArrayList<String>();
        follows = myMap.get(key);
        if(follows == null) throw new NoSuchElementException(key+" not in map");
        return follows;
    }
    @Override
    public void setTraining (String text){

        super.setTraining(text);
        myWords = text.split("\\s+");
        myMap.clear();
        for (int i = 0; i <= myWords.length - myOrder; i++) {
            WordGram current = new WordGram(myWords,i,myOrder);
            ArrayList<String> aft = new ArrayList<String>();
            myMap.putIfAbsent(current, aft);
            if(i + myOrder == myWords.length) myMap.get(current).add(PSEUDO_EOS);
            else{myMap.get(current).add(myWords[i + myOrder]);}
        }
    }

    }

