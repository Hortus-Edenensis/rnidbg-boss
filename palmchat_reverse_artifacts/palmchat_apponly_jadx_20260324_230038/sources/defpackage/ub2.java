package defpackage;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ub2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21183a;
    public int b;
    public String c;
    public int d = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap {
        public a() {
            put("scene", Integer.valueOf(ub2.this.f21183a));
            put("roomId", ub2.this.c);
            put("type", Integer.valueOf(ub2.this.b));
        }
    }

    public ub2(int i, String str, int i2) {
        this.f21183a = i;
        this.b = i2;
        this.c = str;
    }

    public HashMap<String, Object> d() {
        int i = this.d;
        if (i != 200101 && i != 200102 && i == 200103) {
        }
        return new a();
    }

    public void e(int i, long j) {
        HashMap<String, Object> mapD = d();
        mapD.put("tab", i == 1 ? "pack" : "gift");
        mapD.put("giftid", Long.valueOf(j));
        zn6.j("gift_pick", "click", mapD);
    }

    public void f(int i) {
        HashMap<String, Object> mapD = d();
        mapD.put("tab", i == 1 ? "pack" : "gift");
        zn6.j("gift_list_slide", "view", mapD);
    }

    public void g(int i) {
        HashMap<String, Object> mapD = d();
        mapD.put("quantity", Integer.valueOf(i));
        zn6.j("gift_multi", "click", mapD);
    }

    public void h(int i, List<String> list, long j, int i2, boolean z, int i3, int i4) {
        HashMap<String, Object> mapD = d();
        mapD.put("targetuid", list == null ? "" : TextUtils.join(",", list));
        mapD.put("giftid", Long.valueOf(j));
        mapD.put("result", Integer.valueOf(i4));
        if (z) {
            mapD.put("combo", Integer.valueOf(i3));
            zn6.j("gift_combo", "click", mapD);
        } else {
            mapD.put("tab", i == 1 ? "pack" : "gift");
            mapD.put("quantity", Integer.valueOf(i2));
            zn6.j("gift_giving", "click", mapD);
        }
    }

    public void i(int i, int i2) {
        HashMap<String, Object> mapD = d();
        mapD.put("tab", i == 1 ? "pack" : "gift");
        mapD.put("page", Integer.valueOf(i2 + 1));
        zn6.j("gift_listgift_page", "view", mapD);
    }

    public void j() {
        zn6.j("gift_chargeicon", "click", d());
    }

    public void k(int i, boolean z, long j) {
        HashMap<String, Object> mapD = d();
        mapD.put("tab", i == 1 ? "pack" : "gift");
        mapD.put("result", Integer.valueOf(z ? 1 : 0));
        if (j > 0) {
            mapD.put("first_gift", Long.valueOf(j));
        }
        zn6.j("gift_list", "view", mapD);
    }
}
