package link.yangxin.weekemail.config;

import link.yangxin.email.java.sdk.client.EmailClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangxin
 * @date 2018/9/7
 */
@Configuration
public class EmailConfig {

    @Value("${email.hosts}")
    private String hosts;

    @Value("${email.username}")
    private String username;

    @Value("${email.password}")
    private String password;

    public EmailClient emailClient(){
        EmailClient emailClient = new EmailClient();
        emailClient.setDebug(true);
        emailClient.setHost(hosts);
        emailClient.setPassword(password);
        emailClient.setUsername(username);
        emailClient.setProtocol("smtp");
        emailClient.setPort(587);
        return emailClient;
    }

}