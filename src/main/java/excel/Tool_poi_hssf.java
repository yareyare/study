package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.util.WorkbookUtil;

/** 
 * @author  张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2016年7月14日 上午11:05:49 
 * @version 1.0  
 */
public class Tool_poi_hssf {
    public static void main(String[] args) throws Exception  
    {  
        
        String org = "么么贷";
       
//        POIFSFileSystem pfs = new POIFSFileSystem(new FileInputStream(new File("E:/students_h.xls"))); 
//        EncryptionInfo encInfo = new EncryptionInfo(pfs); 
//        Decryptor decryptor = new EcmaDecryptor(encInfo); 
//        decryptor.verifyPassword("hello");         
        // 第一步，创建一个webbook，对应一个Excel文件  
        String filePath ="E:/students_h.xls";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        POIFSFileSystem file = new POIFSFileSystem(fileInputStream); // openHSSFWorkbook 
        HSSFWorkbook wb = new HSSFWorkbook(file);
        wb.writeProtectWorkbook("password", "username"); 
//        HSSFWorkbook wb = new HSSFWorkbook(pfs);  
//        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
//        HSSFSheet sheet = wb.createSheet("学生表一");  
        String safeName = WorkbookUtil.createSafeSheetName("学生表一"); // returns " O'Brien's sales   "      [O'Brien's sales*?]
        HSSFSheet sheet = wb.createSheet();
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow(0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
        HSSFCell cell = null;
        //机构
        HSSFRow row1 = sheet.createRow(1);  
        cell = row1.createCell(0);
        cell.setCellValue("机构");  
        cell.setCellStyle(style);  
        cell = row1.createCell(1);
        cell.setCellValue(org); 
        
        //下载日期  评分范围
        HSSFRow row2 = sheet.createRow(2);  
        cell = row2.createCell(0);
        cell.setCellStyle(style); 
        cell.setCellValue("下载日期");  
         
        cell = row2.createCell(1);
        cell.setCellStyle(style); 
        cell.setCellValue(Calendar.getInstance().getTime());  
        
        cell = row2.createCell(2);
        cell.setCellStyle(style); 
        cell.setCellValue("评分区间");
        cell = row2.createCell(3);
        cell.setCellStyle(style); 
        cell.setCellValue("80-90");
        
        
        
        HSSFRow row5 = sheet.createRow(2);
        cell = row5.createCell(0);
        cell.setCellValue("学号");  
        cell.setCellStyle(style);  
        cell = row5.createCell(1);
        cell.setCellValue("姓名");  
        cell.setCellStyle(style);  
        cell = row5.createCell(2);  
        cell.setCellValue("年龄");  
        cell.setCellStyle(style);  
        cell = row5.createCell(3);  
        cell.setCellValue("生日");  
        cell.setCellStyle(style);  
  
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
      row = sheet.createRow(3);  
      // 第四步，创建单元格，并设置值  
      row.createCell( 0).setCellValue("1");  
      row.createCell( 1).setCellValue("ivy");  
      row.createCell( 2).setCellValue(30);  
      row.createCell(3).setCellValue(new SimpleDateFormat("yyyy-MM-dd").parse("2016-07-14"));
  
      
        // 第六步，将文件存到指定位置  
        try  
        {   
            FileOutputStream fout = new FileOutputStream("E:/students_h.xls");  
            wb.writeProtectWorkbook("ivy", "123");
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
    }  
    
}
