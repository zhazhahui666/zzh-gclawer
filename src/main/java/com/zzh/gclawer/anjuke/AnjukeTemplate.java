package com.zzh.gclawer.anjuke;

import com.zzh.gclawer.Request;
import com.zzh.gclawer.Site;
import com.zzh.gclawer.processor.PageProcessor;
import com.zzh.gclawer.template.SpiderTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zzh
 * @date 2019/8/17
 */
@Component
public class AnjukeTemplate implements SpiderTemplate {

    @Override
    public Site getSite(Request request) {
        return null;
    }

    @Override
    public Site getSite(String templateId) {
        return null;
    }

    @Override
    public PageProcessor getPageProcessor(Request request) {
        return null;
    }

    @Override
    public PageProcessor addPageProcessor(PageProcessor pageProcessor) {
        return null;
    }
}
