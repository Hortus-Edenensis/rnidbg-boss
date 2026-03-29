package com.beizi.fusion;

import android.content.Context;
import android.util.Log;
import com.beizi.fusion.c.h;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class NativeUnifiedAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f4601a;

    public NativeUnifiedAd(Context context, String str, NativeUnifiedAdListener nativeUnifiedAdListener, long j, int i) {
        Log.d("BeiZis", " request NativeUnifiedAd adUnitId:" + str);
        this.f4601a = new h(context, str, nativeUnifiedAdListener, j, i);
    }

    public void destroy() {
        h hVar = this.f4601a;
        if (hVar != null) {
            hVar.E();
        }
    }

    public String getCustomExtraData() {
        h hVar = this.f4601a;
        if (hVar == null) {
            return null;
        }
        return hVar.w();
    }

    public String getCustomExtraJsonData() {
        h hVar = this.f4601a;
        if (hVar == null) {
            return null;
        }
        return hVar.y();
    }

    public int getECPM() {
        h hVar = this.f4601a;
        if (hVar != null) {
            return hVar.D();
        }
        return -1;
    }

    public boolean isLoaded() {
        h hVar = this.f4601a;
        if (hVar != null) {
            return hVar.C();
        }
        return false;
    }

    public void loadAd() {
        h hVar = this.f4601a;
        if (hVar != null) {
            hVar.B();
        }
    }

    public void resume() {
        h hVar = this.f4601a;
        if (hVar != null) {
            hVar.F();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        h hVar = this.f4601a;
        if (hVar == null || map == null) {
            return;
        }
        hVar.b(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        h hVar = this.f4601a;
        if (hVar == null || map == null) {
            return;
        }
        hVar.a(map);
    }

    public void setBidResponse(String str) {
        h hVar = this.f4601a;
        if (hVar == null) {
            return;
        }
        hVar.g(str);
    }

    public void setHideAdLogo(boolean z) {
        h hVar = this.f4601a;
        if (hVar != null) {
            hVar.b(z);
        }
    }

    public void setHideDownloadInfo(boolean z) {
        h hVar = this.f4601a;
        if (hVar != null) {
            hVar.c(z);
        }
    }

    public void setSpaceParam(Map<String, Object> map) {
        h hVar = this.f4601a;
        if (hVar == null) {
            return;
        }
        hVar.c(map);
    }
}
