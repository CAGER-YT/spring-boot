package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.*;


@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  private TransactionRepository transactionRepository;

  @Override
  public void importExcelToDatabase(List<MultipartFile> multipartfiles) {
    if (!multipartfiles.isEmpty()) {
      List<Transaction> transactions = new ArrayList<>();
      multipartfiles.forEach(multipartfile -> {
        try {
          XSSFWorkbook workBook = new XSSFWorkbook(multipartfile.getInputStream());

          XSSFSheet sheet = workBook.getSheetAt(0);
          // looping through each row
          for (int rowIndex = 0; rowIndex < getNumberOfNonEmptyCells(sheet, 0) - 1; rowIndex++) {
            // current row
            XSSFRow row = sheet.getRow(rowIndex);
            // skip the first row because it is a header row
            if (rowIndex == 0) {
              continue;
            }
            Long senderId = Long.parseLong(getValue(row.getCell(0)).toString());
            Long receiverId = Long.parseLong(getValue(row.getCell(1)).toString());
            Long initiatorId = Long.parseLong(getValue(row.getCell(2)).toString());
            String bankCode = String.valueOf(row.getCell(3));
            int serviceCode = Integer.parseInt(getValue(row.getCell(4)).toString());
            double transactionAmount = Double.parseDouble(row.getCell(5).toString());
            double feeAmount = Double.parseDouble(row.getCell(6).toString());

            Transaction transaction =Transaction.builder().senderId(senderId).receiverId(receiverId)
            		.initiatorId(initiatorId).bankCode(bankCode).serviceCode(serviceCode).trxnAmount(transactionAmount).feeAmount(feeAmount).build();

            transactions.add(transaction);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      });

      if (!transactions.isEmpty()) {
        // save to database
        transactionRepository.saveAll(transactions);
      }
    }
  }

  private Object getValue(Cell cell) {
    switch (cell.getCellType()) {
      case STRING:
        return cell.getStringCellValue();
      case NUMERIC:
        return String.valueOf((int) cell.getNumericCellValue());
      case BOOLEAN:
        return cell.getBooleanCellValue();
      case ERROR:
        return cell.getErrorCellValue();
      case FORMULA:
        return cell.getCellFormula();
      case BLANK:
        return null;
      case _NONE:
        return null;
      default:
        break;
    }
    return null;
  }

  public static int getNumberOfNonEmptyCells(XSSFSheet sheet, int columnIndex) {
    int numOfNonEmptyCells = 0;
    for (int i = 0; i <= sheet.getLastRowNum(); i++) {
      XSSFRow row = sheet.getRow(i);
      if (row != null) {
        XSSFCell cell = row.getCell(columnIndex);
        if (cell != null && cell.getCellType() != CellType.BLANK) {
          numOfNonEmptyCells++;
        }
      }
    }
    return numOfNonEmptyCells;
  }

}