package link.yangxin.weekemail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 周报发送器
 *
 * @author yangxin
 * @date 2018/9/7
 */
@Controller
@RequestMapping("/email")
public class WeekEmailController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/send")
    @ResponseBody
    public Object send(List<String> thisWeekContent,List<String> nextWeekContent) {
        return "success";
    }

}