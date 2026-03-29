package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import java.util.ArrayList;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class t1 extends pblx {
    public SDKMonitor b;

    /* JADX INFO: compiled from: SearchBox */
    public class pgla implements SDKMonitor.IGetExtendParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f19351a;
        public final /* synthetic */ String b;

        public pgla(JSONObject jSONObject, String str) {
            this.f19351a = jSONObject;
            this.b = str;
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblx
    public final void c(long j, long j2, String str, String str2, int i) {
        SDKMonitor sDKMonitor = this.b;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorApiError(j, j2, str, (String) null, str2, i, (JSONObject) null);
    }

    @Override // ms.bz.bd.c.Pgl.pblx
    public final void e(long j, long j2, String str, String str2, int i) {
        SDKMonitor sDKMonitor = this.b;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorSLA(j, j2, str, (String) null, str2, i, (JSONObject) null);
    }

    @Override // ms.bz.bd.c.Pgl.pblx
    public final void f(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "91e369", new byte[]{27, Utf8.REPLACEMENT_BYTE, 23, 85, dn.k, 47, 40, 53, 34, 102, 38, 39, 58, 72, dn.l, 3, 59, 30, 53, 100, 45, 33, 86, 84, 12, 60, 44, 25, 55, 102, 38, 50, 27, 66, 73, 99, 119, 93, 116});
        if (this.b == null) {
            return;
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d55e65", new byte[]{102, 50, 84, 7, 0, 33, 98, 26, 101, 56, 112}), str);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e9520b", new byte[]{119, 58, 82, 67, 8, 122, 116, 1}), jSONObject);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "890dc7", new byte[]{36, 62, 87, 2, 85, 35}), jSONObject2);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "08b402", new byte[]{45, 53, 22, 101, 23, 49, 33}), jSONObject3);
            com.bytedance.sdk.component.utils.k.nr((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "00f8ba", new byte[]{12, 23, 33, 109, 110, 83, 16}), jSONObject4.toString());
        } catch (JSONException unused) {
        }
        if (jSONObject.length() > 0 || jSONObject2.length() > 0) {
            this.b.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblx
    public final boolean h(String str) {
        JSONObject jSONObject;
        String str2;
        String string;
        Context contextA = pblw.b().a();
        String string2 = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d0769b", new byte[]{102, 55, 73});
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return false;
        }
        try {
            string = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3c7d07", new byte[]{49, 101, 79, 47, dn.l, 41, 52}));
        } catch (JSONException unused2) {
            str2 = null;
        }
        try {
            string2 = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bdf0ec", new byte[]{123, 105, 6, 80, 101, 117, 104, 65}));
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7b5b59", new byte[]{37, 111, 72, 16, 3, 41, 1, 113, 72, 33}));
            JSONArray jSONArray2 = jSONObject.getJSONArray((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "21c17b", new byte[]{49, 54, 0, 74, 26, 97, 4, 34, 30, 114}));
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                arrayList2.add(jSONArray2.getString(i2));
            }
            if (arrayList.size() <= 0 || arrayList2.size() <= 0) {
                return false;
            }
            SDKMonitorUtils.setConfigUrl(string, arrayList);
            SDKMonitorUtils.setDefaultReportUrl(string, arrayList2);
        } catch (JSONException unused3) {
            str2 = string2;
            string2 = string;
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c6f1ab", new byte[]{97, 49, 24, 122, 87});
            string = string2;
            string2 = str2;
        }
        jSONObject.remove((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d724a4", new byte[]{118, 58, 79, 70, 87, 36, 82, 36, 79, 119}));
        jSONObject.remove((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "89d32d", new byte[]{59, 62, 7, 72, TELogUtils.DEBUG_LEVEL_V, 103, dn.l, 42, 25, 112}));
        SDKMonitorUtils.initMonitor(contextA, string, jSONObject, new pgla(jSONObject, string2));
        this.b = SDKMonitorUtils.getInstance(string);
        return true;
    }
}
