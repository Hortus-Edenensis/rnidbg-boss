package com.zenmen.palmchat.chat.fragment;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.Vo.GreetConfig;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.fragment.a;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.framework.bridge.risk.RiskConfig;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b05;
import defpackage.bo0;
import defpackage.dt2;
import defpackage.f7;
import defpackage.fu5;
import defpackage.hb3;
import defpackage.ih;
import defpackage.io0;
import defpackage.iq5;
import defpackage.jk2;
import defpackage.jo6;
import defpackage.k86;
import defpackage.mj1;
import defpackage.o2;
import defpackage.rl0;
import defpackage.rn0;
import defpackage.rx4;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.vn0;
import defpackage.zh;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {
    public static Set<String> h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f12805a;
    public f7 b;
    public ih c;
    public o2 d;
    public ContactRequestsVO f;
    public boolean e = false;
    public int g = 1;

    /* JADX INFO: renamed from: com.zenmen.palmchat.chat.fragment.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0983a implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f12806a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.fragment.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0984a extends MaterialDialog.e {
            public C0984a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                C0983a c0983a = C0983a.this;
                a.this.r(c0983a.f12806a, false, true, false, false, null);
            }
        }

        public C0983a(ContactInfoItem contactInfoItem, String str, String str2) {
            this.f12806a = contactInfoItem;
            this.b = str;
            this.c = str2;
        }

        public static /* synthetic */ Object b() {
            return "agreeFriendRequest 好友成交成功";
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            a.this.f12805a.c();
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                b05.c(new b05.a() { // from class: j7
                    @Override // b05.a
                    public final Object getValue() {
                        return a.C0983a.b();
                    }
                });
                GiftMessageHelper.S(this.f12806a);
                sy5.e(AppContext.getContext(), R.string.send_success, 0).g();
                ContentValues contentValues = new ContentValues();
                contentValues.put("accept_status", (Long) 1L);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "rid=?", new String[]{this.b});
                iq5.j(false, new String[0]);
                rn0.q(this.c);
                return;
            }
            if (iOptInt == 1327) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(MediationConstant.KEY_ERROR_MSG);
                mj1.c(a.this.f12805a.getActivity(), jSONObjectOptJSONObject.optString("title"), jSONObjectOptJSONObject.optString("part"), jSONObjectOptJSONObject.optString("body"), jSONObjectOptJSONObject.optInt("time"));
                return;
            }
            if (iOptInt == 1306) {
                new sd3(a.this.f12805a.getActivity()).T(R.string.update_install_dialog_title).j(R.string.contact_friend_request_expired).O(R.string.contact_add_friend).K(R.string.alert_dialog_cancel).f(new C0984a()).e().show();
            } else if (iOptInt == 1320 || iOptInt == 1321) {
                rx4.b(a.this.f12805a.getActivity(), jSONObject);
            } else {
                sy5.f(AppContext.getContext(), rx4.a(jSONObject), 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends jk2 {

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.fragment.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0985a implements Runnable {
            public RunnableC0985a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f12805a.a().notifyDataSetChanged();
            }
        }

        public b() {
        }

        @Override // defpackage.jk2
        public void c(int i, Cursor cursor) {
            super.c(i, cursor);
            if (i != 10 || cursor == null) {
                return;
            }
            ArrayList<ContactRequestsVO> arrayListBuildFromCursorForShow = ContactRequestsVO.buildFromCursorForShow(cursor);
            cursor.close();
            ContactRequestsVO contactRequestsVOX = a.this.x(arrayListBuildFromCursorForShow);
            if (contactRequestsVOX == null || TextUtils.isEmpty(contactRequestsVOX.requestRid) || ContactRequestsVO.isSenderParseFromRid(contactRequestsVOX.requestRid)) {
                a.this.g = 1;
            } else {
                a.this.g = 2;
                a.this.f = contactRequestsVOX;
            }
            if (a.this.f12805a.a() == null || a.this.f12805a.getActivity() == null) {
                return;
            }
            a.this.f12805a.getActivity().runOnUiThread(new RunnableC0985a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f12811a;
        public final /* synthetic */ boolean b;

        public d(Runnable runnable, boolean z) {
            this.f12811a = runnable;
            this.b = z;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            this.f12811a.run();
            HashMap map = new HashMap();
            map.put("fuid", a.this.f12805a.b().getChatId());
            map.put("type", this.b ? "agree" : "apply");
            zn6.h("risktip_addpop", "click", map);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f12812a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ ContactRequestsVO c;
        public final /* synthetic */ boolean d;

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.fragment.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0986a implements Response.Listener<JSONObject> {
            public C0986a() {
            }

            public static /* synthetic */ Object b(int i) {
                return "好友无需验证直接申请成功,插入礼物引导消息, resultCode=" + i;
            }

            @Override // com.android.volley.Response.Listener
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onResponse(JSONObject jSONObject) {
                a.this.f12805a.c();
                final int iOptInt = jSONObject.optInt("resultCode");
                if (iOptInt == 0) {
                    iq5.j(false, new String[0]);
                    b05.c(new b05.a() { // from class: k7
                        @Override // b05.a
                        public final Object getValue() {
                            return a.e.C0986a.b(iOptInt);
                        }
                    });
                    GiftMessageHelper.T(a.this.f12805a.b(), 0);
                    return;
                }
                if (iOptInt == 1) {
                    a aVar = a.this;
                    ChatItem chatItemB = aVar.f12805a.b();
                    e eVar = e.this;
                    aVar.r(chatItemB, true, eVar.f12812a, eVar.d, eVar.b, eVar.c);
                    return;
                }
                if (iOptInt == 1318) {
                    if (e.this.f12812a) {
                        sy5.e(AppContext.getContext(), R.string.send_refuse, 1).g();
                    }
                } else if (iOptInt != 1320 && iOptInt != 1321) {
                    if (e.this.f12812a) {
                        sy5.f(AppContext.getContext(), rx4.a(jSONObject), 0).g();
                    }
                } else {
                    e eVar2 = e.this;
                    if (eVar2.f12812a) {
                        rx4.b(a.this.f12805a.getActivity(), jSONObject);
                    }
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Response.ErrorListener {
            public b() {
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                a.this.f12805a.c();
                if (e.this.f12812a) {
                    sy5.e(AppContext.getContext(), R.string.send_failed, 0).g();
                }
            }
        }

        public e(boolean z, boolean z2, ContactRequestsVO contactRequestsVO, boolean z3) {
            this.f12812a = z;
            this.b = z2;
            this.c = contactRequestsVO;
            this.d = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, Integer> pairA = a.this.A();
            int iIntValue = ((Integer) pairA.first).intValue();
            int iIntValue2 = ((Integer) pairA.second).intValue();
            if (!this.f12812a) {
                iIntValue = 4;
            }
            if (iIntValue == -1 && a.this.f12805a.b() != null) {
                iIntValue = a.this.f12805a.b().getChatType() == 0 ? 11 : 12;
            }
            ContactRequestArgs contactRequestArgsA = new ContactRequestArgs.Builder().h(this.b).b(this.c).e(ContactRequestArgs.c(a.this.f12805a.b())).i(String.valueOf(iIntValue)).j(String.valueOf(iIntValue2)).a();
            C0986a c0986a = new C0986a();
            b bVar = new b();
            a.this.b = new f7();
            try {
                a.this.b.p(c0986a, bVar);
                a.this.b.n(contactRequestArgsA);
                if (this.f12812a) {
                    a.this.f12805a.d(AppContext.getContext().getString(R.string.progress_sending), false, false);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.ErrorListener {
        public f() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            a.this.f12805a.c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f12816a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.fragment.a$g$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0987a implements Runnable {
            public RunnableC0987a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f12805a.a().notifyDataSetChanged();
            }
        }

        public g(ChatItem chatItem, boolean z, boolean z2) {
            this.f12816a = chatItem;
            this.b = z;
            this.c = z2;
        }

        public static /* synthetic */ Object b(int i) {
            return "applyFriendImp 好友申请成功,插入礼物引导消息, resultCode=" + i;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            a.this.f12805a.c();
            final int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0 || iOptInt == 1) {
                b05.c(new b05.a() { // from class: l7
                    @Override // b05.a
                    public final Object getValue() {
                        return a.g.b(iOptInt);
                    }
                });
                GiftMessageHelper.T(this.f12816a, 0);
                if (this.b) {
                    a.this.n();
                    if (a.this.f12805a.a() != null && a.this.f12805a.getActivity() != null) {
                        a.this.f12805a.getActivity().runOnUiThread(new RunnableC0987a());
                    }
                }
            }
            if (this.c) {
                rx4.b(a.this.f12805a.getActivity(), jSONObject);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f12819a;
        public final /* synthetic */ int b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ ContactRequestsVO g;

        public i(ChatItem chatItem, int i, EditText editText, boolean z, boolean z2, boolean z3, ContactRequestsVO contactRequestsVO) {
            this.f12819a = chatItem;
            this.b = i;
            this.c = editText;
            this.d = z;
            this.e = z2;
            this.f = z3;
            this.g = contactRequestsVO;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            a.this.s(this.f12819a, this.b, this.c.getText().toString(), this.d, this.e, this.f, this.g);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactRequestsVO f12820a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.fragment.a$j$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0988a implements Response.ErrorListener {
            public C0988a() {
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                a.this.f12805a.c();
                a.this.e = false;
                sy5.e(AppContext.getContext(), R.string.send_failed, 0).g();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Response.Listener<JSONObject> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f12822a;

            /* JADX INFO: renamed from: com.zenmen.palmchat.chat.fragment.a$j$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C0989a extends MaterialDialog.e {
                public C0989a() {
                }

                @Override // com.afollestad.materialdialogs.MaterialDialog.e
                public void onPositive(MaterialDialog materialDialog) {
                    j jVar = j.this;
                    a.this.o(true, jVar.b, true, jVar.f12820a);
                }
            }

            public b(String str) {
                this.f12822a = str;
            }

            public static /* synthetic */ Object b() {
                return "acceptFriendRequest 好友成交成功";
            }

            @Override // com.android.volley.Response.Listener
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onResponse(JSONObject jSONObject) {
                a.this.f12805a.c();
                int iOptInt = jSONObject.optInt("resultCode");
                a.this.e = false;
                if (iOptInt == 0) {
                    b05.c(new b05.a() { // from class: m7
                        @Override // b05.a
                        public final Object getValue() {
                            return a.j.b.b();
                        }
                    });
                    GiftMessageHelper.S(a.this.f12805a.b());
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("accept_status", (Long) 1L);
                    AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "rid=?", new String[]{this.f12822a});
                    iq5.j(false, new String[0]);
                    return;
                }
                if (iOptInt == 1327) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(MediationConstant.KEY_ERROR_MSG);
                    mj1.c(a.this.f12805a.getActivity(), jSONObjectOptJSONObject.optString("title"), jSONObjectOptJSONObject.optString("part"), jSONObjectOptJSONObject.optString("body"), jSONObjectOptJSONObject.optInt("time"));
                    return;
                }
                if (iOptInt == 1306) {
                    new sd3(a.this.f12805a.getActivity()).T(R.string.update_install_dialog_title).j(R.string.contact_friend_request_expired).O(R.string.contact_add_friend).K(R.string.alert_dialog_cancel).f(new C0989a()).e().show();
                } else if (iOptInt == 1320 || iOptInt == 1321) {
                    rx4.b(a.this.f12805a.getActivity(), jSONObject);
                } else {
                    sy5.f(AppContext.getContext(), rx4.a(jSONObject), 0).g();
                }
            }
        }

        public j(ContactRequestsVO contactRequestsVO, boolean z) {
            this.f12820a = contactRequestsVO;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f12820a.requestRid;
            C0988a c0988a = new C0988a();
            b bVar = new b(str);
            if (a.this.e) {
                return;
            }
            a.this.d = new o2();
            try {
                a.this.d.o(str, c0988a, bVar);
                a.this.f12805a.d(AppContext.getContext().getString(R.string.progress_sending), false, true);
                a.this.e = true;
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Response.ErrorListener {
        public k() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            a.this.f12805a.c();
            sy5.e(AppContext.getContext(), R.string.send_failed, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface l {
        ChatterAdapter a();

        ChatItem b();

        void c();

        void d(String str, boolean z, boolean z2);

        void e();

        Activity getActivity();
    }

    public a(l lVar) {
        this.f12805a = lVar;
    }

    public static Set<String> C() {
        HashSet hashSet = new HashSet();
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.CONTACT, k86.a("key_already_apply_contact_ids"), "");
        if (!TextUtils.isEmpty(strN)) {
            String[] strArrSplit = strN.split(",");
            if (strArrSplit.length > 0) {
                hashSet.addAll(Arrays.asList(strArrSplit));
            }
        }
        return hashSet;
    }

    public Pair<Integer, Integer> A() {
        ChatItem chatItemB = this.f12805a.b();
        int iIntValue = -1;
        int iIntValue2 = 0;
        if (chatItemB != null) {
            int bizType = chatItemB.getBizType();
            if (bizType == 14) {
                iIntValue = 14;
            } else if (bizType == 17) {
                iIntValue = 28;
            } else if (bizType == 22) {
                iIntValue = 200;
            }
            Pair<Integer, Integer> pairL = fu5.l(bizType);
            if (pairL != null) {
                iIntValue = ((Integer) pairL.first).intValue();
                iIntValue2 = ((Integer) pairL.second).intValue();
            }
        }
        LogUtil.i("logaddfriend", "addfriendhelperInchat getSourceTypeFromBizType sourceType=" + iIntValue + " subtype=" + iIntValue2);
        return new Pair<>(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
    }

    public void B() {
        f7 f7Var = this.b;
        if (f7Var != null) {
            f7Var.onCancel();
        }
        ih ihVar = this.c;
        if (ihVar != null) {
            ihVar.onCancel();
        }
        o2 o2Var = this.d;
        if (o2Var != null) {
            o2Var.onCancel();
        }
    }

    public void D() {
        zh.k(AppContext.getContext().getContentResolver()).i(10, new b(), vn0.f21483a, null, "from_uid=?", new String[]{this.f12805a.b().getChatId()}, "_id DESC");
    }

    public void m(boolean z, ContactRequestsVO contactRequestsVO) {
        j jVar = new j(contactRequestsVO, z);
        if (t(jVar, true)) {
            return;
        }
        jVar.run();
    }

    public final void n() {
        if (h == null) {
            h = C();
        }
        String strV = v();
        if (!h.contains(strV)) {
            h.add(strV);
            SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, k86.a("key_already_apply_contact_ids"), TextUtils.join(",", h));
        }
    }

    public void o(boolean z, boolean z2, boolean z3, ContactRequestsVO contactRequestsVO) {
        if (this.f12805a.b() == null || this.f12805a.b().getChatId() == null) {
            return;
        }
        e eVar = new e(z, z3, contactRequestsVO, z2);
        if (t(eVar, false)) {
            return;
        }
        eVar.run();
    }

    public void p(ContentValues contentValues) {
        String asString = contentValues.getAsString(DeviceInfoUtil.UID_TAG);
        ContactInfoItem contactInfoItemW = w(asString);
        contentValues.getAsString("sourceType");
        if (TextUtils.isEmpty(asString)) {
            return;
        }
        String str = asString + "_" + AccountUtils.p(AppContext.getContext());
        k kVar = new k();
        C0983a c0983a = new C0983a(contactInfoItemW, str, asString);
        o2 o2Var = new o2();
        this.d = o2Var;
        try {
            o2Var.o(str, kVar, c0983a);
            this.f12805a.d(AppContext.getContext().getString(R.string.progress_sending), false, true);
        } catch (DaoException e2) {
            e2.printStackTrace();
        }
    }

    public void q(ChatItem chatItem, int i2, boolean z, boolean z2, boolean z3, boolean z4, ContactRequestsVO contactRequestsVO) {
        GreetConfig greetConfigF;
        List<GreetConfig.Word> listB;
        GreetConfig greetConfigF2;
        List<GreetConfig.Word> listB2;
        View viewInflate = LayoutInflater.from(this.f12805a.getActivity()).inflate(R.layout.layout_dialog_add_friend_content, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.count);
        EditText editText = (EditText) viewInflate.findViewById(R.id.edit_text);
        editText.addTextChangedListener(new h(editText, textView));
        ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(AppContext.getContext()));
        String string = contactInfoItemL != null ? AppContext.getContext().getString(R.string.new_friend_request_message, contactInfoItemL.getNickName()) : AppContext.getContext().getString(R.string.new_friend_request_message, AccountUtils.l(AppContext.getContext()));
        editText.setText(string);
        if (z) {
            ContactInfoItem contactInfoItemL2 = bo0.r().l(chatItem.getChatId());
            if (contactInfoItemL != null && contactInfoItemL2 != null && contactInfoItemL.getGender() == 0 && contactInfoItemL2.getGender() == 1 && (greetConfigF2 = rl0.h().f()) != null && (listB2 = greetConfigF2.b()) != null) {
                editText.setText(listB2.get(new Random().nextInt(listB2.size())).b);
            }
        }
        Editable text = editText.getText();
        Selection.setSelection(text, text.length());
        if (!z2 || z3) {
            s(chatItem, i2, (contactInfoItemL == null || bo0.r().l(chatItem.getChatId()) == null || (greetConfigF = rl0.h().f()) == null || (listB = greetConfigF.b()) == null) ? string : listB.get(new Random().nextInt(listB.size())).b, z2, z3, z4, contactRequestsVO);
        } else {
            new sd3(this.f12805a.getActivity()).p(viewInflate, false).T(R.string.string_add_friend_title).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new i(chatItem, i2, editText, z2, z3, z4, contactRequestsVO)).e().show();
        }
    }

    public void r(ChatItem chatItem, boolean z, boolean z2, boolean z3, boolean z4, ContactRequestsVO contactRequestsVO) {
        q(chatItem, -1, z, z2, z3, z4, contactRequestsVO);
    }

    public final void s(ChatItem chatItem, int i2, String str, boolean z, boolean z2, boolean z3, ContactRequestsVO contactRequestsVO) {
        int i3;
        f fVar = new f();
        g gVar = new g(chatItem, z2, z);
        ContactRequestArgs.Builder builderE = new ContactRequestArgs.Builder().e(ContactRequestArgs.c(chatItem));
        if (TextUtils.isEmpty(str)) {
            str = AppContext.getContext().getString(R.string.notification_add_contact_request_content);
        }
        builderE.f(str);
        ContactInfoItem contactInfoItemL = bo0.r().l(chatItem.getChatId());
        if (i2 == -1) {
            Pair<Integer, Integer> pairA = A();
            int iIntValue = ((Integer) pairA.first).intValue();
            int iIntValue2 = ((Integer) pairA.second).intValue();
            if (!z) {
                iIntValue = 4;
            }
            if (iIntValue != -1 || this.f12805a.b() == null) {
                i3 = iIntValue2;
                i2 = iIntValue;
            } else if (this.f12805a.b().getChatType() == 0) {
                i3 = iIntValue2;
                i2 = 11;
            } else {
                i3 = iIntValue2;
                i2 = 12;
            }
        } else {
            i3 = 0;
        }
        builderE.i(String.valueOf(i2));
        if (i2 == 12) {
            i3 = 1;
        }
        builderE.j(String.valueOf(i3));
        String remarkName = "";
        if (jo6.i() && io0.t(i2) && contactInfoItemL != null) {
            ContactInfoItem contactInfoItemL2 = bo0.r().l(contactInfoItemL.getUid());
            if (contactInfoItemL2 != null && !TextUtils.isEmpty(contactInfoItemL2.getRemarkName())) {
                remarkName = contactInfoItemL2.getRemarkName();
            } else if (!TextUtils.isEmpty(contactInfoItemL.getIdentifyCode())) {
                com.zenmen.palmchat.contacts.d.j().m().get(contactInfoItemL.getIdentifyCode());
            }
        }
        builderE.g(remarkName);
        builderE.h(z3).b(contactRequestsVO);
        ih ihVar = new ih(gVar, fVar);
        this.c = ihVar;
        try {
            ihVar.r(builderE.a());
            this.c.v(z);
            if (z) {
                this.f12805a.d(AppContext.getContext().getString(R.string.progress_sending), false, false);
            }
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final boolean t(Runnable runnable, boolean z) {
        ContactInfoItem contactInfoItemL;
        if (hb3.g().i() && this.f12805a.b() != null && hb3.g().h() != null && (contactInfoItemL = bo0.r().l(this.f12805a.b().getChatId())) != null && (contactInfoItemL.getRiskLevel() == 40 || contactInfoItemL.getRiskLevel() == 50)) {
            RiskConfig riskConfigH = hb3.g().h();
            String str = contactInfoItemL.getRiskLevel() == 40 ? riskConfigH.nofchat_40_addagree : riskConfigH.nofchat_50_addagree;
            if (!TextUtils.isEmpty(str)) {
                HashMap map = new HashMap();
                map.put("fuid", this.f12805a.b().getChatId());
                map.put("type", z ? "agree" : "apply");
                zn6.h("risktip_addpop", "view", map);
                if (contactInfoItemL.getRiskLevel() == 50) {
                    new sd3(this.f12805a.getActivity()).k(str).P("知道了").f(new c()).e().show();
                } else {
                    new sd3(this.f12805a.getActivity()).k(str).P("放弃").L("坚持添加").f(new d(runnable, z)).e().show();
                }
                return true;
            }
        }
        return false;
    }

    public ContactRequestsVO u() {
        return this.f;
    }

    public final String v() {
        return this.f12805a.b().getChatId();
    }

    public ContactInfoItem w(String str) {
        ChatItem chatItemB = this.f12805a.b();
        if (chatItemB != null && chatItemB.getChatId().equals(str) && (chatItemB instanceof ContactInfoItem)) {
            return (ContactInfoItem) chatItemB;
        }
        ContactInfoItem contactInfoItemL = bo0.r().l(str);
        if (contactInfoItemL != null) {
            return contactInfoItemL;
        }
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setUid(str);
        return contactInfoItem;
    }

    public final ContactRequestsVO x(ArrayList<ContactRequestsVO> arrayList) {
        ContactRequestsVO contactRequestsVO = null;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (this.f12805a.b() == null || this.f12805a.b().getBizType() != 22) {
            return arrayList.get(0);
        }
        Iterator<ContactRequestsVO> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ContactRequestsVO next = it.next();
            if (!ContactRequestsVO.isSenderParseFromRid(next.requestRid)) {
                contactRequestsVO = next;
                break;
            }
        }
        return contactRequestsVO == null ? arrayList.get(0) : contactRequestsVO;
    }

    public int y() {
        if (h == null) {
            h = C();
        }
        String strV = v();
        ContactInfoItem contactInfoItemL = bo0.r().l(this.f12805a.b().getChatId());
        if (contactInfoItemL != null && !contactInfoItemL.getIsStranger()) {
            this.g = 0;
            h.remove(strV);
        } else if (this.g == 1 && h.contains(strV)) {
            this.g = 3;
        }
        return this.g;
    }

    public l z() {
        return this.f12805a;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f12818a;
        public final /* synthetic */ TextView b;

        public h(EditText editText, TextView textView) {
            this.f12818a = editText;
            this.b = textView;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            dt2.e(this.f12818a, charSequence, 60, this.b, true);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
