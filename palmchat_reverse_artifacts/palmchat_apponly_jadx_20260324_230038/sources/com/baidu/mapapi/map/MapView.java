package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.BMapManagerInternal;
import com.baidu.mapsdkplatform.comapi.MapAuthListener;
import com.baidu.mapsdkplatform.comapi.commonutils.AssetsLoadUtil;
import com.baidu.mapsdkplatform.comapi.map.c;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.mapsdkplatform.comapi.map.y;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.v;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comapi.util.h;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import java.io.File;
import java.util.HashMap;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class MapView extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3649a = "MapView";
    private static String b;
    private static int c;
    private static int d;
    private static final SparseIntArray e;
    private int A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private MapSurfaceView f;
    private BaiduMap g;
    private ImageView h;
    private Bitmap i;
    private y j;
    private Point k;
    private Point l;
    private RelativeLayout m;
    private TextView n;
    private TextView o;
    private ImageView p;
    private Context q;
    private final Object r;
    private boolean s;
    private MapAuthListener t;
    private int u;
    private boolean v;
    private boolean w;
    private float x;
    private int y;
    private int z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements MapAuthListener {
        public a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.MapAuthListener
        public void setAuthParam(String str) {
            synchronized (MapView.this.r) {
                if (MapView.this.s) {
                    return;
                }
                if (str != null) {
                    h.b().a(str, com.baidu.platform.comjni.base.sdkauth.a.ParkingSpace.a());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements c.InterfaceC0087c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CustomMapStyleCallBack f3651a;
        final /* synthetic */ MapCustomStyleOptions b;

        public b(CustomMapStyleCallBack customMapStyleCallBack, MapCustomStyleOptions mapCustomStyleOptions) {
            this.f3651a = customMapStyleCallBack;
            this.b = mapCustomStyleOptions;
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0087c
        public void onCustomMapStyleLoadFailed(int i, String str, String str2) {
            HashMap map = new HashMap();
            map.put("O", "local");
            map.put(ExifInterface.LONGITUDE_EAST, "0");
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "CS", "0", map);
            CustomMapStyleCallBack customMapStyleCallBack = this.f3651a;
            if ((customMapStyleCallBack == null || !customMapStyleCallBack.onCustomMapStyleLoadFailed(i, str, str2)) && !MapView.this.E) {
                MapView.this.a(str2, this.b);
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0087c
        public void onCustomMapStyleLoadSuccess(boolean z, String str) {
            HashMap map = new HashMap();
            map.put("O", "online");
            map.put(ExifInterface.LONGITUDE_EAST, "1");
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "CS", "0", map);
            CustomMapStyleCallBack customMapStyleCallBack = this.f3651a;
            if ((customMapStyleCallBack == null || !customMapStyleCallBack.onCustomMapStyleLoadSuccess(z, str)) && z && !TextUtils.isEmpty(str)) {
                MapView.this.a(str, "");
                MapView.this.setMapCustomStyleEnable(true);
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0087c
        public void onPreLoadLastCustomMapStyle(String str) {
            CustomMapStyleCallBack customMapStyleCallBack = this.f3651a;
            if (customMapStyleCallBack == null || !customMapStyleCallBack.onPreLoadLastCustomMapStyle(str)) {
                MapView.this.a(str, this.b);
                MapView.this.E = true;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements v {
        public c() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void d() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(MotionEvent motionEvent) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(s sVar) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c(s sVar) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void d(GeoPoint geoPoint) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(GeoPoint geoPoint) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(GeoPoint geoPoint) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c(GeoPoint geoPoint) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean d(Point point, Point point2, s sVar) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(GL10 gl10, s sVar) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(String str) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean c(Point point, Point point2, s sVar) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(boolean z) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean b(Point point, Point point2, s sVar) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(boolean z, int i) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(Point point, Point point2, s sVar) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(Point point, s sVar) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(MotionEvent motionEvent, float f, float f2, s sVar) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(BmDrawItem bmDrawItem) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(String str) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(s sVar) {
            if (MapView.this.f == null || MapView.this.f.getController() == null) {
                return;
            }
            float zoomLevel = MapView.this.f.getZoomLevel();
            if (zoomLevel < MapView.this.f.getController().mMinZoomLevel) {
                zoomLevel = MapView.this.f.getController().mMinZoomLevel;
            } else if (zoomLevel > MapView.this.f.getController().mMaxZoomLevel) {
                zoomLevel = MapView.this.f.getController().mMaxZoomLevel;
            }
            if (Math.abs(MapView.this.x - zoomLevel) > 0.0f) {
                MapView.this.updateScaleUI(zoomLevel);
            }
            MapView.this.a();
            MapView.this.requestLayout();
        }

        @Override // com.baidu.platform.comapi.map.v
        public void onFirstMapTileLoaded() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void e(GeoPoint geoPoint) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void f(GeoPoint geoPoint) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void g(GeoPoint geoPoint) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            float zoomLevel = MapView.this.f.getZoomLevel();
            float fFloor = zoomLevel - 1.0f;
            double d = zoomLevel;
            if (Math.floor(d) != d) {
                fFloor = (float) Math.floor(d);
            }
            if (MapView.this.f.getController() == null) {
                return;
            }
            float fMax = Math.max(fFloor, MapView.this.f.getController().mMinZoomLevel);
            BaiduMap.mapStatusReason |= 16;
            MapView.this.f.setZoomLevel(fMax);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            float zoomLevel = MapView.this.f.getZoomLevel();
            float fCeil = 1.0f + zoomLevel;
            double d = zoomLevel;
            if (((int) Math.ceil(d)) != ((int) zoomLevel)) {
                fCeil = (float) Math.ceil(d);
            }
            if (MapView.this.f.getController() == null) {
                return;
            }
            float fMin = Math.min(fCeil, MapView.this.f.getController().mMaxZoomLevel);
            BaiduMap.mapStatusReason |= 16;
            MapView.this.f.setZoomLevel(fMin);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f3655a;

        public f(View view) {
            this.f3655a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            MapView.this.removeView(this.f3655a);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        e = sparseIntArray;
        sparseIntArray.append(3, 2000000);
        sparseIntArray.append(4, 1000000);
        sparseIntArray.append(5, ErrorCode.REASON_RD_METADATA);
        sparseIntArray.append(6, ErrorCode.REASON_RD_AUDIO);
        sparseIntArray.append(7, 100000);
        sparseIntArray.append(8, 50000);
        sparseIntArray.append(9, 25000);
        sparseIntArray.append(10, 20000);
        sparseIntArray.append(11, 10000);
        sparseIntArray.append(12, 5000);
        sparseIntArray.append(13, 2000);
        sparseIntArray.append(14, 1000);
        sparseIntArray.append(15, 500);
        sparseIntArray.append(16, 200);
        sparseIntArray.append(17, 100);
        sparseIntArray.append(18, 50);
        sparseIntArray.append(19, 20);
        sparseIntArray.append(20, 10);
        sparseIntArray.append(21, 5);
        sparseIntArray.append(22, 2);
        sparseIntArray.append(23, 2);
        sparseIntArray.append(24, 2);
        sparseIntArray.append(25, 2);
        sparseIntArray.append(26, 2);
    }

    public MapView(Context context) {
        super(context);
        this.r = new Object();
        this.s = false;
        this.t = new a();
        this.u = LogoPosition.logoPostionleftBottom.ordinal();
        this.v = true;
        this.w = true;
        this.E = false;
        a(context, (BaiduMapOptions) null);
    }

    @Deprecated
    public static void setCustomMapStylePath(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
        }
        if (!new File(str).exists()) {
            throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
        }
        b = str;
    }

    @Deprecated
    public static void setIconCustom(int i) {
        d = i;
    }

    @Deprecated
    public static void setLoadCustomMapStyleFileMode(int i) {
        c = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MapViewLayoutParams) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            super.addView(view, layoutParams);
        }
    }

    public final LogoPosition getLogoPosition() {
        int i = this.u;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? LogoPosition.logoPostionleftBottom : LogoPosition.logoPostionRightTop : LogoPosition.logoPostionRightBottom : LogoPosition.logoPostionCenterTop : LogoPosition.logoPostionCenterBottom : LogoPosition.logoPostionleftTop;
    }

    public final BaiduMap getMap() {
        BaiduMap baiduMap = this.g;
        baiduMap.h0 = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return e.get(Math.round(this.f.getZoomLevel()));
    }

    public Point getScaleControlPosition() {
        return this.k;
    }

    public int getScaleControlViewHeight() {
        return this.C;
    }

    public int getScaleControlViewWidth() {
        return this.D;
    }

    public Point getZoomControlsPosition() {
        return this.l;
    }

    public boolean handleMultiTouch(float f2, float f3, float f4, float f5) {
        return false;
    }

    public boolean handleTouchMove(float f2, float f3) {
        return false;
    }

    public boolean handleTouchUp(float f2, float f3) {
        return false;
    }

    public boolean inRangeOfView(float f2, float f3) {
        MapSurfaceView mapSurfaceView = this.f;
        return mapSurfaceView != null && mapSurfaceView.inRangeOfView(f2, f3);
    }

    public boolean isSetBackgroundDraw() {
        MapSurfaceView mapSurfaceView = this.f;
        if (mapSurfaceView == null) {
            return false;
        }
        return mapSurfaceView.isSetBackgroundDraw();
    }

    public boolean isShowScaleControl() {
        return this.w;
    }

    public void onCreate(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (this.k != null) {
            this.k = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.l != null) {
            this.l = (Point) bundle.getParcelable("zoomPosition");
        }
        this.v = bundle.getBoolean("mZoomControlEnabled");
        this.w = bundle.getBoolean("mScaleControlEnabled");
        this.u = bundle.getInt("logoPosition");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
    }

    public final void onDestroy() {
        synchronized (this.r) {
            BaiduMap baiduMap = this.g;
            if (baiduMap != null) {
                baiduMap.d();
            }
            h.a();
            this.s = true;
            MapSurfaceView mapSurfaceView = this.f;
            if (mapSurfaceView != null) {
                mapSurfaceView.unInit();
            }
            Bitmap bitmap = this.i;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.i.recycle();
                this.i = null;
            }
            if (b != null) {
                b = null;
            }
            BMapManagerInternal.getInstance().removeMapAuthListener(this.t);
            this.j.d();
            BMapManager.destroy();
            com.baidu.mapsdkplatform.comapi.map.e.a();
            this.q = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float width;
        float height;
        int measuredHeight;
        int measuredWidth;
        int measuredWidth2;
        int childCount = getChildCount();
        a(this.h);
        if (((getWidth() - this.y) - this.z) - this.h.getMeasuredWidth() <= 0 || ((getHeight() - this.A) - this.B) - this.h.getMeasuredHeight() <= 0) {
            this.y = 0;
            this.z = 0;
            this.B = 0;
            this.A = 0;
            width = 1.0f;
            height = 1.0f;
        } else {
            width = ((getWidth() - this.y) - this.z) / getWidth();
            height = ((getHeight() - this.A) - this.B) / getHeight();
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                MapSurfaceView mapSurfaceView = this.f;
                if (childAt == mapSurfaceView) {
                    mapSurfaceView.layout(0, 0, getWidth(), getHeight());
                } else {
                    ImageView imageView = this.h;
                    if (childAt == imageView) {
                        float f2 = width * 5.0f;
                        int width2 = (int) (this.y + f2);
                        int i6 = (int) (this.z + f2);
                        float f3 = 5.0f * height;
                        int measuredHeight2 = (int) (this.A + f3);
                        int i7 = (int) (this.B + f3);
                        int i8 = this.u;
                        if (i8 == 1) {
                            measuredHeight = imageView.getMeasuredHeight() + measuredHeight2;
                            measuredWidth = this.h.getMeasuredWidth() + width2;
                        } else if (i8 == 2) {
                            measuredHeight = getHeight() - i7;
                            measuredHeight2 = measuredHeight - this.h.getMeasuredHeight();
                            width2 = (((getWidth() - this.h.getMeasuredWidth()) + this.y) - this.z) / 2;
                            measuredWidth = (((getWidth() + this.h.getMeasuredWidth()) + this.y) - this.z) / 2;
                        } else if (i8 != 3) {
                            if (i8 == 4) {
                                measuredHeight = getHeight() - i7;
                                measuredHeight2 = measuredHeight - this.h.getMeasuredHeight();
                                measuredWidth = getWidth() - i6;
                                measuredWidth2 = this.h.getMeasuredWidth();
                            } else if (i8 != 5) {
                                measuredHeight = getHeight() - i7;
                                measuredWidth = this.h.getMeasuredWidth() + width2;
                                measuredHeight2 = measuredHeight - this.h.getMeasuredHeight();
                            } else {
                                measuredHeight = measuredHeight2 + imageView.getMeasuredHeight();
                                measuredWidth = getWidth() - i6;
                                measuredWidth2 = this.h.getMeasuredWidth();
                            }
                            width2 = measuredWidth - measuredWidth2;
                        } else {
                            measuredHeight = measuredHeight2 + imageView.getMeasuredHeight();
                            width2 = (((getWidth() - this.h.getMeasuredWidth()) + this.y) - this.z) / 2;
                            measuredWidth = (((getWidth() + this.h.getMeasuredWidth()) + this.y) - this.z) / 2;
                        }
                        this.h.layout(width2, measuredHeight2, measuredWidth, measuredHeight);
                    } else {
                        y yVar = this.j;
                        if (childAt != yVar) {
                            RelativeLayout relativeLayout = this.m;
                            if (childAt == relativeLayout) {
                                a(relativeLayout);
                                Point point = this.k;
                                if (point == null) {
                                    this.D = this.m.getMeasuredWidth();
                                    this.C = this.m.getMeasuredHeight();
                                    int i9 = (int) (this.y + (5.0f * width));
                                    int height2 = (getHeight() - ((int) ((this.B + (height * 5.0f)) + 56.0f))) - this.h.getMeasuredHeight();
                                    this.m.layout(i9, height2, this.D + i9, this.C + height2);
                                } else {
                                    RelativeLayout relativeLayout2 = this.m;
                                    int i10 = point.x;
                                    relativeLayout2.layout(i10, point.y, relativeLayout2.getMeasuredWidth() + i10, this.k.y + this.m.getMeasuredHeight());
                                }
                            } else {
                                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                                if (layoutParams instanceof MapViewLayoutParams) {
                                    MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                    Point pointA = mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.b : this.f.getBaseMap() != null ? this.f.getBaseMap().a(CoordUtil.ll2mc(mapViewLayoutParams.f3656a)) : new Point();
                                    a(childAt);
                                    int measuredWidth3 = childAt.getMeasuredWidth();
                                    int measuredHeight3 = childAt.getMeasuredHeight();
                                    float f4 = mapViewLayoutParams.d;
                                    float f5 = mapViewLayoutParams.e;
                                    int i11 = ((int) (pointA.x - (f4 * measuredWidth3))) + mapViewLayoutParams.g;
                                    int i12 = ((int) (pointA.y - (f5 * measuredHeight3))) + mapViewLayoutParams.f;
                                    childAt.layout(i11, i12, measuredWidth3 + i11, measuredHeight3 + i12);
                                }
                            }
                        } else if (yVar.c()) {
                            a(this.j);
                            Point point2 = this.l;
                            if (point2 == null) {
                                int height3 = (int) (((getHeight() - 15) * height) + this.A);
                                int width3 = (int) (((getWidth() - 15) * width) + this.y);
                                int measuredWidth4 = width3 - this.j.getMeasuredWidth();
                                int measuredHeight4 = height3 - this.j.getMeasuredHeight();
                                if (this.u == 4) {
                                    height3 -= this.h.getMeasuredHeight();
                                    measuredHeight4 -= this.h.getMeasuredHeight();
                                }
                                this.j.layout(measuredWidth4, measuredHeight4, width3, height3);
                            } else {
                                y yVar2 = this.j;
                                int i13 = point2.x;
                                yVar2.layout(i13, point2.y, yVar2.getMeasuredWidth() + i13, this.l.y + this.j.getMeasuredHeight());
                            }
                        }
                    }
                }
            }
        }
    }

    public final void onPause() {
        this.f.onPause();
    }

    public final void onResume() {
        this.f.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle == null || (baiduMap = this.g) == null) {
            return;
        }
        bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
        bundle.putBoolean("mZoomControlEnabled", this.v);
        bundle.putBoolean("mScaleControlEnabled", this.w);
        bundle.putInt("logoPosition", this.u);
        bundle.putInt("paddingLeft", this.y);
        bundle.putInt("paddingTop", this.A);
        bundle.putInt("paddingRight", this.z);
        bundle.putInt("paddingBottom", this.B);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.h) {
            return;
        }
        if (d()) {
            super.removeView(view);
        } else {
            MapTaskManager.postToMainThread(new f(view), 0L);
        }
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            this.u = LogoPosition.logoPostionleftBottom.ordinal();
        } else {
            this.u = logoPosition.ordinal();
        }
        requestLayout();
    }

    public void setMapCustomStyle(MapCustomStyleOptions mapCustomStyleOptions, CustomMapStyleCallBack customMapStyleCallBack) {
        if (mapCustomStyleOptions == null) {
            return;
        }
        String customMapStyleId = mapCustomStyleOptions.getCustomMapStyleId();
        if (customMapStyleId != null && !customMapStyleId.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.map.c.a().a(this.q, customMapStyleId, new b(customMapStyleCallBack, mapCustomStyleOptions));
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (localCustomStyleFilePath == null || localCustomStyleFilePath.isEmpty()) {
            return;
        }
        a(localCustomStyleFilePath, "");
        setMapCustomStyleEnable(true);
    }

    public void setMapCustomStyleEnable(boolean z) {
        MapSurfaceView mapSurfaceView = this.f;
        if (mapSurfaceView == null || mapSurfaceView.getBaseMap() == null) {
            return;
        }
        this.f.getBaseMap().r(z);
    }

    public void setMapCustomStylePath(String str) {
        HashMap map = new HashMap();
        map.put("O", "local");
        map.put(ExifInterface.LONGITUDE_EAST, "1");
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "CS", "0", map);
        a(str, "");
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.y = i;
        this.A = i2;
        this.z = i3;
        this.B = i4;
    }

    public void setScaleControlPosition(Point point) {
        int i;
        if (point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.k = point;
            requestLayout();
        }
    }

    public void setSupBackgroundDraw(boolean z) {
        MapSurfaceView mapSurfaceView = this.f;
        if (mapSurfaceView == null) {
            return;
        }
        mapSurfaceView.setSupBackgroundDraw(z);
    }

    public void setUpViewEventToMapView(MotionEvent motionEvent) {
        this.f.onTouchEvent(motionEvent);
    }

    public final void setZOrderMediaOverlay(boolean z) {
        MapSurfaceView mapSurfaceView = this.f;
        if (mapSurfaceView == null) {
            return;
        }
        mapSurfaceView.setZOrderMediaOverlay(z);
    }

    public void setZoomControlsPosition(Point point) {
        int i;
        if (point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.l = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        this.m.setVisibility(z ? 0 : 8);
        this.w = z;
    }

    public void showZoomControls(boolean z) {
        if (this.j.c()) {
            this.j.setVisibility(z ? 0 : 8);
            this.v = z;
        }
    }

    public void updateScaleUI(float f2) {
        MapSurfaceView mapSurfaceView = this.f;
        if (mapSurfaceView == null || mapSurfaceView.getController() == null) {
            return;
        }
        int i = e.get(Math.round(f2));
        int zoomUnitsInMeter = (int) (((double) i) / this.f.getController().getZoomUnitsInMeter());
        ImageView imageView = this.p;
        if (imageView != null) {
            int i2 = zoomUnitsInMeter / 2;
            imageView.setPadding(i2, 0, i2, 0);
        }
        String str = i >= 1000 ? this.g.getMapLanguage() == MapLanguage.ENGLISH ? String.format(" %dkm ", Integer.valueOf(i / 1000)) : String.format(" %d公里 ", Integer.valueOf(i / 1000)) : this.g.getMapLanguage() == MapLanguage.ENGLISH ? String.format(" %dm ", Integer.valueOf(i)) : String.format(" %d米 ", Integer.valueOf(i));
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.o;
        if (textView2 != null) {
            textView2.setText(str);
        }
        this.x = f2;
    }

    private void b() {
        this.g.setMapLanguage(com.baidu.platform.comapi.c.b.c().b(), false);
    }

    private boolean c() {
        try {
            Class.forName("com.baidu.bmfmap.map.FlutterMapView");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean d() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private void e() {
        HashMap map = new HashMap();
        if (c()) {
            map.put(ExifInterface.GPS_DIRECTION_TRUE, "1");
        } else {
            map.put(ExifInterface.GPS_DIRECTION_TRUE, "0");
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "M", "0", map);
    }

    private void c(Context context) {
        y yVar = new y(context, false);
        this.j = yVar;
        if (yVar.c()) {
            this.j.setOnZoomOutClickListener(new d());
            this.j.setOnZoomInClickListener(new e());
            addView(this.j);
        }
    }

    private void b(Context context) {
        this.m = new RelativeLayout(context);
        this.m.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.n = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.n.setTextColor(Color.parseColor("#FFFFFF"));
        this.n.setTextSize(2, 11.0f);
        TextView textView = this.n;
        textView.setTypeface(textView.getTypeface(), 1);
        this.n.setLayoutParams(layoutParams);
        this.n.setId(Integer.MAX_VALUE);
        this.m.addView(this.n);
        this.o = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.addRule(14);
        this.o.setTextColor(Color.parseColor("#000000"));
        this.o.setTextSize(2, 11.0f);
        this.o.setLayoutParams(layoutParams2);
        this.m.addView(this.o);
        this.p = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, this.n.getId());
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setLayoutParams(layoutParams3);
            Bitmap bitmapLoadAssetsFile = AssetsLoadUtil.loadAssetsFile("icon_scale.9.png", context);
            if (bitmapLoadAssetsFile != null) {
                byte[] ninePatchChunk = bitmapLoadAssetsFile.getNinePatchChunk();
                if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                    this.p.setBackgroundDrawable(new NinePatchDrawable(bitmapLoadAssetsFile, ninePatchChunk, new Rect(), null));
                }
            }
            this.m.addView(this.p);
        }
        addView(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MapCustomStyleOptions mapCustomStyleOptions) {
        if (!TextUtils.isEmpty(str)) {
            a(str, "");
            setMapCustomStyleEnable(true);
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (TextUtils.isEmpty(localCustomStyleFilePath)) {
            return;
        }
        a(localCustomStyleFilePath, "");
        setMapCustomStyleEnable(true);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = new Object();
        this.s = false;
        this.t = new a();
        this.u = LogoPosition.logoPostionleftBottom.ordinal();
        this.v = true;
        this.w = true;
        this.E = false;
        a(context, (BaiduMapOptions) null);
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        LogoPosition logoPosition;
        this.q = context;
        com.baidu.mapsdkplatform.comapi.map.e.c();
        BMapManager.init();
        if (SysOSUtil.getAuthToken() != null) {
            synchronized (this.r) {
                h.b().a(SysOSUtil.getAuthToken(), com.baidu.platform.comjni.base.sdkauth.a.ParkingSpace.a() | com.baidu.platform.comjni.base.sdkauth.a.WaterMark.a());
                this.s = false;
            }
        } else {
            BMapManagerInternal.getInstance().setMapAuthListener(this.t);
            PermissionCheck.permissionCheck();
        }
        a(context, baiduMapOptions, b, c);
        a(context);
        c(context);
        if (baiduMapOptions != null && !baiduMapOptions.h) {
            this.j.setVisibility(4);
        }
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.i) {
            this.m.setVisibility(4);
        }
        if (baiduMapOptions != null && (logoPosition = baiduMapOptions.j) != null) {
            this.u = logoPosition.ordinal();
        }
        if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
            this.l = point2;
        }
        if (baiduMapOptions != null && (point = baiduMapOptions.k) != null) {
            this.k = point;
        }
        e();
        b();
    }

    public void cancelRenderMap() {
    }

    public void renderMap() {
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = new Object();
        this.s = false;
        this.t = new a();
        this.u = LogoPosition.logoPostionleftBottom.ordinal();
        this.v = true;
        this.w = true;
        this.E = false;
        a(context, (BaiduMapOptions) null);
    }

    @Deprecated
    public static void setMapCustomEnable(boolean z) {
    }

    public MapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        this.r = new Object();
        this.s = false;
        this.t = new a();
        this.u = LogoPosition.logoPostionleftBottom.ordinal();
        this.v = true;
        this.w = true;
        this.E = false;
        a(context, baiduMapOptions);
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i) {
        this.f = new MapSurfaceView(context);
        if (baiduMapOptions != null) {
            this.g = new BaiduMap(context, this.f, baiduMapOptions.a());
        } else {
            this.g = new BaiduMap(context, this.f, (q) null);
        }
        addView(this.f);
        c cVar = new c();
        if (this.f.getBaseMap() != null) {
            this.f.getBaseMap().a(cVar);
        }
    }

    private void a(Context context) {
        int densityDpi = SysOSUtil.getDensityDpi();
        Bitmap bitmapLoadAssetsFile = AssetsLoadUtil.loadAssetsFile(densityDpi < 180 ? "logo_l.png" : "logo_h.png", context);
        if (bitmapLoadAssetsFile == null) {
            return;
        }
        if (densityDpi > 480) {
            Matrix matrix = new Matrix();
            matrix.postScale(2.0f, 2.0f);
            this.i = Bitmap.createBitmap(bitmapLoadAssetsFile, 0, 0, bitmapLoadAssetsFile.getWidth(), bitmapLoadAssetsFile.getHeight(), matrix, true);
        } else if (densityDpi > 320) {
            Matrix matrix2 = new Matrix();
            matrix2.postScale(1.5f, 1.5f);
            this.i = Bitmap.createBitmap(bitmapLoadAssetsFile, 0, 0, bitmapLoadAssetsFile.getWidth(), bitmapLoadAssetsFile.getHeight(), matrix2, true);
        } else {
            this.i = bitmapLoadAssetsFile;
        }
        if (this.i != null) {
            ImageView imageView = new ImageView(context);
            this.h = imageView;
            imageView.setImageBitmap(this.i);
            addView(this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        y yVar = this.j;
        if (yVar == null || !yVar.c() || this.f.getBaseMap() == null) {
            return;
        }
        float f2 = this.f.getBaseMap().y().f3992a;
        this.j.setIsZoomOutEnabled(f2 > this.f.getBaseMap().e);
        this.j.setIsZoomInEnabled(f2 < this.f.getBaseMap().d);
    }

    private void a(View view) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i = layoutParams.width;
        if (i > 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        int i2 = layoutParams.height;
        if (i2 > 0) {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
    }

    public void handleTouchDown(float f2, float f3) {
    }

    public void setCustomStyleFilePathAndMode(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        MapSurfaceView mapSurfaceView = this.f;
        if (mapSurfaceView == null || mapSurfaceView.getBaseMap() == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(f3649a, "customStyleFilePath is empty or null, please check!");
            return;
        }
        if (!str.endsWith(".sty")) {
            Log.e(f3649a, "customStyleFile format is incorrect , please check!");
        } else if (!new File(str).exists()) {
            Log.e(f3649a, "customStyleFile does not exist , please check!");
        } else {
            this.f.getBaseMap().a(str, str2);
        }
    }
}
