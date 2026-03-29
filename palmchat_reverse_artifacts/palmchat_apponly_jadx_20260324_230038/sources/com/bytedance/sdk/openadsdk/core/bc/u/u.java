package com.bytedance.sdk.openadsdk.core.bc.u;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.TTC;
import com.bytedance.sdk.openadsdk.TTM;
import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import j$.util.Objects;
import java.lang.reflect.Method;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.bc.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0238u {
        void b(String str, String str2);

        void fx(String str, String str2);

        void nr(String str, String str2);

        void u();

        void u(String str, String str2);

        void u(String str, String str2, Throwable th);

        void u(String str, Throwable th);
    }

    private static String b(Object obj) {
        if (obj == null) {
            return "";
        }
        TTC ttc = obj instanceof Class ? (TTC) ((Class) obj).getAnnotation(TTC.class) : (TTC) obj.getClass().getAnnotation(TTC.class);
        return ttc == null ? "" : ttc.value();
    }

    public static void fx(Object obj) {
        String strB = "";
        try {
            if (nr(obj)) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, -8999923);
                sparseArray.put(-99999985, String.class);
                strB = (String) ((Function) obj).apply(sparseArray);
            } else {
                TTC ttc = (TTC) obj.getClass().getAnnotation(TTC.class);
                if (ttc != null) {
                    strB = b(ttc);
                }
            }
        } catch (Throwable unused) {
        }
        strB.hashCode();
        if (strB.equals(TKDownloadReason.KSAD_TK_NET)) {
            com.bytedance.sdk.openadsdk.x.fx.u = null;
        }
    }

    public static boolean nr(Object obj) {
        Boolean bool;
        if (obj == null || !(obj instanceof Function)) {
            return false;
        }
        try {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -99999986);
            sparseArray.put(-99999985, SparseArray.class);
            SparseArray sparseArray2 = (SparseArray) ((Function) obj).apply(sparseArray);
            if (sparseArray2 != null && (bool = (Boolean) sparseArray2.get(-99999978)) != null) {
                if (bool.booleanValue()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void u(Object obj) {
        try {
            if (!nr(obj)) {
                if (obj != null) {
                    u(null, obj, b(obj), false);
                    return;
                }
                return;
            }
            Function function = (Function) obj;
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -8999924);
            sparseArray.put(-99999985, Object.class);
            Object objApply = function.apply(sparseArray);
            if (objApply != null) {
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(-99999987, -8999923);
                sparseArray2.put(-99999985, String.class);
                u(function, objApply, (String) function.apply(sparseArray2), true);
            }
        } catch (Throwable th) {
            Objects.toString(obj);
            th.getMessage();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr implements InterfaceC0238u {
        Function nr;
        Object u;

        public nr(Object obj) {
            this.u = obj;
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.u.InterfaceC0238u
        public void b(String str, String str2) {
            if (this.nr != null) {
                u(-8999905, str, str2, null);
            }
            Object obj = this.u;
            if (obj != null) {
                ((TTILog) obj).e(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.u.InterfaceC0238u
        public void fx(String str, String str2) {
            if (this.nr != null) {
                u(-8999902, str, str2, null);
            }
            Object obj = this.u;
            if (obj != null) {
                ((TTILog) obj).i(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.u.InterfaceC0238u
        public void nr(String str, String str2) {
            if (this.nr != null) {
                u(-8999901, str, str2, null);
            }
            Object obj = this.u;
            if (obj != null) {
                ((TTILog) obj).d(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.u.InterfaceC0238u
        public void u(String str, String str2) {
            if (this.nr != null) {
                u(-8999900, str, str2, null);
            }
            Object obj = this.u;
            if (obj != null) {
                ((TTILog) obj).v(str, str2);
            }
        }

        public nr(Function<SparseArray<Object>, Object> function) {
            this.nr = function;
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.u.InterfaceC0238u
        public void u(String str, String str2, Throwable th) {
            if (this.nr != null) {
                u(-8999905, str, str2, th);
            }
            Object obj = this.u;
            if (obj != null) {
                ((TTILog) obj).e(str, str2, th);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.u.InterfaceC0238u
        public void u(String str, Throwable th) {
            if (this.nr != null) {
                u(-8999905, str, null, th);
            }
            Object obj = this.u;
            if (obj != null) {
                ((TTILog) obj).e(str, th);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.u.InterfaceC0238u
        public void u() {
            if (this.nr != null) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, -8999907);
                sparseArray.put(-99999985, Void.class);
                this.nr.apply(sparseArray);
            }
            Object obj = this.u;
            if (obj != null) {
                ((TTILog) obj).flush();
            }
        }

        private void u(int i, String str, String str2, Throwable th) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, Integer.valueOf(i));
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(-8999920, str);
            sparseArray.put(-8999921, str2);
            sparseArray.put(-8999922, th);
            this.nr.apply(sparseArray);
        }
    }

    private static void nr(Function<SparseArray<Object>, Object> function, Object obj, boolean z) {
        if (k.fx()) {
            com.bytedance.sdk.openadsdk.x.fx fxVar = new com.bytedance.sdk.openadsdk.x.fx();
            com.bytedance.sdk.openadsdk.x.fx.u = fxVar;
            try {
                for (Method method : obj.getClass().getDeclaredMethods()) {
                    if (z) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, -8999909);
                        sparseArray.put(-99999985, Integer.class);
                        sparseArray.put(-8999925, method);
                        Integer num = (Integer) function.apply(sparseArray);
                        if (num != null) {
                            method.setAccessible(true);
                            fxVar.u(num.intValue(), method);
                        }
                    } else {
                        TTM ttm = (TTM) method.getAnnotation(TTM.class);
                        if (ttm != null) {
                            method.setAccessible(true);
                            fxVar.u(ttm.value(), method);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            fxVar.u(obj);
        }
    }

    private static void u(Function<SparseArray<Object>, Object> function, Object obj, String str, boolean z) {
        if (obj == null) {
            return;
        }
        str.hashCode();
        if (str.equals("log")) {
            u(function, obj, z);
        } else if (str.equals(TKDownloadReason.KSAD_TK_NET)) {
            nr(function, obj, z);
        }
        obj.toString();
    }

    private static void u(Function<SparseArray<Object>, Object> function, Object obj, boolean z) {
        try {
            if (z) {
                LogAdapter.u((InterfaceC0238u) new nr(function), true);
            } else if (obj instanceof TTILog) {
                LogAdapter.u((InterfaceC0238u) new nr(obj), true);
            }
        } catch (Throwable unused) {
        }
    }

    public static com.bytedance.sdk.openadsdk.x.nr u(String str) {
        str.hashCode();
        if (str.equals(TKDownloadReason.KSAD_TK_NET)) {
            return com.bytedance.sdk.openadsdk.x.fx.u;
        }
        return null;
    }
}
