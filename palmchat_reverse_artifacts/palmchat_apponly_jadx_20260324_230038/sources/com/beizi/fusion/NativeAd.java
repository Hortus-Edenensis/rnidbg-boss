package com.beizi.fusion;

import android.content.Context;
import android.util.Log;
import com.beizi.fusion.c.g;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class NativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f4600a;

    public NativeAd(Context context, String str, NativeAdListener nativeAdListener, long j, int i) {
        Log.d("BeiZis", " request NativeAd adUnitId:" + str);
        this.f4600a = new g(context, str, nativeAdListener, j, i);
    }

    public void destroy() {
        g gVar = this.f4600a;
        if (gVar != null) {
            gVar.C();
        }
    }

    public String getCustomExtraData() {
        g gVar = this.f4600a;
        if (gVar == null) {
            return null;
        }
        return gVar.w();
    }

    public String getCustomExtraJsonData() {
        g gVar = this.f4600a;
        if (gVar == null) {
            return null;
        }
        return gVar.y();
    }

    public int getECPM() {
        g gVar = this.f4600a;
        if (gVar != null) {
            return gVar.B();
        }
        return -1;
    }

    public void loadAd(float f, float f2) {
        g gVar = this.f4600a;
        if (gVar != null) {
            gVar.a(f, f2);
        }
    }

    public void pause() {
        g gVar = this.f4600a;
        if (gVar != null) {
            gVar.E();
        }
    }

    public void resume() {
        g gVar = this.f4600a;
        if (gVar != null) {
            gVar.D();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        g gVar = this.f4600a;
        if (gVar == null || map == null) {
            return;
        }
        gVar.b(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        g gVar = this.f4600a;
        if (gVar == null || map == null) {
            return;
        }
        gVar.a(map);
    }

    public void setBidResponse(String str) {
        g gVar = this.f4600a;
        if (gVar == null) {
            return;
        }
        gVar.g(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        g gVar = this.f4600a;
        if (gVar == null) {
            return;
        }
        gVar.c(map);
    }
}
