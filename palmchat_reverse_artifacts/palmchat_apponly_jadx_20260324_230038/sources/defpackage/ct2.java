package defpackage;

import android.util.Log;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.media.roomchatdemo.videocallgroup.userInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ct2 {
    public static ct2 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<userInfo> f16910a;
    public int b = i();

    public ct2() {
        a();
    }

    public static void b(long j, String str, int i, String str2, String str3) {
        if (c == null) {
            c = new ct2();
        }
        synchronized (c) {
            k(j);
            c.c(j, str, i, str2, str3);
            if (RTCParameters.m()) {
                Log.i("addUserInfo", "uid:" + j + " name:" + str + " icon:" + i + " iconurl:" + str2);
            }
        }
    }

    public static void e() {
        if (c == null) {
            c = new ct2();
        }
        synchronized (c) {
            c.d();
        }
    }

    public static int f(long j) {
        if (c == null) {
            c = new ct2();
        }
        synchronized (c) {
            for (userInfo userinfo : c.f16910a) {
                if (userinfo.id == j) {
                    return userinfo.icon;
                }
            }
            Log.i("InnerUserInfo", "not found uid " + j);
            return 0;
        }
    }

    public static String g(long j) {
        if (c == null) {
            c = new ct2();
        }
        synchronized (c) {
            for (userInfo userinfo : c.f16910a) {
                if (userinfo.id == j) {
                    String str = userinfo.bigurl;
                    if (str != null) {
                        return str;
                    }
                    return userinfo.iconurl;
                }
            }
            Log.i("InnerUserInfo", "not found uid " + j);
            return null;
        }
    }

    public static String h(long j) {
        if (c == null) {
            c = new ct2();
        }
        synchronized (c) {
            for (userInfo userinfo : c.f16910a) {
                if (userinfo.id == j) {
                    return userinfo.name;
                }
            }
            Log.i("InnerUserInfo", "not found uid " + j);
            return "";
        }
    }

    public static int i() {
        return new Random().nextInt(100);
    }

    public static List<userInfo> j() {
        if (c == null) {
            c = new ct2();
        }
        return c.f16910a;
    }

    public static void k(long j) {
        if (c == null) {
            c = new ct2();
        }
        for (userInfo userinfo : c.f16910a) {
            if (userinfo.id == j) {
                c.f16910a.remove(userinfo);
                return;
            }
        }
    }

    public void a() {
        this.f16910a = new ArrayList();
    }

    public final void c(long j, String str, int i, String str2, String str3) {
        userInfo userinfo = new userInfo();
        userinfo.id = j;
        userinfo.name = str;
        userinfo.icon = i;
        userinfo.iconurl = str2;
        userinfo.bigurl = str3;
        this.f16910a.add(userinfo);
    }

    public final void d() {
        this.f16910a.clear();
    }
}
