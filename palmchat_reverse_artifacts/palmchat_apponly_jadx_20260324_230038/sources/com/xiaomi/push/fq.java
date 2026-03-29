package com.xiaomi.push;

import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class fq extends fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private b f472a;
    private String b;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public fq(b bVar) {
        this.f472a = b.available;
        this.b = null;
        this.f11578a = Integer.MIN_VALUE;
        this.f471a = null;
        a(bVar);
    }

    @Override // com.xiaomi.push.fo
    public Bundle a() {
        Bundle bundleA = super.a();
        b bVar = this.f472a;
        if (bVar != null) {
            bundleA.putString("ext_pres_type", bVar.toString());
        }
        String str = this.b;
        if (str != null) {
            bundleA.putString("ext_pres_status", str);
        }
        int i = this.f11578a;
        if (i != Integer.MIN_VALUE) {
            bundleA.putInt("ext_pres_prio", i);
        }
        a aVar = this.f471a;
        if (aVar != null && aVar != a.available) {
            bundleA.putString("ext_pres_mode", aVar.toString());
        }
        return bundleA;
    }

    public fq(Bundle bundle) {
        super(bundle);
        this.f472a = b.available;
        this.b = null;
        this.f11578a = Integer.MIN_VALUE;
        this.f471a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f472a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f11578a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f471a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.f472a = bVar;
            return;
        }
        throw new NullPointerException("Type cannot be null");
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(int i) {
        if (i >= -128 && i <= 128) {
            this.f11578a = i;
            return;
        }
        throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
    }

    public void a(a aVar) {
        this.f471a = aVar;
    }

    @Override // com.xiaomi.push.fo
    /* JADX INFO: renamed from: a */
    public String mo455a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"");
            sb.append(j());
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"");
            sb.append(fx.a(l()));
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"");
            sb.append(fx.a(m()));
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"");
            sb.append(fx.a(k()));
            sb.append("\"");
        }
        if (this.f472a != null) {
            sb.append(" type=\"");
            sb.append(this.f472a);
            sb.append("\"");
        }
        sb.append(">");
        if (this.b != null) {
            sb.append("<status>");
            sb.append(fx.a(this.b));
            sb.append("</status>");
        }
        if (this.f11578a != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.f11578a);
            sb.append("</priority>");
        }
        a aVar = this.f471a;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>");
            sb.append(this.f471a);
            sb.append("</show>");
        }
        sb.append(o());
        fs fsVarM456a = m456a();
        if (fsVarM456a != null) {
            sb.append(fsVarM456a.m459a());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
