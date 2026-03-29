package com.bykv.vk.openvk.component.video.api.fx;

import android.os.Build;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz implements Serializable {
    private b b;
    private int bq;
    private int dw;
    private String iz;
    private String k;
    private int l;
    private int mv;
    private long my;
    public int nr;
    private boolean o;
    private b pn;
    private List<String> s;
    private boolean sx;
    private String t;
    public String u;
    private int x;
    private int n = 204800;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4965a = 0;
    private int jk = 0;
    private long bg = -1;
    public final HashMap<String, Object> fx = new HashMap<>();
    private int c = 10000;
    private int q = 10000;
    private int qq = 10000;
    private int kj = 0;
    private JSONObject z = new JSONObject();

    public iz(String str, b bVar, b bVar2, int i, int i2) {
        this.bq = 0;
        this.dw = 0;
        this.iz = str;
        this.b = bVar;
        this.pn = bVar2;
        this.bq = i;
        this.dw = i2;
    }

    public int a() {
        return this.mv;
    }

    public String b() {
        return this.z.optString("pitaya_msg");
    }

    public int bg() {
        return this.c;
    }

    public int bq() {
        return this.q;
    }

    public int c() {
        return this.kj;
    }

    public int dw() {
        return this.qq;
    }

    public int fx() {
        return this.z.optInt("pitaya_code", 0);
    }

    public int iz() {
        if (s()) {
            return this.pn.my();
        }
        b bVar = this.b;
        if (bVar != null) {
            return bVar.my();
        }
        return 0;
    }

    public long jk() {
        return this.my;
    }

    public float k() {
        if (s()) {
            return this.pn.n();
        }
        b bVar = this.b;
        if (bVar != null) {
            return bVar.n();
        }
        return -1.0f;
    }

    public b kj() {
        if (s()) {
            return this.pn;
        }
        b bVar = this.b;
        if (bVar != null) {
            return bVar;
        }
        return null;
    }

    public long l() {
        if (s()) {
            return this.pn.pn();
        }
        b bVar = this.b;
        if (bVar != null) {
            return bVar.pn();
        }
        return 0L;
    }

    public boolean mv() {
        if (s()) {
            return this.pn.q();
        }
        b bVar = this.b;
        if (bVar != null) {
            return bVar.q();
        }
        return true;
    }

    public String my() {
        if (s()) {
            return this.pn.l();
        }
        b bVar = this.b;
        if (bVar != null) {
            return bVar.l();
        }
        return null;
    }

    public int n() {
        return this.l;
    }

    public int nr() {
        return this.z.optInt("pitaya_cache_size", 0);
    }

    public String o() {
        if (s()) {
            return this.pn.k();
        }
        b bVar = this.b;
        if (bVar != null) {
            return bVar.k();
        }
        return null;
    }

    public String pn() {
        return this.iz;
    }

    public b q() {
        return this.b;
    }

    public b qq() {
        return this.pn;
    }

    public boolean s() {
        b bVar;
        if (this.dw == 1 && (bVar = this.pn) != null && !TextUtils.isEmpty(bVar.l())) {
            if (com.bykv.vk.openvk.component.video.api.fx.pn() == 2) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return true;
                }
            } else if (this.bq == 1) {
                return true;
            }
        }
        return false;
    }

    public int sx() {
        return this.bq;
    }

    public boolean t() {
        return this.o;
    }

    public JSONObject u() {
        return this.z;
    }

    public boolean x() {
        return this.sx;
    }

    public void a(int i) {
        this.kj = i;
    }

    public void b(String str) {
        this.u = str;
    }

    public void fx(int i) {
        this.mv = i;
    }

    public void n(int i) {
        this.qq = i;
    }

    public void nr(String str) {
        this.t = str;
    }

    public void pn(int i) {
        this.bq = i;
    }

    public void u(String str) {
        this.iz = str;
    }

    public void x(int i) {
        this.q = i;
    }

    public void b(int i) {
        this.nr = i;
    }

    public void fx(String str) {
        this.k = str;
    }

    public void nr(int i) {
        this.l = i;
    }

    public synchronized Object pn(String str) {
        return this.fx.get(str);
    }

    public void u(int i) {
        this.x = i;
    }

    public void nr(boolean z) {
        this.o = z;
    }

    public void u(boolean z) {
        this.sx = z;
    }

    public void iz(int i) {
        this.c = i;
    }

    public void u(List<String> list) {
        this.s = list;
    }

    public void u(long j) {
        this.my = j;
    }

    public synchronized void u(String str, Object obj) {
        this.fx.put(str, obj);
    }
}
