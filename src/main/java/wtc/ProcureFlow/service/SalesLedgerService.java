package wtc.ProcureFlow.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import wtc.ProcureFlow.entity.SalesLedger;

public interface SalesLedgerService extends IService<SalesLedger> {

    IPage<SalesLedger> page(int current, int size, SalesLedger salesLedger);
}
