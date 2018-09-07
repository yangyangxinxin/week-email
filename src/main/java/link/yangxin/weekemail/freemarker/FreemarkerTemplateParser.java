package link.yangxin.weekemail.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangxin
 * @date 2018/7/17
 */
public class FreemarkerTemplateParser {

    /**
     * 类路径前缀
     */
    private String pathPrefix;

    /**
     * 是否启用缓存
     */
    private boolean cache;

    /**
     * 配置对象
     */
    private Configuration configuration;

    /**
     * 缓存
     */
    private Map<String, Template> tmpMap = new HashMap<>();

    /**
     * 自定义函数
     */
    private List<CustomizeFunction> customizeFunctions;

    public FreemarkerTemplateParser(Configuration configuration) {
        this.configuration = configuration;
    }

    public FreemarkerTemplateParser(String classPath, String pathPrefix, String charset) {
        try {
            Class<?> clazz = Class.forName(classPath);
            configuration = new Configuration();
            configuration.setClassForTemplateLoading(clazz, pathPrefix);
            configuration.setDefaultEncoding(charset);
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public FreemarkerTemplateParser(Class<?> clazz, String pathPrefix) {
        this(clazz, pathPrefix, "UTF-8");
    }

    public FreemarkerTemplateParser(Class<?> clazz, String pathPrefix, String charset) {
        configuration = new Configuration();
        configuration.setClassForTemplateLoading(clazz, pathPrefix);
        configuration.setDefaultEncoding(charset);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    /**
     * 解析模板，返回解析后内容
     *
     * @param templatePath
     * @param params
     * @return
     */
    public String parseTemplate(String templatePath, Map<String, Object> params) {
        Template temp;
        try {
            if (params == null) {
                params = new HashMap<>();
            }
            if (cache) {
                if (tmpMap.containsKey(templatePath)) {
                    temp = tmpMap.get(templatePath);
                } else {
                    temp = configuration.getTemplate(templatePath);
                    tmpMap.put(templatePath, temp);
                }
            } else {
                temp = configuration.getTemplate(templatePath);
            }
            //输出流
            StringWriter writer = new StringWriter();
            temp.process(params, writer);
            return writer.toString();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 清空缓存模板中的内容
     */
    public void clearCache() {
        tmpMap.clear();
    }

    public String getPathPrefix() {
        return pathPrefix;
    }

    public void setPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
    }

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public List<CustomizeFunction> getCustomizeFunctions() {
        return customizeFunctions;
    }

    public void setCustomizeFunctions(List<CustomizeFunction> customizeFunctions) {
        this.customizeFunctions = customizeFunctions;
        for (CustomizeFunction customizeFunction : customizeFunctions) {
            configuration.setSharedVariable(customizeFunction.getName(), customizeFunction);
        }
    }
}