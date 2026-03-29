package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.beizi.fusion.c.f;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class InterstitialAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f4599a;

    public InterstitialAd(Context context, String str, InterstitialAdListener interstitialAdListener, long j) {
        this.f4599a = new f(context, str, interstitialAdListener, j, 0);
    }

    public void destroy() {
        f fVar = this.f4599a;
        if (fVar != null) {
            fVar.E();
        }
    }

    public String getCustomExtraData() {
        f fVar = this.f4599a;
        if (fVar == null) {
            return null;
        }
        return fVar.w();
    }

    public String getCustomExtraJsonData() {
        f fVar = this.f4599a;
        if (fVar == null) {
            return null;
        }
        return fVar.y();
    }

    public int getECPM() {
        f fVar = this.f4599a;
        if (fVar != null) {
            return fVar.D();
        }
        return -1;
    }

    public boolean isLoaded() {
        f fVar = this.f4599a;
        if (fVar != null) {
            return fVar.B();
        }
        return false;
    }

    public void loadAd() {
        f fVar = this.f4599a;
        if (fVar != null) {
            fVar.C();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        f fVar = this.f4599a;
        if (fVar == null || map == null) {
            return;
        }
        fVar.b(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        f fVar = this.f4599a;
        if (fVar == null || map == null) {
            return;
        }
        fVar.a(map);
    }

    public void setAdVersion(int i) {
        f fVar = this.f4599a;
        if (fVar != null) {
            fVar.b(i);
        }
    }

    public void setBidResponse(String str) {
        f fVar = this.f4599a;
        if (fVar == null) {
            return;
        }
        fVar.g(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        f fVar = this.f4599a;
        if (fVar == null) {
            return;
        }
        fVar.c(map);
    }

    public void showAd(@NonNull Activity activity) {
        f fVar = this.f4599a;
        if (fVar != null) {
            fVar.a(activity);
        }
    }

    public InterstitialAd(Context context, String str, InterstitialAdListener interstitialAdListener, long j, int i) {
        Log.d("BeiZis", " request InterstitialAd adUnitId:" + str);
        this.f4599a = new f(context, str, interstitialAdListener, j, i);
    }
}
