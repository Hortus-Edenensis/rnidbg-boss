package com.amap.api.col.p0002sl;

import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import com.wifi.adsdk.download.LxAdDLManager;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class mx extends Inner_3dMap_location {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f3019a;
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private JSONObject g;
    private String h;
    private String i;
    private long j;
    private String k;

    public mx(String str) {
        super(str);
        this.b = null;
        this.c = "";
        this.e = "";
        this.f = "new";
        this.g = null;
        this.h = "";
        this.f3019a = true;
        this.i = "";
        this.j = 0L;
        this.k = null;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final JSONObject e() {
        return this.g;
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_location
    public final void setFloor(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                nl.a(th, "MapLocationModel", "setFloor");
                str = null;
            }
        }
        this.floor = str;
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_location
    public final JSONObject toJson(int i) {
        try {
            JSONObject json = super.toJson(i);
            if (i == 1) {
                json.put("retype", this.e);
                json.put("cens", this.i);
                json.put("poiid", this.buildingId);
                json.put("floor", this.floor);
                json.put("coord", this.d);
                json.put("mcell", this.h);
                json.put(LxAdDLManager.ITEM_DESC, this.desc);
                json.put("address", getAddress());
                if (this.g != null && np.a(json, "offpct")) {
                    json.put("offpct", this.g.getString("offpct"));
                }
            } else if (i != 2 && i != 3) {
                return json;
            }
            json.put("type", this.f);
            json.put("isReversegeo", this.f3019a);
            return json;
        } catch (Throwable th) {
            nl.a(th, "MapLocationModel", "toStr");
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_location
    public final String toStr(int i) {
        JSONObject json;
        try {
            json = super.toJson(i);
            json.put("nb", this.k);
        } catch (Throwable th) {
            nl.a(th, "MapLocationModel", "toStr part2");
            json = null;
        }
        if (json == null) {
            return null;
        }
        return json.toString();
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            i = -1;
        } else if (getProvider().equals(GeocodeSearch.GPS)) {
            this.d = 0;
            return;
        } else if (str.equals("0")) {
            this.d = 0;
            return;
        } else if (str.equals("1")) {
            i = 1;
        }
        this.d = i;
    }

    public final void d(String str) {
        this.e = str;
    }

    public final void e(String str) {
        this.desc = str;
    }
}
