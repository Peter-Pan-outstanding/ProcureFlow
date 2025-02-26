package wtc.ProcureFlow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("wtc.ProcureFlow.mapper") // 扫描你的 Mapper 层所在包
public class ProcureFlowApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProcureFlowApplication.class,args);
    }
}
