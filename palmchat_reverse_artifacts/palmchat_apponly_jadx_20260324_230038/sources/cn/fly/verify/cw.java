package cn.fly.verify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cw extends BroadcastReceiver implements dg<cw> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private da f2167a;

    public void a(da daVar) {
        this.f2167a = daVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f2167a != null) {
            try {
                ArrayList<Object> arrayList = new ArrayList<>(1);
                arrayList.add(intent);
                this.f2167a.a("onReceive", arrayList);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // cn.fly.verify.dg
    public boolean a(cw cwVar, Class<cw> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        Object obj;
        if (!"setHandler".equals(str) || objArr.length != 1 || (obj = objArr[0]) == null || !(obj instanceof da)) {
            return false;
        }
        cwVar.a((da) obj);
        return true;
    }
}
