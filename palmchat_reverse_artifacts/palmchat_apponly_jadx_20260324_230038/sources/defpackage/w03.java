package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class w03 implements dn2 {
    @Override // defpackage.dn2
    public en2 a(Context context) {
        return new a(context);
    }

    @Override // defpackage.dn2
    public boolean b(boolean z, String... strArr) {
        return iq5.i(true, z, strArr);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements en2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public lo3 f21575a;

        public a(Context context) {
            this.f21575a = new lo3(context, new ServiceConnectionC1282a());
        }

        @Override // defpackage.en2
        public void a() {
            this.f21575a.c();
        }

        @Override // defpackage.en2
        public boolean b() {
            return this.f21575a.e() != null;
        }

        /* JADX INFO: renamed from: w03$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class ServiceConnectionC1282a implements ServiceConnection {
            public ServiceConnectionC1282a() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            }
        }
    }
}
