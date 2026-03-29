package com.zenmen.palmchat.circle.ui.config;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import defpackage.rl0;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleConfig implements Serializable {
    public static final String COUPON_CARD_HOLDER_URL = "https://a.yuanyipos.com/zqb-taskActive-LD/hongbaoRecord.html";
    public static final String COUPON_CARD_HOLDER_URL_TEST = "https://zqbtest.shengpay.com/zqb-taskActive-LD/hongbaoRecord.html";
    public static final int FROM_TYPE_FIND_FRIEND_TAB = 101;
    public static final int FROM_TYPE_LX_HOME = 102;
    public static final String URL_CREATE_CIRCLE_DEF = "http://test.lianwifi.com/lianxin/";
    public static final String VALUE_REMIND_ALL_OF_PERSON = "8888888888888888";

    @SerializedName("cardurl")
    private String cardUrl;
    private int groupTime;
    private String mUrlCreateCircle = URL_CREATE_CIRCLE_DEF;

    public static CircleConfig getConfig() {
        return (CircleConfig) rl0.h().d().getDynamicConfig(DynamicConfig.Type.CIRCLE_CONFIG).parseExtra(CircleConfig.class);
    }

    public static String getCouponUrl() {
        CircleConfig config = getConfig();
        return (config == null || TextUtils.isEmpty(config.getCardUrl())) ? getCouponUrlInternal() : config.cardUrl;
    }

    private static String getCouponUrlInternal() {
        return COUPON_CARD_HOLDER_URL;
    }

    public String getCardUrl() {
        return this.cardUrl;
    }

    public int getGroupTime() {
        return this.groupTime;
    }

    public String getUrlCreateCircle() {
        return this.mUrlCreateCircle;
    }

    public void setCardUrl(String str) {
        this.cardUrl = str;
    }

    public void setGroupTime(int i) {
        this.groupTime = i;
    }

    public void setUrlCreateCircle(String str) {
        this.mUrlCreateCircle = str;
    }
}
