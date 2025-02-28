package wtc.ProcureFlow.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.ProcureFlow.entity.InventoryTransfer;
import wtc.ProcureFlow.mapper.InventoryTransferMapper;
import wtc.ProcureFlow.service.InventoryTransferService;


@Service
public class InventoryTransferServiceImpl extends ServiceImpl<InventoryTransferMapper, InventoryTransfer> implements InventoryTransferService {

    @Resource
    private InventoryTransferMapper mapper;

    @Override
    public IPage<InventoryTransfer> page(int current, int size, InventoryTransfer inventoryTransfer) {
        Page<InventoryTransfer> page = new Page<>(current, size);
        QueryWrapper<InventoryTransfer> queryWrapper = new QueryWrapper<>();
        if (inventoryTransfer != null) {
            if (inventoryTransfer.getMaterialName() != null) {
                queryWrapper.like("material_name", inventoryTransfer.getMaterialName());
            }
            if (inventoryTransfer.getBatchNumber() != null) {
                queryWrapper.eq("batch_number", inventoryTransfer.getBatchNumber());
            }
            if (inventoryTransfer.getSourceWarehouse() != null) {
                queryWrapper.eq("source_warehouse", inventoryTransfer.getSourceWarehouse());
            }
            if (inventoryTransfer.getSourceArea() != null) {
                queryWrapper.eq("source_area", inventoryTransfer.getSourceArea());
            }
            if (inventoryTransfer.getSourceLocation() != null) {
                queryWrapper.eq("source_location", inventoryTransfer.getSourceLocation());
            }
            if (inventoryTransfer.getTargetWarehouse() != null) {
                queryWrapper.eq("target_warehouse", inventoryTransfer.getTargetWarehouse());
            }
            if (inventoryTransfer.getTargetArea() != null) {
                queryWrapper.eq("target_area", inventoryTransfer.getTargetArea());
            }
            if (inventoryTransfer.getTargetLocation() != null) {
                queryWrapper.eq("target_location", inventoryTransfer.getTargetLocation());
            }
            if (inventoryTransfer.getTransferTime() != null) {
                queryWrapper.eq("transfer_time", inventoryTransfer.getTransferTime());
            }
            if (inventoryTransfer.getExecutor() != null) {
                queryWrapper.like("executor", inventoryTransfer.getExecutor());
            }
        }
        return mapper.selectPage(page, queryWrapper);
    }
}