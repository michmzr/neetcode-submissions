class PrefixTree {
    class Node {
        char c;
        Node[] nodes;
        boolean stop = false;

        public boolean hasSubnodes() {
            return nodes != null && nodes.length > 0;
        }

        public Node addNode(char c) {
            Node child = new Node();
            child.nodes = null;
            child.c=c;

            if(!hasSubnodes()) {
                nodes = new Node[32];
            }

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
        root.nodes = new Node[32];
    }

    public void insert(String word) {
        Node parent = root;
        Node curr = root;

        for(int i=0; i< word.length();i++) {
            char c = word.charAt(i);

            if(curr.hasSubnodes()) {
                curr = curr.nodes[c-'a'];

                if(curr == null) {
                    curr = parent.addNode(c);
                }
            } else {
                curr= parent.addNode(c);
            }

            parent = curr;
        }

        curr.stop = true;
    }

    public boolean search(String word) {
        Node curr = root;
        curr = curr.getSub(word.charAt(0));

        if(curr == null)
            return false;

        for(int i=1; i< word.length();i++) {
            char c = word.charAt(i);

            var next = curr.getSub(c);
            if(next != null) {
                curr = next;
            }else if(i < word.length()-1 ) {
                return false;
            }
        }

        return curr.c == word.charAt(word.length() - 1) && curr.stop;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        curr = curr.getSub(prefix.charAt(0));

        if(curr == null)
            return false;

        for(int i=1; i< prefix.length();i++) {
            char c = prefix.charAt(i);

            var next = curr.getSub(c);
            if(next != null) {
                curr = next;
            }else if(i < prefix.length()-1 ) {
                return false;
            }
        }

        return curr.c == prefix.charAt(prefix.length() - 1);
    }

}
