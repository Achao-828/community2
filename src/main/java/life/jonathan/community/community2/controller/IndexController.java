package life.jonathan.community.community2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @PackageName: life.jonathan.community.community2.controller
 * @ClassName: HelloController
 * @Description:
 * @Author: Jonathan
 * @Date: 2019/12/16 10:39
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String hello(){
        return "index";
    }
}
