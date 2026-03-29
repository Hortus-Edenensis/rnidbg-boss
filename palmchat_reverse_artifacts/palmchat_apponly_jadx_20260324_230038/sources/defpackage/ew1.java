package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.find.bean.LoadCountBean;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.find.FindNearByMapActivity;
import com.zenmen.palmchat.activity.find.trip.FindMapCheckTripData;
import com.zenmen.palmchat.activity.find.trip.FindMapReleaseData;
import com.zenmen.palmchat.activity.find.trip.FindMapTripInfoActivity;
import com.zenmen.palmchat.activity.find.trip.FindMapTripNearbyPage;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.giftkit.a;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ro2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ew1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17370a = "发布行程";
    public static String b = "试试发布行程,提前约玩附近的人";
    public static String c = "250330";
    public static String d = "发布后，别人可以在地图发现页或动态中看到你的行程，行程过期或被解锁5次后将会消失";
    public static String e = "该行程由用户发布，请仔细辨别真假，避免上当受骗";
    public static HashMap<Integer, String> f = new HashMap<>();
    public static String g = "";
    public static int h = 0;
    public static SimpleDateFormat i = new SimpleDateFormat("HH:mm:ss");
    public static ArrayList<String> j = new ArrayList<>();
    public static Bitmap k = null;
    public static Bitmap l = null;
    public static Bitmap m = null;
    public static Bitmap n = null;
    public static Bitmap o = null;
    public static Bitmap p = null;
    public static LocationEx q = null;
    public static HashMap<String, Bitmap> r = new HashMap<>();
    public static Handler s = new Handler(Looper.getMainLooper());
    public static SimpleDateFormat t = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
    public static List<LoadCountBean.MarkerBean> u = new ArrayList();
    public static boolean v;
    public static boolean w;
    public static boolean x;
    public static long y;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.zenmen.palmchat.activity.find.b f17371a;
        public final /* synthetic */ List b;

        public a(com.zenmen.palmchat.activity.find.b bVar, List list) {
            this.f17371a = bVar;
            this.b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17371a.u(this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<FindMapCheckTripData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FindNearByMapActivity f17372a;

        public b(FindNearByMapActivity findNearByMapActivity) {
            this.f17372a = findNearByMapActivity;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, nl0.z + "/map.schedule.query.v1", new HashMap()).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<FindMapCheckTripData> lXBaseNetBean, Exception exc) {
            LogUtil.d("FindMapTripManager", "releaseTripData info onResult=" + az2.c(lXBaseNetBean));
            ew1.v = false;
            if (lXBaseNetBean != null) {
                ew1.k(this.f17372a, lXBaseNetBean.data, lXBaseNetBean.resultCode != -1009);
            } else {
                ew1.g0();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<JSONObject>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17373a;

        public c(String str) {
            this.f17373a = str;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("scheduleOrderId", this.f17373a);
            return sw4.b(1, nl0.z + "/map.schedule.delete.v1", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
            LogUtil.d("FindMapTripManager", "deleteTripInfo info onResult=" + az2.c(lXBaseNetBean));
            ew1.w = false;
            if (lXBaseNetBean == null) {
                ew1.g0();
                return;
            }
            if (lXBaseNetBean.resultCode == 0) {
                ry5.a("删除成功");
                ds0.a().b(new qw1(4));
            } else {
                if (TextUtils.isEmpty(lXBaseNetBean.errorMsg)) {
                    return;
                }
                ry5.a(lXBaseNetBean.errorMsg);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends go2<LXBaseNetBean<FindMapReleaseData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double f17374a;
        public final /* synthetic */ double b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ long e;
        public final /* synthetic */ int f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Activity h;

        public d(double d, double d2, String str, int i, long j, int i2, String str2, Activity activity) {
            this.f17374a = d;
            this.b = d2;
            this.c = str;
            this.d = i;
            this.e = j;
            this.f = i2;
            this.g = str2;
            this.h = activity;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("longitude", Double.valueOf(this.f17374a));
            map.put("latitude", Double.valueOf(this.b));
            map.put("scheduleAddress", this.c);
            map.put("scheduleTag", Integer.valueOf(this.d));
            map.put("scheduleMomentTs", Long.valueOf(this.e));
            map.put("scheduleMomentTsV2", Long.valueOf(this.e));
            map.put("publishType", Integer.valueOf(this.f));
            map.put("scheduleOrderId", this.g);
            return sw4.b(1, nl0.z + "/map.schedule.publish.v1", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<FindMapReleaseData> lXBaseNetBean, Exception exc) {
            LogUtil.d("FindMapTripManager", "deleteTripInfo info onResult=" + az2.c(lXBaseNetBean));
            ew1.x = false;
            if (lXBaseNetBean == null) {
                ew1.g0();
                return;
            }
            if (lXBaseNetBean.resultCode != 0) {
                ry5.a(lXBaseNetBean.errorMsg);
                return;
            }
            ry5.a("行程发布成功");
            qw1 qw1Var = new qw1(2);
            qw1Var.d = this.f17374a;
            qw1Var.c = this.b;
            ds0.a().b(qw1Var);
            this.h.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends go2<LXBaseNetBean<FindMapReleaseData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f17376a;
        public final /* synthetic */ String b;
        public final /* synthetic */ LoadCountBean.MarkerBean c;
        public final /* synthetic */ Context d;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LXBaseNetBean f17377a;

            public a(LXBaseNetBean lXBaseNetBean) {
                this.f17377a = lXBaseNetBean;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(1000L);
                    f fVar = f.this;
                    ew1.a0(fVar.d, ((FindMapReleaseData) this.f17377a.data).priceBean, fVar.f17376a, fVar.b, fVar.c);
                } catch (Exception unused) {
                }
            }
        }

        public f(long j, String str, LoadCountBean.MarkerBean markerBean, Context context) {
            this.f17376a = j;
            this.b = str;
            this.c = markerBean;
            this.d = context;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("unlockTargetUid", this.f17376a + "");
            map.put("scheduleOrderId", this.b);
            map.put("pandaValueLx62476", ew1.z());
            map.put("taichiGroupLx66032", t66.h().e("LX-66344", "A"));
            return sw4.b(1, nl0.z + "/map.schedule.unlock.v2", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<FindMapReleaseData> lXBaseNetBean, Exception exc) {
            LogUtil.d("FindMapTripManager", "startOtherChat info onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean == null) {
                ew1.g0();
                return;
            }
            int i = lXBaseNetBean.resultCode;
            if (i == 0) {
                ew1.t(this.f17376a, this.b, this.c);
                return;
            }
            if (i == -1004) {
                ry5.a(!TextUtils.isEmpty(lXBaseNetBean.errorMsg) ? lXBaseNetBean.errorMsg : "您的连信豆不足，请先充值后再解锁");
                new Thread(new a(lXBaseNetBean)).start();
                return;
            }
            if (i != -1009 && i != -1008) {
                ry5.a(lXBaseNetBean.errorMsg);
                return;
            }
            ry5.a(!TextUtils.isEmpty(lXBaseNetBean.errorMsg) ? lXBaseNetBean.errorMsg : "该行程动态已消失，看看其他人的行程吧");
            qw1 qw1Var = new qw1(3);
            qw1Var.e = this.c;
            qw1Var.b = this.f17376a + "";
            ds0.a().b(qw1Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements a.InterfaceC1055a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17378a;
        public final /* synthetic */ LoadCountBean.MarkerBean b;

        public g(Context context, LoadCountBean.MarkerBean markerBean) {
            this.f17378a = context;
            this.b = markerBean;
        }

        @Override // com.zenmen.palmchat.giftkit.a.InterfaceC1055a
        public void a(boolean z) {
            LogUtil.d("", "showStartCharge startCharge result success " + z);
            if (z) {
                ew1.e0(this.f17378a, this.b);
            } else {
                ry5.a("充值失败，请稍后再试");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements ro2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f17379a;
        public final /* synthetic */ String b;

        public h(Activity activity, String str) {
            this.f17379a = activity;
            this.b = str;
        }

        @Override // ro2.b
        public void a(ContactInfoItem contactInfoItem) {
            if (this.f17379a != null) {
                if (!ew1.L(this.b)) {
                    contactInfoItem.setUid(this.b);
                    contactInfoItem.setSourceType(60);
                    contactInfoItem.setBizType(5035);
                    ap3.j(this.f17379a, contactInfoItem, 5035);
                    return;
                }
                contactInfoItem.setBizType(0);
                Intent intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
                intent.putExtra("chat_item", contactInfoItem);
                intent.putExtra("thread_biz_type", contactInfoItem.getBizType());
                intent.putExtra("chat_need_back_to_main", false);
                intent.putExtra("chat_back_to_greet", false);
                k86.X(intent);
                this.f17379a.startActivity(intent);
            }
        }

        @Override // ro2.b
        public void onError(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "获取用户信息失败";
            }
            ry5.a(str);
        }
    }

    static {
        H();
        v = false;
        w = false;
        x = false;
        y = 0L;
    }

    public static HashMap<String, ArrayList<String>> A() {
        int i2;
        try {
            String[] strArrSplit = i.format(Long.valueOf(ir5.c(true))).split(":");
            long j2 = 0;
            for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                if (i3 == 0) {
                    j2 = Integer.parseInt(strArrSplit[i3]) * 60 * 60;
                }
                if (i3 == 1) {
                    j2 += (long) (Integer.parseInt(strArrSplit[i3]) * 60);
                }
                if (i3 == 2) {
                    j2 += (long) Integer.parseInt(strArrSplit[i3]);
                }
            }
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i4 = 0;
            while (true) {
                if (i4 >= j.size()) {
                    i2 = 0;
                    break;
                }
                if (j2 > ((long) i4) * 1800) {
                    i2 = i4 + 1;
                    if (j2 <= ((long) i2) * 1800) {
                        break;
                    }
                }
                i4++;
            }
            for (int i5 = 0; i5 < i2; i5++) {
                arrayList2.add(j.get(i5));
            }
            while (i2 < j.size()) {
                arrayList.add(j.get(i2));
                i2++;
            }
            map.put("timeToday", arrayList);
            map.put("timeTomorrow", arrayList2);
            return map;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String B(long j2) {
        if (j2 > 0) {
            try {
                return cy5.h(j2);
            } catch (Exception e2) {
                LogUtil.d("FindMapTripManager", "getTripCreateTimeByTs Exception momentTs " + j2 + " e " + e2.toString());
            }
        }
        return "1天前";
    }

    public static String C() {
        return v4.e(AppContext.getContext()) + "_map_trip_unlock_data";
    }

    public static String D(long j2) {
        try {
            String strY = y(j2);
            t.setTimeZone(TimeZone.getDefault());
            String[] strArrSplit = t.format(Long.valueOf(j2)).split(":");
            if (TextUtils.isEmpty(strY)) {
                return strArrSplit[1] + "月/" + strArrSplit[2] + "日";
            }
            return strY + strArrSplit[3] + ":" + strArrSplit[4];
        } catch (Exception unused) {
            return "";
        }
    }

    public static String E(long j2) {
        try {
            String strY = y(j2);
            t.setTimeZone(TimeZone.getDefault());
            String[] strArrSplit = t.format(Long.valueOf(j2)).split(":");
            if (!TextUtils.isEmpty(strY)) {
                return strY + strArrSplit[3] + ":" + strArrSplit[4];
            }
            return strArrSplit[0] + "年/" + strArrSplit[1] + "月/" + strArrSplit[2] + "日 " + strArrSplit[3] + ":" + strArrSplit[4];
        } catch (Exception unused) {
            return "";
        }
    }

    public static long F(String str, String str2) {
        SharedPreferences sharedPreferences = AppContext.getContext().getSharedPreferences("map_trip_status_sp_name_new", 0);
        String strC = C();
        if (!sharedPreferences.contains(strC)) {
            return 0L;
        }
        String string = sharedPreferences.getString(strC, "");
        if (TextUtils.isEmpty(string)) {
            return 0L;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() <= 0) {
                return 0L;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                long jOptLong = jSONObjectOptJSONObject.optLong(DeviceInfoUtil.UID_TAG);
                String strOptString = jSONObjectOptJSONObject.optString("scheduleOrderId");
                if (str2.equals(strOptString) && Long.parseLong(str) == jOptLong) {
                    long jOptLong2 = jSONObjectOptJSONObject.optLong("tripUnlockTime");
                    LogUtil.d("FindMapTripManager", "getUnlockTripTime saveTrip return true uid " + str + " resTripId " + strOptString + " tripUnlockTime " + jOptLong2);
                    return jOptLong2;
                }
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static void G() {
        JSONObject jSONObjectOptJSONObject;
        if (K()) {
            JSONObject config = vs0.a().getConfig("mapFinderConfig");
            if (config != null && (jSONObjectOptJSONObject = config.optJSONObject("itineraryConfig")) != null) {
                f17370a = jSONObjectOptJSONObject.optString("post_buttontext");
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("Guiding_bubble");
                if (jSONObjectOptJSONObject2 != null) {
                    b = jSONObjectOptJSONObject2.optString("text");
                    c = jSONObjectOptJSONObject2.optString("version");
                }
                d = jSONObjectOptJSONObject.optString("post_releaseintro");
                e = jSONObjectOptJSONObject.optString("post_unlockintro");
                I(jSONObjectOptJSONObject.optJSONArray("tagList"));
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("unlockcost_text");
                if (jSONObjectOptJSONObject3 != null) {
                    String str = "Group_" + z();
                    if (jSONObjectOptJSONObject3.has(str)) {
                        g = jSONObjectOptJSONObject3.optString(str);
                    }
                }
            }
            LogUtil.d("FindMapTripManager", "initDhIdConfig tripButtonTitle " + f17370a + " tripBubbleTitle " + b + " tripBubbleVersion " + c + " releaseEditTitle " + d + " unlockIntroTitle " + e);
        }
        m();
    }

    public static void H() {
        if (j.size() == 0) {
            j.add("00:00");
            j.add("00:30");
            j.add("01:00");
            j.add("01:30");
            j.add("02:00");
            j.add("02:30");
            j.add("03:00");
            j.add("03:30");
            j.add("04:00");
            j.add("04:30");
            j.add("05:00");
            j.add("05:30");
            j.add("06:00");
            j.add("06:30");
            j.add("07:00");
            j.add("07:30");
            j.add("08:00");
            j.add("08:30");
            j.add("09:00");
            j.add("09:30");
            j.add("10:00");
            j.add("10:30");
            j.add("11:00");
            j.add("11:30");
            j.add("12:00");
            j.add("12:30");
            j.add("13:00");
            j.add("13:30");
            j.add("14:00");
            j.add("14:30");
            j.add("15:00");
            j.add("15:30");
            j.add("16:00");
            j.add("16:30");
            j.add("17:00");
            j.add("17:30");
            j.add("18:00");
            j.add("18:30");
            j.add("19:00");
            j.add("19:30");
            j.add("20:00");
            j.add("20:30");
            j.add("21:00");
            j.add("21:30");
            j.add("22:00");
            j.add("22:30");
            j.add("23:00");
            j.add("23:30");
        }
        if (f.size() == 0) {
            f.put(1, "求偶遇");
            f.put(2, "交朋友");
            f.put(3, "约吃饭");
            f.put(4, "运动");
            f.put(5, "约逛街");
            f.put(6, "约电影");
            f.put(7, "玩游戏");
            f.put(8, "约咖啡");
            f.put(9, "约奶茶");
            f.put(10, "出差");
            f.put(11, "聊聊天");
        }
    }

    public static void I(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        f.clear();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                String[] strArrSplit = jSONArray.optString(i2).split("_");
                if (strArrSplit != null && strArrSplit.length == 2) {
                    try {
                        f.put(Integer.valueOf(Integer.parseInt(strArrSplit[0])), strArrSplit[1]);
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                return;
            }
        }
    }

    public static boolean J() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - y;
        if (j2 < 1000 && j2 > 0) {
            return true;
        }
        y = jCurrentTimeMillis;
        return false;
    }

    public static boolean K() {
        return !"A".contains(z());
    }

    public static boolean L(String str) {
        ContactInfoItem contactInfoItemL;
        return (TextUtils.isEmpty(str) || (contactInfoItemL = bo0.r().l(str)) == null || contactInfoItemL.getIsStranger()) ? false : true;
    }

    public static boolean M(String str, String str2) {
        SharedPreferences sharedPreferences = AppContext.getContext().getSharedPreferences("map_trip_status_sp_name_new", 0);
        String strC = C();
        if (sharedPreferences.contains(strC)) {
            String string = sharedPreferences.getString(strC, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    if (jSONArray.length() > 0) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                            long jOptLong = jSONObjectOptJSONObject.optLong(DeviceInfoUtil.UID_TAG);
                            String strOptString = jSONObjectOptJSONObject.optString("scheduleOrderId");
                            if (str2.equals(strOptString) && Long.parseLong(str) == jOptLong) {
                                LogUtil.d("FindMapTripManager", "isUnlockTrip saveTrip return true uid " + str + " resTripId " + strOptString);
                                return true;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    public static void N(List<LoadCountBean.MarkerBean> list, com.zenmen.palmchat.activity.find.b bVar) {
        if (bVar != null) {
            List<LoadCountBean.MarkerBean> list2 = u;
            if (list2 != null && list != null) {
                list2.clear();
                u.addAll(list);
            }
            s.postDelayed(new a(bVar, list), 1000L);
        }
    }

    public static void O(List<LoadCountBean.MarkerBean> list, LocationEx locationEx, float f2, View view, com.zenmen.palmchat.activity.find.b bVar) {
        if (K()) {
            q = locationEx;
            N(list, bVar);
        }
    }

    public static void P() {
        Bitmap bitmap = k;
        if (bitmap != null) {
            bitmap.recycle();
            k = null;
        }
        Bitmap bitmap2 = l;
        if (bitmap2 != null) {
            bitmap2.recycle();
            l = null;
        }
        Bitmap bitmap3 = m;
        if (bitmap3 != null) {
            bitmap3.recycle();
            m = null;
        }
        Bitmap bitmap4 = n;
        if (bitmap4 != null) {
            bitmap4.recycle();
            n = null;
        }
        Bitmap bitmap5 = o;
        if (bitmap5 != null) {
            bitmap5.recycle();
            o = null;
        }
        Bitmap bitmap6 = p;
        if (bitmap6 != null) {
            bitmap6.recycle();
            p = null;
        }
        List<LoadCountBean.MarkerBean> list = u;
        if (list != null) {
            list.clear();
        }
        s();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void Q(FindNearByMapActivity findNearByMapActivity, LoadCountBean.MarkerBean markerBean, int i2) {
        boolean z;
        if (J() || markerBean == null) {
            return;
        }
        String strE = v4.e(com.zenmen.palmchat.c.b());
        if (!TextUtils.isEmpty(strE)) {
            StringBuilder sb = new StringBuilder();
            sb.append(markerBean.uid);
            sb.append("");
            z = strE.equals(sb.toString());
        }
        LogUtil.d("FindMapTripManager", "onMarkerClick myUid " + strE + " isMySelf " + z);
        if (!z) {
            new cw1(findNearByMapActivity, markerBean, i2).show();
            return;
        }
        FindMapCheckTripData findMapCheckTripData = new FindMapCheckTripData();
        findMapCheckTripData.longitude = markerBean.longitude;
        findMapCheckTripData.latitude = markerBean.latitude;
        findMapCheckTripData.scheduleAddress = markerBean.scheduleAddress;
        findMapCheckTripData.scheduleTag = markerBean.scheduleTag;
        findMapCheckTripData.scheduleMomentTs = markerBean.scheduleMomentTs;
        findMapCheckTripData.scheduleMomentTsV2 = markerBean.scheduleMomentTsV2;
        findMapCheckTripData.createTime = markerBean.createTime;
        findMapCheckTripData.scheduleOrderId = markerBean.scheduleOrderId;
        Z(findNearByMapActivity, findMapCheckTripData);
    }

    public static void R(FindNearByMapActivity findNearByMapActivity) {
        LogUtil.d("FindMapTripManager", "releaseTripData isReleaseRequesting " + v);
        if (v) {
            return;
        }
        v = true;
        zw4.e(new b(findNearByMapActivity));
    }

    public static void S(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }

    public static void T(String str, Bitmap bitmap) {
        if (TextUtils.isEmpty(str) || bitmap == null) {
            return;
        }
        r.put(str, bitmap);
    }

    public static void U() {
        com.zenmen.palmchat.c.b().getSharedPreferences("find_map_nearby_red_sp", 0).edit().putInt(x(), 0).apply();
    }

    public static synchronized void V(String str, String str2, LoadCountBean.MarkerBean markerBean) {
        JSONArray jSONArray;
        SharedPreferences sharedPreferences = AppContext.getContext().getSharedPreferences("map_trip_status_sp_name_new", 0);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (markerBean != null) {
            try {
                markerBean.tripUnlockTime = jCurrentTimeMillis;
                JSONObject jSONObjectN = n(markerBean);
                if (jSONObjectN != null) {
                    String string = sharedPreferences.getString(C(), "");
                    if (TextUtils.isEmpty(string)) {
                        jSONArray = new JSONArray();
                        jSONArray.put(jSONObjectN);
                    } else {
                        JSONArray jSONArray2 = new JSONArray(string);
                        if (jSONArray2.length() > 0) {
                            jSONArray2.put(jSONObjectN);
                        }
                        jSONArray = jSONArray2;
                    }
                    LogUtil.d("FindMapTripManager", "saveTrip saveUnlockTrip arrayMarker " + jSONArray);
                    sharedPreferences.edit().putString(C(), jSONArray.toString()).apply();
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void W(double d2, double d3, String str, int i2, long j2, int i3, String str2, Activity activity) {
        if (x) {
            return;
        }
        x = true;
        zw4.e(new d(d2, d3, str, i2, j2, i3, str2, activity));
    }

    public static void X() {
        com.zenmen.palmchat.c.b().getSharedPreferences("find_map_nearby_red_sp", 0).edit().putInt(x(), 1).apply();
    }

    public static void Y() {
        SPUtil.f14322a.v(SPUtil.SCENE.SQUARE, "key_map_trip_bubble_show", -1);
    }

    public static void Z(FindNearByMapActivity findNearByMapActivity, FindMapCheckTripData findMapCheckTripData) {
        new aw1(findNearByMapActivity, findMapCheckTripData).show();
        LocationEx locationEx = new LocationEx();
        locationEx.setLongitude(findMapCheckTripData.longitude);
        locationEx.setLatitude(findMapCheckTripData.latitude);
        q = locationEx;
        findNearByMapActivity.O3(locationEx);
    }

    public static void a0(Context context, long j2, long j3, String str, LoadCountBean.MarkerBean markerBean) {
        if (!hx3.m(context)) {
            g0();
        } else {
            com.zenmen.palmchat.giftkit.a.a().b(context, of2.f(h + 8200, 1001, "", 0, "", 0), j2, new g(context, markerBean));
        }
    }

    public static void b0(String str) {
        try {
            Application applicationB = com.zenmen.palmchat.c.b();
            Intent intent = new Intent(applicationB, (Class<?>) FindMapTripInfoActivity.class);
            if (!(applicationB instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("trip_scheduleOrderId_tag", str);
            }
            applicationB.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void c0(Activity activity, String str, String str2) {
        try {
            Intent intent = new Intent(activity, (Class<?>) FindMapTripNearbyPage.class);
            if (!(activity instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("trip_address_tag", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("trip_distance_tag", str2);
            }
            activity.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void d0(String str) {
        LocationEx locationEx = q;
        if (!TextUtils.isEmpty(locationEx != null ? locationEx.getAddress() : "") || q == null) {
            b0(str);
        } else {
            dw1.F("startTripInfoView", com.zenmen.palmchat.c.b(), new e(str), q);
        }
    }

    public static void e0(Context context, LoadCountBean.MarkerBean markerBean) {
        zw4.e(new f(markerBean.uid, markerBean.scheduleOrderId, markerBean, context));
    }

    public static void f0(LoadCountBean.MarkerBean markerBean, Activity activity) {
        if (markerBean == null) {
            return;
        }
        String str = markerBean.uid + "";
        bj5.b().a().J(str, new h(activity, str));
    }

    public static boolean g() {
        return com.zenmen.palmchat.c.b().getSharedPreferences("find_map_nearby_red_sp", 0).getInt(x(), 0) == 0;
    }

    public static void g0() {
        ry5.a("网络好像有点问题，稍后再试");
    }

    public static boolean h(String str, String str2) {
        return (L(str) || M(str, str2)) ? false : true;
    }

    public static boolean h0() {
        return !"A".equals(t66.h().e("LX-67222", "A"));
    }

    public static boolean i() {
        if (SPUtil.f14322a.h(SPUtil.SCENE.SQUARE, "key_map_trip_bubble_show", 0) != -1 && !TextUtils.isEmpty(ac1.f)) {
            try {
                int i2 = Integer.parseInt(ac1.f);
                int i3 = Integer.parseInt(c);
                LogUtil.d("FindMapTripManager", "allowShowTripBubble clientVersion " + i2 + " bubbleConfigVersion " + i3);
                if (i2 <= i3) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static void i0(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", str);
            jSONObject.put("fuid", str2);
            jSONObject.put("itineraryID", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("page_mapfinder_itinerary", null, jSONObject.toString());
    }

    public static void j(String str, ImageView imageView) {
        LogUtil.d("FindMapTripManager", "blurAdBg imgUrl " + str + " imageView " + imageView);
        if (imageView != null) {
            imageView.setImageResource(R.drawable.nest_blur_def_bg);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(str)).placeholder(R.drawable.default_portrait).transform(new y5(10, 1)).into(imageView);
        }
    }

    public static void j0() {
        zn6.d("page_mapfinder_nearbyitinerary", null, new JSONObject().toString());
    }

    public static void k(FindNearByMapActivity findNearByMapActivity, FindMapCheckTripData findMapCheckTripData, boolean z) {
        if (!z) {
            d0(null);
        } else {
            if (findNearByMapActivity == null || findNearByMapActivity.isFinishing() || findMapCheckTripData == null) {
                return;
            }
            Z(findNearByMapActivity, findMapCheckTripData);
        }
    }

    public static void k0() {
        zn6.d("page_mapfinder_nearbyitinerarylist_clickchat", null, new JSONObject().toString());
    }

    public static void l(FindNearByMapActivity findNearByMapActivity, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            LoadCountBean.MarkerBean markerBean = (LoadCountBean.MarkerBean) az2.a(new JSONObject(str).optJSONObject("nearbySchedule").toString(), LoadCountBean.MarkerBean.class);
            if (markerBean != null) {
                Q(findNearByMapActivity, markerBean, 1);
            }
        } catch (Exception unused) {
        }
    }

    public static void l0() {
        zn6.d("page_mapfinder_nearbyitinerarylist_clickunlock", null, new JSONObject().toString());
    }

    public static synchronized void m() {
        if (K()) {
            q();
        }
    }

    public static void m0() {
        zn6.d("page_mapfinder_nearbyitinerarylist_close", null, new JSONObject().toString());
    }

    public static JSONObject n(LoadCountBean.MarkerBean markerBean) {
        if (markerBean == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("age", markerBean.age);
            jSONObject.put("avatar", markerBean.avatar);
            jSONObject.put("beanType", markerBean.beanType);
            jSONObject.put("createTime", markerBean.createTime);
            jSONObject.put("distanceMi", markerBean.distanceMi);
            jSONObject.put("gender", markerBean.gender);
            jSONObject.put("isBlur", markerBean.isBlur);
            jSONObject.put("jobCode", markerBean.jobCode);
            jSONObject.put("latitude", markerBean.latitude);
            jSONObject.put("longitude", markerBean.longitude);
            jSONObject.put("nickname", markerBean.nickname);
            jSONObject.put("scheduleAddress", markerBean.scheduleAddress);
            jSONObject.put("userKind", markerBean.userKind);
            jSONObject.put("scheduleMomentTs", markerBean.scheduleMomentTs);
            jSONObject.put("scheduleMomentTsV2", markerBean.scheduleMomentTsV2);
            jSONObject.put("scheduleOrderId", markerBean.scheduleOrderId);
            jSONObject.put("scheduleTag", markerBean.scheduleTag);
            jSONObject.put(DeviceInfoUtil.UID_TAG, markerBean.uid);
            jSONObject.put("tripUnlockTime", markerBean.tripUnlockTime);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void n0(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("page_mapfinder_nearbyitinerarylist_clickit", null, jSONObject.toString());
    }

    public static LoadCountBean.MarkerBean o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LoadCountBean.MarkerBean markerBean = new LoadCountBean.MarkerBean();
        markerBean.age = jSONObject.optInt("age");
        markerBean.avatar = jSONObject.optString("avatar");
        markerBean.beanType = jSONObject.optInt("beanType");
        markerBean.createTime = jSONObject.optLong("createTime");
        markerBean.distanceMi = jSONObject.optString("distanceMi");
        markerBean.gender = jSONObject.optInt("gender");
        markerBean.isBlur = jSONObject.optBoolean("isBlur");
        markerBean.jobCode = jSONObject.optInt("jobCode");
        markerBean.latitude = jSONObject.optDouble("latitude");
        markerBean.longitude = jSONObject.optDouble("longitude");
        markerBean.nickname = jSONObject.optString("nickname");
        markerBean.scheduleAddress = jSONObject.optString("scheduleAddress");
        markerBean.userKind = jSONObject.optInt("userKind");
        markerBean.scheduleMomentTs = jSONObject.optLong("scheduleMomentTs");
        markerBean.scheduleMomentTsV2 = jSONObject.optLong("scheduleMomentTsV2");
        markerBean.scheduleOrderId = jSONObject.optString("scheduleOrderId");
        markerBean.scheduleTag = jSONObject.optInt("scheduleTag");
        markerBean.uid = jSONObject.optLong(DeviceInfoUtil.UID_TAG);
        markerBean.tripUnlockTime = jSONObject.optLong("tripUnlockTime");
        return markerBean;
    }

    public static void o0(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("page_mapfinder_nearbyitinerarylist", null, jSONObject.toString());
    }

    public static long p(boolean z, String str) {
        try {
            long jC = ir5.c(true);
            if (z) {
                jC += 86400000;
            }
            return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).parse(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(jC)) + " " + str).getTime();
        } catch (Exception unused) {
            return ir5.c(true);
        }
    }

    public static void p0(ArrayList<LoadCountBean.MarkerBean> arrayList) {
        if (arrayList != null) {
            SharedPreferences sharedPreferences = AppContext.getContext().getSharedPreferences("map_trip_status_sp_name_new", 0);
            String strC = C();
            if (sharedPreferences.contains(strC)) {
                sharedPreferences.edit().remove(strC).apply();
            }
            JSONArray jSONArray = new JSONArray();
            if (arrayList.size() > 0) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    LoadCountBean.MarkerBean markerBean = arrayList.get(i2);
                    if (markerBean != null) {
                        jSONArray.put(n(markerBean));
                    }
                }
                sharedPreferences.edit().putString(strC, jSONArray.toString()).apply();
            }
            LogUtil.d("FindMapTripManager", "saveTrip updateNewUnlockMark array " + jSONArray.toString());
        }
    }

    public static List<LoadCountBean.MarkerBean> q() {
        JSONArray jSONArray;
        int length;
        String string = AppContext.getContext().getSharedPreferences("map_trip_status_sp_name_new", 0).getString(C(), "");
        try {
            LogUtil.d("FindMapTripManager", "saveTrip createSpUnlockMarker allMarkerData " + string);
            if (TextUtils.isEmpty(string) || (length = (jSONArray = new JSONArray(string)).length()) <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    LoadCountBean.MarkerBean markerBeanO = o(jSONObjectOptJSONObject);
                    LogUtil.d("FindMapTripManager", "saveTrip createSpUnlockMarker i " + i2 + " markerBean " + markerBeanO);
                    if (markerBeanO != null) {
                        long j2 = markerBeanO.tripUnlockTime;
                        if (j2 <= 0 || jCurrentTimeMillis - j2 >= 86400000) {
                            LogUtil.d("FindMapTripManager", "saveTrip createSpUnlockMarker i " + i2 + " timeout error ");
                        } else {
                            arrayList.add(markerBeanO);
                        }
                    }
                }
            }
            LogUtil.d("FindMapTripManager", "saveTrip createSpUnlockMarker allBean.size() " + arrayList.size() + " arrayLength " + length);
            if (arrayList.size() < length) {
                p0(arrayList);
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void r(String str, Context context) {
        if (TextUtils.isEmpty(str) || w) {
            return;
        }
        w = true;
        zw4.e(new c(str));
    }

    public static void s() {
        r.clear();
    }

    public static void t(long j2, String str, LoadCountBean.MarkerBean markerBean) {
        V(j2 + "", str, markerBean);
        qw1 qw1Var = new qw1(1);
        qw1Var.b = j2 + "";
        qw1Var.e = markerBean;
        ds0.a().b(qw1Var);
    }

    public static Bitmap u(Bitmap bitmap, LoadCountBean.MarkerBean markerBean, int i2) {
        int iB = a46.b(AppContext.getContext(), 39.0f);
        int iB2 = a46.b(AppContext.getContext(), 39.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iB, iB2, Bitmap.Config.ARGB_8888);
        int iB3 = iB2 - a46.b(AppContext.getContext(), 10.0f);
        int iMin = Math.min(bitmap.getHeight(), bitmap.getWidth());
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (bitmap.getWidth() * iB3) / iMin, (iB3 * bitmap.getHeight()) / iMin, false);
        markerBean.isBlur = false;
        if (i2 != -1) {
            if (h(markerBean.uid + "", markerBean.scheduleOrderId)) {
                markerBean.isBlur = true;
                bitmapCreateScaledBitmap = ft1.a(bitmapCreateScaledBitmap, 10, true);
            }
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateScaledBitmap, tileMode, tileMode));
        canvas.drawCircle(a46.b(AppContext.getContext(), 20.0f), a46.b(AppContext.getContext(), 20.0f), a46.b(AppContext.getContext(), 19.0f), paint);
        int i3 = markerBean.gender;
        if (i3 != -1) {
            int iB4 = a46.b(AppContext.getContext(), 14.0f);
            int iB5 = a46.b(AppContext.getContext(), 14.0f);
            int iB6 = a46.b(AppContext.getContext(), 24.0f);
            try {
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(AppContext.getContext().getResources(), i3 == 0 ? R.drawable.map_sex_male : R.drawable.map_sex_female);
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeResource, iB4, iB5, false);
                float f2 = iB6;
                canvas.drawBitmap(bitmapCreateScaledBitmap2, f2, f2, (Paint) null);
                bitmapDecodeResource.recycle();
                bitmapCreateScaledBitmap2.recycle();
            } catch (Exception e2) {
                LogUtil.d("FindMapTripManager", "genAvatarMark Exception " + e2.toString());
            }
        }
        bitmapCreateScaledBitmap.recycle();
        return bitmapCreateBitmap;
    }

    public static Bitmap v(Bitmap bitmap, LoadCountBean.MarkerBean markerBean, int i2) {
        if (bitmap == null) {
            return bitmap;
        }
        int iB = a46.b(AppContext.getContext(), 135.0f);
        int iB2 = a46.b(AppContext.getContext(), 58.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iB, iB2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        if (k == null) {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.trip_map_mark_all_bg);
            l = bitmapDecodeResource;
            k = Bitmap.createScaledBitmap(bitmapDecodeResource, iB, iB2, false);
        }
        if (o == null) {
            Bitmap bitmapDecodeResource2 = BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.trip_map_mark_tag_bg);
            p = bitmapDecodeResource2;
            o = Bitmap.createScaledBitmap(bitmapDecodeResource2, a46.b(AppContext.getContext(), 12.0f), a46.b(AppContext.getContext(), 11.0f), false);
        }
        if (m == null) {
            if (h0()) {
                n = BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.trip_map_mark_time_new_bg);
            } else {
                n = BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.trip_map_mark_time_bg);
            }
            m = Bitmap.createScaledBitmap(n, a46.b(AppContext.getContext(), 12.0f), a46.b(AppContext.getContext(), 12.0f), false);
        }
        canvas.drawBitmap(k, 0.0f, 0.0f, (Paint) null);
        Bitmap bitmapU = u(bitmap, markerBean, i2);
        if (bitmapU != null) {
            canvas.drawBitmap(bitmapU, a46.b(AppContext.getContext(), 8.0f), a46.b(AppContext.getContext(), 4.0f), (Paint) null);
            bitmapU.recycle();
        }
        float fB = a46.b(AppContext.getContext(), 55.0f);
        canvas.drawBitmap(m, fB, a46.b(AppContext.getContext(), 10.0f), (Paint) null);
        canvas.drawBitmap(o, fB, a46.b(AppContext.getContext(), 28.0f), (Paint) null);
        String createShow = h0() ? markerBean.getCreateShow() : D(markerBean.scheduleMomentTs);
        if (!TextUtils.isEmpty(createShow)) {
            Paint paint = new Paint();
            paint.setTextSize(a46.b(AppContext.getContext(), 12.0f));
            paint.setColor(Color.parseColor("#222222"));
            canvas.drawText(createShow, a46.b(AppContext.getContext(), 72.0f), a46.b(AppContext.getContext(), 20.0f), paint);
        }
        String tripTag = markerBean.getTripTag();
        if (!TextUtils.isEmpty(tripTag)) {
            Paint paint2 = new Paint();
            paint2.setTextSize(a46.b(AppContext.getContext(), 12.0f));
            paint2.setColor(Color.parseColor("#222222"));
            canvas.drawText(tripTag, a46.b(AppContext.getContext(), 72.0f), a46.b(AppContext.getContext(), 37.0f), paint2);
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap w(String str) {
        if (TextUtils.isEmpty(str) || !r.containsKey(str) || r.get(str).isRecycled()) {
            return null;
        }
        return r.get(str);
    }

    public static String x() {
        return v4.e(AppContext.getContext()) + "find_map_nearby_red_key";
    }

    public static String y(long j2) {
        if (j2 <= 0) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ir5.c(true));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        S(calendar);
        S(calendar2);
        long timeInMillis = (calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / 86400000;
        return timeInMillis == 0 ? "今天" : timeInMillis == -1 ? "昨天" : timeInMillis == 1 ? "明天" : "";
    }

    public static String z() {
        return WkAdxAdConfigMg.DSP_NAME_CSJ;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements i53 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17375a;

        public e(String str) {
            this.f17375a = str;
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
            ew1.q.setAddress(str);
            ew1.b0(this.f17375a);
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }
}
