package com.zm.fda.Z0O00;

import android.content.Context;
import com.zm.fda.utils.EventLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z {
    public static final String e = "fob_fda";
    public static final int f = 3;
    public static final int g = 3;
    public static final String h = "fdadbtag";
    public static final String i = "fdastore.db";
    public static OO22Z j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z200O f16661a;
    public final Z0225 b;
    public final Context c;
    public final boolean d = false;

    public OO22Z(Context context) {
        this.c = context;
        this.b = new Z0225(context);
        this.f16661a = new Z200O(context);
    }

    public static OO22Z b() {
        if (j == null) {
            synchronized (OO22Z.class) {
                if (j == null) {
                    j = new OO22Z(com.zm.fda.ZZ00Z.b());
                }
            }
        }
        return j;
    }

    public long a(com.zm.fda.Z0O00.Z0O00.OO22Z oo22z) {
        long jA = this.f16661a.a(oo22z);
        EventLog.d("fob_fda", "FdaEventBean = ", oo22z.d(), ", save Database result = ", Long.valueOf(jA));
        return jA;
    }

    public boolean a(List<com.zm.fda.Z0O00.Z0O00.OO22Z> list) {
        boolean zB;
        boolean z;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (com.zm.fda.Z0O00.Z0O00.OO22Z oo22z : list) {
            if (oo22z.j() == 0) {
                arrayList.add(String.valueOf(oo22z.a()));
            } else {
                oo22z.j();
            }
        }
        if (arrayList.isEmpty()) {
            zB = true;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (i2 > 0) {
                    sb.append(",");
                }
                sb.append("'");
                sb.append((String) arrayList.get(i2));
                sb.append("'");
            }
            sb.append(")");
            zB = this.f16661a.b(sb.toString());
        }
        try {
            if (!arrayList2.isEmpty()) {
                this.b.a(arrayList2, 1);
            }
            if (!arrayList3.isEmpty()) {
                this.b.a(arrayList3, 2);
            }
            if (!arrayList4.isEmpty()) {
                this.b.a(arrayList4, 3);
            }
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        return zB && z;
    }

    public void b(com.zm.fda.Z0O00.Z0O00.OO22Z oo22z) {
        this.b.a(oo22z);
    }

    public List<com.zm.fda.Z0O00.Z0O00.OO22Z> a(int i2, int i3) {
        return this.f16661a.a(i2, i3, false);
    }

    public void a() {
        this.f16661a.close();
    }
}
