package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class at {
    private static at B = null;
    private static final String Code = "hiad_sp_properties_cache_sdk";
    private static final String I = "PropertiesCache";
    private static final String V = "cache_data";
    private static final byte[] Z = new byte[0];
    private SharedPreferences C;
    private a F;
    private final byte[] S = new byte[0];

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements Cloneable {

        @com.huawei.openalliance.ad.annotations.b
        String B;

        @com.huawei.openalliance.ad.annotations.b
        Integer C;

        @com.huawei.openalliance.ad.annotations.b
        String Code;

        @com.huawei.openalliance.ad.annotations.b
        String D;

        @com.huawei.openalliance.ad.annotations.b
        String F;

        @com.huawei.openalliance.ad.annotations.b
        String I;

        @com.huawei.openalliance.ad.annotations.b
        String L;

        @com.huawei.openalliance.ad.annotations.b
        Boolean S;

        @com.huawei.openalliance.ad.annotations.b
        Boolean V;

        @com.huawei.openalliance.ad.annotations.b
        Boolean Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.huawei.openalliance.ad.annotations.b
        Integer f6957a;

        @com.huawei.openalliance.ad.annotations.b
        Integer b;

        @com.huawei.openalliance.ad.annotations.b
        String c;

        @com.huawei.openalliance.ad.annotations.b
        String d;

        @com.huawei.openalliance.ad.annotations.b
        public a() {
        }

        /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.Code = this.Code;
            aVar.V = this.V;
            aVar.I = this.I;
            aVar.Z = this.Z;
            aVar.B = this.B;
            aVar.C = this.C;
            aVar.S = this.S;
            aVar.F = this.F;
            aVar.D = this.D;
            aVar.L = this.L;
            aVar.f6957a = this.f6957a;
            aVar.b = this.b;
            aVar.c = this.c;
            aVar.d = this.d;
            return aVar;
        }
    }

    private at(Context context) {
        this.C = context.getSharedPreferences(Code, 0);
    }

    private void f() {
        if (this.F == null) {
            a aVar = null;
            String string = this.C.getString(V, null);
            if (string != null && string.length() > 0) {
                aVar = (a) ad.V(string, a.class, new Class[0]);
            }
            if (aVar == null) {
                aVar = new a();
            }
            this.F = aVar;
        }
    }

    public Boolean B() {
        synchronized (this.S) {
            f();
            Boolean bool = this.F.Z;
            if (bool != null) {
                return bool;
            }
            return null;
        }
    }

    public String C() {
        String str;
        synchronized (this.S) {
            f();
            str = this.F.B;
        }
        return str;
    }

    public String D() {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return "";
            }
            return aVar.F;
        }
    }

    public Boolean F() {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            return aVar.S;
        }
    }

    public String I() {
        synchronized (this.S) {
            f();
            String str = this.F.I;
            if (str != null) {
                return str;
            }
            return null;
        }
    }

    public String L() {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            String str = aVar.D;
            if (str != null) {
                return str;
            }
            return null;
        }
    }

    public Integer S() {
        synchronized (this.S) {
            f();
            Integer num = this.F.C;
            if (num != null) {
                return num;
            }
            return null;
        }
    }

    public void V(Integer num) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.b = num;
            Code(aVar);
        }
    }

    public String Z() {
        String str;
        synchronized (this.S) {
            f();
            str = this.F.Code;
        }
        return str;
    }

    public String a() {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            String str = aVar.L;
            if (str != null) {
                return str;
            }
            return null;
        }
    }

    public Integer b() {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            return aVar.f6957a;
        }
    }

    public Integer c() {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            Integer num = aVar.b;
            if (num != null) {
                return num;
            }
            return null;
        }
    }

    public String d() {
        synchronized (this.S) {
            f();
            if (TextUtils.isEmpty(this.F.c)) {
                return "";
            }
            return this.F.c;
        }
    }

    public String e() {
        synchronized (this.S) {
            f();
            if (TextUtils.isEmpty(this.F.d)) {
                return "";
            }
            return this.F.d;
        }
    }

    public static at Code(Context context) {
        at atVar;
        synchronized (Z) {
            if (B == null) {
                B = new at(context);
            }
            atVar = B;
        }
        return atVar;
    }

    public void B(String str) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.d = str;
            Code(aVar);
        }
    }

    public void I(String str) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.F = str;
            Code(aVar);
        }
    }

    public void V(String str) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            aVar.B = str;
            Code(aVar);
        }
    }

    public void Z(String str) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.c = str;
            Code(aVar);
        }
    }

    public void B(boolean z) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.L = String.valueOf(z);
            Code(this.F);
        }
    }

    public void Code() {
        synchronized (this.S) {
            f();
        }
    }

    public void I(boolean z) {
        synchronized (this.S) {
            f();
            this.F.Z = Boolean.valueOf(z);
            Code(this.F);
        }
    }

    public void V(boolean z) {
        synchronized (this.S) {
            f();
            this.F.Code = String.valueOf(z);
            Code(this.F);
        }
    }

    public void Z(boolean z) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.D = String.valueOf(z);
            Code(this.F);
        }
    }

    public void Code(int i) {
        synchronized (this.S) {
            f();
            this.F.C = Integer.valueOf(i);
            Code(this.F);
        }
    }

    public boolean V() {
        synchronized (this.S) {
            f();
            Boolean bool = this.F.V;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
    }

    private void Code(a aVar) {
        if (aVar == null) {
            return;
        }
        final a aVarClone = aVar.clone();
        i.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.at.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = at.this.C.edit();
                editorEdit.putString(at.V, ad.V(aVarClone));
                editorEdit.apply();
            }
        });
    }

    public void Code(Boolean bool) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.S = bool;
            Code(aVar);
        }
    }

    public void Code(Integer num) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.f6957a = num;
            Code(aVar);
        }
    }

    public void Code(String str) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            aVar.I = str;
            Code(aVar);
        }
    }

    public void Code(boolean z) {
        synchronized (this.S) {
            f();
            this.F.V = Boolean.valueOf(z);
            Code(this.F);
        }
    }
}
