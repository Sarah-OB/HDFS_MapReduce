package com.opstty.reducer;

import com.opstty.writable.DistrictNumber;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Reducer7_1 extends Reducer<NullWritable, DistrictNumber, IntWritable, NullWritable> {
    private IntWritable district = new IntWritable();

    public void reduce(NullWritable key, Iterable<DistrictNumber> values, Context context) throws InterruptedException, IOException {
        int maxTrees = 0;
        int dist = 0;

        for (DistrictNumber ar : values) {
            if (ar.getNb().get() > maxTrees){
                maxTrees = ar.getNb().get();
                dist = ar.getDistrict().get();
            }
        }

        district.set(dist);
        context.write(district, NullWritable.get());
    }

}
