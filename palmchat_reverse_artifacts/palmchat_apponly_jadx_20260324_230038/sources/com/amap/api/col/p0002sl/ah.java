package com.amap.api.col.p0002sl;

import android.os.RemoteException;
import com.amap.api.interfaces.IAMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface ah extends IAMap {
    bi a();

    void a(double d, double d2, ab abVar);

    void a(double d, double d2, an anVar);

    void a(int i, int i2);

    void a(int i, int i2, ab abVar);

    void b(double d, double d2, an anVar);

    void b(int i, int i2, ab abVar);

    bq c() throws RemoteException;

    void postInvalidate();
}
