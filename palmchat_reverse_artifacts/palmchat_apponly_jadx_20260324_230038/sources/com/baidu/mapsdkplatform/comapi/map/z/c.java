package com.baidu.mapsdkplatform.comapi.map.z;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.baidu.mapapi.map.BM3DModelOptions;
import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.map.track.TraceOptions;
import com.baidu.mapapi.map.track.TraceOverlay;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.a0;
import com.baidu.platform.comapi.map.q;
import com.baidu.platform.comapi.map.z;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comapi.util.i;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.z.a f3995a;
    private com.baidu.mapsdkplatform.comapi.map.b b;
    private int c;
    private TraceAnimationListener d;
    private com.baidu.mapsdkplatform.comapi.map.z.b f;
    private MapSurfaceView g;
    private MapTextureView h;
    private e e = new e();
    private volatile boolean i = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements com.baidu.mapsdkplatform.comapi.map.z.b {
        public a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.z.b
        public void a(TraceOverlay traceOverlay) {
            c.this.e(traceOverlay);
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.z.b
        public void b(TraceOverlay traceOverlay) {
            c.this.a();
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.z.b
        public void c(TraceOverlay traceOverlay) {
            c.this.c(traceOverlay);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TraceOverlay f3997a;

        public b(TraceOverlay traceOverlay) {
            this.f3997a = traceOverlay;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f3995a == null || c.this.b == null) {
                return;
            }
            c.this.d(this.f3997a);
            c.this.f3995a.a();
        }
    }

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.map.z.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class RunnableC0088c implements Runnable {
        public RunnableC0088c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f3995a.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TraceOverlay f3999a;

        public d(TraceOverlay traceOverlay) {
            this.f3999a = traceOverlay;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d(this.f3999a);
            c.this.f3995a.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"HandlerLeak"})
    public class e extends i {
        public e() {
            super(Looper.getMainLooper());
        }

        @Override // com.baidu.platform.comapi.util.i
        public void a(Message message) {
            int i = message.what;
            if (i != 65302) {
                if (i != 65303 || c.this.d == null) {
                    return;
                }
                c.this.d.onTraceUpdatePosition(CoordUtil.mc2ll(new GeoPoint(message.arg2 / 100.0f, message.arg1 / 100.0f)));
                return;
            }
            int i2 = message.arg1;
            if (i2 > 0 && i2 <= 1000 && c.this.d != null) {
                c.this.d.onTraceAnimationUpdate(message.arg1 / 10.0f);
            }
            if (message.arg2 != 1 || c.this.d == null) {
                return;
            }
            c.this.d.onTraceAnimationFinish();
        }
    }

    public c(MapSurfaceView mapSurfaceView) {
        this.c = 1;
        if (mapSurfaceView == null) {
            return;
        }
        this.f3995a = new com.baidu.mapsdkplatform.comapi.map.z.a();
        this.g = mapSurfaceView;
        this.b = mapSurfaceView.getBaseMap();
        mapSurfaceView.addOverlay(this.f3995a);
        this.f3995a.SetOverlayShow(true);
        this.c = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(TraceOverlay traceOverlay) {
        if (this.f3995a == null || traceOverlay == null) {
            return;
        }
        boolean zIsAnimate = traceOverlay.isAnimate();
        this.f3995a.a(zIsAnimate, traceOverlay.getAnimationTime(), traceOverlay.getAnimationDuration(), traceOverlay.getAnimationType());
        this.f3995a.b(traceOverlay.isRotateWhenTrack());
        q qVar = new q(new z().a(-15794282).b(14));
        qVar.a(b(traceOverlay));
        if (traceOverlay.isUseColorArray()) {
            qVar.a(traceOverlay.isUseColorArray());
            int[] iArrA = a(traceOverlay);
            for (int i = 0; i < iArrA.length; i++) {
                int i2 = iArrA[i];
                iArrA[i] = ((i2 >> 16) & 255) | ((-16777216) & i2) | ((i2 & 255) << 16) | (65280 & i2);
            }
            qVar.a(iArrA);
        }
        qVar.a(new a0().d(-1).a(traceOverlay.getColor()).b(traceOverlay.getWidth()));
        qVar.c = traceOverlay.isTrackMove();
        qVar.d = traceOverlay.isPointMove();
        qVar.e = !traceOverlay.isDataReduction();
        qVar.f = !traceOverlay.isDataSmooth();
        qVar.j = traceOverlay.isTrackBloom();
        qVar.k = traceOverlay.getBloomSpeed();
        qVar.a(zIsAnimate, traceOverlay.getAnimationTime(), traceOverlay.getAnimationType());
        if (traceOverlay.getIcon() != null) {
            qVar.h = false;
            this.f3995a.setParam(a(traceOverlay.getIcon().getBitmap()));
        }
        BM3DModelOptions icon3D = traceOverlay.getIcon3D();
        if (icon3D != null) {
            qVar.h = true;
            this.f3995a.setParam(a(icon3D));
        }
        this.f3995a.a(qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(TraceOverlay traceOverlay) {
        if (traceOverlay == null || this.f3995a == null) {
            return;
        }
        if (!traceOverlay.isStatusChanged()) {
            this.f3995a.clear();
            MapTaskManager.getDefaultThreadPool().execute(new d(traceOverlay));
        } else {
            this.f3995a.a(traceOverlay.isOnPause());
            this.f3995a.c(true);
            MapTaskManager.getDefaultThreadPool().execute(new RunnableC0088c());
        }
    }

    private List<GeoPoint> b(TraceOverlay traceOverlay) {
        if (traceOverlay == null || traceOverlay.getPoints() == null) {
            return null;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : traceOverlay.getPoints()) {
            arrayList.add(CoordUtil.ll2mc(latLng));
            builder.include(latLng);
        }
        return arrayList;
    }

    public TraceOverlay a(TraceOptions traceOptions) {
        if (traceOptions == null) {
            return null;
        }
        TraceOverlay overlay = traceOptions.getOverlay();
        overlay.mListener = this.f;
        MapTaskManager.getDefaultThreadPool().execute(new b(overlay));
        return overlay;
    }

    public void c() {
        this.f = new a();
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_PROGRESS, this.e);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_POSITION, this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(TraceOverlay traceOverlay) {
        if (traceOverlay != null && this.f3995a != null) {
            e();
        }
        return false;
    }

    public void a() {
        com.baidu.mapsdkplatform.comapi.map.z.a aVar = this.f3995a;
        if (aVar == null) {
            return;
        }
        aVar.clear();
        this.f3995a.a();
    }

    public void e() {
        MapTextureView mapTextureView;
        MapSurfaceView mapSurfaceView;
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_PROGRESS, this.e);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_POSITION, this.e);
        int i = this.c;
        if (i == 1 && (mapSurfaceView = this.g) != null) {
            mapSurfaceView.removeOverlay(this.f3995a);
        } else if (i == 2 && (mapTextureView = this.h) != null) {
            mapTextureView.removeOverlay(this.f3995a);
        }
        if (this.d != null) {
            this.d = null;
        }
        this.i = true;
    }

    private int[] a(TraceOverlay traceOverlay) {
        if (traceOverlay == null || traceOverlay.getColors() == null) {
            return null;
        }
        return traceOverlay.getColors();
    }

    public com.baidu.mapsdkplatform.comapi.map.z.a b() {
        return this.f3995a;
    }

    public c(MapTextureView mapTextureView) {
        this.c = 1;
        if (mapTextureView == null) {
            return;
        }
        this.f3995a = new com.baidu.mapsdkplatform.comapi.map.z.a();
        this.h = mapTextureView;
        this.b = mapTextureView.getBaseMap();
        mapTextureView.addOverlay(this.f3995a);
        this.f3995a.SetOverlayShow(true);
        this.c = 2;
    }

    public void a(TraceAnimationListener traceAnimationListener) {
        this.d = traceAnimationListener;
    }

    private Bundle a(Bitmap bitmap) {
        MessageDigest messageDigest = null;
        if (bitmap == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(WfConstant.EXTRA_KEY_IMAGE_WIDTH, bitmap.getWidth());
        bundle.putInt(WfConstant.EXTRA_KEY_IMAGE_HEIGHT, bitmap.getHeight());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
        bitmap.copyPixelsToBuffer(byteBufferAllocate);
        byte[] bArrArray = byteBufferAllocate.array();
        bundle.putByteArray("image_data", bArrArray);
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        if (messageDigest != null) {
            messageDigest.update(bArrArray, 0, bArrArray.length);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder("");
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toString((b2 & UByte.MAX_VALUE) + 256, 16).substring(1));
            }
            bundle.putString("image_hashcode", sb.toString());
        }
        return bundle;
    }

    private Bundle a(BM3DModelOptions bM3DModelOptions) {
        if (bM3DModelOptions == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("icon_3D", 1);
        bundle.putInt("modelType", bM3DModelOptions.getBM3DModelType().ordinal());
        bundle.putString("modelPath", bM3DModelOptions.getModelPath());
        bundle.putString("modelName", bM3DModelOptions.getModelName());
        bundle.putFloat("scale", bM3DModelOptions.getScale());
        bundle.putBoolean("zoomFixed", bM3DModelOptions.isZoomFixed());
        bundle.putInt("yawAxis", bM3DModelOptions.getYawAxis());
        bundle.putFloat("rotateX", bM3DModelOptions.getRotateX());
        bundle.putFloat("rotateY", bM3DModelOptions.getRotateY());
        bundle.putFloat("rotateZ", bM3DModelOptions.getRotateZ());
        bundle.putFloat("offsetX", bM3DModelOptions.getOffsetX());
        bundle.putFloat("offsetY", bM3DModelOptions.getOffsetY());
        bundle.putFloat("offsetZ", bM3DModelOptions.getOffsetZ());
        if (bM3DModelOptions.isSkeletonAnimationEnable()) {
            bundle.putInt("animationIndex", bM3DModelOptions.getAnimationIndex());
            bundle.putBoolean("animationIsEnable", bM3DModelOptions.isSkeletonAnimationEnable());
            bundle.putInt("animationRepeatCount", bM3DModelOptions.getAnimationRepeatCount());
            bundle.putFloat("animationSpeed", bM3DModelOptions.getAnimationSpeed());
        }
        return bundle;
    }

    public boolean d() {
        return this.i;
    }
}
