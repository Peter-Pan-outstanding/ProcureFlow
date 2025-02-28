package wtc.ProcureFlow.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InventoryTransfer {
    private Integer id;
    private String documentNumber;
    private String materialName;
    private String sourceWarehouse;
    private String sourceArea;
    private String sourceLocation;
    private String targetWarehouse;
    private String targetArea;
    private String targetLocation;
    private String batchNumber;
    private String inventoryType;
    private String inventoryMonth;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime inventoryDate;
    private String personInCharge;
    private Integer currentInventory;
    private Integer actualInventory;
    private String reason;
    private String executor;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transferTime;
}