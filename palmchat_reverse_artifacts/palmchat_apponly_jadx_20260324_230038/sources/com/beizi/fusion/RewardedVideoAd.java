package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.beizi.fusion.c.i;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class RewardedVideoAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i f4602a;
    private String b;
    private String c;

    public RewardedVideoAd(Context context, String str, RewardedVideoAdListener rewardedVideoAdListener, long j, int i) {
        Log.d("BeiZis", " request RewardedVideoAd adUnitId:" + str);
        this.f4602a = new i(context, str, rewardedVideoAdListener, j, i);
    }

    public void destroy() {
        i iVar = this.f4602a;
        if (iVar != null) {
            iVar.E();
        }
    }

    public String getCustomExtraData() {
        i iVar = this.f4602a;
        if (iVar == null) {
            return null;
        }
        return iVar.w();
    }

    public String getCustomExtraJsonData() {
        i iVar = this.f4602a;
        if (iVar == null) {
            return null;
        }
        return iVar.y();
    }

    public int getECPM() {
        i iVar = this.f4602a;
        if (iVar != null) {
            return iVar.D();
        }
        return -1;
    }

    public String getExtra() {
        return this.c;
    }

    public String getUserId() {
        return this.b;
    }

    public boolean isLoaded() {
        i iVar = this.f4602a;
        if (iVar != null) {
            return iVar.B();
        }
        return false;
    }

    public void loadAd() {
        i iVar = this.f4602a;
        if (iVar != null) {
            iVar.C();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        i iVar = this.f4602a;
        if (iVar == null || map == null) {
            return;
        }
        iVar.b(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        i iVar = this.f4602a;
        if (iVar == null || map == null) {
            return;
        }
        iVar.a(map);
    }

    public void setBidResponse(String str) {
        i iVar = this.f4602a;
        if (iVar == null) {
            return;
        }
        iVar.g(str);
    }

    public void setExtra(String str) {
        i iVar = this.f4602a;
        if (iVar != null) {
            iVar.i(str);
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        i iVar = this.f4602a;
        if (iVar != null) {
            iVar.a(rewardedVideoAdListener);
        }
    }

    public void setSpaceParam(Map<String, Object> map) {
        i iVar = this.f4602a;
        if (iVar == null) {
            return;
        }
        iVar.c(map);
    }

    public void setUserId(String str) {
        i iVar = this.f4602a;
        if (iVar != null) {
            iVar.h(str);
        }
    }

    public void showAd(@NonNull Activity activity) {
        i iVar = this.f4602a;
        if (iVar != null) {
            iVar.a(activity);
        }
    }
}
