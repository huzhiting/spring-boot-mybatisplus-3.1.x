package com.example.mybatisplus.export;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @Description : 导出Excel文件
 * @Author : huzhiting
 * @Date: 2020-03-24 16:02
 */
@Service
public class ExportFile {

    private static final int SIZE_OF_PER_SHEET = 100;

    /**
     * 写入Excel，每页sheet默认100条数据，大于则创建新的sheet页
     * @param pathName
     * @param dataInfo
     * @param T
     * @throws Exception
     */
    public void writeExcel(String pathName, List<? extends BaseRowModel> dataInfo,Class<?> T) throws Exception {

        ExcelWriter writer = null;
        // 文件输出位置
        OutputStream out = null;
        try {
            out = new FileOutputStream(pathName);
            writer = EasyExcelFactory.getWriter(out);
            int currentSheet = 1;
            int leftRecords = dataInfo.size();
            do{
                Sheet sheet = createNewSheet(currentSheet,T);
                int fromIndex = (currentSheet - 1) * SIZE_OF_PER_SHEET;
                int toIndex = fromIndex + (leftRecords > SIZE_OF_PER_SHEET ? SIZE_OF_PER_SHEET : leftRecords);
                // 写数据到 Writer 上下文中
                // 入参1: 创建要写入的模型数据
                // 入参2: 要写入的目标 sheet
                writer.write(dataInfo.subList(fromIndex,toIndex), sheet);
                currentSheet ++ ;
                leftRecords-=SIZE_OF_PER_SHEET;
            }while (leftRecords > 0);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 将上下文中的最终 outputStream 写入到指定文件中
            writer.finish();
            // 关闭流
            out.close();
        }
    }

    /**
     * 创建新的sheet页
     * @param currentSheet
     * @param T
     * @return
     */
    private Sheet createNewSheet(int currentSheet, Class T) {
        // 创建新的Sheet
        Sheet sheet = new Sheet(currentSheet, 0, T);
        // sheet 名称
        sheet.setSheetName("Sheet" + currentSheet);
        return sheet;
    }
}
