package xyz.onlytype.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author java-小潘
 * @description 通过父类查询子类算法
 * @Date 22.5.22 8:23 上午
 * @Version 1.0
 *
 */

public class CategoryUtils {
    public static String addCode(String parent, List<String> sun) {
        if (parent.equals("")){
            String sunCode = "";
            int len = sun.get(0).length();
            int sunEndMaxValue = 0;
            for (int i = 0; i < sun.size(); i++) {
                int temp = Integer.parseInt(sun.get(i).substring(len - 2, len)) % 100;
                sunEndMaxValue = Math.max(temp, sunEndMaxValue);
            }
            sunCode = parent + "A" + String.format("%02d", ++sunEndMaxValue);
            return sunCode;
        }else {
            String sunCode = "";
            int i = 1;
            sunCode = parent + "A" + String.format("%02d", i++);
            return sunCode;
        }
    }

    public static String addList(String parent, List<String> sun) {
            String sunCode = "";
            int len = sun.get(0).length();
            int sunEndMaxValue = 0;
            for (int i = 0; i < sun.size(); i++) {
                int temp = Integer.parseInt(sun.get(i).substring(len - 2, len)) % 100;
                sunEndMaxValue = Math.max(temp, sunEndMaxValue);
                System.out.println(sunEndMaxValue);
            }
            sunCode = parent + "A" + String.format("%02d", ++sunEndMaxValue);
            return sunCode;
    }

//    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<>();
//        list.add("A04A01");
//        String a05 = addList("", list);
//        System.out.println(a05);
//    }
}