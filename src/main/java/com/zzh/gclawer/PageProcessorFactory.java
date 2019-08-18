package com.zzh.gclawer;

import com.zzh.gclawer.processor.PageProcessor;

import java.util.List;

/**
 * @author zzh
 * @date 2019/8/17
 */
public interface PageProcessorFactory {

    List<PageProcessor> getPageProcessorList();

}
