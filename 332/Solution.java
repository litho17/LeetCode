class Solution {
    List<String> path;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            List<String> toList = map.get(from);
            if (toList==null) toList = new LinkedList<>();
            toList.add(to);
            map.put(from, toList);
        }
        Map<String, ArrayList<Boolean>> visited = new HashMap<>();
        for (String from: map.keySet()) {
            List<String> toList = map.get(from);
            Collections.sort(toList);
            
            ArrayList<Boolean> visitedList = new ArrayList<>();
            for (int i=0; i<toList.size(); i++) {
                visitedList.add(false);
            }
            assert(visitedList.size()==toList.size());
            visited.put(from, visitedList);
        }
        List<String> tmp = new LinkedList<String>();
        tmp.add("JFK");
        assert(helper("JFK", map, visited, tmp, tickets.size()));
        return path;
    }
    
    boolean helper(String from, Map<String, List<String>> map, Map<String, ArrayList<Boolean>> visited, List<String> path, int len) {
        if (path.size()==len+1) {
            this.path = new LinkedList<String>(path);
            return true;
        }
        // Find the smallest to-airport that has not yet been visited
        List<String> toList = map.get(from);
        List<Boolean> visitedList = visited.get(from);
        if (toList==null||visitedList==null) return false;
        assert(toList.size()==visitedList.size());
        for (int i=0; i<toList.size(); i++) {
            if (!visitedList.get(i)) {
                String to = toList.get(i);
                visitedList.set(i, true);
                path.add(to);
                boolean success = helper(to, map, visited, path, len);
                if (success) return true;
                visitedList.set(i, false);
                path.remove(path.size()-1);
            }
        }
        return false;
    }
}

// Runtime: 10 ms, faster than 31.97% of Java online submissions for Reconstruct Itinerary.
// Memory Usage: 42.4 MB, less than 76.23% of Java online submissions for Reconstruct Itinerary.
