package com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.service;

import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.entity.outEntity.LoginOutEntity;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.net.ActionConstants;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface LoginService{

    @FormUrlEncoded
    @POST(ActionConstants.ACTION_LOGIN)
    Observable<LoginOutEntity> getLogin(@FieldMap Map<String, String> map);

}
