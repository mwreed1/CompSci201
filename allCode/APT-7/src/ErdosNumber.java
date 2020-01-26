import java.util.*;

public class ErdosNumber {
    TreeMap<String, Set<String>> myGraph = new TreeMap<String, Set<String>>();
    TreeMap<String, Integer> myDistance = new TreeMap<String, Integer>();

    public String[] calculateNumbers(String[] pubs) {
        makeGraph(pubs);
        ArrayList<String> list = new ArrayList<>();
        bfsErdos();
        for (String s : myGraph.keySet()) {
            if (myDistance.containsKey(s)) {
                int ret = myDistance.get(s);
                s = s + " " + ret;
            }
            list.add(s);
        }
        return list.toArray(new String[0]);
    }

    private void makeGraph(String[] pubs) {
        for (String pub : pubs) {
            List<String> auts = Arrays.asList(pub.split(" "));
            for (String aut : auts) {
                Set<String> set = new HashSet<>(auts);
                myGraph.putIfAbsent(aut, set);
                myGraph.get(aut).addAll(set);
                myGraph.get(aut).remove(aut);
            }
        }
    }

    private void bfsErdos() {
        Set<String> visited = new TreeSet<>();
        Queue<String> qu = new LinkedList<>();
        String str = "ERDOS";
        visited.add(str);
        myDistance.put(str, 0);
        qu.add(str);
        while (qu.size() > 0) {
            str = qu.remove();
            visited.add(str);
            for (String adj : myGraph.get(str)) {
                if (!visited.contains(adj)) {
                    visited.add(adj);
                    qu.add(adj);
                    myDistance.put(adj, myDistance.get(str) + 1);
                }
            }
        }
    }


}