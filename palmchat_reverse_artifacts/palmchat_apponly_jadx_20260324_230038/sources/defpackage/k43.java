package defpackage;

import com.oplus.tbl.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class k43 {
    @Deprecated
    public static long a(LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i, long j, IOException iOException, int i2) {
        throw new UnsupportedOperationException();
    }

    public static long b(LoadErrorHandlingPolicy loadErrorHandlingPolicy, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        return loadErrorHandlingPolicy.getBlacklistDurationMsFor(loadErrorInfo.mediaLoadData.dataType, loadErrorInfo.loadEventInfo.loadDurationMs, loadErrorInfo.exception, loadErrorInfo.errorCount);
    }

    @Deprecated
    public static long c(LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i, long j, IOException iOException, int i2) {
        throw new UnsupportedOperationException();
    }

    public static long d(LoadErrorHandlingPolicy loadErrorHandlingPolicy, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        return loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo.mediaLoadData.dataType, loadErrorInfo.loadEventInfo.loadDurationMs, loadErrorInfo.exception, loadErrorInfo.errorCount);
    }

    public static void e(LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j) {
    }
}
