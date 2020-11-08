package com.opstty.job;

import com.opstty.mapper.Mapper7;
import com.opstty.mapper.Mapper7_1;
import com.opstty.reducer.Reducer7;
import com.opstty.reducer.Reducer7_1;
import com.opstty.writable.DistrictNumber;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class DistrictMostTree {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Incorrect arguments number");
            System.exit(2);
        }

        //First phase
        Job job = Job.getInstance(conf, "District containing the most trees (phase1)");
        job.setJarByClass(DistrictMostTree.class);
        job.setMapperClass(Mapper7.class);
        job.setReducerClass(Reducer7.class);
        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);

        Path input1 = new Path(otherArgs[0]);
        Path output1 = new Path(otherArgs[1]);

        FileInputFormat.addInputPath(job, input1);
        FileOutputFormat.setOutputPath(job, output1);
        job.waitForCompletion(true);

        //Second phase
        Configuration conf2 = new Configuration();
        Job job2 = Job.getInstance(conf2, "District containing the most trees (phase2)");
        job2.setJarByClass(DistrictMostTree.class);
        job2.setMapperClass(Mapper7_1.class);
        job2.setReducerClass(Reducer7_1.class);
        job2.setMapOutputKeyClass(NullWritable.class);
        job2.setMapOutputValueClass(DistrictNumber.class);
        job2.setOutputKeyClass(IntWritable.class);
        job2.setOutputValueClass(NullWritable.class);

        Path input2 = output1;
        Path output2 = new Path(otherArgs[2]);

        FileInputFormat.addInputPath(job2, input2);
        FileOutputFormat.setOutputPath(job2, output2);

        System.exit(job2.waitForCompletion(true) ? 0 : 1);
    }
}
