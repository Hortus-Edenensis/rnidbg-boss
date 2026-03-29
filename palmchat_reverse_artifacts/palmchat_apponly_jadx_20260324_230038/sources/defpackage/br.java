package defpackage;

import com.amap.api.maps2d.model.MyLocationStyle;
import com.kuaishou.weapon.p0.g;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.listui.list.BaseNetListBean;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.location.b;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class br<T extends BaseBean> extends ar<T> {
    public int c;
    public LocationEx d;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public long e = 0;
    public final int j = 49;
    public final int k = 73;

    public final boolean k() {
        if (Math.abs(ir5.b() - this.e) <= 500) {
            return true;
        }
        this.e = ir5.b();
        return false;
    }

    public boolean l() {
        this.h = tg4.b(c.b(), g.g);
        boolean zF = b.f(c.b());
        this.i = zF;
        boolean z = this.h && zF;
        this.g = z;
        return z;
    }

    public JSONObject m(String str) {
        HashMap map = new HashMap();
        map.put("native_err", str);
        return new JSONObject(map);
    }

    public final LocationScene n() {
        LocationScene locationScene = LocationScene.UNKNOWN_LOCATION_LIST;
        int i = this.f;
        return i == 48 ? LocationScene.TBA_FIND_RECOMMEND : i == 49 ? LocationScene.TBA_FIND_NEARBY : i == 1 ? LocationScene.TBA_SQUARE_RECOMMEND : i == 73 ? LocationScene.TBA_SQUARE_NEARBY : i == 74 ? LocationScene.TBA_SQUARE_FRIEND : (i == 6 || i == 7) ? LocationScene.TBA_SQUARE_TOPIC : locationScene;
    }

    public int o() {
        return this.c;
    }

    public boolean p() {
        return this.g && this.d != null;
    }

    public final void q(int i, int i2, String str) {
        int i3 = this.f;
        if (i3 == 49 || i3 == 73) {
            HashMap map = new HashMap();
            map.put("pageType", String.valueOf(this.f));
            map.put("status", String.valueOf(i));
            map.put("code", String.valueOf(i2));
            map.put(MyLocationStyle.ERROR_INFO, str);
            zn6.i("locationinfo_checkresult", map);
        }
    }

    public final void r() {
        int i = this.f;
        if (i == 49 || i == 73) {
            HashMap map = new HashMap();
            map.put("pageType", String.valueOf(this.f));
            zn6.i("locationinfo_check", map);
        }
    }

    public void s(int i) {
        HashMap map = new HashMap();
        map.put("type", String.valueOf(i));
        zn6.i("request_server_with_ip_location", map);
    }

    public abstract boolean t();

    public abstract boolean u();

    public boolean v() {
        return !p() && l();
    }

    public abstract void w(boolean z, ir<BaseNetListBean<T>> irVar);

    public void x(boolean z, ir<BaseNetListBean<T>> irVar) {
        if (this.c == 1) {
            return;
        }
        this.c = 1;
        boolean z2 = !z && k();
        LogUtil.i("BaseLocationListModel", "startLocation " + getClass() + " isRefresh=" + z + " isFast=" + z2 + " listener=" + irVar);
        if (z2 && irVar != null) {
            BaseNetListBean baseNetListBean = new BaseNetListBean();
            baseNetListBean.resultCode = BaseNetBean.NET_ERR_NATIVE_TOO_FAST;
            irVar.a(baseNetListBean);
            this.c = 2;
            return;
        }
        boolean zL = l();
        if (!u() && !zL) {
            this.d = null;
            w(z, irVar);
        } else if (!t() || !zL) {
            w(z, irVar);
        } else {
            r();
            d.g().k(n(), new a(z, irVar));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements i53 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1802a;
        public final /* synthetic */ ir b;

        public a(boolean z, ir irVar) {
            this.f1802a = z;
            this.b = irVar;
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
            int i2;
            LogUtil.i("BaseLocationListMode", "get location success " + locationEx);
            if (i != 0 || locationEx == null) {
                LocationEx locationExI = d.g().i(86400000L);
                if (locationExI != null) {
                    br.this.d = locationExI;
                    i2 = 2;
                } else {
                    i2 = 0;
                }
            } else {
                br.this.d = locationEx;
                i2 = 1;
            }
            br.this.q(i2, i, str);
            br.this.w(this.f1802a, this.b);
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }
}
