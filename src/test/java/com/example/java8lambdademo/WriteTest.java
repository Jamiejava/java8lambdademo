package com.example.java8lambdademo;

import com.alibaba.excel.EasyExcel;
import com.example.easyexcel.DemoData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @Author: kuangjie
 * @Data: 2020/5/15 15:36
 */
public class WriteTest {

    public  void SimpleWrite(){
        String fileName = TestFileUtil.getPath() +"SimpleWrite"+ System.currentTimeMillis()+ ".xlsx";
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());

    }


    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);

            list.add(data);
        }
        return list;
    }
}
