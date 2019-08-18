package com.zzh.gclawer;

import com.zzh.gclawer.processor.PageProcessor;
import com.zzh.gclawer.template.SpiderTemplate;

/**
 * @author zzh
 * @date 2019/8/17
 */
public interface SpiderTemplateFactory {

    SpiderTemplate getTemplate(Request request);

    SpiderTemplate getTemplate(String templateId);

    PageProcessor getPageProcessor(Request request);

    Site getSite(Request request);

    Site getSite(String templateId);
}
