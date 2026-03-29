package com.baidu.mapsdkplatform.comapi.map;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.logstatistics.LogStatistics;
import com.baidu.platform.comapi.longlink.BNLongLink;
import com.baidu.platform.comjni.engine.NAEngine;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3982a;
    private static Context b = BMapManager.getContext();

    static {
        if (!Initializer.isInitialized()) {
            NativeLoader.getInstance().loadLibrary(com.baidu.mapapi.VersionInfo.getKitName());
        }
        if (!com.baidu.mapapi.VersionInfo.getApiVersion().equals(VersionInfo.getApiVersion())) {
            throw new BaiduMapSDKException("the version of map is not match with base");
        }
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
    }

    public static void a() {
        f3982a--;
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap destroy mRef = " + f3982a);
        }
        if (f3982a == 0) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().c();
            LogStatistics.getInstance().a();
            JNIInitializer.destroy();
        }
    }

    public static int b() {
        return f3982a;
    }

    public static void c() {
        if (f3982a == 0) {
            if (b == null) {
                Context cachedContext = JNIInitializer.getCachedContext();
                b = cachedContext;
                if (cachedContext == null) {
                    Log.e("BDMapSDK", "you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
                    return;
                }
            }
            SysOSUtil.updateCuid();
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().b();
            JNIInitializer.attach((Application) b, true, false, false, true);
            JNIInitializer.initEngine();
            JNIInitializer.initEngineResource(new AppResList());
            com.baidu.platform.comapi.util.e.a();
            BNLongLink.initLongLink();
            NAEngine.b();
            NAEngine.startRunningRequest();
            SysUpdateObservable.getInstance().addObserver(new SysUpdateUtil());
            SysUpdateObservable.getInstance().init("");
            com.baidu.platform.comapi.util.e.d();
        }
        f3982a++;
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap init mRef = " + f3982a);
        }
    }
}
