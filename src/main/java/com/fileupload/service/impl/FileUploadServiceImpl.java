package com.fileupload.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fileupload.service.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Override
	public void uploadFile() {
		try {

			File file = ResourceUtils.getFile("classpath:sample.xlsx");
			FileInputStream excelFile = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			DataFormatter formatter = new DataFormatter();

			int row = 0;
			while (iterator.hasNext()) {

				Row currentRow = iterator.next();

				if (row > 1) {

					System.out.println("------------------------------------------" + row);

					if ((row - 2) % 8 == 0) {
						System.out.println(formatter.formatCellValue(currentRow.getCell(0)) + "  "
								+ formatter.formatCellValue(currentRow.getCell(1)) + "  "
								+ formatter.formatCellValue(currentRow.getCell(2)) + " "
								+ formatter.formatCellValue(currentRow.getCell(3)));
					}

					if (((row - 2) % 8 == 0) || ((row - 2) % 8 == 1) || ((row - 2) % 8 == 2)) {
						System.out.println(formatter.formatCellValue(currentRow.getCell(15)) + "  "
								+ formatter.formatCellValue(currentRow.getCell(16)) + "  "
								+ formatter.formatCellValue(currentRow.getCell(17)) + " "
								+ formatter.formatCellValue(currentRow.getCell(18)));
					}

					if (((row - 2) % 8 == 0) || ((row - 2) % 8 == 1) || ((row - 2) % 8 == 2) || ((row - 2) % 8 == 3)
							|| ((row - 2) % 8 == 4) || ((row - 2) % 8 == 5) || ((row - 2) % 8 == 6)) {
						System.out.println(formatter.formatCellValue(currentRow.getCell(21)) + "  "
								+ formatter.formatCellValue(currentRow.getCell(22)) + "  "
								+ formatter.formatCellValue(currentRow.getCell(23)) + " "
								+ formatter.formatCellValue(currentRow.getCell(24)));
					}

					System.out.println("--------------------------------------------");

				}
				row++;
				System.out.println(row);
				

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
