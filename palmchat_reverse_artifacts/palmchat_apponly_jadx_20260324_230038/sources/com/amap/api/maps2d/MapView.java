package com.amap.api.maps2d;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.amap.api.col.p0002sl.ba;
import com.amap.api.col.p0002sl.ct;
import com.amap.api.col.p0002sl.hl;
import com.amap.api.interfaces.IAMap;
import com.amap.api.interfaces.IMapFragmentDelegate;
import com.amap.api.maps2d.model.RuntimeRemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class MapView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IMapFragmentDelegate f3087a;
    private AMap b;

    public MapView(Context context) {
        super(context);
        getMapFragmentDelegate().setContext(context);
    }

    public AMap getMap() {
        IMapFragmentDelegate mapFragmentDelegate = getMapFragmentDelegate();
        if (mapFragmentDelegate == null) {
            return null;
        }
        try {
            IAMap map = mapFragmentDelegate.getMap();
            if (map == null) {
                return null;
            }
            if (this.b == null) {
                this.b = new AMap(map);
            }
            return this.b;
        } catch (RemoteException e) {
            ct.a(e, "MapView", "getMap");
            throw new RuntimeRemoteException(e);
        }
    }

    public IMapFragmentDelegate getMapFragmentDelegate() {
        try {
            if (this.f3087a == null) {
                getContext();
                ct.a();
                this.f3087a = (IMapFragmentDelegate) hl.a();
            }
        } catch (Throwable unused) {
        }
        if (this.f3087a == null) {
            this.f3087a = new ba();
        }
        return this.f3087a;
    }

    public final void onCreate(Bundle bundle) {
        try {
            addView(getMapFragmentDelegate().onCreateView(null, null, bundle), new ViewGroup.LayoutParams(-1, -1));
        } catch (RemoteException e) {
            ct.a(e, "MapView", "onCreate");
        } catch (Throwable th) {
            ct.a(th, "MapView", "onCreate");
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
        } catch (RemoteException e) {
            ct.a(e, "MapView", "onDestroy");
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (RemoteException e) {
            ct.a(e, "MapView", "onLowMemory");
        }
    }

    public final void onPause() {
        try {
            getMapFragmentDelegate().onPause();
        } catch (RemoteException e) {
            ct.a(e, "MapView", "onPause");
        }
    }

    public final void onResume() {
        try {
            getMapFragmentDelegate().onResume();
        } catch (RemoteException e) {
            ct.a(e, "MapView", "onResume");
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().onSaveInstanceState(bundle);
        } catch (RemoteException e) {
            ct.a(e, "MapView", "onSaveInstanceState");
        }
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getMapFragmentDelegate().setContext(context);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        getMapFragmentDelegate().setContext(context);
    }

    public MapView(Context context, AMapOptions aMapOptions) {
        super(context);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setOptions(aMapOptions);
    }
}
