package com.bytedance.sdk.openadsdk.ats;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.SparseArray;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.component.b.a;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Function$CC;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements a, Function {
    private static final Set<String> fx = new HashSet();
    private static File nr;
    private Map<String, com.bytedance.sdk.component.b.nr.fx> u = new ConcurrentHashMap();

    public b() {
        fx.add("sp_bidding_opt_libra");
    }

    private static File b() {
        String name;
        File filesDir = dw.getContext().getFilesDir();
        do {
            name = filesDir.getName();
            if (name == null) {
                break;
            }
            filesDir = filesDir.getParentFile();
        } while (!name.equals("files"));
        return new File(filesDir, "shared_prefs");
    }

    private com.bytedance.sdk.component.b.nr.fx fx(String str) {
        int iAl = dw.nr().al();
        com.bytedance.sdk.openadsdk.core.pb.iz izVarSj = dw.nr().sj();
        if (iAl != 3 || Build.VERSION.SDK_INT == 27) {
            return new com.bytedance.sdk.component.x.fx.b(dw.getContext().getSharedPreferences(b(str), 0));
        }
        File fileNr = nr(str);
        return new com.bytedance.sdk.component.x.fx.fx(fileNr, u(fileNr, str), u(str, izVarSj.u), izVarSj.nr);
    }

    private com.bytedance.sdk.component.x.u nr() {
        return com.bytedance.sdk.component.x.fx.pn.u() ? new com.bytedance.sdk.component.x.fx.pn(null) : new com.bytedance.sdk.component.x.fx.iz(null);
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            com.bytedance.sdk.component.b.nr.fx fxVar = get((String) sparseArray.get(1));
            return fxVar != null ? new com.bytedance.sdk.component.b.nr.b(fxVar) : fxVar;
        }
        if (iIntValue == 2) {
            com.bytedance.sdk.component.b.nr.fx fxVarU = u((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
            return fxVarU != null ? new com.bytedance.sdk.component.b.nr.b(fxVarU) : fxVarU;
        }
        if (iIntValue == 3) {
            com.bytedance.sdk.component.b.nr.u encrypt = getEncrypt(((Integer) sparseArray.get(1)).intValue());
            return encrypt != null ? new com.bytedance.sdk.component.b.nr.nr(encrypt) : encrypt;
        }
        if (iIntValue == 4) {
            store();
            return null;
        }
        if (iIntValue != 5) {
            return null;
        }
        u();
        return null;
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.b.a
    public com.bytedance.sdk.component.b.nr.fx get(String str) {
        if (str == null) {
            str = "tt_sp";
        }
        com.bytedance.sdk.component.b.nr.fx fxVar = this.u.get(str);
        if (fxVar != null) {
            return fxVar;
        }
        synchronized (this.u) {
            com.bytedance.sdk.component.b.nr.fx fxVar2 = this.u.get(str);
            if (fxVar2 != null) {
                return fxVar2;
            }
            com.bytedance.sdk.component.b.nr.fx fxVarFx = fx(str);
            this.u.put(str, fxVarFx);
            return fxVarFx;
        }
    }

    @Override // com.bytedance.sdk.component.b.a
    public com.bytedance.sdk.component.b.nr.u getEncrypt(int i) {
        if (i != 32) {
            return null;
        }
        return new com.bytedance.sdk.component.x.u.u();
    }

    @Override // com.bytedance.sdk.component.b.a
    public void store() {
        Iterator<String> it = this.u.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.b.nr.fx fxVar = this.u.get(it.next());
            if (fxVar != null) {
                fxVar.apply();
            }
        }
    }

    public com.bytedance.sdk.component.b.nr.fx u(String str, int i) {
        return get(str);
    }

    private com.bytedance.sdk.component.x.u u(File file, String str) {
        if (fx.contains(str)) {
            return nr();
        }
        if (d.fx < 6900) {
            return nr();
        }
        u(file);
        return new com.bytedance.sdk.component.x.fx.u(null);
    }

    public static File nr(String str) {
        if (nr == null) {
            nr = b();
        }
        return new File(nr, b(str) + ".xml");
    }

    private static String b(String str) {
        return !str.startsWith("pangle_") ? "pangle_com.byted.pangle_".concat(str) : str;
    }

    private com.bytedance.sdk.component.x.nr u(String str, boolean z) {
        if (fx.contains(str)) {
            return fx();
        }
        com.bytedance.sdk.component.x.u.u uVar = z ? new com.bytedance.sdk.component.x.u.u() : null;
        if (Build.VERSION.SDK_INT != 27 && d.fx >= 6900) {
            return new com.bytedance.sdk.component.x.fx.u(uVar);
        }
        return fx();
    }

    private com.bytedance.sdk.component.x.nr fx() {
        if (com.bytedance.sdk.component.x.fx.pn.u()) {
            return new com.bytedance.sdk.component.x.fx.pn(null);
        }
        return new com.bytedance.sdk.component.x.fx.iz(null);
    }

    private void u(File file) {
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (!file2.exists() || file2.length() <= 0) {
            return;
        }
        file.delete();
    }

    public void u() {
        synchronized (this.u) {
            this.u.clear();
        }
    }

    public static com.bytedance.sdk.component.b.nr.fx u(String str) {
        return ((a) fx.u("kv_store_factory")).get(str);
    }

    public static SharedPreferences u(@ForbidWrapParam Context context, String str, int i) {
        return u(str);
    }
}
