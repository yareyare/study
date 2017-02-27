package excel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.jxcell.CellException;
import com.jxcell.CellFormat;
import com.jxcell.ConditionFormat;
import com.jxcell.DataValidation;
import com.jxcell.View;

/**
 * @author 张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2016年7月14日 下午5:05:07
 * @version 1.0
 */
public class Tool_jxcell {
    private static final Logger LOG = Logger.getLogger(Tool_jxcell.class.getName());

    /**
     * 读取excel，并进行加密
     * 
     * @param url
     *            excel文件路径 例：D:\\word.xls
     * @param pwd
     *            加密密码
     */
    public static void encrypt(String url, String pwd) {
        View view = new View();
        try {
            view.setText(0, 0, "机构");
            view.setText(0, 1, "么么贷");
            view.setText(1, 0, "日期");
            view.setText(1, 1, SimpleDateFormat.getInstance().format(Calendar.getInstance().getTime()));
            view.setText(1, 2, "评分区间");
            view.setText(1, 3, "80-90");
            view.setText(2, 0, "50");
            view.setText(2, 1, "50");
            view.setFormula(2, 2, "SUM(A3:B3)");
            DataValidation dataValidation = view.CreateDataValidation();
            dataValidation.setType(DataValidation.eUser);
            view.setSelection("C1:F8");
            dataValidation.setFormula1("\"dddd\0gggg\0hhh\"");

            // view.editCopyRight();
            try {
                view.setDataValidation(dataValidation);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            view.write(url, pwd);
        } catch (CellException e) {
            LOG.error("加密失败！", e);
        } catch (IOException e) {
            LOG.error("写入excell错误！", e);
        }
    }

    /**
     * excel 解密
     * 
     * @return void
     * @author lifq
     * @date 2015-3-13 下午02:15:49
     */
    public static void decrypt(String url, String pwd) {
        View view = new View();
        // read the encrypted excel file
        try {
            view.read(url, pwd);
        } catch (IOException e) {
            LOG.error("读取excell错误！", e);
        } catch (CellException e) {
            LOG.error("解密失败！", e);
        }
    }

    private static void test() {
        View m_view = new View();
        try {
            // m_view.getLock();
            ConditionFormat condfmt[] = new ConditionFormat[3];
            condfmt[0] = m_view.CreateConditionFormat();
            condfmt[1] = m_view.CreateConditionFormat();
            condfmt[2] = m_view.CreateConditionFormat();

            // Condition #1
            CellFormat cf = condfmt[0].getCellFormat();
            // condfmt[0].setType(ConditionFormat.TypeFormula);
            // condfmt[0].setFormula1("and(iseven(row()), $D1 > 1000)", 0, 0);
            cf.setFontColor(0x0D8427);
            cf.setPattern((short) 1);
            cf.setPatternFG(0x0D8427);
            condfmt[0].setCellFormat(cf);

            // Condition #2
            // condfmt[1].setType(ConditionFormat.TypeFormula);
            // cf.setFontColor(0xffffff);
            condfmt[1].setCellFormat(cf);

            // Condition #3
            // condfmt[2].setType(ConditionFormat.TypeCell);
            // condfmt[2].setFormula1("500", 0, 0);
            // condfmt[2].setOperator(ConditionFormat.OperatorGreaterThan);
            // cf=condfmt[2].getCellFormat();
            // cf.setFontColor(0xff0000);
            // condfmt[2].setCellFormat(cf);

            // Select the range and apply conditional formatting
            m_view.setSelection(0, 0, 39, 3);
            m_view.setConditionalFormats(condfmt);

            m_view.write("./sonditionFormats.xls");
            com.jxcell.designer.Designer.newDesigner(m_view);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            m_view.releaseLock();
        }
    }

    public static void main(String args[]) {
        // 下面1与2 两个方法请分开执行，可以看到效果
        //
        // 1. 把g:\\test.xls 添加打开密码123
         Tool_jxcell.encrypt("E:\\test.xls", "123");
        // 2. 把g:\\test.xls 密码123 去除
        // Tool_jxcell.decrypt("E:\\test.xls", "111");
        // test();
//        test1();
    }

    public static void test1() {
        try {
            View m_view = new View();
            try {
                m_view.getLock();
                ConditionFormat condfmt[] = new ConditionFormat[1];
                condfmt[0] = m_view.CreateConditionFormat();

                // Condition #1
                CellFormat cf = condfmt[0].getCellFormat();
                condfmt[0].setType(ConditionFormat.TypeCell);
//                condfmt[0].setFormula1("and(iseven(row()), $D1 > 1000)", 0, 0);
                cf.setFontColor(0x00ff00); //白
                cf.setPattern((short) 1);
                cf.setPatternFG(0x99ccff); //蓝色
                condfmt[0].setCellFormat(cf);

                // Condition #2
//                condfmt[1].setType(ConditionFormat.TypeFormula);
//                condfmt[1].setFormula1("iseven($A1)", 0, 0);
//                cf.setFontColor(0xffffff);//黑色
//                condfmt[1].setCellFormat(cf);

                // Condition #3
//                condfmt[2].setType(ConditionFormat.TypeCell);
//                condfmt[2].setFormula1("500", 0, 0);
//                condfmt[2].setOperator(ConditionFormat.OperatorGreaterThan);
//                cf = condfmt[2].getCellFormat();
//                cf.setFontColor(0xff0000); //红色
//                condfmt[2].setCellFormat(cf);

                // Select the range and apply conditional formatting
                m_view.setSelection(0, 0, 39, 3);
                m_view.setConditionalFormats(condfmt);

                m_view.write("E:\\conditionFormats.xls");
                com.jxcell.designer.Designer.newDesigner(m_view);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                m_view.releaseLock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
