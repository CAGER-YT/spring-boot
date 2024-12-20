package com.example.demo;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface TransactionService {

  void importExcelToDatabase(List<MultipartFile> multipartfiles);
  
}
