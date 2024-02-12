package com.yuzhou.algorithm.leetcode;

public class SolutionMain {
    public static void main(String[] args) {
        // System.out.println(mergeAlternately("sos", "hsb"));
        // System.out.println(replaceSpaces("hello world                    ", 12));
        // System.out.println(canPermutePalindrome("cob"));
        // System.out.println(oneEditAway("a", "ab"));
        // System.out.println(compressString("aaaaaaa"));
        rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    public static String mergeAlternately(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        StringBuilder result = new StringBuilder();
        if (word1Length > word2Length) {
            for (int i = 0; i < word1Length; i++) {
                if (i < word2Length) {
                    result.append(word1.charAt(i)).append(word2.charAt(i));
                } else {
                    result.append(word1.charAt(i));
                }

            }
        } else {
            for (int i = 0; i < word2Length; i++) {
                if (i < word1Length) {
                    result.append(word1.charAt(i)).append(word2.charAt(i));
                } else {
                    result.append(word2.charAt(i));
                }

            }
        }
        return result.toString();
    }

    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] hashs1 = new int[26];
        int[] hashs2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            ++hashs1[s1.charAt(i) - 'a'];
        }
        for (int i = 0; i < s2.length(); i++) {
            ++hashs2[s2.charAt(i) - 'a'];
        }
        for (int i = 0; i < hashs1.length; i++) {
            if (hashs1[i] != hashs2[i]) {
                return false;
            }
        }
        return true;
    }

    public static String replaceSpaces(String S, int length) {
        char[] result = S.toCharArray();
        int lastIndex = result.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (result[i] != ' ') {
                result[lastIndex--] = result[i];
            } else {
                result[lastIndex--] = '0';
                result[lastIndex--] = '2';
                result[lastIndex--] = '%';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = lastIndex + 1; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static boolean canPermutePalindrome(String s) {
        int[] hash = new int[255];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            hash[s.charAt(i) - ' ']++;
        }
        int count = 0;
        for (int j : hash) {
            if (j % 2 != 0) {
                if (++count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean oneEditAway(String first, String second) {
        int lengthFirst = first.length();
        int lengthSecond = second.length();
        int differentCount = 0;

        if (lengthFirst == lengthSecond) {
            for (int i = 0; i < lengthFirst; i++) {
                if (first.charAt(i) != second.charAt(i) && ++differentCount > 1) {
                    return false;
                }
            }
            return true;
        }

        if (Math.abs(lengthFirst - lengthSecond) > 1) {
            return false;
        }

        if (lengthSecond > lengthFirst) {
            return oneEditAway(second, first);
        }

        for (int i = 0, j = 0; j < lengthSecond; i++, j++) {
            if (first.charAt(i) == second.charAt(j)) {
                continue;
            }
            if (++differentCount > 1 || first.charAt(++i) != second.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static String compressString(String S) {
        if (S.isEmpty()) {
            return S;
        }
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        while (++j < S.length()) {
            if (S.charAt(i) != S.charAt(j)) {
                result.append(S.charAt(i));
                result.append(j - i);
                i = j;
            }
        }
        result.append(S.charAt(i));
        result.append(j - i);

        return result.length() >= S.length() ? S : result.toString();
    }

    /**
     * 进行两轮交换
     * <p>
     * 首先进行从左上到右下的对角线交换
     * 然后进行左右对称交换
     *
     * @param matrix 输入矩阵
     */
    public static void rotate(int[][] matrix) {
        // [[1,2,3],[4,5,6],[7,8,9]] -> [[7,4,1],[8,5,2],[9,6,3]]

        // start: 对角线交换，仅需要遍历上半/下半对角线
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // start: 左右交换，仅需要遍历左半或右半
        for (int i = 0; i < matrix.length; i++) {
            for (int indexF = 0, indexL = matrix[i].length - 1; indexL - indexF > 0; indexF++, indexL--) {
                int temp = matrix[i][indexF];
                matrix[i][indexF] = matrix[i][indexL];
                matrix[i][indexL] = temp;
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
