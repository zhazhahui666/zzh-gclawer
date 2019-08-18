package com.zzh.gclawer.scheduler;


import com.zzh.gclawer.Request;

/**
 * Scheduler is the part of url management.<br>
 * You can implement interface Scheduler to do:
 * manage urls to fetch
 * remove duplicate urls
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 */
public interface Scheduler {

    /**
     * add a url to fetch
     *
     * @param request request
     */
    void push(Request request);

    /**
     * get an url to crawl
     *
     * @return the url to crawl
     */
    Request poll();

}
