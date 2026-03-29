package com.oplus.tblplayer.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class LoggerPrinter {
    private final List<ILoggerAdapter> logAdapters = new CopyOnWriteArrayList();

    public void addAdapter(@NonNull ILoggerAdapter iLoggerAdapter) {
        this.logAdapters.add((ILoggerAdapter) Utils.checkNotNull(iLoggerAdapter));
    }

    public void addAdapters(@NonNull List<ILoggerAdapter> list) {
        this.logAdapters.addAll((Collection) Utils.checkNotNull(list));
    }

    public void clearAdapters() {
        this.logAdapters.clear();
    }

    public synchronized int println(int i, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        if (th != null) {
            str2 = str2 != null ? Utils.appendThrowableString(str2, th) : Utils.getStackTraceString(th);
        }
        if (!Utils.isEmpty(str2)) {
            for (ILoggerAdapter iLoggerAdapter : this.logAdapters) {
                if (iLoggerAdapter.isLoggable(i)) {
                    iLoggerAdapter.println(i, str, str2);
                }
            }
        }
        return 0;
    }
}
