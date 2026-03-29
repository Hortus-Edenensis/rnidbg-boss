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
public class h extends d {
    private int r;
    private boolean s;
    private boolean t;

    public h(Context context, String str, com.beizi.fusion.a aVar, long j, int i) {
        super(context, str, aVar, j);
        this.r = i;
    }

    public void B() {
        a((ViewGroup) null);
    }

    public boolean C() {
        return this.l;
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

    public void F() {
        n();
    }

    @Override // com.beizi.fusion.c.d
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        return (ao.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new com.beizi.fusion.work.c.b(this.b, this.f, forwardBean.getSleepTime(), buyerBean, forwardBean, this, this.r, this.s, this.t) : aVar;
    }

    public void b(boolean z) {
        this.s = z;
    }

    @Override // com.beizi.fusion.c.d
    public void c() {
        AppEventId.getInstance(d.f4613a).setAppNativeRequest(this.m);
        EventBean eventBean = this.c;
        if (eventBean != null) {
            eventBean.setAdType("5");
        }
    }

    public void c(boolean z) {
        this.t = z;
    }
}
