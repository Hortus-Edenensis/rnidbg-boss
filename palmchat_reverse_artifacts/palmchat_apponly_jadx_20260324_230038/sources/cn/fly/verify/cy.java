package cn.fly.verify;

import android.database.ContentObserver;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cy extends ContentObserver implements dg<cy> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private da f2168a;

    public cy() {
        super(null);
    }

    public void a(da daVar) {
        this.f2168a = daVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f2168a != null) {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(Boolean.valueOf(z));
            this.f2168a.a("onChange", arrayList);
        }
    }

    @Override // cn.fly.verify.dg
    public boolean a(cy cyVar, Class<cy> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        Object obj;
        if (!"setHandler".equals(str) || objArr.length != 1 || (obj = objArr[0]) == null || !(obj instanceof da)) {
            return false;
        }
        cyVar.a((da) obj);
        return true;
    }
}
