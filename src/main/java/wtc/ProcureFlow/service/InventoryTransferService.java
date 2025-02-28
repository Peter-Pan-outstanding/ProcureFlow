package wtc.ProcureFlow.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import wtc.ProcureFlow.entity.InventoryTransfer;

public interface InventoryTransferService extends IService<InventoryTransfer> {
    IPage<InventoryTransfer> page(int current, int size, InventoryTransfer inventoryTransfer);
}