package vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to read and write data into excel sheet
 * 
 * @author KRISHNA KANTH
 *
 */
public class ExcelFileLibrary {
	/**
	 * This method will read the date from excel sheet for the sheet name, rowNo,
	 * cellNo given by user.
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName, int rowNo, int celNo)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsLibrary.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNo);
		Cell ce = rw.getCell(celNo);
		String value = ce.getStringCellValue();
		return value;
	}

	/**
	 * This method will provide the last rowNo utilized in a given sheet.
	 * 
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsLibrary.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}

	/**
	 * This method will write the data into excel sheet for user specified Sheet
	 * rowNo,cellNo
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int celNo, String value)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsLibrary.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNo);
		Cell cel = rw.createCell(celNo);
		cel.setCellValue(value);

		FileOutputStream fos = new FileOutputStream(IConstantsLibrary.excelFilePath);
		wb.write(fos);
		wb.close();
		System.out.println("Data written successfully");
	}

	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(IConstantsLibrary.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();

		Object[][] data = new Object[lastRow][lastCell];

		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				// take i+1 in getRow to avoid taking header data from excel sheet,because index from 0.
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
           return data;
	}

}
