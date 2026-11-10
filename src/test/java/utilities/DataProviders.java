package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name ="LoginData")
    public String[][] getData() throws IOException {

        String path = ".\\testData\\LoginTestData.xlsx";
        ExcelUtility xlutil= new ExcelUtility(path);
       int rowcount= xlutil.getRowCount("sheet1");
       int colcount= xlutil.getCellCount("sheet1",0);
String[][] loginData = new String[rowcount][colcount];
       for(int i=1; i<rowcount; i++){

           for(int j=0;j<colcount;j++){

             loginData[i-1][j] =xlutil.getCellData("sheet1",i, j);
           }
       }


        return loginData;
    }
}
