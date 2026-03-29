package com.beizi.fusion.c;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.ao;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class f extends d {
    private int r;
    private int s;

    public f(Context context, String str, com.beizi.fusion.a aVar, long j, int i) {
        super(context, str, aVar, j);
        this.s = i;
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
        buyerBean.getAdType();
        return (ao.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new com.beizi.fusion.work.a.a(this.b, this.e, this.f, forwardBean.getSleepTime(), buyerBean, forwardBean, this) : aVar;
    }

    public void b(int i) {
        this.r = i;
    }

    @Override // com.beizi.fusion.c.d
    public void c() {
        EventBean eventBean = this.c;
        if (eventBean != null) {
            eventBean.setAdType("3");
        }
    }

    public void a(Activity activity) {
        com.beizi.fusion.work.a aVar;
        if (activity == null || (aVar = this.i) == null) {
            return;
        }
        aVar.a(activity);
    }
}
