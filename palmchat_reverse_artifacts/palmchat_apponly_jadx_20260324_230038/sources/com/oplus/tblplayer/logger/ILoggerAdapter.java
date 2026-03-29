package com.oplus.tblplayer.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface ILoggerAdapter {
    boolean isLoggable(int i);

    int println(int i, @Nullable String str, @NonNull String str2);
}
