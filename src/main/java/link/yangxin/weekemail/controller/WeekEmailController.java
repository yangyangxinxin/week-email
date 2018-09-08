package link.yangxin.weekemail.controller;

import link.yangxin.weekemail.service.WeekEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 周报发送器
 *
 * @author yangxin
 * @date 2018/9/7
 */
@Controller
@RequestMapping("/email")
public class WeekEmailController {

    @Resource
    private WeekEmailService weekEmailService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/send")
    @ResponseBody
    public Object send(HttpServletRequest request) {
        String[] thisWeeks = request.getParameterValues("thisWeek");
        String[] nextWeeks = request.getParameterValues("nextWeek");

        weekEmailService.send(Arrays.asList(thisWeeks),Arrays.asList(nextWeeks));
        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }

}