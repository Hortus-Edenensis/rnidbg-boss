package com.amap.api.col.p0002sl;

import java.util.ArrayList;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class ca extends bx<cb> {
    /* JADX WARN: Removed duplicated region for block: B:35:0x0046 A[EDGE_INSN: B:35:0x0046->B:24:0x0046 BREAK  A[LOOP:0: B:12:0x0016->B:23:0x0043], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0043 A[SYNTHETIC] */
    @Override // com.amap.api.col.p0002sl.bx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized ArrayList<cb> a(int i, boolean z) {
        LinkedList<T> linkedList = this.f2663a;
        if (linkedList == 0) {
            return null;
        }
        try {
            int size = linkedList.size();
            if (size <= 0) {
                i = size;
            }
            ArrayList<cb> arrayList = new ArrayList<>(i);
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                cb cbVar = (cb) this.f2663a.get(i2);
                if (cbVar != null) {
                    int i4 = cbVar.f2667a;
                    if (z) {
                        if (i4 == 0) {
                            arrayList.add(cbVar);
                            this.f2663a.remove(i2);
                            size--;
                            i2--;
                            i3++;
                        }
                        if (i3 < i) {
                            break;
                        }
                    } else {
                        if (i4 < 0) {
                            arrayList.add(cbVar);
                            this.f2663a.remove(i2);
                            size--;
                            i2--;
                            i3++;
                        }
                        if (i3 < i) {
                        }
                    }
                }
                i2++;
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }
}
