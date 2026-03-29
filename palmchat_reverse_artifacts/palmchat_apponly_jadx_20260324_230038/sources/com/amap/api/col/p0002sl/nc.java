package com.amap.api.col.p0002sl;

import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class nc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<Long, nd> f3027a = new HashMap<>();
    private long b = 0;

    private static long a(int i, int i2) {
        return (((long) i2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) | ((((long) i) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32);
    }

    public final long a(nd ndVar) {
        int iA;
        int iB;
        long jA;
        if (ndVar == null || !ndVar.p) {
            return 0L;
        }
        HashMap<Long, nd> map = this.f3027a;
        int i = ndVar.k;
        if (i == 1) {
            iA = ndVar.a();
            iB = ndVar.b();
            jA = a(iA, iB);
        } else if (i != 2) {
            if (i != 3 && i != 4) {
                jA = 0;
            }
            iA = ndVar.a();
            iB = ndVar.b();
            jA = a(iA, iB);
        } else {
            iA = ndVar.c();
            iB = ndVar.d();
            jA = a(iA, iB);
        }
        nd ndVar2 = map.get(Long.valueOf(jA));
        if (ndVar2 == null) {
            ndVar.m = np.b();
            map.put(Long.valueOf(jA), ndVar);
            return 0L;
        }
        if (ndVar2.e() != ndVar.e()) {
            ndVar.m = np.b();
            map.put(Long.valueOf(jA), ndVar);
            return 0L;
        }
        ndVar.m = ndVar2.m;
        map.put(Long.valueOf(jA), ndVar);
        return (np.b() - ndVar2.m) / 1000;
    }

    public final void a() {
        this.f3027a.clear();
        this.b = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        if (r13 != 4) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
    
        if (r12 != 4) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0065 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(ArrayList<? extends nd> arrayList) {
        int iA;
        int iB;
        int i;
        int i2;
        nd ndVar;
        if (arrayList != null) {
            long jB = np.b();
            long j = this.b;
            long jA = 0;
            if (j <= 0 || jB - j >= 60000) {
                HashMap<Long, nd> map = this.f3027a;
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    nd ndVar2 = arrayList.get(i3);
                    if (ndVar2.p) {
                        int i4 = ndVar2.k;
                        if (i4 == 1) {
                            i = ndVar2.c;
                            i2 = ndVar2.d;
                            jA = a(i, i2);
                            ndVar = map.get(Long.valueOf(jA));
                            if (ndVar != null) {
                                if (ndVar.e() == ndVar2.e()) {
                                    ndVar2.m = ndVar.m;
                                } else {
                                    ndVar2.m = jB;
                                }
                            }
                        } else if (i4 != 2) {
                            if (i4 != 3) {
                            }
                            i = ndVar2.c;
                            i2 = ndVar2.d;
                            jA = a(i, i2);
                            ndVar = map.get(Long.valueOf(jA));
                            if (ndVar != null) {
                            }
                        } else {
                            i = ndVar2.h;
                            i2 = ndVar2.i;
                            jA = a(i, i2);
                            ndVar = map.get(Long.valueOf(jA));
                            if (ndVar != null) {
                            }
                        }
                    }
                }
                map.clear();
                int size2 = arrayList.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    nd ndVar3 = arrayList.get(i5);
                    if (ndVar3.p) {
                        int i6 = ndVar3.k;
                        if (i6 == 1) {
                            iA = ndVar3.a();
                            iB = ndVar3.b();
                            jA = a(iA, iB);
                            map.put(Long.valueOf(jA), ndVar3);
                        } else if (i6 != 2) {
                            if (i6 != 3) {
                            }
                            iA = ndVar3.a();
                            iB = ndVar3.b();
                            jA = a(iA, iB);
                            map.put(Long.valueOf(jA), ndVar3);
                        } else {
                            iA = ndVar3.c();
                            iB = ndVar3.d();
                            jA = a(iA, iB);
                            map.put(Long.valueOf(jA), ndVar3);
                        }
                    }
                }
                this.b = jB;
            }
        }
    }
}
