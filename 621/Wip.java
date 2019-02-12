class Solution {
    class Node implements Comparable {
        char ch;
        int count;
        
        @Override
        public int compareTo(Object obj) { 
            assert (obj instanceof Node);
            Node other = (Node) obj;
            if (this.count < other.count) return 1; // Sort from large to small
            else if (this.count == other.count) return 0;
            else return -1; // Sort from large to small
        }
    }
    
    char IDLE;
    
    public int leastInterval(char[] tasks, int n) {
        IDLE = '~';
        
        // 1. Count and Sort the # of each tasks
        // 2. Greedily fill/extend the output list
        Node[] counts = new Node[26];
        for (int i = 0; i < 26; i++) {
            counts[i] = new Node();
            counts[i].ch = (char)('A'+i);
            counts[i].count = 0;
        }
        for (char task: tasks) {
            counts[task-'A'].count++;
        }
        Arrays.sort(counts);
        List<Character> list = new ArrayList<>();
        for (Node node: counts) {
            System.out.println(node.ch + " " + node.count);
            int lastIdx = -1; // The index of the last inserted task of the same type as node.ch
            for (int i = 0; i < node.count; i++) { // Insert all tasks of the type: node.ch
                // Invariant: the task is not yet inserted, and list is a valid arrangement
                // Find the first empty slot to insert this task, whose index should be at least lastIdx+n (when lastIdx is not -1)
                boolean find = false;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == IDLE) {
                        if (lastIdx==-1 || (lastIdx!=-1 && j>lastIdx+n)) {
                            list.set(j, node.ch);
                            lastIdx = j;
                            find = true;
                            break;
                        }
                    }
                }
                // If cannot find the first empty slot, then append this task to the end
                // But we also need to make sure the list is a valid arrangement after the append
                if (!find) {
                    if (lastIdx == -1) {
                        ;
                    } else { // Fill in IDLE slots from the lastIdx
                        int listSize = list.size();
                        for (int j = 0; j < n; j++) { // Count n nodes
                            if (lastIdx+j+1 >= listSize) { // Node with index lastIdx+j+1 should exist in the output list
                                list.add(IDLE);
                            }
                        }
                    }
                    list.add(node.ch);
                    lastIdx = list.size()-1;
                }
                // Invariant: the task is inserted, and list is a valid arrangement
                // assert (list.get(list.size()-1) != IDLE);
            }
        }
        for (int i = 990; i < list.size(); i++) {
            // if (list.get(i) == IDLE) System.out.println(i);
            System.out.println(list.get(i));
        }
        return list.size();
    }
}
