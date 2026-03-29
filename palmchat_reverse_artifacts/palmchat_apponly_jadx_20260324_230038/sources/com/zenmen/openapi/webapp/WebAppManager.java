package com.zenmen.openapi.webapp;

import android.text.TextUtils;
import defpackage.fz4;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public enum WebAppManager {
    mInstance;

    public static final String APPID_WEBAPP_CENTER = "op9e2193844e424de8";
    public static final String APPID_WEBAPP_PREVENT = "op75a1c9d73e5e435f";
    private static String[] INNER_APPIDS = null;
    public static final String TASK_MAIN = "MAIN";
    public static final String TASK_WEBAPP0 = "lx.webapp";
    private static HashMap<String, String> webAppMap;
    private fz4 idleAppInfo;
    private boolean isFromSdp = false;
    private String wxPayTaskName;

    static {
        HashMap<String, String> map = new HashMap<>();
        webAppMap = map;
        INNER_APPIDS = new String[]{APPID_WEBAPP_CENTER, APPID_WEBAPP_PREVENT};
        map.put(TASK_WEBAPP0, "com.zenmen.openapi.webapp.MainActivity");
    }

    WebAppManager() {
    }

    public static WebAppManager getInstance() {
        return mInstance;
    }

    public static boolean isInnerApp(String str) {
        for (String str2 : INNER_APPIDS) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public Class getCurrentPayTaskForWx() {
        return null;
    }

    public fz4 getLastOpenAppInfo() {
        return this.idleAppInfo;
    }

    public boolean isFromSdp() {
        return this.isFromSdp;
    }

    public void setCurrentPayTaskForWx(String str) {
        if (TextUtils.isEmpty(str)) {
            this.wxPayTaskName = TASK_MAIN;
        } else {
            this.wxPayTaskName = str;
        }
        setPayFromSdp(true);
    }

    public void setIdleAppInfo(fz4 fz4Var) {
        this.idleAppInfo = fz4Var;
    }

    public void setPayFromSdp(boolean z) {
        this.isFromSdp = z;
    }
}
