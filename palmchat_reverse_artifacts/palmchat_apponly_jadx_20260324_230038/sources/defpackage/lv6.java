package defpackage;

import android.text.TextUtils;
import com.apm.lite.nativecrash.NativeImpl;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.analytics.pro.f;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class lv6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f19087a;

    public lv6(File file) {
        String nativeCrashHeader;
        File fileM = wi7.m(file);
        if (!fileM.exists() || fileM.length() == 0 || (nativeCrashHeader = NativeImpl.getNativeCrashHeader(fileM.getAbsolutePath())) == null) {
            return;
        }
        String[] strArrSplit = nativeCrashHeader.split("\n");
        this.f19087a = new HashMap();
        for (String str : strArrSplit) {
            String[] strArrSplit2 = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (strArrSplit2.length == 2) {
                this.f19087a.put(strArrSplit2[0], strArrSplit2[1]);
            }
        }
    }

    public boolean a() {
        Map<String, String> map = this.f19087a;
        return (map == null || map.isEmpty() || TextUtils.isEmpty(this.f19087a.get(ContentProviderManager.PLUGIN_PROCESS_NAME)) || TextUtils.isEmpty(this.f19087a.get("crash_thread_name")) || TextUtils.isEmpty(this.f19087a.get("pid")) || TextUtils.isEmpty(this.f19087a.get("tid")) || TextUtils.isEmpty(this.f19087a.get(f.p)) || TextUtils.isEmpty(this.f19087a.get("crash_time")) || TextUtils.isEmpty(this.f19087a.get("signal_line"))) ? false : true;
    }

    public String b() {
        return this.f19087a.get("signal_line");
    }

    public Map<String, String> c() {
        return this.f19087a;
    }
}
