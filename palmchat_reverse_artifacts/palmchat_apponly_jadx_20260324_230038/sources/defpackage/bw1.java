package defpackage;

import android.graphics.Point;
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.Projection;
import com.amap.api.maps2d.model.LatLng;
import com.google.gson.reflect.TypeToken;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.find.ConditionHelper;
import com.zenmen.find.bean.AvatarPayBean;
import com.zenmen.find.bean.CheckDriftBean;
import com.zenmen.find.bean.LoadCountBean;
import com.zenmen.find.bean.req.LoadNearMapReqBean;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bw1 {
    public static boolean g = false;
    public static DecimalFormat h = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f1832a;
    public LocationEx b;
    public LocationEx c;
    public BaseNetBean<LoadCountBean> d;
    public boolean e;
    public int f = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ei5<BaseNetBean<LoadCountBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationEx f1833a;
        public final /* synthetic */ float b;
        public final /* synthetic */ ad3 c;
        public final /* synthetic */ boolean d;

        /* JADX INFO: renamed from: bw1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0028a extends TypeToken<BaseNetBean<LoadCountBean>> {
            public C0028a() {
            }
        }

        public a(LocationEx locationEx, float f, ad3 ad3Var, boolean z) {
            this.f1833a = locationEx;
            this.b = f;
            this.c = ad3Var;
            this.d = z;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            LoadNearMapReqBean loadNearMapReqBean = new LoadNearMapReqBean();
            loadNearMapReqBean.longitude = this.f1833a.getLongitude();
            loadNearMapReqBean.latitude = this.f1833a.getLatitude();
            loadNearMapReqBean.zoomScale = this.b;
            loadNearMapReqBean.taichiV7 = bj5.b().a().Q("LX-50141");
            loadNearMapReqBean.pandaValueLx62476 = WkAdxAdConfigMg.DSP_NAME_CSJ;
            ContactInfoItem contactInfoItemF = v4.f();
            if (contactInfoItemF != null) {
                loadNearMapReqBean.gender = contactInfoItemF.getGender();
            }
            Point pointD = gi5.d();
            loadNearMapReqBean.avatarPoint = bw1.k(this.c, pointD.y, pointD.x, true);
            try {
                JSONObject jSONObject = new JSONObject(az2.c(loadNearMapReqBean));
                if (uj5.c()) {
                    ConditionHelper.getInstance().getNearByCond().mergeParams(jSONObject);
                }
                return jSONObject;
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }

        @Override // defpackage.ei5
        public BaseNetBean<LoadCountBean> handle(JSONObject jSONObject) {
            BaseNetBean<LoadCountBean> baseNetBeanCreateDefault = BaseNetBean.createDefault(jSONObject, new C0028a().getType());
            LoadCountBean loadCountBean = baseNetBeanCreateDefault.data;
            if (loadCountBean != null && loadCountBean.nearbyAvatar != null) {
                LatLng latLng = bw1.this.c != null ? new LatLng(bw1.this.c.getLatitude(), bw1.this.c.getLongitude()) : null;
                LatLng latLng2 = bw1.this.b != null ? new LatLng(bw1.this.b.getLatitude(), bw1.this.b.getLongitude()) : null;
                HashSet hashSet = new HashSet();
                for (LoadCountBean.MarkerBean markerBean : baseNetBeanCreateDefault.data.nearbyAvatar) {
                    markerBean.beanType = 1;
                    hashSet.add(Long.valueOf(markerBean.uid));
                    markerBean.isBlur = true;
                    if (latLng != null && bw1.this.e) {
                        float fCalculateLineDistance = AMapUtils.calculateLineDistance(markerBean.getLatLng(), latLng);
                        LogUtil.d("FindMap", "selfDistance " + fCalculateLineDistance);
                        LoadCountBean loadCountBean2 = baseNetBeanCreateDefault.data;
                        if (fCalculateLineDistance < loadCountBean2.clearAvatarMiMySelf || loadCountBean2.clearAvatarMiMySelf == -1.0f) {
                            markerBean.isBlur = false;
                        }
                    }
                    if (latLng2 != null) {
                        float fCalculateLineDistance2 = AMapUtils.calculateLineDistance(markerBean.getLatLng(), latLng2);
                        LogUtil.d("FindMap", "driftDistance " + fCalculateLineDistance2);
                        LoadCountBean loadCountBean3 = baseNetBeanCreateDefault.data;
                        if (fCalculateLineDistance2 < loadCountBean3.clearAvatarMi || loadCountBean3.clearAvatarMiMySelf == -1.0f) {
                            markerBean.isBlur = false;
                        }
                    }
                }
            }
            LoadCountBean loadCountBean4 = baseNetBeanCreateDefault.data;
            if (loadCountBean4 != null && loadCountBean4.nearbySchedule != null) {
                for (LoadCountBean.MarkerBean markerBean2 : loadCountBean4.nearbySchedule) {
                    markerBean2.beanType = 2;
                    if (bw1.this.c != null) {
                        markerBean2.distanceMi = String.format("%.2f", Float.valueOf(AMapUtils.calculateLineDistance(new LatLng(markerBean2.latitude, markerBean2.longitude), new LatLng(bw1.this.c.getLatitude(), bw1.this.c.getLongitude())) / 1000.0f));
                    }
                }
            }
            return baseNetBeanCreateDefault;
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean<LoadCountBean> baseNetBean) {
            if (bw1.this.f1832a != null) {
                bw1.this.d = baseNetBean;
                bw1.this.f1832a.X0(baseNetBean, this.d);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ei5<BaseNetBean<CheckDriftBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationEx f1835a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean<CheckDriftBean>> {
            public a() {
            }
        }

        public b(LocationEx locationEx, boolean z, int i) {
            this.f1835a = locationEx;
            this.b = z;
            this.c = i;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("longitude", Double.valueOf(this.f1835a.getLongitude()));
            map.put("latitude", Double.valueOf(this.f1835a.getLatitude()));
            map.put("taichiGroup", WkAdxAdConfigMg.DSP_NAME_CSJ);
            map.put("newTaichiGroup", bw1.n());
            map.put("nearbyPersonNum", Integer.valueOf(bw1.this.f));
            map.put("taichiGroup2", "A");
            map.put("taichiGroupLx66032", bj5.b().a().T("LX-66344", "A"));
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean<CheckDriftBean> handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean<CheckDriftBean> baseNetBean) {
            if (bw1.this.f1832a != null) {
                bw1.this.f1832a.Q0(baseNetBean, this.b, this.c);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements ei5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1838a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean> {
            public a() {
            }
        }

        public d(boolean z) {
            this.f1838a = z;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("showAvatar", Boolean.valueOf(this.f1838a));
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean baseNetBean) {
            if (bw1.this.f1832a != null) {
                bw1.this.f1832a.Z0(baseNetBean, this.f1838a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements ei5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadCountBean.MarkerBean f1840a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean<AvatarPayBean>> {
            public a() {
            }
        }

        public e(LoadCountBean.MarkerBean markerBean) {
            this.f1840a = markerBean;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("driftLongitude", Double.valueOf(this.f1840a.longitude));
            map.put("driftLatitude", Double.valueOf(this.f1840a.latitude));
            map.put("taichiGroup2", "A");
            map.put("taichiGroupLx66032", bj5.b().a().T("LX-66344", "A"));
            map.put("productId", Integer.valueOf(bj5.b().a().f()));
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean baseNetBean) {
            if (bw1.this.f1832a != null) {
                bw1.this.f1832a.q(baseNetBean, this.f1840a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void Q0(BaseNetBean<CheckDriftBean> baseNetBean, boolean z, int i);

        void X0(BaseNetBean<LoadCountBean> baseNetBean, boolean z);

        void Z0(BaseNetBean baseNetBean, boolean z);

        void q(BaseNetBean<AvatarPayBean> baseNetBean, LoadCountBean.MarkerBean markerBean);
    }

    public bw1(boolean z) {
        this.e = z;
    }

    public static pc3[] g(MapView mapView, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int measuredWidth = mapView.getMeasuredWidth();
        int measuredHeight = mapView.getMeasuredHeight();
        Projection projection = mapView.getMap().getProjection();
        pc3[] pc3VarArr = new pc3[i3 * i4];
        double d2 = measuredHeight / (i3 * 2);
        double d3 = measuredWidth / (i4 * 2);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i3) {
            int i8 = 0;
            while (i8 < i4) {
                Point point = new Point();
                double d4 = i5;
                int i9 = i6;
                point.x = (int) ((((double) i8) * d3 * 2.0d) + d4);
                point.y = (int) (d4 + (((double) i9) * d2 * 2.0d));
                LatLng latLngFromScreenLocation = projection.fromScreenLocation(point);
                LocationEx locationEx = new LocationEx();
                locationEx.setLatitude(latLngFromScreenLocation.latitude);
                locationEx.setLongitude(latLngFromScreenLocation.longitude);
                pc3 pc3Var = new pc3();
                pc3Var.f19991a = locationEx;
                pc3Var.b = point;
                pc3VarArr[i7] = pc3Var;
                i7++;
                i8++;
                i4 = i2;
                i6 = i9;
                i5 = 0;
            }
            i6++;
            i3 = i;
            i4 = i2;
            i5 = 0;
        }
        return pc3VarArr;
    }

    public static LocationEx[] h(com.baidu.mapapi.map.MapView mapView, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = i;
        int i6 = i2;
        int measuredWidth = mapView.getMeasuredWidth();
        int measuredHeight = mapView.getMeasuredHeight();
        com.baidu.mapapi.map.Projection projection = mapView.getMap().getProjection();
        LocationEx[] locationExArr = new LocationEx[i5 * i6];
        double d2 = measuredHeight / (i5 * 2);
        double d3 = measuredWidth / (i6 * 2);
        if (z) {
            i3 = (int) d2;
            i4 = (int) d3;
        } else {
            i3 = 0;
            i4 = 0;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            int i9 = 0;
            while (i9 < i6) {
                Point point = new Point();
                int i10 = i3;
                point.x = (int) (((double) i4) + (((double) i9) * d3 * 2.0d));
                double d4 = d3;
                point.y = (int) (((double) i10) + (((double) i7) * d2 * 2.0d));
                try {
                    com.baidu.mapapi.model.LatLng latLngFromScreenLocation = projection.fromScreenLocation(point);
                    LocationEx locationEx = new LocationEx();
                    locationEx.setLatitude(Double.parseDouble(h.format(latLngFromScreenLocation.latitude)));
                    locationEx.setLongitude(Double.parseDouble(h.format(latLngFromScreenLocation.longitude)));
                    locationExArr[i8] = locationEx;
                } catch (Exception unused) {
                }
                i8++;
                i9++;
                i6 = i2;
                i3 = i10;
                d3 = d4;
            }
            i7++;
            i5 = i;
            i6 = i2;
        }
        return locationExArr;
    }

    public static pc3[] i(com.baidu.mapapi.map.MapView mapView, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int measuredWidth = mapView.getMeasuredWidth();
        int measuredHeight = mapView.getMeasuredHeight();
        com.baidu.mapapi.map.Projection projection = mapView.getMap().getProjection();
        pc3[] pc3VarArr = new pc3[i3 * i4];
        double d2 = measuredHeight / (i3 * 2);
        double d3 = measuredWidth / (i4 * 2);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i3) {
            int i8 = 0;
            while (i8 < i4) {
                Point point = new Point();
                double d4 = i5;
                int i9 = i6;
                point.x = (int) ((((double) i8) * d3 * 2.0d) + d4);
                point.y = (int) (d4 + (((double) i9) * d2 * 2.0d));
                try {
                    com.baidu.mapapi.model.LatLng latLngFromScreenLocation = projection.fromScreenLocation(point);
                    LocationEx locationEx = new LocationEx();
                    locationEx.setLatitude(Double.parseDouble(h.format(latLngFromScreenLocation.latitude)));
                    locationEx.setLongitude(Double.parseDouble(h.format(latLngFromScreenLocation.longitude)));
                    pc3 pc3Var = new pc3();
                    pc3Var.f19991a = locationEx;
                    pc3Var.b = point;
                    pc3VarArr[i7] = pc3Var;
                    i7++;
                } catch (Exception unused) {
                }
                i8++;
                i4 = i2;
                i6 = i9;
                i5 = 0;
            }
            i6++;
            i3 = i;
            i4 = i2;
            i5 = 0;
        }
        return pc3VarArr;
    }

    public static LocationEx[] j(MapView mapView, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = i;
        int i6 = i2;
        int measuredWidth = mapView.getMeasuredWidth();
        int measuredHeight = mapView.getMeasuredHeight();
        Projection projection = mapView.getMap().getProjection();
        LocationEx[] locationExArr = new LocationEx[i5 * i6];
        double d2 = measuredHeight / (i5 * 2);
        double d3 = measuredWidth / (i6 * 2);
        if (z) {
            i3 = (int) d2;
            i4 = (int) d3;
        } else {
            i3 = 0;
            i4 = 0;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            int i9 = 0;
            while (i9 < i6) {
                Point point = new Point();
                int i10 = i3;
                point.x = (int) (((double) i4) + (((double) i9) * d3 * 2.0d));
                point.y = (int) (((double) i10) + (((double) i7) * d2 * 2.0d));
                LatLng latLngFromScreenLocation = projection.fromScreenLocation(point);
                LocationEx locationEx = new LocationEx();
                locationEx.setLatitude(latLngFromScreenLocation.latitude);
                locationEx.setLongitude(latLngFromScreenLocation.longitude);
                locationExArr[i8] = locationEx;
                i8++;
                i9++;
                i6 = i2;
                i3 = i10;
                d3 = d3;
            }
            i7++;
            i5 = i;
            i6 = i2;
        }
        return locationExArr;
    }

    public static LocationEx[] k(ad3 ad3Var, int i, int i2, boolean z) {
        return ad3Var instanceof yo ? h((com.baidu.mapapi.map.MapView) ad3Var.p(), i, i2, z) : j((MapView) ad3Var.p(), i, i2, z);
    }

    public static pc3[] l(ad3 ad3Var, int i, int i2) {
        return ad3Var instanceof yo ? i((com.baidu.mapapi.map.MapView) ad3Var.p(), i, i2) : g((MapView) ad3Var.p(), i, i2);
    }

    public static String n() {
        return g ? WkAdxAdConfigMg.DSP_NAME_BAIDU : bj5.b().a().T("LX-49252", "A");
    }

    public static boolean o() {
        return !"A".equals(n());
    }

    public void m(LocationEx locationEx, boolean z, int i) {
        bi5.p("lbs.square.map.find.person.check.v4", new b(locationEx, z, i));
    }

    public void p(LocationEx locationEx, float f2, ad3 ad3Var) {
        q(locationEx, f2, ad3Var, false);
    }

    public final void q(LocationEx locationEx, float f2, ad3 ad3Var, boolean z) {
        bi5.p("lbs.square.map.find.person.nearby.count.v7", new a(locationEx, f2, ad3Var, z));
    }

    public void r(LoadCountBean.MarkerBean markerBean) {
        if (markerBean == null) {
            return;
        }
        bi5.p("lbs.square.map.find.pay.for.click.avatar.v2", new e(markerBean));
    }

    public final void s() {
        BaseNetBean<LoadCountBean> baseNetBean;
        if (this.f1832a == null || (baseNetBean = this.d) == null || !baseNetBean.isSuccess() || this.d.data.nearbyAvatar == null) {
            return;
        }
        LatLng latLng = this.c != null ? new LatLng(this.c.getLatitude(), this.c.getLongitude()) : null;
        LatLng latLng2 = this.b != null ? new LatLng(this.b.getLatitude(), this.b.getLongitude()) : null;
        for (LoadCountBean.MarkerBean markerBean : this.d.data.nearbyAvatar) {
            markerBean.beanType = 1;
            markerBean.isBlur = true;
            if (latLng != null && this.e) {
                float fCalculateLineDistance = AMapUtils.calculateLineDistance(markerBean.getLatLng(), latLng);
                LogUtil.d("FindMap", "selfDistance " + fCalculateLineDistance);
                if (fCalculateLineDistance < this.d.data.clearAvatarMiMySelf) {
                    markerBean.isBlur = false;
                }
            }
            if (latLng2 != null) {
                float fCalculateLineDistance2 = AMapUtils.calculateLineDistance(markerBean.getLatLng(), latLng2);
                LogUtil.d("FindMap", "driftDistance " + fCalculateLineDistance2);
                if (fCalculateLineDistance2 < this.d.data.clearAvatarMi) {
                    markerBean.isBlur = false;
                }
            }
        }
        this.f1832a.X0(this.d, false);
    }

    public void t(LocationEx locationEx) {
        if (locationEx != null) {
            this.b = locationEx;
        }
    }

    public void u(f fVar) {
        this.f1832a = fVar;
    }

    public void v(int i) {
        this.f = i;
    }

    public void w(LocationEx locationEx) {
        if (locationEx != null) {
            this.c = locationEx;
        }
    }

    public void x(boolean z) {
        bi5.p("lbs.square.map.find.show.avatar.v1", new d(z));
    }

    public void y(boolean z) {
        this.e = z;
        s();
    }

    public void z() {
        bi5.p("lbs.square.map.find.person.close.tip.v1", new c());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ei5 {
        public c() {
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            return new JSONObject();
        }

        @Override // defpackage.ei5
        public BaseNetBean handle(JSONObject jSONObject) {
            return new BaseNetBean();
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean baseNetBean) {
        }
    }
}
