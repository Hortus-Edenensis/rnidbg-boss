package com.qiniu.android.common;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ZonesInfo implements Cloneable {
    private boolean isTemporary;
    public final ArrayList<ZoneInfo> zonesInfo;

    public ZonesInfo(ArrayList<ZoneInfo> arrayList) {
        this(arrayList, false);
    }

    public static ZonesInfo createZonesInfo(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("hosts");
                for (int i = 0; i < jSONArray.length(); i++) {
                    ZoneInfo zoneInfoBuildFromJson = ZoneInfo.buildFromJson(jSONArray.getJSONObject(i));
                    if (zoneInfoBuildFromJson != null && zoneInfoBuildFromJson.isValid()) {
                        arrayList.add(zoneInfoBuildFromJson);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return new ZonesInfo(arrayList);
    }

    public Object clone() throws CloneNotSupportedException {
        ArrayList arrayList = new ArrayList();
        ArrayList<ZoneInfo> arrayList2 = this.zonesInfo;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<ZoneInfo> it = this.zonesInfo.iterator();
            while (it.hasNext()) {
                arrayList.add((ZoneInfo) it.next().clone());
            }
        }
        ZonesInfo zonesInfo = new ZonesInfo(arrayList);
        zonesInfo.isTemporary = this.isTemporary;
        return zonesInfo;
    }

    public boolean isTemporary() {
        return this.isTemporary;
    }

    public boolean isValid() {
        ArrayList<ZoneInfo> arrayList = this.zonesInfo;
        return arrayList != null && arrayList.size() > 0 && this.zonesInfo.get(0).isValid();
    }

    public void toTemporary() {
        this.isTemporary = true;
    }

    public ZonesInfo(ArrayList<ZoneInfo> arrayList, boolean z) {
        this.zonesInfo = arrayList;
        this.isTemporary = z;
    }
}
