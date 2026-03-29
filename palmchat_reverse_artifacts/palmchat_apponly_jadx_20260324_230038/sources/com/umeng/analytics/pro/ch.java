package com.umeng.analytics.pro;

import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.co;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ch<T extends ch<?, ?>, F extends co> extends Serializable {
    void clear();

    ch<T, F> deepCopy();

    F fieldForId(int i);

    void read(dg dgVar) throws cn;

    void write(dg dgVar) throws cn;
}
