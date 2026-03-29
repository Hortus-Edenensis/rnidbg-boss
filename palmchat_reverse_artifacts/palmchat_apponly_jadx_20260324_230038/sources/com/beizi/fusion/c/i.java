package com.beizi.fusion.c;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.tool.ao;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class i extends d {
    private int r;
    private String s;
    private String t;

    public i(Context context, String str, com.beizi.fusion.a aVar, long j, int i) {
        super(context, str, aVar, j);
        this.r = i;
    }

    public boolean B() {
        return this.l;
    }

    public void C() {
        a((ViewGroup) null);
    }

    public int D() {
        String strI;
        com.beizi.fusion.work.a aVar = this.i;
        if (aVar == null || (strI = aVar.i()) == null) {
            return -1;
        }
        try {
            return Integer.parseInt(strI);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public void E() {
        m();
    }

    @Override // com.beizi.fusion.c.d
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        return (ao.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new com.beizi.fusion.work.d.a(this.b, this.e, this.f, forwardBean.getSleepTime(), buyerBean, forwardBean, this) : aVar;
    }

    @Override // com.beizi.fusion.c.d
    public void c() {
        AppEventId.getInstance(d.f4613a).setAppRewardedVideoRequest(this.m);
        EventBean eventBean = this.c;
        if (eventBean != null) {
            eventBean.setAdType("1");
        }
    }

    public void h(String str) {
        this.s = str;
    }

    public void i(String str) {
        this.t = str;
    }

    public void a(Activity activity) {
        com.beizi.fusion.work.a aVar;
        if (activity == null || (aVar = this.i) == null) {
            return;
        }
        aVar.a(activity);
    }
}
