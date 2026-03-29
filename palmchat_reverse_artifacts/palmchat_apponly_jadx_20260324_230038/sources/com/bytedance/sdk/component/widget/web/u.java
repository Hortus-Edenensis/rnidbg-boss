package com.bytedance.sdk.component.widget.web;

import android.webkit.JavascriptInterface;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {
    private final String nr;
    private final Object u;

    public u(Object obj, String str) {
        this.u = obj;
        this.nr = str;
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        u("adAnalysisData", str);
    }

    @JavascriptInterface
    public String adInfo() {
        Object objU = u("adInfo", new Object[0]);
        return objU != null ? objU.toString() : "";
    }

    @JavascriptInterface
    public String appInfo() {
        Object objU = u("appInfo", new Object[0]);
        return objU != null ? objU.toString() : "";
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        u("changeVideoState", str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        u("clickEvent", str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        u("dynamicTrack", str);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        Object objU = u("getCurrentVideoState", new Object[0]);
        return objU != null ? objU.toString() : "";
    }

    @JavascriptInterface
    public String getData(String str) {
        Object objU = u("getData", str);
        return objU != null ? objU.toString() : "";
    }

    @JavascriptInterface
    public int getNetOperatorType() {
        Object objU = u("getNetOperatorType", new Object[0]);
        if (objU instanceof Integer) {
            return ((Integer) objU).intValue();
        }
        return -3;
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        Object objU = u("getTemplateInfo", new Object[0]);
        return objU != null ? objU.toString() : "";
    }

    @JavascriptInterface
    public void getUrl(String str) {
        u("getUrl", str);
    }

    @JavascriptInterface
    public void initRenderFinish() {
        u("initRenderFinish", new Object[0]);
    }

    @JavascriptInterface
    public Object invokeMethod(String str) {
        return u("invokeMethod", str);
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        u("muteVideo", str);
    }

    public String nr() {
        return this.nr;
    }

    @JavascriptInterface
    public void readHtml(String str, String str2) {
        u("readHtml", str, str2);
    }

    @JavascriptInterface
    public void readPercent(String str) {
        u("readPercent", str);
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        u("renderDidFinish", str);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        u("requestPauseVideo", str);
    }

    @JavascriptInterface
    public String sendNetworkSwitch(String str) {
        Object objU = u("sendNetworkSwitch", str);
        return objU != null ? objU.toString() : "";
    }

    @JavascriptInterface
    public void skipVideo() {
        u("skipVideo", new Object[0]);
    }

    public Object u() {
        return this.u;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022 A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:4:0x0003, B:6:0x0006, B:7:0x0009, B:9:0x000c, B:10:0x0017, B:12:0x002e, B:11:0x0022), top: B:16:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object u(String str, Object... objArr) {
        Method declaredMethod;
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Class<?>[] clsArr = new Class[objArr.length];
                    for (int i = 0; i < objArr.length; i++) {
                        clsArr[i] = objArr[i].getClass();
                    }
                    declaredMethod = this.u.getClass().getDeclaredMethod(str, clsArr);
                } else {
                    declaredMethod = this.u.getClass().getDeclaredMethod(str, new Class[0]);
                }
            } catch (Exception unused) {
                return null;
            }
        }
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(this.u, objArr);
    }
}
