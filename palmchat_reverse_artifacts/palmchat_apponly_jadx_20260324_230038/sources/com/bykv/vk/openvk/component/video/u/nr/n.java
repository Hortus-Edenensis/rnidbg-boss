package com.bykv.vk.openvk.component.video.u.nr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n {
    private final int b;
    private final ArrayList<u> fx;
    private int iz;
    private int pn = -1;
    private final int x;
    private static final Set<String> u = new HashSet();
    private static final Set<String> nr = new HashSet();

    /* JADX INFO: compiled from: SearchBox */
    public class u {
        int nr;
        final String u;

        public u(String str) {
            this.u = str;
        }

        public void nr() {
            n.nr.add(this.u);
        }

        public String toString() {
            return this.u;
        }

        public void u() {
            n.u.add(this.u);
        }
    }

    public n(List<String> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.b = size;
        this.fx = new ArrayList<>(size);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            u uVar = new u(str);
            if (u.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(uVar);
            } else if (nr.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(uVar);
            } else {
                this.fx.add(uVar);
            }
        }
        if (arrayList != null) {
            this.fx.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.fx.addAll(arrayList2);
        }
        Integer num = b.b;
        this.x = (num == null || num.intValue() <= 0) ? this.b >= 2 ? 1 : 2 : num.intValue();
    }

    public u nr() {
        if (!u()) {
            throw new NoSuchElementException();
        }
        int i = this.pn + 1;
        if (i >= this.b - 1) {
            this.pn = -1;
            this.iz++;
        } else {
            this.pn = i;
        }
        u uVar = this.fx.get(i);
        uVar.nr = (this.iz * this.b) + this.pn;
        return uVar;
    }

    public boolean u() {
        return this.iz < this.x;
    }
}
