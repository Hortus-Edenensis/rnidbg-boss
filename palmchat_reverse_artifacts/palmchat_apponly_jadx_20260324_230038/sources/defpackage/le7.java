package defpackage;

import android.content.Context;
import com.apm.lite.ICommonParams;
import com.apm.lite.MonitorCrash;
import com.apm.lite.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class le7 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements ICommonParams {
        @Override // com.apm.lite.ICommonParams
        public Map<String, Object> getCommonParams() {
            return new HashMap();
        }

        @Override // com.apm.lite.ICommonParams
        public String getDeviceId() {
            MonitorCrash monitorCrash = (MonitorCrash) b.b();
            return monitorCrash != null ? monitorCrash.config().getDeviceId() : "";
        }

        @Override // com.apm.lite.ICommonParams
        public List<String> getPatchInfo() {
            return null;
        }

        @Override // com.apm.lite.ICommonParams
        public Map<String, Integer> getPluginInfo() {
            return null;
        }

        @Override // com.apm.lite.ICommonParams
        public String getSessionId() {
            return null;
        }

        @Override // com.apm.lite.ICommonParams
        public long getUserId() {
            return 0L;
        }
    }

    public static a87 a(Context context) {
        return new a87(context, new a());
    }
}
