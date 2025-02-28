package wtc.ProcureFlow.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import wtc.ProcureFlow.entity.SalesOrder;

public interface SalesOrderService extends IService<SalesOrder> {

    IPage<SalesOrder> page(int current, int size, SalesOrder salesOrder);
}
