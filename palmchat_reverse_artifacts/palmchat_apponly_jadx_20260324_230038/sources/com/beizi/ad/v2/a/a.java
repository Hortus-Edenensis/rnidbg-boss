package com.beizi.ad.v2.a;

import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b f4517a;

    public void a(boolean z) {
    }

    public String b() {
        b bVar = this.f4517a;
        if (bVar == null) {
            return null;
        }
        return bVar.h();
    }

    public void c() {
        b bVar = this.f4517a;
        if (bVar == null) {
            return;
        }
        bVar.b();
    }

    public boolean d() {
        b bVar = this.f4517a;
        if (bVar == null) {
            return false;
        }
        return bVar.i();
    }

    public void e() {
        b bVar = this.f4517a;
        if (bVar == null) {
            return;
        }
        bVar.c();
    }

    public void f() {
        b bVar = this.f4517a;
        if (bVar != null) {
            bVar.q();
        }
    }

    public Map g() {
        b bVar = this.f4517a;
        if (bVar == null) {
            return null;
        }
        return bVar.k();
    }

    public String h() {
        b bVar = this.f4517a;
        if (bVar == null) {
            return null;
        }
        return bVar.l();
    }

    public boolean i() {
        b bVar = this.f4517a;
        if (bVar == null) {
            return false;
        }
        return bVar.o();
    }

    public long j() {
        b bVar = this.f4517a;
        if (bVar == null) {
            return 0L;
        }
        return bVar.p();
    }

    public int k() {
        b bVar = this.f4517a;
        if (bVar == null) {
            return 5;
        }
        return bVar.s();
    }

    public boolean l() {
        b bVar = this.f4517a;
        if (bVar == null) {
            return false;
        }
        return bVar.j();
    }

    public JSONObject m() {
        b bVar = this.f4517a;
        if (bVar == null) {
            return null;
        }
        return bVar.t();
    }

    public void a(String str) {
        this.f4517a.a(str);
    }

    public void b(Map map) {
        b bVar = this.f4517a;
        if (bVar == null || map == null) {
            return;
        }
        bVar.b(map);
    }

    public void a(int i) {
        this.f4517a.a(i);
    }

    public void c(String str) {
        b bVar = this.f4517a;
        if (bVar == null) {
            return;
        }
        bVar.e(str);
    }

    public void a(AdSpacesBean.BuyerBean buyerBean) {
        this.f4517a.a(buyerBean);
    }

    public void b(String str) {
        b bVar = this.f4517a;
        if (bVar == null) {
            return;
        }
        bVar.d(str);
    }

    public void a(EventBean eventBean) {
        this.f4517a.a(eventBean);
    }

    public void c(Map<String, Object> map) {
        b bVar = this.f4517a;
        if (bVar == null) {
            return;
        }
        bVar.c(map);
    }

    public String a() {
        b bVar = this.f4517a;
        if (bVar == null) {
            return null;
        }
        return bVar.g();
    }

    public void a(Map map) {
        b bVar = this.f4517a;
        if (bVar == null || map == null) {
            return;
        }
        bVar.a(map);
    }
}
