package com.lcb.test.demo.RxjavaRetrofitOkHttp.noEncapsulation;

import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.entity.outEntity.LoginOutEntity;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface HttpPostService {

    @FormUrlEncoded
    @POST("sdm.do?action=LOGIN")
    Observable<LoginOutEntity> getLogin(@FieldMap Map<String, String> map);

}
