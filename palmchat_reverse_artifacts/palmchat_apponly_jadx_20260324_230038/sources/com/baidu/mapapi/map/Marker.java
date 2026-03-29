package com.baidu.mapapi.map;

import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.bmsdk.ui.RichView;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.animation.BDAnimation;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmIconMarker;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.bmsdk.BmTextMarker;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmFrameResource;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;
import com.baidu.platform.comapi.bmsdk.ui.BmLabelUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import com.baidu.platform.comjni.tools.ParcelItem;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.umeng.analytics.AnalyticsConfig;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Marker extends Overlay {
    int E;
    ArrayList<BitmapDescriptor> G;
    BmFrameResource H;
    int I;
    Animation K;
    Point O;
    InfoWindow P;
    InfoWindow.a Q;
    InfoWindowAdapter X;
    LatLng g;
    BitmapDescriptor h;
    BmBitmapResource i;
    BmIconMarker j;
    int k;
    float l;
    float m;
    boolean n;
    boolean o;
    float p;
    String q;
    TitleOptions r;
    BmTextMarker s;
    int t;
    int u;
    float x;
    int y;
    boolean v = false;
    boolean w = false;
    boolean z = false;
    boolean A = true;
    boolean B = false;
    boolean C = false;
    boolean D = false;
    int F = 160;
    int J = 20;
    float L = 1.0f;
    float M = 1.0f;
    float N = 1.0f;
    boolean R = false;
    int S = Integer.MAX_VALUE;
    int T = 0;
    int U = 4;
    int V = 22;
    int W = 0;

    public Marker() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.marker;
    }

    private void a(InfoWindow infoWindow, InfoWindow infoWindow2) {
        infoWindow.b = infoWindow2.getBitmapDescriptor();
        infoWindow.d = infoWindow2.getPosition();
        infoWindow.f3633a = infoWindow2.getTag();
        infoWindow.c = infoWindow2.getView();
        infoWindow.j = infoWindow2.getYOffset();
        infoWindow.n = infoWindow2.n;
        infoWindow.h = infoWindow2.h;
    }

    public void addRichView(RichView richView) {
        BmIconMarker bmIconMarker;
        if (richView == null || !OverlayUtil.isOverlayUpgrade() || (bmIconMarker = this.j) == null || this.f == null) {
            return;
        }
        bmIconMarker.a(richView.getBmRichView());
        this.f.b();
    }

    public void cancelAnimation() {
        if (this.K != null) {
            if (!OverlayUtil.isOverlayUpgrade()) {
                this.K.bdAnimation.cancelAnimation();
            } else {
                this.K.bmAnimation.cancel();
                this.f.b();
            }
        }
    }

    public void clearRichViews() {
        BmIconMarker bmIconMarker;
        if (!OverlayUtil.isOverlayUpgrade() || (bmIconMarker = this.j) == null || this.f == null) {
            return;
        }
        bmIconMarker.c();
        this.f.b();
    }

    public float getAlpha() {
        return this.x;
    }

    public float getAnchorX() {
        return this.l;
    }

    public float getAnchorY() {
        return this.m;
    }

    public BmBitmapResource getBmBitmapResource() {
        return this.i;
    }

    public int getEndLevel() {
        return this.V;
    }

    public Point getFixedPosition() {
        return this.O;
    }

    public Point getFixedScreenPosition() {
        return this.O;
    }

    public BitmapDescriptor getIcon() {
        return this.h;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.G;
    }

    public String getId() {
        return this.f3666a;
    }

    public InfoWindow getInfoWindow() {
        return this.P;
    }

    @Deprecated
    public int getPeriod() {
        if (OverlayUtil.isOverlayUpgrade()) {
            return 0;
        }
        return this.J;
    }

    public LatLng getPosition() {
        return this.g;
    }

    public int getPriority() {
        return this.S;
    }

    public float getRotate() {
        return this.p;
    }

    public float getScale() {
        return this.N;
    }

    public float getScaleX() {
        return this.L;
    }

    public float getScaleY() {
        return this.M;
    }

    public int getStartLevel() {
        return this.U;
    }

    public String getTitle() {
        return this.q;
    }

    public TitleOptions getTitleOptions() {
        return this.r;
    }

    public int getXOffset() {
        return this.u;
    }

    public int getYOffset() {
        return this.t;
    }

    public void hideInfoWindow() {
        InfoWindow.a aVar = this.Q;
        if (aVar != null) {
            aVar.a(this.P);
            this.R = false;
        }
        this.P = null;
    }

    public boolean isClickable() {
        return this.A;
    }

    public boolean isDraggable() {
        return this.o;
    }

    public boolean isFixed() {
        return this.z;
    }

    public boolean isFlat() {
        return this.v;
    }

    public boolean isForceDisplay() {
        return this.D;
    }

    public boolean isInfoWindowEnabled() {
        return this.R;
    }

    public boolean isJoinCollision() {
        return this.B;
    }

    public boolean isPerspective() {
        return this.n;
    }

    public boolean isPoiCollided() {
        return this.C;
    }

    public void pauseAnimation() {
        if (this.K == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.K.bmAnimation.pause();
        this.f.b();
    }

    public void poiCollided(boolean z) {
        this.C = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (z) {
            this.T |= CollisionBehavior.COLLIDE_WITH_BASEPOI.getNumber();
        } else {
            this.T = (~CollisionBehavior.COLLIDE_WITH_BASEPOI.getNumber()) & this.T;
        }
        this.j.e(this.T);
        this.f.b();
    }

    public void removeRichView(RichView richView) {
        BmIconMarker bmIconMarker;
        if (richView == null || !OverlayUtil.isOverlayUpgrade() || (bmIconMarker = this.j) == null || this.f == null) {
            return;
        }
        bmIconMarker.b(richView.getBmRichView());
        this.f.b();
    }

    public void resumeAnimation() {
        if (this.K == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.K.bmAnimation.resume();
        this.f.b();
    }

    public void setAlpha(float f) {
        if (f < 0.0f || f > 1.0d) {
            this.x = 1.0f;
            return;
        }
        this.x = f;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.a(this.x);
        this.f.b();
    }

    public void setAnchor(float f, float f2) {
        if (f < 0.0f || f > 1.0f || f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.l = f;
        this.m = f2;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.b(f);
        this.j.c(f2);
        BmTextMarker bmTextMarker = this.s;
        if (bmTextMarker != null) {
            bmTextMarker.b(f);
            this.s.c(f2);
        }
        this.f.b();
    }

    public void setAnimateType(int i) {
        this.y = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.o(i);
        this.f.b();
    }

    public void setAnimation(Animation animation) {
        if (animation == null) {
            return;
        }
        this.K = animation;
        if (!OverlayUtil.isOverlayUpgrade()) {
            BDAnimation bDAnimation = this.K.bdAnimation;
            if (bDAnimation != null) {
                bDAnimation.setAnimation(this, animation);
                return;
            }
            return;
        }
        BmAnimation bmAnimation = this.K.bmAnimation;
        if (bmAnimation != null) {
            this.j.a(bmAnimation);
            this.f.b();
        }
    }

    public void setBmBitmapResource(BmBitmapResource bmBitmapResource) {
        BmIconMarker bmIconMarker;
        if (bmBitmapResource == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
        }
        this.i = bmBitmapResource;
        if (!OverlayUtil.isOverlayUpgrade() || (bmIconMarker = this.j) == null || this.f == null) {
            return;
        }
        bmIconMarker.a(this.i);
        this.f.b();
    }

    public void setClickable(boolean z) {
        this.A = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.a(z);
        this.f.b();
    }

    public void setDraggable(boolean z) {
        this.o = z;
        if (OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.listener.c(this);
    }

    public void setEndLevel(int i) {
        this.V = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.a(i);
        this.f.b();
    }

    public void setFixedScreenPosition(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("BDMapSDKException: the screenPosition can not be null");
        }
        this.O = point;
        this.z = true;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.j(this.z ? 1 : 0);
        this.j.g(this.O.x);
        this.j.h(this.O.y);
        this.f.b();
    }

    public void setFlat(boolean z) {
        this.v = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        if (z) {
            bmIconMarker.i(3);
        } else {
            bmIconMarker.i(0);
        }
        this.f.b();
    }

    public void setForceDisplay(boolean z) {
        this.D = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (z) {
            this.T |= CollisionBehavior.ALWAYS_SHOW.getNumber();
        } else {
            this.T = (~CollisionBehavior.ALWAYS_SHOW.getNumber()) & this.T;
        }
        this.j.e(this.T);
        this.f.b();
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
        }
        this.h = bitmapDescriptor;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.a(new BmBitmapResource(this.h.getBitmap()));
        this.f.b();
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
        }
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() == 1) {
            this.h = arrayList.get(0);
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) == null || arrayList.get(i).f3610a == null) {
                    return;
                }
            }
            this.G = (ArrayList) arrayList.clone();
            this.h = null;
        }
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        if (this.G != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<BitmapDescriptor> it = this.G.iterator();
            while (it.hasNext()) {
                arrayList2.add(new BmBitmapResource(it.next().getBitmap()));
            }
            BmFrameResource bmFrameResource = new BmFrameResource(arrayList2, this.F, Integer.MAX_VALUE);
            this.H = bmFrameResource;
            this.j.a(bmFrameResource);
        } else if (this.h != null) {
            bmIconMarker.a(new BmBitmapResource(this.h.getBitmap()));
        }
        this.f.b();
    }

    public void setInterval(int i) {
        BmFrameResource bmFrameResource;
        int i2;
        if (i > 0 && OverlayUtil.isOverlayUpgrade() && (bmFrameResource = this.H) != null && (i2 = this.I) > 0) {
            bmFrameResource.a(i2, this.F);
            this.F = i;
            this.f.b();
        }
    }

    public void setJoinCollision(boolean z) {
        this.B = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (z) {
            this.T |= CollisionBehavior.COLLIDE_WITH_INNER.getNumber();
        } else {
            this.T = (~CollisionBehavior.COLLIDE_WITH_INNER.getNumber()) & this.T;
        }
        this.j.e(this.T);
        this.f.b();
    }

    @Deprecated
    public void setPeriod(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        if (i <= 0) {
            throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
        }
        this.J = i;
        this.listener.c(this);
    }

    public void setPerspective(boolean z) {
        this.n = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.n(this.n ? 1 : 0);
        this.f.b();
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
        this.g = latLng;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.j == null || this.f == null) {
            return;
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.g);
        this.j.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        BmTextMarker bmTextMarker = this.s;
        if (bmTextMarker != null) {
            bmTextMarker.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        }
        this.f.b();
    }

    public void setPositionWithInfoWindow(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
        this.g = latLng;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else if (this.j != null && this.f != null) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.g);
            this.j.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            this.f.b();
        }
        InfoWindow infoWindow = this.P;
        if (infoWindow != null) {
            infoWindow.setPosition(latLng);
        }
    }

    public void setPriority(int i) {
        this.S = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.f(i);
        this.f.b();
    }

    public void setRotate(float f) {
        while (f < 0.0f) {
            f += 360.0f;
        }
        float f2 = f % 360.0f;
        this.p = f2;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.d(f2);
        this.f.b();
    }

    public void setScale(float f) {
        if (f < 0.0f) {
            f = 1.0f;
        }
        this.L = f;
        this.M = f;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.e(f);
        if (this.s != null) {
            int titleYOffset = this.r.getTitleYOffset();
            if (this.h != null) {
                titleYOffset -= (int) (r0.getBitmap().getHeight() * this.M);
            }
            this.s.m((titleYOffset * 310) / SysOSUtil.getDensityDpi());
        }
        this.f.b();
    }

    public void setScaleX(float f) {
        if (f < 0.0f) {
            f = 1.0f;
        }
        this.L = f;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.f(f);
        this.f.b();
    }

    public void setScaleY(float f) {
        if (f < 0.0f) {
            f = 1.0f;
        }
        this.M = f;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.g(f);
        if (this.s != null) {
            int titleYOffset = this.r.getTitleYOffset();
            if (this.h != null) {
                titleYOffset -= (int) (r0.getBitmap().getHeight() * this.M);
            }
            this.s.m((titleYOffset * 310) / SysOSUtil.getDensityDpi());
        }
        this.f.b();
    }

    public void setStartLevel(int i) {
        this.U = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.b(i);
        this.f.b();
    }

    public void setTitle(String str) {
        this.q = str;
        if (OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.listener.c(this);
    }

    public void setTitleOptions(TitleOptions titleOptions) {
        if (titleOptions == null) {
            return;
        }
        this.r = titleOptions;
        this.W = 1;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.j == null || this.f == null) {
            return;
        }
        BmLabelUI bmLabelUI = new BmLabelUI();
        bmLabelUI.setName("titleOption");
        bmLabelUI.b(this.r.getText());
        bmLabelUI.b(this.r.getTitleXOffset(), this.r.getTitleYOffset(), 0, 0);
        bmLabelUI.b(this.r.getTitleBgColor());
        BmTextStyle bmTextStyle = new BmTextStyle();
        bmTextStyle.d(this.r.getTitleFontColor());
        bmTextStyle.e(this.r.getTitleFontSize());
        bmLabelUI.a(bmTextStyle);
        BmRichView bmRichView = new BmRichView();
        bmRichView.a(bmLabelUI);
        this.j.a(bmRichView);
        this.f.b();
    }

    public void setToTop() {
        BmLayer bmLayer;
        this.w = true;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || (bmLayer = this.f) == null) {
            return;
        }
        BmDrawItem bmDrawItemA = bmLayer.a(bmIconMarker.getName());
        if (bmDrawItemA != null) {
            this.f.a(bmDrawItemA);
        }
        this.f.a(this.j.getName(), this.j);
        this.f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public void setVisible(boolean z) {
        this.d = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.c(z ? 1 : 0);
        this.f.b();
    }

    public void setXOffset(int i) {
        this.u = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.l(i);
        this.f.b();
    }

    public void setYOffset(int i) {
        this.t = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        bmIconMarker.m(i);
        this.f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public void setZIndex(int i) {
        BmLayer bmLayer;
        this.c = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || (bmLayer = this.f) == null) {
            return;
        }
        if (bmLayer.a(bmIconMarker.getName()) != null) {
            this.f.a(this.j);
        }
        this.f.a(this.j, i);
        this.f.b();
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        if (infoWindow == null) {
            throw new IllegalArgumentException("BDMapSDKException: the InfoWindow can not be null");
        }
        InfoWindow infoWindow2 = this.P;
        if (infoWindow2 == null) {
            this.P = infoWindow;
        } else {
            InfoWindow.a aVar = this.Q;
            if (aVar != null) {
                aVar.a(infoWindow2);
            }
            a(this.P, infoWindow);
        }
        InfoWindow.a aVar2 = this.Q;
        if (aVar2 != null) {
            aVar2.b(this.P);
            this.R = true;
        }
    }

    public void showSmoothMoveInfoWindow(InfoWindow infoWindow) {
        if (infoWindow == null) {
            return;
        }
        if (!infoWindow.n) {
            throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow must build with View");
        }
        if (infoWindow.c == null) {
            throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow's View can not be null");
        }
        InfoWindow infoWindow2 = this.P;
        if (infoWindow2 == null) {
            this.P = infoWindow;
        } else {
            a(infoWindow2, infoWindow);
        }
        InfoWindow infoWindow3 = this.P;
        infoWindow3.m = true;
        InfoWindow.a aVar = this.Q;
        if (aVar != null) {
            aVar.b(infoWindow3);
            this.R = true;
        }
    }

    public void startAnimation() {
        if (this.K != null) {
            if (!OverlayUtil.isOverlayUpgrade()) {
                this.K.bdAnimation.startAnimation();
            } else {
                this.K.bmAnimation.start();
                this.f.b();
            }
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmIconMarker bmIconMarker = new BmIconMarker();
        this.j = bmIconMarker;
        bmIconMarker.a(this);
        setDrawItem(this.j);
        super.toDrawItem();
        if (this.G != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<BitmapDescriptor> it = this.G.iterator();
            while (it.hasNext()) {
                arrayList.add(new BmBitmapResource(it.next().getBitmap()));
            }
            this.H = new BmFrameResource(arrayList, this.F, Integer.MAX_VALUE);
            this.I = arrayList.size();
            this.j.a(this.H);
        } else {
            BmBitmapResource bmBitmapResource = this.i;
            if (bmBitmapResource != null) {
                this.j.a(bmBitmapResource);
            } else if (this.h != null) {
                this.j.a(new BmBitmapResource(this.h.getBitmap()));
            }
        }
        LatLng latLng = this.g;
        if (latLng != null) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
            this.j.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        }
        this.j.k(this.k);
        this.j.a(this.x);
        this.j.a(this.A);
        this.j.a(this.U, this.V);
        this.j.d(this.c);
        this.j.e(this.N);
        this.j.f(this.L);
        this.j.g(this.M);
        this.j.l(this.u);
        this.j.m(this.t);
        this.j.d(this.p);
        this.j.o(this.y);
        Animation animation = this.K;
        if (animation != null) {
            this.j.a(animation.bmAnimation);
        }
        this.j.a(this.f3666a);
        this.j.d(this.c);
        this.j.j(this.z ? 1 : 0);
        this.j.n(this.n ? 1 : 0);
        if (this.B) {
            this.T |= CollisionBehavior.COLLIDE_WITH_INNER.getNumber();
        }
        if (this.D) {
            this.T |= CollisionBehavior.ALWAYS_SHOW.getNumber();
        }
        if (this.C) {
            this.T |= CollisionBehavior.COLLIDE_WITH_BASEPOI.getNumber();
        }
        Point point = this.O;
        if (point != null) {
            this.j.g(point.x);
            this.j.h(this.O.y);
            this.T = CollisionBehavior.NOT_COLLIDE.getNumber();
        }
        this.j.e(this.T);
        this.j.f(this.S);
        if (this.v) {
            this.j.i(3);
        } else {
            this.j.i(0);
        }
        this.j.b(this.l);
        this.j.c(this.m);
        if (this.r != null) {
            BmTextMarker bmTextMarker = this.s;
            if (bmTextMarker != null) {
                this.f.a(bmTextMarker);
                this.s = null;
            }
            BmTextMarker bmTextMarker2 = new BmTextMarker();
            this.s = bmTextMarker2;
            bmTextMarker2.setName("titleOption");
            this.s.b(this.r.getText());
            if (this.B) {
                BmTextMarker bmTextMarker3 = this.s;
                CollisionBehavior collisionBehavior = CollisionBehavior.ALWAYS_SHOW;
                bmTextMarker3.e(collisionBehavior.getNumber());
                this.j.e(collisionBehavior.getNumber());
                if (this.C) {
                    BmTextMarker bmTextMarker4 = this.s;
                    int number = collisionBehavior.getNumber();
                    CollisionBehavior collisionBehavior2 = CollisionBehavior.COLLIDE_WITH_BASEPOI;
                    bmTextMarker4.e(number | collisionBehavior2.getNumber());
                    this.j.e(collisionBehavior.getNumber() | collisionBehavior2.getNumber());
                }
            } else {
                this.s.e(this.T);
                this.s.f(this.S);
            }
            BmTextStyle bmTextStyle = new BmTextStyle();
            bmTextStyle.e((this.r.getTitleFontSize() * 310) / SysOSUtil.getDensityDpi());
            bmTextStyle.d(this.r.getTitleFontColor());
            bmTextStyle.c(0);
            this.s.d(this.r.getTitleRotate());
            GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.g);
            this.s.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6()));
            this.s.b(this.r.getTitleAnchorX());
            this.s.c(this.r.getTitleAnchorY());
            this.s.l((this.r.getTitleXOffset() * 310) / SysOSUtil.getDensityDpi());
            int titleYOffset = this.r.getTitleYOffset();
            if (this.h != null) {
                titleYOffset -= (int) (r2.getBitmap().getHeight() * this.M);
            }
            this.s.m((titleYOffset * 310) / SysOSUtil.getDensityDpi());
            this.s.a(bmTextStyle);
            this.f.a(this.s, this.j.b() + 1);
            this.f.b();
        }
        return this.j;
    }

    public void updateInfoWindowBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        InfoWindow infoWindow = this.P;
        if (infoWindow == null || infoWindow.o) {
            return;
        }
        infoWindow.setBitmapDescriptor(bitmapDescriptor);
    }

    public void updateInfoWindowPosition(LatLng latLng) {
        InfoWindow infoWindow = this.P;
        if (infoWindow != null) {
            infoWindow.setPosition(latLng);
        }
    }

    public void updateInfoWindowView(View view) {
        InfoWindow infoWindow = this.P;
        if (infoWindow == null || !infoWindow.n) {
            return;
        }
        infoWindow.setView(view);
    }

    public void updateInfoWindowYOffset(int i) {
        InfoWindow infoWindow = this.P;
        if (infoWindow != null) {
            infoWindow.setYOffset(i);
        }
    }

    public void updateRichView() {
        BmLayer bmLayer;
        if (!OverlayUtil.isOverlayUpgrade() || (bmLayer = this.f) == null) {
            return;
        }
        bmLayer.b();
    }

    public void setAnimation(Animation animation, TypeEvaluator typeEvaluator) {
        if (animation != null) {
            this.K = animation;
            animation.bdAnimation.setTypeEvaluator(typeEvaluator);
            this.K.bdAnimation.setAnimation(this, animation);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        Bundle bundle2 = new Bundle();
        BitmapDescriptor bitmapDescriptor = this.h;
        if (bitmapDescriptor != null) {
            bundle.putBundle("image_info", bitmapDescriptor.a());
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.g);
        bundle.putInt("animatetype", this.y);
        bundle.putDouble("location_x", geoPointLl2mc.getLongitudeE6());
        bundle.putDouble("location_y", geoPointLl2mc.getLatitudeE6());
        bundle.putInt("perspective", this.n ? 1 : 0);
        bundle.putFloat("anchor_x", this.l);
        bundle.putFloat("anchor_y", this.m);
        bundle.putFloat(FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, this.p);
        bundle.putInt("y_offset", this.t);
        bundle.putInt("x_offset", this.u);
        bundle.putInt("isflat", this.v ? 1 : 0);
        bundle.putInt("istop", this.w ? 1 : 0);
        bundle.putInt(AnalyticsConfig.RTD_PERIOD, this.J);
        bundle.putFloat("alpha", this.x);
        bundle.putInt("m_height", this.E);
        bundle.putFloat("scaleX", this.L);
        bundle.putFloat("scaleY", this.M);
        bundle.putInt("isClickable", this.A ? 1 : 0);
        bundle.putInt("priority", this.S);
        bundle.putInt("isJoinCollision", this.B ? 1 : 0);
        bundle.putInt("isForceDisplay", this.D ? 1 : 0);
        bundle.putInt("startLevel", this.U);
        bundle.putInt("endLevel", this.V);
        Point point = this.O;
        if (point != null) {
            bundle.putInt("fix_x", point.x);
            bundle.putInt("fix_y", this.O.y);
        }
        bundle.putInt("isfixed", this.z ? 1 : 0);
        ArrayList<BitmapDescriptor> arrayList = this.G;
        if (arrayList != null && arrayList.size() > 0) {
            a(this.G, bundle);
        }
        bundle2.putBundle(RemoteMessageConst.MessageBody.PARAM, bundle);
        TitleOptions titleOptions = this.r;
        if (titleOptions != null) {
            bundle.putBundle("m_title", titleOptions.a());
            int titleYOffset = this.r.getTitleYOffset();
            if (this.h != null) {
                titleYOffset -= (int) (r2.getBitmap().getHeight() * this.M);
            }
            Bundle bundle3 = bundle.getBundle("m_title");
            if (bundle3 != null) {
                bundle3.putInt("title_y_offset", titleYOffset);
            }
        }
        bundle.putInt("update", this.W);
        bundle.putInt("poi_collied", this.C ? 1 : 0);
        return bundle;
    }

    public void showInfoWindow() {
        LatLng latLng;
        InfoWindowAdapter infoWindowAdapter = this.X;
        if (infoWindowAdapter == null) {
            Log.e("BDMapSDKException", "Marker showInfoWindow InfoWindowAdapter listener can not be null");
            return;
        }
        InfoWindow infoWindow = infoWindowAdapter.getInfoWindow(this);
        if (infoWindow == null) {
            View infoWindowView = this.X.getInfoWindowView(this);
            int infoWindowViewYOffset = this.X.getInfoWindowViewYOffset();
            if (infoWindowView != null && (latLng = this.g) != null) {
                infoWindow = new InfoWindow(infoWindowView, latLng, infoWindowViewYOffset);
            }
        }
        if (infoWindow != null) {
            InfoWindow infoWindow2 = this.P;
            if (infoWindow2 == null) {
                this.P = infoWindow;
            } else {
                InfoWindow.a aVar = this.Q;
                if (aVar != null) {
                    aVar.a(infoWindow2);
                }
                a(this.P, infoWindow);
            }
            InfoWindow.a aVar2 = this.Q;
            if (aVar2 != null) {
                aVar2.b(this.P);
                this.R = true;
            }
        }
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList, int[] iArr, int i) {
        if (!OverlayUtil.isOverlayUpgrade() || arrayList == null || arrayList.isEmpty() || arrayList.size() > iArr.length || i < 0) {
            return;
        }
        if (arrayList.size() == 1) {
            this.h = arrayList.get(0);
        } else {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2) == null || arrayList.get(i2).f3610a == null) {
                    return;
                }
            }
            this.G = (ArrayList) arrayList.clone();
            this.h = null;
        }
        BmIconMarker bmIconMarker = this.j;
        if (bmIconMarker == null || this.f == null) {
            return;
        }
        if (this.G != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<BitmapDescriptor> it = this.G.iterator();
            while (it.hasNext()) {
                arrayList2.add(new BmBitmapResource(it.next().getBitmap()));
            }
            BmFrameResource bmFrameResource = new BmFrameResource(arrayList2, iArr, i);
            this.H = bmFrameResource;
            this.j.a(bmFrameResource);
        } else if (this.h != null) {
            bmIconMarker.a(new BmBitmapResource(this.h.getBitmap()));
        }
        this.f.b();
    }

    private void a(ArrayList<BitmapDescriptor> arrayList, Bundle bundle) {
        int i;
        MessageDigest messageDigest;
        ArrayList arrayList2 = new ArrayList();
        Iterator<BitmapDescriptor> it = arrayList.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            BitmapDescriptor next = it.next();
            ParcelItem parcelItem = new ParcelItem();
            Bundle bundle2 = new Bundle();
            Bitmap bitmap = next.f3610a;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(byteBufferAllocate);
            byte[] bArrArray = byteBufferAllocate.array();
            bundle2.putByteArray("image_data", bArrArray);
            bundle2.putInt(WfConstant.EXTRA_KEY_IMAGE_WIDTH, bitmap.getWidth());
            bundle2.putInt(WfConstant.EXTRA_KEY_IMAGE_HEIGHT, bitmap.getHeight());
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                messageDigest = null;
            }
            if (messageDigest != null) {
                messageDigest.update(bArrArray, 0, bArrArray.length);
                byte[] bArrDigest = messageDigest.digest();
                StringBuilder sb = new StringBuilder("");
                while (i < bArrDigest.length) {
                    sb.append(Integer.toString((bArrDigest[i] & UByte.MAX_VALUE) + 256, 16).substring(1));
                    i++;
                }
                bundle2.putString("image_hashcode", sb.toString());
            }
            parcelItem.setBundle(bundle2);
            arrayList2.add(parcelItem);
        }
        if (arrayList2.size() > 0) {
            ParcelItem[] parcelItemArr = new ParcelItem[arrayList2.size()];
            while (i < arrayList2.size()) {
                parcelItemArr[i] = (ParcelItem) arrayList2.get(i);
                i++;
            }
            bundle.putParcelableArray("icons", parcelItemArr);
        }
    }
}
