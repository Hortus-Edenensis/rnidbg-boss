package cn.fly.verify;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import cn.fly.verify.fq;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import j$.util.concurrent.ConcurrentHashMap;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class et {
    private static et b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2257a;
    private Object c;
    private PackageManager d;
    private ConcurrentHashMap<String, Object> e = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> f = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> g = new ConcurrentHashMap<>();
    private String h;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a<T> {
        private a() {
        }

        public abstract T a() throws Throwable;
    }

    private et(Context context) {
        this.f2257a = context;
        String packageName = context.getPackageName();
        this.h = packageName;
        try {
            a(packageName, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT);
        } catch (Throwable th) {
            en.a().a(th);
        }
    }

    public static et a(Context context) {
        if (b == null) {
            synchronized (et.class) {
                if (b == null) {
                    b = new et(context);
                }
            }
        }
        return b;
    }

    public int b() {
        if (!er.a(this.f2257a).d().e(ed.a("035de'dcdjeddidcfdNjfWdjdfdifhfhdied5e<fdgighelfkdhglfjggehghdhejekelekgh"))) {
            return -1;
        }
        if (!az.a().i()) {
            return az.a().t();
        }
        if (this.c == null) {
            this.c = fq.d.a(ed.a("005jh]ed*ef"));
        }
        return ((Integer) fy.a(this.c, ed.a("014Wee fiVehIfi@ffeddjdlekdk_jf"), -1, new Object[0])).intValue();
    }

    public int c() {
        if (Build.VERSION.SDK_INT < 24 || !fq.d.b(ed.a("035deCdcdjeddidcfd<jfTdjdfdifhfhdiedJe3fdgighelfkdhglfjggehghdhejekelekgh"))) {
            return -1;
        }
        if (!az.a().i()) {
            return az.a().t();
        }
        if (this.c == null) {
            this.c = fq.d.a(ed.a("005jhEedNef"));
        }
        return ((Integer) fy.a(this.c, ed.a("018=ee3fiDfk,did?eh]fiJffeddjdlekdkNjf"), -1, new Object[0])).intValue();
    }

    public ApplicationInfo d() {
        return this.f2257a.getApplicationInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object c(String str, int i) throws Throwable {
        return Build.VERSION.SDK_INT <= 25 ? fq.d.a(this.d, ed.a("014Bee]fi>gl5dc]dlVd8ee4fLei2eTefed"), new Object[]{str, Integer.valueOf(i)}, new Class[]{String.class, Integer.TYPE}) : ez.a(this.f2257a, str, i);
    }

    public ApplicationInfo b(String str, int i) throws PackageManager.NameNotFoundException {
        if (this.d == null) {
            this.d = this.f2257a.getPackageManager();
        }
        if (TextUtils.equals(str, this.f2257a.getPackageName()) || Cdo.b()) {
            return this.d.getApplicationInfo(str, i);
        }
        return null;
    }

    public Object a(final String str, final int i) throws Throwable {
        if (this.d == null) {
            this.d = this.f2257a.getPackageManager();
        }
        boolean zEquals = str.equals(this.h);
        if (!zEquals && !Cdo.b()) {
            return null;
        }
        if (!zEquals) {
            return c(str, i);
        }
        final int i2 = (i == 0 || i == 1 || i == 128 || i == 64) ? MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT : i;
        Object objA = a("gpisys-" + str + "-" + i2, new a<Object>() { // from class: cn.fly.verify.et.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // cn.fly.verify.et.a
            public Object a() throws Throwable {
                return et.this.c(str, i2);
            }
        }, (Object) null);
        if (objA != null || i2 != 193) {
            return objA;
        }
        return a("gpisys-" + str + "-" + i, new a<Object>() { // from class: cn.fly.verify.et.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // cn.fly.verify.et.a
            public Object a() throws Throwable {
                return et.this.c(str, i);
            }
        }, (Object) null);
    }

    public ResolveInfo b(Intent intent, int i) {
        if (Cdo.b()) {
            return (ResolveInfo) fy.a(this.f2257a.getPackageManager(), ed.a("0152djBfIfhedRg$dd%fWelDci.didddiPi!dk"), new Object[]{intent, Integer.valueOf(i)}, (Class<?>[]) new Class[]{Intent.class, Integer.TYPE}, (Object) null);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T a(String str, a<T> aVar, long j, T t, boolean z) {
        Object objA;
        ConcurrentHashMap<String, Integer> concurrentHashMap;
        int iValueOf;
        Object objA2 = null;
        try {
        } catch (Throwable th) {
            en.a().a(th);
        }
        if (str == null) {
            objA = aVar.a();
            return objA != null ? t : (T) objA;
        }
        Integer num = this.f.get(str);
        if (num != null && (objA2 = this.e.get(str)) == null && !z) {
            return t;
        }
        Long l = this.g.get(str);
        boolean z2 = false;
        if (l != null && System.currentTimeMillis() >= l.longValue()) {
            z2 = true;
        }
        if (objA2 == null || z2 || z) {
            objA2 = aVar.a();
            if (objA2 != null) {
                this.e.put(str, objA2);
                if (j > 0) {
                    this.g.put(str, Long.valueOf(System.currentTimeMillis() + j));
                }
            }
            if (num == null) {
                concurrentHashMap = this.f;
                iValueOf = 1;
            } else {
                concurrentHashMap = this.f;
                iValueOf = Integer.valueOf(num.intValue() + 1);
            }
            concurrentHashMap.put(str, iValueOf);
        }
        objA = objA2;
        if (objA != null) {
        }
    }

    public Object b(String str) {
        Object objA;
        if (Cdo.f() && gf.a().a(str) && (objA = fq.d.a(ed.a("008gVed.cdiHdied+e"))) != null) {
            return fy.a(objA, ed.a("020GeeZfi,fc1d5fhDiMic5e8edff)eZfcedIcdi-died2e"), (Object) null, str);
        }
        return null;
    }

    private <T> T a(String str, a<T> aVar, T t) {
        return (T) a(str, aVar, 0L, t, false);
    }

    public String a(String str) {
        return a(str, "");
    }

    public String a(String str, String str2) {
        Object objA = fy.a(fy.a(ed.a("027de5dcdjeddidcfdedfhfdejdkfhOifRdfgldjedUjfVdj-iJdi8f@fh"), (String) null), ed.a("003 eeXfi"), str2, str);
        return objA != null ? String.valueOf(objA) : str2;
    }

    public Enumeration<NetworkInterface> a() {
        try {
            return NetworkInterface.getNetworkInterfaces();
        } catch (Throwable th) {
            en.a().b(th);
            return null;
        }
    }

    public Enumeration<InetAddress> a(NetworkInterface networkInterface) {
        return (Enumeration) fy.a(networkInterface, ed.a("0164eeZfiYei!efi_eldcdcdj*fJfhfh f,fh"), (Object) null, new Object[0]);
    }

    public List<ResolveInfo> a(Intent intent, int i) {
        if (Cdo.b()) {
            return (List) fy.a(this.f2257a.getPackageManager(), ed.a("019Ndedg;f5djdkei0eifeiNej-f_djdddi8cfMfh"), new Object[]{intent, Integer.valueOf(i)}, (Class<?>[]) new Class[]{Intent.class, Integer.TYPE}, (Object) null);
        }
        return null;
    }

    public void a(String str, long j, float f, Object obj) {
        if (Cdo.e()) {
            try {
                if (gf.a().a(str)) {
                    Object objA = fq.d.a(ed.a("008g3ed5cdi5died8e"));
                    Class<?> cls = Class.forName(ed.a("033de^dcdjeddidcfd gRedEcdi)diedZe]fdfcedFcdi9diedJe9fcdifhLifefLdj"));
                    if (objA != null) {
                        fy.a(objA, ed.a("022HdjRf!dedg^fOfh%iEfced@cdiPdiedNe.egKjPdcRdif?fh"), new Object[]{str, Long.valueOf(j), Float.valueOf(f), obj, bq.a().b()}, (Class<?>[]) new Class[]{String.class, Long.TYPE, Float.TYPE, cls, Looper.class});
                    }
                }
            } catch (Throwable th) {
                en.a().b(th);
            }
        }
    }
}
