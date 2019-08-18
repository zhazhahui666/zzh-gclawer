package com.zzh.gclawer.anjuke;

import com.zzh.gclawer.Page;
import com.zzh.gclawer.processor.PageProcessor;
import org.springframework.stereotype.Component;

/**
 * @author zzh
 * @date 2019/8/17
 */
@Component
public class AnjukeProcessor implements PageProcessor {

    @Override
    public void process(Page page) {
        System.out.println(page.getRawText());
    }

    @Override
    public boolean support(String url) {
        return true;
    }

    @Override
    public String getTemplateClassName() {
        return AnjukeTemplate.class.getName();
    }
}
