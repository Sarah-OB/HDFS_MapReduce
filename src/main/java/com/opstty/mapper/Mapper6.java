package com.opstty.mapper;

import com.opstty.writable.AgeDistrict;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class Mapper6 extends Mapper<Object, Text, Text, AgeDistrict> {
    private Text district = new Text();
    private Text year = new Text();
    private AgeDistrict ageDistrict = new AgeDistrict();
    private Text genre = new Text("rien");

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String csv = value.toString();
        String[] arrLine = csv.split(";");

        if (arrLine[0].equals("GEOPOINT") || arrLine[1].equals("ARRONDISSEMENT") || arrLine[2].equals("GENRE") || arrLine[3].equals("ESPECE") || arrLine[4].equals("FAMILLE") || arrLine[5].equals("ANNEE PLANTATION") || arrLine[6].equals("HAUTEUR") || arrLine[7].equals("CIRCONFERENCE") || arrLine[8].equals("ADRESSE") || arrLine[9].equals("NOM COMMUN") || arrLine[10].equals("VARIETE") || arrLine[11].equals("OBJECTID") || arrLine[12].equals("NOM_EV")){
            return;
        }

        district.set(arrLine[1]);
        year.set(arrLine[5]);

        if (!((year.toString().equals("\t") || year.toString().equals(" ") || year.toString().equals("")) && year.toString().length() == 0)) {
            ageDistrict.setAge(Integer.parseInt(year.toString()));
            ageDistrict.setDistrict(new IntWritable(Integer.parseInt(district.toString())));
            context.write(genre, ageDistrict);
        }
    }
}
