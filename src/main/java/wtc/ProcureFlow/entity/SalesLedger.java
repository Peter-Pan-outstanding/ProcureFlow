package wtc.ProcureFlow.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SalesLedger {

    private Integer contractId;
    private String contractNumber;
    private String customerName;
    private Double contractAmount;
    private LocalDateTime contractDate;
    private String materialName;
    private String model;
    private String specification;
    private Double unitPrice;
    private Integer orderQuantity;
    private Double receivableAmount;
    private Double refundAmount;
}
