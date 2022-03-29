package io.atlant.ledger.service;

import io.atlant.ledger.model.Transaction;
import io.atlant.ledger.repository.TransactionRepo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class TransactionService {

    private TransactionRepo transactionRepo;

    @Autowired
    public void setTransactionRepo(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public List<Transaction> findAll() {
        return transactionRepo.findAll();
    }

    public File getAllTransactionHistoryInExcel() throws IOException {
        String FILE_PATH = "C:\\Projects\\atlant\\disk\\excel\\";

        List<Transaction> transactions = this.findAll();
        String jsonStr = this.formatListToJsonStr(transactions);

        // Excel line number limit is 1 048 576, sheets are limitless
        // TODO: Write constrain to avoid this issue
        try (Workbook workbook = new HSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("transactions");

            for (int i = 0; i < transactions.size(); i++) {
                Row row = sheet.createRow(i);

                row.createCell(0).setCellValue(transactions.get(i).getId().toString());
                row.createCell(1).setCellValue(transactions.get(i).getTimestamp().toString());
                row.createCell(2).setCellValue(transactions.get(i).getValue().toString());

                sheet.autoSizeColumn(i);
            }

            workbook.write(new FileOutputStream(FILE_PATH + "test.xls"));

        }

        return null;
    }

    private String formatListToJsonStr(List<Transaction> transactions) {
        StringBuilder retVal = new StringBuilder();

        retVal.append("[");
        transactions.forEach(t -> {
            retVal.append(t.toString()).append(", ");
        });
        retVal.append("]");

        return retVal.toString();
    }
}
