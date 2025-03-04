package com.opstty.job;

import com.opstty.mapper.Mapper5;
import com.opstty.reducer.Reducer5;
import com.opstty.writable.AscendingComparator;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class SortTrees {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Incorrect arguments number");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "Sort the trees height from smallest to largest");
        job.setJarByClass(SortTrees.class);
        job.setMapperClass(Mapper5.class);
        job.setCombinerClass(Reducer5.class);
        job.setSortComparatorClass(AscendingComparator.class);
        job.setReducerClass(Reducer5.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
