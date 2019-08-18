package com.zzh.gclawer;

import com.zzh.gclawer.processor.PageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zzh
 * @date 2019/8/17
 */
@Component
public class DefaultPageProcessorFactory implements PageProcessorFactory {

    @Autowired
    private List<PageProcessor> pageProcessorList;

//    @Override
//    public Site getSite(Request request) {
//        Site site = spiderTemplateFactory.getSite(request);
//        return site;
//    }

//    @Override
//    public PageProcessor getPageProcessor(Request request) {
//        List<PageProcessor> pageProcessors = pageProcessorMap.get(request.getTemplateId());
//        if (CollectionUtils.isEmpty(pageProcessors)) {
//            throw new NullPointerException("没有模板对应的页面处理器");
//        }
//        PageProcessor pageProcessor = null;
//        for (PageProcessor processor : pageProcessors) {
//            if (processor.support(request.getUrl())) {
//                pageProcessor = processor;
//                break;
//            }
//        }
//        if (pageProcessor == null) {
//            throw new NullPointerException("没有找到url对应的页面处理器");
//        }
//        return pageProcessor;
//    }


    @Override
    public List<PageProcessor> getPageProcessorList() {
        return pageProcessorList;
    }
}
