import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q0743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int res = -1;
        int timesLen = times.length;

        int currNode;
        int[] curr;
        int src;
        int dest;
        int cost;

        ArrayList<ArrayList<int[]>> adjlist = new ArrayList<>();
        ArrayList<int[]> currAdj;

        for (int i = 0; i < n + 1; i++) {
            adjlist.add(new ArrayList<>());
        }

        for (int i = 0; i < timesLen; i++) {
            curr = times[i];
            src = curr[0];
            adjlist.get(src).add(curr);
        }

        int adjlen;

        int[] shortest = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            shortest[i] = -1;
        }
        shortest[k] = 0;


        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(k);

        while (!q.isEmpty()) {
            currNode = q.remove();
            currAdj = adjlist.get(currNode);
            adjlen = currAdj.size();

            for (int i = 0; i < adjlen; i++) {
                curr = currAdj.get(i);
                src = curr[0];
                dest = curr[1];
                cost = curr[2];

                if (src == currNode) {

                    if (shortest[dest] == -1) {
                        shortest[dest] = shortest[currNode] + cost;
                        q.add(curr[1]);
                    } else {
                        if (shortest[currNode] + cost < shortest[dest]) {
                            shortest[dest] = shortest[currNode] + cost;
                            q.add(dest);
                        }
                    }

                }
            }

        }

        for (int i = 1; i < n + 1; i++) {
            if (shortest[i] == -1)
                return -1;

            res = Math.max(shortest[i], res);
        }

        return res;
    }

}