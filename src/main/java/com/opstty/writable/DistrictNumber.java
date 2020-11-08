package com.opstty.writable;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DistrictNumber implements Writable {
    private IntWritable district;
    private IntWritable nb;
    private static IntWritable one = new IntWritable(1);

    public DistrictNumber(){
        this.district = new IntWritable();
        this.nb = one;
    }

    public DistrictNumber(IntWritable district, IntWritable nb){
        this.setDistrict(district);
        this.setNb(nb);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        district.write(dataOutput);
        nb.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        district.readFields(dataInput);
        nb.readFields(dataInput);
    }

    public void setDistrict(IntWritable district) {
        this.district = district;
    }

    public IntWritable getDistrict() {
        return district;
    }

    public IntWritable getNb() {
        return nb;
    }

    public IntWritable setNb(IntWritable nb) {
        return this.nb = nb;
    }

    public String toString(){
        return "I come from district number : " + getDistrict().get() + " and I have : " + getNb().get() + " trees.";
    }
}
