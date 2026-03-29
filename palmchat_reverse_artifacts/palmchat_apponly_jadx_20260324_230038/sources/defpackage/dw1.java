package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.reflect.TypeToken;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.find.ConditionHelper;
import com.zenmen.find.bean.CheckDriftBean;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.find.FindNearByMapActivity;
import com.zenmen.palmchat.activity.find.MapFindCountBean;
import com.zenmen.palmchat.activity.find.separation.MapBuySuccessModel;
import com.zenmen.palmchat.activity.find.separation.MapSeparationModel;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.giftkit.a;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.AliMapConfig;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.bean.UserrecommendTabs230414Config;
import com.zenmen.square.util.conf.MapFinderConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class dw1 {
    public static Bitmap A = null;
    public static Bitmap B = null;
    public static Bitmap C = null;
    public static Bitmap D = null;
    public static boolean E = false;
    public static boolean F = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17145a = "解锁附近的人";
    public static String b = "";
    public static String c = "";
    public static String d = "解锁后24小时有效";
    public static String e = "解锁后1小时有效";
    public static String f = "开始解锁";
    public static boolean g = false;
    public static BaseNetBean<CheckDriftBean> h = null;
    public static boolean i = true;
    public static boolean j = false;
    public static boolean k = false;
    public static String l = "附近xx人活跃 ，查看详情>";
    public static String m = "";
    public static String n = "";
    public static String o = "附近有xx人活跃，解锁查看详情>";
    public static String p = "解锁附近的人";
    public static int q = 172800;
    public static String r = "附近100+人活跃";
    public static String s = "这里有活跃信号，拖动地图查看";
    public static String t = "这个位置聊天的人可能很多";
    public static Bitmap u;
    public static Bitmap v;
    public static Bitmap w;
    public static Bitmap x;
    public static Bitmap y;
    public static Bitmap z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ei5<BaseNetBean<CheckDriftBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FindNearByMapActivity f17146a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: renamed from: dw1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1186a extends TypeToken<BaseNetBean<CheckDriftBean>> {
            public C1186a() {
            }
        }

        public a(FindNearByMapActivity findNearByMapActivity, boolean z) {
            this.f17146a = findNearByMapActivity;
            this.b = z;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("taichiGroup", WkAdxAdConfigMg.DSP_NAME_CSJ);
            map.put("newTaichiGroup", t66.h().e("LX-49252", "A"));
            map.put("nearbyPersonNum", 0);
            map.put("taichiGroup2", "A");
            map.put("taichiGroupLx66032", t66.h().e("LX-66344", "A"));
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean<CheckDriftBean> handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new C1186a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean<CheckDriftBean> baseNetBean) {
            CheckDriftBean checkDriftBean;
            CheckDriftBean checkDriftBean2;
            dw1.F = false;
            dw1.h = baseNetBean;
            if (baseNetBean != null && (checkDriftBean2 = baseNetBean.data) != null) {
                dw1.i = checkDriftBean2.freeStatus;
                LogUtil.d("FindMapPayManager", "startCharge getUnlockStatus onPostExecute isUnlockFree " + dw1.i + " " + az2.c(baseNetBean.data));
            }
            FindNearByMapActivity findNearByMapActivity = this.f17146a;
            if (findNearByMapActivity == null) {
                return;
            }
            TextView textView = (TextView) findNearByMapActivity.findViewById(R.id.map_finder_confirm_intro);
            String str = vc3.f21404a;
            if (dw1.i && gi5.g().mapFinder_button != null && this.f17146a != null) {
                String str2 = gi5.g().mapFinder_button.newfreeintro;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
            }
            textView.setText(str);
            LogUtil.d("FindMapPayManager", "startCharge onPostExecute curCheckDriftBean " + dw1.h + " fromCharge " + this.b + " confirmText " + str);
            if (this.b) {
                boolean z = (baseNetBean == null || (checkDriftBean = baseNetBean.data) == null) ? false : checkDriftBean.tipStatus;
                LogUtil.d("FindMapPayManager", "startCharge onPostExecute tipStatus " + z);
                if (z) {
                    FindNearByMapActivity findNearByMapActivity2 = this.f17146a;
                    if (findNearByMapActivity2 instanceof tc3) {
                        findNearByMapActivity2.B(dw1.g, dw1.h, false);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uc3 f17148a;

        public b(uc3 uc3Var) {
            this.f17148a = uc3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            this.f17148a.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f17149a;
        public final /* synthetic */ View b;
        public final /* synthetic */ View c;
        public final /* synthetic */ TextView d;
        public final /* synthetic */ TextView e;
        public final /* synthetic */ View f;
        public final /* synthetic */ View g;

        public c(int[] iArr, View view, View view2, TextView textView, TextView textView2, View view3, View view4) {
            this.f17149a = iArr;
            this.b = view;
            this.c = view2;
            this.d = textView;
            this.e = textView2;
            this.f = view3;
            this.g = view4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            int[] iArr = this.f17149a;
            if (iArr[0] == 2) {
                iArr[0] = 1;
                dw1.Q(1);
                this.b.setVisibility(0);
                this.c.setVisibility(8);
                this.d.setTextColor(Color.parseColor("#222222"));
                this.d.setTextSize(1, 20.0f);
                this.e.setTextColor(Color.parseColor("#999999"));
                this.e.setTextSize(1, 18.0f);
                this.f.setVisibility(8);
                this.g.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f17150a;
        public final /* synthetic */ View b;
        public final /* synthetic */ View c;
        public final /* synthetic */ TextView d;
        public final /* synthetic */ TextView e;
        public final /* synthetic */ View f;
        public final /* synthetic */ View g;

        public d(int[] iArr, View view, View view2, TextView textView, TextView textView2, View view3, View view4) {
            this.f17150a = iArr;
            this.b = view;
            this.c = view2;
            this.d = textView;
            this.e = textView2;
            this.f = view3;
            this.g = view4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            int[] iArr = this.f17150a;
            if (iArr[0] == 1) {
                iArr[0] = 2;
                dw1.Q(2);
                this.b.setVisibility(8);
                this.c.setVisibility(0);
                this.d.setTextColor(Color.parseColor("#999999"));
                this.d.setTextSize(1, 18.0f);
                this.e.setTextColor(Color.parseColor("#222222"));
                this.e.setTextSize(1, 20.0f);
                this.f.setVisibility(0);
                this.g.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends go2<LXBaseNetBean<MapBuySuccessModel>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationEx f17153a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wc3 c;
        public final /* synthetic */ FindNearByMapActivity d;

        public f(LocationEx locationEx, String str, wc3 wc3Var, FindNearByMapActivity findNearByMapActivity) {
            this.f17153a = locationEx;
            this.b = str;
            this.c = wc3Var;
            this.d = findNearByMapActivity;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return xc3.E(this.f17153a, this.b);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<MapBuySuccessModel> lXBaseNetBean, Exception exc) {
            int i;
            LogUtil.i("FindMapPayManager", "buySeparation info onResult=" + az2.c(lXBaseNetBean));
            if (!z || lXBaseNetBean == null || (i = lXBaseNetBean.resultCode) == -1004 || i != 0) {
                return;
            }
            xc3.O(this.c, lXBaseNetBean);
            FindNearByMapActivity findNearByMapActivity = this.d;
            if (findNearByMapActivity != null) {
                findNearByMapActivity.D3();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends go2<LXBaseNetBean<MapFindCountBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationEx f17154a;
        public final /* synthetic */ nc3 b;

        public g(LocationEx locationEx, nc3 nc3Var) {
            this.f17154a = locationEx;
            this.b = nc3Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put(DeviceInfoUtil.UID_TAG, v4.e(com.zenmen.palmchat.c.b()));
            LocationEx locationEx = this.f17154a;
            if (locationEx != null) {
                map.put("latitude", Double.valueOf(locationEx.getLatitude()));
                map.put("longitude", Double.valueOf(this.f17154a.getLongitude()));
            }
            return sw4.b(1, nl0.z + "/lbs.square.map.find.person.nearby.count.v1", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<MapFindCountBean> lXBaseNetBean, Exception exc) {
            MapFindCountBean mapFindCountBean;
            LogUtil.i("FindMapPayManager", "getNearCountPeople info onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean == null || (mapFindCountBean = lXBaseNetBean.data) == null) {
                this.b.a("");
                return;
            }
            int i = mapFindCountBean.nearbyCount;
            if (i == 0) {
                this.b.a("");
                return;
            }
            this.b.a(i + "");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationEx f17155a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ int c;

        public h(LocationEx locationEx, Activity activity, int i) {
            this.f17155a = locationEx;
            this.b = activity;
            this.c = i;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            dw1.m0(this.f17155a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uc3 f17156a;

        public i(uc3 uc3Var) {
            this.f17156a = uc3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            dw1.x();
            this.f17156a.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationEx f17157a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ int c;
        public final /* synthetic */ uc3 d;

        public j(LocationEx locationEx, Activity activity, int i, uc3 uc3Var) {
            this.f17157a = locationEx;
            this.b = activity;
            this.c = i;
            this.d = uc3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            dw1.y();
            dw1.m0(this.f17157a, this.b, this.c);
            this.d.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uc3 f17158a;

        public k(uc3 uc3Var) {
            this.f17158a = uc3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (dw1.i) {
                dw1.S();
            } else {
                dw1.V();
            }
            this.f17158a.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends go2<LXBaseNetBean<CheckDriftBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationEx f17159a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Activity c;

        public l(LocationEx locationEx, int i, Activity activity) {
            this.f17159a = locationEx;
            this.b = i;
            this.c = activity;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put(DeviceInfoUtil.UID_TAG, v4.e(com.zenmen.palmchat.c.b()));
            LocationEx locationEx = this.f17159a;
            if (locationEx != null) {
                map.put("latitude", Double.valueOf(locationEx.getLatitude()));
                map.put("longitude", Double.valueOf(this.f17159a.getLongitude()));
            }
            map.put("taichiGroup", WkAdxAdConfigMg.DSP_NAME_CSJ);
            map.put("newTaichiGroup", bj5.b().a().T("LX-49252", "A"));
            map.put("nearbyPersonNum", Integer.valueOf(this.b));
            map.put("taichiGroup2", "A");
            map.put("taichiGroupLx66032", bj5.b().a().T("LX-66344", "A"));
            return sw4.b(1, nl0.z + "/lbs.square.map.find.person.check.v4", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<CheckDriftBean> lXBaseNetBean, Exception exc) {
            CheckDriftBean checkDriftBean;
            LogUtil.i("FindMapPayManager", "unlockMapFindLocation info onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean == null || (checkDriftBean = lXBaseNetBean.data) == null) {
                return;
            }
            if (!checkDriftBean.enoughBean) {
                dw1.k0(checkDriftBean.priceBean, this.f17159a, this.c, this.b);
                return;
            }
            ve.o(this.c, (dw1.l() && UserrecommendTabs230414Config.getUserrecommendTabs230414Config().mapfinder.show_Switch) ? "zenxin://activity?page=a0406&openMap=false&subTabName=mapfinder" : "zenxin://activity?page=a0406&openMap=false", false);
            ConditionHelper.getInstance().setDriftInfo(this.f17159a, true, true, 1);
            Activity activity = this.c;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements a.InterfaceC1055a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationEx f17160a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ int c;

        public m(LocationEx locationEx, Activity activity, int i) {
            this.f17160a = locationEx;
            this.b = activity;
            this.c = i;
        }

        @Override // com.zenmen.palmchat.giftkit.a.InterfaceC1055a
        public void a(boolean z) {
            LogUtil.d("", "FindMapPayManager startCharge result success " + z);
            if (z) {
                dw1.m0(this.f17160a, this.b, this.c);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ tc3 f17161a;
        public final /* synthetic */ uc3 b;

        public n(tc3 tc3Var, uc3 uc3Var) {
            this.f17161a = tc3Var;
            this.b = uc3Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            LogUtil.d("FindMapPayManager", "startCharge unlockOneClick curCheckDriftBean " + dw1.h);
            if (dw1.h != null) {
                dw1.n0(dw1.h, this.f17161a);
                if (dw1.h.data == 0 || !((CheckDriftBean) dw1.h.data).enoughBean || this.b == null) {
                    return;
                }
                LogUtil.d("FindMapPayManager", "startCharge unlockOneClick curCheckDriftBean.data.enoughBean ");
                this.b.dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ tc3 f17162a;
        public final /* synthetic */ uc3 b;

        public o(tc3 tc3Var, uc3 uc3Var) {
            this.f17162a = tc3Var;
            this.b = uc3Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            LogUtil.d("FindMapPayManager", "startCharge unlockAlwaysClick curCheckDriftBean " + dw1.h);
            if (dw1.h != null) {
                dw1.l0(dw1.h, this.f17162a);
                if (dw1.h.data == 0 || !((CheckDriftBean) dw1.h.data).enoughBean || this.b == null) {
                    return;
                }
                LogUtil.d("FindMapPayManager", "startCharge unlockAlwaysClick curCheckDriftBean.data.enoughBean ");
                this.b.dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements ei5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f17163a;
        public final /* synthetic */ int b;

        public p(int i, int i2) {
            this.f17163a = i;
            this.b = i2;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("tipType", Integer.valueOf(this.f17163a));
            map.put("status", Integer.valueOf(this.b));
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean handle(JSONObject jSONObject) {
            return new BaseNetBean();
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean baseNetBean) {
            if (baseNetBean != null) {
                LogUtil.d("FindMapPayManager", "postCloseTip baseNetBean" + baseNetBean.resultCode);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FindNearByMapActivity f17165a;

        public r(FindNearByMapActivity findNearByMapActivity) {
            this.f17165a = findNearByMapActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            dw1.P();
            dw1.g0(this.f17165a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FindNearByMapActivity f17166a;

        public s(FindNearByMapActivity findNearByMapActivity) {
            this.f17166a = findNearByMapActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            dw1.Y();
            this.f17166a.D3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FindNearByMapActivity f17167a;

        public t(FindNearByMapActivity findNearByMapActivity) {
            this.f17167a = findNearByMapActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            dw1.e0(this.f17167a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FindNearByMapActivity f17168a;

        public u(FindNearByMapActivity findNearByMapActivity) {
            this.f17168a = findNearByMapActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            dw1.d0(this.f17168a);
        }
    }

    public static void A(Context context, LocationEx locationEx, String str, BaseNetBean<CheckDriftBean> baseNetBean, boolean z2, tc3 tc3Var, int i2, int i3) {
        LogUtil.d("FindMapPayManager", "getGeocodeSearch distanceKm " + str + " location " + locationEx);
        if (context == null || locationEx == null) {
            j0(baseNetBean, context, str, "", z2, tc3Var, i2, i3);
        } else {
            F("MapPayManager getGeocodeSearch", context, new q(baseNetBean, context, str, z2, tc3Var, i2, i3), locationEx);
        }
    }

    public static void B(nc3 nc3Var, LocationEx locationEx) {
        if (locationEx == null || nc3Var == null) {
            return;
        }
        zw4.e(new g(locationEx, nc3Var));
    }

    public static int C() {
        return 0;
    }

    public static int D() {
        return 0;
    }

    public static String E() {
        return WkAdxAdConfigMg.DSP_NAME_BAIDU;
    }

    public static void F(String str, Context context, i53 i53Var, LocationEx locationEx) {
        if (context == null || locationEx == null || i53Var == null) {
            return;
        }
        LogUtil.d(AliMapConfig.TAG, "getRealAddressByLocation result :" + str);
        com.zenmen.palmchat.location.b bVarA = com.zenmen.palmchat.location.b.a(context, null, LocationScene.FIND_MAP);
        bVarA.i(i53Var);
        bVarA.h(locationEx);
    }

    public static void G(wc3 wc3Var, FindNearByMapActivity findNearByMapActivity, LocationEx locationEx) {
        zw4.e(new e(wc3Var, findNearByMapActivity, locationEx));
    }

    public static void H(FindNearByMapActivity findNearByMapActivity, boolean z2) {
        if (F) {
            return;
        }
        F = true;
        bi5.p("lbs.square.map.find.person.check.v4", new a(findNearByMapActivity, z2));
    }

    public static void I() {
        if (u == null) {
            u = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.map_find_guide_bg_1), a46.b(AppContext.getContext(), 91.0f), a46.b(AppContext.getContext(), 64.0f), false);
        }
        if (v == null) {
            v = BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.map_find_guide_bg_2);
        }
        if (w == null) {
            w = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.map_find_guide_bg_3), a46.b(AppContext.getContext(), 8.0f), a46.b(AppContext.getContext(), 64.0f), false);
        }
        if (x == null) {
            x = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.map_find_guide_center_green), a46.b(AppContext.getContext(), 9.0f), a46.b(AppContext.getContext(), 17.0f), false);
        }
        if (y == null) {
            y = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.map_find_guide_big_13_bg), a46.b(AppContext.getContext(), 113.0f), a46.b(AppContext.getContext(), 116.0f), false);
        }
        if (z == null) {
            z = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.map_find_guide_big_35_bg), a46.b(AppContext.getContext(), 176.0f), a46.b(AppContext.getContext(), 117.0f), false);
        }
        if (A == null) {
            A = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.map_find_guide_big_42_bg), a46.b(AppContext.getContext(), 128.0f), a46.b(AppContext.getContext(), 143.0f), false);
        }
    }

    public static void J(FindNearByMapActivity findNearByMapActivity) {
        ImageView imageView = (ImageView) findNearByMapActivity.findViewById(R.id.iv_separation_unlock_info);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new r(findNearByMapActivity));
    }

    public static void K() {
        JSONObject config = vs0.a().getConfig("mapFinderConfig");
        if (config != null) {
            JSONObject jSONObjectOptJSONObject = config.optJSONObject("unlocknearby_popup");
            if (jSONObjectOptJSONObject != null) {
                LogUtil.d("FindMapPayManager", "initOptimizeConfig unlockObject " + jSONObjectOptJSONObject);
                f17145a = jSONObjectOptJSONObject.optString("title");
                b = jSONObjectOptJSONObject.optString("pic1_url");
                c = jSONObjectOptJSONObject.optString("pic2_url");
                d = jSONObjectOptJSONObject.optString("vice_intro");
                e = jSONObjectOptJSONObject.optString("free_vice_intro");
                f = jSONObjectOptJSONObject.optString("unlock_button");
            }
            q = config.optInt("moveguide_fre", 172800);
            JSONArray jSONArrayOptJSONArray = config.optJSONArray("moveguide_text");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                int length = jSONArrayOptJSONArray.length();
                r = jSONArrayOptJSONArray.optString(new Random().nextInt(length));
                s = jSONArrayOptJSONArray.optString(new Random().nextInt(length));
                t = jSONArrayOptJSONArray.optString(new Random().nextInt(length));
            }
            LogUtil.d("FindMapPayManager", "initOptimizeConfig moveguideFre " + q + " moveguideText13 " + r + " moveguideText35 " + s + " moveguideText42 " + t);
        }
        JSONObject config2 = vs0.a().getConfig("locationmsg_mapfinderguide");
        if (config2 != null) {
            JSONObject jSONObjectOptJSONObject2 = config2.optJSONObject("location_msg");
            if (jSONObjectOptJSONObject2 != null) {
                k = jSONObjectOptJSONObject2.optBoolean("msg_switch", false);
                l = jSONObjectOptJSONObject2.optString("text", "附近xx人活跃 ，查看详情>");
            }
            JSONObject jSONObjectOptJSONObject3 = config2.optJSONObject("location_detail");
            if (jSONObjectOptJSONObject3 != null) {
                m = jSONObjectOptJSONObject3.optString("top_pic", "");
                n = jSONObjectOptJSONObject3.optString("top_url", "");
                o = jSONObjectOptJSONObject3.optString("down_mapfinderintro", "附近有xx人活跃，解锁查看详情>");
                p = jSONObjectOptJSONObject3.optString("down_buttontext", "解锁附近的人");
            }
        }
        H(null, false);
    }

    public static void L(FindNearByMapActivity findNearByMapActivity) {
        View viewFindViewById = findNearByMapActivity.findViewById(R.id.separation_new_buy_layout);
        View viewFindViewById2 = findNearByMapActivity.findViewById(R.id.separation_old_buy_layout);
        viewFindViewById.setVisibility(0);
        viewFindViewById2.setVisibility(8);
        if (gi5.g() != null && gi5.g().setanotherme_setpopup != null) {
            MapFinderConfig.SetPopUp setPopUp = gi5.g().setanotherme_setpopup;
            String str = setPopUp.title;
            if (!TextUtils.isEmpty(str)) {
                ((TextView) viewFindViewById.findViewById(R.id.map_separation_bug_title_new)).setText(str);
            }
            String str2 = setPopUp.pic1;
            if (!TextUtils.isEmpty(str2)) {
                hc2.b(findNearByMapActivity).load(str2).error(R.drawable.map_separation_bug_img1).into((ImageView) viewFindViewById.findViewById(R.id.map_separation_bug_img1_new));
            }
            String str3 = setPopUp.pic2;
            if (!TextUtils.isEmpty(str3)) {
                hc2.b(findNearByMapActivity).load(str3).error(R.drawable.map_separation_bug_img2).into((ImageView) viewFindViewById.findViewById(R.id.map_separation_bug_img2_new));
            }
            String str4 = setPopUp.pic3;
            if (!TextUtils.isEmpty(str4)) {
                hc2.b(findNearByMapActivity).load(str4).error(R.drawable.map_separation_bug_img3).into((ImageView) viewFindViewById.findViewById(R.id.map_separation_bug_img3_new));
            }
            String str5 = setPopUp.vice_intro_v2;
            if (!TextUtils.isEmpty(str5)) {
                ((TextView) viewFindViewById.findViewById(R.id.map_separation_bug_vice_intro_new)).setText(str5);
            }
            String str6 = setPopUp.set_button;
            if (!TextUtils.isEmpty(str6)) {
                ((TextView) viewFindViewById.findViewById(R.id.separation_always_text)).setText(str6);
                ((TextView) viewFindViewById.findViewById(R.id.separation_buy_one_text)).setText(str6);
            }
            viewFindViewById.findViewById(R.id.separation_new_close).setOnClickListener(new s(findNearByMapActivity));
        }
        viewFindViewById.findViewById(R.id.separation_buy_one_layout).setOnClickListener(new t(findNearByMapActivity));
        viewFindViewById.findViewById(R.id.separation_always_layout).setOnClickListener(new u(findNearByMapActivity));
    }

    public static void M(int i2, int i3) {
        bi5.p("lbs.square.map.find.person.close.tip.v1", new p(i2, i3));
    }

    public static void N(wc3 wc3Var, FindNearByMapActivity findNearByMapActivity, LocationEx locationEx, String str) {
        zw4.e(new f(locationEx, str, wc3Var, findNearByMapActivity));
    }

    public static void O(String str) {
        try {
            HashMap map = new HashMap();
            if (str != null) {
                map.put("report_type", str);
            }
            zn6.g("page_mapfinder_activebubble", new JSONObject(map));
        } catch (Exception unused) {
        }
    }

    public static void P() {
        try {
            zn6.g("page_mapfinder_instruction_click", new JSONObject(new HashMap()));
        } catch (Exception unused) {
        }
    }

    public static void Q(int i2) {
        try {
            HashMap map = new HashMap();
            map.put("view", Integer.valueOf(i2));
            zn6.g("page_mapfinder_instruction_popup", new JSONObject(map));
        } catch (Exception unused) {
        }
    }

    public static void R() {
        try {
            zn6.g("page_mapfinder_newfreepopup", new JSONObject(new HashMap()));
        } catch (Exception unused) {
        }
    }

    public static void S() {
        try {
            zn6.g("page_mapfinder_newfreepopup_cancel", new JSONObject(new HashMap()));
        } catch (Exception unused) {
        }
    }

    public static void T() {
        try {
            zn6.g("page_mapfinder_newfreepopup_lookforfree", new JSONObject(new HashMap()));
        } catch (Exception unused) {
        }
    }

    public static void U(int i2, int i3) {
        try {
            HashMap map = new HashMap();
            map.put("from", Integer.valueOf(i2));
            map.put("status", Integer.valueOf(i3));
            zn6.g("page_mapfinder_newpopupv2", new JSONObject(map));
        } catch (Exception unused) {
        }
    }

    public static void V() {
        try {
            zn6.g("page_mapfinder_newpopupv2_cancel", new JSONObject());
        } catch (Exception unused) {
        }
    }

    public static void W() {
        try {
            zn6.g("page_mapfinder_newpopupv2_lookforandnevershow", new JSONObject(new HashMap()));
        } catch (Exception unused) {
        }
    }

    public static void X() {
        try {
            zn6.g("page_mapfinder_newpopupv2_lookforandshowagain", new JSONObject(new HashMap()));
        } catch (Exception unused) {
        }
    }

    public static void Y() {
        try {
            zn6.g("page_mapfinder_setanotherme_newpopupv2_cancel", new JSONObject(new HashMap()));
        } catch (Exception unused) {
        }
    }

    public static void Z() {
        try {
            zn6.g("page_mapfinder_setanotherme_newpopv2_set&nevershow", new JSONObject(new HashMap()));
        } catch (Exception unused) {
        }
    }

    public static void a0() {
        try {
            zn6.g("page_mapfinder_setanotherme_newpopv2_set&showagain", new JSONObject(new HashMap()));
        } catch (Exception unused) {
        }
    }

    public static void b0(int i2) {
        try {
            HashMap map = new HashMap();
            map.put("from", Integer.valueOf(i2));
            zn6.g("page_mapfinder_setanotherme_newpopupv2", new JSONObject(map));
        } catch (Exception unused) {
        }
    }

    public static void c0() {
        SPUtil.f14322a.v(SPUtil.SCENE.MAPFIND, "KEY_FIND_MAP_GUIDE_SHOW_TIME", Long.valueOf(System.currentTimeMillis()));
    }

    public static void d0(tc3 tc3Var) {
        a0();
        M(1, 1);
        if (tc3Var != null) {
            tc3Var.P();
        }
    }

    public static void e0(tc3 tc3Var) {
        Z();
        M(1, 0);
        if (tc3Var != null) {
            tc3Var.P();
        }
    }

    public static void f0(TextView textView) {
        if (textView == null || gi5.g().notmove_operation_text == null) {
            return;
        }
        try {
            ArrayList<String> arrayList = gi5.g().notmove_operation_text.text;
            int size = arrayList.size();
            if (size > 0) {
                int iNextInt = new Random().nextInt(size);
                String str = arrayList.get(iNextInt);
                LogUtil.d("FindMapPayManager", "setSelectedInfo size " + size + " randSize " + iNextInt + " text " + str);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                E = true;
                textView.setText(str);
            }
        } catch (Exception unused) {
        }
    }

    public static void g0(FindNearByMapActivity findNearByMapActivity) {
        int[] iArr = {1};
        View viewInflate = View.inflate(findNearByMapActivity, R.layout.dialog_map_info_msg, null);
        uc3 uc3Var = new uc3(findNearByMapActivity, viewInflate);
        uc3Var.show();
        Q(iArr[0]);
        View viewFindViewById = viewInflate.findViewById(R.id.unlock_info_item_layout);
        View viewFindViewById2 = viewInflate.findViewById(R.id.unlock_info_item_bg);
        TextView textView = (TextView) viewInflate.findViewById(R.id.unlock_info_item_text);
        View viewFindViewById3 = viewInflate.findViewById(R.id.sep_info_item_layout);
        View viewFindViewById4 = viewInflate.findViewById(R.id.sep_info_item_bg);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.sep_info_item_text);
        View viewFindViewById5 = viewInflate.findViewById(R.id.layout_find_map_separation_info_show);
        View viewFindViewById6 = viewInflate.findViewById(R.id.layout_find_map_unlock_info_show);
        View viewFindViewById7 = viewInflate.findViewById(R.id.layout_find_info_close);
        if (!TextUtils.isEmpty(f17145a)) {
            textView.setText(f17145a);
        }
        if (!TextUtils.isEmpty(b) && !q05.o(findNearByMapActivity)) {
            a46.u(b, (ImageView) viewFindViewById6.findViewById(R.id.map_unlock_pic1_info), R.drawable.map_unlock_pic1);
        }
        if (!TextUtils.isEmpty(c) && !q05.o(findNearByMapActivity)) {
            a46.u(c, (ImageView) viewFindViewById6.findViewById(R.id.map_unlock_pic2_info), R.drawable.map_unlock_pic2);
        }
        if (!TextUtils.isEmpty(d)) {
            ((TextView) viewFindViewById6.findViewById(R.id.map_unlock_intro)).setText(d);
        }
        if (gi5.g() != null && gi5.g().setanotherme_setpopup != null) {
            MapFinderConfig.SetPopUp setPopUp = gi5.g().setanotherme_setpopup;
            String str = setPopUp.title;
            if (!TextUtils.isEmpty(str)) {
                textView2.setText(str);
            }
            String str2 = setPopUp.pic1;
            if (!TextUtils.isEmpty(str2)) {
                hc2.b(findNearByMapActivity).load(str2).error(R.drawable.map_separation_bug_img1).into((ImageView) viewFindViewById5.findViewById(R.id.map_separation_bug_img1_info));
            }
            String str3 = setPopUp.pic2;
            if (!TextUtils.isEmpty(str3)) {
                hc2.b(findNearByMapActivity).load(str3).error(R.drawable.map_separation_bug_img2).into((ImageView) viewFindViewById5.findViewById(R.id.map_separation_bug_img2_info));
            }
            String str4 = setPopUp.pic3;
            if (!TextUtils.isEmpty(str4)) {
                hc2.b(findNearByMapActivity).load(str4).error(R.drawable.map_separation_bug_img3).into((ImageView) viewFindViewById5.findViewById(R.id.map_separation_bug_img3_info));
            }
            String str5 = setPopUp.vice_intro_v2;
            if (!TextUtils.isEmpty(str5)) {
                ((TextView) viewFindViewById5.findViewById(R.id.map_separation_optimize_buy_desc_title_info)).setText(str5);
            }
        }
        viewFindViewById7.setOnClickListener(new b(uc3Var));
        viewFindViewById.setOnClickListener(new c(iArr, viewFindViewById2, viewFindViewById4, textView, textView2, viewFindViewById5, viewFindViewById6));
        viewFindViewById3.setOnClickListener(new d(iArr, viewFindViewById2, viewFindViewById4, textView, textView2, viewFindViewById5, viewFindViewById6));
    }

    public static void h0(Activity activity, LocationEx locationEx, int i2) {
        new sd3(activity).U("温馨提示").k("本次解锁和当前已解锁位置距离较近，请确认是否继续？").O(R.string.dialog_confirm).L("取消").f(new h(locationEx, activity, i2)).u().e().show();
    }

    public static void i0(Activity activity, LocationEx locationEx, int i2) {
        w();
        View viewInflate = View.inflate(activity, R.layout.map_find_location_lock_dialog, null);
        uc3 uc3Var = new uc3(activity, viewInflate);
        uc3Var.show();
        if (!TextUtils.isEmpty(f17145a)) {
            ((TextView) viewInflate.findViewById(R.id.unlock_title)).setText(f17145a);
        }
        if (!TextUtils.isEmpty(d)) {
            ((TextView) viewInflate.findViewById(R.id.clock_vice_intro)).setText(d);
        }
        if (!TextUtils.isEmpty(b)) {
            a46.u(b, (ImageView) viewInflate.findViewById(R.id.map_unlock_pic1), R.drawable.map_unlock_pic1);
        }
        if (!TextUtils.isEmpty(c)) {
            a46.u(c, (ImageView) viewInflate.findViewById(R.id.map_unlock_pic2), R.drawable.map_unlock_pic2);
        }
        if (!TextUtils.isEmpty(f)) {
            ((TextView) viewInflate.findViewById(R.id.clock_one_text)).setText(f);
        }
        if (!TextUtils.isEmpty(vc3.f21404a)) {
            ((TextView) viewInflate.findViewById(R.id.clock_one_price)).setText("（" + vc3.f21404a + "）");
        }
        ((TextView) viewInflate.findViewById(R.id.unlock_new_close)).setOnClickListener(new i(uc3Var));
        viewInflate.findViewById(R.id.clock_one_layout).setOnClickListener(new j(locationEx, activity, i2, uc3Var));
        if (i) {
            viewInflate.findViewById(R.id.clock_vice_intro).setVisibility(8);
            viewInflate.findViewById(R.id.clock_one_price).setVisibility(8);
        }
    }

    public static void j0(BaseNetBean<CheckDriftBean> baseNetBean, Context context, String str, String str2, boolean z2, tc3 tc3Var, int i2, int i3) {
        int i4;
        g = z2;
        h = baseNetBean;
        LogUtil.d("FindMapPayManager", "startCharge showPromptDialog curCheckDriftBean " + h);
        View viewInflate = View.inflate(context, R.layout.dialog_map_unlock_new, null);
        uc3 uc3Var = new uc3(context, viewInflate);
        uc3Var.show();
        if (i) {
            R();
            i4 = 2;
        } else {
            i4 = 1;
        }
        U(i2, i4);
        if (!TextUtils.isEmpty(f17145a)) {
            ((TextView) viewInflate.findViewById(R.id.unlock_title)).setText(f17145a);
        }
        if (!TextUtils.isEmpty(d)) {
            ((TextView) viewInflate.findViewById(R.id.clock_vice_intro)).setText(d);
        }
        if (!TextUtils.isEmpty(b) && (context instanceof Activity) && !q05.o((Activity) context)) {
            a46.u(b, (ImageView) viewInflate.findViewById(R.id.map_unlock_pic1), R.drawable.map_unlock_pic1);
        }
        if (!TextUtils.isEmpty(c) && (context instanceof Activity) && !q05.o((Activity) context)) {
            a46.u(c, (ImageView) viewInflate.findViewById(R.id.map_unlock_pic2), R.drawable.map_unlock_pic2);
        }
        LogUtil.d("FindMapPayManager", "showPromptDialog curAddress" + str2 + " distance " + str);
        TextView textView = (TextView) viewInflate.findViewById(R.id.map_unlock_location_km);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.map_unlock_location_marquee);
        textView2.setSelected(true);
        if (!TextUtils.isEmpty(str2)) {
            textView2.setText(str2);
        }
        if (!com.zenmen.palmchat.location.c.b().unlockLocation) {
            LogUtil.d(AliMapConfig.TAG, "unlockLocation is false addRessLayout visibility gone");
            viewInflate.findViewById(R.id.map_separation_bug_success_address_layout).setVisibility(8);
            viewInflate.findViewById(R.id.map_separation_bug_success_address_title).setVisibility(8);
        }
        if (!TextUtils.isEmpty(f)) {
            ((TextView) viewInflate.findViewById(R.id.clock_one_text)).setText(f);
            ((TextView) viewInflate.findViewById(R.id.clock_always_text)).setText(f);
        }
        ((TextView) viewInflate.findViewById(R.id.unlock_new_close)).setOnClickListener(new k(uc3Var));
        if (i) {
            viewInflate.findViewById(R.id.clock_one_layout_line).setVisibility(8);
            viewInflate.findViewById(R.id.clock_one_layout).setVisibility(8);
            viewInflate.findViewById(R.id.clock_vice_intro).setVisibility(8);
            viewInflate.findViewById(R.id.clock_always_text_show).setVisibility(8);
        }
        viewInflate.findViewById(R.id.clock_one_layout).setOnClickListener(new n(tc3Var, uc3Var));
        viewInflate.findViewById(R.id.clock_always_layout).setOnClickListener(new o(tc3Var, uc3Var));
    }

    public static void k0(long j2, LocationEx locationEx, Activity activity, int i2) {
        if (!hx3.m(AppContext.getContext())) {
            ry5.a("网络好像有点问题，稍后再试");
        } else {
            com.zenmen.palmchat.giftkit.a.a().b(activity, of2.f(8099, 1001, "", 0, "", 0), j2, new m(locationEx, activity, i2));
        }
    }

    public static boolean l() {
        return !"A".equals(t66.h().e("LX-74314", "A"));
    }

    public static void l0(BaseNetBean<CheckDriftBean> baseNetBean, tc3 tc3Var) {
        if (i) {
            T();
        } else {
            X();
        }
        M(0, 1);
        if (tc3Var != null) {
            tc3Var.B(g, baseNetBean, true);
        }
    }

    public static boolean m() {
        return !"A".equals(E());
    }

    public static void m0(LocationEx locationEx, Activity activity, int i2) {
        if (locationEx != null) {
            zw4.e(new l(locationEx, i2, activity));
        }
    }

    public static boolean n() {
        long jK = SPUtil.f14322a.k(SPUtil.SCENE.MAPFIND, "KEY_FIND_MAP_GUIDE_SHOW_TIME", 0L);
        return jK == 0 || System.currentTimeMillis() - jK > ((long) (q * 1000));
    }

    public static void n0(BaseNetBean<CheckDriftBean> baseNetBean, tc3 tc3Var) {
        W();
        M(0, 0);
        if (tc3Var != null) {
            tc3Var.B(g, baseNetBean, true);
        }
    }

    public static void o(tc3 tc3Var, int i2) {
        LogUtil.d("FindMapPayManager", "checkSeparationAllowDialog separationTipStatus " + j);
        if (tc3Var != null) {
            if (j) {
                tc3Var.P();
            } else {
                tc3Var.j1(i2);
            }
        }
    }

    public static void p(FindNearByMapActivity findNearByMapActivity) {
        if (findNearByMapActivity != null && m()) {
            H(findNearByMapActivity, false);
            L(findNearByMapActivity);
            J(findNearByMapActivity);
        }
    }

    public static Bitmap q(String str, Bitmap bitmap, int i2, int i3, int i4) {
        int i5;
        int i6;
        int iK = ((int) il5.k(AppContext.getContext(), str, a46.b(AppContext.getContext(), 12.0f))) + a46.b(AppContext.getContext(), 20.0f);
        int iB = a46.b(AppContext.getContext(), 2.0f);
        if (iK > i2) {
            i5 = iB;
            i6 = (int) ((iK - i2) / 2.0f);
            i2 = iK;
        } else {
            i5 = (int) ((i2 - iK) / 2.0f);
            i6 = 0;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, i6, 0.0f, (Paint) null);
        canvas.drawBitmap(x, (int) ((i2 - a46.b(AppContext.getContext(), 9.0f)) / 2.0f), i3 - (a46.b(AppContext.getContext(), 17.0f) + i4), (Paint) null);
        float fB = i3 - ((a46.b(AppContext.getContext(), 9.0f) + i4) + a46.b(AppContext.getContext(), 64.0f));
        canvas.drawBitmap(u, i5, fB, (Paint) null);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(v, iK - a46.b(AppContext.getContext(), 99.0f), a46.b(AppContext.getContext(), 64.0f), false);
        canvas.drawBitmap(bitmapCreateScaledBitmap, a46.b(AppContext.getContext(), 91.0f) + i5, fB, (Paint) null);
        bitmapCreateScaledBitmap.recycle();
        canvas.drawBitmap(w, a46.b(AppContext.getContext(), 91.0f) + i5 + r0, fB, (Paint) null);
        Paint paint = new Paint();
        paint.setTextSize(a46.b(AppContext.getContext(), 12.0f));
        paint.setColor(Color.parseColor("#222222"));
        paint.setFakeBoldText(true);
        canvas.drawText(str, a46.b(AppContext.getContext(), 13.0f) + i5, r13 + a46.b(AppContext.getContext(), 46.0f), paint);
        return bitmapCreateBitmap;
    }

    public static Bitmap r(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            I();
            if ("guideType13".equals(str2)) {
                Bitmap bitmap = B;
                if (bitmap == null || bitmap.isRecycled()) {
                    B = q(str, y, a46.b(AppContext.getContext(), 113.0f), a46.b(AppContext.getContext(), 116.0f), a46.b(AppContext.getContext(), 38.0f));
                }
                return B;
            }
            if ("guideType35".equals(str2)) {
                Bitmap bitmap2 = C;
                if (bitmap2 == null || bitmap2.isRecycled()) {
                    C = q(str, z, a46.b(AppContext.getContext(), 176.0f), a46.b(AppContext.getContext(), 117.0f), a46.b(AppContext.getContext(), 44.0f));
                }
                return C;
            }
            if (!"guideType42".equals(str2)) {
                return null;
            }
            Bitmap bitmap3 = D;
            if (bitmap3 == null || bitmap3.isRecycled()) {
                D = q(str, A, a46.b(AppContext.getContext(), 128.0f), a46.b(AppContext.getContext(), 143.0f), a46.b(AppContext.getContext(), 50.0f));
            }
            return D;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void s(String str) {
        try {
            HashMap map = new HashMap();
            map.put("report_type", str);
            zn6.g("locationmsg_detail_notice", new JSONObject(map));
        } catch (Exception unused) {
        }
    }

    public static void t(String str) {
        try {
            HashMap map = new HashMap();
            map.put("report_type", str);
            zn6.g("locationmsg_detail_unlock", new JSONObject(map));
        } catch (Exception unused) {
        }
    }

    public static void u(String str) {
        try {
            HashMap map = new HashMap();
            map.put("report_type", str);
            zn6.g("pagemapfinder_hotzonehint", new JSONObject(map));
        } catch (Exception unused) {
        }
    }

    public static void v(String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put("report_type", str);
            map.put("mid", str2);
            zn6.g("locationmsg_mapfinderhint", new JSONObject(map));
        } catch (Exception unused) {
        }
    }

    public static void w() {
        try {
            zn6.g("locationmsg_detail_unlockpopup", new JSONObject(new HashMap()));
        } catch (Exception unused) {
        }
    }

    public static void x() {
        try {
            zn6.g("locationmsg_detail_unlockpopup_cancel", new JSONObject(new HashMap()));
        } catch (Exception unused) {
        }
    }

    public static void y() {
        try {
            zn6.g("locationmsg_detail_unlockpopup_unlock", new JSONObject(new HashMap()));
        } catch (Exception unused) {
        }
    }

    public static List<pc3> z(pc3[] pc3VarArr) {
        ArrayList arrayList = new ArrayList();
        if (pc3VarArr != null) {
            if (pc3VarArr.length >= 17) {
                arrayList.add(pc3VarArr[16]);
            }
            if (pc3VarArr.length >= 29) {
                arrayList.add(pc3VarArr[28]);
            }
            if (pc3VarArr.length >= 15) {
                arrayList.add(pc3VarArr[14]);
            }
        }
        return arrayList;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends go2<LXBaseNetBean<MapSeparationModel>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wc3 f17151a;
        public final /* synthetic */ FindNearByMapActivity b;
        public final /* synthetic */ LocationEx c;

        public e(wc3 wc3Var, FindNearByMapActivity findNearByMapActivity, LocationEx locationEx) {
            this.f17151a = wc3Var;
            this.b = findNearByMapActivity;
            this.c = locationEx;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return xc3.F();
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<MapSeparationModel> lXBaseNetBean, Exception exc) {
            MapSeparationModel mapSeparationModel;
            LogUtil.i("FindMapPayManager", "startCharge requestSeparationStatus info onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean != null) {
                try {
                    if (lXBaseNetBean.resultCode == 0 && (mapSeparationModel = lXBaseNetBean.data) != null) {
                        vc3.d(mapSeparationModel);
                        boolean z2 = lXBaseNetBean.data.tipStatus;
                        dw1.j = z2;
                        if (z2) {
                            String str = xc3.k;
                            if (TextUtils.isEmpty(str)) {
                                dw1.F("getSeparationStatus", com.zenmen.palmchat.c.b(), new a(), this.c);
                            } else {
                                dw1.N(this.f17151a, this.b, this.c, str);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements i53 {
            public a() {
            }

            @Override // defpackage.i53
            public void onRegeocodeSearched(String str) {
                e eVar = e.this;
                dw1.N(eVar.f17151a, eVar.b, eVar.c, str);
            }

            @Override // defpackage.i53
            public void onLocationReceived(LocationEx locationEx, int i, String str) {
            }

            @Override // defpackage.i53
            public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements i53 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseNetBean f17164a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ tc3 e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;

        public q(BaseNetBean baseNetBean, Context context, String str, boolean z, tc3 tc3Var, int i, int i2) {
            this.f17164a = baseNetBean;
            this.b = context;
            this.c = str;
            this.d = z;
            this.e = tc3Var;
            this.f = i;
            this.g = i2;
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
            LogUtil.d("FindMapPayManager", "getGeocodeSearch onRegeocodeSearched address " + str);
            dw1.j0(this.f17164a, this.b, this.c, str, this.d, this.e, this.f, this.g);
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }
}
