public class FilterTreeCount {
    public int count(TreeNode tree, int low, int high) {
        int ret;
        if(tree == null) return 0;
        if(tree.left == null && tree.right == null){
            if(high >= tree.info && low <= tree.info) return 1;
            return 0;
        }
        int l = count(tree.left, low, high);
        int r = count(tree.right, low, high);
        if(high >= tree.info && low <= tree.info) ret = 1;
        else{ret = 0;}
       return ret + l + r;
    }
}