package wtc.ProcureFlow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import wtc.ProcureFlow.common.Result;
import wtc.ProcureFlow.entity.SalesOrder;
import wtc.ProcureFlow.service.SalesOrderService;

import java.util.List;

@RestController
@RequestMapping("/salesOrder")
public class SalesOrderController {

    @Resource
    private SalesOrderService service;

    @GetMapping("/list")
    public Result<List<SalesOrder>> list() {
        List<SalesOrder> data = service.list();
        if (data.isEmpty()) {
            return Result.error(404, "没有数据");
        } else {
            return Result.success(data);
        }
    }

    @GetMapping("/page")
    public Result<IPage<SalesOrder>> page(
            @RequestParam int current,
            @RequestParam int size,
            @RequestBody(required = false) SalesOrder salesOrder
    ) {
        IPage<SalesOrder> page = service.page(current, size, salesOrder);
        if (page.getSize() == 0) {
            return Result.error(404, "没有数据");
        } else {
            return Result.success(page);
        }
    }

    @PostMapping("/save")
    public Result<?> save(@RequestBody SalesOrder salesOrder) {
        if (!service.save(salesOrder)) {
            return Result.error(404, "保存失败");
        } else {
            return Result.success();
        }
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody SalesOrder salesOrder) {
        if (!service.updateById(salesOrder)) {
            return Result.error(404, "更新失败");
        } else {
            return Result.success();
        }
    }

    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        if (!service.removeById(id)) {
            return Result.error(404, "删除失败");
        } else {
            return Result.success();
        }
    }
}
