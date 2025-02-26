package wtc.ProcureFlow.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OutboundRequest {
    private Integer id;
    private String documentNumber;
    private String status;
    private String applicant;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime applyDate;
    private String approvalStatus;
    private String approver;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime approvalDate;
    private String materialName;
    private Integer quantity;
}
