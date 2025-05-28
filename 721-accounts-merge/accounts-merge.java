import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                graph.putIfAbsent(email, new HashSet<>());
                if (i > 1) {
                    String prev = account.get(i - 1);
                    graph.get(email).add(prev);
                    graph.get(prev).add(email);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();

        // DFS traversal
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> emails = new ArrayList<>();
                Deque<String> stack = new ArrayDeque<>();
                stack.push(email);

                while (!stack.isEmpty()) {
                    String node = stack.pop();
                    if (visited.contains(node)) continue;
                    visited.add(node);
                    emails.add(node);
                    for (String neighbor : graph.get(node)) {
                        if (!visited.contains(neighbor)) {
                            stack.push(neighbor);
                        }
                    }
                }

                Collections.sort(emails);
                emails.add(0, emailToName.get(email)); // Prepend name
                res.add(emails);
            }
        }

        return res;
    }
}
