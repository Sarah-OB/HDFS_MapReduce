package com.opstty.writable;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AscendingComparator extends WritableComparator {
    public AscendingComparator() {
        super(FloatWritable.class, true);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public int compare(WritableComparable w1, WritableComparable w2) {
        FloatWritable key1 = (FloatWritable) w1;
        FloatWritable key2 = (FloatWritable) w2;
        return 1 * key1.compareTo(key2);
    }
}
