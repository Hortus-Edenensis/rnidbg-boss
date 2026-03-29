package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.find.bean.LoadCountBean;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.fragment.online.OnLineAllData;
import com.zenmen.square.fragment.online.OnLineDetailActiveInfo;
import com.zenmen.square.fragment.online.OnLineDetailData;
import com.zenmen.square.fragment.online.OnLineDetailTripInfo;
import com.zenmen.square.fragment.online.OnLineDetailUserInfo;
import com.zenmen.square.fragment.online.OnLineDialogActivity;
import com.zenmen.square.fragment.online.OnLineItemData;
import com.zenmen.square.fragment.online.OnLinePublicData;
import com.zenmen.square.fragment.online.OnLineStatusData;
import com.zenmen.square.fragment.online.OnLineStatusItem;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class z64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f22360a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static String d = "添加状态";
    public static String e = "活跃状态发布后24小时有效，有效期内会持续在活跃大厅中展示";
    public static String f = "我的活跃状态";
    public static String g = "说说你现在的心情……";
    public static int h = 12;
    public static int i = 259200;
    public static int j = 600;
    public static boolean k = true;
    public static HashMap<String, String> l = new HashMap<>();
    public static long m = 0;
    public static String[] n = {"https://avatar.cdn.lianxinapp.com/avatar2/u/c/2023/7/8/h/f/1sim1blvaio-1-2-147d222ad9694c0499da4a49de5ad85f-rxg2mz.jpg", "https://p66-pro.a.yximgs.com/uhead/AB/2024/04/23/16/BMjAyNDA0MjMxNjQ3MDRfNDA4MjU1NTQyNl8zX2hkNTk3XzkxMw==_s.jpg", "https://avatar.cdn.lianxinapp.com/avatar/u/c/2023/3/8/k/l/1pyxt47ghkw-1-2-8d0293e4b72a4d58ba1d46ef1d93f137-rr6mya.png", "https://avatar.cdn.lianxinapp.com/avatar/u/c/2022/12/13/v/p/1lxht5e5w5c-1-2-5aaedbb529434ebfbcfe936b56974635-rmty3b_small.png"};
    public static String[] o = {"#FFFCF3", "#F3F3FF", "#F4F9FF", "#F0FCF8"};
    public static String[] p = {"旅游中", "来个人陪我聊聊天", "有人出来玩吗", "交朋友"};
    public static String[] q = {"https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-24-2-c1ea2b4cd2fc450eab4371af3d0cb01e-t2crxs", "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-24-2-08172d7494e7491dbffa5ab8b1890247-t2crxm", "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-24-2-cb4e09e5a472462c9035c4768d592be9-t2cry6", "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-24-2-d73257d3179d4dbe9c370382e85c7058-t2cryd"};
    public static int r = 0;
    public static long s = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<OnLinePublicData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22361a;
        public final /* synthetic */ OnLineStatusItem b;
        public final /* synthetic */ a74 c;

        public a(String str, OnLineStatusItem onLineStatusItem, a74 a74Var) {
            this.f22361a = str;
            this.b = onLineStatusItem;
            this.c = a74Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(this.f22361a)) {
                map.put("content", this.f22361a);
            }
            map.put("tagId", Long.valueOf(this.b.tagId));
            if (com.zenmen.palmchat.location.d.g().h() != null) {
                map.put("longitude", Double.valueOf(com.zenmen.palmchat.location.d.g().h().getLongitude()));
                map.put("latitude", Double.valueOf(com.zenmen.palmchat.location.d.g().h().getLatitude()));
            }
            ContactInfoItem contactInfoItemA = dn0.a(v4.e(com.zenmen.palmchat.c.b()));
            if (contactInfoItemA != null) {
                map.put("gender", Integer.valueOf(contactInfoItemA.getGender()));
            }
            return sw4.b(1, nl0.z + "/active.state.publish", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<OnLinePublicData> lXBaseNetBean, Exception exc) {
            LogUtil.i("OnLineManagerTag", "requestOnLineAllData info onResult=" + lXBaseNetBean);
            boolean unused = z64.c = false;
            if (lXBaseNetBean == null || lXBaseNetBean.resultCode != 0) {
                a74 a74Var = this.c;
                if (a74Var != null) {
                    a74Var.onError("result is null");
                    return;
                }
                return;
            }
            a74 a74Var2 = this.c;
            if (a74Var2 != null) {
                a74Var2.onSuccess(lXBaseNetBean.data);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22362a;
        public final /* synthetic */ a74 b;

        public b(String str, a74 a74Var) {
            this.f22362a = str;
            this.b = a74Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("id", this.f22362a);
            return sw4.b(1, nl0.z + "/active.state.delete", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            LogUtil.i("OnLineManagerTag", "postDeleteStatus info onResult=" + lXBaseNetBean);
            if (lXBaseNetBean == null) {
                a74 a74Var = this.b;
                if (a74Var != null) {
                    a74Var.onError("result is null");
                    return;
                }
                return;
            }
            if (lXBaseNetBean.resultCode == 0) {
                a74 a74Var2 = this.b;
                if (a74Var2 != null) {
                    a74Var2.onSuccess(lXBaseNetBean.data);
                    return;
                }
                return;
            }
            a74 a74Var3 = this.b;
            if (a74Var3 != null) {
                a74Var3.onError(lXBaseNetBean.errorMsg);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<OnLineAllData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22363a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ LocationEx d;
        public final /* synthetic */ a74 e;

        public c(int i, String str, boolean z, LocationEx locationEx, a74 a74Var) {
            this.f22363a = i;
            this.b = str;
            this.c = z;
            this.d = locationEx;
            this.e = a74Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("pageNo", Integer.valueOf(this.f22363a));
            map.put("refreshId", this.b);
            if (this.c) {
                ContactInfoItem contactInfoItemA = dn0.a(v4.e(com.zenmen.palmchat.c.b()));
                if ((contactInfoItemA != null ? contactInfoItemA.getGender() : 0) == 0) {
                    map.put("gender", 1);
                } else {
                    map.put("gender", 0);
                }
            }
            LocationEx locationEx = this.d;
            if (locationEx != null) {
                map.put("longitude", Double.valueOf(locationEx.getLongitude()));
                map.put("latitude", Double.valueOf(this.d.getLatitude()));
            }
            return sw4.b(1, nl0.z + "/active.state.rec.list", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<OnLineAllData> lXBaseNetBean, Exception exc) {
            OnLineAllData onLineAllData;
            LogUtil.i("OnLineManagerTag", "requestOnLineAllData info onResult=" + az2.c(lXBaseNetBean));
            boolean unused = z64.f22360a = false;
            if (lXBaseNetBean == null) {
                a74 a74Var = this.e;
                if (a74Var != null) {
                    a74Var.onError("result is null");
                    return;
                }
                return;
            }
            if (lXBaseNetBean.resultCode != 0 || (onLineAllData = lXBaseNetBean.data) == null) {
                a74 a74Var2 = this.e;
                if (a74Var2 != null) {
                    a74Var2.onError(lXBaseNetBean.errorMsg);
                    return;
                }
                return;
            }
            a74 a74Var3 = this.e;
            if (a74Var3 != null) {
                a74Var3.onSuccess(onLineAllData);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends go2<LXBaseNetBean<OnLineStatusData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a74 f22364a;

        public d(a74 a74Var) {
            this.f22364a = a74Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, nl0.z + "/active.state.last", new HashMap()).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<OnLineStatusData> lXBaseNetBean, Exception exc) {
            OnLineStatusData onLineStatusData;
            LogUtil.i("OnLineManagerTag", "requestOnLineStatus info onResult=" + az2.c(lXBaseNetBean));
            boolean unused = z64.b = false;
            if (lXBaseNetBean == null) {
                a74 a74Var = this.f22364a;
                if (a74Var != null) {
                    a74Var.onError("result is null");
                    return;
                }
                return;
            }
            if (lXBaseNetBean.resultCode != 0 || (onLineStatusData = lXBaseNetBean.data) == null) {
                a74 a74Var2 = this.f22364a;
                if (a74Var2 != null) {
                    a74Var2.onError(lXBaseNetBean.errorMsg);
                    return;
                }
                return;
            }
            a74 a74Var3 = this.f22364a;
            if (a74Var3 != null) {
                a74Var3.onSuccess(onLineStatusData);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22365a;
        public final /* synthetic */ String b;

        public e(int i, String str) {
            this.f22365a = i;
            this.b = str;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("type", Integer.valueOf(this.f22365a));
            map.put("id", this.b);
            return sw4.b(1, nl0.z + "/active.state.click.v1", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            LogUtil.i("OnLineManagerTag", "postItemClickEvent info onResult=" + az2.c(lXBaseNetBean));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements fo0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnLineItemData f22366a;
        public final /* synthetic */ Activity b;

        public f(OnLineItemData onLineItemData, Activity activity) {
            this.f22366a = onLineItemData;
            this.b = activity;
        }

        @Override // defpackage.fo0
        public void onResponse(int i, String str) {
            if (i == 0) {
                z64.K((ContactInfoItem) az2.a(str, ContactInfoItem.class), this.f22366a, this.b);
            } else {
                sy5.f(this.b, "获取用户信息失败", 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements a74 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22367a;

        public g(Activity activity) {
            this.f22367a = activity;
        }

        @Override // defpackage.a74
        public void onError(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if ("1006".equals(str)) {
                str = "该行程动态已结束，看看其他人的动态吧~";
            }
            sy5.h(this.f22367a, str, 0);
        }

        @Override // defpackage.a74
        public void onSuccess(Object obj) {
            if (obj instanceof OnLineDetailData) {
                z64.J((OnLineDetailData) obj, 1);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends go2<LXBaseNetBean<OnLineDetailData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22368a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ a74 d;

        public h(int i, String str, long j, a74 a74Var) {
            this.f22368a = i;
            this.b = str;
            this.c = j;
            this.d = a74Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("type", Integer.valueOf(this.f22368a));
            map.put("id", this.b);
            map.put(DeviceInfoUtil.UID_TAG, Long.valueOf(this.c));
            LocationEx locationExH = com.zenmen.palmchat.location.d.g().h();
            if (locationExH != null) {
                map.put("longitude", Double.valueOf(locationExH.getLongitude()));
                map.put("latitude", Double.valueOf(locationExH.getLatitude()));
                map.put("cityCode", locationExH.getCityCode());
            }
            return sw4.b(1, nl0.z + "/active.state.detail", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<OnLineDetailData> lXBaseNetBean, Exception exc) {
            OnLineDetailData onLineDetailData;
            LogUtil.i("OnLineManagerTag", "requestOnLineAllData info onResult=" + lXBaseNetBean);
            if (lXBaseNetBean == null) {
                a74 a74Var = this.d;
                if (a74Var != null) {
                    a74Var.onError("数据异常");
                    return;
                }
                return;
            }
            int i = lXBaseNetBean.resultCode;
            if (i == 1006) {
                a74 a74Var2 = this.d;
                if (a74Var2 != null) {
                    a74Var2.onError("1006");
                    return;
                }
                return;
            }
            if (i != 0 || (onLineDetailData = lXBaseNetBean.data) == null) {
                a74 a74Var3 = this.d;
                if (a74Var3 != null) {
                    a74Var3.onError(lXBaseNetBean.errorMsg);
                    return;
                }
                return;
            }
            a74 a74Var4 = this.d;
            if (a74Var4 != null) {
                a74Var4.onSuccess(onLineDetailData);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements a74 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22369a;

        public i(Activity activity) {
            this.f22369a = activity;
        }

        @Override // defpackage.a74
        public void onError(String str) {
            if (TextUtils.isEmpty(str) || "1006".equals(str)) {
                return;
            }
            sy5.h(this.f22369a, str, 0);
        }

        @Override // defpackage.a74
        public void onSuccess(Object obj) {
            if (obj instanceof OnLineDetailData) {
                z64.J((OnLineDetailData) obj, 2);
            }
        }
    }

    public static void A(String str, a74 a74Var) {
        zw4.e(new b(str, a74Var));
    }

    public static void B(int i2, String str, long j2, a74 a74Var) {
        zw4.e(new h(i2, str, j2, a74Var));
    }

    public static void C(int i2, String str) {
        zw4.e(new e(i2, str));
    }

    public static void D(String str, OnLineStatusItem onLineStatusItem, a74 a74Var) {
        if (onLineStatusItem == null || c) {
            return;
        }
        c = true;
        zw4.e(new a(str, onLineStatusItem, a74Var));
    }

    public static void E(boolean z, int i2, String str, LocationEx locationEx, a74 a74Var) {
        if (f22360a) {
            return;
        }
        f22360a = true;
        zw4.e(new c(i2, str, z, locationEx, a74Var));
    }

    public static void F(boolean z, a74 a74Var) {
        if (z && m > 0 && System.currentTimeMillis() - m < 5000) {
            LogUtil.i("OnLineManagerTag", "requestOnLineStatus time not allow");
        } else {
            if (b) {
                return;
            }
            m = System.currentTimeMillis();
            b = true;
            zw4.e(new d(a74Var));
        }
    }

    public static void G() {
        LogUtil.d("OnLineManagerTag", "OnLineManagerRed saveShowLineRedDotTime success ");
        long jCurrentTimeMillis = System.currentTimeMillis();
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.ONLINE;
        sPUtil.v(scene, "KEY_ONLINE_RED_DOT_FRE_TIME", Long.valueOf(jCurrentTimeMillis));
        sPUtil.v(scene, "KEY_ONLINE_RED_DOT_SHOW", 0);
    }

    public static void H(ContactInfoItem contactInfoItem, Activity activity) {
        if (contactInfoItem == null || TextUtils.isEmpty(contactInfoItem.getChatId())) {
            return;
        }
        long jB = ap3.b(contactInfoItem.getChatId());
        if ((jB <= 0 || System.currentTimeMillis() - jB > 600000) && l.containsKey(contactInfoItem.getChatId())) {
            B(2, l.get(contactInfoItem.getChatId()), Long.parseLong(contactInfoItem.getChatId()), new i(activity));
        }
    }

    public static void I(OnLineDetailData onLineDetailData, Activity activity) {
        if (onLineDetailData == null || onLineDetailData.userInfo == null) {
            return;
        }
        m();
        ap3.m(activity, onLineDetailData.userInfo.uid + "", 5055, az2.c(onLineDetailData));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033 A[Catch: Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:5:0x0006, B:7:0x000a, B:17:0x0033, B:11:0x0017, B:13:0x0025, B:19:0x0040, B:21:0x0048), top: B:24:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void J(OnLineDetailData onLineDetailData, int i2) {
        if (onLineDetailData != null) {
            boolean z = true;
            if (i2 == 2) {
                try {
                    if (!onLineDetailData.isMine) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (k) {
                            long jK = SPUtil.f14322a.k(SPUtil.SCENE.ONLINE, "KEY_ONLINE_GIFTPOPUP_FRE_TIME", 0L);
                            if (jK > 0 && jCurrentTimeMillis - jK < j * 1000) {
                                z = false;
                            }
                            if (z) {
                            }
                        } else {
                            z = false;
                            if (z) {
                                SPUtil.f14322a.v(SPUtil.SCENE.ONLINE, "KEY_ONLINE_GIFTPOPUP_FRE_TIME", Long.valueOf(jCurrentTimeMillis));
                            }
                        }
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            if (!z) {
                LogUtil.d("OnLineManagerTag", "startDetailItemDialog allowShow false ");
                return;
            }
            onLineDetailData.type = i2;
            String strC = az2.c(onLineDetailData);
            Intent intent = new Intent(com.zenmen.palmchat.c.b(), (Class<?>) OnLineDialogActivity.class);
            intent.putExtra("key_activity_detail_data", strC);
            intent.addFlags(268435456);
            com.zenmen.palmchat.c.b().startActivity(intent);
        }
    }

    public static void K(ContactInfoItem contactInfoItem, OnLineItemData onLineItemData, Activity activity) {
        C(1, onLineItemData.id);
        if (contactInfoItem.getIsStranger()) {
            B(1, onLineItemData.id, onLineItemData.uid, new g(activity));
            return;
        }
        ap3.l(activity, onLineItemData.uid + "", "", 5055);
    }

    public static boolean e() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.ONLINE;
        long jK = sPUtil.k(scene, "KEY_ONLINE_RED_DOT_FRE_TIME", 0L);
        if (jK == 0 || sPUtil.k(scene, "KEY_ONLINE_RED_DOT_SHOW", 0L) == 0 || System.currentTimeMillis() - jK > i * 1000) {
            return true;
        }
        LogUtil.d("OnLineManagerTag", "OnLineManagerRed allowShowLineRedDot not allow");
        return false;
    }

    public static LoadCountBean.MarkerBean f(OnLineDetailData onLineDetailData) {
        LoadCountBean.MarkerBean markerBean = new LoadCountBean.MarkerBean();
        if (onLineDetailData != null) {
            OnLineDetailTripInfo onLineDetailTripInfo = onLineDetailData.scheduleInfo;
            if (onLineDetailTripInfo != null) {
                markerBean.scheduleOrderId = onLineDetailTripInfo.scheduleOrderId;
                markerBean.scheduleAddress = onLineDetailTripInfo.address;
                markerBean.scheduleTag = onLineDetailTripInfo.tag;
            }
            OnLineDetailUserInfo onLineDetailUserInfo = onLineDetailData.userInfo;
            if (onLineDetailUserInfo != null) {
                markerBean.uid = onLineDetailUserInfo.uid;
                markerBean.nickname = onLineDetailUserInfo.nickname;
                markerBean.avatar = onLineDetailUserInfo.avatar;
                markerBean.gender = onLineDetailUserInfo.gender;
            }
            markerBean.isBlur = true;
        }
        return markerBean;
    }

    public static void g() {
        zn6.d("pageactivehall_addactive", null, new JSONObject().toString());
    }

    public static void h() {
        zn6.d("pageactivehall_addactivepopup_close", null, new JSONObject().toString());
    }

    public static void i() {
        zn6.d("pageactivehall_addactivepopup_post", null, new JSONObject().toString());
    }

    public static void j() {
        zn6.d("pageactivehall_activedetail_chat", null, new JSONObject().toString());
    }

    public static void k() {
        zn6.d("pageactivehall_addactivepopup", null, new JSONObject().toString());
    }

    public static void l() {
        zn6.d("pageactivehall_entryview", null, new JSONObject().toString());
    }

    public static void m() {
        zn6.d("pageactivehall_activedetail_givegift", null, new JSONObject().toString());
    }

    public static void n(int i2, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i2);
            jSONObject.put("activeID", str);
            jSONObject.put("active_content", str2);
        } catch (Exception unused) {
        }
        zn6.d("pageactivehall_active_click", null, jSONObject.toString());
    }

    public static void o(int i2, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i2);
            jSONObject.put("activeID", str);
            jSONObject.put("active_content", str2);
        } catch (Exception unused) {
        }
        zn6.d("pageactivehall_activedetail", null, jSONObject.toString());
    }

    public static void p(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("activeID", str);
            jSONObject.put("active_content", str2);
        } catch (Exception unused) {
        }
        zn6.d("pageactivehall_active", null, jSONObject.toString());
    }

    public static void q(int i2, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i2);
            jSONObject.put("report_type", str);
        } catch (Exception unused) {
        }
        zn6.d("pageactivehall_onlydifsex", null, jSONObject.toString());
    }

    public static void r() {
        zn6.d("pageactivehall_reddot", null, new JSONObject().toString());
    }

    public static void s() {
        zn6.d("pageactivehall_tabbutton", null, new JSONObject().toString());
    }

    public static void t() {
        zn6.d("pageactivehall", null, new JSONObject().toString());
    }

    public static void u() {
        zn6.d("pageactivehall_activedetail_unlock", null, new JSONObject().toString());
    }

    public static void v() {
        JSONObject config = vs0.a().getConfig("onlinedynamic_post");
        if (config != null) {
            d = config.optString("postbutton_text", "添加状态");
            e = config.optString("post_intro", "活跃状态发布后24小时有效，有效期内会持续在活跃大厅中展示");
            f = config.optString("postpopup_title", "我的活跃状态");
            g = config.optString("Default_prompt", "说说你现在的心情……");
            h = config.optInt("word_limit", 12);
            i = config.optInt("reddot_fre", 259200);
            j = config.optInt("sameperson_giftpopup_fre", 600);
            k = config.optBoolean("giftpopup_Switch", true);
            LogUtil.d("OnLineManagerTag", "initDhidData postbuttonText " + d + " postIntro " + e + " postpopupTitle " + f + " DefaultPrompt " + g + " wordLimit " + h + " reddotFre " + i + " samepersonGiftpopupFre " + j + " giftpopupSwitch " + k);
        }
    }

    public static boolean w() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - s;
        if (j2 < 800 && j2 > 0) {
            return true;
        }
        s = jCurrentTimeMillis;
        return false;
    }

    public static String x(int i2) {
        int i3 = i2 / 3600;
        int i4 = (i2 % 3600) / 60;
        int i5 = i2 % 60;
        String strValueOf = String.valueOf(i3);
        if (i3 < 10) {
            strValueOf = "0" + strValueOf;
        }
        String strValueOf2 = String.valueOf(i4);
        if (i4 < 10) {
            strValueOf2 = "0" + strValueOf2;
        }
        String strValueOf3 = String.valueOf(i5);
        if (i5 < 10) {
            strValueOf3 = "0" + strValueOf3;
        }
        return strValueOf + ":" + strValueOf2 + ":" + strValueOf3;
    }

    public static void y() {
        l.clear();
    }

    public static void z(OnLineItemData onLineItemData, Activity activity) {
        if (onLineItemData == null || activity == null) {
            return;
        }
        int i2 = onLineItemData.type;
        if (i2 != 2) {
            if (i2 == 1) {
                n(2, onLineItemData.id, onLineItemData.content);
                String str = onLineItemData.uid + "";
                ContactInfoItem contactInfoItemA = !TextUtils.isEmpty(str) ? dn0.a(str) : null;
                if (contactInfoItemA == null) {
                    go0.h(str, "", new f(onLineItemData, activity));
                    return;
                } else {
                    K(contactInfoItemA, onLineItemData, activity);
                    return;
                }
            }
            return;
        }
        if (onLineItemData.uid != 0) {
            l.put(onLineItemData.uid + "", onLineItemData.id);
            if (onLineItemData.mineType != 1) {
                n(1, onLineItemData.id, onLineItemData.content);
                ap3.l(activity, onLineItemData.uid + "", "", 5055);
                C(2, onLineItemData.id);
                return;
            }
            n(3, onLineItemData.id, onLineItemData.content);
            ContactInfoItem contactInfoItemA2 = dn0.a(v4.e(com.zenmen.palmchat.c.b()));
            if (contactInfoItemA2 != null) {
                OnLineDetailData onLineDetailData = new OnLineDetailData();
                onLineDetailData.isMine = true;
                OnLineDetailUserInfo onLineDetailUserInfo = new OnLineDetailUserInfo();
                onLineDetailUserInfo.avatar = contactInfoItemA2.getIconURL();
                onLineDetailUserInfo.nickname = contactInfoItemA2.getNickName();
                onLineDetailUserInfo.gender = contactInfoItemA2.getGender();
                onLineDetailUserInfo.cityName = "同城";
                onLineDetailUserInfo.jobName = contactInfoItemA2.getOccupationForShow();
                onLineDetailUserInfo.age = contactInfoItemA2.getAge();
                onLineDetailUserInfo.onlineDesc = "当前在线";
                onLineDetailData.userInfo = onLineDetailUserInfo;
                OnLineDetailActiveInfo onLineDetailActiveInfo = new OnLineDetailActiveInfo();
                onLineDetailActiveInfo.itemUrl = onLineItemData.url;
                onLineDetailActiveInfo.content = onLineItemData.content;
                onLineDetailData.activeInfo = onLineDetailActiveInfo;
                J(onLineDetailData, 2);
            }
        }
    }
}
