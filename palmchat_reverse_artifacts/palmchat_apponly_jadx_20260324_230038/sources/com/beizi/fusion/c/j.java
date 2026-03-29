package com.beizi.fusion.c;

import android.content.Context;
import android.view.View;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.tool.ao;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class j extends d {
    private int r;
    private int s;

    public j(Context context, String str, View view, com.beizi.fusion.a aVar, long j) {
        super(context, str, aVar, j);
        this.g = view;
    }

    public int B() {
        return this.r;
    }

    public int C() {
        return this.s;
    }

    public void D() {
        com.beizi.fusion.work.a aVar;
        if (this.o || (aVar = this.i) == null || this.n) {
            return;
        }
        aVar.au();
        this.i.e();
        this.n = true;
    }

    public int E() {
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

    public void F() {
        com.beizi.fusion.tool.e.b().c().execute(new Runnable() { // from class: com.beizi.fusion.c.j.1
            @Override // java.lang.Runnable
            public void run() {
                EventCar.getInstance(d.f4613a).goRoadWithoutThread(new EventBean(b.b, "", "200.500", "", b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            }
        });
    }

    public Map G() {
        com.beizi.fusion.work.a aVar = this.i;
        if (aVar == null) {
            return null;
        }
        return aVar.av();
    }

    @Override // com.beizi.fusion.c.d
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        return (ao.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new com.beizi.fusion.work.splash.a(this.b, this.e, this.f, this.g, this.d, buyerBean, forwardBean, list, B(), C(), this) : aVar;
    }

    public void b(int i) {
        this.r = i;
    }

    @Override // com.beizi.fusion.c.d
    public void c() {
        AppEventId.getInstance(d.f4613a).setAppSplashRequest(this.m);
        EventBean eventBean = this.c;
        if (eventBean != null) {
            eventBean.setAdType("2");
        }
    }

    public void a(Context context) {
        try {
            com.beizi.fusion.work.a aVar = this.i;
            if (aVar != null) {
                aVar.a(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(int i) {
        this.s = i;
    }
}
