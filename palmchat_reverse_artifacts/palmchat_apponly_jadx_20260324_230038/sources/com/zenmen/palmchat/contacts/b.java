package com.zenmen.palmchat.contacts;

import android.content.ContentValues;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.recommend.EnhanceRecommendActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.f7;
import defpackage.fg6;
import defpackage.gr2;
import defpackage.ih;
import defpackage.io0;
import defpackage.iq5;
import defpackage.jo6;
import defpackage.kx3;
import defpackage.l50;
import defpackage.lx3;
import defpackage.me1;
import defpackage.mj1;
import defpackage.mx3;
import defpackage.o2;
import defpackage.rn0;
import defpackage.rx4;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.un0;
import defpackage.vn0;
import defpackage.wh4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b extends BaseAdapter {
    public static final String j = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameworkBaseActivity f13552a;
    public LayoutInflater b;
    public HashMap<String, PhoneContactItem> c;
    public o2 e;
    public f7 f;
    public ih g;
    public k h;
    public ArrayList<j> d = new ArrayList<>();
    public boolean i = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            LogUtil.onImmediateClickEvent("2c1", null, null);
            b.this.f13552a.startActivity(new Intent(b.this.f13552a, (Class<?>) NewContactTotalActivity.class));
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1021b implements View.OnClickListener {
        public ViewOnClickListenerC1021b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            LogUtil.onImmediateClickEvent("2c2", null, null);
            EnhanceRecommendActivity.H1(b.this.f13552a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f13555a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ContactRequestsVO f;

        public c(ContactInfoItem contactInfoItem, int i, String str, String str2, String str3, ContactRequestsVO contactRequestsVO) {
            this.f13555a = contactInfoItem;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = contactRequestsVO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhoneContactItem phoneContactItem;
            int sourceType = this.f13555a.getSourceType() == 4 ? 14 : this.b == 101 ? 3 : this.f13555a.getSourceType();
            int i = this.b;
            if (i < 100) {
                b bVar = b.this;
                String str = this.c;
                String str2 = this.d;
                String str3 = this.e;
                ContactInfoItem contactInfoItem = this.f13555a;
                ContactRequestsVO contactRequestsVO = this.f;
                bVar.h(i, str, str2, str3, contactInfoItem, sourceType, contactRequestsVO.realName, contactRequestsVO);
                return;
            }
            if (b.this.h.e && jo6.r()) {
                Intent intent = new Intent(b.this.f13552a, (Class<?>) RecommendRequestSendActivity.class);
                intent.putExtra("uid_key", this.d);
                intent.putExtra("user_item_info_key", this.f13555a);
                intent.putExtra("source_type_key", sourceType);
                intent.putExtra("real_name", this.f.realName);
                intent.putExtra("send_from_type", 4);
                intent.putExtra("subtype_key", b.this.h.f13564a);
                b.this.f13552a.startActivity(intent);
                return;
            }
            if (!b.this.h.e || !jo6.t()) {
                b.this.i(this.d, false, this.f13555a, sourceType, this.f);
                return;
            }
            Intent intent2 = new Intent(b.this.f13552a, (Class<?>) NewContactRequestSendActivityV2.class);
            intent2.putExtra("user_item_info", this.f13555a);
            intent2.putExtra("uid_key", this.d);
            intent2.putExtra("new_contact_source_type", sourceType);
            intent2.putExtra("send_from_type", 4);
            if (TextUtils.isEmpty(this.f13555a.getMobile())) {
                String str4 = this.f.identifyCode;
                if (!TextUtils.isEmpty(str4) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(str4)) != null) {
                    intent2.putExtra("new_contact_local_phone_number", phoneContactItem.y());
                }
            } else {
                intent2.putExtra("new_contact_local_phone_number", this.f13555a.getMobile());
            }
            intent2.putExtra("extra_request_type", this.f13555a.getRequestType());
            intent2.putExtra("subtype_key", b.this.h.f13564a);
            intent2.putExtra("extra_request_from", 21);
            b.this.f13552a.startActivity(intent2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {
        public d() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            b.this.f13552a.hideBaseProgressBar();
            new sd3(b.this.f13552a).j(R.string.sent_request_failed).O(R.string.alert_dialog_ok).e().show();
            LogUtil.d(b.j, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13557a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ContactInfoItem d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ ContactRequestsVO h;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                e eVar = e.this;
                b.this.i(eVar.c, true, eVar.d, eVar.f13557a, eVar.h);
            }
        }

        public e(int i, String str, String str2, ContactInfoItem contactInfoItem, int i2, String str3, String str4, ContactRequestsVO contactRequestsVO) {
            this.f13557a = i;
            this.b = str;
            this.c = str2;
            this.d = contactInfoItem;
            this.e = i2;
            this.f = str3;
            this.g = str4;
            this.h = contactRequestsVO;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                if (this.f13557a == 28) {
                    LogUtil.onImmediateClickEvent("pm1061", null, null);
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("accept_status", (Long) 1L);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "rid=?", new String[]{this.b});
                rn0.h(this.c, this.f13557a);
                rn0.r(this.c);
                wh4.h(this.d);
                iq5.j(false, new String[0]);
                UserDetailActivity.V2(b.this.f13552a, this.e, this.f, this.b, this.d, b.this.h.c, this.g, this.f13557a != 34);
            } else if (iOptInt == 1306) {
                new sd3(b.this.f13552a).T(R.string.update_install_dialog_title).j(R.string.contact_friend_request_expired).O(R.string.contact_add_friend).K(R.string.alert_dialog_cancel).f(new a()).e().show();
            } else if (iOptInt == 1327) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(MediationConstant.KEY_ERROR_MSG);
                mj1.c(b.this.f13552a, jSONObjectOptJSONObject.optString("title"), jSONObjectOptJSONObject.optString("part"), jSONObjectOptJSONObject.optString("body"), jSONObjectOptJSONObject.optInt("time"));
            } else if (iOptInt == -1) {
                sy5.e(b.this.f13552a, R.string.send_failed, 0).g();
            } else if (iOptInt == 1320 || iOptInt == 1321) {
                rx4.b(b.this.f13552a, jSONObject);
            } else {
                sy5.f(AppContext.getContext(), rx4.a(jSONObject), 0).g();
            }
            b.this.f13552a.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f13559a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ContactRequestArgs e;

        public f(ContactInfoItem contactInfoItem, String str, boolean z, int i, ContactRequestArgs contactRequestArgs) {
            this.f13559a = contactInfoItem;
            this.b = str;
            this.c = z;
            this.d = i;
            this.e = contactRequestArgs;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                b.this.f13552a.hideBaseProgressBar();
                wh4.h(this.f13559a);
                iq5.j(false, new String[0]);
            } else {
                if (iOptInt == 1) {
                    b.this.j(this.b, this.c, this.f13559a, this.d, this.e);
                    return;
                }
                if (iOptInt == 1318) {
                    b.this.f13552a.hideBaseProgressBar();
                    sy5.e(b.this.f13552a, R.string.send_refuse, 1).g();
                } else if (iOptInt == 1320 || iOptInt == 1321) {
                    b.this.f13552a.hideBaseProgressBar();
                    rx4.b(b.this.f13552a, jSONObject);
                } else {
                    b.this.f13552a.hideBaseProgressBar();
                    sy5.f(b.this.f13552a, rx4.a(jSONObject), 0).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.ErrorListener {
        public g() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            b.this.f13552a.hideBaseProgressBar();
            new sd3(b.this.f13552a).j(R.string.sent_request_failed).O(R.string.alert_dialog_ok).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.ErrorListener {
        public h() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            b.this.f13552a.hideBaseProgressBar();
            LogUtil.d(b.j, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13562a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ContactInfoItem c;

        public i(boolean z, String str, ContactInfoItem contactInfoItem) {
            this.f13562a = z;
            this.b = str;
            this.c = contactInfoItem;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            b.this.f13552a.hideBaseProgressBar();
            if (iOptInt != 0 && iOptInt != 1) {
                if (iOptInt == 1320 || iOptInt == 1321) {
                    rx4.b(b.this.f13552a, jSONObject);
                    return;
                } else {
                    if (iOptInt == -1) {
                        sy5.e(b.this.f13552a, R.string.send_failed, 0).g();
                        return;
                    }
                    return;
                }
            }
            if (this.f13562a) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("accept_status", (Long) 2L);
                contentValues.put("request_type", (Integer) 0);
                contentValues.put("rid", AccountUtils.p(AppContext.getContext()) + "_" + this.b);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "from_uid=?", new String[]{this.b});
            } else {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("accept_status", (Long) 2L);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues2, "from_uid=?", new String[]{this.b});
            }
            wh4.h(this.c);
            rn0.r(this.b);
            if (b.this.h.f13564a != 14) {
                wh4.d(this.b, this.c.getRequestType());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13563a = 0;
        public ContactRequestsVO b;
        public boolean c;

        public j(ContactRequestsVO contactRequestsVO) {
            this.b = contactRequestsVO;
        }

        public ContactRequestsVO d() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13564a = 0;
        public int b = 0;
        public int c = 0;
        public boolean d = false;
        public boolean e = false;
        public boolean f = false;
        public boolean g = false;
    }

    public b(FrameworkBaseActivity frameworkBaseActivity, HashMap<String, PhoneContactItem> map, k kVar) {
        this.f13552a = frameworkBaseActivity;
        this.c = map;
        this.b = LayoutInflater.from(frameworkBaseActivity);
        this.h = kVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.d.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (i2 < 0 || i2 >= this.d.size()) {
            return 0;
        }
        return this.d.get(i2).f13563a;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        mx3 mx3VarA;
        kx3 kx3VarA;
        lx3 lx3VarA;
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 1) {
            if (view == null) {
                view = this.b.inflate(R.layout.layout_list_item_friend_head_request, (ViewGroup) null, false);
                lx3VarA = lx3.a(view);
                view.setTag(lx3VarA);
            } else {
                lx3VarA = (lx3) view.getTag();
            }
            m(lx3VarA, this.d.get(i2));
            return view;
        }
        if (itemViewType == 2) {
            if (view == null) {
                view = this.b.inflate(R.layout.layout_list_item_friend_head_recommend, (ViewGroup) null, false);
                kx3VarA = kx3.a(view);
                view.setTag(kx3VarA);
            } else {
                kx3VarA = (kx3) view.getTag();
            }
            l(kx3VarA, this.d.get(i2));
            return view;
        }
        if (view == null) {
            k kVar = this.h;
            view = kVar.d ? this.b.inflate(R.layout.layout_list_item_friend_request_main, (ViewGroup) null, false) : kVar.f ? this.b.inflate(R.layout.layout_list_item_friend_request_enhanced, (ViewGroup) null, false) : this.b.inflate(R.layout.layout_list_item_friend_request, (ViewGroup) null, false);
            mx3VarA = mx3.a(view);
            view.setTag(mx3VarA);
        } else {
            mx3VarA = (mx3) view.getTag();
        }
        o(mx3VarA, i2);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public final void h(int i2, String str, String str2, String str3, ContactInfoItem contactInfoItem, int i3, String str4, ContactRequestsVO contactRequestsVO) {
        String remarkName;
        d dVar = new d();
        e eVar = new e(i3, str, str2, contactInfoItem, i2, str3, str4, contactRequestsVO);
        this.e = new o2();
        try {
            String strM = "";
            if (jo6.i() && io0.t(i3)) {
                ContactInfoItem contactInfoItemL = bo0.r().l(str2);
                if (contactInfoItemL == null || TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                    PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(str3);
                    if (phoneContactItem != null) {
                        strM = phoneContactItem.m();
                    }
                    remarkName = strM;
                } else {
                    remarkName = contactInfoItemL.getRemarkName();
                }
            } else {
                remarkName = strM;
            }
            this.e.n(str, this.h.b, remarkName, dVar, eVar);
            this.f13552a.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        }
    }

    public final void i(String str, boolean z, ContactInfoItem contactInfoItem, int i2, ContactRequestsVO contactRequestsVO) {
        if (str == null) {
            return;
        }
        String strM = "";
        if (jo6.i() && io0.t(i2) && !TextUtils.isEmpty(contactInfoItem.getIdentifyCode())) {
            ContactInfoItem contactInfoItemL = bo0.r().l(str);
            if (contactInfoItemL == null || TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(contactInfoItem.getIdentifyCode());
                if (phoneContactItem != null) {
                    strM = phoneContactItem.m();
                }
            } else {
                strM = contactInfoItemL.getRemarkName();
            }
        }
        ContactRequestArgs.Builder builderG = new ContactRequestArgs.Builder().h(z).b(contactRequestsVO).e(ContactRequestArgs.c(contactInfoItem)).i(String.valueOf(i2)).g(strM);
        if (i2 == 3 || this.h.f) {
            builderG.j(String.valueOf(this.h.f13564a));
        }
        ContactRequestArgs contactRequestArgsA = builderG.a();
        f7 f7Var = new f7(new f(contactInfoItem, str, z, i2, contactRequestArgsA), new g());
        this.f = f7Var;
        try {
            f7Var.n(contactRequestArgsA);
            this.f13552a.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void j(String str, boolean z, ContactInfoItem contactInfoItem, int i2, ContactRequestArgs contactRequestArgs) {
        ih ihVar = new ih(new i(z, str, contactInfoItem), new h());
        this.g = ihVar;
        try {
            ihVar.r(contactRequestArgs);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void l(kx3 kx3Var, j jVar) {
        if (jVar.c) {
            kx3Var.b.setVisibility(0);
            kx3Var.c.setVisibility(0);
            kx3Var.f18848a.setOnClickListener(new ViewOnClickListenerC1021b());
        } else {
            kx3Var.b.setVisibility(8);
            kx3Var.c.setVisibility(8);
            kx3Var.f18848a.setOnClickListener(null);
        }
    }

    public final void m(lx3 lx3Var, j jVar) {
        if (jVar.c) {
            lx3Var.b.setVisibility(0);
            lx3Var.c.setVisibility(8);
        } else {
            lx3Var.b.setVisibility(8);
            lx3Var.c.setVisibility(0);
        }
        lx3Var.f19096a.setOnClickListener(new a());
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x028d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o(mx3 mx3Var, int i2) {
        long j2;
        String str;
        b bVar = this;
        ContactRequestsVO contactRequestsVO = bVar.d.get(i2).b;
        String strR = bVar.r(contactRequestsVO.fromUid, contactRequestsVO.fromNickName);
        String string = contactRequestsVO.requestInfo;
        String strQ = bVar.q(contactRequestsVO.fromUid, contactRequestsVO.fromHeadIcon);
        int i3 = contactRequestsVO.sourceType;
        long j3 = contactRequestsVO.acceptStatus;
        long disReadStatus = bVar.h.d ? contactRequestsVO.getDisReadStatus() : contactRequestsVO.readStatus;
        String str2 = contactRequestsVO.requestRid;
        int i4 = contactRequestsVO.type;
        String str3 = contactRequestsVO.fromUid;
        String str4 = contactRequestsVO.identifyCode;
        ContactInfoItem contactInfoItemConvert2ContactInfoItem = contactRequestsVO.convert2ContactInfoItem();
        mx3Var.f19386a.changeShapeType(3);
        mx3Var.f19386a.setDegreeForRoundRectangle(19, 19);
        if (TextUtils.isEmpty(strQ)) {
            mx3Var.f19386a.setImageResource(R.drawable.default_portrait);
            j2 = disReadStatus;
        } else {
            j2 = disReadStatus;
            gr2.j().h(strQ, mx3Var.f19386a, bq6.s());
        }
        if (bVar.h.f) {
            SocialPortraitView socialPortraitView = mx3Var.f19386a;
            if (socialPortraitView instanceof EffectiveShapeView) {
                socialPortraitView.changeShapeType(3);
                mx3Var.f19386a.setDegreeForRoundRectangle(me1.b(bVar.f13552a, 3), me1.b(bVar.f13552a, 3));
            }
        }
        boolean zW = bo0.r().w(str3);
        mx3Var.f.setBackgroundResource(R.drawable.selector_settings_item_background);
        mx3Var.e.setVisibility(8);
        if (i4 < 100) {
            if (bVar.h.d) {
                mx3Var.d.setBackgroundResource(R.drawable.shape_cccccc_bg_radius_15);
                mx3Var.d.setTextColor(bVar.f13552a.getResources().getColorStateList(R.color.text_color_btn_green));
            } else {
                mx3Var.d.setBackgroundResource(R.drawable.selector_btn_green_invite);
                mx3Var.d.setTextColor(bVar.f13552a.getResources().getColorStateList(R.color.text_color_btn_green));
            }
            if (zW) {
                mx3Var.d.setText(R.string.contact_already_friend);
                mx3Var.d.setEnabled(false);
                mx3Var.d.setBackgroundResource(R.drawable.shape_cccccc_bg_radius_15);
                mx3Var.d.setTextColor(bVar.f13552a.getResources().getColor(R.color.text_color_ffffff));
                str = " (";
            } else if (ContactRequestsVO.isSenderParseFromRid(str2) || TextUtils.isEmpty(str2)) {
                str = " (";
                mx3Var.d.setText(R.string.apply_request_wait_approve);
                mx3Var.d.setEnabled(false);
                mx3Var.d.setTextColor(bVar.f13552a.getResources().getColor(R.color.text_color_ffffff));
                mx3Var.d.setBackgroundResource(R.drawable.shape_cccccc_bg_radius_15);
            } else {
                if (contactRequestsVO.applyTime > 0) {
                    str = " (";
                    boolean z = System.currentTimeMillis() > contactRequestsVO.applyTime + (contactRequestsVO.applyExpireSec * 1000);
                    if (i3 == 14 && z) {
                        bVar = this;
                        if (!bVar.h.d) {
                            mx3Var.d.setText(R.string.add_contact_request_expire);
                            mx3Var.d.setEnabled(false);
                            mx3Var.d.setTextColor(bVar.f13552a.getResources().getColor(R.color.text_color_ffffff));
                            mx3Var.d.setBackgroundResource(R.drawable.shape_cccccc_bg_radius_15);
                        }
                    } else {
                        bVar = this;
                    }
                    mx3Var.d.setText(R.string.accept_add_contact_request);
                    mx3Var.d.setEnabled(true);
                    mx3Var.d.setBackgroundResource(R.drawable.selector_btn_green_invite);
                    mx3Var.d.setTextColor(bVar.f13552a.getResources().getColorStateList(R.color.text_color_btn_green));
                } else {
                    str = " (";
                }
                if (i3 == 14) {
                    bVar = this;
                    mx3Var.d.setText(R.string.accept_add_contact_request);
                    mx3Var.d.setEnabled(true);
                    mx3Var.d.setBackgroundResource(R.drawable.selector_btn_green_invite);
                    mx3Var.d.setTextColor(bVar.f13552a.getResources().getColorStateList(R.color.text_color_btn_green));
                }
            }
            k kVar = bVar.h;
            if (kVar.f) {
                strR = contactRequestsVO.getFormatShowName();
            } else if (kVar.d || kVar.e) {
                String localOrRealName = contactRequestsVO.getLocalOrRealName(bVar.c);
                if (!TextUtils.isEmpty(localOrRealName)) {
                    strR = strR + str + localOrRealName + ")";
                }
            }
            mx3Var.b.setText(strR);
            if (TextUtils.isEmpty(string)) {
                if (i3 == 2) {
                    string = bVar.f13552a.getString(R.string.notification_add_contact_request_group);
                } else if (i3 == 3) {
                    string = bVar.f13552a.getString(R.string.notification_add_contact_request_contact);
                } else if (i3 == 7) {
                    string = bVar.f13552a.getString(R.string.notification_add_contact_request_auto);
                } else if (i3 == 10) {
                    string = bVar.f13552a.getString(R.string.notification_add_contact_request_active);
                } else if (i3 == 14) {
                    string = bVar.f13552a.getString(R.string.notification_greeting_content);
                } else if (i3 != 20) {
                    if (i3 != 28 && i3 != 34) {
                        if (i3 != 17) {
                            string = i3 != 18 ? (i3 == 22 || i3 == 23) ? bVar.f13552a.getString(R.string.notification_add_contact_request_sec) : bVar.f13552a.getString(R.string.notification_add_contact_request_content_new) : bVar.f13552a.getString(R.string.notification_add_contact_request_accurate);
                        }
                    }
                }
            }
            mx3Var.c.setText(string);
        } else {
            String localOrRealName2 = contactRequestsVO.getLocalOrRealName(bVar.c);
            if (bVar.h.f) {
                strR = contactRequestsVO.getFormatShowName();
            } else if (!TextUtils.isEmpty(localOrRealName2)) {
                strR = strR + " (" + localOrRealName2 + ")";
            }
            mx3Var.b.setText(strR);
            mx3Var.d.setBackgroundResource(R.drawable.shape_cccccc_bg_radius_15);
            mx3Var.d.setTextColor(bVar.f13552a.getResources().getColor(R.color.text_color_ffffff));
            if (j3 == 2) {
                if (zW) {
                    mx3Var.d.setText(R.string.contact_already_friend);
                } else {
                    mx3Var.d.setText(R.string.contact_friend_wait_confirm);
                }
                mx3Var.d.setEnabled(false);
            } else if (zW) {
                mx3Var.d.setText(R.string.contact_already_friend);
                mx3Var.d.setEnabled(false);
            } else {
                mx3Var.d.setBackgroundResource(R.drawable.selector_btn_green_invite);
                mx3Var.d.setTextColor(bVar.f13552a.getResources().getColor(R.color.text_color_btn_green));
                mx3Var.d.setText(R.string.contact_add_friend);
                mx3Var.d.setEnabled(true);
            }
            if (i4 >= 200 || i4 < 100) {
                if (i4 == 220) {
                    mx3Var.c.setText(R.string.contact_others_phone);
                } else {
                    mx3Var.c.setText(contactRequestsVO.recommendText);
                }
            } else if (TextUtils.isEmpty(localOrRealName2)) {
                mx3Var.c.setText(bVar.f13552a.getString(R.string.add_contact_item_link));
            } else {
                mx3Var.c.setText(bVar.f13552a.getString(R.string.contact_phone_nick_name, localOrRealName2));
            }
        }
        if (bVar.h.e) {
            mx3Var.g.setVisibility(8);
            mx3Var.h.setVisibility(8);
        }
        k kVar2 = bVar.h;
        if (kVar2.e) {
            if (zW || j2 != 0) {
                mx3Var.f.setBackgroundResource(R.drawable.selector_settings_item_background);
            } else {
                mx3Var.f.setBackgroundResource(R.drawable.selector_contact_requset_item_background_unclicker_other);
            }
        } else if (j2 != 0) {
            mx3Var.f.setBackgroundResource(R.drawable.selector_settings_item_background);
        } else if (kVar2.d) {
            mx3Var.f.setBackgroundResource(R.drawable.selector_settings_item_background_unclicker_dis);
        } else {
            mx3Var.f.setBackgroundResource(R.drawable.selector_settings_item_background_unclicker);
        }
        mx3Var.d.setOnClickListener(new c(contactInfoItemConvert2ContactInfoItem, i4, str2, str3, str4, contactRequestsVO));
        if (mx3Var.i != null) {
            if (!bVar.h.g || TextUtils.isEmpty(contactRequestsVO.carImageUrl)) {
                mx3Var.i.setVisibility(8);
            } else {
                mx3Var.i.setVisibility(0);
                gr2.j().h(contactRequestsVO.carImageUrl, mx3Var.i, bq6.b());
            }
        }
        if (mx3Var.k != null) {
            if (contactInfoItemConvert2ContactInfoItem == null || !contactInfoItemConvert2ContactInfoItem.isOfficialAccount()) {
                mx3Var.k.setVisibility(8);
            } else {
                mx3Var.k.setVisibility(0);
            }
        }
        int iG = fg6.g(contactInfoItemConvert2ContactInfoItem.getExt());
        if (mx3Var.j != null) {
            if (fg6.q(iG)) {
                mx3Var.j.setVisibility(0);
                mx3Var.j.setImageResource(fg6.c(iG));
            } else {
                mx3Var.j.setVisibility(8);
            }
        }
        if (contactInfoItemConvert2ContactInfoItem.isOfficialAccount()) {
            mx3Var.b.setTextColor(bVar.f13552a.getResources().getColor(R.color.Gg));
        } else {
            mx3Var.b.setTextColor(fg6.n(bVar.f13552a, iG));
        }
    }

    public void p() {
        o2 o2Var = this.e;
        if (o2Var != null) {
            o2Var.onCancel();
        }
        f7 f7Var = this.f;
        if (f7Var != null) {
            f7Var.onCancel();
        }
        ih ihVar = this.g;
        if (ihVar != null) {
            ihVar.onCancel();
        }
    }

    public final String q(String str, String str2) {
        ContactInfoItem contactInfoItemL = bo0.r().l(str);
        return contactInfoItemL != null ? contactInfoItemL.getIconURL() : str2;
    }

    public final String r(String str, String str2) {
        ContactInfoItem contactInfoItemL = bo0.r().l(str);
        return contactInfoItemL != null ? contactInfoItemL.getNickName() : str2;
    }

    public void s(ArrayList<j> arrayList) {
        if (arrayList != null) {
            this.d = arrayList;
            notifyDataSetChanged();
        }
    }

    public void t(ArrayList<ContactRequestsVO> arrayList) {
        if (arrayList != null) {
            this.d.clear();
            Iterator<ContactRequestsVO> it = arrayList.iterator();
            while (it.hasNext()) {
                this.d.add(new j(it.next()));
            }
            notifyDataSetChanged();
            u(true);
        }
    }

    public void u(boolean z) {
        boolean z2 = true;
        if (z) {
            if (this.i) {
                z2 = false;
            } else {
                this.i = true;
            }
        }
        if (z2) {
            ArrayList arrayList = new ArrayList();
            Iterator<j> it = this.d.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().b);
            }
            un0.f(arrayList, "Adapter updateContactRequests" + z);
        }
    }

    public void v(HashMap<String, PhoneContactItem> map) {
        this.c = map;
        notifyDataSetChanged();
    }
}
