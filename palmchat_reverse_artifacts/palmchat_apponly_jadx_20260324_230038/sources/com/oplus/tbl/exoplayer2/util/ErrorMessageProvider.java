package com.oplus.tbl.exoplayer2.util;

import android.util.Pair;
import java.lang.Throwable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface ErrorMessageProvider<T extends Throwable> {
    Pair<Integer, String> getErrorMessage(T t);
}
