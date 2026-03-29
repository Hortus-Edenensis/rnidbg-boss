package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.api.model.AdnName;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.utils.Async;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.aichat.AiCHatBuyDialogBaseActivity;
import com.zenmen.palmchat.aichat.AiChatBuyDialogView;
import com.zenmen.palmchat.aichat.AiChatErrorDialogView;
import com.zenmen.palmchat.aichat.AiChatGuardBean;
import com.zenmen.palmchat.aichat.AiChatMsgBuySkuBean;
import com.zenmen.palmchat.aichat.AiChatMsgSku;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.conversations.threadsnew.newfriend.NewFriendAdapter;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.giftkit.a;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.mvp.model.bean.NearByResp;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class v8 {
    public static ArrayList<String> B;
    public static boolean C;
    public static long D;
    public static HashMap<String, Boolean> E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayList<Integer> f21374a = new ArrayList<>();
    public static int b = 2;
    public static ArrayList<Integer> c = new ArrayList<>();
    public static int d = 2;
    public static ArrayList<Integer> e = new ArrayList<>();
    public static int f = 5;
    public static ArrayList<Integer> g = new ArrayList<>();
    public static int h = 2;
    public static ArrayList<Integer> i = new ArrayList<>();
    public static int j = 2;
    public static int k = 3600;
    public static ContactRequestsVO l = null;
    public static boolean m = true;
    public static boolean n = true;
    public static boolean o = true;
    public static String p = "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-24-2-b356b4728bf74ceea3d80f8f99befc05-t20bpb";
    public static String q = "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-24-2-b356b4728bf74ceea3d80f8f99befc05-t20bpb";
    public static String r = "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-24-2-e59ae27fddc64feda88bedacd2ad9039-t20bq2";
    public static String s = "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-24-2-b356b4728bf74ceea3d80f8f99befc05-t20bpb";
    public static String t = "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-24-2-b356b4728bf74ceea3d80f8f99befc05-t20bpb";
    public static String u = "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-24-2-e59ae27fddc64feda88bedacd2ad9039-t20bq2";
    public static SimpleDateFormat v = new SimpleDateFormat("yyyy·MM·dd", Locale.getDefault());
    public static int w = 0;
    public static int x = 120;
    public static int y = 120;
    public static boolean z = false;
    public static boolean A = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<AiChatMsgBuySkuBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f21375a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ int g;

        public a(long j, long j2, int i, Context context, int i2, String str, int i3) {
            this.f21375a = j;
            this.b = j2;
            this.c = i;
            this.d = context;
            this.e = i2;
            this.f = str;
            this.g = i3;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("fuid", Long.valueOf(this.f21375a));
            map.put(DeviceInfoUtil.UID_TAG, Long.valueOf(this.b));
            map.put("gender", Integer.valueOf(this.c));
            return sw4.b(1, nl0.z + "/customer.service.virtual.sku", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<AiChatMsgBuySkuBean> lXBaseNetBean, Exception exc) {
            AiChatMsgBuySkuBean aiChatMsgBuySkuBean;
            v8.C = false;
            LogUtil.d("AiChatPeopleManagerTag", "showAiBuyGuardDialog info onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean == null || lXBaseNetBean.resultCode != 0 || (aiChatMsgBuySkuBean = lXBaseNetBean.data) == null) {
                Context context = this.d;
                if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                    return;
                }
                AiChatErrorDialogView aiChatErrorDialogView = new AiChatErrorDialogView(this.d, R.style.SuperExposeDialogViewStyle);
                aiChatErrorDialogView.x(2);
                aiChatErrorDialogView.v(0.99f);
                aiChatErrorDialogView.J(this.c);
                aiChatErrorDialogView.I(this.f21375a);
                aiChatErrorDialogView.K(this.b);
                aiChatErrorDialogView.G(this.g);
                aiChatErrorDialogView.H(this.e);
                aiChatErrorDialogView.show();
                return;
            }
            AiChatMsgBuySkuBean aiChatMsgBuySkuBean2 = aiChatMsgBuySkuBean;
            aiChatMsgBuySkuBean2.fuid = this.f21375a;
            aiChatMsgBuySkuBean2.uid = this.b;
            Context context2 = this.d;
            if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                return;
            }
            AiChatBuyDialogView aiChatBuyDialogView = new AiChatBuyDialogView(this.d, R.style.SuperExposeDialogViewStyle, this.e, this.f);
            aiChatBuyDialogView.x(2);
            aiChatBuyDialogView.v(0.99f);
            aiChatBuyDialogView.P(this.c);
            aiChatBuyDialogView.show();
            aiChatBuyDialogView.O(aiChatMsgBuySkuBean2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements hk2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f21376a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;

        public b(long j, String str, Context context, String str2) {
            this.f21376a = j;
            this.b = str;
            this.c = context;
            this.d = str2;
        }

        @Override // defpackage.hk2
        public void onResult(int i) {
            if (i == 1) {
                r8 r8Var = new r8(2);
                v8.J(this.f21376a + "", this.b + "", 1);
                r8Var.d = 1;
                ds0.a().b(r8Var);
                sy5.h(this.c, "你已成功开通守护，继续和" + this.d + "畅聊吧", 0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements a.InterfaceC1055a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gk2 f21377a;
        public final /* synthetic */ Context b;

        public c(gk2 gk2Var, Context context) {
            this.f21377a = gk2Var;
            this.b = context;
        }

        @Override // com.zenmen.palmchat.giftkit.a.InterfaceC1055a
        public void a(boolean z) {
            LogUtil.d("AiChatPeopleManagerTag", "showStartCharge startCharge result success " + z);
            gk2 gk2Var = this.f21377a;
            if (gk2Var != null) {
                gk2Var.a(z);
            }
            if (z) {
                return;
            }
            sy5.h(this.b, "充值失败，请稍后再试", 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends go2<LXBaseNetBean<AiChatGuardBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f21378a;
        public final /* synthetic */ long b;
        public final /* synthetic */ hk2 c;

        public d(long j, long j2, hk2 hk2Var) {
            this.f21378a = j;
            this.b = j2;
            this.c = hk2Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("fuid", Long.valueOf(this.f21378a));
            map.put(DeviceInfoUtil.UID_TAG, Long.valueOf(this.b));
            return sw4.b(1, nl0.z + "/customer.service.virtual.query.guard.status", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<AiChatGuardBean> lXBaseNetBean, Exception exc) {
            AiChatGuardBean aiChatGuardBean;
            LogUtil.d("AiChatPeopleManagerTag", "postCheckOpenGuard info onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean == null || lXBaseNetBean.resultCode != 0 || (aiChatGuardBean = lXBaseNetBean.data) == null) {
                hk2 hk2Var = this.c;
                if (hk2Var != null) {
                    hk2Var.onResult(0);
                    return;
                }
                return;
            }
            AiChatGuardBean aiChatGuardBean2 = aiChatGuardBean;
            hk2 hk2Var2 = this.c;
            if (hk2Var2 != null) {
                hk2Var2.onResult(aiChatGuardBean2.status);
            }
            v8.J(this.f21378a + "", this.b + "", aiChatGuardBean2.status);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends go2<LXBaseNetBean<NearByResp>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f21379a;

            public a(String str) {
                this.f21379a = str;
            }

            @Override // defpackage.ho2
            public sw4 getRequestArgs() {
                HashMap map = new HashMap();
                LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(86400000L);
                if (locationExI != null) {
                    map.put("longitude", Double.valueOf(locationExI.getLongitude()));
                    map.put("latitude", Double.valueOf(locationExI.getLatitude()));
                }
                map.put("scene", this.f21379a);
                return sw4.b(1, nl0.z + "/new.friend.tab.pull.virtual", map).f(false);
            }

            @Override // defpackage.io2
            public void onResult(boolean z, LXBaseNetBean<NearByResp> lXBaseNetBean, Exception exc) {
                JSONObject jSONObject;
                JSONObject jSONObjectOptJSONObject;
                LogUtil.d("AiChatPeopleManagerTag", "startTriggerToServer new.friend.tab.pull.virtual onResult=" + az2.c(lXBaseNetBean));
                if (lXBaseNetBean == null || lXBaseNetBean.resultCode != 0 || (jSONObject = lXBaseNetBean.originData) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
                    return;
                }
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("nearbyList");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    v8.q(0);
                    return;
                }
                String strI = v8.i(jSONArrayOptJSONArray.optJSONObject(0));
                if (!TextUtils.isEmpty(strI)) {
                    v8.E(strI, this.f21379a);
                }
                v8.q(1);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = "newFriend_empty";
            String strE = v4.e(AppContext.getContext());
            String[] strArr = new String[8];
            strArr[0] = Integer.toString(14);
            if (TextUtils.isEmpty(strE)) {
                strE = "";
            }
            strArr[1] = strE;
            strArr[2] = Integer.toString(34);
            strArr[3] = Integer.toString(4);
            strArr[4] = Integer.toString(28);
            strArr[5] = Integer.toString(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR);
            strArr[6] = Integer.toString(301);
            strArr[7] = Integer.toString(302);
            Cursor cursorQuery = null;
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(vn0.f21483a, null, "source_type!=? and from_uid!=? and source_type!=? and source_type!=? and source_type!=? and request_type!=? and request_type!=? and request_type!=? ", strArr, "_id DESC");
                if (cursorQuery != null) {
                    if (cursorQuery.getCount() > 0) {
                        str = "newFriend_notEmpty";
                    }
                }
            } catch (Exception unused) {
                if (cursorQuery != null) {
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            LogUtil.d("AiChatPeopleManagerTag", "startTriggerToServer scene " + str);
            SharedPreferences sharedPreferences = com.zenmen.palmchat.c.b().getSharedPreferences("AI_CHAT_PEOPLE_ALL_SP_NAME", 0);
            String strW = v8.w();
            long j = (long) v8.y;
            if ("newFriend_notEmpty".equals(str)) {
                strW = v8.x();
                j = v8.x;
            }
            long j2 = sharedPreferences.getLong(strW, 0L);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (j2 <= 0 || jCurrentTimeMillis - j2 >= j * 1000) {
                sharedPreferences.edit().putLong(strW, jCurrentTimeMillis).apply();
                zw4.e(new a(str));
            } else {
                LogUtil.d("AiChatPeopleManagerTag", "startTriggerToServer time not allow scene " + str);
            }
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        B = arrayList;
        arrayList.clear();
        f21374a.add(1);
        f21374a.add(3);
        f21374a.add(4);
        c.add(1);
        c.add(3);
        c.add(4);
        e.add(1);
        e.add(4);
        g.add(1);
        g.add(3);
        g.add(4);
        i.add(1);
        i.add(3);
        i.add(4);
        C = false;
        D = 0L;
        E = new HashMap<>();
    }

    public static void A(String str) {
        LogUtil.d("AiChatPeopleManagerTag", "initAllConfig ext " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            k = jSONObject.optInt("newFriend_friendApply_frequency", 3600);
            m = jSONObject.optBoolean("msgList_label_enable", true);
            n = jSONObject.optBoolean("msgPage_label_enable", true);
            o = jSONObject.optBoolean("profile_label_enable", true);
            s = jSONObject.optString("msgList_label_url", p);
            t = jSONObject.optString("msgPage_label_url", q);
            u = jSONObject.optString("profile_label_url", r);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("findFriend_recommend");
            if (jSONObjectOptJSONObject != null) {
                d = jSONObjectOptJSONObject.optInt("timing", 2);
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("preTiming");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    c.clear();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        c.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i2)));
                    }
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("findFriend_nearby");
            if (jSONObjectOptJSONObject2 != null) {
                f = jSONObjectOptJSONObject2.optInt("timing", 5);
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("preTiming");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    e.clear();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                        e.add(Integer.valueOf(jSONArrayOptJSONArray2.optInt(i3)));
                    }
                }
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("newFriend_friendApply");
            if (jSONObjectOptJSONObject3 != null) {
                j = jSONObjectOptJSONObject3.optInt("timing", 2);
                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject3.optJSONArray("preTiming");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    i.clear();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                        i.add(Integer.valueOf(jSONArrayOptJSONArray3.optInt(i4)));
                    }
                }
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("newFriend_empty");
            if (jSONObjectOptJSONObject4 != null) {
                b = jSONObjectOptJSONObject4.optInt("timing", 2);
                JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject4.optJSONArray("preTiming");
                if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                    f21374a.clear();
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray4.length(); i5++) {
                        f21374a.add(Integer.valueOf(jSONArrayOptJSONArray4.optInt(i5)));
                    }
                }
                y = jSONObjectOptJSONObject4.optInt("frequency_seconds", 120);
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("newFriend_notEmpty");
            if (jSONObjectOptJSONObject5 != null) {
                h = jSONObjectOptJSONObject5.optInt("timing", 2);
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject5.optJSONArray("preTiming");
                if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                    g.clear();
                    for (int i6 = 0; i6 < jSONArrayOptJSONArray5.length(); i6++) {
                        g.add(Integer.valueOf(jSONArrayOptJSONArray5.optInt(i6)));
                    }
                }
                x = jSONObjectOptJSONObject5.optInt("frequency_seconds", 120);
            }
        } catch (Exception unused) {
        }
    }

    public static void B(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("uids");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
            B.clear();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                B.add(jSONArrayOptJSONArray.optString(i2));
            }
        } catch (Exception unused) {
        }
    }

    public static boolean C(String str) {
        try {
            if (TextUtils.isEmpty(str) || !str.startsWith("502")) {
                return false;
            }
            return str.length() == 12;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean D() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - D;
        if (j2 < 1000 && j2 > 0) {
            return true;
        }
        D = jCurrentTimeMillis;
        return false;
    }

    public static void E(String str, String str2) {
        LogUtil.d("AiChatPeopleManagerTag", "msgFriendAddAiItem startTriggerToServer start friendFragmentLoaded " + z + " friendFragmentVisible " + A);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ContactRequestsVO contactRequestsVOK = k(str);
        l = contactRequestsVOK;
        if (!z) {
            F();
            return;
        }
        r8 r8Var = new r8(1);
        r8Var.c = contactRequestsVOK;
        r8Var.b = str2;
        ds0.a().b(r8Var);
        if (A) {
            return;
        }
        F();
    }

    public static void F() {
        tn0.i().z(1);
        LogUtil.d("AiChatPeopleManagerTag", "mNewFriendAdapter startTriggerToServer aiChatEvent start notifyDataSetChanged count 1 ");
        ch.s().K(tn0.i().s(), null);
    }

    public static void G() {
        l = null;
        z = false;
        A = false;
        tn0.i().z(0);
    }

    public static void H(hk2 hk2Var, long j2, long j3) {
        zw4.e(new d(j3, j2, hk2Var));
    }

    public static int I(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        try {
            SharedPreferences sharedPreferences = com.zenmen.palmchat.c.b().getSharedPreferences("AI_CHAT_PEOPLE_ALL_SP_NAME", 0);
            if (!sharedPreferences.contains(str)) {
                return 1;
            }
            String string = sharedPreferences.getString(str, "");
            if (TextUtils.isEmpty(string)) {
                return 1;
            }
            int iOptInt = new JSONObject(string).optInt("num");
            LogUtil.d("AiChatPeopleManagerTag", "readTriggerNumByType type " + str + " num " + iOptInt);
            return iOptInt;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static void J(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        com.zenmen.palmchat.c.b().getSharedPreferences("AI_CHAT_PEOPLE_ALL_SP_NAME", 0).edit().putInt(v(str, str2), i2).apply();
    }

    public static void K(String str) {
        String string;
        if (!h() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = com.zenmen.palmchat.c.b().getSharedPreferences("AI_CHAT_PEOPLE_ALL_SP_NAME", 0);
            long jCurrentTimeMillis = System.currentTimeMillis();
            v.setTimeZone(TimeZone.getDefault());
            String str2 = v.format(Long.valueOf(jCurrentTimeMillis));
            if (sharedPreferences.contains(str)) {
                String string2 = sharedPreferences.getString(str, "");
                if (TextUtils.isEmpty(string2)) {
                    string = null;
                } else {
                    JSONObject jSONObject = new JSONObject(string2);
                    if (str2.equals(jSONObject.optString("day"))) {
                        jSONObject.put("num", jSONObject.optInt("num") + 1);
                    } else {
                        jSONObject.put("day", str2);
                        jSONObject.put("num", 1);
                    }
                    string = jSONObject.toString();
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("day", str2);
                jSONObject2.put("num", 1);
                string = jSONObject2.toString();
            }
            LogUtil.d("AiChatPeopleManagerTag", "saveTriggerNumByType type " + str + " resultSave " + string);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            sharedPreferences.edit().putString(str, string).apply();
        } catch (Exception unused) {
        }
    }

    public static void L(Context context, long j2, int i2, gk2 gk2Var, String str, String str2) {
        if (!hx3.m(context)) {
            sy5.h(context, "网络好像有点问题，稍后再试", 0);
            return;
        }
        Uri.Builder builderBuildUpon = Uri.parse(of2.f(i2, 1901, "", 0, "", 0)).buildUpon();
        if (!TextUtils.isEmpty(str)) {
            builderBuildUpon.appendQueryParameter("pushScene", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builderBuildUpon.appendQueryParameter("targetUid", str2);
        }
        com.zenmen.palmchat.giftkit.a.a().b(context, builderBuildUpon.build().toString(), j2, new c(gk2Var, context));
    }

    public static boolean M() {
        return WkAdxAdConfigMg.DSP_NAME_BAIDU.equals(t66.h().e("LX-74175", "A"));
    }

    public static boolean N(Context context, int i2, long j2, long j3, int i3, int i4) {
        if (D()) {
            return false;
        }
        String strY = y(i4);
        if (M()) {
            P(context, i2, j2, j3, i3, strY);
            return true;
        }
        if (C) {
            return false;
        }
        C = true;
        zw4.e(new a(j2, j3, i3, context, i2, strY, i4));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[PHI: r2
      0x0032: PHI (r2v1 long) = (r2v0 long), (r2v6 long) binds: [B:7:0x001b, B:9:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void O(Activity activity, String str, int i2, int i3) {
        long j2;
        int gender;
        try {
            long j3 = 0;
            long j4 = !TextUtils.isEmpty(str) ? Long.parseLong(str) : 0L;
            String strP = AccountUtils.p(AppContext.getContext());
            if (!TextUtils.isEmpty(strP)) {
                j3 = Long.parseLong(strP);
                ContactInfoItem contactInfoItemL = bo0.r().l(strP);
                if (contactInfoItemL != null) {
                    gender = contactInfoItemL.getGender();
                    j2 = j3;
                } else {
                    j2 = j3;
                    gender = 0;
                }
            }
            int i4 = 190100 + i2;
            if (activity instanceof AppCompatActivity) {
                m(str, "click");
                N(activity, i4, j4, j2, gender, i3);
                return;
            }
            Intent intent = new Intent(activity, (Class<?>) AiCHatBuyDialogBaseActivity.class);
            intent.putExtra("fuidL", j4);
            intent.putExtra("uidL", j2);
            intent.putExtra("gender", gender);
            intent.putExtra("dfrom", i4);
            intent.putExtra("bizType", i3);
            activity.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void P(Context context, int i2, long j2, long j3, int i3, String str) {
        if (context instanceof Activity) {
            try {
                String str2 = "zenxin://activity?page=a0052&pkgId=guardian&isTransParent=true&urlExtra=" + URLEncoder.encode("?from=" + i2 + "&fuid=" + j2 + "&pushScene=" + str, "UTF-8");
                LogUtil.d("AiChatPeopleManagerTag", "SkuWeb startAiSkuWeb openUrl " + str2);
                ve.o((Activity) context, str2, false);
            } catch (Exception unused) {
            }
        }
    }

    public static void Q(Activity activity, ChatItem chatItem) {
        q8 q8Var = new q8(activity);
        q8Var.j();
        q8Var.i(chatItem);
    }

    public static void R() {
        Async.INSTANCE.getCache().execute(new e());
    }

    public static void g(Context context, long j2, String str, int i2) {
        try {
            String strE = v4.e(AppContext.getContext());
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            H(new b(j2, strE, context, str), Long.parseLong(strE), j2);
        } catch (Exception unused) {
        }
    }

    public static boolean h() {
        return !"A".equals(z());
    }

    public static String i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("fromUid", jSONObject.optString(DeviceInfoUtil.UID_TAG));
            jSONObject2.put("fromNickName", jSONObject.optString("nickname"));
            jSONObject2.put("fromHeadIcon", jSONObject.optString("avatar"));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("sex", jSONObject.optInt("gender"));
            jSONObject3.put("age", jSONObject.optInt("age"));
            String strOptString = jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY);
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = "同城";
            }
            jSONObject3.put("cityName", strOptString);
            jSONObject2.put("userInfo", jSONObject3);
            String string = jSONObject2.toString();
            LogUtil.d("AiChatPeopleManagerTag", "changeRespToContactRequests allRes=" + string);
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean j(String str) {
        ArrayList<Integer> arrayList;
        int i2;
        int size;
        int iIntValue;
        boolean z2;
        if (!h()) {
            return false;
        }
        if ("newFriend_empty".equals(str)) {
            arrayList = f21374a;
            i2 = b;
        } else if ("findFriend_recommend".equals(str)) {
            arrayList = c;
            i2 = d;
        } else if ("findFriend_nearby".equals(str)) {
            arrayList = e;
            i2 = f;
        } else {
            arrayList = null;
            i2 = 2;
        }
        if (arrayList != null && arrayList.size() > 0) {
            size = arrayList.size();
            iIntValue = arrayList.get(size - 1).intValue();
            int I = I(str);
            z2 = 1;
            if (I > iIntValue) {
                z2 = (I - iIntValue) % i2 == 0 ? 1 : 0;
                i = I;
            } else {
                i = I;
                if (!arrayList.contains(Integer.valueOf(I))) {
                }
            }
            LogUtil.d("AiChatPeopleManagerTag", "checkTriggerAllow type " + str + " curShowNum " + i + " max " + iIntValue + " checkDuration " + i2 + " size " + size + " checkDone " + z2);
            return z2;
        }
        size = 0;
        iIntValue = 0;
        z2 = 0;
        LogUtil.d("AiChatPeopleManagerTag", "checkTriggerAllow type " + str + " curShowNum " + i + " max " + iIntValue + " checkDuration " + i2 + " size " + size + " checkDone " + z2);
        return z2;
    }

    public static ContactRequestsVO k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ContactRequestsVO contactRequestsVO = new ContactRequestsVO();
            JSONObject jSONObject = new JSONObject(str);
            contactRequestsVO.fromUid = jSONObject.optString("fromUid");
            contactRequestsVO.fromNickName = jSONObject.optString("fromNickName");
            contactRequestsVO.fromHeadIcon = jSONObject.optString("fromHeadIcon");
            if (jSONObject.has("userInfo")) {
                contactRequestsVO.userInfo = jSONObject.optJSONObject("userInfo").toString();
            }
            contactRequestsVO.aiShowUi = 1;
            return contactRequestsVO;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void l(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(AppContext.getContext()));
            jSONObject.put("report_type", str2);
            jSONObject.put("fuid", str);
            jSONObject.put("button", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("AIchat_buyAgain_pop", null, jSONObject.toString());
    }

    public static void m(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(AppContext.getContext()));
            jSONObject.put("report_type", str2);
            jSONObject.put("fuid", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("AIchat_buyAgain_systemMsg", null, jSONObject.toString());
    }

    public static void n(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(AppContext.getContext()));
            jSONObject.put("report_type", str2);
            jSONObject.put("fuid", str);
            int i3 = 1;
            if (i2 != 1) {
                i3 = 2;
            }
            jSONObject.put("status", i3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("AIchat_buyCard", null, jSONObject.toString());
    }

    public static void o(String str, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(AppContext.getContext()));
            jSONObject.put("report_type", "click");
            jSONObject.put("showuid", str);
            jSONObject.put("action", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("AIchat_newFriend_recommend", null, jSONObject.toString());
    }

    public static void p(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (E.containsKey(str) ? E.get(str).booleanValue() : false) {
            return;
        }
        E.put(str, Boolean.TRUE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(AppContext.getContext()));
            jSONObject.put("report_type", "view");
            jSONObject.put("showuid", str);
            jSONObject.put("action", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("AIchat_newFriend_recommend", null, jSONObject.toString());
    }

    public static void q(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(AppContext.getContext()));
            jSONObject.put("result", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("AIchat_newFriend_request", null, jSONObject.toString());
    }

    public static void r(String str, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(AppContext.getContext()));
            jSONObject.put("report_type", "view");
            jSONObject.put("fuid", str);
            jSONObject.put("from", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("AIchat_salesPop", null, jSONObject.toString());
    }

    public static void s(String str, int i2, int i3, long j2, String str2, AiChatMsgSku aiChatMsgSku) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(AppContext.getContext()));
            jSONObject.put("report_type", "click");
            jSONObject.put("fuid", str);
            jSONObject.put("from", i2);
            jSONObject.put("status", i3);
            jSONObject.put("remainTime", j2);
            jSONObject.put("defaultSelectProductId", str2);
            if (aiChatMsgSku != null) {
                jSONObject.put("sku", new JSONObject(az2.c(aiChatMsgSku)));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("AIchat_salesPop_buyButton", null, jSONObject.toString());
    }

    public static List<NewFriendAdapter.b> t(List<NewFriendAdapter.b> list) {
        NewFriendAdapter.a aVar;
        ContactRequestsVO contactRequestsVO;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            NewFriendAdapter.b bVar = list.get(i2);
            if ((bVar instanceof NewFriendAdapter.a) && (contactRequestsVO = (aVar = (NewFriendAdapter.a) bVar).f13833a) != null && contactRequestsVO.aiShowUi == 1 && C(contactRequestsVO.fromUid)) {
                LogUtil.d("AiChatPeopleManagerTag", "findAiShowItem has fromUid " + aVar.f13833a.fromUid);
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public static int u(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String strV = v(str, str2);
            SharedPreferences sharedPreferences = com.zenmen.palmchat.c.b().getSharedPreferences("AI_CHAT_PEOPLE_ALL_SP_NAME", 0);
            if (sharedPreferences.contains(strV)) {
                return sharedPreferences.getInt(strV, 0);
            }
        }
        return 0;
    }

    public static String v(String str, String str2) {
        return str + "_" + str2;
    }

    public static String w() {
        return "newFriendEmpty_time" + v4.e(AppContext.getContext());
    }

    public static String x() {
        return "newFriendNotEmpty_time" + v4.e(AppContext.getContext());
    }

    public static String y(int i2) {
        LogUtil.d("", "AIP getPushSceneByBizType bizType " + i2);
        return i2 == 5066 ? "findFriend_nearby" : i2 == 5065 ? "findFriend_recommend" : i2 == 5063 ? "newFriend_empty" : i2 == 5064 ? "newFriend_notEmpty" : i2 == 5068 ? "push_friendApply_heartbeat" : i2 == 5069 ? "push_timedTask" : i2 == 5067 ? "push_message" : AdnName.OTHER;
    }

    public static String z() {
        return t66.h().e("LX-66953", "A");
    }
}
