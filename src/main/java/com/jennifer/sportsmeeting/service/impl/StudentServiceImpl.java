package com.jennifer.sportsmeeting.service.impl;

import com.jennifer.sportsmeeting.bean.Student;
import com.jennifer.sportsmeeting.exception.MyException;
import com.jennifer.sportsmeeting.mapper.StudentMapper;
import com.jennifer.sportsmeeting.service.StudentService;
import com.jennifer.sportsmeeting.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {
    private final static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询列表--TODO：查询不用做事务
     *
     * @return
     */
    @Override
    public List<Student> findAllStudent() {
        List<Student> list = null;
        try {
            list = studentMapper.selectListStudent();
        } catch (Exception e) {
            logger.error("StudentServiceImpl findAllStudent():" + e.getMessage());
        }
        return list;
    }



    /**
     * 分页查询
     *
     * @param page  页号
     * @param limit 每页显示记录数-limit
     * @return
     */
    @Override
    public List<Student> findByPage(int page, int limit, String keyWord) {
        page = (page - 1) * limit;
        List<Student> list = studentMapper.selectByPage(page, limit, keyWord);
        logger.info("list:" + list.size());
        return list;
    }


    @Override
    public int queryById(String id) {
        int count =0;
         count = studentMapper.selectById(id);
        return count;
    }

    @Override
    public int queryCount() {
        int count =0;
        count = studentMapper.selectCount();
        return count;
    }

    /**
     * 修改
     *
     * @param student
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public int modifyStudent(Student student) {
        int num = 0;
        num = studentMapper.updateStudent(student);
        return num;
    }

    @Override
    public int removeStudent(String id) {
        return 0;
    }

    @Override
    @Transactional(readOnly = false)
    public int addStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public boolean readExcel(String fileName, MultipartFile file) throws IOException {
        boolean notNull = false;
        List<Student> studentList = new ArrayList<>();

        //识别文件格式

        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException(110, "上传文件格式不正确");
        }

        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        //读取Excel文件

        InputStream inputStream = file.getInputStream();
        Workbook workbook = null;
        if (isExcel2003) {
            workbook = new HSSFWorkbook(inputStream);
            inputStream.close();
        } else {
            workbook = new XSSFWorkbook(inputStream);
            inputStream.close();
        }


        //循环工作表
        Sheet sheet = null;
        String cell = null;
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {//获取每个Sheet表
            sheet = workbook.getSheetAt(i);
            System.out.println("sheet:" + sheet);
            if (sheet != null) {
                notNull = true;
            }
            for (int j = 0; j < sheet.getLastRowNum(); j++) {//获取每行
                //从第2行读
                Row row = sheet.getRow(j+1);
                System.out.println("row:" + row);

                if (row == null) {
                    continue;
                }
                Student student =null;
                StringBuffer buffer = new StringBuffer();


                for (int k = 0; k < row.getLastCellNum(); k++) {//获取每个单元格
                    System.out.println("cell---:" + row.getCell(k));
                    if (row.getCell(k) == null) {
                        break;
                    }
                    row.getCell(k).setCellType(CellType.STRING);
                    try {
                        cell = row.getCell(k).getStringCellValue();
                        buffer.append(cell + ";");

                        //得到每一行第1个单元格的值
                    } catch (Exception e) {
                        throw new MyException(110, "导入失败(第" + (j + 1) + "行,内容未填写)");
                    }

                }

                System.out.println(buffer);
                try {
                  student =  ExcelUtil.SplitMethod(buffer);
                  studentList.add(student);
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                System.out.println("---Sheet表" + i+1 + "处理完毕---");
            }

        }

        for (Student stu : studentList) {
            //查询是否存在,1存在,0不存在
            int count =  queryById(stu.getsId());
            System.out.println(count);
            if (count == 0) {
                addStudent(stu);
                System.out.println(" 插入 " + stu);
            } else {
                modifyStudent(stu);
                System.out.println(" 更新 " + stu);
            }
        }

        return notNull;
    }






}
