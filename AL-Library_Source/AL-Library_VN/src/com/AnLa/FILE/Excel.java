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

/**Lớp Excel hỗ trợ đọc/ghi dữ liệu từ/vào tệp excel.
 * @author AnLaVN
 */
public class Excel {

    /**Sử dụng phương thức này để đọc dữ liệu từ tệp Excel tại vị trí filePath.
     * @param filePath là vị trí cụ thể của tệp Excel, phần mở rộng tên tệp phải là ".xlsx".
     * @param workSheet là tên của trang tính mà bạn muốn làm việc.
     * @return tất cả ô dữ liệu dưới dạng Iterator từ workSheet trong tệp Excel.
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
    
    
    /**Sử dụng phương thức này để ghi dữ liệu vào tệp Excel tại vị trí filePath.
     * @param filePath là vị trí cụ thể của tệp Excel, phần mở rộng tên tệp phải là ".xlsx".
     * @param workSheet là tên của trang tính mà bạn muốn làm việc.
     * @param data all data as Iterator that you want to write to workSheet in Excel file.
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void WriteExcel(String filePath, String workSheet, Iterator<Object[]> data) throws FileNotFoundException, IOException{
        WriteExcel(filePath, workSheet, data, 0, 0);
    }

    
    /**Sử dụng phương thức này để ghi dữ liệu vào tệp Excel tại vị trí filePath.
     * @param filePath là vị trí cụ thể của tệp Excel, phần mở rộng tên tệp phải là ".xlsx".
     * @param workSheet là tên của trang tính mà bạn muốn làm việc.
     * @param data tất cả dữ liệu dưới dạng Iterator mà bạn muốn ghi vào workSheet trong tệp Excel.
     * @param beginRow là số hàng bắt đầu, 0 là giá trị bắt đầu và là giá trị nhỏ nhất.
     * @param beginCol là số cột bắt đầu, 0 là giá trị bắt đầu và là giá trị nhỏ nhất.
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