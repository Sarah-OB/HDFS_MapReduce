package com.opstty.mapper;

import com.opstty.writable.DistrictNumber;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class Mapper7_1Test {
    @Mock
    private Mapper<java.lang.Object, org.apache.hadoop.io.Text, org.apache.hadoop.io.NullWritable, com.opstty.writable.DistrictNumber>.Context context;
    private Mapper7_1 mapper7_1;

    @Before
    public void setup() {
        this.mapper7_1 = new Mapper7_1();
    }

    @Test
    public void testMap() throws IOException, InterruptedException {
        String value = "3\t1";
        this.mapper7_1.map(null, new Text(value), this.context);
        //verify(this.context, times(1))
                //.write(NullWritable.get(), new DistrictNumber(new IntWritable(3), new IntWritable(1)));
    }
}