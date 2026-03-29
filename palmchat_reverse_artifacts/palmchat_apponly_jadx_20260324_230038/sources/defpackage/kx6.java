package defpackage;

import android.app.OplusNotificationManager;
import android.os.Build;
import android.util.Log;
import com.android.id.impl.IdProviderImpl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class kx6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IdProviderImpl f18851a;
    public OplusNotificationManager b = null;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final kx6 f18852a = new kx6();
    }

    public kx6() {
        this.f18851a = null;
        int i = Build.VERSION.SDK_INT;
        if (i != 31 && i != 32) {
            try {
                this.f18851a = new IdProviderImpl();
                return;
            } catch (Error | Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("1084: ");
                sb.append(e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage());
                be7.c(sb.toString());
            }
        }
        a();
    }

    public final void a() {
        try {
            this.b = new OplusNotificationManager();
        } catch (Error | Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("1085: ");
            sb.append(e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage());
            Log.e("IDHelper", sb.toString());
        }
    }
}
