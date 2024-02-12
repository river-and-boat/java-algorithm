package com.yuzhou.algorithm.bloom;

import java.util.BitSet;

public class BloomFilter {
    private static final int DEFAULT_SIZE = 1 << 25;

    private static final int[] SEEDS = new int[]{6, 18, 64, 89, 126, 189, 223};

    private BitSet bits = new BitSet(DEFAULT_SIZE);

    private MyHash[] myHashes = new MyHash[SEEDS.length];

    public BloomFilter() {
        for (int i = 0; i < SEEDS.length; i++) {
            myHashes[i] = new MyHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    public void add(Object value) {
        for (MyHash myHash : myHashes) {
            bits.set(myHash.hash(value), true);
        }
    }

    public boolean contains(Object value) {
        boolean result = true;
        for (MyHash myHash : myHashes) {
            result = result && bits.get(myHash.hash(value));
        }
        return result;
    }

    private static class MyHash {
        private int cap;

        private int seed;

        public MyHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        int hash(Object object) {
            return (object == null ? 0 : Math.abs(seed * (cap - 1) & (object.hashCode() ^ (object.hashCode() >>> 16))));
        }
    }
}
