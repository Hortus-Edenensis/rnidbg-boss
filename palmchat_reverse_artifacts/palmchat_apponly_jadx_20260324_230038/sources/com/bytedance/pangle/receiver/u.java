package com.bytedance.pangle.receiver;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u {
    private static final fx u;

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends C0198u {
        private b() {
            super();
        }

        @Override // com.bytedance.pangle.receiver.u.C0198u, com.bytedance.pangle.receiver.u.fx
        public boolean u(Context context) throws Throwable {
            Object objU = u(context, "mWhiteList");
            if (!(objU instanceof List)) {
                return false;
            }
            ((List) objU).add(context.getPackageName());
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface fx {
        boolean u(Context context) throws Throwable;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr extends pn {
        private nr() {
            super();
        }

        @Override // com.bytedance.pangle.receiver.u.pn, com.bytedance.pangle.receiver.u.C0198u, com.bytedance.pangle.receiver.u.fx
        public boolean u(Context context) throws Throwable {
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class pn extends C0198u {
        private pn() {
            super();
        }

        @Override // com.bytedance.pangle.receiver.u.C0198u, com.bytedance.pangle.receiver.u.fx
        public boolean u(Context context) throws Throwable {
            Object objU = u(context, "mWhiteListMap");
            if (!(objU instanceof Map)) {
                return false;
            }
            Map map = (Map) objU;
            List arrayList = (List) map.get(0);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(0, arrayList);
            }
            arrayList.add(context.getPackageName());
            return true;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            u = new C0198u();
            return;
        }
        if (i < 26) {
            u = new b();
        } else if (i < 28) {
            u = new pn();
        } else {
            u = new nr();
        }
    }

    public static void u(Application application) {
        if (application != null) {
            try {
                if (a.bq()) {
                    u.u(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.pangle.receiver.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0198u implements fx {
        private C0198u() {
        }

        private Object nr(Context context) {
            Field field;
            Object field2;
            try {
                Field field3 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field3 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (field2 = FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return FieldUtils.readField(field3, field2);
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.bytedance.pangle.receiver.u.fx
        public boolean u(Context context) throws Throwable {
            Object objNr = nr(context);
            Object objU = u(objNr, "mWhiteList");
            if (!(objU instanceof String[])) {
                if (objNr == null) {
                    return false;
                }
                FieldUtils.writeField(objNr, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) objU);
            FieldUtils.writeField(objNr, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        public Object u(Context context, String str) {
            return u(nr(context), str);
        }

        private Object u(Object obj, String str) {
            if (obj == null) {
                return null;
            }
            try {
                return FieldUtils.readField(obj, str);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
