package com.zenmen.palmchat.chat.fragment;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.InputItemManager;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.config.GroupVersionConfig;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.c70;
import defpackage.eb6;
import defpackage.fg6;
import defpackage.fn2;
import defpackage.fu2;
import defpackage.fu5;
import defpackage.h70;
import defpackage.ho3;
import defpackage.iq5;
import defpackage.ir5;
import defpackage.lg1;
import defpackage.lo3;
import defpackage.lu4;
import defpackage.o86;
import defpackage.sd1;
import defpackage.st4;
import defpackage.sy5;
import defpackage.wa6;
import defpackage.wi0;
import defpackage.xn3;
import defpackage.zp3;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c implements ServiceConnection {
    public static final String e = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleChatFragment f12839a;
    public lo3 b = new lo3(AppContext.getContext(), this);
    public st4 c;
    public h70 d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<ChatterActivity.LongClickMenuItem, String> {
        public a() {
            put(ChatterActivity.LongClickMenuItem.MORE, c.this.f12839a.getString(R.string.string_more));
            put(ChatterActivity.LongClickMenuItem.BUBBLE, c.this.f12839a.getString(R.string.chat_item_menu_bubble));
            put(ChatterActivity.LongClickMenuItem.DELETE, c.this.f12839a.getString(R.string.string_delete));
            put(ChatterActivity.LongClickMenuItem.COPY, c.this.f12839a.getString(R.string.chat_item_menu_copy));
            put(ChatterActivity.LongClickMenuItem.RECALL, c.this.f12839a.getString(R.string.chat_item_menu_recall));
            put(ChatterActivity.LongClickMenuItem.FORWARD, c.this.f12839a.getString(R.string.string_forward));
            put(ChatterActivity.LongClickMenuItem.MOMENTS, c.this.f12839a.getString(R.string.string_moments));
            put(ChatterActivity.LongClickMenuItem.SPEAKERMODE1, c.this.f12839a.getString(R.string.string_use_speaker_mode));
            put(ChatterActivity.LongClickMenuItem.SPEAKERMODE2, c.this.f12839a.getString(R.string.string_use_receiver_mode));
            put(ChatterActivity.LongClickMenuItem.SAVEEXPRESSION, c.this.f12839a.getString(R.string.string_add_expressions));
            put(ChatterActivity.LongClickMenuItem.REPORT, c.this.f12839a.getString(R.string.hotchat_message_report));
            put(ChatterActivity.LongClickMenuItem.KICKOUT, c.this.f12839a.getString(R.string.hotchat_message_kickout));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12841a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse> {
            public a() {
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                LogUtil.d(c.e, "onResponse() called with: response = [" + baseResponse + "]");
            }
        }

        public b(MessageVo messageVo) {
            this.f12841a = messageVo;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            c.this.f12839a.G();
            if (jSONObject.optInt("resultCode") != 0) {
                c.this.f12839a.K1();
                return;
            }
            if (this.f12841a.mimeType == 52) {
                lg1.c().m(this.f12841a);
            }
            c.this.p(this.f12841a);
            if (c.this.f12839a.L0() instanceof GroupInfoItem) {
                c70.R().r0(((GroupInfoItem) c.this.f12839a.L0()).getGroupId(), this.f12841a.mid, new a());
            }
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.chat.fragment.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0992c implements Response.ErrorListener {
        public C0992c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            c.this.f12839a.G();
            sy5.e(c.this.f12839a.getActivity(), R.string.net_operation_fail, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("action", "send_message");
            put("status", "cancelSendMessage");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put("action", "send_message");
            put("status", "fail");
            put("detail", "sendExpression");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {
        public f() {
            put("action", "bind_service");
            put("status", "getMessagingServiceInterface is null");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {
        public g() {
            put("action", "bind_service");
            put("status", "onServiceDisconnected_Base");
        }
    }

    public c(SimpleChatFragment simpleChatFragment) {
        this.f12839a = simpleChatFragment;
    }

    public static boolean l(MessageVo messageVo) {
        File fileB;
        boolean z = !TextUtils.isEmpty(messageVo.data1) && new File(messageVo.data1).exists();
        if (!z) {
            String strF = com.zenmen.palmchat.expression.a.f(messageVo);
            if (!TextUtils.isEmpty(strF) && (fileB = sd1.b(strF)) != null && fileB.exists() && fileB.length() > 0) {
                return true;
            }
        }
        return z;
    }

    public static boolean m(MessageVo messageVo) {
        File fileB;
        boolean z = false;
        if (messageVo.attachStatus == 5) {
            return false;
        }
        if (!TextUtils.isEmpty(messageVo.data1) && new File(messageVo.data1).exists()) {
            z = true;
        }
        if (z || TextUtils.isEmpty(messageVo.data3) || (fileB = sd1.b(messageVo.data3)) == null || !fileB.exists() || fileB.length() <= 0) {
            return z;
        }
        return true;
    }

    public static boolean n(MessageVo messageVo) {
        return (messageVo.mimeType == 6 && !o86.j(messageVo)) || (messageVo.mimeType == 4 && !eb6.e().d(messageVo.data1)) || (messageVo.mimeType == 14 && !l(messageVo)) || (messageVo.mimeType == 2 && !m(messageVo));
    }

    public void d() {
        this.b.c();
    }

    public void e(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i == strArr.length - 1) {
                sb.append("packet_id=?");
            } else {
                sb.append("packet_id=? or ");
            }
            try {
                h().s(strArr[i]);
            } catch (Exception e2) {
                e2.printStackTrace();
                LogUtil.i(e, 3, new d(), e2);
            }
        }
        AppContext.getContext().getContentResolver().delete(DBUriManager.b(ho3.class, this.f12839a.L0()), sb.toString(), strArr);
    }

    public final void f() {
        InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_FILE);
        InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_IMAGE);
        InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_CAMERA);
        InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_NAME_CARD);
    }

    public final void g() {
        GroupVersionConfig config;
        if (this.f12839a.L0() instanceof GroupInfoItem) {
            GroupInfoItem groupInfoItem = (GroupInfoItem) this.f12839a.L0();
            boolean z = groupInfoItem.getMerchantType() == 1 && groupInfoItem.getMerchantState() == 1;
            boolean z2 = (!z || (config = GroupVersionConfig.getConfig()) == null || config.isShowCircleRedPacket()) ? z : false;
            if (!z2) {
                InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_VOUCHER);
            } else if ((groupInfoItem.getRoleType() == 1 && zp3.a()) || groupInfoItem.getRoleType() == 2) {
                InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_VOUCHER);
            } else {
                InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_VOUCHER);
            }
            if (this.f12839a.S0() != null) {
                this.f12839a.S0().K3(z2);
            }
        } else {
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_VOUCHER);
        }
        if (this.f12839a.S0() != null) {
            this.f12839a.S0().W3();
            if (this.f12839a.S0().q2() == null || this.f12839a.S0().q2().getAdapter() == null) {
                return;
            }
            this.f12839a.S0().q2().getAdapter().notifyDataSetChanged();
        }
    }

    public fn2 h() {
        fn2 fn2VarE = this.b.e();
        if (fn2VarE == null) {
            AppContext.getContext().initMessagingService("STASRT_REASON_BASEACTIVITY_BIND_NULL");
            LogUtil.i(e, 3, new f(), (Throwable) null);
        }
        return fn2VarE;
    }

    public void i(MessageVo messageVo) {
        if (this.d == null) {
            this.d = new h70(this.f12839a.b1().b());
        }
        this.d.g(messageVo);
    }

    public void j() {
        InputItemManager.f();
        InputItemManager.InputItemType inputItemType = InputItemManager.InputItemType.INPUT_ITEM_CAMERA;
        InputItemManager.c(inputItemType);
        f();
        if (this.f12839a.L0().getChatType() == 1) {
            g();
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL);
            if (wa6.d()) {
                InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_GROUP_VOICE_CALL);
                fg6.b("view", fg6.j(AppContext.getContext()) ? 1 : 0, fg6.d(AppContext.getContext()) ? 1 : 0, 1);
            } else {
                InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_GROUP_VOICE_CALL);
            }
        } else {
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_GROUP_VOICE_CALL);
            if ((AccountUtils.p(AppContext.getContext()) == null || !AccountUtils.p(AppContext.getContext()).equals(this.f12839a.L0().getChatId())) && com.zenmen.palmchat.videocall.c.e()) {
                InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL);
                fg6.b("view", fg6.j(AppContext.getContext()) ? 1 : 0, fg6.d(AppContext.getContext()) ? 1 : 0, 2);
            } else {
                InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL);
            }
        }
        if (this.f12839a.L0().getBizType() != 0 && this.f12839a.L0().getBizType() != 13) {
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_REDPACKET);
        } else if (this.f12839a.L0().getChatType() == 0) {
            if (!lu4.c() || this.f12839a.L0().getChatId() == null || this.f12839a.L0().getChatId().equals(AccountUtils.p(AppContext.getContext()))) {
                InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_REDPACKET);
            } else {
                InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_REDPACKET);
            }
        } else if (lu4.b()) {
            InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_REDPACKET);
        } else {
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_REDPACKET);
        }
        if (lu4.d() && this.f12839a.L0().getChatType() == 0 && this.f12839a.L0().getBizType() == 0 && this.f12839a.L0().getChatId() != null && !this.f12839a.L0().getChatId().equals(AccountUtils.p(AppContext.getContext()))) {
            InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_TRANSFER);
        } else {
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_TRANSFER);
        }
        if (fu5.u(this.f12839a.L0())) {
            InputItemManager.c(InputItemManager.InputItemType.INPUT_ITEM_LOCATION);
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_IMAGE);
            InputItemManager.b(inputItemType);
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_FILE);
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL);
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_GROUP_VOICE_CALL);
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_NAME_CARD);
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_REDPACKET);
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_BIG_TEXT);
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_SIGHT);
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_TRANSFER);
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_VOUCHER);
        }
        if (this.f12839a.L0().getChatType() == 0) {
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_REDPACKET);
            InputItemManager.b(InputItemManager.InputItemType.INPUT_ITEM_TRANSFER);
        }
    }

    public HashMap<ChatterActivity.LongClickMenuItem, String> k() {
        return new a();
    }

    public void o() {
        st4 st4Var = this.c;
        if (st4Var != null) {
            st4Var.onCancel();
        }
        h70 h70Var = this.d;
        if (h70Var != null) {
            h70Var.l();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        LogUtil.i(e, 3, new g(), (Throwable) null);
    }

    public final void p(MessageVo messageVo) {
        if (messageVo.isSend) {
            this.f12839a.L1();
        }
        iq5.j(false, new String[0]);
    }

    public void q(MessageVo messageVo) {
        b bVar = new b(messageVo);
        C0992c c0992c = new C0992c();
        HashMap map = new HashMap();
        map.put("mid", messageVo.mid);
        map.put(RemoteMessageConst.TO, DomainHelper.a(this.f12839a.L0(), true));
        if (!messageVo.isSend) {
            map.put("midOwner", DomainHelper.q(messageVo.from));
        }
        st4 st4Var = new st4(bVar, c0992c);
        this.c = st4Var;
        try {
            st4Var.n(map);
            SimpleChatFragment simpleChatFragment = this.f12839a;
            simpleChatFragment.O(simpleChatFragment.getString(R.string.message_recall), false, false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public void r(ExpressionObject expressionObject) {
        if (fu2.g(this.f12839a.getActivity(), InputItemManager.InputItemType.INPUT_ITEM_EXPRESSION)) {
            String strA = xn3.a();
            if (this.f12839a.L0() == null || TextUtils.isEmpty(this.f12839a.L0().getChatId())) {
                return;
            }
            try {
                h().r(MessageVo.buildExpressionMessage(strA, DomainHelper.e(this.f12839a.L0()), expressionObject, 0, ir5.b()).setThreadBizType(AppContext.getContext(), this.f12839a.c1()));
            } catch (Exception e2) {
                e2.printStackTrace();
                LogUtil.i(e, 3, new e(), e2);
            }
        }
    }

    public void s() {
        this.b.f();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }
}
