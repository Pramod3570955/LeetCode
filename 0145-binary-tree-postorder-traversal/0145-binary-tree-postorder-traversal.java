class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer>l1=new ArrayList<>();
        postorder(root,l1);
        return l1;
    }  
    public void postorder(TreeNode root,List<Integer> l1){
        if(root == null)
        return;
        
        postorder(root.left,l1);
        
        postorder(root.right, l1);
        l1.add(root.val);
    }
}