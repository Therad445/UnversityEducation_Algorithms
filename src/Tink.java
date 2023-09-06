import java.util.*;

public class Tink {

    PriorityQueue<Integer> availableShelves = new PriorityQueue<>();
    Map<Integer, Integer> itemToShelfMap = new HashMap<>();

    public static void main(String[] args) {
        Tink s = new Tink();
        s.solve();
    }

    void solve() {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();

        for (int i = 1; i <= m * 2; i++) {
            availableShelves.add(i);
        }

        while (m-- > 0) {
            String event = in.next();
            int x = in.nextInt();
            if (event.equals("+")) {
                int shelf = availableShelves.poll();
                itemToShelfMap.put(x, shelf);
                System.out.println(shelf);
            } else {
                int shelf = itemToShelfMap.get(x);
                availableShelves.add(shelf);
                itemToShelfMap.remove(x);
            }
        }
        in.close();
    }
}
