import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FriendScore {
    Map<Integer, Set<Integer>> myGraph = new HashMap<Integer, Set<Integer>>();;
    private Set<Integer> twoFriends(int index){
        Set<Integer> set = new TreeSet<>();
        Set<Integer> friends = myGraph.get(index);
        set.addAll(friends);
        for(int friend: friends){
            set.addAll(myGraph.get(friend));
        }
        set.remove(index);
        return set;
    }
    public int highestScore(String[] friends) {
        int best = 0;
        for(int k = 0; k< friends.length; k++){
            String friend = friends[k];
            String[] list = friend.split("");
            Set<Integer> set = new TreeSet<>();
            set.add(k);
            myGraph.put(k, set);
            for(int i = 0; i< list.length; i++){
                if(k !=i && list[i].equals("Y")){
                    myGraph.get(k).add(i);
                }
            }
        }
        for(int j = 0; j< friends.length; j++){
            if(twoFriends(j).size() > best) best = twoFriends(j).size();
        }
        return best;
    }
}