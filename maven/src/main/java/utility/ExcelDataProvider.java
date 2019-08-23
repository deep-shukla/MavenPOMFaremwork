package utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wbook;
	
	public ExcelDataProvider(){
		
		
		File src= new File("./TestData/testdata1.xlsx");
		FileInputStream fisexcel;
		try {
			fisexcel = new FileInputStream(src);
			wbook= new XSSFWorkbook(fisexcel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to load excel file"+e.getMessage());
		}		
	}
	
	public String getStringData(int SheetIndex,int row, int column){
		return wbook.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String SheetName,int row, int column){
		return wbook.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String SheetName,int row, int column){
		return wbook.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
	}

}
