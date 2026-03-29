package com.baidu.platform.comapi.map.c0;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapViewInterface;
import java.util.IllegalFormatException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4192a;
    private StringBuffer b = new StringBuffer();
    private StringBuffer c = new StringBuffer();
    private MapController d;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4193a;

        static {
            int[] iArr = new int[b.values().length];
            f4193a = iArr;
            try {
                iArr[b.MOVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4193a[b.FLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4193a[b.ZOOM_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4193a[b.ZOOM_IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4193a[b.ROTATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4193a[b.DOUBLE_CLICK_ZOOM_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4193a[b.TWO_CLICK_ZOOM_OUT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4193a[b.MOVE_OVERLOOK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        ZOOM_OUT,
        ZOOM_IN,
        FLING,
        MOVE,
        ROTATE,
        DOUBLE_CLICK_ZOOM_IN,
        TWO_CLICK_ZOOM_OUT,
        MOVE_OVERLOOK
    }

    public c(MapController mapController) {
        this.d = mapController;
    }

    private void d(float f) {
        this.f4192a = f;
    }

    private boolean e(float f) {
        return f < this.f4192a;
    }

    private boolean f(float f) {
        return f > this.f4192a;
    }

    public void a() {
        a(b.FLING);
    }

    public void b(float f) {
        a(b.TWO_CLICK_ZOOM_OUT);
        d(f);
    }

    public void c(float f) {
        if (f(f)) {
            a(b.ZOOM_OUT);
        }
        if (e(f)) {
            a(b.ZOOM_IN);
        }
        d(f);
    }

    public void a(float f) {
        a(b.DOUBLE_CLICK_ZOOM_IN);
        d(f);
    }

    public void d() {
        a(b.MOVE);
    }

    public void b() {
        a(b.MOVE_OVERLOOK);
    }

    private void a(b bVar) {
        MapViewInterface mapView;
        String strB;
        MapController mapController = this.d;
        if (mapController == null || (mapView = mapController.getMapView()) == null) {
            return;
        }
        GeoPoint mapCenter = mapView.getMapCenter();
        try {
            strB = String.format("(%s,%d,%d,%d,%d)", b(bVar), Double.valueOf(mapCenter.getLongitudeE6()), Double.valueOf(mapCenter.getLatitudeE6()), Integer.valueOf((int) mapView.getZoomLevel()), Long.valueOf(System.currentTimeMillis()));
        } catch (IllegalFormatException unused) {
            strB = b(bVar);
        }
        StringBuffer stringBuffer = this.b;
        if (stringBuffer == null) {
            return;
        }
        stringBuffer.append(strB);
        StringBuffer stringBuffer2 = this.c;
        if (stringBuffer2 == null) {
            return;
        }
        stringBuffer2.append(b(bVar));
    }

    private String b(b bVar) {
        switch (a.f4193a[bVar.ordinal()]) {
            case 1:
            case 2:
                return "0";
            case 3:
                return "1";
            case 4:
                return "2";
            case 5:
                return "3";
            case 6:
                return "4";
            case 7:
                return "5";
            case 8:
                return "6";
            default:
                return "";
        }
    }

    public void c() {
        a(b.ROTATE);
    }
}
