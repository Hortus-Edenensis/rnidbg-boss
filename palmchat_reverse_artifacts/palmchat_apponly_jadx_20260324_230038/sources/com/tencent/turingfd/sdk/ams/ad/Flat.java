package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import com.tencent.turingfd.sdk.ams.ad.Csynchronized;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Flat {
    public static Flat D;
    public static final Cassiopeia E = new Cdo();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CanisMinor f10695a;
    public Cassiopeia b;
    public ITuringDeviceInfoProvider c;
    public ITuringPkgProvider d;
    public ITuringIoTFeatureMap e;
    public int f = 0;
    public String g = "";
    public boolean h = true;
    public String[] i = null;
    public int j = 10000;
    public String k = "";
    public String l = "";
    public String m = "";
    public int n = 0;
    public String o = "";
    public Map<Integer, String> p = new HashMap();
    public String q = "";
    public boolean r = true;
    public boolean s = false;
    public boolean t = true;
    public boolean u = true;
    public boolean v = false;
    public long w = 5000;
    public long x = 60000;
    public int y = 3;
    public boolean z = false;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Flat$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class Cdo implements Cassiopeia {
        @Override // com.tencent.turingfd.sdk.ams.ad.Cassiopeia
        public boolean userAgreement() {
            return false;
        }
    }

    public final void a() {
        String[] strArr = this.i;
        if (strArr != null) {
            if (strArr.length == 0) {
                this.i = null;
            } else {
                ArrayList arrayList = new ArrayList();
                for (String str : this.i) {
                    if (str != null && !str.isEmpty()) {
                        arrayList.add(str);
                    }
                }
                this.i = arrayList.isEmpty() ? null : (String[]) arrayList.toArray(new String[0]);
            }
        }
        if (this.i == null) {
            this.i = new String[]{"https://tdid.m.qq.com?mc=2"};
        }
        if (this.f10695a != null) {
            this.z = true;
            return;
        }
        if (this.j < 1000) {
            this.j = 10000;
        }
        String[] strArr2 = this.i;
        int i = this.j;
        Csynchronized.Cdo cdo = new Csynchronized.Cdo(strArr2);
        if (strArr2.length > 1) {
            Cpackage.f10766a.submit(new Cinstanceof(cdo, i));
        }
        this.f10695a = cdo;
    }

    public final Context b() {
        Context context;
        synchronized (Ccase.class) {
            context = Ccase.f10751a;
        }
        return context;
    }

    public Cassiopeia c() {
        Cassiopeia cassiopeia = this.b;
        return cassiopeia == null ? E : cassiopeia;
    }

    public final void a(Context context) {
        Ccase.a(context);
    }
}
