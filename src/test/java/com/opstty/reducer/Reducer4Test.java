package com.opstty.reducer;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class Reducer4Test {
    @Mock
    private Reducer.Context context;
    private Reducer4 reducer4;

    @Before
    public void setup() {
        this.reducer4 = new Reducer4();
    }

    @Test
    public void testReduce() throws IOException, InterruptedException {
        String key = "key";
        Text value1 = new Text("1");
        Text value2 = new Text("10");
        Text value3 = new Text("4");
        Text value4 = new Text("6");
        Iterable<Text> values = Arrays.asList(value1, value2, value3, value4);
        this.reducer4.reduce(new Text(key), values, this.context);
        verify(this.context).write(new Text(key), new Text(String.valueOf(Float.parseFloat(value2.toString()))));
    }
}
