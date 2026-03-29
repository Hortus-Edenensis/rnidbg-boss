package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static k f3984a;

    @SuppressLint({"HandlerLeak"})
    private static Handler b;
    private AppBaseMap c;
    private o d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        @SuppressLint({"HandlerLeak"})
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (k.f3984a != null) {
                k.this.d.a(message);
            }
        }
    }

    private k() {
    }

    public static k f() {
        if (f3984a == null) {
            k kVar = new k();
            f3984a = kVar;
            kVar.g();
        }
        return f3984a;
    }

    private void g() {
        h();
        this.d = new o();
        a aVar = new a();
        b = aVar;
        MessageCenter.registMessage(65289, aVar);
    }

    private void h() {
        EnvironmentUtilities.initAppDirectory(BMapManager.getContext());
        AppBaseMap appBaseMap = new AppBaseMap();
        this.c = appBaseMap;
        appBaseMap.Create();
        String moduleFileName = SysOSUtil.getModuleFileName();
        String appSDCardPath = EnvironmentUtilities.getAppSDCardPath();
        String appCachePath = EnvironmentUtilities.getAppCachePath();
        String appSecondCachePath = EnvironmentUtilities.getAppSecondCachePath();
        int mapTmpStgMax = EnvironmentUtilities.getMapTmpStgMax();
        int domTmpStgMax = EnvironmentUtilities.getDomTmpStgMax();
        int itsTmpStgMax = EnvironmentUtilities.getItsTmpStgMax();
        int ssgTmpStgMax = EnvironmentUtilities.getSsgTmpStgMax();
        String str = com.baidu.platform.comapi.util.SysOSUtil.getInstance().getDensityDPI() >= 180 ? "/h/" : "/l/";
        String str2 = moduleFileName + "/cfg";
        String str3 = appSDCardPath + "/vmp";
        String str4 = str2 + "/idrres/";
        String str5 = str3 + str;
        String str6 = str3 + str;
        String str7 = appCachePath + "/tmp/";
        this.c.Init(str2 + "/a/", str4, str5, str7, appSecondCachePath + "/tmp/", str6, str2 + "/a/", com.baidu.platform.comapi.util.SysOSUtil.getInstance().getScreenWidth(), com.baidu.platform.comapi.util.SysOSUtil.getInstance().getScreenHeight(), com.baidu.platform.comapi.util.SysOSUtil.getInstance().getDensityDPI(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, ssgTmpStgMax, false, false);
        this.c.OnResume();
    }

    public void b() {
        MessageCenter.unregistMessage(65289, b);
        this.c.releaseFromOfflineMap();
        f3984a = null;
    }

    public boolean c(int i) {
        AppBaseMap appBaseMap = this.c;
        if (appBaseMap == null || i < 0) {
            return false;
        }
        return appBaseMap.OnRecordRemove(i, false);
    }

    public boolean d(int i) {
        AppBaseMap appBaseMap = this.c;
        if (appBaseMap == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return appBaseMap.OnRecordStart(i, false, 0);
        }
        return false;
    }

    public boolean e(int i) {
        AppBaseMap appBaseMap = this.c;
        if (appBaseMap == null || i < 0) {
            return false;
        }
        return appBaseMap.OnRecordSuspend(i, false, 0);
    }

    public void a(n nVar) {
        o oVar = this.d;
        if (oVar != null) {
            oVar.a(nVar);
        }
    }

    public ArrayList<j> c() {
        AppBaseMap appBaseMap = this.c;
        ArrayList<j> arrayList = null;
        if (appBaseMap == null) {
            return null;
        }
        String strOnSchcityGet = appBaseMap.OnSchcityGet("");
        ArrayList<j> arrayList2 = new ArrayList<>();
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(strOnSchcityGet).optJSONArray("dataset");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                int i = 0;
                while (i < jSONArrayOptJSONArray.length()) {
                    j jVar = new j();
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    int iOptInt = jSONObjectOptJSONObject.optInt("id");
                    if (iOptInt <= 2000 || iOptInt == 2912 || iOptInt == 2911 || iOptInt == 9000) {
                        jVar.f3983a = iOptInt;
                        jVar.b = jSONObjectOptJSONObject.optString("name");
                        jVar.c = jSONObjectOptJSONObject.optInt("mapsize");
                        jVar.d = jSONObjectOptJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                        if (jSONObjectOptJSONObject.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() != 0) {
                                ArrayList<j> arrayList3 = new ArrayList<>();
                                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                    j jVar2 = new j();
                                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                    try {
                                        jVar2.f3983a = jSONObjectOptJSONObject2.optInt("id");
                                        jVar2.b = jSONObjectOptJSONObject2.optString("name");
                                        jVar2.c = jSONObjectOptJSONObject2.optInt("mapsize");
                                        jVar2.d = jSONObjectOptJSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                                        arrayList3.add(jVar2);
                                    } catch (JSONException unused) {
                                        return null;
                                    } catch (Exception unused2) {
                                        return null;
                                    }
                                }
                                jVar.a(arrayList3);
                                arrayList2.add(jVar);
                            }
                        } else {
                            arrayList2.add(jVar);
                        }
                    }
                    i++;
                    arrayList = null;
                }
                return arrayList2;
            }
            return null;
        } catch (JSONException unused3) {
            return arrayList;
        } catch (Exception unused4) {
            return arrayList;
        }
    }

    public ArrayList<m> d() {
        String strOnRecordGetAll;
        JSONArray jSONArrayOptJSONArray;
        AppBaseMap appBaseMap = this.c;
        if (appBaseMap != null && (strOnRecordGetAll = appBaseMap.OnRecordGetAll()) != null && !strOnRecordGetAll.equals("")) {
            ArrayList<m> arrayList = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(strOnRecordGetAll);
                if (jSONObject.length() != 0 && (jSONArrayOptJSONArray = jSONObject.optJSONArray("dataset")) != null && jSONArrayOptJSONArray.length() != 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        m mVar = new m();
                        l lVar = new l();
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        lVar.f3986a = jSONObjectOptJSONObject.optInt("id");
                        lVar.b = jSONObjectOptJSONObject.optString("name");
                        lVar.c = jSONObjectOptJSONObject.optString("pinyin");
                        lVar.h = jSONObjectOptJSONObject.optInt("mapoldsize");
                        lVar.i = jSONObjectOptJSONObject.optInt("ratio");
                        lVar.l = jSONObjectOptJSONObject.optInt("status");
                        lVar.g = new GeoPoint(jSONObjectOptJSONObject.optInt("y"), jSONObjectOptJSONObject.optInt("x"));
                        boolean z = true;
                        if (jSONObjectOptJSONObject.optInt("up") != 1) {
                            z = false;
                        }
                        lVar.j = z;
                        lVar.e = jSONObjectOptJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_LEVEL);
                        if (lVar.j) {
                            lVar.k = jSONObjectOptJSONObject.optInt("mapsize");
                        } else {
                            lVar.k = 0;
                        }
                        mVar.a(lVar);
                        arrayList.add(mVar);
                    }
                    return arrayList;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ArrayList<j> e() {
        ArrayList<j> arrayList;
        AppBaseMap appBaseMap = this.c;
        if (appBaseMap == null) {
            return null;
        }
        String strOnHotcityGet = appBaseMap.OnHotcityGet();
        ArrayList<j> arrayList2 = new ArrayList<>();
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(strOnHotcityGet).optJSONArray("dataset");
            if (jSONArrayOptJSONArray != null) {
                try {
                    if (jSONArrayOptJSONArray.length() != 0) {
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            j jVar = new j();
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                            jVar.f3983a = jSONObjectOptJSONObject.optInt("id");
                            jVar.b = jSONObjectOptJSONObject.optString("name");
                            jVar.c = jSONObjectOptJSONObject.optInt("mapsize");
                            jVar.d = jSONObjectOptJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                            if (jSONObjectOptJSONObject.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() != 0) {
                                    ArrayList<j> arrayList3 = new ArrayList<>();
                                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                        j jVar2 = new j();
                                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                        jVar2.f3983a = jSONObjectOptJSONObject2.optInt("id");
                                        jVar2.b = jSONObjectOptJSONObject2.optString("name");
                                        jVar2.c = jSONObjectOptJSONObject2.optInt("mapsize");
                                        jVar2.d = jSONObjectOptJSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                                        arrayList3.add(jVar2);
                                    }
                                    jVar.a(arrayList3);
                                    arrayList2.add(jVar);
                                }
                            } else {
                                arrayList2.add(jVar);
                            }
                        }
                        return arrayList2;
                    }
                } catch (JSONException e) {
                    e = e;
                    arrayList = null;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            return null;
        } catch (JSONException e2) {
            e = e2;
            arrayList = null;
        }
    }

    public void b(n nVar) {
        o oVar = this.d;
        if (oVar != null) {
            oVar.b(nVar);
        }
    }

    public boolean a(int i) {
        AppBaseMap appBaseMap = this.c;
        if (appBaseMap == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return appBaseMap.OnRecordAdd(i);
        }
        return false;
    }

    public boolean f(int i) {
        AppBaseMap appBaseMap = this.c;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.OnRecordSuspend(0, true, i);
    }

    public boolean g(int i) {
        AppBaseMap appBaseMap = this.c;
        if (appBaseMap == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return appBaseMap.OnRecordReload(i, false);
        }
        return false;
    }

    public m b(int i) {
        String strOnRecordGetAt;
        AppBaseMap appBaseMap = this.c;
        if (appBaseMap != null && i >= 0 && (strOnRecordGetAt = appBaseMap.OnRecordGetAt(i)) != null && !strOnRecordGetAt.equals("")) {
            m mVar = new m();
            l lVar = new l();
            try {
                JSONObject jSONObject = new JSONObject(strOnRecordGetAt);
                if (jSONObject.length() == 0) {
                    return null;
                }
                int iOptInt = jSONObject.optInt("id");
                if (iOptInt > 2000 && iOptInt != 2912 && iOptInt != 2911 && iOptInt != 9000) {
                    return null;
                }
                lVar.f3986a = iOptInt;
                lVar.b = jSONObject.optString("name");
                lVar.c = jSONObject.optString("pinyin");
                lVar.d = jSONObject.optString("headchar");
                lVar.h = jSONObject.optInt("mapoldsize");
                lVar.i = jSONObject.optInt("ratio");
                lVar.l = jSONObject.optInt("status");
                lVar.g = new GeoPoint(jSONObject.optInt("y"), jSONObject.optInt("x"));
                boolean z = true;
                if (jSONObject.optInt("up") != 1) {
                    z = false;
                }
                lVar.j = z;
                lVar.e = jSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_LEVEL);
                if (lVar.j) {
                    lVar.k = jSONObject.optInt("mapsize");
                } else {
                    lVar.k = 0;
                }
                lVar.f = jSONObject.optInt("ver");
                mVar.a(lVar);
                return mVar;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean a(boolean z, boolean z2) {
        AppBaseMap appBaseMap = this.c;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.OnRecordImport(z, z2);
    }

    public ArrayList<j> a(String str) {
        AppBaseMap appBaseMap;
        if (!str.equals("") && (appBaseMap = this.c) != null) {
            String strOnSchcityGet = appBaseMap.OnSchcityGet(str);
            if (strOnSchcityGet == null || strOnSchcityGet.equals("")) {
                return null;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(strOnSchcityGet);
                if (jSONObject.length() == 0) {
                    return null;
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("dataset");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        j jVar = new j();
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        int iOptInt = jSONObject2.optInt("id");
                        if (iOptInt <= 2000 || iOptInt == 2912 || iOptInt == 2911 || iOptInt == 9000) {
                            jVar.f3983a = iOptInt;
                            jVar.b = jSONObject2.optString("name");
                            jVar.c = jSONObject2.optInt("mapsize");
                            jVar.d = jSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                            if (jSONObject2.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                                JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() != 0) {
                                    ArrayList<j> arrayList2 = new ArrayList<>();
                                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                        j jVar2 = new j();
                                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i2);
                                        jVar2.f3983a = jSONObjectOptJSONObject.optInt("id");
                                        jVar2.b = jSONObjectOptJSONObject.optString("name");
                                        jVar2.c = jSONObjectOptJSONObject.optInt("mapsize");
                                        jVar2.d = jSONObjectOptJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                                        arrayList2.add(jVar2);
                                    }
                                    jVar.a(arrayList2);
                                    arrayList.add(jVar);
                                }
                            } else {
                                arrayList.add(jVar);
                            }
                        }
                    }
                    return arrayList;
                }
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
