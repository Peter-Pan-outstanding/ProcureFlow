package wtc.ProcureFlow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/getAMap")
public class TestController {

    @GetMapping("/test")
    public Map<String,String> test(){
        HashMap<String, String> map = new HashMap<>();
        map.put("name","小明");
        map.put("age","18");
        return map;
    }
}
