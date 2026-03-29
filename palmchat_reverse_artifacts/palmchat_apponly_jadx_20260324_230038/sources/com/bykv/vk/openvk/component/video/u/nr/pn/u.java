package com.bykv.vk.openvk.component.video.u.nr.pn;

import com.bykv.vk.openvk.component.video.u.nr.iz;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class u {
    pn nr;
    List<iz.nr> u;

    public abstract InputStream b();

    public abstract List<iz.nr> fx();

    public abstract boolean nr();

    public pn pn() {
        return this.nr;
    }

    public abstract int u();

    public iz.nr u(String str) {
        List<iz.nr> list;
        if (str != null && (list = this.u) != null && list.size() > 0) {
            for (iz.nr nrVar : this.u) {
                if (str.equals(nrVar.u)) {
                    return nrVar;
                }
            }
        }
        return null;
    }

    public abstract String u(String str, String str2);
}
