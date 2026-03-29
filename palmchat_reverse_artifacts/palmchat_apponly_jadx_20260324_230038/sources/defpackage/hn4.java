package defpackage;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.cdo.oaps.ad.Launcher;
import com.kuaishou.weapon.p0.t;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u001a\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¨\u0006\u0006"}, d2 = {"Landroid/content/Context;", "context", "", "a", "c", t.l, "zx-core_release"}, k = 2, mv = {1, 4, 0})
public final class hn4 {

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", Launcher.Method.INVOKE_CALLBACK}, k = 3, mv = {1, 1, 16})
    public static final class a extends Lambda implements Function0<String> {
        public final /* synthetic */ Context b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.b = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
            Object next;
            Object systemService = this.b.getSystemService("activity");
            if (systemService == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
            }
            int iMyPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<T> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((ActivityManager.RunningAppProcessInfo) next).pid == iMyPid) {
                        break;
                    }
                }
                runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
            } else {
                runningAppProcessInfo = null;
            }
            if (runningAppProcessInfo != null) {
                return runningAppProcessInfo.processName;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", Launcher.Method.INVOKE_CALLBACK}, k = 3, mv = {1, 1, 16})
    public static final class b extends Lambda implements Function0<String> {
        public static final b b = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "declaredMethod");
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            return (String) (objInvoke instanceof String ? objInvoke : null);
        }
    }

    public static final String a(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        String strC = c();
        return strC != null ? strC : b(context);
    }

    public static final String b(Context context) {
        return (String) C1502w15.a(null, new a(context));
    }

    public static final String c() {
        return (String) C1502w15.a(null, b.b);
    }
}
