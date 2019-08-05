package EmotionalAnalysis;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/*
 * @ Author 张丰‎
 * @ Date 2019‎年‎5‎月‎19‎日
 * @content读取Eccel中的 评论,对方法进行封装
 */

public class ReadExcel {
//	public static void main(String[] args) {
//		ReadExcel obj=new ReadExcel();
//		File file=new File("C:/JAVA/SisterTest/Text1.xls");
//		obj.readExcel(file);
//		
//	}
	//去读Excel
	public static ArrayList<String> readExcel(File file) {
		try{
			//创建输入流，读取Excel
			ArrayList<String> LL=new ArrayList<String>();
			InputStream is=new FileInputStream(file.getAbsoluteFile());
			//ixl提供的Workbook类
			Workbook wb=Workbook.getWorkbook(is);
			
			int sheet_size=wb.getNumberOfSheets();
			for(int index=0;index<sheet_size;index++){
				//Excel的页签创建一个Sheet对象
				Sheet sheet=wb.getSheet(index);
				//sheet.getRows()返回该页的总行数
				for(int i=0;i<sheet.getRows();i++){
					//sheet.getColumns()返回该页总列数
//					for(int j=0;j<sheet.getColumns();j++){
						String cellinfo=sheet.getCell(1,i).getContents();
						LL.add(cellinfo);
						
//					}
				}
				
			}
			return LL;
			
			
		}catch(FileNotFoundException e){
			
			e.printStackTrace();
		}catch(BiffException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

}
