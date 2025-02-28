package wtc.ProcureFlow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.ProcureFlow.entity.OutboundRequest;
import wtc.ProcureFlow.mapper.OutboundRequestMapper;
import wtc.ProcureFlow.service.OutboundRequestService;

@Service
public class OutboundRequestServiceImpl
        extends ServiceImpl<OutboundRequestMapper, OutboundRequest>
        implements OutboundRequestService {

    @Resource
    private OutboundRequestMapper mapper;


    @Override
    public IPage<OutboundRequest> page(int current, int size, OutboundRequest outboundRequest) {

        Page<OutboundRequest> page = new Page<>(current, size);

        QueryWrapper<OutboundRequest> queryWrapper = new QueryWrapper<>();

        if (outboundRequest != null) {
            if (outboundRequest.getDocumentNumber() != null) {
                queryWrapper.like("document_number", outboundRequest.getDocumentNumber());
            }
            if (outboundRequest.getStatus() != null) {
                queryWrapper.eq("status", outboundRequest.getStatus());
            }
            if (outboundRequest.getApplicant() != null) {
                queryWrapper.like("applicant", outboundRequest.getApplicant());
            }
            if (outboundRequest.getApplyDate() != null) {
                queryWrapper.eq("apply_date", outboundRequest.getApplyDate());
            }
            if (outboundRequest.getApprovalStatus() != null) {
                queryWrapper.eq("approval_status", outboundRequest.getApprovalStatus());
            }
            if (outboundRequest.getApprover() != null) {
                queryWrapper.like("approver", outboundRequest.getApprover());
            }
            if (outboundRequest.getApprovalDate() != null) {
                queryWrapper.eq("approval_date", outboundRequest.getApprovalDate());
            }
            if (outboundRequest.getMaterialName() != null) {
                queryWrapper.like("material_name", outboundRequest.getMaterialName());
            }
            if (outboundRequest.getQuantity() != null) {
                queryWrapper.eq("quantity", outboundRequest.getQuantity());
            }
        }

        return mapper.selectPage(page, queryWrapper);
    }
}
