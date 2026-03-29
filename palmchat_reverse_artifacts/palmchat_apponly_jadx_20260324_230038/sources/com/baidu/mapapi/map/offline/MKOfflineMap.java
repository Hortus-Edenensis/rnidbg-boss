package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.mapsdkplatform.comapi.map.j;
import com.baidu.mapsdkplatform.comapi.map.k;
import com.baidu.mapsdkplatform.comapi.map.l;
import com.baidu.mapsdkplatform.comapi.map.m;
import com.baidu.mapsdkplatform.comapi.map.n;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import com.igexin.push.core.b;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class MKOfflineMap {
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NETWORK_ERROR = 2;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k f3733a;
    private MKOfflineMapListener b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements n {
        public a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.n
        public void a(int i, int i2) {
            if (i == 4) {
                ArrayList<MKOLUpdateElement> allUpdateInfo = MKOfflineMap.this.getAllUpdateInfo();
                if (allUpdateInfo != null) {
                    for (MKOLUpdateElement mKOLUpdateElement : allUpdateInfo) {
                        if (mKOLUpdateElement.update) {
                            MKOfflineMap.this.b.onGetOfflineMapState(4, mKOLUpdateElement.cityID);
                        }
                    }
                    return;
                }
                return;
            }
            if (i == 6) {
                MKOfflineMap.this.b.onGetOfflineMapState(6, i2);
                return;
            }
            if (i == 8) {
                MKOfflineMap.this.b.onGetOfflineMapState(0, i2 >> 8);
            } else if (i == 10) {
                MKOfflineMap.this.b.onGetOfflineMapState(2, i2);
            } else {
                if (i != 12) {
                    return;
                }
                MKOfflineMap.this.f3733a.a(true, false);
            }
        }
    }

    public void destroy() {
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "OFF", "1", null);
        this.f3733a.f(0);
        this.f3733a.b((n) null);
        this.f3733a.b();
        e.a();
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        ArrayList<m> arrayListD = this.f3733a.d();
        if (arrayListD == null) {
            return null;
        }
        ArrayList<MKOLUpdateElement> arrayList = new ArrayList<>();
        Iterator<m> it = arrayListD.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getUpdatElementFromLocalMapElement(it.next().a()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getHotCityList() {
        ArrayList<j> arrayListE = this.f3733a.e();
        if (arrayListE == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<j> it = arrayListE.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getOfflineCityList() {
        ArrayList<j> arrayListC = this.f3733a.c();
        if (arrayListC == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<j> it = arrayListC.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public MKOLUpdateElement getUpdateInfo(int i) {
        m mVarB = this.f3733a.b(i);
        if (mVarB == null) {
            return null;
        }
        return OfflineMapUtil.getUpdatElementFromLocalMapElement(mVarB.a());
    }

    @Deprecated
    public int importOfflineData() {
        return importOfflineData(false);
    }

    public boolean init(MKOfflineMapListener mKOfflineMapListener) {
        e.c();
        k kVarF = k.f();
        this.f3733a = kVarF;
        if (kVarF == null) {
            return false;
        }
        kVarF.a(new a());
        this.b = mKOfflineMapListener;
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "OFF", "0", null);
        return true;
    }

    public boolean pause(int i) {
        HashMap map = new HashMap();
        map.put("I", Integer.valueOf(i));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "OFF", "4", map);
        return this.f3733a.e(i);
    }

    public boolean remove(int i) {
        HashMap map = new HashMap();
        map.put("I", Integer.valueOf(i));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "OFF", "5", map);
        return this.f3733a.c(i);
    }

    public ArrayList<MKOLSearchRecord> searchCity(String str) {
        ArrayList<j> arrayListA = this.f3733a.a(str);
        if (arrayListA == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<j> it = arrayListA.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public boolean start(int i) {
        int i2;
        HashMap map = new HashMap();
        if (this.f3733a == null) {
            map.put("I", b.m);
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "OFF", "2", map);
            return false;
        }
        map.put("I", Integer.valueOf(i));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "OFF", "2", map);
        if (this.f3733a.d() != null) {
            Iterator<m> it = this.f3733a.d().iterator();
            while (it.hasNext()) {
                l lVar = it.next().f3987a;
                if (lVar.f3986a == i) {
                    if (lVar.j || (i2 = lVar.l) == 2 || i2 == 3 || i2 == 6) {
                        return this.f3733a.d(i);
                    }
                    return false;
                }
            }
        }
        return this.f3733a.a(i);
    }

    public boolean update(int i) {
        HashMap map = new HashMap();
        if (this.f3733a == null) {
            map.put("I", b.m);
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "OFF", "3", map);
            return false;
        }
        map.put("I", Integer.valueOf(i));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "OFF", "3", map);
        if (this.f3733a.d() != null) {
            Iterator<m> it = this.f3733a.d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                l lVar = it.next().f3987a;
                if (lVar.f3986a == i) {
                    if (lVar.j) {
                        return this.f3733a.g(i);
                    }
                }
            }
        }
        return false;
    }

    @Deprecated
    public int importOfflineData(boolean z) {
        int size;
        int i;
        ArrayList<m> arrayListD = this.f3733a.d();
        if (arrayListD != null) {
            size = arrayListD.size();
            i = size;
        } else {
            size = 0;
            i = 0;
        }
        this.f3733a.a(z, true);
        ArrayList<m> arrayListD2 = this.f3733a.d();
        if (arrayListD2 != null) {
            size = arrayListD2.size();
        }
        return size - i;
    }
}
