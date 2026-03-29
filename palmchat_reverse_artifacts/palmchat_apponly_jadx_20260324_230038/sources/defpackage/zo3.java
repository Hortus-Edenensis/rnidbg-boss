package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.zenmen.media.roomchatdemo.videocallgroup.VideoCallGroupSelectionActivity;
import com.zenmen.media.roomchatdemo.videocallgroup.userInfo;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.PhoneContactVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.activity.webview.LxVipPayCordovaWebActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.chat.temporary.SquareTempChatActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.HomeTown;
import com.zenmen.palmchat.contacts.d;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.giftkit.a;
import com.zenmen.palmchat.lxvoip.LxVoipManager;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.videocall.VideoCallService;
import com.zenmen.square.MediaViewActivity;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.fk2;
import defpackage.gn2;
import defpackage.t5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class zo3 implements gn2 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends AsyncTask<Void, Void, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gn2.a f22465a;

        public a(gn2.a aVar) {
            this.f22465a = aVar;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            iq5.j(true, new String[0]);
            return null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r1) {
            super.onPostExecute(r1);
            this.f22465a.onFinish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gn2.b f22466a;

        public b(gn2.b bVar) {
            this.f22466a = bVar;
        }

        @Override // com.zenmen.palmchat.contacts.d.c
        public void onFinished(HashMap<String, PhoneContactVo> map) {
            this.f22466a.onFinish((map == null || map.size() <= 0) ? -1 : 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements a.InterfaceC1055a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yo3 f22467a;

        public c(yo3 yo3Var) {
            this.f22467a = yo3Var;
        }

        @Override // com.zenmen.palmchat.giftkit.a.InterfaceC1055a
        public void a(boolean z) {
            this.f22467a.a(Boolean.valueOf(z));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements fo0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22468a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public d(Activity activity, int i, String str, String str2) {
            this.f22468a = activity;
            this.b = i;
            this.c = str;
            this.d = str2;
        }

        @Override // defpackage.fo0
        public void onResponse(int i, String str) {
            if (i != 0) {
                sy5.f(this.f22468a, "获取用户信息失败", 0).g();
            } else {
                zo3.this.d0(this.f22468a, (ContactInfoItem) az2.a(str, ContactInfoItem.class), this.b, this.c, this.d);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements yl2 {
        public e() {
        }

        @Override // defpackage.yl2
        public void a(String str, List<ContactInfoItem> list, ChatItem chatItem) {
            GiftMessageHelper.Y(str, list, chatItem);
        }

        @Override // defpackage.yl2
        public HashMap<String, Object> b(ContactInfoItem contactInfoItem) {
            HashMap<String, Object> map = new HashMap<>();
            int bizType = contactInfoItem.getBizType();
            String str = DomainHelper.m(contactInfoItem).domain;
            map.put("domain", str);
            if (DomainHelper.Domains.DOMAIN_PRIVATE.domain.equalsIgnoreCase(str) && fu5.q(bizType)) {
                map.put("bizType", Integer.valueOf(bizType + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite));
            } else {
                map.put("bizType", Integer.valueOf(bizType));
            }
            return map;
        }
    }

    @Override // defpackage.gn2
    public boolean A() {
        return SAppUtil.e.b();
    }

    @Override // defpackage.gn2
    public void B(Context context, String str) {
        Intent intent = new Intent();
        intent.setClass(context, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    @Override // defpackage.gn2
    public boolean C() {
        return com.zenmen.palmchat.videocall.c.h(false);
    }

    @Override // defpackage.gn2
    public String D() {
        return vm0.k1;
    }

    @Override // defpackage.gn2
    public void E() {
        RoomSDKInfo roomSDKInfoC = LxVoipManager.b().c();
        if (roomSDKInfoC != null) {
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) VideoCallService.class);
            intent.setAction("action_foreground");
            intent.putExtra("call_type", roomSDKInfoC.type == 1 ? 0 : 1);
            intent.putExtra("is_ve_rtc", true);
            if (Build.VERSION.SDK_INT >= 26) {
                AppContext.getContext().startForegroundService(intent);
            } else {
                AppContext.getContext().startService(intent);
            }
        }
    }

    @Override // defpackage.gn2
    public boolean F() {
        return ns.c().b().isDcLogSwitch();
    }

    @Override // defpackage.gn2
    public void G(FrameworkBaseActivity frameworkBaseActivity, String str) {
        cq6.b(frameworkBaseActivity, str, 1);
    }

    @Override // defpackage.gn2
    public void H(Activity activity, String str, String str2, int i, String str3, String str4) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
            return;
        }
        ContactInfoItem contactInfoItemA = !TextUtils.isEmpty(str) ? dn0.a(str) : !TextUtils.isEmpty(str2) ? dn0.b(str2) : null;
        if (contactInfoItemA == null) {
            go0.h(str, str2, new d(activity, i, str3, str4));
        } else {
            d0(activity, contactInfoItemA, i, str3, str4);
        }
    }

    @Override // defpackage.gn2
    public void I(Context context, String str) {
        g(context, vm0.C + "?from=" + str);
    }

    @Override // defpackage.gn2
    public ArrayList<String> J(HomeTown homeTown) {
        if (homeTown != null) {
            return r7.j(AppContext.getContext()).n(AppContext.getContext(), homeTown.nation, homeTown.province, homeTown.city);
        }
        return null;
    }

    @Override // defpackage.gn2
    public void K(gn2.a aVar) {
        new a(aVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // defpackage.gn2
    public long L(String str) {
        ThreadChatItem threadChatItemF = nw5.f(str);
        if (threadChatItemF != null) {
            return threadChatItemF.lastMessageDate;
        }
        return 0L;
    }

    @Override // defpackage.gn2
    public boolean M() {
        return gk4.d();
    }

    @Override // defpackage.gn2
    public Object N(Object obj) {
        if (!(obj instanceof iy)) {
            return null;
        }
        iy iyVar = (iy) obj;
        LogUtil.i("CallLogManagerProcess", "event=" + az2.c(iyVar));
        String str = iyVar.g;
        if (str == null || com.zenmen.palmchat.database.b.C(String.valueOf(str))) {
            return null;
        }
        LogUtil.i("CallLogManagerProcess", "enter");
        if (lh6.V().t()) {
            lh6.V().d0(iyVar);
            return null;
        }
        MessageVo messageVo = new MessageVo();
        messageVo.mid = xn3.a();
        messageVo.time = ir5.b();
        String str2 = iyVar.b;
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getString(iyVar.d == LxVoipManager.CallMediaType.CALL_MEDIA_TYPE_VIDEO ? R.string.message_type_video_call : R.string.message_type_voice_call);
        messageVo.mimeType = 30;
        messageVo.status = 2;
        messageVo.sendFlag = String.valueOf(0);
        messageVo.from = c0(AppContext.getContext());
        messageVo.isSend = iyVar.c;
        messageVo.isRead = iyVar.f;
        messageVo.extention = "";
        messageVo.data1 = iyVar.e;
        messageVo.data2 = String.valueOf(iyVar.d == LxVoipManager.CallMediaType.CALL_MEDIA_TYPE_AUDIO ? 1 : 0);
        messageVo.data3 = String.valueOf(iyVar.g);
        messageVo.versionId = com.zenmen.palmchat.database.b.o(iyVar.b);
        com.zenmen.palmchat.database.b.t(messageVo);
        return null;
    }

    @Override // defpackage.gn2
    public boolean O(String str) {
        return ve.d(str);
    }

    @Override // defpackage.gn2
    public void P(Activity activity, String str, int i, String str2) {
        H(activity, str, "", i, "", str2);
    }

    @Override // defpackage.gn2
    public yl2 Q() {
        return new e();
    }

    @Override // defpackage.gn2
    public boolean R(Context context, String str) {
        ma3.a("showPaymentPage url:" + str, new Object[0]);
        try {
            if (TeenagersModeManager.a().d()) {
                sy5.e(context, R.string.teenagers_mode_payment_toast, 0).g();
                return false;
            }
            Intent intent = new Intent();
            intent.setClass(context, LxVipPayCordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", str);
            bundle.putBoolean("extra_key_full_window", false);
            bundle.putBoolean("hide_toolbar", true);
            bundle.putBoolean("hide_progressbar", true);
            k86.X(intent);
            intent.putExtras(bundle);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    @Override // defpackage.gn2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void S() {
        boolean z;
        try {
            t5.b bVarK = t5.k();
            if (bVarK != null) {
                String name = bVarK.e().getName();
                LogUtil.d("RefundManager", "checkVipEffectSuccess className " + name);
                z = "com.zenmen.palmchat.chat.ChatterActivity".equals(name) || "com.zenmen.palmchat.chat.temporary.SquareTempChatActivity".equals(name);
            }
            if (z) {
                return;
            }
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString("main_tab", "tab_find_friend");
            bundle.putString("find_friend_tab", "userrecommend");
            aVar.b(bundle);
            AppContext context = AppContext.getContext();
            context.startActivity(n5.b(context, aVar));
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.gn2
    public np2 T() {
        return lh6.V();
    }

    @Override // defpackage.gn2
    public String U() {
        return gk4.c().a().friendRecommend;
    }

    @Override // defpackage.gn2
    public void V(Context context, String str, String str2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(vm0.D);
        sb.append("?from=");
        sb.append(str);
        sb.append("&vipType=");
        sb.append(str2);
        sb.append("&onlySvip=");
        sb.append(z ? "1" : "0");
        R(context, sb.toString());
    }

    @Override // defpackage.gn2
    public String W() {
        return vm0.X0;
    }

    @Override // defpackage.gn2
    public void X(uk5 uk5Var) {
        ch.s().r().i(uk5Var);
    }

    @Override // defpackage.gn2
    public Pair<Integer, String> Y(Exception exc) {
        return VolleyError.getExceptionCodeAndMessage(exc);
    }

    @Override // defpackage.gn2
    public void Z(String str) {
        vt0.d().n(str);
    }

    @Override // defpackage.gn2
    public boolean a() {
        return TeenagersModeManager.a().d();
    }

    @Override // defpackage.gn2
    public void a0(FrameworkBaseActivity frameworkBaseActivity, String str) {
        ve.s(frameworkBaseActivity, str, false);
    }

    @Override // defpackage.gn2
    public int b(Context context) {
        if (fg6.j(context)) {
            return 0;
        }
        return fg6.d(context) ? 1 : -1;
    }

    @Override // defpackage.gn2
    public ik2 b0() {
        return ba.c();
    }

    @Override // defpackage.gn2
    public void c(Activity activity, ArrayList<RoomUserInfo> arrayList) {
        Intent intent = new Intent(activity, (Class<?>) VideoCallGroupSelectionActivity.class);
        ArrayList arrayList2 = new ArrayList();
        for (RoomUserInfo roomUserInfo : arrayList) {
            userInfo userinfo = new userInfo();
            userinfo.id = Long.parseLong(roomUserInfo.uid);
            arrayList2.add(userinfo);
        }
        intent.putExtra("USER_LIST_FOR_SELECTION", arrayList2);
        intent.putExtra("IS_INVITE_MODE", 1);
        intent.putExtra("IS_VE_RTC", 1);
        activity.startActivityForResult(intent, 0);
    }

    public String c0(Context context) {
        if (context != null) {
            return AccountUtils.p(context);
        }
        return null;
    }

    @Override // defpackage.gn2
    public void d(Context context, String str, String str2) {
        g(context, vm0.C + "?from=" + str + "&vipType=" + str2);
    }

    public void d0(Activity activity, ContactInfoItem contactInfoItem, int i, String str, String str2) {
        if (contactInfoItem == null) {
            sy5.f(activity, "用户信息为空", 0).g();
            return;
        }
        if (contactInfoItem.getIsStranger()) {
            contactInfoItem.setBizType(i);
            SquareTempChatActivity.K1(activity, contactInfoItem, contactInfoItem.getBizType(), null, str, str2);
            return;
        }
        contactInfoItem.setBizType(0);
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
        intent.putExtra("chat_item", contactInfoItem);
        intent.putExtra("thread_biz_type", contactInfoItem.getBizType());
        intent.putExtra("chat_need_back_to_main", false);
        intent.putExtra("chat_back_to_greet", false);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("online_gift_data", str2);
        }
        k86.X(intent);
        activity.startActivity(intent);
    }

    @Override // defpackage.gn2
    public boolean e(Throwable th) {
        NetworkResponse networkResponse;
        return th != null && (th instanceof VolleyError) && (networkResponse = ((VolleyError) th).networkResponse) != null && networkResponse.statusCode == 509;
    }

    @Override // defpackage.gn2
    public void f(Context context, String str, String str2, String str3) {
        R(context, vm0.D + "?from=" + str + "&vipType=" + str2 + "&scene=" + str3);
    }

    @Override // defpackage.gn2
    public boolean g(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setClass(context, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", str);
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putBoolean("hide_toolbar", true);
            bundle.putBoolean("hide_progressbar", true);
            intent.putExtras(bundle);
            k86.X(intent);
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // defpackage.gn2
    public void h(Activity activity, String str, String str2, int i) {
        H(activity, str, str2, i, "", "");
    }

    @Override // defpackage.gn2
    public boolean i() {
        return ws2.a();
    }

    @Override // defpackage.gn2
    public JSONObject j() {
        return ts0.o().n();
    }

    @Override // defpackage.gn2
    public void k() {
        AppContext.getContext().stopService(new Intent(AppContext.getContext(), (Class<?>) VideoCallService.class));
    }

    @Override // defpackage.gn2
    public void l(Activity activity, Bundle bundle) {
        vt2.d(activity, bundle);
    }

    @Override // defpackage.gn2
    public void m(Activity activity, ContactInfoItem contactInfoItem, int i) {
        d0(activity, contactInfoItem, i, "", "");
    }

    @Override // defpackage.gn2
    public String n(String str, String str2) {
        return t66.h().e(str, str2);
    }

    @Override // defpackage.gn2
    public String o() {
        return vm0.l1;
    }

    @Override // defpackage.gn2
    public boolean p(Context context, String str, long j, int i) {
        SquareFeed squareFeed = new SquareFeed();
        squareFeed.id = j;
        squareFeed.exid = str;
        squareFeed.feedType = i;
        return MediaViewActivity.B1(28, context, squareFeed, false);
    }

    @Override // defpackage.gn2
    public void q(gn2.b bVar) {
        if (!AppContext.getContext().getTrayPreferences().a(k86.n(), false)) {
            AppContext.getContext().getTrayPreferences().i(k86.n(), true);
        }
        com.zenmen.palmchat.contacts.d.j().i();
        com.zenmen.palmchat.contacts.d.j().u(new b(bVar));
    }

    @Override // defpackage.gn2
    public void r(Context context, String str) {
        R(context, vm0.D + "?from=" + str);
    }

    @Override // defpackage.gn2
    public String s(ContactInfoItem contactInfoItem) {
        return contactInfoItem != null ? il5.j(AppContext.getContext(), contactInfoItem.getCountry(), contactInfoItem.getProvince(), contactInfoItem.getCity(), false) : "";
    }

    @Override // defpackage.gn2
    public xk3 t() {
        return new ra3();
    }

    @Override // defpackage.gn2
    public boolean u() {
        return tu3.f21071a.get();
    }

    @Override // defpackage.gn2
    public void v(int i) {
        wk3.b(AppContext.getContext(), "sound/close.mp3", false, null);
    }

    @Override // defpackage.gn2
    public void w(Context context, String str, String str2) {
        R(context, vm0.D + "?from=" + str + "&vipType=" + str2);
    }

    @Override // defpackage.gn2
    public lo2 x() {
        return hb3.g();
    }

    @Override // defpackage.gn2
    public void y(Activity activity, int i, int i2, boolean z, int i3) {
        com.zenmen.palmchat.paidservices.superexpose.a.b().i(activity, i, i2, z, i3);
    }

    @Override // defpackage.gn2
    public void z(Context context, int i, int i2, String str, int i3, int i4, yo3 yo3Var) {
        com.zenmen.palmchat.giftkit.a.a().b(context, of2.g(i, i2, "", 0, "", 0, str, i4), i3, new c(yo3Var));
    }
}
