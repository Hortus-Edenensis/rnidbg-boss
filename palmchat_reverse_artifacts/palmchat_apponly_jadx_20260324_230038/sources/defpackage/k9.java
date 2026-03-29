package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.zenmen.palmchat.location.LocationEx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class k9 implements ad3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MapView f18596a;
    public d74 b;
    public boolean c = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AMap.OnCameraChangeListener {
        public a() {
        }

        @Override // com.amap.api.maps2d.AMap.OnCameraChangeListener
        public void onCameraChange(CameraPosition cameraPosition) {
            if (k9.this.b != null) {
                d74 d74Var = k9.this.b;
                LatLng latLng = cameraPosition.target;
                d74Var.y(new LocationEx(latLng.latitude, latLng.longitude, AMapLocation.COORD_TYPE_GCJ02, "", ""));
            }
        }

        @Override // com.amap.api.maps2d.AMap.OnCameraChangeListener
        public void onCameraChangeFinish(CameraPosition cameraPosition) {
            if (k9.this.c && k9.this.b != null) {
                d74 d74Var = k9.this.b;
                LatLng latLng = cameraPosition.target;
                d74Var.M(new LocationEx(latLng.latitude, latLng.longitude, AMapLocation.COORD_TYPE_GCJ02, "", ""));
            }
            k9.this.c = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AMap.OnMapClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xi0 f18598a;

        public b(xi0 xi0Var) {
            this.f18598a = xi0Var;
        }

        @Override // com.amap.api.maps2d.AMap.OnMapClickListener
        public void onMapClick(LatLng latLng) {
            if (this.f18598a != null) {
                this.f18598a.h(new LocationEx(latLng.latitude, latLng.longitude, AMapLocation.COORD_TYPE_GCJ02, "", ""));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements AMap.OnMapLoadedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yi0 f18599a;

        public c(yi0 yi0Var) {
            this.f18599a = yi0Var;
        }

        @Override // com.amap.api.maps2d.AMap.OnMapLoadedListener
        public void onMapLoaded() {
            yi0 yi0Var = this.f18599a;
            if (yi0Var != null) {
                yi0Var.onMapLoaded();
            }
        }
    }

    @Override // defpackage.ad3
    public ed3 a(int i, LocationEx locationEx) {
        return d(i, locationEx, 0.5f, 0.8f, 0.0f);
    }

    @Override // defpackage.ad3
    public void b(LocationEx locationEx, long j) {
        this.c = false;
        MapView mapView = this.f18596a;
        if (mapView == null || locationEx == null) {
            return;
        }
        mapView.getMap().animateCamera(CameraUpdateFactory.changeLatLng(new LatLng(locationEx.getLatitude(), locationEx.getLongitude())), j, null);
    }

    @Override // defpackage.ad3
    public void c(float f, LocationEx locationEx) {
        MapView mapView = this.f18596a;
        if (mapView == null) {
            return;
        }
        mapView.getMap().moveCamera(CameraUpdateFactory.zoomTo(f));
    }

    @Override // defpackage.ad3
    public ed3 d(int i, LocationEx locationEx, float f, float f2, float f3) {
        if (this.f18596a == null || locationEx == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.draggable(false).position(new LatLng(locationEx.getLatitude(), locationEx.getLongitude())).icon(BitmapDescriptorFactory.fromResource(i)).anchor(f, f2).zIndex(f3);
        Marker markerAddMarker = this.f18596a.getMap().addMarker(markerOptions);
        ed3 ed3Var = new ed3();
        ed3Var.b = locationEx;
        ed3Var.f17281a = markerAddMarker;
        return ed3Var;
    }

    @Override // defpackage.ad3
    public ed3 e(Bitmap bitmap, LocationEx locationEx, float f, float f2, float f3, sc3 sc3Var) {
        if (this.f18596a == null || locationEx == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.draggable(false).position(new LatLng(locationEx.getLatitude(), locationEx.getLongitude())).icon(BitmapDescriptorFactory.fromBitmap(bitmap)).anchor(f, f2).zIndex(f3);
        Marker markerAddMarker = this.f18596a.getMap().addMarker(markerOptions);
        markerAddMarker.setObject(sc3Var);
        ed3 ed3Var = new ed3();
        ed3Var.f17281a = markerAddMarker;
        ed3Var.b = locationEx;
        return ed3Var;
    }

    @Override // defpackage.ad3
    public View f(Context context) {
        if (this.f18596a == null) {
            synchronized (this) {
                if (this.f18596a == null) {
                    MapView mapView = new MapView(context);
                    this.f18596a = mapView;
                    mapView.getMap().getUiSettings().setZoomControlsEnabled(false);
                    this.f18596a.getMap().getUiSettings().setMyLocationButtonEnabled(false);
                    this.f18596a.getMap().getUiSettings().setScaleControlsEnabled(true);
                    this.f18596a.getMap().moveCamera(CameraUpdateFactory.zoomTo(16.0f));
                    this.f18596a.getMap().setOnCameraChangeListener(new a());
                }
            }
        }
        return this.f18596a;
    }

    @Override // defpackage.ad3
    public void g(boolean z) {
        MapView mapView = this.f18596a;
        if (mapView != null) {
            mapView.getMap().getUiSettings().setAllGesturesEnabled(z);
        }
    }

    @Override // defpackage.ad3
    public void h(LocationEx locationEx) {
        this.c = false;
        MapView mapView = this.f18596a;
        if (mapView == null || locationEx == null) {
            return;
        }
        mapView.getMap().animateCamera(CameraUpdateFactory.changeLatLng(new LatLng(locationEx.getLatitude(), locationEx.getLongitude())), 2000L, null);
    }

    @Override // defpackage.ad3
    public void i(ed3 ed3Var, LocationEx locationEx) {
        Object obj;
        if (this.f18596a == null || ed3Var == null || (obj = ed3Var.f17281a) == null || !(obj instanceof Marker)) {
            return;
        }
        ((Marker) obj).setPosition(new LatLng(locationEx.getLatitude(), locationEx.getLongitude()));
    }

    @Override // defpackage.ad3
    public void j(d74 d74Var) {
        this.b = d74Var;
    }

    @Override // defpackage.ad3
    public void k(yi0 yi0Var) {
        MapView mapView = this.f18596a;
        if (mapView != null) {
            mapView.getMap().setOnMapLoadedListener(new c(yi0Var));
        }
    }

    @Override // defpackage.ad3
    public void l(LocationEx locationEx) {
        this.c = false;
        MapView mapView = this.f18596a;
        if (mapView == null || locationEx == null) {
            return;
        }
        mapView.getMap().moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(locationEx.getLatitude(), locationEx.getLongitude())));
    }

    @Override // defpackage.ad3
    public void m(xi0 xi0Var) {
        MapView mapView = this.f18596a;
        if (mapView != null) {
            mapView.getMap().setOnMapClickListener(new b(xi0Var));
        }
    }

    @Override // defpackage.ad3
    public void o(ed3 ed3Var) {
        Object obj;
        if (this.f18596a == null || ed3Var == null || (obj = ed3Var.f17281a) == null || !(obj instanceof Marker)) {
            return;
        }
        Marker marker = (Marker) obj;
        marker.remove();
        marker.destroy();
    }

    @Override // defpackage.ad3
    public void onCreate(Bundle bundle) {
        MapView mapView = this.f18596a;
        if (mapView != null) {
            mapView.onCreate(bundle);
        }
    }

    @Override // defpackage.ad3
    public void onDestroy() {
        MapView mapView = this.f18596a;
        if (mapView != null) {
            mapView.onDestroy();
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // defpackage.ad3
    public void onPause() {
        MapView mapView = this.f18596a;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    @Override // defpackage.ad3
    public void onResume() {
        MapView mapView = this.f18596a;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    @Override // defpackage.ad3
    public void onSaveInstanceState(Bundle bundle) {
        MapView mapView = this.f18596a;
        if (mapView != null) {
            mapView.onSaveInstanceState(bundle);
        }
    }

    @Override // defpackage.ad3
    public View p() {
        return this.f18596a;
    }

    @Override // defpackage.ad3
    public ed3 q(Bitmap bitmap, LocationEx locationEx, float f, float f2, float f3) {
        return e(bitmap, locationEx, f, f2, f3, null);
    }

    @Override // defpackage.ad3
    public void n(boolean z) {
    }
}
