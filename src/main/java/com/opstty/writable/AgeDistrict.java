package com.opstty.writable;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AgeDistrict implements Writable {
    private final static int actualYear = 2020;
    private IntWritable age;
    private IntWritable district;

    public AgeDistrict() {
        this.age = new IntWritable();
        this.district = new IntWritable();
    }

    public AgeDistrict(IntWritable age, IntWritable district){
        this.setAge(age.get());
        this.setDistrict(district);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this.age.write(dataOutput);
        this.district.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.getAge().readFields(dataInput);
        this.getDistrict().readFields(dataInput);
    }

    public void setAge(int annee) {
        this.age = new IntWritable(actualYear - annee);
    }

    public void setDistrict(IntWritable district) {
        this.district = district;
    }

    public IntWritable getAge() {
        return age;
    }

    public IntWritable getDistrict() {
        return district;
    }

    public String toString(){
        return "I come from district number : " + this.getDistrict().get() + " and I am : " + this.getAge().get() + " years old.";
    }
}

