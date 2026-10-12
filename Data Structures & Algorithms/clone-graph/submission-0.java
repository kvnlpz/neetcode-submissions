
public class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> clonedMap = new HashMap<>();
        return dfs(node, clonedMap);
    }

    private Node dfs(Node node, Map<Node, Node> clonedMap) {
        if (node == null) {
            return null;
        }

        if (clonedMap.containsKey(node)) {
            return clonedMap.get(node);
        }

        Node copy = new Node(node.val);
        clonedMap.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, clonedMap));
        }

        return copy;
    }
}