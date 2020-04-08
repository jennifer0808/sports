package com.jennifer.sportsmeeting.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.DateUtils;

import javax.management.ObjectName;
import java.io.IOException;
import java.io.InputStream;
@Service("omsAttendanceService")
public class excelService {
    @SuppressWarnings("resource")
    @Transactional(rollbackFor=Exception.class)

    public String importService(String filename, MultipartFile file) throws IOException {
        boolean isExcel2003 = true;
        String str = "";
        if (filename.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet != null) {
            str = "文件上传成功";
        } else {
            str = "上传失败sheet为空";
            return str;
        }
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);

            //从excel第二行开始获取每个单元格的数据

            String vcName = row.getCell(0).getStringCellValue();

            String vcDate = row.getCell(1).getStringCellValue();
            String vcSignin = row.getCell(2).getStringCellValue();
            String vcLeave = row.getCell(3).getStringCellValue();

//            ObjectName va = new ObjectName();
//
//            va.setVcName(vcName);
//            va.setVcDate(DateUtils.getExcelToDate(Integer.parseInt(vcDate)));
//            va.setVcSignin(vcSignin.trim().length()>0 ? DateUtils.getExcelToTime(Double.parseDouble(vcSignin)):"");
//
//            va.setVcLeave(vcLeave.trim().length()>0 ? DateUtils.getExcelToTime(Double.parseDouble(vcLeave)):"");
//            //保存
//            ObjectName Mapper.save(va);
        }
        return str;
    }
}
