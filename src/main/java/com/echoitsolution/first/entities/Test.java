package com.echoitsolution.first.entities;

import com.echoitsolution.first.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(
        name = "test",
        schema = "test_schema",
        catalog = "securitydb",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_test_emailId_phoneNo", columnNames = {"emailId","phoneNo"}),
                @UniqueConstraint(name = "uk_test_name_emailId", columnNames = {"name","emailId"})
        },
        indexes = {
                @Index(name = "idx_test_emailId", unique = true, columnList = "emailId"),
                @Index(name = "idx_test_name_city", unique = true, columnList = "name,city")
        }
)
public class Test {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String name;

    @Column(name = "user_email", unique = true)
    private Integer emailId;

    @Column(name = "user_phone", unique = true)
    private String phoneNo;

    private String city;

    @Column(insertable = true, updatable = false)
    private Date createdOn;

    private Long createdBy;

    @Enumerated(EnumType.STRING) // default : EnumType.ORDINAL
    @Column(name = "status", columnDefinition = "VARCHAR(20) DEFAULT 'INACTIVE'")
    private Status status;

    @Column(name = "amount", precision = 15, scale = 2)
    private Double amount;

}
