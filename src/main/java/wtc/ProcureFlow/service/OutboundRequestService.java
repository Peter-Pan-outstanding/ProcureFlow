package wtc.ProcureFlow.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import wtc.ProcureFlow.entity.OutboundRequest;

public interface OutboundRequestService extends IService<OutboundRequest> {

    public IPage<OutboundRequest> page(int current, int size,OutboundRequest outboundRequest);
}
