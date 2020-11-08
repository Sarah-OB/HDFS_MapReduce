package com.opstty.mapper;

import com.opstty.writable.DistrictNumber;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class Mapper7_1 extends Mapper<Object, Text, NullWritable, DistrictNumber> {
    private IntWritable district = new IntWritable();
    private IntWritable nb = new IntWritable();
    private DistrictNumber districtNb = new DistrictNumber();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String result = value.toString();
        String[] arrLine = result.split("\t");

        district.set(Integer.parseInt(arrLine[0]));
        nb.set(Integer.parseInt(arrLine[1]));

        districtNb.setDistrict(district);
        districtNb.setNb(nb);

        context.write(NullWritable.get(), districtNb);
    }
}
