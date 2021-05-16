import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;



public class MaxLeaves {
    //TreeMap<Integer,Boolean> myMap = new TreeMap<>();
    List<Integer> list = new ArrayList<Integer>();
    public int height(TreeNode tree) {
        if (tree == null) return 0;
        return 1 + Math.max(height(tree.left), height(tree.right));
    }

    public int[] gather(TreeNode tree) {
        int cor = height(tree);
        doWork(tree, cor);
        //for(int k : myMap.keySet()){ if(myMap.get(k)) list.add(k); }
        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

    private void doWork(TreeNode t, int max){
        if (t == null) return;
        if(t.left == null && t.right == null) {
            list.add(t.info);
        }
            doWork(t.left, max);
            doWork(t.right, max);
    }
}