package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.md0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class kd0 implements AMap.OnMarkerClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AMap f18625a;
    public Context b;
    public List<jd0> c;
    public List<hd0> d;
    public int e;
    public id0 f;
    public md0 g;
    public List<Marker> h;
    public Map<String, Marker> i;
    public Map<String, hd0> j;
    public double k;
    public HandlerThread l;
    public HandlerThread m;
    public Handler n;
    public Handler o;
    public float p;
    public boolean q;
    public float r;
    public int s;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements md0.a {
        public a() {
        }

        @Override // md0.a
        public void a(hd0 hd0Var) {
            if (kd0.this.q) {
                return;
            }
            kd0.this.k(hd0Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public hd0 f18627a;
        public Bitmap b;

        public b() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                kd0.this.j((List) message.obj);
                return;
            }
            if (i == 1) {
                kd0.this.l((hd0) message.obj);
            } else if (i == 2) {
                kd0.this.C((hd0) message.obj);
            } else {
                if (i != 3) {
                    return;
                }
                kd0.this.B((b) message.obj);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                kd0.this.n();
            } else {
                if (i != 1) {
                    return;
                }
                jd0 jd0Var = (jd0) message.obj;
                kd0.this.c.add(jd0Var);
                Log.i("yiyi.qi", "calculate single cluster");
                kd0.this.o(jd0Var);
            }
        }
    }

    public kd0(AMap aMap, int i, Context context) {
        this(aMap, null, i, context);
    }

    public void A(float f) {
        this.r = f;
    }

    public final void B(b bVar) {
        hd0 hd0Var;
        Marker markerD;
        if (bVar == null || (hd0Var = bVar.f18627a) == null || bVar.b == null || (markerD = hd0Var.d()) == null) {
            return;
        }
        markerD.setIcon(BitmapDescriptorFactory.fromBitmap(bVar.b));
    }

    public final void C(hd0 hd0Var) {
        hd0Var.d().setIcon(r(hd0Var));
    }

    public void D(hd0 hd0Var, Bitmap bitmap) {
        if (hd0Var == null || bitmap == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        b bVar = new b();
        bVar.b = bitmap;
        bVar.f18627a = hd0Var;
        messageObtain.obj = bVar;
        this.n.removeMessages(3);
        this.n.sendMessageDelayed(messageObtain, 5L);
    }

    public final synchronized void j(List<hd0> list) {
        HashMap map = new HashMap();
        for (hd0 hd0Var : list) {
            if (this.q) {
                return;
            }
            Marker markerL = l(hd0Var);
            if (markerL != null) {
                map.put(this.g.a(hd0Var), markerL);
            }
        }
        x();
        this.i = map;
        p();
    }

    public final synchronized void k(hd0 hd0Var) {
        String strA = this.g.a(hd0Var);
        LatLng latLngB = hd0Var.b();
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.anchor(0.5f, 0.5f).icon(r(hd0Var)).position(latLngB);
        Marker markerAddMarker = this.f18625a.addMarker(markerOptions);
        markerAddMarker.setObject(hd0Var);
        markerAddMarker.setZIndex(this.r);
        hd0Var.f(markerAddMarker);
        this.i.put(strA, markerAddMarker);
    }

    public final synchronized Marker l(hd0 hd0Var) {
        String strA = this.g.a(hd0Var);
        if (this.j.containsKey(strA)) {
            return null;
        }
        if (this.i.containsKey(strA)) {
            return this.i.remove(strA);
        }
        if (this.g.drawAsync()) {
            this.j.put(strA, hd0Var);
            return null;
        }
        LatLng latLngB = hd0Var.b();
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.anchor(0.5f, 0.5f).icon(r(hd0Var)).position(latLngB);
        Marker markerAddMarker = this.f18625a.addMarker(markerOptions);
        markerAddMarker.setObject(hd0Var);
        markerAddMarker.setZIndex(this.r);
        hd0Var.f(markerAddMarker);
        return markerAddMarker;
    }

    public void m() {
        this.q = true;
        this.o.removeMessages(0);
        this.o.sendEmptyMessage(0);
    }

    public final void n() {
        this.q = false;
        this.d.clear();
        for (jd0 jd0Var : new ArrayList(this.c)) {
            if (this.q) {
                return;
            }
            LatLng position = jd0Var.getPosition();
            hd0 hd0VarS = s(position, this.d);
            if (hd0VarS != null) {
                hd0VarS.a(jd0Var);
            } else {
                hd0 hd0Var = new hd0(position);
                this.d.add(hd0Var);
                hd0Var.a(jd0Var);
            }
        }
        LogUtil.d("FindMapTripManager", "calculateClusters mClusters size " + this.d.size() + " mClusterItems size " + this.c.size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.d);
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = arrayList;
        if (this.q) {
            return;
        }
        this.n.sendMessage(messageObtain);
    }

    public final void o(jd0 jd0Var) {
        this.s++;
        LogUtil.d("Cluster", "calculateSingleCluster itemSize:" + this.s);
        LatLngBounds latLngBounds = this.f18625a.getProjection().getVisibleRegion().latLngBounds;
        LatLng position = jd0Var.getPosition();
        if (latLngBounds.contains(position)) {
            hd0 hd0VarS = s(position, this.d);
            if (hd0VarS != null) {
                hd0VarS.a(jd0Var);
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                messageObtain.obj = hd0VarS;
                this.n.removeMessages(2);
                this.n.sendMessageDelayed(messageObtain, 5L);
                LogUtil.d("Cluster", "has Cluster=================:" + this.d.size());
                return;
            }
            hd0 hd0Var = new hd0(position);
            this.d.add(hd0Var);
            hd0Var.a(jd0Var);
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 1;
            messageObtain2.obj = hd0Var;
            this.n.sendMessage(messageObtain2);
            LogUtil.d("Cluster", "new Cluster+++++++++++++++++++:" + this.d.size());
        }
    }

    @Override // com.amap.api.maps2d.AMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (this.f == null) {
            return true;
        }
        if (marker.getObject() == null) {
            return false;
        }
        if ((marker.getObject() instanceof sc3) && ((sc3) marker.getObject()).b == 1002 && marker.getPosition() != null) {
            LocationEx locationEx = new LocationEx();
            locationEx.setLongitude(marker.getPosition().longitude);
            locationEx.setLatitude(marker.getPosition().latitude);
            ((sc3) marker.getObject()).f20713a = locationEx;
        }
        this.f.a(marker, marker.getObject());
        return true;
    }

    public final void p() {
        for (String str : this.j.keySet()) {
            if (this.q) {
                this.j.clear();
                return;
            }
            this.g.b(this.j.get(str), new a());
        }
        this.j.clear();
    }

    public List<hd0> q() {
        return this.d;
    }

    public final BitmapDescriptor r(hd0 hd0Var) {
        return BitmapDescriptorFactory.fromBitmap(this.g.c(hd0Var));
    }

    public final hd0 s(LatLng latLng, List<hd0> list) {
        for (hd0 hd0Var : list) {
            double dCalculateLineDistance = AMapUtils.calculateLineDistance(latLng, hd0Var.b());
            LogUtil.d("Cluster", "distance:" + dCalculateLineDistance + " mClusterDistance:" + this.k);
            if (dCalculateLineDistance < this.k) {
                return hd0Var;
            }
        }
        return null;
    }

    public final void t() {
        this.l.start();
        this.m.start();
        this.n = new c(this.l.getLooper());
        this.o = new d(this.m.getLooper());
    }

    public void u() {
        this.q = true;
        this.o.removeCallbacksAndMessages(null);
        this.n.removeCallbacksAndMessages(null);
        this.m.quit();
        this.l.quit();
        Iterator<Marker> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().remove();
        }
        this.h.clear();
    }

    public void w(List<jd0> list) {
        this.p = this.f18625a.getScalePerPixel();
        this.k = r0 * this.e;
        this.c = list;
        m();
    }

    public final synchronized void x() {
        Iterator<String> it = this.i.keySet().iterator();
        while (it.hasNext()) {
            this.i.get(it.next()).remove();
        }
        this.i.clear();
    }

    public void y(md0 md0Var) {
        this.g = md0Var;
    }

    public void z(id0 id0Var) {
        this.f = id0Var;
    }

    public kd0(AMap aMap, List<jd0> list, int i, Context context) {
        this.h = new ArrayList();
        this.i = new HashMap();
        this.j = new HashMap();
        this.l = new HandlerThread("addMarker");
        this.m = new HandlerThread("calculateCluster");
        this.q = false;
        this.r = 0.0f;
        this.s = 0;
        if (list != null) {
            this.c = list;
        } else {
            this.c = new ArrayList();
        }
        this.b = context;
        this.d = new ArrayList();
        this.f18625a = aMap;
        this.e = i;
        this.p = aMap.getScalePerPixel();
        LogUtil.d("Cluster", "mClusterSize:" + this.e + " mPXInMeters:" + this.p);
        this.k = (double) (this.p * ((float) this.e));
        aMap.setOnMarkerClickListener(this);
        t();
    }

    public void v(LocationEx locationEx) {
    }
}
