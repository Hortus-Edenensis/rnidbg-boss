package com.zenmen.palmchat.paidservices.superexpose.bean;

import androidx.annotation.Keep;
import defpackage.by5;
import defpackage.ir5;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class GuideInfo {
    public int frequency;
    public int interval;
    public List<String> range;
    public List<Integer> when;

    public boolean isInTime() {
        List<String> list = this.range;
        if (list == null || list.size() != 2) {
            return false;
        }
        long jA = by5.a(this.range.get(0));
        long jA2 = by5.a(this.range.get(1));
        long jB = ir5.b();
        return jB > jA && jB < jA2;
    }
}
