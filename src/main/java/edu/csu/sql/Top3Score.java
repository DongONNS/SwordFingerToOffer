package edu.csu.sql;

import java.util.ArrayList;
import java.util.List;

public class Top3Score {
    public static void main(String[] args) {
        List<Record> recordList = RecordMapper.getAllRecord();
        List<Record> res = new ArrayList<>();
        for (Record recordComp : recordList){
            for (Record record: recordList){
                if (record.getClassNo() == recordComp.getClassNo()
                    && record.getScore() >= recordComp.getScore()
                    && getRankOfScoreInClass(record,recordList) <= 3){
                    res.add(record);
                }
            }
        }
        System.out.println(res.toString());
    }

    private static int getRankOfScoreInClass(Record record,List<Record> recordList){
        int rank = 1;
        for (Record recordEle : recordList){
            if (record.getScore() < recordEle.getScore()){
                rank++;
            }
        }
        return rank;
    }

    private class Record{
        private int id;
        private String name;
        private int score;
        private int classNo;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public int getClassNo() {
            return classNo;
        }
    }

    private static class RecordMapper{
        private static List<Record> getAllRecord(){
            return new ArrayList<>();
        }
    }
}
