package com.beizi.fusion.c;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.tool.ao;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class g extends d {
    private float r;
    private float s;
    private int t;

    public g(Context context, String str, com.beizi.fusion.a aVar, long j, int i) {
        super(context, str, aVar, j);
        this.t = i;
    }

    public int B() {
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

    public void C() {
        m();
    }

    public void D() {
        n();
    }

    public void E() {
        com.beizi.fusion.work.a aVar = this.i;
        if (aVar != null) {
            aVar.n();
        }
    }

    @Override // com.beizi.fusion.c.d
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        long sleepTime = forwardBean.getSleepTime();
        if (!ao.b().equalsIgnoreCase(str) && !"BEIZI".equalsIgnoreCase(str)) {
            return aVar;
        }
        int i = this.t;
        return i == 4 ? new com.beizi.fusion.work.b.b(this.b, this.e, this.f, sleepTime, buyerBean, forwardBean, this, this.r, this.s) : i == 5 ? new com.beizi.fusion.work.b.c(this.b, this.e, this.f, sleepTime, buyerBean, forwardBean, this, this.r, this.s) : new com.beizi.fusion.work.b.d(this.b, this.e, this.f, sleepTime, buyerBean, forwardBean, this, this.r, this.s);
    }

    @Override // com.beizi.fusion.c.d
    public void c() {
        AppEventId.getInstance(d.f4613a).setAppNativeRequest(this.m);
        EventBean eventBean = this.c;
        if (eventBean != null) {
            eventBean.setAdType("5");
        }
    }

    public void a(float f, float f2) {
        this.r = f;
        this.s = f2;
        a((ViewGroup) null);
    }
}
