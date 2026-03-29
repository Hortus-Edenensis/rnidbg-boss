package com.amap.api.col.p0002sl;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.wifi.adsdk.download.LxAdDLManager;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class lh extends AMapLocation {
    protected String d;
    boolean e;
    String f;
    private String g;
    private String h;
    private int i;
    private String j;
    private int k;
    private String l;
    private JSONObject m;
    private String n;
    private String o;
    private String p;

    public lh(String str) {
        super(str);
        this.d = "";
        this.g = null;
        this.h = "";
        this.j = "";
        this.k = 0;
        this.l = "new";
        this.m = null;
        this.n = "";
        this.e = true;
        this.f = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
        this.o = "";
        this.p = null;
    }

    private void i(String str) {
        this.n = str;
    }

    public final String a() {
        return this.g;
    }

    public final String b() {
        return this.h;
    }

    public final int c() {
        return this.i;
    }

    public final String d() {
        return this.j;
    }

    public final String e() {
        return this.l;
    }

    public final JSONObject f() {
        return this.m;
    }

    public final String g() {
        return this.n;
    }

    public final lh h() {
        String strG = g();
        if (TextUtils.isEmpty(strG)) {
            return null;
        }
        String[] strArrSplit = strG.split(",");
        if (strArrSplit.length != 3) {
            return null;
        }
        lh lhVar = new lh("");
        lhVar.setProvider(getProvider());
        lhVar.setLongitude(mm.c(strArrSplit[0]));
        lhVar.setLatitude(mm.c(strArrSplit[1]));
        lhVar.setAccuracy(mm.d(strArrSplit[2]));
        lhVar.setCityCode(getCityCode());
        lhVar.setAdCode(getAdCode());
        lhVar.setCountry(getCountry());
        lhVar.setProvince(getProvince());
        lhVar.setCity(getCity());
        lhVar.setTime(getTime());
        lhVar.e(e());
        lhVar.c(String.valueOf(c()));
        if (mm.a(lhVar)) {
            return lhVar;
        }
        return null;
    }

    public final String j() {
        return this.f;
    }

    public final String k() {
        return this.p;
    }

    public final int l() {
        return this.k;
    }

    @Override // com.amap.api.location.AMapLocation
    public final JSONObject toJson(int i) {
        try {
            JSONObject json = super.toJson(i);
            if (i == 1) {
                json.put("retype", this.j);
                json.put("cens", this.o);
                json.put("coord", this.i);
                json.put("mcell", this.n);
                json.put(LxAdDLManager.ITEM_DESC, this.d);
                json.put("address", getAddress());
                if (this.m != null && mm.a(json, "offpct")) {
                    json.put("offpct", this.m.getString("offpct"));
                }
            } else if (i != 2 && i != 3) {
                return json;
            }
            json.put("type", this.l);
            json.put("isReversegeo", this.e);
            json.put("geoLanguage", this.f);
            return json;
        } catch (Throwable th) {
            me.a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr() {
        return toStr(1);
    }

    private void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArrSplit = str.split("\\*");
        int length = strArrSplit.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str2 = strArrSplit[i];
            if (!TextUtils.isEmpty(str2)) {
                String[] strArrSplit2 = str2.split(",");
                setLongitude(mm.c(strArrSplit2[0]));
                setLatitude(mm.c(strArrSplit2[1]));
                setAccuracy(mm.e(strArrSplit2[2]));
                break;
            }
            i++;
        }
        this.o = str;
    }

    public final void a(String str) {
        this.g = str;
    }

    public final void b(String str) {
        this.h = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.i = -1;
        } else if (str.equals("0")) {
            this.i = 0;
        } else if (str.equals("1")) {
            this.i = 1;
        }
        if (this.i == 0) {
            super.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        } else {
            super.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
        }
    }

    public final void d(String str) {
        this.j = str;
    }

    public final void e(String str) {
        this.l = str;
    }

    public final void f(String str) {
        this.f = str;
    }

    public final void g(String str) {
        this.d = str;
    }

    public final boolean i() {
        return this.e;
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr(int i) {
        JSONObject json;
        try {
            json = toJson(i);
            json.put("nb", this.p);
        } catch (Throwable th) {
            me.a(th, "AMapLocation", "toStr part2");
            json = null;
        }
        if (json == null) {
            return null;
        }
        return json.toString();
    }

    public final void a(JSONObject jSONObject) {
        this.m = jSONObject;
    }

    public final void b(JSONObject jSONObject) {
        try {
            me.a(this, jSONObject);
            e(jSONObject.optString("type", this.l));
            d(jSONObject.optString("retype", this.j));
            j(jSONObject.optString("cens", this.o));
            g(jSONObject.optString(LxAdDLManager.ITEM_DESC, this.d));
            c(jSONObject.optString("coord", String.valueOf(this.i)));
            i(jSONObject.optString("mcell", this.n));
            a(jSONObject.optBoolean("isReversegeo", this.e));
            f(jSONObject.optString("geoLanguage", this.f));
            if (mm.a(jSONObject, "poiid")) {
                setBuildingId(jSONObject.optString("poiid"));
            }
            if (mm.a(jSONObject, "pid")) {
                setBuildingId(jSONObject.optString("pid"));
            }
            if (mm.a(jSONObject, "floor")) {
                setFloor(jSONObject.optString("floor"));
            }
            if (mm.a(jSONObject, "flr")) {
                setFloor(jSONObject.optString("flr"));
            }
        } catch (Throwable th) {
            me.a(th, "AmapLoc", "AmapLoc");
        }
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final void a(int i) {
        this.k = i;
    }

    public final void h(String str) {
        this.p = str;
    }
}
