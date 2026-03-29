package com.opos.exoplayer.core.text.webvtt;

import android.text.SpannableStringBuilder;
import com.opos.exoplayer.core.text.Cue;
import com.opos.exoplayer.core.util.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class h implements com.opos.exoplayer.core.text.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b> f8364a;
    private final int b;
    private final long[] c;
    private final long[] d;

    public h(List<b> list) {
        this.f8364a = list;
        int size = list.size();
        this.b = size;
        this.c = new long[size * 2];
        for (int i = 0; i < this.b; i++) {
            b bVar = list.get(i);
            int i2 = i * 2;
            long[] jArr = this.c;
            jArr[i2] = bVar.m;
            jArr[i2 + 1] = bVar.n;
        }
        long[] jArr2 = this.c;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.d = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.opos.exoplayer.core.text.b
    public int a(long j) {
        int iB = y.b(this.d, j, false, false);
        if (iB < this.d.length) {
            return iB;
        }
        return -1;
    }

    @Override // com.opos.exoplayer.core.text.b
    public int b() {
        return this.d.length;
    }

    @Override // com.opos.exoplayer.core.text.b
    public long a(int i) {
        com.opos.exoplayer.core.util.a.a(i >= 0);
        com.opos.exoplayer.core.util.a.a(i < this.d.length);
        return this.d[i];
    }

    @Override // com.opos.exoplayer.core.text.b
    public List<Cue> b(long j) {
        SpannableStringBuilder spannableStringBuilderAppend;
        SpannableStringBuilder spannableStringBuilder = null;
        b bVar = null;
        ArrayList arrayList = null;
        for (int i = 0; i < this.b; i++) {
            long[] jArr = this.c;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                b bVar2 = this.f8364a.get(i);
                if (!bVar2.a()) {
                    arrayList.add(bVar2);
                } else if (bVar == null) {
                    bVar = bVar2;
                } else {
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilderAppend = spannableStringBuilder.append(bVar.f8314a).append((CharSequence) "\n");
                    } else {
                        spannableStringBuilderAppend = spannableStringBuilder.append((CharSequence) "\n");
                    }
                    spannableStringBuilderAppend.append(bVar2.f8314a);
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new b(spannableStringBuilder));
        } else if (bVar != null) {
            arrayList.add(bVar);
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }
}
