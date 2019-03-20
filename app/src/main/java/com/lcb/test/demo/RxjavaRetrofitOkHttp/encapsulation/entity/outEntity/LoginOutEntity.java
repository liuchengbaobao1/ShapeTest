package com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.entity.outEntity;

import com.google.gson.annotations.Expose;

/**
 * Created by baocheng.liu on 2017/12/13.
 */

public class LoginOutEntity extends OutputEntity{
     public String empno;
     public String username;
     public String name;
     public String deptname;

    public String toString() {
        return "code:" + code
                + "\nmessage:" + getErrorMsg()
                + "\nstate:" + state
                + "\nempno:" + empno
                + "\nusername:" + username
                + "\nname:" + name
                + "\ndeptname:" + deptname;
    }
}
