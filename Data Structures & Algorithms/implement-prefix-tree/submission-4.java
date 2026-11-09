class PrefixTree {
  class Node {
        Node[] nodes;
        boolean stop = false;

        public boolean hasSubnodes() {
            return nodes != null && nodes.length > 0;
        }

        Node() {
            stop = false;
            nodes = new Node['z'-'a' +1] ;
        }

        public boolean hasNode(char c) {
            return nodes[c-'a'] != null;
        }

        public Node addNode(char c) {
            Node child = new Node();
            nodes[c-'a'] = child;

            return child;
        }

        public Node getSub(char c) {
            if(!hasSubnodes())
                return null;

            return nodes[c-'a'];
        }
    }

    private final Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;

        for(char c: word.toCharArray()) {
            if(curr.hasNode(c)) {
                curr = curr.getSub(c);
            }else {
                curr = curr.addNode(c);
            }
        }
        curr.stop = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for(char c: word.toCharArray()) {
            var next = curr.getSub(c);

            if(next != null) {
                curr = next;
            }else {
                return false;
            }
        }

        return curr != null & curr.stop;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;

        for(char c: prefix.toCharArray()) {
            var next = curr.getSub(c);

            if(next != null) {
                curr = next;
            }else {
                return false;
            }
        }

        return curr != null;
    }

}
