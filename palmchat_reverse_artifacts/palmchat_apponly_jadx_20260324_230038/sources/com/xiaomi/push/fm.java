package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class fm extends fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f11574a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Map<String, String> f462a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11575a = new a("get");
        public static final a b = new a("set");
        public static final a c = new a("result");
        public static final a d = new a("error");
        public static final a e = new a(com.heytap.mcssdk.constant.b.y);

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f463a;

        private a(String str) {
            this.f463a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = f11575a;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = b;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = d;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = c;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = e;
            if (aVar5.toString().equals(lowerCase)) {
                return aVar5;
            }
            return null;
        }

        public String toString() {
            return this.f463a;
        }
    }

    public fm() {
        this.f11574a = a.f11575a;
        this.f462a = new HashMap();
    }

    public synchronized void a(Map<String, String> map) {
        this.f462a.putAll(map);
    }

    public String b() {
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public a m454a() {
        return this.f11574a;
    }

    public fm(Bundle bundle) {
        super(bundle);
        this.f11574a = a.f11575a;
        this.f462a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f11574a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.f11574a = a.f11575a;
        } else {
            this.f11574a = aVar;
        }
    }

    @Override // com.xiaomi.push.fo
    public Bundle a() {
        Bundle bundleA = super.a();
        a aVar = this.f11574a;
        if (aVar != null) {
            bundleA.putString("ext_iq_type", aVar.toString());
        }
        return bundleA;
    }

    @Override // com.xiaomi.push.fo
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo455a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"");
            sb.append(fx.a(l()));
            sb.append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"");
            sb.append(fx.a(m()));
            sb.append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"");
            sb.append(fx.a(k()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f462a.entrySet()) {
            sb.append(fx.a(entry.getKey()));
            sb.append("=\"");
            sb.append(fx.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.f11574a == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"");
            sb.append(m454a());
            sb.append("\">");
        }
        String strB = b();
        if (strB != null) {
            sb.append(strB);
        }
        sb.append(o());
        fs fsVarM456a = m456a();
        if (fsVarM456a != null) {
            sb.append(fsVarM456a.m459a());
        }
        sb.append("</iq>");
        return sb.toString();
    }
}
