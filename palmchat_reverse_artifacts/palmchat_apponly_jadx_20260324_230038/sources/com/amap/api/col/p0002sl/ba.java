package com.amap.api.col.p0002sl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.interfaces.IAMap;
import com.amap.api.interfaces.IMapFragmentDelegate;
import com.amap.api.maps2d.AMapOptions;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.CameraPosition;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ba implements IMapFragmentDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Context f2628a;
    private IAMap b;
    private AMapOptions c;

    private static void a(Context context) {
        if (context != null) {
            f2628a = context.getApplicationContext();
        }
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public IAMap getMap() throws RemoteException {
        if (this.b == null) {
            if (f2628a == null) {
                throw new NullPointerException("Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
            }
            a();
            this.b = new m(f2628a);
        }
        return this.b;
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        byte[] byteArray;
        if (this.b == null) {
            if (f2628a == null && layoutInflater != null) {
                setContext(layoutInflater.getContext().getApplicationContext());
            }
            if (f2628a == null) {
                throw new NullPointerException("Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
            }
            a();
            this.b = new m(f2628a);
        }
        try {
            if (this.c == null && bundle != null && (byteArray = bundle.getByteArray("MapOptions")) != null) {
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(byteArray, 0, byteArray.length);
                parcelObtain.setDataPosition(0);
                this.c = AMapOptions.CREATOR.createFromParcel(parcelObtain);
            }
            a(this.c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.b.getView();
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onDestroy() throws RemoteException {
        if (getMap() != null) {
            getMap().clear();
            getMap().destroy();
        }
        setContext(null);
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onInflate(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        setContext(activity);
        this.c = aMapOptions;
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onLowMemory() throws RemoteException {
        Log.d("onLowMemory", "onLowMemory run");
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onPause() throws RemoteException {
        IAMap iAMap = this.b;
        if (iAMap != null) {
            iAMap.onPause();
        }
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onResume() throws RemoteException {
        IAMap iAMap = this.b;
        if (iAMap != null) {
            iAMap.onResume();
        }
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onSaveInstanceState(Bundle bundle) throws RemoteException {
        if (this.b != null) {
            if (this.c == null) {
                this.c = new AMapOptions();
            }
            this.c = this.c.camera(getMap().getCameraPosition());
            if (bundle != null) {
                try {
                    Parcel parcelObtain = Parcel.obtain();
                    this.c.writeToParcel(parcelObtain, 0);
                    bundle.putByteArray("MapOptions", parcelObtain.marshall());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void setContext(Context context) {
        a(context);
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void setOptions(AMapOptions aMapOptions) {
        this.c = aMapOptions;
    }

    private static void a() {
        int i = f2628a.getResources().getDisplayMetrics().densityDpi;
        z.l = i;
        if (i <= 320) {
            z.j = 256;
        } else if (i <= 480) {
            z.j = 384;
        } else {
            z.j = 512;
        }
        if (i <= 120) {
            z.f3056a = 0.5f;
        } else if (i <= 160) {
            z.f3056a = 0.6f;
        } else if (i <= 240) {
            z.f3056a = 0.87f;
        } else if (i <= 320) {
            z.f3056a = 1.0f;
        } else if (i <= 480) {
            z.f3056a = 1.5f;
        } else {
            z.f3056a = 1.8f;
        }
        if (z.f3056a <= 0.6f) {
            z.c = 18;
        }
    }

    private void a(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions == null || this.b == null) {
            return;
        }
        CameraPosition camera = aMapOptions.getCamera();
        if (camera != null) {
            this.b.moveCamera(new CameraUpdate(v.a(camera.target, camera.zoom, camera.bearing, camera.tilt)));
        }
        UiSettings aMapUiSettings = this.b.getAMapUiSettings();
        aMapUiSettings.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled().booleanValue());
        aMapUiSettings.setZoomControlsEnabled(aMapOptions.getZoomControlsEnabled().booleanValue());
        aMapUiSettings.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled().booleanValue());
        aMapUiSettings.setCompassEnabled(aMapOptions.getCompassEnabled().booleanValue());
        aMapUiSettings.setScaleControlsEnabled(aMapOptions.getScaleControlsEnabled().booleanValue());
        aMapUiSettings.setLogoPosition(aMapOptions.getLogoPosition());
        this.b.setMapType(aMapOptions.getMapType());
        this.b.setZOrderOnTop(aMapOptions.getZOrderOnTop().booleanValue());
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onDestroyView() throws RemoteException {
    }

    @Override // com.amap.api.interfaces.IMapFragmentDelegate
    public void onCreate(Bundle bundle) throws RemoteException {
    }
}
