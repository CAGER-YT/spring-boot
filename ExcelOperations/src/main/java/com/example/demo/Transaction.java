package com.example.demo;

import java.util.Date;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long initiatorId;
  private Long senderId;
  private Long receiverId;
  private double trxnAmount;
  private double feeAmount;
  private int serviceCode;
  private String bankCode;
  
@Default
  private boolean refunded = false;
  private int status;
  @Default
  private boolean success = false;
  @Default
  private boolean deleted = false;

  @CreatedDate
  private Date createdDate;

  @LastModifiedDate
  private Date modifiedDate;

  @CreatedBy
  private Long createdBy;

  @LastModifiedBy
  private Long modifiedBy;


}