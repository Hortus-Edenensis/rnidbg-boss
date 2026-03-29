package com.baidu.platform.comapi.util;

import com.baidu.vi.VIContext;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class SysOSUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SysOSUtil f4229a = new SysOSUtil();
    private com.baidu.platform.comapi.util.a.b b = null;
    private com.baidu.platform.comapi.util.a.a c = null;
    private boolean d = false;
    private String e = "";
    private String f = "";
    private String g = "";

    private SysOSUtil() {
    }

    public static SysOSUtil getInstance() {
        return f4229a;
    }

    public String getCompatibleSdcardPath() {
        com.baidu.platform.comapi.util.a.b bVar = this.b;
        return bVar != null ? bVar.a() : "";
    }

    public float getDensity() {
        com.baidu.platform.comapi.util.a.a aVar = this.c;
        if (aVar != null) {
            return aVar.a();
        }
        return 1.0f;
    }

    public int getDensityDPI() {
        com.baidu.platform.comapi.util.a.a aVar = this.c;
        if (aVar != null) {
            return aVar.b();
        }
        return 1;
    }

    public String getExternalFilesDir() {
        com.baidu.platform.comapi.util.a.b bVar = this.b;
        return bVar != null ? bVar.b() : "";
    }

    public String getGLRenderer() {
        return this.g;
    }

    public String getGLVersion() {
        return this.f;
    }

    public String getNetType() {
        return this.e;
    }

    public String getOutputCache() {
        com.baidu.platform.comapi.util.a.b bVar = this.b;
        return bVar != null ? bVar.c() : "";
    }

    public String getOutputDirPath() {
        com.baidu.platform.comapi.util.a.b bVar = this.b;
        return bVar != null ? bVar.d() : "";
    }

    public int getScreenHeight() {
        com.baidu.platform.comapi.util.a.a aVar = this.c;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    public int getScreenWidth() {
        com.baidu.platform.comapi.util.a.a aVar = this.c;
        if (aVar != null) {
            return aVar.d();
        }
        return 0;
    }

    public String getSdcardPath() {
        com.baidu.platform.comapi.util.a.b bVar = this.b;
        return bVar != null ? bVar.e() : "";
    }

    public void init(com.baidu.platform.comapi.util.a.b bVar, com.baidu.platform.comapi.util.a.a aVar) {
        if (this.d) {
            return;
        }
        this.b = bVar;
        this.c = aVar;
        if (bVar == null) {
            this.b = new com.baidu.platform.comapi.util.a.b();
        }
        if (this.c == null) {
            this.c = new com.baidu.platform.comapi.util.a.a();
        }
        this.b.a(VIContext.getContext());
        this.c.a(VIContext.getContext());
        try {
            NetworkUtil.registerNetwork(VIContext.getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = true;
    }

    public void setGLInfo(String str, String str2) {
        if (this.g.equals(str2) && this.f.equals(str)) {
            return;
        }
        this.f = str;
        this.g = str2;
    }

    public void updateNetType(String str) {
        this.e = str;
    }
}
