package com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.entity.inEntity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by baocheng.liu on 2017/12/19.
 */

public abstract class InputEntity {

    protected ArrayList<String> errors = new ArrayList<>();

    public boolean checkInput(){
        return true;
    }

    public ArrayList<String> getErrors(){
        return errors;
    }

    public Map<String,String> getParams(){
        HashMap<String,String> params = new HashMap<>();
        params.put("data",jsonThis(this));
        return params;
    }

    public String jsonThis(Object obj){
        return new Gson().toJson(obj);
    }
}
