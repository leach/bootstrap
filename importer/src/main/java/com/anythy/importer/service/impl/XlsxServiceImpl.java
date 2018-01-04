package com.anythy.importer.service.impl;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;

import java.io.IOException;

public class XlsxServiceImpl {
    public void processOneSheet(String fileName) throws OpenXML4JException, IOException {
        OPCPackage pkg = OPCPackage.open(fileName);
        XSSFReader r = new XSSFReader(pkg);
        SharedStringsTable sst = r.getSharedStringsTable();
        //https://poi.apache.org/spreadsheet/how-to.html#user_api
    }
}
