package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/data")
    public @ResponseBody String getData() {
        return testService.getData();
    }

    @GetMapping("/data/params/{first}")
    public @ResponseBody String getDataWithParams(@PathVariable String first, @RequestParam String second) {
        return testService.getDataWithParams(first, second);
    }

    @GetMapping("/data/json")
    public @ResponseBody TestDTO getJson() {
        return testService.getTestDTO();
    }

    @PostMapping("/data/take/post")
    public @ResponseBody TestDTO takeJsonPost(@RequestBody TestDTO testDTO) {
        return testService.takeJson(testDTO);
    }

    @PutMapping("/data/take/post")
    public @ResponseBody TestDTO takeJsonPut(@RequestBody TestDTO testDTO) {
        return testService.takeJson(testDTO);
    }
}
