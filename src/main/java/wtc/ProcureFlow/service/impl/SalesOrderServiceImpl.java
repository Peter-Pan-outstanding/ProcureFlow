package wtc.ProcureFlow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.ProcureFlow.entity.SalesOrder;
import wtc.ProcureFlow.mapper.SalesOrderMapper;
import wtc.ProcureFlow.service.SalesOrderService;

@Service
public class SalesOrderServiceImpl extends ServiceImpl<SalesOrderMapper, SalesOrder> implements SalesOrderService {

    @Resource
    private SalesOrderMapper mapper;

    @Override
    public IPage<SalesOrder> page(int current, int size, SalesOrder salesOrder) {
        Page<SalesOrder> page = new Page<>(current, size);
        QueryWrapper<SalesOrder> queryWrapper = new QueryWrapper<>();

        if (salesOrder != null) {
            if (salesOrder.getOrderNumber() != null) {
                queryWrapper.like("order_number", salesOrder.getOrderNumber());
            }
            if (salesOrder.getCustomerName() != null) {
                queryWrapper.like("customer_name", salesOrder.getCustomerName());
            }
            if (salesOrder.getDeliveryDate() != null) {
                queryWrapper.eq("delivery_date", salesOrder.getDeliveryDate());
            }
        }

        return mapper.selectPage(page, queryWrapper);
    }
}
