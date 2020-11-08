package com.opstty.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class Reducer7 extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws InterruptedException, IOException {
        int sum = 0;
        for (IntWritable i : values){
            sum += i.get();
        }

        result.set(sum);

        context.write(key,result);
    }

}
