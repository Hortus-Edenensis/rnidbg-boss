package defpackage;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.BeiZiBiddingConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class p47 {
    public Handler f;
    public HandlerThread g;
    public Context h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile IInterface f19938a = null;
    public String b = null;
    public String c = null;
    public final Object d = new Object();
    public ServiceConnection e = null;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public volatile ContentProviderClient l = null;
    public IBinder.DeathRecipient m = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.e("IDHelper", "1029");
            if (p47.this.f19938a != null) {
                p47.this.f19938a.asBinder().unlinkToDeath(p47.this.m, 0);
                p47.this.f19938a = null;
            }
        }
    }

    public Intent a() {
        throw null;
    }

    public String b(String str) {
        throw null;
    }

    public void c(Context context, String str, String str2) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00e1 A[Catch: all -> 0x0102, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x001e, B:7:0x0027, B:9:0x002d, B:11:0x0035, B:14:0x0040, B:12:0x003a, B:15:0x0044, B:19:0x004c, B:21:0x0059, B:22:0x005f, B:24:0x0067, B:25:0x0071, B:27:0x0075, B:38:0x009f, B:40:0x00a3, B:42:0x00a7, B:43:0x00a9, B:45:0x00b0, B:44:0x00ad, B:53:0x00c8, B:55:0x00cc, B:68:0x00e7, B:67:0x00e3, B:69:0x00ea, B:66:0x00e1, B:72:0x00ee, B:74:0x00f2, B:76:0x00f6, B:77:0x00f8, B:79:0x00ff, B:78:0x00fc, B:80:0x0101, B:62:0x00d9, B:64:0x00dd, B:30:0x007d, B:32:0x0081, B:33:0x0091, B:35:0x0095, B:37:0x009a, B:48:0x00b4, B:49:0x00b8, B:51:0x00be, B:61:0x00d4), top: B:85:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e7 A[Catch: all -> 0x0102, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x001e, B:7:0x0027, B:9:0x002d, B:11:0x0035, B:14:0x0040, B:12:0x003a, B:15:0x0044, B:19:0x004c, B:21:0x0059, B:22:0x005f, B:24:0x0067, B:25:0x0071, B:27:0x0075, B:38:0x009f, B:40:0x00a3, B:42:0x00a7, B:43:0x00a9, B:45:0x00b0, B:44:0x00ad, B:53:0x00c8, B:55:0x00cc, B:68:0x00e7, B:67:0x00e3, B:69:0x00ea, B:66:0x00e1, B:72:0x00ee, B:74:0x00f2, B:76:0x00f6, B:77:0x00f8, B:79:0x00ff, B:78:0x00fc, B:80:0x0101, B:62:0x00d9, B:64:0x00dd, B:30:0x007d, B:32:0x0081, B:33:0x0091, B:35:0x0095, B:37:0x009a, B:48:0x00b4, B:49:0x00b8, B:51:0x00be, B:61:0x00d4), top: B:85:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void d(Context context, List<String> list, boolean z) {
        if (this.f == null) {
            HandlerThread handlerThread = new HandlerThread("GetIDWorkThread");
            this.g = handlerThread;
            handlerThread.start();
            this.f = new u87(this, this.g.getLooper());
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!(z ? f(str) : g(str))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        be7.a("2010");
        if (TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = lx6.b(context, this.b, "SHA1");
        }
        if (this.i) {
            try {
                try {
                    if (this.l == null) {
                        this.l = context.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.oplus.omes.ids_provider"));
                    }
                } catch (Exception e) {
                    be7.b("3148", e);
                    if (this.l != null) {
                        if (Build.VERSION.SDK_INT >= 24) {
                        }
                    }
                }
                if (this.l == null) {
                    e(arrayList);
                    Log.e("IDHelper", "3147");
                    if (this.l != null) {
                        (Build.VERSION.SDK_INT >= 24 ? this.l : this.l).release();
                        this.l = null;
                    }
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    i((String) it.next());
                }
                if (this.l != null) {
                    ContentProviderClient contentProviderClient = Build.VERSION.SDK_INT >= 24 ? this.l : this.l;
                    contentProviderClient.release();
                    this.l = null;
                }
            } catch (Throwable th) {
                if (this.l != null) {
                    (Build.VERSION.SDK_INT >= 24 ? this.l : this.l).release();
                    this.l = null;
                }
                throw th;
            }
        } else {
            e(arrayList);
        }
    }

    public final void e(List<String> list) {
        String str;
        be7.a("2048");
        if (this.f19938a == null) {
            be7.a("2009");
            try {
                if (this.h.bindService(a(), this.e, 1)) {
                    be7.a("2013");
                    if (this.f19938a == null) {
                        synchronized (this.d) {
                            try {
                                if (this.f19938a == null) {
                                    this.d.wait(10000L);
                                }
                            } catch (InterruptedException e) {
                                e = e;
                                str = "1006";
                                be7.b(str, e);
                            } catch (Exception e2) {
                                e = e2;
                                str = "1057";
                                be7.b(str, e);
                            }
                        }
                    }
                } else {
                    Log.e("IDHelper", "1007");
                }
            } catch (Exception e3) {
                be7.b("1008", e3);
            }
        }
        if (this.f19938a == null) {
            Log.e("IDHelper", "1004");
            return;
        }
        Handler handler = this.f;
        if (handler != null) {
            handler.removeMessages(2);
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            i(it.next());
        }
        Handler handler2 = this.f;
        if (handler2 == null) {
            return;
        }
        Message messageObtainMessage = handler2.obtainMessage();
        messageObtainMessage.what = 2;
        this.f.sendMessageDelayed(messageObtainMessage, 300000L);
    }

    public boolean f(String str) {
        throw null;
    }

    public boolean g(String str) {
        throw null;
    }

    public String h(String str) {
        be7.a("2049");
        Bundle bundle = new Bundle();
        bundle.putString("packageName", this.b);
        bundle.putString(com.umeng.ccg.a.A, this.c);
        try {
            if (this.l != null) {
                return this.l.call(str, null, bundle).getString(str);
            }
        } catch (RemoteException unused) {
            Log.e("IDHelper", "3149");
        } catch (Exception e) {
            be7.b("3150", e);
        }
        return "";
    }

    public final void i(String str) {
        String str2;
        synchronized (this.d) {
            be7.a(str + " 2023");
            Handler handler = this.f;
            if (handler != null) {
                Message messageObtainMessage = handler.obtainMessage();
                if (str.equals("RESET_OUID")) {
                    messageObtainMessage.what = 3;
                } else {
                    messageObtainMessage.what = 1;
                }
                Bundle bundle = new Bundle();
                bundle.putString("IdType", str);
                messageObtainMessage.setData(bundle);
                this.f.sendMessage(messageObtainMessage);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            int i = str.equals("DUID") ? 5000 : 2000;
            try {
                this.d.wait(i);
            } catch (InterruptedException e) {
                e = e;
                str2 = BeiZiBiddingConstant.Adn.ADN_GM;
                be7.b(str2, e);
            } catch (Exception e2) {
                e = e2;
                str2 = "1058";
                be7.b(str2, e);
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis > i) {
                Log.e("IDHelper", "1023");
            }
            be7.a(str + " 2024");
        }
    }
}
