package defpackage;

import com.apm.lite.CrashInfoCallback;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashCallback;
import com.apm.lite.IOOMCallback;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class x37 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ICrashCallback> f21871a = new CopyOnWriteArrayList();
    public final List<ICrashCallback> b = new CopyOnWriteArrayList();
    public final List<ICrashCallback> c = new CopyOnWriteArrayList();
    public final List<ICrashCallback> d = new CopyOnWriteArrayList();
    public final List<IOOMCallback> e = new CopyOnWriteArrayList();
    public final List<CrashInfoCallback> f = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21872a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f21872a = iArr;
            try {
                iArr[CrashType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21872a[CrashType.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21872a[CrashType.JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21872a[CrashType.LAUNCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21872a[CrashType.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public List<IOOMCallback> a() {
        return this.e;
    }

    public void b(ICrashCallback iCrashCallback, CrashType crashType) {
        List<ICrashCallback> list;
        int i = a.f21872a[crashType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    list = this.b;
                } else if (i == 4) {
                    list = this.f21871a;
                } else if (i != 5) {
                    return;
                } else {
                    list = this.c;
                }
            }
            list.add(iCrashCallback);
        }
        this.f21871a.add(iCrashCallback);
        this.b.add(iCrashCallback);
        this.c.add(iCrashCallback);
        list = this.d;
        list.add(iCrashCallback);
    }

    public void c(IOOMCallback iOOMCallback) {
        this.e.add(iOOMCallback);
    }

    public List<ICrashCallback> d() {
        return this.f21871a;
    }

    public void e(ICrashCallback iCrashCallback, CrashType crashType) {
        List<ICrashCallback> list;
        int i = a.f21872a[crashType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    list = this.b;
                } else if (i == 4) {
                    list = this.f21871a;
                } else if (i != 5) {
                    return;
                } else {
                    list = this.c;
                }
            }
            list.remove(iCrashCallback);
        }
        this.f21871a.remove(iCrashCallback);
        this.b.remove(iCrashCallback);
        this.c.remove(iCrashCallback);
        list = this.d;
        list.remove(iCrashCallback);
    }

    public void f(IOOMCallback iOOMCallback) {
        this.e.remove(iOOMCallback);
    }

    public List<ICrashCallback> g() {
        return this.b;
    }

    public List<ICrashCallback> h() {
        return this.c;
    }

    public List<ICrashCallback> i() {
        return this.d;
    }
}
