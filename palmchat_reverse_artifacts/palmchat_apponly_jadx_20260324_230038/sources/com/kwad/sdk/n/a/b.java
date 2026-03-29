package com.kwad.sdk.n.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsJson
public class b extends com.kwad.sdk.core.response.a.a {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();
    public Object bco;
    public String bcp;
    public String bcq;
    public boolean bcr;

    @NonNull
    public String bcs;
    public C0632b bct;
    public b bcu;

    /* JADX INFO: compiled from: SearchBox */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public Object bcA;
        public List<Object> bcB;
        public String bcv;
        public String bcw;
        public String bcx;
        public List<String> bcy;
        public List<a> bcz = new ArrayList();
        public String className;
        public String fieldName;

        private Object QR() {
            Object objHk = null;
            try {
                if (TextUtils.isEmpty(this.className)) {
                    c.w(b.TAG, "SpecialParam className is null");
                    return null;
                }
                objHk = z.hk(this.className);
                c.d(b.TAG, "Class.forName(className):" + this.className + " value:" + objHk);
                List<a> list = this.bcz;
                if (list != null && !list.isEmpty()) {
                    for (a aVar : this.bcz) {
                        aVar.bcA = objHk;
                        c.d(b.TAG, "param.ob:" + aVar.bcA);
                        try {
                            z.a(aVar.bcA, aVar.fieldName, aVar.getValue());
                        } catch (Exception e) {
                            c.d(b.TAG, Log.getStackTraceString(e));
                        }
                    }
                }
            } catch (Exception e2) {
                c.d(b.TAG, Log.getStackTraceString(e2));
            }
            c.d(b.TAG, "return value in special:" + objHk);
            return objHk;
        }

        private Object QS() {
            if (TextUtils.isEmpty(this.bcx)) {
                return ap(this.bcv, this.bcw);
            }
            this.bcB = new ArrayList();
            Iterator<String> it = this.bcy.iterator();
            while (it.hasNext()) {
                Object objAp = ap(this.bcx, it.next());
                if (objAp != null) {
                    this.bcB.add(objAp);
                }
            }
            return this.bcB;
        }

        private static Object ap(String str, String str2) {
            Object objValueOf = null;
            try {
                Class<?> cls = Class.forName(str);
                if (cls == Integer.class) {
                    objValueOf = Integer.valueOf(Integer.parseInt(str2));
                } else if (cls == Long.class) {
                    objValueOf = Long.valueOf(Long.parseLong(str2));
                } else if (cls == Float.class) {
                    objValueOf = Float.valueOf(Float.parseFloat(str2));
                } else if (cls == Boolean.class) {
                    objValueOf = Boolean.valueOf(Boolean.parseBoolean(str2));
                } else if (cls == Double.class) {
                    objValueOf = Double.valueOf(Double.parseDouble(str2));
                } else {
                    if (cls != String.class) {
                        str2 = null;
                    }
                    objValueOf = str2;
                }
            } catch (Exception e) {
                c.w(b.TAG, Log.getStackTraceString(e));
            }
            return objValueOf;
        }

        public final Object getValue() {
            return (TextUtils.isEmpty(this.bcv) && TextUtils.isEmpty(this.bcx)) ? QR() : QS();
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.n.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @KsJson
    public static class C0632b extends com.kwad.sdk.core.response.a.a {
        public boolean bcC;
        public List<a> bcD;
        public Object[] bcE;
        public String name;

        public final boolean QQ() {
            if (!TextUtils.isEmpty(this.name)) {
                return false;
            }
            List<a> list = this.bcD;
            return (list == null || list.isEmpty()) && this.bcE == null;
        }

        public final Object[] QT() {
            List<a> list = this.bcD;
            if (list == null || list.isEmpty()) {
                return null;
            }
            Object[] objArr = new Object[this.bcD.size()];
            for (int i = 0; i < this.bcD.size(); i++) {
                objArr[i] = this.bcD.get(i).getValue();
            }
            return objArr;
        }
    }

    public final boolean QQ() {
        if (this.bco != null || !TextUtils.isEmpty(this.bcp) || !TextUtils.isEmpty(this.bcq) || !TextUtils.isEmpty(this.bcs)) {
            return false;
        }
        C0632b c0632b = this.bct;
        if (c0632b != null && !c0632b.QQ()) {
            return false;
        }
        b bVar = this.bcu;
        return bVar == null || bVar.QQ();
    }
}
