package com.opos.exoplayer.core.source;

import com.opos.exoplayer.core.Format;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8303a;
    private final Format[] b;
    private int c;

    public o(Format... formatArr) {
        com.opos.exoplayer.core.util.a.b(formatArr.length > 0);
        this.b = formatArr;
        this.f8303a = formatArr.length;
    }

    public int a(Format format) {
        int i = 0;
        while (true) {
            Format[] formatArr = this.b;
            if (i >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i]) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.f8303a == oVar.f8303a && Arrays.equals(this.b, oVar.b);
    }

    public int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.b) + 527;
        }
        return this.c;
    }

    public Format a(int i) {
        return this.b[i];
    }
}
