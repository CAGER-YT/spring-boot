package com.example.demo;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/transactions")
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  @PostMapping(path = "/import-excel")
  public void importExcelToDatabase(
      @RequestPart(required = true) List<MultipartFile> files) {

    transactionService.importExcelToDatabase(files);

  }
}