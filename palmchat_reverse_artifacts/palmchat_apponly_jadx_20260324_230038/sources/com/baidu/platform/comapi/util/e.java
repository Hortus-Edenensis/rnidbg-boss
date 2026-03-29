package com.baidu.platform.comapi.util;

import android.os.Build;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.platform.comjni.map.commonmemcache.NACommonMemCache;
import com.baidu.vi.VIContext;
import com.cdo.oaps.ad.OapsWrapper;
import com.cdo.oaps.ad.wrapper.download.RedirectReqWrapper;
import com.umeng.commonsdk.statistics.AnalyticsConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static NACommonMemCache f4236a = new NACommonMemCache();

    public static void a() {
        c();
    }

    public static NACommonMemCache b() {
        return f4236a;
    }

    private static void c() {
        JsonBuilder jsonBuilder = new JsonBuilder();
        f4236a.b(SyncSysInfo.initPhoneInfo());
        d();
        jsonBuilder.reset();
        jsonBuilder.object();
        jsonBuilder.putStringValue(EngineImpl.KEY_CUID, SyncSysInfo.getCid());
        jsonBuilder.putStringValue("app", "1");
        jsonBuilder.putStringValue(OapsWrapper.KEY_PATH, VIContext.getContext().getCacheDir().getAbsolutePath() + "/");
        jsonBuilder.putStringValue("domain", "");
        jsonBuilder.endObject();
        f4236a.b("longlink", jsonBuilder.getJson());
    }

    public static void d() {
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.object();
        jsonBuilder.key("sw").value(SysOSUtil.getInstance().getScreenWidth());
        jsonBuilder.key("sh").value(SysOSUtil.getInstance().getScreenHeight());
        jsonBuilder.putStringValue("ver", "2");
        jsonBuilder.putStringValue("pd", "mapsdk");
        jsonBuilder.putStringValue("os", "android");
        jsonBuilder.putStringValue("sv", SyncSysInfo.getSoftWareVer());
        jsonBuilder.putStringValue("ov", AnalyticsConstants.SDK_TYPE + Build.VERSION.SDK_INT);
        jsonBuilder.putStringValue(EngineImpl.KEY_CUID, SyncSysInfo.getCid());
        jsonBuilder.putStringValue(RedirectReqWrapper.KEY_CHANNEL, "mapsdk");
        jsonBuilder.putStringValue("channel", "mapsdk");
        jsonBuilder.putStringValue("mb", SyncSysInfo.getPhoneType());
        jsonBuilder.putStringValue(OapsWrapper.KEY_PATH, SysOSUtil.getInstance().getExternalFilesDir());
        jsonBuilder.endObject();
        f4236a.b("logstatistics", jsonBuilder.getJson());
    }
}
