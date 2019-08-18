package com.zzh.gclawer.download;


import com.zzh.gclawer.Page;
import com.zzh.gclawer.Request;
import com.zzh.gclawer.Site;

/**
 * Downloader is the part that downloads web pages and store in Page object. <br>
 * Downloader has {@link #setThread(int)} method because downloader is always the bottleneck of a crawler,
 * there are always some mechanisms such as pooling in downloader, and pool size is related to thread numbers.
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 */
public interface Downloader {

    /**
     * Downloads web pages and store in Page object.
     *
     * @param request request
     * @param site site
     * @return page
     */
     Page download(Request request, Site site);

    /**
     * Tell the downloader how many threads the spider used.
     * @param threadNum number of threads
     */
     void setThread(int threadNum);
}
