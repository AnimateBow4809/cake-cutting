package bow.animate;
import java.util.*;

public class CakeCutting {


    public static int getMaxPieceArea(TreeSet<Integer> cuts) {
        int prevCut = cuts.first();
        int maxPieceArea = 0;

        for (int cut : cuts.tailSet(prevCut, false)) {
            maxPieceArea = Math.max(maxPieceArea, cut - prevCut);
            prevCut = cut;
        }

        return maxPieceArea;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int W = scanner.nextInt();
        int H = scanner.nextInt();
        int q = scanner.nextInt();

        TreeSet<Integer> horizontalCuts = new TreeSet<>();
        TreeSet<Integer> verticalCuts = new TreeSet<>();
        horizontalCuts.add(0);
        horizontalCuts.add(H);
        verticalCuts.add(0);
        verticalCuts.add(W);

        int maxArea = W * H;
        for (int i = 0; i < q; i++) {
            char cutType = scanner.next().charAt(0);
            int coord = scanner.nextInt();

            if (cutType == 'h') {
                horizontalCuts.add(coord);
            } else {
                verticalCuts.add(coord);
            }

            maxArea = Math.max(maxArea, getMaxPieceArea(horizontalCuts) * getMaxPieceArea(verticalCuts));
            System.out.println(maxArea);
        }
    }
}