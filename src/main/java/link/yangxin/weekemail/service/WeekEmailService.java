package link.yangxin.weekemail.service;

import link.yangxin.email.java.sdk.client.EmailClient;
import link.yangxin.email.java.sdk.message.EmailMessage;
import link.yangxin.email.java.sdk.sender.EmailSender;
import link.yangxin.email.java.sdk.sender.EmailSenderExecutor;
import link.yangxin.weekemail.dal.dao.WeekEmailDao;
import link.yangxin.weekemail.dal.entity.WeekEmail;
import link.yangxin.weekemail.freemarker.FreemarkerTemplateParser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangxin
 * @date 2018/9/7
 */
@Service
public class WeekEmailService {

    @Resource
    private WeekEmailDao weekEmailDao;

    @Resource
    private EmailClient emailClient;

    @Resource
    private FreemarkerTemplateParser freemarkerTemplateParser;

    public void send(List<String> thisWeekContent, List<String> nextWeekContent) {
        EmailSender emailSender = new EmailSenderExecutor(emailClient);
        Map<String, Object> map = new HashMap<>();
        map.put("thisWeekDate", "");
        map.put("thisWeek", thisWeekContent);
        map.put("nextWeek", nextWeekContent);
        String html = freemarkerTemplateParser.parseTemplate("week_template.ftl", map);

        WeekEmail weekEmail = new WeekEmail();
        weekEmail.setContent(html);
        weekEmail.setCreateTime(new Date());

        weekEmailDao.save(weekEmail);

        emailSender.send(EmailMessage.create(html).to("rulin@ebaoquan.org").cc("leader@ebaoquan.org").cc("RD@ebaoquan.org"));

    }

}