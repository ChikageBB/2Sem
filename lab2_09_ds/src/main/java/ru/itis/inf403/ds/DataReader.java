package ru.itis.inf403.ds;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static void main(String[] args) {
        DataReader dr = new DataReader();
        dr.readFile("D:\\itis\\javaProject\\2Sem\\med (2).csv");


    }

    public List<RawRow> readFile(String fileName){
        List<RawRow> result = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists() || !file.isFile()) return result;

        try (

            BufferedReader bf = new BufferedReader(new FileReader(file));

        ){

            while (bf.ready()) {

                //System.out.print((char)reader.read());
                //System.out.println(bf.readLine());
                String[] data = bf.readLine().split(";");

                if (data.length < 24) continue;

                RawRow rawRow = new RawRow();
                rawRow.setRiskScoreCVRM(data[6]);
                rawRow.setMdrd(data[7]);
                rawRow.setGlucoseFasting(data[9]);
                rawRow.setTotalCholesterol(data[11]);
                rawRow.setSystolicBloodPressure(data[13]);
                rawRow.setDiastolicBloodPressure(data[14]);
                rawRow.setBmi(data[16]);
                rawRow.setPsCVRM(data[18]);
                rawRow.setSmokingStatus(data[19]);
                rawRow.setAge(data[22]);
                rawRow.setHypertension(data[23]);

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

//    public List<Row> clearData(List<RawRow> raw){
//        raw
//                .stream()
//                .filter(r -> !r.badRedord())
//                .map(r -> new Row()).toList();
//
//    }

    public Row convertor(RawRow raw){
        Row r = new Row();
        r.setRiskScoreCVRM(Integer.parseInt(raw.getRiskScoreCVRM()));
        r.setMdrd(Integer.parseInt(raw.getMdrd()));


        return r;
    }

    public void tree(){
        Node root = new Node();

        Node[] tree = new Node[63];

        for (int i = 0; i < tree.length; i++){
            tree[i].setFunction(
                    null
            );
        }

    }
}
