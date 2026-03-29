package com.tide.host.a;

import com.tide.protocol.config.TideWholeConfig;
import com.tide.protocol.report.IFdaReporter;
import com.tide.protocol.report.ITideReporter;
import com.tide.protocol.util.TdLogUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class e0 implements ITideReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile e0 f10787a;

    public static e0 a() {
        if (f10787a == null) {
            synchronized (e0.class) {
                if (f10787a == null) {
                    f10787a = new e0();
                }
            }
        }
        return f10787a;
    }

    @Override // com.tide.protocol.report.ITideReporter
    public final void onEvent(String str, String str2) {
        onEvent(str, str2, new HashMap());
    }

    @Override // com.tide.protocol.report.ITideReporter
    public final void onEvent(String str, String str2, Map map) {
        try {
            IFdaReporter reporter = TideWholeConfig.getInstance().getReporter(str2);
            if (map != null) {
                TdLogUtils.log("TdDataReporter", "report onEvent eventId=" + str + ", reportInfo=" + map.toString());
                if (reporter != null) {
                    reporter.onEvent(str, (Map<String, Object>) map);
                }
            } else {
                TdLogUtils.log("TdDataReporter", "report onEvent eventId=" + str + ", reportInfo=");
                if (reporter != null) {
                    reporter.onEvent(str);
                }
            }
        } catch (Throwable th) {
            TdLogUtils.error("TdDataReporter", "onEvent map error " + th.getMessage());
        }
    }

    @Override // com.tide.protocol.report.ITideReporter
    public final void onEvent(String str, String str2, JSONObject jSONObject) {
        try {
            IFdaReporter reporter = TideWholeConfig.getInstance().getReporter(str2);
            if (jSONObject != null) {
                TdLogUtils.log("TdDataReporter", "report onEvent eventId=" + str + ", reportInfo=" + jSONObject.toString());
                if (reporter != null) {
                    reporter.onEvent(str, jSONObject);
                }
            } else {
                TdLogUtils.log("TdDataReporter", "report onEvent eventId=" + str + ", reportInfo=");
                if (reporter != null) {
                    reporter.onEvent(str);
                }
            }
        } catch (Throwable th) {
            TdLogUtils.error("TdDataReporter", "onEvent json error " + th.getMessage());
        }
    }
}
