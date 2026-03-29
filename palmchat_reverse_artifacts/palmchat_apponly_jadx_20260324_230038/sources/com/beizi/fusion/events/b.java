package com.beizi.fusion.events;

import com.beizi.fusion.events.a;
import com.beizi.fusion.events.a.C0139a;
import com.beizi.fusion.events.a.b;
import com.beizi.fusion.events.a.c;
import com.beizi.fusion.events.a.d;
import com.beizi.fusion.events.a.e;
import com.beizi.fusion.events.a.f;
import com.beizi.fusion.events.a.g;
import com.beizi.fusion.events.a.h;
import com.beizi.fusion.events.a.i;
import com.beizi.fusion.events.a.j;
import com.beizi.fusion.events.a.k;
import com.beizi.fusion.tool.aa;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a.i f4666a;
    public a.h b;
    public a.k c;
    public a.g d;
    public a.d e;
    public a.e f;
    public a.f g;
    public a.c h;
    public a.b i;
    public a.j j;
    public a.C0139a k;
    private final a l;
    private EventBean m;
    private boolean n = false;

    public b(EventBean eventBean) {
        this.m = eventBean;
        a aVar = new a();
        this.l = aVar;
        this.f4666a = aVar.new i();
        this.b = aVar.new h();
        this.c = aVar.new k();
        this.d = aVar.new g();
        this.e = aVar.new d();
        this.f = aVar.new e();
        this.g = aVar.new f();
        this.h = aVar.new c();
        this.i = aVar.new b();
        this.j = aVar.new j();
        this.k = aVar.new C0139a();
    }

    public a a() {
        return this.l;
    }

    public EventBean b() {
        return this.m;
    }

    public boolean c() {
        return this.n;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if ((observable instanceof a.l) && (obj instanceof EventBean)) {
            EventBean eventBean = (EventBean) obj;
            aa.a("BeiZis", "channel == " + eventBean.getBuyerId() + ",eventCode = " + eventBean.getEventCode() + ";buyerSpaceId:" + eventBean.getBuyerSpaceUuId() + ",srcType = " + eventBean.getBeiZiSrcType() + ",price = " + eventBean.getBeiZiPrice() + ",bidPrice = " + eventBean.getBidPrice() + ",eventId = " + eventBean.getReqId() + ",buyerSpaceId = " + eventBean.getBuyerSpaceId());
            EventCar.getInstance(com.beizi.fusion.c.b.a().e()).goRoad(eventBean);
        }
    }

    public void a(boolean z) {
        this.n = z;
    }
}
