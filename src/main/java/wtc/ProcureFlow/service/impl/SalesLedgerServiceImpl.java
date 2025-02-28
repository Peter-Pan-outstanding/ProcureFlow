package wtc.ProcureFlow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.ProcureFlow.entity.SalesLedger;
import wtc.ProcureFlow.mapper.SalesLedgerMapper;
import wtc.ProcureFlow.service.SalesLedgerService;

@Service
public class SalesLedgerServiceImpl
        extends ServiceImpl<SalesLedgerMapper, SalesLedger>
        implements SalesLedgerService {

    @Resource
    private SalesLedgerMapper mapper;

    @Override
    public IPage<SalesLedger> page(int current, int size, SalesLedger salesLedger) {
        Page<SalesLedger> page = new Page<>(current, size);

        QueryWrapper<SalesLedger> queryWrapper = new QueryWrapper<>();

        if (salesLedger != null) {
            if (salesLedger.getContractNumber() != null) {
                queryWrapper.like("contract_number", salesLedger.getContractNumber());
            }
            if (salesLedger.getCustomerName() != null) {
                queryWrapper.like("customer_name", salesLedger.getCustomerName());
            }
            if (salesLedger.getContractDate() != null) {
                queryWrapper.eq("contract_date", salesLedger.getContractDate());
            }
            if (salesLedger.getMaterialName() != null) {
                queryWrapper.like("material_name", salesLedger.getMaterialName());
            }
            if (salesLedger.getUnitPrice() != null) {
                queryWrapper.eq("unit_price", salesLedger.getUnitPrice());
            }
            if (salesLedger.getOrderQuantity() != null) {
                queryWrapper.eq("order_quantity", salesLedger.getOrderQuantity());
            }
            if (salesLedger.getReceivableAmount() != null) {
                queryWrapper.eq("receivable_amount", salesLedger.getReceivableAmount());
            }
            if (salesLedger.getRefundAmount() != null) {
                queryWrapper.eq("refund_amount", salesLedger.getRefundAmount());
            }
        }

        return mapper.selectPage(page, queryWrapper);
    }
}
