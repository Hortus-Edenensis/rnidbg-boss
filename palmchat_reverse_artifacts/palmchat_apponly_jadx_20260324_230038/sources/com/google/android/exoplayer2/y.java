package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.y;
import defpackage.g86;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class y implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6047a = g86.w0(0);
    public static final f.a<y> b = new f.a() { // from class: ct4
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return y.b(bundle);
        }
    };

    public static y b(Bundle bundle) {
        int i = bundle.getInt(f6047a, -1);
        if (i == 0) {
            return (y) n.g.fromBundle(bundle);
        }
        if (i == 1) {
            return (y) t.e.fromBundle(bundle);
        }
        if (i == 2) {
            return (y) b0.g.fromBundle(bundle);
        }
        if (i == 3) {
            return (y) d0.g.fromBundle(bundle);
        }
        throw new IllegalArgumentException("Unknown RatingType: " + i);
    }
}
