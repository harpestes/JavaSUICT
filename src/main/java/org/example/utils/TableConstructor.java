package org.example.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.dto.ProductDTO;
import org.example.mapper.ProductMapper;
import org.example.model.Category;
import org.example.model.Product;
import org.example.model.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class TableConstructor {
    public static void writeDataToExcel(String filePath, List<Product> products, List<Category> categories, List<User> users) {
        try (Workbook workbook = new XSSFWorkbook()) {
            writeSheet(workbook, "Products", ProductMapper.toDTO(products), ProductDTO.class);
            writeSheet(workbook, "Categories", categories, Category.class);
            writeSheet(workbook, "Users", users, User.class);

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <T> void writeSheet(Workbook workbook, String sheetName, List<T> dataList, Class<T> dataType) {
        Sheet sheet = workbook.createSheet(sheetName);
        createHeaderRow(sheet, dataType);

        int rowNum = 1;
        for (T data : dataList) {
            Row row = sheet.createRow(rowNum++);
            writeDataToRow(row, data);
        }
    }

    private static <T> void createHeaderRow(Sheet sheet, Class<T> dataType) {
        Row headerRow = sheet.createRow(0);
        Field[] fields = dataType.getDeclaredFields();
        int colNum = 0;
        for (Field field : fields) {
            Cell cell = headerRow.createCell(colNum++);
            cell.setCellValue(field.getName());
        }
    }

    private static <T> void writeDataToRow(Row row, T data) {
        Field[] fields = data.getClass().getDeclaredFields();
        int colNum = 0;

        for (Field field : fields) {
            field.setAccessible(true);
            Cell cell = row.createCell(colNum++);
            try {
                Object value = field.get(data);
                if (value != null) {
                    if (value instanceof List) {
                        value = String.join(", ", (List<String>) value);
                    }
                    cell.setCellValue(value.toString());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            field.setAccessible(false);
        }
    }
}
