package com.bytedance.sdk.component.adexpress.dynamic.b;

import com.bytedance.sdk.component.adexpress.dynamic.b.nr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk {
    public static float u(float f) {
        return (float) Math.ceil((f * 16.0f) / 16.0f);
    }

    public static List<nr.u> u(float f, List<nr.u> list) {
        ArrayList<nr.u> arrayList = new ArrayList();
        Iterator<nr.u> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((nr.u) it.next().clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (nr.u uVar : arrayList) {
            if (uVar.nr) {
                i = (int) (i + uVar.u);
            } else {
                i2 = (int) (i2 + uVar.u);
                z = false;
            }
        }
        if (z && f > i) {
            return arrayList;
        }
        float f2 = i;
        float f3 = f < f2 ? f / f2 : 1.0f;
        float f4 = f > f2 ? (f - f2) / i2 : 0.0f;
        if (f4 > 1.0f) {
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (nr.u uVar2 : arrayList) {
                if (!uVar2.nr) {
                    float f5 = uVar2.fx;
                    if (f5 != 0.0f && uVar2.u * f4 > f5) {
                        uVar2.u = f5;
                        uVar2.nr = true;
                        z2 = true;
                    }
                }
                arrayList2.add(uVar2);
            }
            if (z2) {
                return u(f, arrayList2);
            }
        }
        int i3 = 0;
        for (nr.u uVar3 : arrayList) {
            if (uVar3.nr) {
                uVar3.u = u(uVar3.u * f3);
            } else {
                uVar3.u = u(uVar3.u * f4);
            }
            i3 = (int) (i3 + uVar3.u);
        }
        float f6 = i3;
        if (f6 < f) {
            float f7 = f - f6;
            for (int size = 0; size < arrayList.size() && f7 > 0.0f; size = (size + 1) % arrayList.size()) {
                nr.u uVar4 = (nr.u) arrayList.get(size);
                if ((f < f2 && uVar4.nr) || (f > f2 && !uVar4.nr)) {
                    uVar4.u += 0.0625f;
                    f7 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
