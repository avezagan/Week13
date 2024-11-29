import java.util.*;

public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        int visitedCount = 1;

        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.add(key);
                    visitedCount++;
                }
            }
        }
        return visitedCount == rooms.size();
    }

    public static void main(String[] args) {
        // Number of rooms is fixed to 4
        int n = 4;

        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> rooms = new ArrayList<>();
        System.out.println("Enter the keys for each of the 4 rooms (space-separated):");

        for (int i = 0; i < n; i++) {
            System.out.println("Keys in room " + i + ": ");
            String input = scanner.nextLine().trim();
            List<Integer> roomKeys = new ArrayList<>();

            if (!input.isEmpty()) {
                String[] keys = input.split(" ");
                for (String key : keys) {
                    if (!key.isEmpty()) { // Ignore blank values, will not return exception error
                        try {
                            roomKeys.add(Integer.parseInt(key));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input: " + key);
                        }
                    }
                }
            }
            rooms.add(roomKeys);
        }
        Solution sol = new Solution();
        boolean result = sol.canVisitAllRooms(rooms);
        System.out.println("Can visit all rooms: " + result);
    }
}