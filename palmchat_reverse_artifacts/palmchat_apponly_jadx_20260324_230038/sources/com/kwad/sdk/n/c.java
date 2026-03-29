package com.kwad.sdk.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.huawei.hms.ads.ex;
import com.kwad.sdk.n.a.b;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {
    public static final String TAG = "Ranger_" + c.class.getSimpleName();
    private String value;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static final c bbZ = new c(0);
    }

    private c() {
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public static c QK() {
        return a.bbZ;
    }

    public static /* synthetic */ com.kwad.sdk.n.b.a.d a(c cVar, String str, String str2) {
        return ao(str, str2);
    }

    @Nullable
    private static com.kwad.sdk.n.b.a.d ao(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.kwad.sdk.n.b.a.d dVar = new com.kwad.sdk.n.b.a.d();
        dVar.name = str;
        dVar.bcM = str2;
        return dVar;
    }

    private Object b(com.kwad.sdk.n.a.b bVar) {
        Class<?> cls;
        if (!bVar.bct.bcC) {
            if (bVar.bco != null) {
                return a(bVar, false, (Class<?>) null);
            }
            return null;
        }
        try {
            if (TextUtils.isEmpty(bVar.bcp)) {
                Object obj = bVar.bco;
                cls = obj != null ? obj.getClass() : null;
            } else {
                cls = Class.forName(bVar.bcp);
            }
            if (cls != null) {
                return a(bVar, true, cls);
            }
            return null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e));
            return null;
        }
    }

    private static String p(Object obj) {
        if (obj != null) {
            return String.valueOf(obj);
        }
        com.kwad.sdk.core.d.c.w(TAG, "value is null by ob null");
        return "";
    }

    public final void c(d dVar) {
        List<com.kwad.sdk.n.a.b> list;
        if (dVar == null || (list = dVar.bcc) == null || list.isEmpty()) {
            return;
        }
        final List<com.kwad.sdk.n.a.b> list2 = dVar.bcc;
        h.schedule(new bg() { // from class: com.kwad.sdk.n.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ArrayList arrayList = new ArrayList();
                for (com.kwad.sdk.n.a.b bVar : list2) {
                    if (bVar != null && !TextUtils.isEmpty(bVar.bcs)) {
                        String str = bVar.bcs;
                        c cVar = c.this;
                        cVar.value = cVar.a(bVar);
                        c cVar2 = c.this;
                        com.kwad.sdk.n.b.a.d dVarA = c.a(cVar2, str, cVar2.value);
                        if (dVarA != null) {
                            arrayList.add(dVarA);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                com.kwad.sdk.n.b.a.e eVar = new com.kwad.sdk.n.b.a.e();
                eVar.bcN = arrayList;
                com.kwad.sdk.n.b.a.a(eVar);
            }
        }, 20L, TimeUnit.SECONDS);
    }

    private static Object c(com.kwad.sdk.n.a.b bVar) {
        if (bVar.bcr) {
            try {
                return z.c(Class.forName(bVar.bcp), bVar.bcq);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e));
            }
        } else {
            Object obj = bVar.bco;
            if (obj != null) {
                return z.getField(obj, bVar.bcq);
            }
        }
        return null;
    }

    public final String a(com.kwad.sdk.n.a.b bVar) {
        com.kwad.sdk.n.a.b bVar2 = bVar.bcu;
        if (bVar2 != null && !bVar2.QQ()) {
            if (!TextUtils.isEmpty(bVar.bcq)) {
                bVar.bcu.bco = c(bVar);
            } else {
                b.C0632b c0632b = bVar.bct;
                if (c0632b != null && !c0632b.QQ()) {
                    bVar.bcu.bco = b(bVar);
                }
            }
            return a(bVar.bcu);
        }
        if (!TextUtils.isEmpty(bVar.bcq)) {
            return p(c(bVar));
        }
        b.C0632b c0632b2 = bVar.bct;
        if (c0632b2 != null && !c0632b2.QQ()) {
            return p(b(bVar));
        }
        com.kwad.sdk.core.d.c.d(TAG, "node.nodeClassName:" + bVar.bcp);
        return z.classExists(bVar.bcp) ? ex.Code : ex.V;
    }

    private static Object a(com.kwad.sdk.n.a.b bVar, boolean z, Class<?> cls) {
        Object[] objArrQT = bVar.bct.QT();
        if (objArrQT == null || objArrQT.length == 0) {
            if (z) {
                return z.callStaticMethod(cls, bVar.bct.name, new Object[0]);
            }
            return z.callMethod(bVar.bco, bVar.bct.name, new Object[0]);
        }
        if (z) {
            return z.callStaticMethod(cls, bVar.bct.name, objArrQT);
        }
        return z.callMethod(bVar.bco, bVar.bct.name, objArrQT);
    }
}
