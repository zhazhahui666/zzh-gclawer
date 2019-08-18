package com.zzh.gclawer.listener;

import com.zzh.gclawer.Request;

/**
 * Listener of Spider on page processing. Used for monitor and such on.
 *
 * @author code4crafer@gmail.com
 * @since 0.5.0
 */
public interface SpiderListener {

    void onSuccess(Request request);

    void onError(Request request);
}
