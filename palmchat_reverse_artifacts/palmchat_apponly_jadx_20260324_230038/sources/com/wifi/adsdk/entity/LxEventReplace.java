package com.wifi.adsdk.entity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxEventReplace {
    public static final String Sld_HONOR_NORMAL = "1";
    public static final String Sld_HONOR_XS = "3";
    public static final String Sld_HONOR_YY = "2";
    public static final String Sld_NORMAL = "0";
    public static final String Sld_OPPO_NORMAL = "1";
    public static final String Sld_OPPO_XS = "3";
    public static final String Sld_XS = "1";
    public static final String Sld_YY = "2";
    public static final String __AD_H__ = "__AD_H__";
    public static final String __AD_LT_X__ = "__AD_LT_X__";
    public static final String __AD_LT_Y__ = "__AD_LT_Y__";
    public static final String __AD_RB_X__ = "__AD_RB_X__";
    public static final String __AD_RB_Y__ = "__AD_RB_Y__";
    public static final String __AD_W__ = "__AD_W__";
    public static final String __BEGIN_TIME__ = "__BEGIN_TIME__";
    public static final String __CALL_UP_RESULT__ = "__CALL_UP_RESULT__";
    public static final String __CARRIER__ = "__CARRIER__";
    public static final String __CLICKAREA__ = "__CLICKAREA__";
    public static final String __DENSITY__ = "__DENSITY__";
    public static final String __DLD_PHASE__ = "__DLD_PHASE__";
    public static final String __DOWN_TIME__ = "__DOWN_TIME__";
    public static final String __DOWN_X__ = "__DOWN_X__";
    public static final String __DOWN_Y__ = "__DOWN_Y__";
    public static final String __DP_REASON__ = "__DP_REASON__";
    public static final String __DP_RESULT__ = "__DP_RESULT__";
    public static final String __END_TIME__ = "__END_TIME__";
    public static final String __MAX_SHOW_RATIO__ = "__MAX_SHOW_RATIO__";
    public static final String __NET_TYPE__ = "__NET_TYPE__";
    public static final String __OAID__ = "__OAID__";
    public static final String __SHOW_TIME__ = "__SHOW_TIME__";
    public static final String __SLD__ = "__SLD__";
    public static final String __TS__ = "__TS__";
    public static final String __TURN_TIME__ = "__TURN_TIME__";
    public static final String __TURN_X__ = "__TURN_X__";
    public static final String __TURN_Y__ = "__TURN_Y__";
    public static final String __TURN_Z__ = "__TURN_Z__";
    public static final String __UP_TIME__ = "__UP_TIME__";
    public static final String __UP_X__ = "__UP_X__";
    public static final String __UP_Y__ = "__UP_Y__";
    public static final String __VIDEO_TIME__ = "__VIDEO_TIME__";
    public static final String __WIN_PRICE__ = "__WIN_PRICE__";
    public static final String __X_MAX_ACC__ = "__X_MAX_ACC__";
    public static final String __Y_MAX_ACC__ = "__Y_MAX_ACC__";
    public static final String __Z_MAX_ACC__ = "__Z_MAX_ACC__";
    private String TS;
    private String WinPrice;
    private String apiKey;
    private String clickAre;
    private boolean clickEvent;
    private String clickX;
    private String clickY;
    private String density;
    private String dldStatus;
    private String dpReason;
    private String dpResult;
    private String hwDownTime;
    private String hwMaxShowRatio;
    private String hwShowTime;
    private String hwUpTime;
    private String hwXAcc;
    private String hwYAcc;
    private String hwZAcc;
    private String lTX;
    private String lTY;
    private String rBX;
    private String rBY;
    private boolean showEvent;
    private String sld;
    private String upX;
    private String upY;
    private String videoTime;
    private String wxCall;

    public LxEventReplace(String str) {
        this.apiKey = str;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getClickAre() {
        return this.clickAre;
    }

    public String getClickX() {
        return this.clickX;
    }

    public String getClickY() {
        return this.clickY;
    }

    public String getDensity() {
        return this.density;
    }

    public String getDldStatus() {
        return this.dldStatus;
    }

    public String getDpReason() {
        return this.dpReason;
    }

    public String getDpResult() {
        return this.dpResult;
    }

    public String getHwDownTime() {
        return this.hwDownTime;
    }

    public String getHwMaxShowRatio() {
        return this.hwMaxShowRatio;
    }

    public String getHwShowTime() {
        return this.hwShowTime;
    }

    public String getHwUpTime() {
        return this.hwUpTime;
    }

    public String getHwXAcc() {
        return this.hwXAcc;
    }

    public String getHwYAcc() {
        return this.hwYAcc;
    }

    public String getHwZAcc() {
        return this.hwZAcc;
    }

    public String getSld() {
        return this.sld;
    }

    public String getTS() {
        return this.TS;
    }

    public String getUpX() {
        return this.upX;
    }

    public String getUpY() {
        return this.upY;
    }

    public String getVideoTime() {
        return this.videoTime;
    }

    public String getWinPrice() {
        return this.WinPrice;
    }

    public String getWxCall() {
        return this.wxCall;
    }

    public String getlTX() {
        return this.lTX;
    }

    public String getlTY() {
        return this.lTY;
    }

    public String getrBX() {
        return this.rBX;
    }

    public String getrBY() {
        return this.rBY;
    }

    public boolean isClickEvent() {
        return this.clickEvent;
    }

    public boolean isShowEvent() {
        return this.showEvent;
    }

    public void setClickAre(String str) {
        this.clickAre = str;
    }

    public void setClickEvent(boolean z) {
        this.clickEvent = z;
    }

    public void setClickX(String str) {
        this.clickX = str;
    }

    public void setClickY(String str) {
        this.clickY = str;
    }

    public void setDensity(String str) {
        this.density = str;
    }

    public void setDldStatus(String str) {
        this.dldStatus = str;
    }

    public void setDpReason(String str) {
        this.dpReason = str;
    }

    public void setDpResult(String str) {
        this.dpResult = str;
    }

    public void setHwDownTime(String str) {
        this.hwDownTime = str;
    }

    public void setHwMaxShowRatio(String str) {
        this.hwMaxShowRatio = str;
    }

    public void setHwShowTime(String str) {
        this.hwShowTime = str;
    }

    public void setHwUpTime(String str) {
        this.hwUpTime = str;
    }

    public void setHwXAcc(String str) {
        this.hwXAcc = str;
    }

    public void setHwYAcc(String str) {
        this.hwYAcc = str;
    }

    public void setHwZAcc(String str) {
        this.hwZAcc = str;
    }

    public void setShowEvent(boolean z) {
        this.showEvent = z;
    }

    public void setSld(String str) {
        this.sld = str;
    }

    public void setTS(String str) {
        this.TS = str;
    }

    public void setUpX(String str) {
        this.upX = str;
    }

    public void setUpY(String str) {
        this.upY = str;
    }

    public void setVideoTime(String str) {
        this.videoTime = str;
    }

    public void setWinPrice(String str) {
        this.WinPrice = str;
    }

    public void setWxCall(String str) {
        this.wxCall = str;
    }

    public void setlTX(String str) {
        this.lTX = str;
    }

    public void setlTY(String str) {
        this.lTY = str;
    }

    public void setrBX(String str) {
        this.rBX = str;
    }

    public void setrBY(String str) {
        this.rBY = str;
    }
}
