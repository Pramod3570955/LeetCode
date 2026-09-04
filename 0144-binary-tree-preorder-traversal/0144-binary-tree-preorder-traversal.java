class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer>l1=new ArrayList<>();
        preorder(root,l1);
        return l1;
    }  
    public void preorder(TreeNode root,List<Integer> l1){
        if(root == null)
        return;
        l1.add(root.val);
        preorder(root.left,l1);
        
        preorder(root.right, l1);
    }
}