import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWriter {
    public void writeLaptopsToExcel(List<Laptop> laptops, String fileName) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Laptop-Data");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Title");
        headerRow.createCell(1).setCellValue("Price");
        headerRow.createCell(2).setCellValue("Description");
        headerRow.createCell(3).setCellValue("Image URL");

        for (int i = 0; i < laptops.size(); i++) {
            Laptop laptop = laptops.get(i);
            Row dataRow = sheet.createRow(i + 1);
            dataRow.createCell(0).setCellValue(laptop.getTitle());
            dataRow.createCell(1).setCellValue(laptop.getPrice());
            dataRow.createCell(2).setCellValue(laptop.getDescription());
            dataRow.createCell(3).setCellValue(laptop.getImgUrl());
        }

        FileOutputStream outputStream = new FileOutputStream(fileName);
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }
}
