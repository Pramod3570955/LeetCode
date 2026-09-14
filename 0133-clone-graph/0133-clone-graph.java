class Solution {

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        return dfs(node);
    }

    private Node dfs(Node node) {

        // 1. null check
        if(node == null){
            return null;
        }

        // 2. already cloned?
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // 3. create clone
        Node clone = new Node(node.val);

        // 4. put original -> clone
        map.put(node, clone);

        // 5. process all neighbors
        for (Node neighbor : node.neighbors){
            Node clonedNeighbor = dfs(neighbor);
            clone.neighbors.add(clonedNeighbor);
        }

        // 6. return clone
        return clone;
    }
}