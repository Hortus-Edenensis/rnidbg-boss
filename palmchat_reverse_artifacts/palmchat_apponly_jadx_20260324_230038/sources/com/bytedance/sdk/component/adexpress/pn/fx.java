package com.bytedance.sdk.component.adexpress.pn;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private WeakReference<nr> u;

    public fx(nr nrVar) {
        this.u = new WeakReference<>(nrVar);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<nr> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.u.get().adAnalysisData(str);
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<nr> weakReference = this.u;
        return (weakReference == null || weakReference.get() == null) ? "" : this.u.get().adInfo();
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<nr> weakReference = this.u;
        return (weakReference == null || weakReference.get() == null) ? "" : this.u.get().appInfo();
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<nr> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.u.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<nr> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.u.get().clickEvent(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<nr> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.u.get().dynamicTrack(str);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<nr> weakReference = this.u;
        return (weakReference == null || weakReference.get() == null) ? "" : this.u.get().getCurrentVideoState();
    }

    @JavascriptInterface
    public String getData(String str) {
        WeakReference<nr> weakReference = this.u;
        return (weakReference == null || weakReference.get() == null) ? "" : this.u.get().getData(str);
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<nr> weakReference = this.u;
        return (weakReference == null || weakReference.get() == null) ? "" : this.u.get().getTemplateInfo();
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<nr> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.u.get().initRenderFinish();
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<nr> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.u.get().muteVideo(str);
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<nr> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.u.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<nr> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.u.get().requestPauseVideo(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<nr> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.u.get().skipVideo();
    }

    public void u(nr nrVar) {
        if (nrVar == null) {
            this.u = null;
        } else {
            this.u = new WeakReference<>(nrVar);
        }
    }
}
