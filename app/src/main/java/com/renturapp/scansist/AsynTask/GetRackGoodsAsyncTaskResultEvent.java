package com.renturapp.scansist.AsynTask;

/**
 * Created by Wayne on 10/08/2015.
 */
public class GetRackGoodsAsyncTaskResultEvent {
    private final String result;

    public GetRackGoodsAsyncTaskResultEvent(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
