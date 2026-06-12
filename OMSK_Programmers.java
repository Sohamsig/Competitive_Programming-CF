import java.util.*;

public class Main {

    static long x;

    static void dfs(long v, long cost, HashMap<Long, Long> mp) {
        Long old = mp.get(v);
        if (old != null && old <= cost) return;

        mp.put(v, cost);

        if (v == 0) return;

        dfs(v / x, cost + 1, mp);

        long add = (x - v % x) % x;
        dfs((v + add) / x, cost + add + 1, mp);
    }

    static HashMap<Long, Long> generate(long start, long xx) {
        x = xx;
        HashMap<Long, Long> mp = new HashMap<>();
        dfs(start, 0, mp);
        return mp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            long a = sc.nextLong();
            long b = sc.nextLong();
            long xx = sc.nextLong();

            HashMap<Long, Long> A = generate(a, xx);
            HashMap<Long, Long> B = generate(b, xx);

            TreeSet<Long> vals = new TreeSet<>();
            vals.addAll(A.keySet());
            vals.addAll(B.keySet());

            ArrayList<Long> points = new ArrayList<>(vals);

            long bestA = Long.MAX_VALUE;
            long bestB = Long.MAX_VALUE;

            int pa = 0, pb = 0;

            ArrayList<long[]> listA = new ArrayList<>();
            for (Map.Entry<Long, Long> e : A.entrySet()) {
                listA.add(new long[]{e.getKey(), e.getValue()});
            }

            ArrayList<long[]> listB = new ArrayList<>();
            for (Map.Entry<Long, Long> e : B.entrySet()) {
                listB.add(new long[]{e.getKey(), e.getValue()});
            }

            listA.sort(Comparator.comparingLong(z -> z[0]));
            listB.sort(Comparator.comparingLong(z -> z[0]));

            long ans = Long.MAX_VALUE;

            for (long T : points) {

                while (pa < listA.size() && listA.get(pa)[0] <= T) {
                    bestA = Math.min(bestA,
                            listA.get(pa)[1] - listA.get(pa)[0]);
                    pa++;
                }

                while (pb < listB.size() && listB.get(pb)[0] <= T) {
                    bestB = Math.min(bestB,
                            listB.get(pb)[1] - listB.get(pb)[0]);
                    pb++;
                }

                ans = Math.min(ans,
                        2L * T + bestA + bestB);
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
