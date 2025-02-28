package wtc.ProcureFlow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import wtc.ProcureFlow.common.Result;
import wtc.ProcureFlow.entity.SalesLedger;
import wtc.ProcureFlow.service.SalesLedgerService;

import java.util.List;

@RestController
@RequestMapping("/salesLedger")
public class SalesLedgerController {

    @Resource
    private SalesLedgerService service;

    @GetMapping("/list")
    public Result<List<SalesLedger>> list() {
        List<SalesLedger> data = service.list();
        if (data.isEmpty()) {
            return Result.error(404, "没有数据");
        } else {
            return Result.success(data);
        }
    }

    @GetMapping("/page")
    public Result<IPage<SalesLedger>> page(
            @RequestParam int current,
            @RequestParam int size,
            @RequestBody(required = false) SalesLedger salesLedger
    ) {
        IPage<SalesLedger> page = service.page(current, size, salesLedger);
        if (page.getSize() == 0) {
            return Result.error(404, "没有数据");
        } else {
            return Result.success(page);
        }
    }

    @GetMapping("/get/{id}")
    public Result<SalesLedger> get(@PathVariable Integer id) {
        SalesLedger data = service.getById(id);
        if (data == null) {
            return Result.error(404, "没有数据");
        } else {
            return Result.success(data);
        }
    }

    @PostMapping("/save")
    public Result<?> save(@RequestBody SalesLedger ledger) {
        if (!service.save(ledger)) {
            return Result.error(404, "保存失败");
        } else {
            return Result.success();
        }
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody SalesLedger ledger) {
        if (!service.updateById(ledger)) {
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
