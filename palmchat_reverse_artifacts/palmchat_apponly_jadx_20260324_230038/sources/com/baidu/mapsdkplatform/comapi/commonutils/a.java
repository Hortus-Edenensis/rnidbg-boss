package com.baidu.mapsdkplatform.comapi.commonutils;

import android.text.TextUtils;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.engine.NAEngine;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3958a = true;
    private static boolean b = false;

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.commonutils.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class RunnableC0083a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f3959a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        public RunnableC0083a(c cVar, String str, String str2) {
            this.f3959a = cVar;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NAEngine.a(this.f3959a.ordinal(), this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        eMonitorConsole(1),
        eMonitorNative(2),
        eMonitorNet(4);

        private int e;

        b(int i) {
            this.e = i;
        }

        public int a() {
            return this.e;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum c {
        eNone,
        eMonitorVerbose,
        eMonitorDebug,
        eMonitorInfo,
        eMonitorWarn,
        eMonitorError,
        eMonitorRealTime
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f3962a = new a(null);
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum e {
        SDK_MAP,
        Net,
        Engine
    }

    public /* synthetic */ a(RunnableC0083a runnableC0083a) {
        this();
    }

    public static a a() {
        return d.f3962a;
    }

    private void d() {
        NAEngine.a(new String[]{e.SDK_MAP.name(), e.Engine.name()});
    }

    public void b() {
        boolean zIsMapLogEnable = OpenLogUtil.isMapLogEnable();
        f3958a = zIsMapLogEnable;
        if (!zIsMapLogEnable || b) {
            return;
        }
        String mapLogFilePath = OpenLogUtil.getMapLogFilePath();
        if (TextUtils.isEmpty(mapLogFilePath)) {
            mapLogFilePath = SysOSUtil.getInstance().getExternalFilesDir();
        }
        NAEngine.a(false);
        NAEngine.a(mapLogFilePath);
        NAEngine.b(b.eMonitorNative.a());
        NAEngine.a(c.eMonitorError.ordinal());
        d();
        NAEngine.a(true);
        b = true;
    }

    public void c() {
        if (f3958a && b) {
            b = false;
            f3958a = false;
            NAEngine.a(false);
        }
    }

    private a() {
    }

    public void a(String str) {
        a(c.eMonitorRealTime, e.SDK_MAP.name(), str);
    }

    private void a(c cVar, String str, String str2) {
        if (f3958a) {
            MapTaskManager.getSingleThreadPool().submit(new RunnableC0083a(cVar, str, str2));
        }
    }
}
