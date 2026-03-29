package com.baidu.mapapi.map;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.bmsdk.ui.RichView;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmTextMarker;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;
import com.baidu.vi.EnvDrawText;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Text extends Overlay {
    int A;
    CollisionBehavior D;
    Point F;
    Animation H;
    BmTextMarker g;
    BmTextStyle h;
    String i;
    LatLng j;
    int k;
    int l;
    int m;
    int o;
    int r;
    int s;
    float t;
    int u;
    int w;
    int x;
    boolean y;
    int z;
    Typeface n = Typeface.DEFAULT;
    float p = 0.5f;
    float q = 0.5f;
    boolean v = true;
    float B = 1.0f;
    float C = 1.0f;
    int E = Integer.MAX_VALUE;
    boolean G = false;

    public Text() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.text;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (this.j == null) {
            throw new IllegalStateException("BDMapSDKException: when you add a text overlay, you must provide text and the position info.");
        }
        bundle.putString("text", this.i);
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.j);
        bundle.putDouble("location_x", geoPointLl2mc.getLongitudeE6());
        bundle.putDouble("location_y", geoPointLl2mc.getLatitudeE6());
        int i = this.l;
        bundle.putInt("font_color", Color.argb(i >>> 24, i & 255, (i >> 8) & 255, (i >> 16) & 255));
        int i2 = this.k;
        bundle.putInt("bg_color", Color.argb(i2 >>> 24, i2 & 255, (i2 >> 8) & 255, (i2 >> 16) & 255));
        bundle.putInt("font_size", this.m);
        Typeface typeface = this.n;
        if (typeface != null) {
            EnvDrawText.registFontCache(typeface.hashCode(), this.n);
            bundle.putInt("type_face", this.n.hashCode());
        }
        int i3 = this.r;
        float f = 0.5f;
        bundle.putFloat("align_x", i3 != 1 ? i3 != 2 ? 0.5f : 1.0f : 0.0f);
        int i4 = this.s;
        if (i4 == 8) {
            f = 0.0f;
        } else if (i4 == 16) {
            f = 1.0f;
        }
        bundle.putFloat("align_y", f);
        bundle.putFloat(FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, this.t);
        bundle.putInt("update", this.u);
        bundle.putInt("isClickable", this.v ? 1 : 0);
        return bundle;
    }

    public void addRichView(RichView richView) {
        if (richView != null && OverlayUtil.isOverlayUpgrade()) {
            this.g.a(richView.getBmRichView());
            this.f.b();
        }
    }

    public void cancelAnimation() {
        if (this.H == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.H.bmAnimation.cancel();
        this.f.b();
    }

    public void clearRichViews() {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.g.c();
            this.f.b();
        }
    }

    public float getAlignX() {
        return this.r;
    }

    public float getAlignY() {
        return this.s;
    }

    public float getAnchorX() {
        return this.p;
    }

    public float getAnchorY() {
        return this.q;
    }

    public int getBgColor() {
        return this.k;
    }

    public CollisionBehavior getCollisionBehavior() {
        return this.D;
    }

    public int getEndLevel() {
        return this.x;
    }

    public Point getFixedPosition() {
        return this.F;
    }

    public int getFontColor() {
        return this.l;
    }

    public int getFontSize() {
        return this.m;
    }

    public LatLng getPosition() {
        return this.j;
    }

    public int getPriority() {
        return this.E;
    }

    public float getRotate() {
        return this.t;
    }

    public float getScaleX() {
        return this.B;
    }

    public float getScaleY() {
        return this.C;
    }

    public int getStartLevel() {
        return this.w;
    }

    public String getText() {
        return this.i;
    }

    public Typeface getTypeface() {
        return this.n;
    }

    public int getXOffset() {
        return this.A;
    }

    public int getYOffset() {
        return this.z;
    }

    public boolean isClickable() {
        return this.v;
    }

    public boolean isFixed() {
        return this.G;
    }

    public boolean isPerspective() {
        return this.y;
    }

    public void pauseAnimation() {
        if (this.H == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.H.bmAnimation.pause();
        this.f.b();
    }

    public void removeRichView(RichView richView) {
        if (richView != null && OverlayUtil.isOverlayUpgrade()) {
            this.g.b(richView.getBmRichView());
            this.f.b();
        }
    }

    public void resumeAnimation() {
        if (this.H == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.H.bmAnimation.resume();
        this.f.b();
    }

    public void setAlign(int i, int i2) {
        this.r = i;
        this.s = i2;
        this.u = 1;
        if (OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.listener.c(this);
    }

    public void setAnchor(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f || f > 1.0f || f2 > 1.0f || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.p = f;
        this.q = f2;
        this.g.b(f);
        this.g.c(f2);
        this.f.b();
    }

    public void setAnimation(Animation animation) {
        BmAnimation bmAnimation;
        if (animation == null) {
            return;
        }
        this.H = animation;
        if (!OverlayUtil.isOverlayUpgrade() || (bmAnimation = this.H.bmAnimation) == null) {
            return;
        }
        this.g.a(bmAnimation);
        this.f.b();
    }

    public void setBgColor(int i) {
        this.k = i;
        this.u = 1;
        if (OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.listener.c(this);
    }

    public void setBorderColor(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.h.a(i);
            this.f.b();
        }
    }

    public void setBorderWidth(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.h.b(i);
            this.f.b();
        }
    }

    public void setClickable(boolean z) {
        this.v = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmTextMarker bmTextMarker = this.g;
        if (bmTextMarker == null || this.f == null) {
            return;
        }
        bmTextMarker.a(z);
        this.f.b();
    }

    public void setCollisionBehavior(CollisionBehavior collisionBehavior) {
        BmTextMarker bmTextMarker;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.g) == null || this.f == null) {
            return;
        }
        this.D = collisionBehavior;
        bmTextMarker.e(collisionBehavior.getNumber());
        this.f.b();
    }

    public void setEndLevel(int i) {
        BmTextMarker bmTextMarker;
        this.x = i;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.g) == null || this.f == null) {
            return;
        }
        bmTextMarker.a(i);
        this.f.b();
    }

    public void setFixedScreenPosition(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("BDMapSDKException: the screenPosition can not be null");
        }
        this.F = point;
        this.G = true;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmTextMarker bmTextMarker = this.g;
        if (bmTextMarker == null || this.f == null) {
            return;
        }
        bmTextMarker.j(this.G ? 1 : 0);
        this.g.g(this.F.x);
        this.g.h(this.F.y);
        this.f.b();
    }

    public void setFontColor(int i) {
        this.l = i;
        this.u = 1;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.h.d(i);
            this.f.b();
        }
    }

    public void setFontSize(int i) {
        this.m = i;
        this.u = 1;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.h.e(i);
            this.f.b();
        }
    }

    public void setPerspective(boolean z) {
        BmTextMarker bmTextMarker;
        this.y = z;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.g) == null || this.f == null) {
            return;
        }
        bmTextMarker.n(this.y ? 1 : 0);
        this.f.b();
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        this.j = latLng;
        this.u = 1;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.g == null || this.f == null) {
                return;
            }
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.j);
            this.g.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            this.f.b();
        }
    }

    public void setPriority(int i) {
        BmTextMarker bmTextMarker;
        this.E = i;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.g) == null || this.f == null) {
            return;
        }
        bmTextMarker.f((int) ((short) i));
        this.f.b();
    }

    public void setRotate(float f) {
        this.t = f;
        this.u = 1;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmTextMarker bmTextMarker = this.g;
        if (bmTextMarker == null || this.f == null) {
            return;
        }
        bmTextMarker.d(f);
        this.f.b();
    }

    public void setScale(float f) {
        BmTextMarker bmTextMarker;
        if (f < 0.0f) {
            f = 1.0f;
        }
        this.B = f;
        this.C = f;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.g) == null || this.f == null) {
            return;
        }
        bmTextMarker.e(f);
        this.f.b();
    }

    public void setScaleX(float f) {
        BmTextMarker bmTextMarker;
        if (f < 0.0f) {
            f = 1.0f;
        }
        this.B = f;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.g) == null || this.f == null) {
            return;
        }
        bmTextMarker.f(f);
        this.f.b();
    }

    public void setScaleY(float f) {
        BmTextMarker bmTextMarker;
        if (f < 0.0f) {
            f = 1.0f;
        }
        this.C = f;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.g) == null || this.f == null) {
            return;
        }
        bmTextMarker.g(f);
        this.f.b();
    }

    public void setStartLevel(int i) {
        BmTextMarker bmTextMarker;
        this.w = i;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.g) == null || this.f == null) {
            return;
        }
        bmTextMarker.b(i);
        this.f.b();
    }

    public void setText(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
        }
        this.i = str;
        this.u = 1;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.g.b(str);
            this.f.b();
        }
    }

    public void setTypeface(Typeface typeface) {
        this.n = typeface;
        this.u = 1;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.h.c(typeface.getStyle());
            this.f.b();
        }
    }

    public void setXOffset(int i) {
        BmTextMarker bmTextMarker;
        this.A = i;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.g) == null || this.f == null) {
            return;
        }
        bmTextMarker.l(i);
        this.f.b();
    }

    public void setYOffset(int i) {
        BmTextMarker bmTextMarker;
        this.z = i;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.g) == null || this.f == null) {
            return;
        }
        bmTextMarker.m(i);
        this.f.b();
    }

    public void startAnimation() {
        if (this.H == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.H.bmAnimation.start();
        this.f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        this.g = new BmTextMarker();
        this.h = new BmTextStyle();
        this.g.a(this);
        setDrawItem(this.g);
        super.toDrawItem();
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.j);
        this.g.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        this.g.b(this.i);
        this.h.c(this.n.getStyle());
        this.h.e(this.m);
        this.h.d(this.l);
        this.h.c(this.o);
        this.g.a(this.h);
        this.g.d(this.t);
        this.g.b(this.p);
        this.g.c(this.q);
        this.g.n(this.y ? 1 : 0);
        this.g.l(this.A);
        this.g.m(this.z);
        this.g.n(this.y ? 1 : 0);
        this.g.l(this.A);
        this.g.m(this.z);
        this.g.f(this.B);
        this.g.g(this.C);
        CollisionBehavior collisionBehavior = this.D;
        if (collisionBehavior != null) {
            this.g.e(collisionBehavior.ordinal());
        }
        this.g.f(this.E);
        Animation animation = this.H;
        if (animation != null) {
            this.g.a(animation.bmAnimation);
        }
        return this.g;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a() {
        Typeface typeface = this.n;
        if (typeface != null) {
            EnvDrawText.removeFontCache(typeface.hashCode());
        }
        return super.a();
    }
}
