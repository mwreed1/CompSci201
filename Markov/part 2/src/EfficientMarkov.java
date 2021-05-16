import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class EfficientMarkov extends BaseMarkov {
	private Map<String, ArrayList<String>> myMap;


	public EfficientMarkov(int order) {
		super(order);
		myMap =  new HashMap<String, ArrayList<String>>();
	}
	public EfficientMarkov() {
		this(3);
		this.myMap = myMap;
	}
	@Override
	public ArrayList<String> getFollows(String key){
		ArrayList<String> follows = new ArrayList<String>();
		follows = myMap.get(key);
		if(follows == null) throw new NoSuchElementException(key+" not in map");
		return follows;
	}
	@Override
	public void setTraining (String text){

		super.setTraining(text);
		myMap.clear();
		for (int i = 0; i <= myText.length() - myOrder; i++) {
			String sub = myText.substring(i, i + myOrder);
			ArrayList<String> aft = new ArrayList<String>();
			myMap.putIfAbsent(sub, aft);
			if(i + myOrder == myText.length()) myMap.get(sub).add(PSEUDO_EOS);
			else{myMap.get(sub).add(myText.substring(i + myOrder, i + myOrder +1));}
		}
	}

}

