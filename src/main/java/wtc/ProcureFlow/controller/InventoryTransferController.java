package wtc.ProcureFlow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import wtc.ProcureFlow.common.Result;
import wtc.ProcureFlow.entity.InventoryTransfer;
import wtc.ProcureFlow.service.InventoryTransferService;

import java.util.List;

@RestController
@RequestMapping("/inventoryTransfer")
public class InventoryTransferController {

    @Resource
    private InventoryTransferService service;

    @GetMapping("/list")
    public Result<List<InventoryTransfer>> list() {
        List<InventoryTransfer> data = service.list();
        return data.isEmpty() ? Result.error(404, "没有数据") : Result.success(data);
    }

    @GetMapping("/page")
    public Result<IPage<InventoryTransfer>> page(@RequestParam int current, @RequestParam int size, @RequestBody(required = false) InventoryTransfer inventoryTransfer) {
        IPage<InventoryTransfer> page = service.page(current, size, inventoryTransfer);
        return page.getSize() == 0 ? Result.error(404, "没有数据") : Result.success(page);
    }

    @PostMapping("/save")
    public Result<?> save(@RequestBody InventoryTransfer inventoryTransfer) {
        return service.save(inventoryTransfer) ? Result.success() : Result.error(404, "保存失败");
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody InventoryTransfer inventoryTransfer) {
        return service.updateById(inventoryTransfer) ? Result.success() : Result.error(404, "更新失败");
    }

    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        return service.removeById(id) ? Result.success() : Result.error(404, "删除失败");
    }

    @DeleteMapping("/deleteBatch")
    public Result<?> deleteBatch(@RequestBody List<Integer> ids) {
        return service.removeByIds(ids) ? Result.success() : Result.error(404, "批量删除失败");
    }
}