package com.lcb.test.formal.dao;

import android.content.Context;

import com.lcb.test.formal.base.BaseApplication;
import com.lcb.test.formal.utils.Contants;
import com.lcb.test.formal.utils.SPUtils;

/**
 * Created by baocheng.liu on 2017/3/20.
 */

public class ConfigDao {
    private static ConfigDao sInstance;

    private Context mContext;

    public static ConfigDao getInstance() {
        if (sInstance == null) {
            synchronized (ConfigDao.class) {
                if (sInstance == null) {
                    sInstance = new ConfigDao();
                }
            }
        }
        return sInstance;
    }

    public ConfigDao() {
        mContext = BaseApplication.getContext();
    }

    /**
     * 用户名
     */
    public void setUserName(String tUserName) {
        SPUtils.put(mContext, Contants.ShardPreName.USERNAME, tUserName);
    }

    public String getUserName() {
        return (String) SPUtils.get(mContext, Contants.ShardPreName.USERNAME, "");
    }

    /**
     * =============================================================================================
     * 密码
     */
    public void setPassWord(String tPassWord) {
        SPUtils.put(mContext, Contants.ShardPreName.PASSWORD, tPassWord);
    }

    public String getPassWord() {
        return (String) SPUtils.get(mContext, Contants.ShardPreName.PASSWORD, "");
    }

    /**
     * =============================================================================================
     * 是否显示密码
     */
    public boolean isShowPassWord() {
        return (boolean) SPUtils.get(mContext, Contants.ShardPreName.SHOW_PASSWORD, false);
    }

    public void setShowPassWord(boolean showPassWord) {
        SPUtils.put(mContext, Contants.ShardPreName.SHOW_PASSWORD, showPassWord);
    }

    /**
     * =============================================================================================
     * 是否记住密码
     */
    public boolean isRemembPassWord() {
        return (boolean) SPUtils.get(mContext, Contants.ShardPreName.REMEMB_PASSWORD, false);
    }

    public void setRemembPassWord(boolean remembPassWord) {
        SPUtils.put(mContext, Contants.ShardPreName.REMEMB_PASSWORD, remembPassWord);
    }
}
