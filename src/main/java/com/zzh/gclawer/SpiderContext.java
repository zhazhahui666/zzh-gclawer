package com.zzh.gclawer;

import com.zzh.gclawer.spider.Spider;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zzh
 * @date 2019/8/18
 */
@Configuration
public class SpiderContext implements InitializingBean {

    @Autowired
    private Spider spider;

    @Override
    public void afterPropertiesSet() {
        spider.addUrl("https://shenzhen.anjuke.com/?pi=PZ-baidu-pc-all-biaoti");
        spider.start();
    }

}
