package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.beizi.fusion.c.k;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class UnifiedCustomAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k f4604a;

    public UnifiedCustomAd(Context context, String str, NativeAdListener nativeAdListener, long j, int i) {
        this.f4604a = new k(context, str, nativeAdListener, j, i);
    }

    public void destroy() {
        k kVar = this.f4604a;
        if (kVar != null) {
            kVar.D();
        }
    }

    public String getCustomExtraData() {
        k kVar = this.f4604a;
        if (kVar == null) {
            return null;
        }
        return kVar.w();
    }

    public String getCustomExtraJsonData() {
        k kVar = this.f4604a;
        if (kVar == null) {
            return null;
        }
        return kVar.y();
    }

    public boolean isLoaded() {
        k kVar = this.f4604a;
        if (kVar != null) {
            return kVar.C();
        }
        return false;
    }

    public void loadAd() {
        k kVar = this.f4604a;
        if (kVar != null) {
            kVar.B();
        }
    }

    public void resume() {
        k kVar = this.f4604a;
        if (kVar != null) {
            kVar.E();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        k kVar = this.f4604a;
        if (kVar == null || map == null) {
            return;
        }
        kVar.b(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        k kVar = this.f4604a;
        if (kVar == null || map == null) {
            return;
        }
        kVar.a(map);
    }

    public void setBidResponse(String str) {
        k kVar = this.f4604a;
        if (kVar == null) {
            return;
        }
        kVar.g(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        k kVar = this.f4604a;
        if (kVar == null) {
            return;
        }
        kVar.c(map);
    }

    public void showAd(@NonNull Activity activity) {
        k kVar = this.f4604a;
        if (kVar != null) {
            kVar.a(activity);
        }
    }
}
