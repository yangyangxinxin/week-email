package link.yangxin.weekemail.config;

import link.yangxin.weekemail.freemarker.FreemarkerTemplateParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangxin
 * @date 2018/9/7
 */
@Configuration
public class Freemarker {

    @Bean
    public FreemarkerTemplateParser freemarkerTemplateParser(){
        FreemarkerTemplateParser freemarkerTemplateParser = new FreemarkerTemplateParser(this.getClass(),"/META-INF/email");
        freemarkerTemplateParser.setCache(false);
        return freemarkerTemplateParser;
    }

}