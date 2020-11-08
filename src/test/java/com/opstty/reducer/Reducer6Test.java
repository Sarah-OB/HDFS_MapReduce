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
public class Reducer6Test {
    @Mock
    private Reducer.Context context;
    private Reducer6 reducer6;

    @Before
    public void setup() {
        this.reducer6 = new Reducer6();
    }

    @Test
    public void testReduce() throws IOException, InterruptedException {
        String key = "key";
        AgeDistrict value1 = new AgeDistrict(new IntWritable(1933),new IntWritable(5));
        AgeDistrict value2 = new AgeDistrict(new IntWritable(1904),new IntWritable(8));
        Iterable<AgeDistrict> values = Arrays.asList(value1, value2);
        this.reducer6.reduce(new Text(key), values, this.context);
        verify(this.context).write(new Text("8"), NullWritable.get());
    }
}
