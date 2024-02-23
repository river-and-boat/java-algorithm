package com.yuzhou.structure.heap;

/**
 * 特性
 * 1.完全二叉树
 * 2. 节点左子节点和右子节点均小于根节点
 * 3. 注意，左子节点和右子节点之间没有大小关系
 */
public class BigTopHeap {
    private final int[] dataArray;

    private final int max;

    private int count;

    public BigTopHeap() {
        this(100);
    }

    public BigTopHeap(int size) {
        dataArray = new int[size + 1];
        max = size;
        count = 0;
    }

    public void insert(int data) {
        if (count >= max) {
            return;
        }
        dataArray[++count] = data;

        int index = count;
        while (index / 2 > 0) {
            if (dataArray[index] > dataArray[index / 2]) {
                int swap = dataArray[index];
                dataArray[index] = dataArray[index / 2];
                dataArray[index / 2] = swap;

                index = index / 2;
            } else {
                return;
            }
        }
    }

    /**
     * 删除堆顶元素，即删除最大值
     */
    public void deleteTop() {
        dataArray[1] = dataArray[count];
        dataArray[count] = 0;
        count--;
        int index = 1;

        while (index < count / 2) {
            int biggerIndex;
            if (dataArray[2 * index] > dataArray[2 * index + 1]) {
                biggerIndex = 2 * index;
            } else {
                biggerIndex = 2 * index + 1;
            }
            if (dataArray[index] < dataArray[biggerIndex]) {
                int swap = dataArray[index];
                dataArray[index] = dataArray[biggerIndex];
                dataArray[biggerIndex] = swap;
                index = biggerIndex;
            } else {
                return;
            }
        }
    }

    /**
     * 根据index删除元素
     *
     * @param pos 元素位置
     */
    public void delete(int pos) {
        if (pos > count) {
            return;
        }
        dataArray[pos] = dataArray[count];
        dataArray[count] = 0;
        count--;
        int index = 1;

        while (index < count / 2) {
            int biggerIndex;
            if (dataArray[2 * index] > dataArray[2 * index + 1]) {
                biggerIndex = 2 * index;
            } else {
                biggerIndex = 2 * index + 1;
            }
            if (dataArray[index] < dataArray[biggerIndex]) {
                int swap = dataArray[index];
                dataArray[index] = dataArray[biggerIndex];
                dataArray[biggerIndex] = swap;
                index = biggerIndex;
            } else {
                return;
            }
        }
    }

    public int max() {
        return dataArray[1];
    }

    public void sort() {
        int index = count;
        while (index > 1) {
            int swap = dataArray[1];
            dataArray[1] = dataArray[index];
            dataArray[index] = swap;
            index--;
            heap(index);
        }
    }

    private void heap(int count) {
        int index = 1;
        int maxPos = index;
        while (true) {
            if (2 * index <= count && dataArray[index] < dataArray[2 * index]) {
                maxPos = 2 * index;
            }
            if (2 * index + 1 <= count && dataArray[maxPos] < dataArray[2 * index + 1]) {
                maxPos = 2 * index + 1;
            }
            if (maxPos == index) {
                break;
            }
            int swap = dataArray[index];
            dataArray[index] = dataArray[maxPos];
            dataArray[maxPos] = swap;
            index = maxPos;
        }
    }

    public String string() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            builder.append(dataArray[i]);
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
