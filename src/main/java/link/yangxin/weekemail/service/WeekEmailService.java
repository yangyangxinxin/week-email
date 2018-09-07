package link.yangxin.weekemail.service;

import link.yangxin.weekemail.WeekEmailDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yangxin
 * @date 2018/9/7
 */
@Service
public class WeekEmailService {

    @Resource
    private WeekEmailDao weekEmailDao;

    public void send(List<String> contents){

    }

}