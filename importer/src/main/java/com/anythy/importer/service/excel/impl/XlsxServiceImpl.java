package com.anythy.importer.service.excel.impl;

import com.anythy.importer.service.excel.handler.SheetHandler;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XlsxServiceImpl {
    /**
     * 处理一个sheet
     * @param fileName
     * @throws OpenXML4JException
     * @throws IOException
     * @throws SAXException
     */
    public void processOneSheet(String fileName) throws OpenXML4JException, IOException, SAXException {
        OPCPackage pkg = OPCPackage.open(fileName);
        XSSFReader r = new XSSFReader(pkg);
        SharedStringsTable sst = r.getSharedStringsTable();
        //https://poi.apache.org/spreadsheet/how-to.html#user_api
        XMLReader parser = fetchSheetParser(sst);

        InputStream sheet2 = r.getSheet("rId1");
        InputSource sheetSource = new InputSource(sheet2);
        parser.parse(sheetSource);
        sheet2.close();
    }

    /**
     * 处理多个sheet
     * @param filename
     * @throws Exception
     */
    public void processAllSheets(String filename) throws Exception {
        OPCPackage pkg = OPCPackage.open(filename);
        XSSFReader r = new XSSFReader( pkg );
        SharedStringsTable sst = r.getSharedStringsTable();

        XMLReader parser = fetchSheetParser(sst);

        Iterator<InputStream> sheets = r.getSheetsData();
        while(sheets.hasNext()) {
            System.out.println("Processing new sheet:\n");
            InputStream sheet = sheets.next();
            InputSource sheetSource = new InputSource(sheet);
            parser.parse(sheetSource);
            sheet.close();
            System.out.println("");
        }
    }

    public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
        XMLReader parser =
                XMLReaderFactory.createXMLReader(
                        "org.apache.xerces.parsers.SAXParser"
                );
        ContentHandler handler = new SheetHandler(sst);
        parser.setContentHandler(handler);
        return parser;
    }



    public static void main(String[] args) throws Exception {
        Pattern p = Pattern.compile("[A-Z]+");
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        while (!a.equals("e")){
            Matcher m = p.matcher(a);
            if(m.find()){
                System.out.println("m.group()" + m.groupCount());
                System.out.println("m.group(0):" + m.group(0));
                System.out.println("m.group()" + m.group());
            }
            a = s.nextLine();
        }

        /*
        XlsxServiceImpl example = new XlsxServiceImpl();
        example.processOneSheet("D:\\新建文件夹\\ssqq.xlsx");*/
    }
}
