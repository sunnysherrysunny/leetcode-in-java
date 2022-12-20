public class Q0739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] prevTemps = new int[101];
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int temperature = temperatures[i];
            for (int j = temperature + 1; j <= 100; j++) {
                if (prevTemps[j] != 0) {
                    if (res[i] == 0) {
                        res[i] = prevTemps[j] - i;
                    } else {
                        res[i] = Math.min(res[i], prevTemps[j] - i);
                    }
                    if (res[i] == 1) {
                        break;
                    }
                }
            }
            prevTemps[temperature] = i;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76,
                73});
        System.out.println("stop");
    }

}


