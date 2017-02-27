package excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.log4j.Logger;

/**
 * @author 张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2016年7月15日 下午5:24:42
 * @version 1.0
 */
public class Tool_jxl {
    private static final Logger LOG = Logger.getLogger(Tool_jxl.class.getName());

    public static void main(String[] args) {
        WritableWorkbook book = null;
        try {
            OutputStream os = new FileOutputStream(new File("E:\\jxl.xls"));
            book = Workbook.createWorkbook(os);
        } catch (IOException e) {
            LOG.error("创建工作本失败", e);
        }
        WritableSheet sheet = book.createSheet("数据", 0);
        sheet.getSettings().setPassword("aaaaaaa");
        Label label0 = new Label(0, 0, "张三");
        // jxl.write.Number number = new jxl.write.Number(1, 0, 30);
        Label label = new Label(0, 2, "A label record"); // put alabel incell A3,Label(column,row)
        try {
            sheet.addCell(label0);
            sheet.addCell(label);
            book.write();
            book.close();
        } catch (RowsExceededException e) {
            LOG.error("写入单元格失败", e);
        } catch (WriteException e) {
            LOG.error("写入单元格失败", e);
        } catch (IOException e) {
            LOG.error("写入工作本失败", e);
        }
    }
}
