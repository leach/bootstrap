package com.anythy.wechat.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Leach on 0004 2018/1/4.
 */
public class QQTool {
    public static Map<Integer, String> importQQ(String filePath){
        HSSFWorkbook wb = null;
        HSSFSheet sheet;
        HSSFRow row;
        Map<Integer, String> content = new HashMap<Integer, String>();
        String str = "";
        try {
            InputStream is = new FileInputStream(new File(filePath));
            POIFSFileSystem fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
// 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
// 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            while (j < colNum) {
// 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
// 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
// str += getStringCellValue(row.getCell((short) j)).trim() +
// "-";
                str += getCellFormatValue(row.getCell((short) j)).trim() + "    ";
                j++;
            }
            content.put(i, str);
            str = "";
        }

        return content;
    }



    private static String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
// 判断当前Cell的Type
            switch (cell.getCellType()) {
// 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC:
                case HSSFCell.CELL_TYPE_FORMULA: {
// 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
// 如果是Date类型则，转化为Data格式

//方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
//cellvalue = cell.getDateCellValue().toLocaleString();

//方法2：这样子的data格式是不带带时分秒的：2011-10-12
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);

                    }
// 如果是纯数字
                    else {
// 取得当前Cell的数值
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
// 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
// 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
// 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }

    public static void main(String[] args) {
        Map<Integer, String> content = QQTool.importQQ("D:\\新建文件夹\\ssqq.xlsx");

        content.forEach((k, v) -> System.out.println(v));
    }
}
