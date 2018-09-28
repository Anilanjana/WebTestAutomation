package genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	/**
	 * @author Indrapal Singh To configure, read and write excel file(Testdata
	 *         file)
	 */

	private ExcelUtilities() {
		throw new IllegalStateException("Utility class");
	}

	private static XSSFWorkbook excelWorkbook;
	private static XSSFSheet excelSheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	private static String cellData;
	private static FileInputStream excelFile;

	public static void setExcel(String path) throws IOException {
		try {

			excelFile = new FileInputStream(path);
			excelWorkbook = new XSSFWorkbook(excelFile);
			excelSheet = excelWorkbook.getSheetAt(0);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static String readExcel(int rowNum, int colNum) throws IOException {
		try {

			
			
			ExcelUtilities.setExcel(BrowserUtilities.prop.getProperty("pathTestData"));

			row = excelSheet.getRow(rowNum);
			cell = row.getCell(colNum);
			cellData = cell.getStringCellValue();
			excelFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return cellData;
	}

	public static String writeExcel(String result, int rowNum, int colNum) throws IOException {
		try {

			ExcelUtilities.setExcel(BrowserUtilities.prop.getProperty("pathTestData"));

			row = excelSheet.createRow(rowNum);

			cell = row.getCell(colNum, Row.RETURN_BLANK_AS_NULL);

			if (cell == null) {

				cell = row.createCell(colNum);

				cell.setCellValue(result);

			} else {

				cell.setCellValue(result);

			}
			FileOutputStream fileOut = new FileOutputStream(BrowserUtilities.prop.getProperty("pathTestData"));

			excelWorkbook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return cellData;
	}

}
