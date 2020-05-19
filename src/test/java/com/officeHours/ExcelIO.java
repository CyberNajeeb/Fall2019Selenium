package com.officeHours;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;

public class ExcelIO {

    @Test
    public void createExcelFileTest() throws IOException {
        String filePath = System.getProperty("user.dir") + File.separator + "VytrackTestUsers.xlsx";
        File file = new File(filePath);
//        file.createNewFile();
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet("QA3-short");

        Row row = sheet.getRow(1);
        Cell cell = row.getCell(5);
        System.out.println("cell = " + cell);
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();
    }

    @Test
    public void createFile() throws IOException {
        File file = new File("regressionTestResults.xlsx");
        file.createNewFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.close();
        XSSFWorkbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("test_results");

        Row row = sheet.createRow(0);
        Cell firstCell = row.createCell(0);

        Row secondRow = sheet.createRow(1);
        Cell secondCell = secondRow.createCell(0);

        firstCell.setCellValue("Test Status");
        secondCell.setCellValue("Passed");
        FileOutputStream fileOutputStream = new FileOutputStream(new File("regressionTestResults.xlsx"));
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
