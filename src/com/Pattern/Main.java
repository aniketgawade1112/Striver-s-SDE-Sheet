package com.Pattern;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        pattern1(n);
        pattern2(n);
        pattern3(n);
        pattern4(n);
        pattern5(n);
        pattern6(n);
        pattern7(n);
    }
    static void pattern1(int n) {
        for(int row = 0; row < n; row++) {
            for(int col = 0; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void pattern2(int n) {
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n - row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void pattern3(int n) {
        for(int row = 0; row < n; row++) {
            for(int col = 0; col <= row; col++) {
                System.out.print((col + 1));
            }
            System.out.println();
        }
    }
    static void pattern4(int n) {
        for(int row = 0; row < 2 * n; row++) {
            int totalColInRow = row > n ? 2 * n - row : row;
            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern5(int n) {
        for(int row = 0; row < 2 * n; row++) {
            int totalColInRow = row > n ? 2 * n - row : row;

            int noOfSpaces = n - totalColInRow;

            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }

            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern6(int n) {
        for (int row = 1; row <= n; row++) {

            for (int space = 0; space < n - row; space++) {
                System.out.print("  ");
            }
            
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }

            for (int col = 2; col <= row ; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void pattern7(int n) {
        int m = 2 * n - 1;
        int k = 1;
        int flag = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= m; j++) {
                if(i == j || j == (n*2) - i) {
                    System.out.print(k);
                }
                else {
                    System.out.print(" ");
                }
            }
            if(flag == 1 && k < n) {
                k++;
            }
            else {
                flag = 0;
                k--;
            }
            System.out.println();
        }
    }
}
