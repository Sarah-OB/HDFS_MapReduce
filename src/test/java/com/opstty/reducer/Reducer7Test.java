package com.opstty.reducer;

import com.opstty.writable.AgeDistrict;
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
public class Reducer7Test {
    @Mock
    private Reducer.Context context;
    private Reducer7 reducer7;

    @Before
    public void setup() {
        this.reducer7 = new Reducer7();
    }

    @Test
    public void testReduce() throws IOException, InterruptedException {
        int key = 1;
        IntWritable value = new IntWritable(5);
        Iterable<IntWritable> values = Arrays.asList(value, value);
        this.reducer7.reduce(new IntWritable(key), values, this.context);
        verify(this.context).write(new IntWritable(key), new IntWritable(10));
    }
}
