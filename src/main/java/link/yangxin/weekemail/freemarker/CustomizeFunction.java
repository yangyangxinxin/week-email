package link.yangxin.weekemail.freemarker;

import freemarker.template.TemplateMethodModelEx;

/**
 * 自定义函数
 *
 * @author yangxin
 * @date 2018/7/17
 */
public interface CustomizeFunction extends TemplateMethodModelEx {

    /**
     * 自定义函数调用名称
     *
     * @return 函数名
     */
    String getName();
}