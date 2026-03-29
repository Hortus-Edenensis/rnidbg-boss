package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.zenmen.palmchat.location.LocationEx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class yo implements ad3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MapView f22237a;
    public BaiduMap b;
    public d74 c;
    public yi0 d;
    public boolean e = false;
    public boolean f = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements BaiduMap.OnMapStatusChangeListener {
        public a() {
        }

        @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
        public void onMapStatusChange(MapStatus mapStatus) {
            if (yo.this.c != null) {
                LatLng latLng = mapStatus.target;
                yo.this.c.y(new LocationEx(latLng.latitude, latLng.longitude, "BD09LL", "", ""));
            }
        }

        @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
        public void onMapStatusChangeFinish(MapStatus mapStatus) {
            b05.a("onMapStatusChangeFinish开始-->" + yo.this.e);
            if (yo.this.f && yo.this.d != null) {
                yo.this.f = false;
                yo.this.d.onMapLoaded();
            }
            if (yo.this.e && yo.this.c != null) {
                LatLng latLng = mapStatus.target;
                yo.this.c.M(new LocationEx(latLng.latitude, latLng.longitude, "BD09LL", "", ""));
            }
            yo.this.e = true;
            b05.a("onMapStatusChangeFinish结束-->" + yo.this.e);
        }

        @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
        public void onMapStatusChangeStart(MapStatus mapStatus) {
        }

        @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
        public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationEx f22240a;

        public c(LocationEx locationEx) {
            this.f22240a = locationEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (yo.this.c != null) {
                yo.this.c.M(this.f22240a);
            }
        }
    }

    @Override // defpackage.ad3
    public ed3 a(int i, LocationEx locationEx) {
        return d(i, locationEx, 0.5f, 0.8f, 0.0f);
    }

    @Override // defpackage.ad3
    public void b(LocationEx locationEx, long j) {
        b05.a("moveTo");
        this.e = false;
        if (this.b == null || locationEx == null) {
            return;
        }
        this.b.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(locationEx.getLatitude(), locationEx.getLongitude())), (int) j);
    }

    @Override // defpackage.ad3
    public void c(float f, LocationEx locationEx) {
        b05.a("zoomTo");
        if (this.b != null) {
            MapStatusUpdate mapStatusUpdateZoomTo = MapStatusUpdateFactory.zoomTo(f);
            if (locationEx != null) {
                this.e = false;
                this.b.setMapStatus(mapStatusUpdateZoomTo);
            } else {
                this.b.animateMapStatus(mapStatusUpdateZoomTo);
            }
            if (this.c == null || locationEx == null) {
                return;
            }
            u93.b(100, new c(locationEx));
        }
    }

    @Override // defpackage.ad3
    public ed3 d(int i, LocationEx locationEx, float f, float f2, float f3) {
        if (this.b == null || locationEx == null) {
            return null;
        }
        Marker marker = (Marker) this.b.addOverlay(new MarkerOptions().position(new LatLng(locationEx.getLatitude(), locationEx.getLongitude())).icon(BitmapDescriptorFactory.fromResource(i)).anchor(f, f2).zIndex((int) f3));
        ed3 ed3Var = new ed3();
        ed3Var.b = locationEx;
        ed3Var.f17281a = marker;
        return ed3Var;
    }

    @Override // defpackage.ad3
    public ed3 e(Bitmap bitmap, LocationEx locationEx, float f, float f2, float f3, sc3 sc3Var) {
        Bundle bundle = null;
        if (this.b == null || locationEx == null) {
            return null;
        }
        BitmapDescriptor bitmapDescriptorFromBitmap = BitmapDescriptorFactory.fromBitmap(bitmap);
        LatLng latLng = new LatLng(locationEx.getLatitude(), locationEx.getLongitude());
        if (sc3Var != null) {
            bundle = new Bundle();
            bundle.putInt("mapClickTypeKey", sc3Var.b);
        }
        Marker marker = (Marker) this.b.addOverlay(new MarkerOptions().position(latLng).icon(bitmapDescriptorFromBitmap).anchor(f, f2).zIndex((int) f3).extraInfo(bundle));
        ed3 ed3Var = new ed3();
        ed3Var.f17281a = marker;
        ed3Var.b = locationEx;
        return ed3Var;
    }

    @Override // defpackage.ad3
    public View f(Context context) {
        if (this.f22237a == null) {
            synchronized (this) {
                if (this.f22237a == null) {
                    MapView mapView = new MapView(context);
                    this.f22237a = mapView;
                    BaiduMap map = mapView.getMap();
                    this.b = map;
                    map.getUiSettings().setCompassEnabled(false);
                    this.f22237a.showZoomControls(false);
                    this.f22237a.showScaleControl(true);
                    this.b.setMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().zoom(16.0f).build()));
                    this.b.setOnMapStatusChangeListener(new a());
                }
            }
        }
        return this.f22237a;
    }

    @Override // defpackage.ad3
    public void g(boolean z) {
        BaiduMap baiduMap = this.b;
        if (baiduMap != null) {
            UiSettings uiSettings = baiduMap.getUiSettings();
            uiSettings.setScrollGesturesEnabled(z);
            uiSettings.setZoomGesturesEnabled(z);
            uiSettings.setOverlookingGesturesEnabled(z);
        }
    }

    @Override // defpackage.ad3
    public void h(LocationEx locationEx) {
        b05.a("moveTo");
        this.e = false;
        if (this.b == null || locationEx == null) {
            return;
        }
        this.b.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(locationEx.getLatitude(), locationEx.getLongitude())), 2000);
    }

    @Override // defpackage.ad3
    public void i(ed3 ed3Var, LocationEx locationEx) {
        Object obj;
        if (this.b == null || ed3Var == null || (obj = ed3Var.f17281a) == null || !(obj instanceof Marker)) {
            return;
        }
        ((Marker) obj).setPosition(new LatLng(locationEx.getLatitude(), locationEx.getLongitude()));
    }

    @Override // defpackage.ad3
    public void j(d74 d74Var) {
        this.c = d74Var;
    }

    @Override // defpackage.ad3
    public void k(yi0 yi0Var) {
        this.d = yi0Var;
    }

    @Override // defpackage.ad3
    public void l(LocationEx locationEx) {
        this.e = false;
        if (this.b == null || locationEx == null) {
            return;
        }
        this.b.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(locationEx.getLatitude(), locationEx.getLongitude())));
    }

    @Override // defpackage.ad3
    public void m(xi0 xi0Var) {
        BaiduMap baiduMap = this.b;
        if (baiduMap != null) {
            baiduMap.setOnMapClickListener(new b(xi0Var));
        }
    }

    @Override // defpackage.ad3
    public void n(boolean z) {
        BaiduMap baiduMap = this.b;
        if (baiduMap != null) {
            baiduMap.getUiSettings().setRotateGesturesEnabled(z);
        }
    }

    @Override // defpackage.ad3
    public void o(ed3 ed3Var) {
        Object obj;
        if (this.b == null || ed3Var == null || (obj = ed3Var.f17281a) == null || !(obj instanceof Marker)) {
            return;
        }
        ((Marker) obj).remove();
    }

    @Override // defpackage.ad3
    public void onDestroy() {
        MapView mapView = this.f22237a;
        if (mapView != null) {
            mapView.onDestroy();
        }
        if (this.c != null) {
            this.c = null;
        }
    }

    @Override // defpackage.ad3
    public void onPause() {
        MapView mapView = this.f22237a;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    @Override // defpackage.ad3
    public void onResume() {
        MapView mapView = this.f22237a;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    @Override // defpackage.ad3
    public View p() {
        return this.f22237a;
    }

    @Override // defpackage.ad3
    public ed3 q(Bitmap bitmap, LocationEx locationEx, float f, float f2, float f3) {
        return e(bitmap, locationEx, f, f2, f3, null);
    }

    public BaiduMap x() {
        return this.b;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements BaiduMap.OnMapClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xi0 f22239a;

        public b(xi0 xi0Var) {
            this.f22239a = xi0Var;
        }

        @Override // com.baidu.mapapi.map.BaiduMap.OnMapClickListener
        public void onMapClick(LatLng latLng) {
            if (this.f22239a != null) {
                this.f22239a.h(new LocationEx(latLng.latitude, latLng.longitude, "BD09LL", "", ""));
            }
        }

        @Override // com.baidu.mapapi.map.BaiduMap.OnMapClickListener
        public void onMapPoiClick(MapPoi mapPoi) {
        }
    }

    @Override // defpackage.ad3
    public void onCreate(Bundle bundle) {
    }

    @Override // defpackage.ad3
    public void onSaveInstanceState(Bundle bundle) {
    }
}
