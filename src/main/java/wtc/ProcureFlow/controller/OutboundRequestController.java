package wtc.ProcureFlow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import wtc.ProcureFlow.common.Result;
import wtc.ProcureFlow.entity.OutboundRequest;
import wtc.ProcureFlow.service.OutboundRequestService;

import java.util.List;

@RestController
@RequestMapping("/outbound")
public class OutboundRequestController {

    @Resource
    private OutboundRequestService service;

    @GetMapping("/list")
    public Result<List<OutboundRequest>> list() {
        List<OutboundRequest> data = service.list();
        if (data.isEmpty()) {
            return Result.error(404, "没有数据");
        }else {
            return Result.success(data);
        }
    }

    @GetMapping("/page")
    public Result<IPage<OutboundRequest>> page(
            @RequestParam int current,
            @RequestParam int size,
            @RequestBody(required = false) OutboundRequest outboundRequest
    ) {
        IPage<OutboundRequest> page = service.page(current, size, outboundRequest);
        if (page.getSize() == 0) {
            return Result.error(404,"没有数据");
        } else {
            return Result.success(page);
        }
    }

    @GetMapping("/get/{id}")
    public Result<OutboundRequest> get(@PathVariable Integer id) {
        OutboundRequest data = service.getById(id);
        if (data == null) {
            return Result.error(404,"没有数据");
        } else {
            return Result.success(data);
        }
    }

    @PostMapping("/save")
    public Result<?> save(@RequestBody OutboundRequest request) {
        if (!service.save(request)){
            return Result.error(404,"保存失败");
        }else {
            return Result.success();
        }
    }

    @PutMapping("/update")
    public Result<?> update( @RequestBody OutboundRequest request) {
        if (!service.updateById(request)) {
            return Result.error(404, "更新失败");
        } else {
            return Result.success();
        }
    }

    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        if (!service.removeById(id)) {
            return Result.error(404,"删除失败");
        } else {
            return Result.success();
        }
    }
}
