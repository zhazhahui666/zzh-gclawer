package com.zzh.gclawer.processor;


import com.zzh.gclawer.Page;

public interface PageProcessor {

    /**
     * process the page, extract urls to fetch, extract the data and store
     *
     * @param page page
     */
    void process(Page page);

    boolean support(String url);

    String getTemplateClassName();

}
