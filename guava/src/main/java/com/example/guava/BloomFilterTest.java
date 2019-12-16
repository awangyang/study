package com.example.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author wangyang
 * @date 2019/12/12
 */
public class BloomFilterTest {


    public static void main(String[] args) {

        BloomFilter<Long> userBloomFilter = BloomFilter.create(Funnels.longFunnel(), 200000, 1E-7);

        userBloomFilter.put(100L);
        System.out.println(userBloomFilter.mightContain(100L));
        System.out.println(userBloomFilter.mightContain(101L));

        System.out.println(Long.bitCount(1L));

    }
}
