package com.oplus.tblplayer.logger;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultLoggerAdapter implements ILoggerAdapter {
    public static final int LOG_LEVEL_ALL = Integer.MIN_VALUE;
    public static final int LOG_LEVEL_ERROR = 6;
    public static final int LOG_LEVEL_INFO = 4;
    public static final int LOG_LEVEL_OFF = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_WARNING = 5;
    private int logLevel;

    public DefaultLoggerAdapter() {
        this(Integer.MIN_VALUE);
    }

    @Override // com.oplus.tblplayer.logger.ILoggerAdapter
    public boolean isLoggable(int i) {
        return i >= this.logLevel;
    }

    @Override // com.oplus.tblplayer.logger.ILoggerAdapter
    public int println(int i, @Nullable String str, @NonNull String str2) {
        return Log.println(i, str, str2);
    }

    public void setLogLevel(int i) {
        this.logLevel = i;
    }

    public DefaultLoggerAdapter(int i) {
        this.logLevel = i;
    }
}
