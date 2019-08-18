package com.zzh.gclawer.template;

import com.zzh.gclawer.Request;
import com.zzh.gclawer.Site;
import com.zzh.gclawer.processor.PageProcessor;

/**
 * @author zzh
 * @date 2019/8/17
 */
public interface SpiderTemplate {

    Site getSite(Request request);

    Site getSite(String templateId);

    PageProcessor getPageProcessor(Request request);

    PageProcessor addPageProcessor(PageProcessor pageProcessor);

}
