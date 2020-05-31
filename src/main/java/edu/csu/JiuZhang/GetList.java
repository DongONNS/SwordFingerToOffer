package edu.csu.JiuZhang;

import java.util.ArrayList;
import java.util.List;

public class GetList {
     public List<List<String>> getList(List<List<String>> datalist1, List<List<String>> datalist2) {
        if (datalist1.size() != datalist2.size()) return null;
        List<List<String>> res = new ArrayList<>();
        for(int i = 0;i < datalist1.size();i++){
            List<String> list = new ArrayList<>();
            String name = datalist1.get(i).get(1);
            String salary01 = datalist2.get(i).get(2);
            String salary02 = datalist2.get(i).get(4);
            String salary03 = datalist2.get(i).get(6);
            String sumSalary =Integer.parseInt(salary01)+Integer.parseInt(salary02)+Integer.parseInt(salary03) + "";
            list.add(name);
            list.add(salary01);
            list.add(salary02);
            list.add(salary03);
            list.add(sumSalary);
            res.add(list);
        }
        return res;
    }
}
