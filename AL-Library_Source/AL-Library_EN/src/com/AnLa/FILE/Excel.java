package com.AnLa.FILE;
// Make By Bình An || AnLaVN || KatoVN

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**The Excel class support to read/write data from/to excel file.
 * @author AnLaVN
 */
public class Excel {

    /**Use this method to read data from Excel file at filePath location.
     * @param filePath is specific location of Excel file, file name extension must be ".xlsx".
     * @param workSheet is the name of the worksheet you want to work with.
     * @return all data cell as Iterator from workSheet in Excel file.
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static Iterator<Object[]> ReadExcel(String filePath, String workSheet) throws FileNotFoundException, IOException{
        FileInputStream file = new FileInputStream(new File(filePath));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(workSheet);
        Iterator<Row> rowIterator = sheet.iterator();
        ArrayList<Object[]> data = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            ArrayList<Object> rowData = new ArrayList<>();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING  -> rowData.add(cell.getStringCellValue());
                    case NUMERIC -> rowData.add(cell.getNumericCellValue());
                    case BOOLEAN -> rowData.add(cell.getBooleanCellValue());
                    case BLANK   -> rowData.add(null);
                }
            }
            data.add(rowData.toArray());
        }
        workbook.close();
        file.close();
        return data.iterator();
    }
    
    
    /**Use this method to write data to Excel file at filePath location.
     * @param filePath is specific location of Excel file, file name extension must be ".xlsx".
     * @param workSheet is the name of the worksheet you want to work with.
     * @param data all data as Iterator that you want to write to workSheet in Excel file.
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void WriteExcel(String filePath, String workSheet, Iterator<Object[]> data) throws FileNotFoundException, IOException{
        WriteExcel(filePath, workSheet, data, 0, 0);
    }

    
    /**Use this method to write data to Excel file at filePath location.
     * @param filePath is specific location of Excel file, file name extension must be ".xlsx".
     * @param workSheet is the name of the worksheet you want to work with.
     * @param data all data as Iterator that you want to write to workSheet in Excel file.
     * @param beginRow is number of begin row, 0 is the starting value and is the minimum.
     * @param beginCol is number of begin column, 0 is the starting value and is the minimum.
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void WriteExcel(String filePath, String workSheet, Iterator<Object[]> data, int beginRow, int beginCol) throws FileNotFoundException, IOException{
        File file = new File(filePath);
        XSSFWorkbook workbook = file.exists() ? new XSSFWorkbook(new FileInputStream(file)) : new XSSFWorkbook();
        XSSFSheet sheet = workbook.getSheet(workSheet) == null ? workbook.createSheet(workSheet) : workbook.getSheet(workSheet);
        int curRow = beginRow;
        while (data.hasNext()) {
            Object[] rowData = data.next();
            Row row = sheet.getRow(curRow);
            row = row == null ? sheet.createRow(curRow) : row;
            curRow++;
            for (int curCol = beginCol; curCol < beginCol + rowData.length; curCol++) {
                Cell cell = row.getCell(curCol);
                cell = cell == null ? row.createCell(curCol) : cell;
                Object dataCell = rowData[curCol - beginCol];
                if (dataCell instanceof Boolean datacell)   cell.setCellValue(datacell);
                if (dataCell instanceof Integer datacell)   cell.setCellValue(datacell);
                if (dataCell instanceof Long    datacell)   cell.setCellValue(datacell);
                if (dataCell instanceof Double  datacell)   cell.setCellValue(datacell);
                if (dataCell instanceof String  datacell)   cell.setCellValue(datacell);
            }
        }
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);    out.close();
    }
}