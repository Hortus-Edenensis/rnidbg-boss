package com.zenmen.palmchat.voiceroom.adapter;

import android.content.Context;
import defpackage.am2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RcySAdapter<T, VH extends am2> extends RcyAdapter<T, VH> {
    public int i;

    public RcySAdapter(Context context, int i) {
        super(context, i);
        this.i = i;
    }

    @Override // com.zenmen.palmchat.voiceroom.adapter.RcyAdapter
    public void a(VH vh, T t, int i, int i2) {
        h(vh, t, i);
    }

    @Override // com.zenmen.palmchat.voiceroom.adapter.RcyAdapter
    public int b(T t, int i) {
        return this.i;
    }

    public abstract void h(VH vh, T t, int i);
}
