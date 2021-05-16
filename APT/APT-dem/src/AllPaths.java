import java.util.ArrayList;
import java.util.Comparator;
public class AllPaths {
    private ArrayList<String> list = new ArrayList<>();
    public String[] paths(TreeNode tree) {
        initList(tree,"");
        list.sort(Comparator.naturalOrder());
        String[] ret = list.toArray(new String[0]);
        return ret;
    }
    public void initList(TreeNode tree, String path){
        if(tree == null) return;
        if(tree.right == null && tree.left == null){
            list.add(path + tree.info);
            return; //Use return; for void methods with recursion
        }
        initList(tree.left, path + tree.info + "->");
        initList(tree.right, path + tree.info + "->");
    }
}
