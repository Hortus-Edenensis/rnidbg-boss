package cn.fly.verify;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import cn.fly.verify.fq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static fx f2375a;
    private Context b;
    private BroadcastReceiver c;
    private String d;
    private Integer e;

    private fx(Context context) {
        this.b = context;
        c();
    }

    public static fx a(Context context) {
        if (f2375a == null) {
            synchronized (fx.class) {
                if (f2375a == null) {
                    f2375a = new fx(context);
                }
            }
        }
        return f2375a;
    }

    @SuppressLint({"MissingPermission"})
    private void c() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) fq.d.a("connectivity");
            if (Build.VERSION.SDK_INT >= 26 && fq.d.b(ba.a("039fg>feflgffkfehfKlh8flfhfkhjhjfkgf$gQhfgnimimijglglfjgjijgmigiiikkefjglgmgngmij"))) {
                connectivityManager.registerDefaultNetworkCallback(d());
            } else if (fq.d.b(ba.a("039fg*feflgffkfehf1lh+flfhfkhjhjfkgf4g(hfgnimimijglglfjgjijgmigiiikkefjglgmgngmij"))) {
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), d());
            } else {
                g();
            }
        } catch (Throwable th) {
            en.a().a(th);
        }
    }

    @TargetApi(21)
    private ConnectivityManager.NetworkCallback d() {
        return new ConnectivityManager.NetworkCallback() { // from class: cn.fly.verify.fx.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                fx.this.e();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                super.onCapabilitiesChanged(network, networkCapabilities);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                super.onLinkPropertiesChanged(network, linkProperties);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLosing(Network network, int i) {
                super.onLosing(network, i);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                super.onLost(network);
                fx.this.e();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                super.onUnavailable();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.d = h();
        this.e = Integer.valueOf(f());
    }

    private int f() {
        if (fq.d.a("phone") != null && fq.d.b(ba.a("035fgTfeflgffkfehf*lhWflfhfkhjhjfkgfHg?hfikijgnhmfjinhliigjijfjglgmgngmij"))) {
            return Build.VERSION.SDK_INT >= 24 ? et.a(this.b).c() : et.a(this.b).b();
        }
        return -1;
    }

    private void g() {
        this.c = new BroadcastReceiver() { // from class: cn.fly.verify.fx.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equalsIgnoreCase(ba.a("036fgTfeflgffkfehf<ghkBhf1ePgf9gg@hfimiigjgjijimgmgkilgkgmkmfjimhlgngjkfij"))) {
                        fx.this.e();
                    }
                } catch (Throwable th) {
                    en.a().a(th);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ba.a("036fg6feflgffkfehf,ghk%hfIe^gf^gg[hfimiigjgjijimgmgkilgkgmkmfjimhlgngjkfij"));
        eg.a(this.c, intentFilter);
    }

    private String h() {
        Object objA;
        NetworkInfo activeNetworkInfo;
        try {
            if (fq.d.b(ba.a("039fgWfeflgffkfehfLlh5flfhfkhjhjfkgf0gHhfgnimimijglglfjgjijgmigiiikkefjglgmgngmij")) && (objA = fq.d.a("connectivity")) != null && (activeNetworkInfo = ((ConnectivityManager) objA).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    int iB = et.a(this.b).b();
                    if (a(iB)) {
                        return ba.a("002Tjkkf");
                    }
                    if (c(iB)) {
                        return ba.a("002@jnkf");
                    }
                    return ba.a(d(iB) ? "002)lhkf" : "0029jgkf");
                }
                if (type == 1) {
                    return ba.a("004Jhhfkghfk");
                }
                switch (type) {
                    case 6:
                        return ba.a("005ShhfkfhOf*ge");
                    case 7:
                        return ba.a("009%hgCiZfiShkJgfgf5kj");
                    case 8:
                        return ba.a("005'fefifhfhfm");
                    case 9:
                        return ba.a("008hkjh)flFghk");
                    default:
                        return String.valueOf(type);
                }
            }
        } catch (Throwable th) {
            en.a().b(th);
        }
        return ba.a("004gZgf+gh");
    }

    public synchronized int b() {
        if (this.e == null) {
            this.e = Integer.valueOf(f());
        }
        return this.e.intValue();
    }

    private boolean b(int i) {
        return i == 20;
    }

    private boolean c(int i) {
        return i == 13;
    }

    private boolean d(int i) {
        switch (i) {
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            case 4:
            case 7:
            case 11:
            default:
                return false;
        }
    }

    public synchronized String a() {
        if (TextUtils.isEmpty(this.d)) {
            this.d = h();
        }
        return this.d;
    }

    private boolean b(Object obj) {
        if (obj != null && fq.d.b(ba.a("035fg;feflgffkfehf=lhGflfhfkhjhjfkgf]gYhfikijgnhmfjinhliigjijfjglgmgngmij")) && Build.VERSION.SDK_INT >= 26) {
            Object objA = az.a().i() ? fy.a(obj, ba.a("015-gg'hkYglFhWflfffk1eh>glXkfkh"), (Object) null, new Object[0]) : az.a().u();
            if (objA != null && ((Integer) fy.a(objA, ba.a("010.gg%hk4gjflgl.kfkh"), 0, new Object[0])).intValue() == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean a(int i) {
        Object objA = fq.d.a("phone");
        if (objA == null) {
            return false;
        }
        if (a(objA) || b(objA)) {
            return true;
        }
        return b(i);
    }

    private boolean a(Object obj) {
        Object objU;
        if (obj != null && fq.d.b(ba.a("035fgKfeflgffkfehfHlh(flfhfkhjhjfkgfBgShfikijgnhmfjinhliigjijfjglgmgngmij"))) {
            if (az.a().i()) {
                String strK = fq.d.k();
                objU = null;
                if (!TextUtils.isEmpty(strK) && ((strK.contains(ba.a("006j,fi;f?hh6h_fk")) || strK.contains(ba.a("006Mhlfi3fPhh=hGfk")) || strK.contains(ba.a("006Rhlgignigijgk"))) && Build.VERSION.SDK_INT >= 29)) {
                    objU = fy.a(obj, ba.a("015,ggDhkRgl:h6flfffk+eh]gl)kfkh"), (Object) null, new Object[0]);
                }
            } else {
                objU = az.a().u();
            }
            if (objU != null && ((Integer) fy.a(objU, ba.a("0161gg(hkXhlhhgj7hk;hhgfflfngmfm2lh"), 0, new Object[0])).intValue() == 20) {
                return true;
            }
        }
        return false;
    }
}
