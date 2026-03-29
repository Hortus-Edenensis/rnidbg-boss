package com.baidu.platform.comapi.b;

import android.util.Log;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comapi.util.NetworkUtil;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.base.networkdetect.NANetworkDetect;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NANetworkDetect f4105a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a("netchanged");
        }
    }

    /* JADX INFO: renamed from: com.baidu.platform.comapi.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0102b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f4107a = new b(null);
    }

    public /* synthetic */ b(com.baidu.platform.comapi.b.a aVar) {
        this();
    }

    public void b(String str) {
        Log.d("NetworkLogic", "onNetWorkChanged-" + str);
        SysOSUtil.getInstance().getNetType();
        if (str == null || str.equals(SysOSUtil.getInstance().getNetType())) {
            return;
        }
        MapTaskManager.getSingleThreadPool().submit(new a());
    }

    private b() {
    }

    public static b a() {
        return C0102b.f4107a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (e.b() <= 0) {
            return;
        }
        Log.d("NetworkLogic", "NetworkDetect");
        if (this.f4105a == null) {
            this.f4105a = new NANetworkDetect();
        }
        String currentNetMode = NetworkUtil.getCurrentNetMode(JNIInitializer.getCachedContext());
        SysOSUtil.getInstance().updateNetType(currentNetMode);
        if (this.f4105a != null) {
            try {
                JsonBuilder jsonBuilder = new JsonBuilder();
                jsonBuilder.object();
                try {
                    jsonBuilder.key("nettype").value(Integer.parseInt(currentNetMode));
                } catch (NumberFormatException unused) {
                    jsonBuilder.key("nettype").value(-1);
                }
                jsonBuilder.key("telecomtype").value(NetworkUtil.getNetworkOperatorType(JNIInitializer.getCachedContext()));
                jsonBuilder.key("triggerType").value(str);
                jsonBuilder.endObject();
                this.f4105a.a(jsonBuilder.toString());
            } catch (Exception unused2) {
            }
        }
    }
}
