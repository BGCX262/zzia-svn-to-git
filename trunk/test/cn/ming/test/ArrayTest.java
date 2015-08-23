package cn.ming.test;

import org.junit.Test;

public class ArrayTest {

    @Test
    public void array() {
        int M = 1000, N = 2000;
        int a[][] = new int[M][N];
        int b[][] = new int[M][N];
        int c[][] = new int[M][N];
        long start = System.currentTimeMillis();
        System.out.println(start);
        //        for (int i = 0; i < M; i++) {
        //            for (int j = 0; j < N; j++) {
        //                c[i][j] = a[i][j] * b[i][j];
        //            }
        //        }
        //        long end = System.currentTimeMillis();
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                c[i][j] = a[i][j] * b[i][j];
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
