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
public class k extends d {
    private int r;

    public k(Context context, String str, com.beizi.fusion.a aVar, long j, int i) {
        super(context, str, aVar, j);
        this.r = i;
    }

    public void B() {
        a((ViewGroup) null);
    }

    public boolean C() {
        return this.l;
    }

    public void D() {
        m();
    }

    public void E() {
        n();
    }

    @Override // com.beizi.fusion.c.d
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        return (ao.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new com.beizi.fusion.work.e.b(this.b, forwardBean.getSleepTime(), buyerBean, forwardBean, this, this.r) : aVar;
    }

    @Override // com.beizi.fusion.c.d
    public void c() {
        AppEventId.getInstance(d.f4613a).setAppNativeRequest(this.m);
        EventBean eventBean = this.c;
        if (eventBean != null) {
            eventBean.setAdType("5");
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
