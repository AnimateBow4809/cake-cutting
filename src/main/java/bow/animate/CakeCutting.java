package bow.animate;

import java.util.*;

import java.util.Scanner;

public class CakeCutting {

    /*
        calculate in O(n) time
        and O(max(H,W)) space complexity
     */
    public static long calcMax(long w, long h, boolean[] xAxisCuts, boolean[] yAxisCuts) {
        long x=0,y=0;
        long xMax=0,yMax=0;
        for (int i = 0; i < w+1; i++) {
            if (i==0){
                x++;
                continue;
            }
            if (xAxisCuts[i]){
                xMax=Math.max(xMax,x);
                x=0;
            }
            x++;
        }

        for (int i = 0; i < h+1; i++) {
            if (i==0){
                y++;
                continue;
            }
            if (yAxisCuts[i]){
                yMax=Math.max(yMax,y);
                y=0;
            }
            y++;
        }
        return xMax*yMax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input=scanner.nextLine().split(" ");
        int w = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        int q = Integer.parseInt(input[2]);
        boolean[] xAxisCuts=new boolean[w+1];
        boolean[] yAxisCuts=new boolean[h+1];
        xAxisCuts[w]=true;
        yAxisCuts[h]=true;
        long max=w*h;
        for (long i = 0; i < q; i++) {
            input=scanner.nextLine().split(" ");
            if (input[0].toUpperCase(Locale.ROOT).equals("V")){
                xAxisCuts[Integer.parseInt(input[1])]=true;
            }else {
                yAxisCuts[Integer.parseInt(input[1])]=true;
            }
            max=calcMax(w,h,xAxisCuts,yAxisCuts);
            System.out.println(max);
        }
//        max=calcMax(w,h,xAxisCuts,yAxisCuts);
        if (q==0)
        System.out.println(max);
    }

}
