package com.opos.exoplayer.core.extractor.ts;

import android.util.SparseArray;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.ts.s;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class DefaultTsPayloadReaderFactory implements s.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8220a;
    private final List<Format> b;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    @Override // com.opos.exoplayer.core.extractor.ts.s.c
    public SparseArray<s> a() {
        return new SparseArray<>();
    }

    public DefaultTsPayloadReaderFactory(int i) {
        this(i, Collections.emptyList());
    }

    @Override // com.opos.exoplayer.core.extractor.ts.s.c
    public s a(int i, s.b bVar) {
        if (i == 2) {
            return new n(new h());
        }
        if (i == 3 || i == 4) {
            return new n(new m(bVar.b));
        }
        if (i == 15) {
            if (a(2)) {
                return null;
            }
            return new n(new d(false, bVar.b));
        }
        if (i == 17) {
            if (a(2)) {
                return null;
            }
            return new n(new l(bVar.b));
        }
        if (i == 21) {
            return new n(new k());
        }
        if (i == 27) {
            if (a(4)) {
                return null;
            }
            return new n(new i(a(bVar), a(1), a(8)));
        }
        if (i == 36) {
            return new n(new j(a(bVar)));
        }
        if (i == 89) {
            return new n(new f(bVar.c));
        }
        if (i != 138) {
            if (i != 129) {
                if (i != 130) {
                    if (i == 134) {
                        if (a(16)) {
                            return null;
                        }
                        return new q(new r());
                    }
                    if (i != 135) {
                        return null;
                    }
                }
            }
            return new n(new b(bVar.b));
        }
        return new n(new e(bVar.b));
    }

    public DefaultTsPayloadReaderFactory(int i, List<Format> list) {
        this.f8220a = i;
        if (!a(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.a(null, "application/cea-608", 0, null));
        }
        this.b = list;
    }

    private u a(s.b bVar) {
        String str;
        int i;
        if (a(32)) {
            return new u(this.b);
        }
        com.opos.exoplayer.core.util.p pVar = new com.opos.exoplayer.core.util.p(bVar.d);
        List<Format> arrayList = this.b;
        while (pVar.b() > 0) {
            int iG = pVar.g();
            int iD = pVar.d() + pVar.g();
            if (iG == 134) {
                arrayList = new ArrayList<>();
                int iG2 = pVar.g() & 31;
                for (int i2 = 0; i2 < iG2; i2++) {
                    String strE = pVar.e(3);
                    int iG3 = pVar.g();
                    if ((iG3 & 128) != 0) {
                        i = iG3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    arrayList.add(Format.a((String) null, str, (String) null, -1, 0, strE, i, (DrmInitData) null));
                    pVar.d(2);
                }
            }
            pVar.c(iD);
        }
        return new u(arrayList);
    }

    private boolean a(int i) {
        return (i & this.f8220a) != 0;
    }
}
