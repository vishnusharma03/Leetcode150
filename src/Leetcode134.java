package src;
 // Type: RR_N
public class Leetcode134 {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int ans = canCompleteCircuit(gas, cost);
        System.out.println(ans);
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int currentSurplus = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int surplus = gas[i] - cost[i];
            totalSurplus += surplus;
            currentSurplus += surplus;

            if (currentSurplus < 0) {
                startStation = i + 1;
                currentSurplus = 0;
            }
        }
        return totalSurplus >= 0 ? startStation : -1;
    }
}


// Brute Force Method
//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int saveIndex = -1;
//        int i = 0;
//        while(i < gas.length){
//            if(gas[i] >= cost[i]){
//                saveIndex = i;
//                int[] g = new int[gas.length];
//                int[] c = new int[cost.length];
//                int s = 0;
//                for (int j = i; j < gas.length; j++) {
//                    g[s] = gas[j];
//                    c[s] = cost[j];
//                    s++;
//                }
//                for (int j = 0; j < i; j++) {
//                    g[s] = gas[j];
//                    c[s] = cost[j];
//                    s++;
//                }
//                int fuel = 0;
//                for (int j = 0; j < g.length; j++) {
//                    fuel += g[j] - c[j];
//                    if (fuel <=0){
//                        break;
//                    }
//                }
//                if (fuel >= 0)
//                    return saveIndex;
//            }
//            i++;
//        }
//
//        return -1;
//    }
//}
