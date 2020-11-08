package com.opstty.reducer;

import com.opstty.writable.AgeDistrict;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Reducer6 extends Reducer<Text, AgeDistrict, Text, NullWritable> {
    private Text district = new Text();

    public void reduce(Text key, Iterable<AgeDistrict> values, Context context) throws InterruptedException, IOException {
        int ageMaxTmp = 0;
        int dist = 0;
        for (AgeDistrict ad : values) {
            if (ad.getAge().get() > ageMaxTmp){
                ageMaxTmp = ad.getAge().get();
                dist = ad.getDistrict().get();
            }
        }

        district.set(String.valueOf(dist));
        context.write(district, NullWritable.get());
    }

}
