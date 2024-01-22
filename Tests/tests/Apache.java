package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Apache {

    public void main (String[] args) throws FileNotFoundException{

        String excelFilePath = "";

        // To read the excel file we use the FileInputStream Method

        FileInputStream input =  new FileInputStream(excelFilePath);

        // Now use a class in apache which is XSSFWorkbook we get the work book from FileinputStream
        //From the workbook we get the sheet, workbook.geSheet method


    }
    
}
