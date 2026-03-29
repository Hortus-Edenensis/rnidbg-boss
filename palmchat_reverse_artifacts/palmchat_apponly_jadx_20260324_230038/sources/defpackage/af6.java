package defpackage;

import android.content.Context;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class af6 {

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1220a;

        static {
            int[] iArr = new int[TeenagersModeManager.SmallVideoMode.values().length];
            f1220a = iArr;
            try {
                iArr[TeenagersModeManager.SmallVideoMode.ATTENTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1220a[TeenagersModeManager.SmallVideoMode.ALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1220a[TeenagersModeManager.SmallVideoMode.NOT_ACCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onFinish(boolean z);
    }

    public static int a() {
        if (!TeenagersModeManager.a().d()) {
            return 0;
        }
        int i = a.f1220a[TeenagersModeManager.a().b().ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 0 : 3;
        }
        return 1;
    }

    public static boolean b() {
        int iA = a();
        return iA == 0 || iA == 1;
    }

    public static boolean c() {
        return a() == 3;
    }

    public static boolean d() {
        return a() == 3;
    }

    public static void e(Context context, String str, String str2, b bVar) {
        int iA = a();
        if (context instanceof FrameworkBaseActivity) {
        }
        if (iA == 3) {
            bVar.onFinish(false);
            return;
        }
        if (iA == 2) {
            bVar.onFinish(false);
        } else if (iA == 1 || iA == 0) {
            bVar.onFinish(true);
        }
    }
}
