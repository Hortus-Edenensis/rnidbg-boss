package com.bytedance.sdk.component.nr.u;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class pn extends k {
    List<String> nr;
    List<String> u;

    public pn(List<String> list, List<String> list2) {
        this.u = list;
        this.nr = list2;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        private final List<String> u = new ArrayList();
        private final List<String> nr = new ArrayList();

        public u u(String str, String str2) {
            this.u.add(str);
            this.nr.add(str2);
            return this;
        }

        public pn u() {
            return new pn(this.u, this.nr);
        }
    }
}
