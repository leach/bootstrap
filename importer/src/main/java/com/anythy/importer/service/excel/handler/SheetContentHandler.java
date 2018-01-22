package com.anythy.importer.service.excel.handler;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leach on 0008 2018/1/8.
 */
public class SheetContentHandler implements XSSFSheetXMLHandler.SheetContentsHandler {

    private int currentRow = -1;
    private int currentCol = -1;
    private int minColumns;

    private List<String> lRows = new ArrayList<String>(); // 处理一行信息

    @Override
    public void startRow(int rowNum) {
        currentRow = rowNum;
        currentCol = -1;
        lRows.clear();
    }

    @Override
    public void endRow(int rowNum) {
        // 添加数据
        for (int i = currentCol; i < minColumns; i++) {
            lRows.add("");
        }
        postRowAdded(lRows, rowNum);
    }


    private void postRowAdded(List<String> row, int rowNum){
        for (int i = 0; i < row.size(); i++) {
            System.out.println(row.get(i));
        }
    }

    @Override
    public void cell(String cellReference, String formattedValue, XSSFComment comment) {

        if (cellReference == null) {
            cellReference = new CellAddress(currentRow, currentCol)
                    .formatAsString();
        }
        int thisCol = (new CellReference(cellReference)).getCol();
        int missedCols = thisCol - currentCol - 1;//处理数据中间存在空白
        for (int i = 0; i < missedCols; i++) {
            this.lRows.add("");
        }
        currentCol = thisCol;

        // TODO 数据类型处理
        try {
            Double.parseDouble(formattedValue);
            this.lRows.add(formattedValue);
        } catch (NumberFormatException e) {
            this.lRows.add(formattedValue);
        }
    }

    @Override
    public void headerFooter(String text, boolean isHeader, String tagName) {

        System.out.println(text + "==" + isHeader + "==" + tagName);
    }
}
