package com.vivo.push.restructure.a.a;

import com.tencent.matrix.trace.config.SharePluginInfo;
import com.vivo.push.util.t;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected T f11261a;
    private String b;
    private i e;
    private a g;
    private long c = -1;
    private int d = -1;
    private boolean f = false;

    public a(String str, T t, i iVar) {
        this.b = str;
        this.f11261a = t;
        this.e = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.d = a(this.f11261a);
        this.c = System.currentTimeMillis() - jCurrentTimeMillis;
        int i = this.d;
        if (i != 0) {
            i iVar = this.e;
            if (iVar != null) {
                iVar.a(this, this.f11261a, i);
                return;
            }
            return;
        }
        a aVar = this.g;
        if (aVar != null) {
            aVar.a();
            return;
        }
        i iVar2 = this.e;
        if (iVar2 != null) {
            iVar2.a(this.f11261a);
        }
    }

    public abstract int a(T t);

    public final void a(a aVar) {
        if (this != aVar) {
            this.g = aVar;
        }
    }

    public final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        for (a<T> aVar = this; aVar != null; aVar = aVar.g) {
            try {
                jSONArray.put(aVar.b());
            } catch (Exception e) {
                t.a("AbstractMessageNodeMoni", e);
            }
        }
        return jSONArray;
    }

    public final void a(long j) {
        this.c = j;
    }

    public synchronized String b() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.b);
            jSONObject.put("code", this.d);
            jSONObject.put(SharePluginInfo.ISSUE_COST, this.c);
        } catch (Exception e) {
            t.a("AbstractMessageNodeMoni", e);
        }
        return jSONObject.toString();
    }

    public final void a() {
        if (this.f) {
            com.vivo.push.util.g.a().execute(new b(this));
        } else {
            d();
        }
    }
}
