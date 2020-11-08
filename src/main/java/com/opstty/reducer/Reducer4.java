package com.opstty.reducer;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Reducer4 extends Reducer<Text, Text, Text, Text> {
    private FloatWritable result = new FloatWritable();

    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        float maxHeight = 0;
        for (Text height : values) {
            if (Float.parseFloat(height.toString()) > maxHeight && height.getLength() != 0){
                maxHeight = Float.parseFloat(height.toString());
            }
        }
        result.set(maxHeight);
        context.write(key, new Text(String.valueOf(result)));
    }
}
