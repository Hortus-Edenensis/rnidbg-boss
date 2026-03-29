package com.baidu.mapapi.map;

import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmTextPathMarker;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class TextPathMarker extends Overlay {
    String g;
    private BmTextStyle h;
    private BmGeoElement i;
    private BmTextPathMarker j;
    int k;
    int l;
    int m;
    int n;
    Typeface o;
    List<LatLng> p;

    public TextPathMarker() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.textPath;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        bundle.putString("id", this.f3666a);
        bundle.putInt("type", this.type.ordinal());
        bundle.putInt(RemoteMessageConst.Notification.VISIBILITY, this.d ? 1 : 0);
        bundle.putInt("z_index", this.c);
        return null;
    }

    public List<LatLng> getPoints() {
        return this.p;
    }

    public String getText() {
        return this.g;
    }

    public int getTextBorderColor() {
        return this.m;
    }

    public int getTextBorderWidth() {
        return this.n;
    }

    public int getTextColor() {
        return this.k;
    }

    public Typeface getTextFontOption() {
        return this.o;
    }

    public int getTextSize() {
        return this.l;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public int getZIndex() {
        return this.c;
    }

    public void setPoints(List<LatLng> list) {
        if (!OverlayUtil.isOverlayUpgrade() || list == null || list.size() < 2) {
            return;
        }
        this.p = list;
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < list.size(); i++) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(list.get(i - 1));
            GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(list.get(i));
            com.baidu.platform.comapi.bmsdk.b bVar = new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6());
            com.baidu.platform.comapi.bmsdk.b bVar2 = new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6());
            arrayList.add(bVar);
            arrayList.add(bVar2);
        }
        this.i.a(arrayList);
        this.f.b();
    }

    public void setText(String str) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.g = str;
            this.j.a(str);
            this.f.b();
        }
    }

    public void setTextBorderColor(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.m = i;
            this.h.a(i);
            this.f.b();
        }
    }

    public void setTextBorderWidth(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.n = i;
            this.h.b(i);
            this.f.b();
        }
    }

    public void setTextColor(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.k = i;
            this.h.d(i);
            this.f.b();
        }
    }

    public void setTextFontOption(Typeface typeface) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.o = typeface;
            this.h.c(typeface.getStyle());
            this.f.b();
        }
    }

    public void setTextSize(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.l = i;
            this.h.e(i);
            this.f.b();
        }
    }

    public void setZIndex(short s) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.c = s;
            this.j.d(s);
            this.f.b();
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        List<LatLng> list = this.p;
        if (list == null || list.size() < 2) {
            return null;
        }
        if (this.j == null) {
            this.j = new BmTextPathMarker();
        }
        if (this.h == null) {
            this.h = new BmTextStyle();
        }
        if (this.i == null) {
            this.i = new BmGeoElement(0);
        }
        super.toDrawItem();
        setDrawItem(this.j);
        this.j.a(this.g);
        this.j.d(this.c);
        this.h.d(this.k);
        this.h.a(this.m);
        this.h.b(this.n);
        Typeface typeface = this.o;
        if (typeface != null) {
            this.h.c(typeface.getStyle());
        } else {
            this.h.c(Typeface.DEFAULT.getStyle());
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < this.p.size(); i++) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.p.get(i - 1));
            GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.p.get(i));
            com.baidu.platform.comapi.bmsdk.b bVar = new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6());
            com.baidu.platform.comapi.bmsdk.b bVar2 = new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6());
            arrayList.add(bVar);
            arrayList.add(bVar2);
        }
        this.j.a(this.h);
        this.i.a(arrayList);
        this.j.a(this.i);
        this.f.b();
        return this.j;
    }
}
