package com.XiangDeng.first_project_java_spring;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class HelloController {

    @GetMapping("/")
    public String hello1() {
        return "Hello there, in my first Spring controller. <br>" +
                "大家好啊 我喜欢Yorushika";
    }

    @GetMapping("/wocao")
    public String hello2() {
        return "枣尚豪！！！！ 老师让我写这个的 虽然我啥都不会嘻嘻";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name",name);
        return "greeting";
    }
}