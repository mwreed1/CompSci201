import java.util.ArrayList;
import java.util.Collections;

public class SortedLeaves {
    ArrayList<String> myList = new ArrayList<String>();
    public void doWork(TreeNode tree){
        if (tree == null) return;
        if (tree.left == null && tree.right == null) {
            myList.add("" + ((char)tree.info));
        }
        else {
            doWork(tree.left);
            doWork(tree.right);
        }
    }
    public String[] values(TreeNode tree) {
        doWork(tree);
        Collections.sort(myList);
        String[] ret;
        ret = myList.toArray(new String[0]);
        return ret;
    }
}