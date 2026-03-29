package cn.fly.verify;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class db implements dg<db> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private da f2173a;

    private ConnectivityManager.NetworkCallback a() {
        return new ConnectivityManager.NetworkCallback() { // from class: cn.fly.verify.db.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                ArrayList<Object> arrayList = new ArrayList<>();
                arrayList.add(network);
                db.this.f2173a.a(dx.a("011[cb@c<cjbb!b5bgMeb7dc8ed"), arrayList);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                super.onLost(network);
                ArrayList<Object> arrayList = new ArrayList<>();
                arrayList.add(network);
                db.this.f2173a.a(dx.a("006QcbYcSdacbdf g"), arrayList);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                super.onUnavailable();
            }
        };
    }

    public void a(da daVar) {
        this.f2173a = daVar;
    }

    @Override // cn.fly.verify.dg
    public boolean a(db dbVar, Class<db> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        Object obj;
        if ("setHandler".equals(str) && objArr.length == 1 && (obj = objArr[0]) != null && (obj instanceof da)) {
            dbVar.a((da) obj);
        } else {
            if (!dx.a("019Tbg5cYbgXgAcf dgJddcbbhbjeiMbee[dc:ba>bj").equals(str) || objArr.length != 0) {
                return false;
            }
            objArr2[0] = dbVar.a();
        }
        return true;
    }
}
