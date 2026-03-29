package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class TileOverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Bundle f3705a = null;
    private static final String b = "TileOverlayOptions";
    private TileProvider d;
    public int datasource;
    public String urlString;
    private int c = AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_CACHE_SIZE;
    private int e = 20;
    private int f = 3;
    private int g = 15786414;
    private int h = -20037726;
    private int i = -15786414;
    private int j = 20037726;

    public TileOverlayOptions() {
        Bundle bundle = new Bundle();
        f3705a = bundle;
        bundle.putInt("rectr", this.g);
        f3705a.putInt("rectb", this.h);
        f3705a.putInt("rectl", this.i);
        f3705a.putInt("rectt", this.j);
    }

    private TileOverlayOptions a(int i, int i2) {
        this.e = i;
        this.f = i2;
        return this;
    }

    public TileOverlayOptions setMaxTileTmp(int i) {
        this.c = i;
        return this;
    }

    public TileOverlayOptions setPositionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            throw new IllegalArgumentException("BDMapSDKException: bound can not be null");
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLngBounds.northeast);
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(latLngBounds.southwest);
        double latitudeE6 = geoPointLl2mc.getLatitudeE6();
        double longitudeE6 = geoPointLl2mc2.getLongitudeE6();
        double latitudeE62 = geoPointLl2mc2.getLatitudeE6();
        double longitudeE62 = geoPointLl2mc.getLongitudeE6();
        if (latitudeE6 <= latitudeE62 || longitudeE62 <= longitudeE6) {
            Log.e(b, "BDMapSDKException: bounds is illegal, use default bounds");
        } else {
            f3705a.putInt("rectr", (int) longitudeE62);
            f3705a.putInt("rectb", (int) latitudeE62);
            f3705a.putInt("rectl", (int) longitudeE6);
            f3705a.putInt("rectt", (int) latitudeE6);
        }
        return this;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        if (tileProvider == null) {
            return null;
        }
        if (tileProvider instanceof UrlTileProvider) {
            this.datasource = 1;
            String tileUrl = ((UrlTileProvider) tileProvider).getTileUrl();
            if (tileUrl == null || "".equals(tileUrl) || !tileUrl.contains("{x}") || !tileUrl.contains("{y}") || !tileUrl.contains("{z}")) {
                Log.e(b, "tile url template is illegal, must contains {x}、{y}、{z}");
                return null;
            }
            this.urlString = tileUrl;
        } else {
            if (!(tileProvider instanceof FileTileProvider)) {
                Log.e(b, "tileProvider must be UrlTileProvider or FileTileProvider");
                return null;
            }
            this.datasource = 0;
        }
        this.d = tileProvider;
        int maxDisLevel = tileProvider.getMaxDisLevel();
        int minDisLevel = tileProvider.getMinDisLevel();
        if (maxDisLevel > 21 || minDisLevel < 3) {
            Log.e(b, "display level is illegal");
        } else {
            a(maxDisLevel, minDisLevel);
        }
        return this;
    }

    public TileOverlay a(BaiduMap baiduMap) {
        return new TileOverlay(baiduMap, this.d);
    }

    public Bundle a() {
        f3705a.putString("url", this.urlString);
        f3705a.putInt("datasource", this.datasource);
        f3705a.putInt("maxDisplay", this.e);
        f3705a.putInt("minDisplay", this.f);
        f3705a.putInt("sdktiletmpmax", this.c);
        return f3705a;
    }
}
