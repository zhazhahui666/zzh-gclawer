package com.zzh.gclawer.pipeline;


import com.zzh.gclawer.ResultItems;

public interface Pipeline {

    /**
     * Process extracted results.
     *
     * @param resultItems resultItems
     */
    void process(ResultItems resultItems);
}
