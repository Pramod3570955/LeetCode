class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer>l1=new ArrayList<>();
        inorder(root,l1);
        return l1;
    }  
    public void inorder(TreeNode root,List<Integer> l1){
        if(root == null)
        return;
        inorder(root.left,l1);
        l1.add(root.val);
        inorder(root.right, l1);
    }
}