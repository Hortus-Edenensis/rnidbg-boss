package com.opos.exoplayer.core.text.a;

import android.text.Layout;
import androidx.annotation.NonNull;
import com.opos.exoplayer.core.text.Cue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class d extends Cue implements Comparable<d> {
    public final int m;

    public d(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4, int i5) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3, z, i4);
        this.m = i5;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull d dVar) {
        int i = dVar.m;
        int i2 = this.m;
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }
}
