package com.zzh.gclawer;

import com.zzh.gclawer.processor.PageProcessor;
import com.zzh.gclawer.template.SpiderTemplate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zzh
 * @date 2019/8/17
 */
@Component
public class DefaultSpiderTemplateFactory implements SpiderTemplateFactory, InitializingBean {

    @Autowired
    private List<SpiderTemplate> spiderTemplates;

    @Autowired
    private PageProcessorFactory pageProcessorFactory;

    /**
     * 模板类全名
     */
    private Map<String, List<PageProcessor>> pageProcessorMap = new ConcurrentHashMap<>();

    @Override
    public SpiderTemplate getTemplate(Request request) {
        return null;
    }

    @Override
    public SpiderTemplate getTemplate(String templateId) {
        return null;
    }

    @Override
    public PageProcessor getPageProcessor(Request request) {
        if (CollectionUtils.isEmpty(pageProcessorMap.keySet())) {
            throw new NullPointerException("没有找到模板");
        }
        PageProcessor pageProcessor = null;
        if (StringUtils.isEmpty(request.getTemplateId())) {
            List<PageProcessor> pageProcessorList = pageProcessorFactory.getPageProcessorList();
            if (CollectionUtils.isEmpty(pageProcessorList)) {
                throw new NullPointerException("没有找到模板");
            }
            for (PageProcessor processor : pageProcessorList) {
                if (!processor.support(request.getUrl())) {
                    continue;
                }
                pageProcessor = processor;
                request.setTemplateId(pageProcessor.getTemplateClassName());
            }
        } else {
            List<PageProcessor> pageProcessors = pageProcessorMap.get(request.getTemplateId());
            if (CollectionUtils.isEmpty(pageProcessors)) {
                throw new NullPointerException("没有模板对应的页面处理器");
            }
            for (PageProcessor processor : pageProcessors) {
                if (processor.support(request.getUrl())) {
                    pageProcessor = processor;
                    break;
                }
            }
        }
        if (pageProcessor == null) {
            throw new NullPointerException("没有找到url对应的页面处理器");
        }
        return pageProcessor;
    }

    @Override
    public Site getSite(Request request) {
        return Site.me();
//                .setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
    }

    @Override
    public Site getSite(String templateId) {
        return null;
    }

    @Override
    public void afterPropertiesSet() {
        List<PageProcessor> pageProcessorList = pageProcessorFactory.getPageProcessorList();
        if (CollectionUtils.isEmpty(spiderTemplates) || CollectionUtils.isEmpty(pageProcessorList)) {
            return;
        }
        for (SpiderTemplate spiderTemplate : spiderTemplates) {
            for (PageProcessor pageProcessor : pageProcessorList) {
                String templateClassName = pageProcessor.getTemplateClassName();
                if (!spiderTemplate.getClass().getName().equals(templateClassName)) {
                    continue;
                }
                List<PageProcessor> pageProcessors = pageProcessorMap.get(templateClassName);
                if (pageProcessors == null) {
                    pageProcessors = new ArrayList<>();
                }
                pageProcessors.add(pageProcessor);
                pageProcessorMap.put(templateClassName, pageProcessors);
            }
        }
    }
}
