package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RequiresPermission;
import com.beizi.fusion.c.j;
import com.kuaishou.weapon.p0.g;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class SplashAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f4603a;
    private ViewGroup b;
    private boolean c = false;

    @RequiresPermission(g.f7481a)
    public SplashAd(Context context, View view, String str, AdListener adListener, long j) {
        Log.d("BeiZis", " request SplashAd adUnitId:" + str);
        this.f4603a = new j(context, str, view, adListener, j);
        FrameLayout frameLayout = new FrameLayout(context);
        this.b = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void cancel(Context context) {
        j jVar = this.f4603a;
        if (jVar != null) {
            jVar.m();
        }
    }

    public String getCustomExtraData() {
        j jVar = this.f4603a;
        if (jVar == null) {
            return null;
        }
        return jVar.w();
    }

    public String getCustomExtraJsonData() {
        j jVar = this.f4603a;
        if (jVar == null) {
            return null;
        }
        return jVar.y();
    }

    public int getECPM() {
        j jVar = this.f4603a;
        if (jVar != null) {
            return jVar.E();
        }
        return -1;
    }

    public Map getExtraData() {
        j jVar = this.f4603a;
        if (jVar == null) {
            return null;
        }
        return jVar.G();
    }

    public void loadAd(int i, int i2) {
        j jVar = this.f4603a;
        if (jVar == null || this.b == null) {
            return;
        }
        jVar.b(i);
        this.f4603a.c(i2);
        this.f4603a.a(this.b);
    }

    public void reportNotShow() {
        j jVar = this.f4603a;
        if (jVar != null) {
            jVar.F();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        j jVar = this.f4603a;
        if (jVar == null || map == null) {
            return;
        }
        jVar.b(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        j jVar = this.f4603a;
        if (jVar == null || map == null) {
            return;
        }
        jVar.a(map);
    }

    public void setBidResponse(String str) {
        j jVar = this.f4603a;
        if (jVar == null) {
            return;
        }
        jVar.g(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        j jVar = this.f4603a;
        if (jVar == null) {
            return;
        }
        jVar.c(map);
    }

    public void setSupportRegionClick(boolean z) {
        j jVar = this.f4603a;
        if (jVar != null) {
            jVar.a(z);
        }
    }

    public void show(ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        if (this.c) {
            return;
        }
        if (viewGroup == null) {
            Log.e("BeiZis", "parent can't be null !");
            return;
        }
        if (this.f4603a == null || (viewGroup2 = this.b) == null) {
            return;
        }
        try {
            if (!(viewGroup2.getContext() instanceof Activity)) {
                this.f4603a.a(viewGroup.getContext());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        viewGroup.addView(this.b);
        this.f4603a.D();
        this.c = true;
    }

    @Deprecated
    public void loadAd() {
        ViewGroup viewGroup;
        j jVar = this.f4603a;
        if (jVar == null || (viewGroup = this.b) == null) {
            return;
        }
        jVar.a(viewGroup);
    }
}
