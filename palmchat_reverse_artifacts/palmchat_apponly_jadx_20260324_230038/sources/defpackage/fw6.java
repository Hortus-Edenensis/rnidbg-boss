package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.umeng.analytics.pro.f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.apache.cordova.jssdk.RedPacketPullNewPlugin;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class fw6 implements e47 {
    public static k87 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17613a = 0;
    public boolean b = false;
    public Handler c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Activity> f17614a;

        public a(Activity activity) {
            this.f17614a = new WeakReference<>(activity);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Activity activity = this.f17614a.get();
            if (activity != null) {
                int i = message.what;
                if (i != 123) {
                    if (i == 124) {
                        fw6.d.b(new m17("Network_Info", g47.c(), (byte) 4, null, null));
                        return;
                    }
                    return;
                }
                Bitmap bitmapB = g47.b(activity);
                if (bitmapB != null) {
                    HashMap map = new HashMap();
                    map.put("activity_name", (String) message.obj);
                    fw6.d.b(new m17(RedPacketPullNewPlugin.ACTION_SCREENSHOT, bitmapB, (byte) 4, null, map));
                }
            }
        }
    }

    public fw6(k87 k87Var) {
        d = k87Var;
    }

    @Override // defpackage.e47
    public final void a(Context context) {
        if (d == null) {
            return;
        }
        String simpleName = ((Activity) context).getClass().getSimpleName();
        b(true, this.b, context);
        this.b = false;
        d.b(new m17("activity_lifecycle", simpleName + " start ", (byte) 4, null, null));
    }

    public final void b(boolean z, boolean z2, Context context) {
        if (d == null) {
            return;
        }
        if (!z) {
            int i = this.f17613a - 1;
            this.f17613a = i;
            if (i == 0 || z2) {
                d.b(new m17(f.aC, "session end", (byte) 4, null, null));
                return;
            }
            return;
        }
        int i2 = this.f17613a;
        this.f17613a = i2 + 1;
        if (i2 != 0 || z2) {
            return;
        }
        d.b(new m17(f.aC, "session start", (byte) 4, null, null));
        if (this.c == null) {
            this.c = new a((Activity) context);
        }
        this.c.sendEmptyMessage(124);
    }

    @Override // defpackage.e47
    public final void b(Context context) {
        if (d == null) {
            return;
        }
        Activity activity = (Activity) context;
        d.b(new m17("activity_lifecycle", activity.getClass().getSimpleName() + " stop ", (byte) 4, null, null));
        boolean z = activity.getChangingConfigurations() != 0;
        this.b = z;
        b(false, z, null);
    }
}
