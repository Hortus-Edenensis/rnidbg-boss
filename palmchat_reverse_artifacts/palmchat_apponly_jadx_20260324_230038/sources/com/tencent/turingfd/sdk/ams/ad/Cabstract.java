package com.tencent.turingfd.sdk.ams.ad;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.abstract, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cabstract {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, Long> f10749a = new HashMap();
    public Map<Integer, Long> b = new HashMap();

    public void a(int i, long j) {
        this.f10749a.put(Integer.valueOf(i), Long.valueOf(j));
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = this.f10749a.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(iIntValue);
            sb.append("_");
            sb.append(this.f10749a.get(Integer.valueOf(iIntValue)));
        }
        Iterator<Integer> it2 = this.b.keySet().iterator();
        while (it2.hasNext()) {
            int iIntValue2 = it2.next().intValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append('s');
            sb.append(iIntValue2);
            sb.append("_");
            sb.append(this.b.get(Integer.valueOf(iIntValue2)));
        }
        return sb.toString();
    }
}
