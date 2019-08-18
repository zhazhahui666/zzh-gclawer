package com.zzh.gclawer.scheduler;

import com.zzh.gclawer.Request;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Basic Scheduler implementation.<br>
 * Store urls to fetch in LinkedBlockingQueue and remove duplicate urls by HashMap.
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 */
public class QueueScheduler implements Scheduler {

    private BlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    @Override
    public void push(Request request) {
        queue.add(request);
    }

    @Override
    public Request poll() {
        return queue.poll();
    }

}
