package com.baidu.platform.comapi.map.c0.f;

import android.graphics.Point;
import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.c0.a;
import com.baidu.platform.comapi.map.v;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.monitor.ErrorCode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class d extends a {
    private GeoPoint b;
    private int c;
    private float d;
    private Queue<a.c> e;
    private a.c f;
    private a.c g;
    private boolean h;
    private com.baidu.platform.comapi.map.c0.e.b i;
    private boolean j;
    private double k;
    private boolean l;
    private long m;

    public d(MapController mapController) {
        super(mapController);
        this.e = new LinkedList();
        this.h = false;
        this.j = false;
        this.k = 0.0d;
        this.l = false;
        this.m = 0L;
    }

    private void b(MapStatus mapStatus) {
        com.baidu.platform.comapi.map.c0.e.b bVar = this.i;
        double dAbs = Math.abs(new a.c(new a.C0104a(bVar.b.f4186a, bVar.c.f4186a), this.i.b).f4188a);
        com.baidu.platform.comapi.map.c0.e.b bVar2 = this.i;
        double dAbs2 = Math.abs(new a.c(new a.C0104a(bVar2.b.b, bVar2.c.b), this.i.b).f4188a);
        double d = this.k;
        boolean z = false;
        if (d != 0.0d && d * this.g.b < 0.0d) {
            return;
        }
        if (this.j) {
            mapStatus.rotation = (int) ((((double) this.c) + this.f.f4188a) % 360.0d);
        } else {
            double d2 = this.g.b;
            boolean z2 = (d2 < 1.0d && dAbs > 60.0d) || (d2 > 1.0d && Math.abs(dAbs - 180.0d) > 60.0d);
            double d3 = this.g.b;
            if ((d3 > 1.0d && dAbs2 > 60.0d) || (d3 < 1.0d && Math.abs(dAbs2 - 180.0d) > 60.0d)) {
                z = true;
            }
            if (z2 || z) {
                if (Math.abs(this.f.f4188a) > (MapController.isCompass ? 30 : 10)) {
                    this.j = true;
                    this.f4198a.getGestureMonitor().c();
                    this.c = (int) (((double) this.c) - this.f.f4188a);
                    if (MapController.isCompass) {
                        this.l = true;
                        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.a());
                    }
                }
            }
        }
        this.k = this.g.b;
    }

    private void c(MapStatus mapStatus) {
        float fLog = this.d + ((float) (Math.log(this.f.b) / Math.log(2.0d)));
        mapStatus.level = fLog;
        if (fLog < 4.0f) {
            fLog = 4.0f;
        }
        mapStatus.level = fLog;
        if (fLog > 22.0f) {
            fLog = 22.0f;
        }
        mapStatus.level = fLog;
    }

    @Override // com.baidu.platform.comapi.map.c0.f.a
    public void a(com.baidu.platform.comapi.map.c0.e.b bVar) {
        MapViewInterface mapView = this.f4198a.getMapView();
        if (mapView == null) {
            return;
        }
        MapStatus mapStatus = this.f4198a.getMapStatus();
        a.b bVarA = bVar.f4197a.a();
        this.b = mapView.getProjection().fromPixels((int) bVarA.f4187a, (int) bVarA.b);
        this.d = this.f4198a.getZoomLevel();
        this.c = mapStatus.rotation;
        this.k = 0.0d;
    }

    @Override // com.baidu.platform.comapi.map.c0.f.a
    public void a(com.baidu.platform.comapi.map.c0.e.b bVar, MotionEvent motionEvent) {
        this.i = bVar;
        this.f = new a.c(bVar.f4197a, bVar.c);
        this.g = new a.c(bVar.b, bVar.c);
        List<v> listeners = this.f4198a.getListeners();
        if (listeners != null) {
            s mapStatusInner = this.f4198a.getMapStatusInner();
            float x = motionEvent.getX(1) - motionEvent.getX(0);
            float y = motionEvent.getY(1) - motionEvent.getY(0);
            Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            Point point2 = new Point((int) (motionEvent.getRawX() + x), (int) (motionEvent.getRawY() + y));
            for (int i = 0; i < listeners.size(); i++) {
                v vVar = listeners.get(i);
                if (vVar != null && vVar.d(point, point2, mapStatusInner)) {
                    return;
                }
            }
        }
        MapStatus mapStatus = this.f4198a.getMapStatus();
        if (this.f4198a.isEnableZoom()) {
            c(mapStatus);
        }
        if (this.f4198a.is3DGestureEnable() && this.f4198a.getMapControlMode() != MapController.MapControlMode.STREET) {
            b(mapStatus);
        }
        if (mapStatus.overlooking == 0.0d && this.f4198a.isCanTouchMove()) {
            a(mapStatus);
        }
        this.f4198a.setMapStatus(mapStatus);
        if (this.f4198a.isNaviMode() && this.f4198a.getNaviMapViewListener() != null) {
            this.f4198a.getNaviMapViewListener().onAction(520, null);
        }
        this.f4198a.mapStatusChangeStart();
        if (this.e.size() >= 10) {
            this.e.poll();
        }
        this.e.offer(this.g);
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.d());
        this.m = System.currentTimeMillis();
    }

    private void a(MapStatus mapStatus) {
        MapViewInterface mapView;
        a.b bVarA;
        com.baidu.platform.comapi.basestruct.Point pixels;
        a.b bVarA2;
        com.baidu.platform.comapi.basestruct.Point pixels2;
        if (this.b != null) {
            if (Math.abs(this.g.c.f4189a) > 0.0d || Math.abs(this.g.c.b) > 0.0d) {
                a.b bVarA3 = this.i.f4197a.a();
                a.b bVarA4 = this.i.c.a();
                double d = bVarA4.f4187a - bVarA3.f4187a;
                double d2 = bVarA4.b - bVarA3.b;
                double dSqrt = Math.sqrt((d * d) + (d2 * d2));
                if ((!MapController.isCompass || dSqrt >= 100.0d) && (mapView = this.f4198a.getMapView()) != null) {
                    if (!MapController.isCompass && !this.l) {
                        MapController mapController = this.f4198a;
                        if (mapController != null && mapController.getPointGesturesCenter() != null) {
                            Point pointGesturesCenter = this.f4198a.getPointGesturesCenter();
                            if (pointGesturesCenter == null) {
                                return;
                            }
                            this.b = mapView.getProjection().fromPixels(pointGesturesCenter.x, pointGesturesCenter.y);
                            bVarA2 = new a.b(pointGesturesCenter.x, pointGesturesCenter.y);
                        } else {
                            MapController mapController2 = this.f4198a;
                            if (mapController2 != null && mapController2.getLatLngGesturesCenter() != null) {
                                GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f4198a.getLatLngGesturesCenter());
                                if (geoPointLl2mc == null || (pixels2 = this.f4198a.getMapView().getProjection().toPixels(geoPointLl2mc, null)) == null) {
                                    return;
                                }
                                Point point = new Point(pixels2.getIntX(), pixels2.getIntY());
                                this.b = geoPointLl2mc;
                                bVarA2 = new a.b(point.x, point.y);
                            } else {
                                bVarA2 = this.i.c.a();
                            }
                        }
                        if (bVarA2 == null) {
                            return;
                        }
                        mapStatus.centerPtX = this.b.getLongitude();
                        mapStatus.centerPtY = this.b.getLatitude();
                        mapStatus.xOffset = (float) (bVarA2.f4187a - ((double) ((mapStatus.winRound.left + (this.f4198a.getScreenWidth() / 2)) + mapStatus.xScreenOffset)));
                        mapStatus.yOffset = ((float) (bVarA2.b - ((double) ((mapStatus.winRound.top + (this.f4198a.getScreenHeight() / 2)) + mapStatus.yScreenOffset)))) * (-1.0f);
                        return;
                    }
                    this.l = false;
                    com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.a());
                    MapController mapController3 = this.f4198a;
                    if (mapController3 != null && mapController3.getPointGesturesCenter() != null) {
                        if (this.f4198a.getPointGesturesCenter() == null) {
                            return;
                        } else {
                            bVarA = new a.b(r8.x, r8.y);
                        }
                    } else {
                        MapController mapController4 = this.f4198a;
                        if (mapController4 != null && mapController4.getLatLngGesturesCenter() != null) {
                            GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.f4198a.getLatLngGesturesCenter());
                            if (geoPointLl2mc2 == null || (pixels = this.f4198a.getMapView().getProjection().toPixels(geoPointLl2mc2, null)) == null) {
                                return;
                            }
                            Point point2 = new Point(pixels.getIntX(), pixels.getIntY());
                            this.b = geoPointLl2mc2;
                            bVarA = new a.b(point2.x, point2.y);
                        } else {
                            bVarA = this.i.c.a();
                        }
                    }
                    if (bVarA == null) {
                        return;
                    }
                    this.b = mapView.getProjection().fromPixels((int) bVarA.f4187a, (int) bVarA.b);
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.c0.f.a
    public void a(com.baidu.platform.comapi.map.c0.e.b bVar, Pair<a.d, a.d> pair) {
        double d;
        double latitude;
        MapViewInterface mapView = this.f4198a.getMapView();
        if (mapView == null) {
            return;
        }
        MapStatus mapStatus = this.f4198a.getMapStatus();
        int x = (int) bVar.d.getX();
        int y = (int) bVar.d.getY();
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        GeoPoint geoPointFromPixels = mapView.getProjection().fromPixels((int) ((this.f4198a.getScreenWidth() / 2) + mapStatus.winRound.left + mapStatus.xScreenOffset), (int) ((this.f4198a.getScreenHeight() / 2) + mapStatus.winRound.top + mapStatus.yScreenOffset));
        if (geoPointFromPixels != null) {
            double longitude = geoPointFromPixels.getLongitude();
            latitude = geoPointFromPixels.getLatitude();
            d = longitude;
        } else {
            d = 0.0d;
            latitude = 0.0d;
        }
        this.f4198a.MapMsgProc(5, 1, (y << 16) | x, 0, 0, d, latitude, 0.0d, 0.0d);
        this.f4198a.getGestureMonitor().c(this.f4198a.getZoomLevel());
        if (System.currentTimeMillis() - this.m <= 100) {
            MapController mapController = this.f4198a;
            if (mapController.mIsInertialAnimation && mapController.isEnableZoom()) {
                a(this.f4198a.getMapStatus(), bVar, pair);
            }
        }
    }

    private int a() {
        if (!this.j) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.e);
        if (linkedList.size() < 2) {
            return 0;
        }
        int i = (int) (((a.c) linkedList.get(linkedList.size() - 2)).f4188a * 8.0d);
        if (i >= 180) {
            return MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT;
        }
        if (i <= -180) {
            return -179;
        }
        return i;
    }

    private void a(MapStatus mapStatus, int i) {
        if (i != 0) {
            mapStatus.rotation = (mapStatus.rotation + i) % 360;
            this.f4198a.setMapStatusWithAnimation(mapStatus, 600);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(MapStatus mapStatus, com.baidu.platform.comapi.map.c0.e.b bVar, Pair<a.d, a.d> pair) {
        double d;
        boolean z;
        double d2;
        a.c cVar;
        double d3;
        if (pair == null) {
            return;
        }
        int iA = a();
        a.d dVar = (a.d) pair.first;
        double d4 = dVar.f4189a;
        a.d dVar2 = (a.d) pair.second;
        double d5 = dVar2.f4189a;
        if (d4 * d5 > 0.0d && dVar.b * dVar2.b > 0.0d) {
            a(mapStatus, iA);
            return;
        }
        if (Math.abs(d4 - d5) >= 1.0d && Math.abs(((a.d) pair.first).b - ((a.d) pair.second).b) >= 1.0d) {
            double dAbs = Math.abs(new a.c(new a.C0104a(bVar.b.f4186a, bVar.c.f4186a), bVar.b).f4188a);
            double dAbs2 = Math.abs(new a.c(new a.C0104a(bVar.b.b, bVar.c.b), bVar.b).f4188a);
            double d6 = this.k;
            if (d6 != 0.0d) {
                d = dAbs;
                z = d6 * this.g.b < 0.0d;
                if (!z) {
                    a(mapStatus, iA);
                    return;
                }
                a.d dVar3 = (a.d) pair.first;
                double d7 = dVar3.f4189a;
                a.d dVar4 = (a.d) pair.second;
                double d8 = dVar4.f4189a;
                double d9 = (d7 * d7) + (d8 * d8);
                double d10 = dVar3.b;
                double d11 = d9 + (d10 * d10);
                double d12 = dVar4.b;
                float fSqrt = ((float) Math.sqrt(d11 + (d12 * d12))) * 2.0f;
                if (fSqrt > (SysOSUtil.getInstance().getDensityDPI() * 100) / MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME) {
                    mapStatus.hasAnimation = 1;
                    mapStatus.animationTime = 600;
                    a.c cVar2 = null;
                    a.c cVar3 = null;
                    int i = 0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < this.e.size(); i3++) {
                        a.c cVarPoll = this.e.poll();
                        if (cVarPoll != null) {
                            if (this.e.isEmpty()) {
                                cVar = cVar2;
                                d3 = 1.0d;
                                if (Math.abs(cVarPoll.b - 1.0d) < 0.01d) {
                                    a(mapStatus, iA);
                                    return;
                                }
                            } else {
                                cVar = cVar2;
                                d3 = 1.0d;
                            }
                            if (cVarPoll.b > d3) {
                                i++;
                                cVar2 = cVarPoll;
                            } else {
                                i2++;
                                cVar3 = cVarPoll;
                                cVar2 = cVar;
                            }
                        }
                    }
                    a.c cVar4 = i >= i2 ? cVar2 : cVar3;
                    if (cVar4 != null) {
                        d2 = 1.0d;
                        if (Math.abs(cVar4.b - 1.0d) < 0.01d) {
                            a(mapStatus, iA);
                            return;
                        }
                    } else {
                        d2 = 1.0d;
                    }
                    double d13 = cVar4.b;
                    boolean z2 = (d13 < d2 && d > 60.0d) || (d13 > d2 && Math.abs(d - 180.0d) > 60.0d);
                    double d14 = cVar4.b;
                    boolean z3 = (d14 > 1.0d && dAbs2 > 60.0d) || (d14 < 1.0d && Math.abs(dAbs2 - 180.0d) > 60.0d);
                    if (z2 || z3) {
                        if (Math.abs(this.f.f4188a) > (MapController.isCompass ? 30 : 15)) {
                            a(mapStatus, iA);
                            return;
                        }
                    }
                    this.h = cVar4.b > 1.0d;
                    float densityDPI = fSqrt / (ErrorCode.REASON_MS_OTHERS / SysOSUtil.getInstance().getDensityDPI());
                    float f = densityDPI > 2.0f ? 2.0f : densityDPI;
                    if (this.h) {
                        mapStatus.level += f;
                    } else {
                        mapStatus.level -= f;
                    }
                    float f2 = mapStatus.level;
                    if (f2 < 4.0f) {
                        f2 = 4.0f;
                    }
                    mapStatus.level = f2;
                    if (f2 > 22.0f) {
                        f2 = 22.0f;
                    }
                    mapStatus.level = f2;
                    if (iA != 0) {
                        mapStatus.rotation = (mapStatus.rotation + iA) % 360;
                    }
                    this.f4198a.setMapStatus(mapStatus);
                    this.f4198a.mIsAnimating = true;
                    return;
                }
                return;
            }
            d = dAbs;
            if (!z) {
            }
        } else {
            a(mapStatus, iA);
        }
    }
}
