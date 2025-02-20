package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	
	
	@DataProvider(name="LoginData")
	public String [] [] getData() throws IOException{
		
		String path =".\\testData\\Project.xlsx";
		ExcelUtility xlfile = new ExcelUtility(path);
		
		int totalrows = xlfile.getRowCount("Sheet1");
		int totalcolms = xlfile.getCellCount("Sheet1",1);
		
		String loginData [][] = new String[totalrows][totalcolms];
		
		for(int i =1; i<=totalrows;i++) {
			for(int j = 0;j<totalcolms;j++) {
				
		      loginData [i-1][j]= xlfile.getCellData("Sheet1", i, j);
			}
		}
		
		return loginData;
 		
		
		
		
		
		
	}

}
