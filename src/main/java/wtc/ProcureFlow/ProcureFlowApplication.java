package wtc.ProcureFlow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("wtc.ProcureFlow.mapper")
public class ProcureFlowApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProcureFlowApplication.class,args);
    }
}
