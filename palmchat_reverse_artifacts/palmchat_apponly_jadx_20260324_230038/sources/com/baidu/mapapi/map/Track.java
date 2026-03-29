package com.baidu.mapapi.map;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.bmsdk.BmTrack;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.animation.BmTrackAnimation;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmTrackStyle;
import com.baidu.platform.comapi.util.i;
import com.baidu.platform.comjni.engine.MessageProxy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class Track extends Overlay {
    TraceAnimationListener C;
    private c D;
    private BmTrack g;
    private BmGeoElement h;
    private BmTrackStyle i;
    List<Integer> m;
    List<LatLng> n;
    int[] o;
    int[] p;
    int q;
    private boolean z;
    private BmTrackAnimation.a j = new a();
    private BmAnimation.a k = new b();
    BmTrackAnimation l = new BmTrackAnimation();
    int r = 300;
    int s = 0;
    float t = 0.0f;
    int u = 5;
    int v = -1426128896;
    float w = 0.0f;
    float x = 0.0f;
    boolean y = false;
    BitmapDescriptor A = null;
    BitmapDescriptor B = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements BmTrackAnimation.a {
        public a() {
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmTrackAnimation.a
        public void a(com.baidu.platform.comapi.bmsdk.b bVar, float f, float f2) {
            if (Track.this.C != null) {
                Track.this.C.onTraceUpdatePosition(CoordUtil.mc2ll(new GeoPoint(bVar.b, bVar.f4118a)));
                Track.this.C.onTraceAnimationUpdate((float) (Math.round(((double) f2) * 1000.0d) / 10.0d));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"HandlerLeak"})
    public class c extends i {
        public c() {
            super(Looper.getMainLooper());
        }

        @Override // com.baidu.platform.comapi.util.i
        public void a(Message message) {
            TraceAnimationListener traceAnimationListener;
            int i = message.what;
            if (i != 65302) {
                if (i != 65303 || Track.this.C == null) {
                    return;
                }
                Track.this.C.onTraceUpdatePosition(CoordUtil.mc2ll(new GeoPoint(message.arg2 / 100.0f, message.arg1 / 100.0f)));
                return;
            }
            int i2 = message.arg1;
            if (i2 >= 0 && i2 <= 1000) {
                Track track = Track.this;
                float f = i2;
                track.t = f / 1000.0f;
                TraceAnimationListener traceAnimationListener2 = track.C;
                if (traceAnimationListener2 != null) {
                    traceAnimationListener2.onTraceAnimationUpdate(f / 10.0f);
                }
            }
            if (message.arg2 != 1 || (traceAnimationListener = Track.this.C) == null) {
                return;
            }
            traceAnimationListener.onTraceAnimationFinish();
        }
    }

    public Track() {
        c cVar = new c();
        this.D = cVar;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.track;
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_PROGRESS, cVar);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_POSITION, this.D);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        int i;
        super.a(bundle);
        List<LatLng> list = this.n;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add Track, you must at least supply 2 points");
        }
        Bundle bundle2 = new Bundle();
        BitmapDescriptor bitmapDescriptor = this.A;
        if (bitmapDescriptor != null) {
            bundle2.putBundle(String.format("texture_%d", 0), bitmapDescriptor.a());
            i = 1;
        } else {
            i = 0;
        }
        BitmapDescriptor bitmapDescriptor2 = this.B;
        if (bitmapDescriptor2 != null) {
            bundle2.putBundle(String.format("texture_%d", 1), bitmapDescriptor2.a());
            i++;
        }
        bundle2.putInt("total", i);
        bundle.putBundle("image_info_list", bundle2);
        bundle.putFloat("opacity", this.w);
        bundle.putFloat("paletteOpacity", this.x);
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.n.get(0));
        bundle.putDouble("location_x", geoPointLl2mc.getLongitudeE6());
        bundle.putDouble("location_y", geoPointLl2mc.getLatitudeE6());
        bundle.putInt("track_type", this.q);
        bundle.putFloat("animation_start_value", this.t);
        bundle.putBoolean("onPause", this.y);
        bundle.putInt("width", this.u);
        Overlay.c(this.n, bundle);
        if (this.q == 1) {
            bundle.putIntArray("color_array", this.p);
        }
        bundle.putIntArray("height_array", this.o);
        bundle.putInt("animation_time", this.r);
        bundle.putInt("animation_type", this.s);
        return bundle;
    }

    public void addTraceAnimationListener(TraceAnimationListener traceAnimationListener) {
        this.C = traceAnimationListener;
    }

    public void pause() {
        this.y = true;
        this.listener.c(this);
        this.l.pause();
        BmLayer bmLayer = this.f;
        if (bmLayer != null) {
            bmLayer.b();
        }
    }

    public void resume() {
        if (this.y) {
            this.y = false;
            this.listener.c(this);
            this.l.resume();
            BmLayer bmLayer = this.f;
            if (bmLayer != null) {
                bmLayer.b();
            }
        }
    }

    public void setAnimationListener(BmAnimation.a aVar) {
        this.k = aVar;
    }

    public void setTrackMove(boolean z) {
        this.z = z;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmTrack bmTrack = new BmTrack();
        this.g = bmTrack;
        bmTrack.a(this);
        setDrawItem(this.g);
        super.toDrawItem();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.n.size(); i++) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.n.get(i));
            arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6(), this.o[i]));
        }
        BmGeoElement bmGeoElement = new BmGeoElement(0);
        this.h = bmGeoElement;
        bmGeoElement.b(arrayList);
        BmTrackStyle bmTrackStyle = new BmTrackStyle();
        this.i = bmTrackStyle;
        bmTrackStyle.b(this.q);
        if (this.q == 6) {
            this.h.a(1, this.m);
        }
        this.i.c(this.u);
        this.i.a(this.v);
        if (this.B != null) {
            this.i.a(new BmBitmapResource(this.B.getBitmap()));
        }
        this.i.a(this.w);
        this.i.b(this.x);
        if (this.A != null) {
            this.i.b(new BmBitmapResource(this.A.getBitmap()));
        }
        this.h.a(this.i);
        this.g.a(this.h);
        this.l.setTrackPosRadio(0.0f, 1.0f);
        this.l.setDuration(this.r);
        this.l.setStartDelay(0L);
        this.l.setRepeatCount(0);
        this.l.setRepeatMode(1);
        this.l.setTrackUpdateListener(this.j);
        this.l.setAnimationListener(this.k);
        this.l.start();
        this.l.setSdkTrack(this.g);
        this.g.a(this.l);
        this.g.c(this.z);
        return this.g;
    }

    public void updateTrackZIndex(int i) {
        BmLayer bmLayer;
        this.c = i;
        BmTrack bmTrack = this.g;
        if (bmTrack == null || (bmLayer = this.f) == null || bmLayer.a(bmTrack.getName()) == null) {
            return;
        }
        this.f.a((BmDrawItem) this.g, (short) i);
        this.f.b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements BmAnimation.a {
        public b() {
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void b(BmAnimation bmAnimation) {
            TraceAnimationListener traceAnimationListener = Track.this.C;
            if (traceAnimationListener != null) {
                traceAnimationListener.onTraceAnimationFinish();
            }
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void a(BmAnimation bmAnimation) {
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void c(BmAnimation bmAnimation) {
        }
    }
}
