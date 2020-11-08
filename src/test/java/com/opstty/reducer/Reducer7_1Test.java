package com.opstty.reducer;

import com.opstty.writable.AgeDistrict;
import com.opstty.writable.DistrictNumber;
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
public class Reducer7_1Test {
    @Mock
    private Reducer.Context context;
    private Reducer7_1 reducer7_1;

    @Before
    public void setup() {
        this.reducer7_1 = new Reducer7_1();
    }

    @Test
    public void testReduce() throws IOException, InterruptedException {
        DistrictNumber value1 = new DistrictNumber(new IntWritable(5), new IntWritable(20));
        DistrictNumber value2 = new DistrictNumber(new IntWritable(7), new IntWritable( 6));
        Iterable<DistrictNumber> values = Arrays.asList(value1, value2);
        this.reducer7_1.reduce(NullWritable.get(), values, this.context);
        verify(this.context).write(new IntWritable(5), NullWritable.get());
    }
}
