package com.baidu.platform.comapi.logstatistics;

import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.base.logstatistics.NALogStatistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class LogStatistics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NALogStatistics f4141a;
    private ArrayList<c> b;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final LogStatistics f4142a = new LogStatistics();
    }

    private boolean b() {
        if (this.f4141a != null) {
            return true;
        }
        this.f4141a = new NALogStatistics();
        return true;
    }

    public static LogStatistics getInstance() {
        return b.f4142a;
    }

    public static void onAddLog(int i, int i2, String str, String str2) {
        getInstance().a(new com.baidu.platform.comapi.logstatistics.b(i, i2, str, str2));
    }

    public void a() {
        NALogStatistics nALogStatistics = this.f4141a;
        if (nALogStatistics != null) {
            nALogStatistics.dispose();
            this.f4141a = null;
        }
    }

    private LogStatistics() {
        this.f4141a = null;
        this.b = new ArrayList<>();
        b();
    }

    public void a(int i, int i2, String str, Map<String, Object> map) {
        String json;
        if (map == null || map.size() <= 0) {
            json = null;
        } else {
            JsonBuilder jsonBuilder = new JsonBuilder();
            jsonBuilder.object();
            for (String str2 : map.keySet()) {
                Object obj = map.get(str2);
                if (obj != null) {
                    jsonBuilder.key(str2).value(obj);
                }
            }
            jsonBuilder.endObject();
            json = jsonBuilder.getJson();
        }
        a(i, i2, str, json);
    }

    public boolean a(int i, int i2, String str, String str2) {
        if (this.f4141a == null) {
            return false;
        }
        if (JNIInitializer.isDebug() || JNIInitializer.isBaseLineRelease()) {
            a(new com.baidu.platform.comapi.logstatistics.b(i, i2, str, str2));
        }
        return this.f4141a.a(i, i2, SysOSUtil.getInstance().getNetType(), str, str2);
    }

    public boolean a(com.baidu.platform.comapi.logstatistics.b bVar) {
        ArrayList<c> arrayList = this.b;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        Iterator<c> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        return false;
    }
}
