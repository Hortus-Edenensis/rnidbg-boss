package com.zenmen.palmchat.groupchat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.az;
import com.wifi.adsdk.utils.CollectionUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.circle.bean.CircleAppItem;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.circle.bean.CircleNoticeList;
import com.zenmen.palmchat.circle.bean.CircleRecommendItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.CircleAuthActivity;
import com.zenmen.palmchat.circle.ui.CircleCateSelectActivity;
import com.zenmen.palmchat.circle.ui.CircleDetailActivity;
import com.zenmen.palmchat.circle.ui.CircleGroupRemarkActivity;
import com.zenmen.palmchat.circle.ui.CircleNameModifyActivity;
import com.zenmen.palmchat.circle.ui.CircleNoteActivity;
import com.zenmen.palmchat.circle.ui.CirclePrivilageActivity;
import com.zenmen.palmchat.circle.ui.CircleQRCodeActivity;
import com.zenmen.palmchat.circle.ui.CircleToolActivity;
import com.zenmen.palmchat.circle.ui.config.CircleConfig;
import com.zenmen.palmchat.circle.ui.view.CircleChatInfoToolsItemView;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.dating.bean.DatingGroupToolBeans;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.groupchat.ChatInfoActivity;
import com.zenmen.palmchat.groupchat.a;
import com.zenmen.palmchat.groupchat.dao.GroupModifyResultVo;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.publish.PublishActivity;
import com.zenmen.palmchat.redpacket.pay.SPWalletUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.SocialPortraitView;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.UI;
import defpackage.ap3;
import defpackage.b56;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.c70;
import defpackage.cb0;
import defpackage.de2;
import defpackage.dt2;
import defpackage.dx5;
import defpackage.f25;
import defpackage.fn0;
import defpackage.gr2;
import defpackage.hx3;
import defpackage.i65;
import defpackage.ie2;
import defpackage.ih;
import defpackage.iq5;
import defpackage.ir5;
import defpackage.is0;
import defpackage.j70;
import defpackage.j92;
import defpackage.je2;
import defpackage.jw5;
import defpackage.k65;
import defpackage.k80;
import defpackage.k86;
import defpackage.l03;
import defpackage.l50;
import defpackage.l65;
import defpackage.m66;
import defpackage.nl0;
import defpackage.nw5;
import defpackage.o7;
import defpackage.oc0;
import defpackage.pm2;
import defpackage.pu2;
import defpackage.qa0;
import defpackage.qm5;
import defpackage.ry5;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.v8;
import defpackage.vq4;
import defpackage.wc1;
import defpackage.wi0;
import defpackage.xn3;
import defpackage.ye2;
import defpackage.yy2;
import defpackage.zd2;
import defpackage.zg5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ChatInfoActivity extends BaseActionBarActivity implements pm2<Cursor>, a.d {
    public static final String x1 = "ChatInfoActivity";
    public CheckBox A;
    public Response.Listener<JSONObject> A0;
    public CheckBox B;
    public Response.ErrorListener B0;
    public View C;
    public Response.Listener<JSONObject> C0;
    public Response.ErrorListener D0;
    public View E;
    public Response.Listener<JSONObject> E0;
    public View F;
    public Response.ErrorListener F0;
    public View G;
    public Response.Listener<JSONObject> G0;
    public TextView H;
    public SocialPortraitView I;
    public b56 I0;
    public View J;
    public vq4 J0;
    public TextView K;
    public f25 K0;
    public View L;
    public l65 L0;
    public View M;
    public i65 M0;
    public View N;
    public k65 N0;
    public TextView O;
    public l03 O0;
    public TextView P;
    public ih P0;
    public SocialPortraitView Q;
    public ArrayList<ContactInfoItem> Q0;
    public View R;
    public String R0;
    public View S;
    public View T;
    public View U;
    public TextView U0;
    public View V;
    public TextView V0;
    public CheckBox W;
    public TextView W0;
    public boolean X0;
    public FrameLayout Y;
    public String Y0;
    public TextView Z;
    public TextView Z0;
    public String a1;
    public String b1;
    public TextView c1;
    public k80 d1;
    public TextView e0;
    public ViewGroup e1;
    public View f0;
    public ViewGroup f1;
    public CheckBox g0;
    public ViewGroup g1;
    public View h0;
    public View h1;
    public View i0;
    public CircleChatInfoToolsItemView i1;
    public View j0;
    public CircleChatInfoToolsItemView j1;
    public View k0;
    public CircleChatInfoToolsItemView k1;
    public View l0;
    public TextView l1;
    public View m0;
    public LinearLayout m1;
    public View n0;
    public LinearLayout n1;
    public TextView o0;
    public LinearLayout o1;
    public String p0;
    public Toolbar r;
    public View s;
    public View t;
    public Response.ErrorListener t0;
    public ListView u;
    public Response.Listener<JSONObject> u0;
    public com.zenmen.palmchat.groupchat.a v;
    public Response.ErrorListener v0;
    public ContactInfoItem w;
    public Response.Listener<JSONObject> w0;
    public GroupInfoItem x;
    public Response.ErrorListener x0;
    public ContactInfoItem y;
    public Response.Listener<JSONObject> y0;
    public CheckBox z;
    public Response.ErrorListener z0;
    public int q = 0;
    public ArrayList<CircleAppItem> X = new ArrayList<>();
    public final int q0 = 0;
    public final int r0 = 1;
    public int s0 = 0;
    public boolean H0 = false;
    public String[] S0 = {AppContext.getContext().getResources().getString(R.string.circle_menu_share_friend), AppContext.getContext().getResources().getString(R.string.circle_menu_share_friendcircle), AppContext.getContext().getResources().getString(R.string.circle_menu_save_qr)};
    public int[] T0 = {R.drawable.ic_share_friends, R.drawable.ic_share_moments, R.drawable.icon_group_qrcode};
    public int p1 = 0;
    public ArrayList<ContactInfoItem> q1 = new ArrayList<>();
    public is0.f r1 = new p1();
    public boolean s1 = false;
    public boolean t1 = false;
    public boolean u1 = false;
    public boolean v1 = false;
    public boolean w1 = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatInfoActivity.this.m3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a0 extends HashMap<String, Object> {
        public a0() {
            put("roomId", ChatInfoActivity.this.x.getChatId());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a1 implements Response.Listener<JSONObject> {
        public a1() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            ChatInfoActivity.this.hideBaseProgressBar();
            if (iOptInt != 0) {
                ChatInfoActivity.this.showRequestFailDialog(yy2.a(jSONObject), ChatInfoActivity.this.getString(R.string.send_failed));
            } else {
                iq5.j(false, new String[0]);
                ChatInfoActivity.this.r4();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a2 implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14124a;

        public a2(String str) {
            this.f14124a = str;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ChatInfoActivity.this.hideBaseProgressBar();
            sy5.e(ChatInfoActivity.this, R.string.send_failed, 0).g();
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "2", this.f14124a + "errorMsg:" + volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatInfoActivity.this.d3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b0 extends wi0<BaseResponse<CircleRecommendItem>> {
        public b0() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleRecommendItem> baseResponse) {
            int i;
            if (baseResponse != null && baseResponse.getResultCode() == 0 && (i = baseResponse.getData().checkTotalNum) > 0) {
                ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
                chatInfoActivity.i4(chatInfoActivity.Z, 0);
                ChatInfoActivity chatInfoActivity2 = ChatInfoActivity.this;
                chatInfoActivity2.h4(chatInfoActivity2.Z, String.valueOf(i));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b1 implements Response.ErrorListener {
        public b1() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ChatInfoActivity.this.hideBaseProgressBar();
            ChatInfoActivity.this.o4();
            LogUtil.d(ChatInfoActivity.x1, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b2 implements View.OnClickListener {
        public b2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(ChatInfoActivity.this, GroupMemberListActivity.class);
            intent.putExtra("type_add", true);
            intent.putExtra("groupitem", ChatInfoActivity.this.x);
            ChatInfoActivity.this.startActivityForResult(intent, 3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                ChatInfoActivity.this.J0 = new vq4(ChatInfoActivity.this.y0, ChatInfoActivity.this.x0);
                try {
                    ChatInfoActivity.this.J0.n(ChatInfoActivity.this.x.getGroupId());
                    ChatInfoActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
                } catch (DaoException e) {
                    e.printStackTrace();
                    ChatInfoActivity.this.hideBaseProgressBar();
                }
            }
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new sd3(ChatInfoActivity.this).j(R.string.group_quit_alert_message).N(R.color.material_dialog_button_text_color_red).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new a()).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c0 implements View.OnClickListener {
        public c0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ap3.a().B(ChatInfoActivity.this, nl0.q + "/vip/#/renewal");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c1 implements Response.Listener<JSONObject> {
        public c1() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            ChatInfoActivity.this.hideBaseProgressBar();
            if (iOptInt == 0) {
                iq5.j(false, new String[0]);
                ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
                sy5.e(chatInfoActivity, chatInfoActivity.B.isChecked() ? R.string.toast_save_group_contact : R.string.toast_remove_group_contact, 0).g();
            } else {
                if (ChatInfoActivity.this.d1.d(ChatInfoActivity.this, iOptInt, jSONObject.optString(MediationConstant.KEY_ERROR_MSG))) {
                    return;
                }
                ChatInfoActivity.this.o4();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c2 implements View.OnClickListener {
        public c2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChatInfoActivity.this.x == null || ChatInfoActivity.this.x.getGroupOwner() == null || !ChatInfoActivity.this.x.getGroupOwner().equals(AccountUtils.p(ChatInfoActivity.this))) {
                return;
            }
            Intent intent = new Intent(ChatInfoActivity.this, (Class<?>) CircleCateSelectActivity.class);
            intent.putExtra("extra_from", 1);
            intent.putExtra("extra_room_id", ChatInfoActivity.this.x.getGroupId());
            intent.putExtra("extra_selected_cate_name", ChatInfoActivity.this.a1);
            intent.putExtra("extra_selected_cate_id", ChatInfoActivity.this.b1);
            ChatInfoActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                com.zenmen.palmchat.database.b.j(ChatInfoActivity.this.q == 1 ? ChatInfoActivity.this.x : ChatInfoActivity.this.w);
            }
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string;
            if (ChatInfoActivity.this.q == 1) {
                string = ChatInfoActivity.this.getString(R.string.string_delete_chat_message_dialog_group);
            } else if (ChatInfoActivity.this.w != null) {
                ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
                string = chatInfoActivity.getString(R.string.string_delete_chat_message_dialog_single, chatInfoActivity.w.getNameForShow());
            } else {
                string = null;
            }
            if (string == null) {
                return;
            }
            new sd3(ChatInfoActivity.this).k(string).N(R.color.material_dialog_button_text_color_red).K(R.string.alert_dialog_cancel).O(R.string.string_delete_chat_message_dialog_ok).f(new a()).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d0 implements View.OnClickListener {
        public d0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChatInfoActivity.this.x == null || ChatInfoActivity.this.x.getGroupOwner() == null || !ChatInfoActivity.this.x.getGroupOwner().equals(AccountUtils.p(ChatInfoActivity.this))) {
                return;
            }
            Intent intent = new Intent(ChatInfoActivity.this, (Class<?>) CircleCateSelectActivity.class);
            intent.putExtra("extra_from", 1);
            intent.putExtra("extra_room_id", ChatInfoActivity.this.x.getGroupId());
            intent.putExtra("extra_selected_cate_name", ChatInfoActivity.this.a1);
            intent.putExtra("extra_selected_cate_id", ChatInfoActivity.this.b1);
            ChatInfoActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d1 implements Response.ErrorListener {
        public d1() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ChatInfoActivity.this.hideBaseProgressBar();
            ChatInfoActivity.this.o4();
            LogUtil.d(ChatInfoActivity.x1, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatInfoActivity.this.p3(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e0 implements View.OnClickListener {
        public e0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(ChatInfoActivity.this, GroupMemberListActivity.class);
            intent.putExtra("type_add", true);
            intent.putExtra("groupitem", ChatInfoActivity.this.x);
            ChatInfoActivity.this.startActivityForResult(intent, 3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e1 implements Response.Listener<JSONObject> {
        public e1() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            ChatInfoActivity.this.hideBaseProgressBar();
            if (iOptInt != 0) {
                ChatInfoActivity.this.showRequestFailDialog(yy2.a(jSONObject), ChatInfoActivity.this.getString(R.string.send_failed));
            } else {
                iq5.j(false, new String[0]);
                ChatInfoActivity.this.r4();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements CompoundButton.OnCheckedChangeListener {
        public f() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!hx3.m(ChatInfoActivity.this)) {
                sy5.e(ChatInfoActivity.this, R.string.net_status_unavailable, 1).g();
            }
            if (ChatInfoActivity.this.w1) {
                return;
            }
            String strJ3 = ChatInfoActivity.this.j3();
            if (TextUtils.isEmpty(strJ3)) {
                return;
            }
            int iD = jw5.d(ChatInfoActivity.this.q, z, ChatInfoActivity.this.A.isChecked(), ChatInfoActivity.this.g0.isChecked(), ChatInfoActivity.this.v1, zg5.j(strJ3));
            ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
            chatInfoActivity.e3(chatInfoActivity.q, strJ3, iD);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f1 implements Response.ErrorListener {
        public f1() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ChatInfoActivity.this.hideBaseProgressBar();
            ChatInfoActivity.this.o4();
            LogUtil.d(ChatInfoActivity.x1, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements CompoundButton.OnCheckedChangeListener {
        public g() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!hx3.m(ChatInfoActivity.this)) {
                sy5.e(ChatInfoActivity.this, R.string.net_status_unavailable, 1).g();
            }
            if (ChatInfoActivity.this.w1) {
                return;
            }
            String strJ3 = ChatInfoActivity.this.j3();
            if (TextUtils.isEmpty(strJ3)) {
                return;
            }
            int iD = jw5.d(ChatInfoActivity.this.q, ChatInfoActivity.this.z.isChecked(), z, ChatInfoActivity.this.g0.isChecked(), ChatInfoActivity.this.v1, zg5.j(strJ3));
            ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
            chatInfoActivity.e3(chatInfoActivity.q, strJ3, iD);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g0 implements View.OnClickListener {
        public g0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(ChatInfoActivity.this, GroupMemberListActivity.class);
            intent.putExtra("type_add", true);
            intent.putExtra("groupitem", ChatInfoActivity.this.x);
            ChatInfoActivity.this.startActivityForResult(intent, 3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g1 implements Response.Listener<JSONObject> {
        public g1() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            ChatInfoActivity.this.hideBaseProgressBar();
            if (iOptInt != 0 && iOptInt != 404 && iOptInt != 403) {
                if (iOptInt == 5085) {
                    new sd3(ChatInfoActivity.this).k(jSONObject.optString(MediationConstant.KEY_ERROR_MSG)).O(R.string.alert_dialog_ok).f(null).e().show();
                    return;
                } else {
                    ChatInfoActivity.this.o4();
                    return;
                }
            }
            com.zenmen.palmchat.database.b.j(ChatInfoActivity.this.q == 1 ? ChatInfoActivity.this.x : ChatInfoActivity.this.w);
            nw5.d(DomainHelper.l(ChatInfoActivity.this.q == 1 ? ChatInfoActivity.this.x : ChatInfoActivity.this.w));
            iq5.j(false, new String[0]);
            ChatInfoActivity.this.r4();
            Intent intent = new Intent(ChatInfoActivity.this, (Class<?>) MainTabsActivity.class);
            k86.X(intent);
            ChatInfoActivity.this.startActivity(intent);
            ChatInfoActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements CompoundButton.OnCheckedChangeListener {
        public h() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!hx3.m(ChatInfoActivity.this)) {
                sy5.e(ChatInfoActivity.this, R.string.net_status_unavailable, 1).g();
            }
            if (ChatInfoActivity.this.w1) {
                return;
            }
            String strJ3 = ChatInfoActivity.this.j3();
            if (TextUtils.isEmpty(strJ3)) {
                return;
            }
            int iD = jw5.d(ChatInfoActivity.this.q, ChatInfoActivity.this.z.isChecked(), ChatInfoActivity.this.A.isChecked(), z, ChatInfoActivity.this.v1, zg5.j(strJ3));
            ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
            chatInfoActivity.e3(chatInfoActivity.q, strJ3, iD);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h0 implements View.OnClickListener {
        public h0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatInfoActivity.this.m3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h1 implements Response.ErrorListener {
        public h1() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ChatInfoActivity.this.hideBaseProgressBar();
            if (hx3.m(ChatInfoActivity.this)) {
                ChatInfoActivity.this.o4();
            }
            LogUtil.d(ChatInfoActivity.x1, volleyError.toString());
            ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
            chatInfoActivity.t4(chatInfoActivity.t1);
            ChatInfoActivity chatInfoActivity2 = ChatInfoActivity.this;
            chatInfoActivity2.z4(chatInfoActivity2.s1);
            ChatInfoActivity chatInfoActivity3 = ChatInfoActivity.this;
            chatInfoActivity3.y4(chatInfoActivity3.u1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements CompoundButton.OnCheckedChangeListener {
        public i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int i = 1;
            if ((ChatInfoActivity.this.x.getGroupType() == 1) != z) {
                ChatInfoActivity.this.K0 = new f25(ChatInfoActivity.this.E0, ChatInfoActivity.this.D0);
                try {
                    f25 f25Var = ChatInfoActivity.this.K0;
                    String groupId = ChatInfoActivity.this.x.getGroupId();
                    if (!z) {
                        i = 0;
                    }
                    f25Var.n(groupId, i);
                    ChatInfoActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
                } catch (DaoException e) {
                    e.printStackTrace();
                    ChatInfoActivity.this.hideBaseProgressBar();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i0 implements View.OnClickListener {
        public i0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatInfoActivity.this.d3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i1 implements Response.Listener<JSONObject> {
        public i1() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d(ChatInfoActivity.x1, jSONObject.toString());
            int iOptInt = jSONObject.optInt("resultCode");
            ChatInfoActivity.this.hideBaseProgressBar();
            if (iOptInt != 0) {
                if (ChatInfoActivity.this.d1.d(ChatInfoActivity.this, iOptInt, jSONObject.optString(MediationConstant.KEY_ERROR_MSG))) {
                    return;
                }
                ChatInfoActivity.this.o4();
            } else if (1 == ChatInfoActivity.this.q) {
                iq5.j(false, "4");
            } else {
                iq5.j(false, new String[0]);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(ChatInfoActivity.this, (Class<?>) ChatPhotoGridActivity.class);
            intent.putExtra("info_item", ChatInfoActivity.this.q == 0 ? ChatInfoActivity.this.w : ChatInfoActivity.this.x);
            ChatInfoActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j0 implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                ChatInfoActivity.this.Z3();
            }
        }

        public j0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new sd3(ChatInfoActivity.this).j(R.string.group_quit_alert_message).N(R.color.material_dialog_button_text_color_red).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new a()).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j1 implements Response.ErrorListener {
        public j1() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ChatInfoActivity.this.hideBaseProgressBar();
            ChatInfoActivity.this.o4();
            LogUtil.d(ChatInfoActivity.x1, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends wi0<BaseResponse<CircleNoticeList>> {
        public k() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleNoticeList> baseResponse) {
            if (baseResponse == null || baseResponse.getData() == null) {
                return;
            }
            List<CircleNoticeItem> detailVOList = baseResponse.getData().getDetailVOList();
            if (CollectionUtils.isEmpty(detailVOList)) {
                ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
                chatInfoActivity.i4(chatInfoActivity.S, 8);
                return;
            }
            CircleNoticeItem circleNoticeItem = detailVOList.get(0);
            ChatInfoActivity chatInfoActivity2 = ChatInfoActivity.this;
            chatInfoActivity2.h4(chatInfoActivity2.V0, circleNoticeItem.getContent());
            ChatInfoActivity chatInfoActivity3 = ChatInfoActivity.this;
            chatInfoActivity3.i4(chatInfoActivity3.S, 0);
            if (circleNoticeItem.getStatus() == 1) {
                ChatInfoActivity chatInfoActivity4 = ChatInfoActivity.this;
                chatInfoActivity4.i4(chatInfoActivity4.Z0, 0);
                ChatInfoActivity chatInfoActivity5 = ChatInfoActivity.this;
                chatInfoActivity5.b4(chatInfoActivity5.Z0, R.drawable.shape_red_round_corner_8dp);
                ChatInfoActivity chatInfoActivity6 = ChatInfoActivity.this;
                chatInfoActivity6.h4(chatInfoActivity6.Z0, "审核中");
                return;
            }
            if (circleNoticeItem.getStatus() != 3) {
                ChatInfoActivity chatInfoActivity7 = ChatInfoActivity.this;
                chatInfoActivity7.i4(chatInfoActivity7.Z0, 8);
                return;
            }
            ChatInfoActivity chatInfoActivity8 = ChatInfoActivity.this;
            chatInfoActivity8.i4(chatInfoActivity8.Z0, 0);
            ChatInfoActivity chatInfoActivity9 = ChatInfoActivity.this;
            chatInfoActivity9.b4(chatInfoActivity9.Z0, R.drawable.shape_lightred_round_corner_8dp);
            ChatInfoActivity chatInfoActivity10 = ChatInfoActivity.this;
            chatInfoActivity10.h4(chatInfoActivity10.Z0, "审核失败");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k0 implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                com.zenmen.palmchat.database.b.j(ChatInfoActivity.this.q == 1 ? ChatInfoActivity.this.x : ChatInfoActivity.this.w);
            }
        }

        public k0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string;
            if (ChatInfoActivity.this.q == 1) {
                string = ChatInfoActivity.this.getString(R.string.string_delete_chat_message_dialog_group);
            } else if (ChatInfoActivity.this.w != null) {
                ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
                string = chatInfoActivity.getString(R.string.string_delete_chat_message_dialog_single, chatInfoActivity.w.getNameForShow());
            } else {
                string = null;
            }
            if (string == null) {
                return;
            }
            new sd3(ChatInfoActivity.this).k(string).N(R.color.material_dialog_button_text_color_red).K(R.string.alert_dialog_cancel).O(R.string.string_delete_chat_message_dialog_ok).f(new a()).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k1 implements Response.Listener<JSONObject> {
        public k1() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            ChatInfoActivity.this.hideBaseProgressBar();
            if (jSONObject.optInt("resultCode") == 0) {
                sy5.e(ChatInfoActivity.this, R.string.sent, 0).g();
                return;
            }
            String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = ChatInfoActivity.this.getString(R.string.send_failed);
            }
            sy5.f(chatInfoActivity, strOptString, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l0 implements View.OnClickListener {
        public l0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatInfoActivity.this.p3(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l1 implements View.OnClickListener {
        public l1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(ChatInfoActivity.this, (Class<?>) CircleAuthActivity.class);
            intent.putExtra(j70.f18338a, ChatInfoActivity.this.x.getGroupId());
            ChatInfoActivity.this.startActivityForResult(intent, 100);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m0 implements View.OnClickListener {
        public m0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatInfoActivity.this.p3(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m1 implements View.OnClickListener {
        public m1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(ChatInfoActivity.this, CirclePrivilageActivity.class);
            intent.putExtra("key_group_info", ChatInfoActivity.this.x);
            ChatInfoActivity.this.startActivityForResult(intent, 12);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(ChatInfoActivity.this, GroupMemberListActivity.class);
            intent.putExtra("type_add", true);
            intent.putExtra("groupitem", ChatInfoActivity.this.x);
            ChatInfoActivity.this.startActivityForResult(intent, 3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n0 implements CompoundButton.OnCheckedChangeListener {
        public n0() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!hx3.m(ChatInfoActivity.this)) {
                sy5.e(ChatInfoActivity.this, R.string.net_status_unavailable, 1).g();
            }
            if (ChatInfoActivity.this.w1) {
                return;
            }
            String strJ3 = ChatInfoActivity.this.j3();
            if (TextUtils.isEmpty(strJ3)) {
                return;
            }
            int iD = jw5.d(ChatInfoActivity.this.q, z, ChatInfoActivity.this.A.isChecked(), ChatInfoActivity.this.g0.isChecked(), ChatInfoActivity.this.v1, zg5.j(strJ3));
            ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
            chatInfoActivity.e3(chatInfoActivity.q, strJ3, iD);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n1 extends AsyncTask<Void, Void, ArrayList<ContactInfoItem>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Cursor f14178a;

        public n1(Cursor cursor) {
            this.f14178a = cursor;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<ContactInfoItem> doInBackground(Void... voidArr) {
            return ChatInfoActivity.this.x3(this.f14178a);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ArrayList<ContactInfoItem> arrayList) {
            super.onPostExecute(arrayList);
            ChatInfoActivity.this.W3(arrayList);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChatInfoActivity.this.x == null || ChatInfoActivity.this.x.getGroupOwner() == null || !ChatInfoActivity.this.x.getGroupOwner().equals(AccountUtils.p(ChatInfoActivity.this))) {
                return;
            }
            Intent intent = new Intent(ChatInfoActivity.this, (Class<?>) CircleCateSelectActivity.class);
            intent.putExtra("extra_from", 1);
            intent.putExtra("extra_room_id", ChatInfoActivity.this.x.getGroupId());
            intent.putExtra("extra_selected_cate_name", ChatInfoActivity.this.a1);
            intent.putExtra("extra_selected_cate_id", ChatInfoActivity.this.b1);
            ChatInfoActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o0 implements CompoundButton.OnCheckedChangeListener {
        public o0() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!hx3.m(ChatInfoActivity.this)) {
                sy5.e(ChatInfoActivity.this, R.string.net_status_unavailable, 1).g();
            }
            if (ChatInfoActivity.this.w1) {
                return;
            }
            String strJ3 = ChatInfoActivity.this.j3();
            if (TextUtils.isEmpty(strJ3)) {
                return;
            }
            int iD = jw5.d(ChatInfoActivity.this.q, ChatInfoActivity.this.z.isChecked(), z, ChatInfoActivity.this.g0.isChecked(), ChatInfoActivity.this.v1, zg5.j(strJ3));
            ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
            chatInfoActivity.e3(chatInfoActivity.q, strJ3, iD);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o1 implements Comparator<ContactInfoItem> {
        public o1() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ContactInfoItem contactInfoItem, ContactInfoItem contactInfoItem2) {
            int iB = zd2.b(contactInfoItem.getNickName(), "连信用户") - zd2.b(contactInfoItem2.getNickName(), "连信用户");
            return iB != 0 ? iB : contactInfoItem.getRoleType() - contactInfoItem2.getRoleType();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
            CircleGroupRemarkActivity.G1(chatInfoActivity, chatInfoActivity.x, ChatInfoActivity.this.Y0, 10);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p0 implements CompoundButton.OnCheckedChangeListener {
        public p0() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!hx3.m(ChatInfoActivity.this)) {
                sy5.e(ChatInfoActivity.this, R.string.net_status_unavailable, 1).g();
            }
            if (ChatInfoActivity.this.w1) {
                return;
            }
            String strJ3 = ChatInfoActivity.this.j3();
            if (TextUtils.isEmpty(strJ3)) {
                return;
            }
            int iD = jw5.d(ChatInfoActivity.this.q, ChatInfoActivity.this.z.isChecked(), ChatInfoActivity.this.A.isChecked(), z, ChatInfoActivity.this.v1, zg5.j(strJ3));
            ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
            chatInfoActivity.e3(chatInfoActivity.q, strJ3, iD);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p1 implements is0.f {
        public p1() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i == 0) {
                MessageVo threadBizType = MessageVo.buildNameCardMessage(xn3.a(), (String) null, ChatInfoActivity.this.x, 0, ir5.b()).setThreadBizType(ChatInfoActivity.this, 1);
                Intent intent = new Intent(ChatInfoActivity.this, (Class<?>) SendMessageActivity.class);
                intent.putExtra("message_vo", threadBizType);
                intent.putExtra("extra_from", 2);
                intent.putExtra("extra_is_show_group", false);
                intent.addFlags(268435456);
                ChatInfoActivity.this.startActivity(intent);
                return;
            }
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                ChatInfoActivity.this.m3();
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("key_from", 1);
            intent2.putExtra("key_publish_type", 2);
            ArrayList arrayList = new ArrayList();
            MediaItem mediaItem = new MediaItem();
            mediaItem.fileFullPath = "www.baidu.com";
            arrayList.add(mediaItem);
            intent2.putExtra("key_publish_pictures", arrayList);
            intent2.setClass(ChatInfoActivity.this, PublishActivity.class);
            ChatInfoActivity.this.startActivity(intent2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatInfoActivity.this.m3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q0 implements CompoundButton.OnCheckedChangeListener {
        public q0() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int i = 1;
            if ((ChatInfoActivity.this.x.getGroupType() == 1) != z) {
                ChatInfoActivity.this.K0 = new f25(ChatInfoActivity.this.E0, ChatInfoActivity.this.D0);
                try {
                    f25 f25Var = ChatInfoActivity.this.K0;
                    String groupId = ChatInfoActivity.this.x.getGroupId();
                    if (!z) {
                        i = 0;
                    }
                    f25Var.n(groupId, i);
                    ChatInfoActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
                } catch (DaoException e) {
                    e.printStackTrace();
                    ChatInfoActivity.this.hideBaseProgressBar();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q1 extends HashMap<String, Object> {
        public q1() {
            put("type", Integer.valueOf(ChatInfoActivity.this.q == 0 ? 1 : 2));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatInfoActivity.this.d3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r0 implements View.OnClickListener {
        public r0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(ChatInfoActivity.this, CircleDetailActivity.class);
            intent.putExtra(j70.f18338a, ChatInfoActivity.this.x.getGroupId());
            intent.putExtra("key_apply_group_source", -1);
            intent.putExtra("key_group_info", ChatInfoActivity.this.x);
            intent.putExtra("extra_selected_cate_name", ChatInfoActivity.this.a1);
            intent.putExtra("extra_selected_cate_id", ChatInfoActivity.this.b1);
            ChatInfoActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                ChatInfoActivity.this.Z3();
            }
        }

        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new sd3(ChatInfoActivity.this).j(R.string.group_quit_alert_message).N(R.color.material_dialog_button_text_color_red).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new a()).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s1 extends MaterialDialog.e {
        public s1() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (TextUtils.isEmpty(ChatInfoActivity.this.R0) || ChatInfoActivity.this.Q0 == null || ChatInfoActivity.this.Q0.size() <= 0) {
                return;
            }
            ChatInfoActivity.this.h3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                com.zenmen.palmchat.database.b.j(ChatInfoActivity.this.q == 1 ? ChatInfoActivity.this.x : ChatInfoActivity.this.w);
            }
        }

        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string;
            if (ChatInfoActivity.this.q == 1) {
                string = ChatInfoActivity.this.getString(R.string.string_delete_chat_message_dialog_group);
            } else if (ChatInfoActivity.this.w != null) {
                ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
                string = chatInfoActivity.getString(R.string.string_delete_chat_message_dialog_single, chatInfoActivity.w.getNameForShow());
            } else {
                string = null;
            }
            if (string == null) {
                return;
            }
            new sd3(ChatInfoActivity.this).k(string).N(R.color.material_dialog_button_text_color_red).K(R.string.alert_dialog_cancel).O(R.string.string_delete_chat_message_dialog_ok).f(new a()).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t0 implements View.OnClickListener {
        public t0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(ChatInfoActivity.this, (Class<?>) ChatPhotoGridActivity.class);
            intent.putExtra("info_item", ChatInfoActivity.this.q == 0 ? ChatInfoActivity.this.w : ChatInfoActivity.this.x);
            ChatInfoActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t1 extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14200a;
        public final /* synthetic */ String b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse> {
            public a() {
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                ChatInfoActivity.this.hideBaseProgressBar();
                if (baseResponse.getResultCode() != 0) {
                    if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                        ChatInfoActivity.this.o4();
                    } else {
                        ChatInfoActivity.n4(baseResponse.getErrorMsg(), ChatInfoActivity.this);
                    }
                }
            }
        }

        public t1(ArrayList arrayList, String str) {
            this.f14200a = arrayList;
            this.b = str;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            ChatInfoActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            ArrayList arrayList = new ArrayList(this.f14200a.size());
            for (int i = 0; i < this.f14200a.size(); i++) {
                arrayList.add(((ContactInfoItem) this.f14200a.get(i)).getUid());
            }
            qa0.i().c(this.b, arrayList, materialDialog.k().getText().toString().trim(), new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatInfoActivity.this.p3(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u0 extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f14203a;

        public u0(EditText editText) {
            this.f14203a = editText;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            String string = this.f14203a.getText().toString();
            if (TextUtils.isEmpty(string.trim()) && ChatInfoActivity.this.y != null) {
                string = string.trim();
            }
            ChatInfoActivity.this.L0 = new l65(ChatInfoActivity.this.A0, ChatInfoActivity.this.z0);
            try {
                ChatInfoActivity.this.L0.n(ChatInfoActivity.this.x.getGroupId(), string);
                ChatInfoActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            } catch (DaoException e) {
                e.printStackTrace();
                ChatInfoActivity.this.hideBaseProgressBar();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u1 extends AsyncTask<Void, Void, GroupModifyResultVo> {
        public u1() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupModifyResultVo doInBackground(Void... voidArr) {
            try {
                return new pu2(null, null).n(ChatInfoActivity.this.Q0, ChatInfoActivity.this.R0);
            } catch (DaoException unused) {
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(GroupModifyResultVo groupModifyResultVo) {
            super.onPostExecute(groupModifyResultVo);
            ChatInfoActivity.this.hideBaseProgressBar();
            if (groupModifyResultVo == null) {
                ChatInfoActivity.this.o4();
                return;
            }
            int i = groupModifyResultVo.resultCode;
            if (i == 0 || i == 4001) {
                ChatInfoActivity.q4(ChatInfoActivity.this);
            } else if (TextUtils.isEmpty(groupModifyResultVo.errorMsg)) {
                ChatInfoActivity.this.o4();
            } else {
                ChatInfoActivity.n4(groupModifyResultVo.errorMsg, ChatInfoActivity.this);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v implements CompoundButton.OnCheckedChangeListener {
        public v() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!hx3.m(ChatInfoActivity.this)) {
                sy5.e(ChatInfoActivity.this, R.string.net_status_unavailable, 1).g();
            }
            if (ChatInfoActivity.this.w1) {
                return;
            }
            String strJ3 = ChatInfoActivity.this.j3();
            if (TextUtils.isEmpty(strJ3)) {
                return;
            }
            int iD = jw5.d(ChatInfoActivity.this.q, z, ChatInfoActivity.this.A.isChecked(), ChatInfoActivity.this.g0.isChecked(), ChatInfoActivity.this.v1, zg5.j(strJ3));
            ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
            chatInfoActivity.e3(chatInfoActivity.q, strJ3, iD);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v1 extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14207a;
        public final /* synthetic */ String[] b;

        public v1(ArrayList arrayList, String[] strArr) {
            this.f14207a = arrayList;
            this.b = strArr;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            ChatInfoActivity.this.k4(this.f14207a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements CompoundButton.OnCheckedChangeListener {
        public w() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!hx3.m(ChatInfoActivity.this)) {
                sy5.e(ChatInfoActivity.this, R.string.net_status_unavailable, 1).g();
            }
            if (ChatInfoActivity.this.w1) {
                return;
            }
            String strJ3 = ChatInfoActivity.this.j3();
            if (TextUtils.isEmpty(strJ3)) {
                return;
            }
            int iD = jw5.d(ChatInfoActivity.this.q, ChatInfoActivity.this.z.isChecked(), z, ChatInfoActivity.this.g0.isChecked(), ChatInfoActivity.this.v1, zg5.j(strJ3));
            ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
            chatInfoActivity.e3(chatInfoActivity.q, strJ3, iD);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w0 implements Runnable {
        public w0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatInfoActivity.this.v.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x implements CompoundButton.OnCheckedChangeListener {
        public x() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!hx3.m(ChatInfoActivity.this)) {
                sy5.e(ChatInfoActivity.this, R.string.net_status_unavailable, 1).g();
            }
            if (ChatInfoActivity.this.w1) {
                return;
            }
            String strJ3 = ChatInfoActivity.this.j3();
            if (TextUtils.isEmpty(strJ3)) {
                return;
            }
            int iD = jw5.d(ChatInfoActivity.this.q, ChatInfoActivity.this.z.isChecked(), ChatInfoActivity.this.A.isChecked(), z, ChatInfoActivity.this.v1, zg5.j(strJ3));
            ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
            chatInfoActivity.e3(chatInfoActivity.q, strJ3, iD);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x0 implements Response.ErrorListener {
        public x0() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ChatInfoActivity.this.hideBaseProgressBar();
            ChatInfoActivity.this.o4();
            LogUtil.d(ChatInfoActivity.x1, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x1 implements View.OnClickListener {
        public x1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
            CircleGroupRemarkActivity.G1(chatInfoActivity, chatInfoActivity.x, ChatInfoActivity.this.Y0, 10);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y implements CompoundButton.OnCheckedChangeListener {
        public y() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int i = 1;
            if ((ChatInfoActivity.this.x.getGroupType() == 1) != z) {
                ChatInfoActivity.this.K0 = new f25(ChatInfoActivity.this.E0, ChatInfoActivity.this.D0);
                try {
                    f25 f25Var = ChatInfoActivity.this.K0;
                    String groupId = ChatInfoActivity.this.x.getGroupId();
                    if (!z) {
                        i = 0;
                    }
                    f25Var.n(groupId, i);
                    ChatInfoActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
                } catch (DaoException e) {
                    e.printStackTrace();
                    ChatInfoActivity.this.hideBaseProgressBar();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y0 implements Response.Listener<JSONObject> {
        public y0() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            ChatInfoActivity.this.hideBaseProgressBar();
            if (iOptInt == 0) {
                iq5.j(false, new String[0]);
                ChatInfoActivity.this.r4();
            } else {
                if (ChatInfoActivity.this.d1.d(ChatInfoActivity.this, iOptInt, jSONObject.optString(MediationConstant.KEY_ERROR_MSG))) {
                    return;
                }
                ChatInfoActivity.this.o4();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y1 extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f14216a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ EditText c;

        public y1(String[] strArr, ArrayList arrayList, EditText editText) {
            this.f14216a = strArr;
            this.b = arrayList;
            this.c = editText;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            String exid;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            HashMap map = new HashMap();
            for (String str : this.f14216a) {
                Iterator it = this.b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        exid = null;
                        break;
                    }
                    ContactInfoItem contactInfoItem = (ContactInfoItem) it.next();
                    if (contactInfoItem.getUid().equals(str)) {
                        exid = contactInfoItem.getExid();
                        break;
                    }
                }
                sb.append(str);
                sb.append(",");
                sb2.append(exid);
                sb2.append(",");
                sb3.append(String.valueOf(2));
                sb3.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb2.deleteCharAt(sb2.length() - 1);
            sb3.deleteCharAt(sb3.length() - 1);
            map.put("fuids", sb.toString());
            map.put("fexids", sb2.toString());
            map.put("info", this.c.getText().toString());
            map.put("sourceType", String.valueOf(12));
            map.put("subTypes", sb3.toString());
            ChatInfoActivity.this.P0 = new ih(ChatInfoActivity.this.G0, ChatInfoActivity.this.F0);
            try {
                ChatInfoActivity.this.P0.s(map);
                ChatInfoActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z implements View.OnClickListener {
        public z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(ChatInfoActivity.this, (Class<?>) ChatPhotoGridActivity.class);
            intent.putExtra("info_item", ChatInfoActivity.this.q == 0 ? ChatInfoActivity.this.w : ChatInfoActivity.this.x);
            ChatInfoActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z0 implements Response.ErrorListener {
        public z0() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ChatInfoActivity.this.hideBaseProgressBar();
            ChatInfoActivity.this.o4();
            LogUtil.d(ChatInfoActivity.x1, volleyError.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K3(View view) {
        CircleConfig config = CircleConfig.getConfig();
        String urlCreateCircle = config != null ? config.getUrlCreateCircle() : CircleConfig.URL_CREATE_CIRCLE_DEF;
        Intent intent = new Intent(this, (Class<?>) CordovaWebActivity.class);
        intent.putExtra("web_url", urlCreateCircle);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M3(View view) {
        Intent intent = new Intent();
        intent.setClass(this, CircleNoteActivity.class);
        intent.putExtra(j70.f18338a, this.x.getGroupId());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N3(View view) {
        Intent intent = new Intent(this, (Class<?>) ChatPhotoGridActivity.class);
        intent.putExtra("info_item", this.q == 0 ? this.w : this.x);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O3(View view) {
        CircleToolActivity.I1(this, this.x.getGroupId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q3(View view) {
        j4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R3(View view) {
        CircleToolActivity.I1(this, this.x.getGroupId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S3(View view) {
        n3(view.getTag());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T3(View view) {
        n3(view.getTag());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U3(View view) {
        n3(view.getTag());
    }

    public static void n4(String str, Context context) {
        new sd3(context).k(str.replace("\"", "")).O(R.string.alert_dialog_ok).f(null).e().show();
    }

    public static void q4(Context context) {
        new sd3(context).j(R.string.group_invite_has_been_send).O(R.string.alert_dialog_ok).f(null).e().show();
    }

    public final View A3() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_activity_chat_info_foot_view_new, (ViewGroup) null);
        this.S = viewInflate.findViewById(R.id.layout_circle_setting_note);
        this.V0 = (TextView) viewInflate.findViewById(R.id.circle_setting_note_content);
        this.Z0 = (TextView) viewInflate.findViewById(R.id.circle_note_auditing_status);
        this.U = viewInflate.findViewById(R.id.group_remark);
        if (oc0.f()) {
            i4(viewInflate.findViewById(R.id.show_member_nick_area), 8);
        }
        if (F3()) {
            i4(viewInflate.findViewById(R.id.group_name_area), 0);
            i4(this.U, 0);
            i4(this.S, 0);
            f4(this.S, new View.OnClickListener() { // from class: z20
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatInfoActivity.P3(view);
                }
            });
        } else {
            i4(viewInflate.findViewById(R.id.group_name_area), 8);
            i4(this.S, 8);
            i4(this.U, 8);
        }
        this.n0 = (ViewGroup) viewInflate.findViewById(R.id.group_chat_member_count);
        this.o0 = (TextView) viewInflate.findViewById(R.id.group_chat_member_count_tv);
        f4(this.n0, new n());
        this.J = viewInflate.findViewById(R.id.group_cate_area);
        this.K = (TextView) viewInflate.findViewById(R.id.group_type_tv);
        this.L = viewInflate.findViewById(R.id.group_type_icon);
        f4(this.J, new o());
        f4(this.U, new p());
        u4();
        this.E = viewInflate.findViewById(R.id.group_qrcode);
        this.F = viewInflate.findViewById(R.id.group_l1);
        this.G = viewInflate.findViewById(R.id.no_disturb_area);
        this.h0 = viewInflate.findViewById(R.id.quit_group_btn);
        this.i0 = viewInflate.findViewById(R.id.delete_chat_message);
        this.k0 = viewInflate.findViewById(R.id.report_group);
        this.M = viewInflate.findViewById(R.id.group_member_nick_name_area);
        this.e0 = (TextView) viewInflate.findViewById(R.id.group_member_nick_name);
        this.f0 = viewInflate.findViewById(R.id.show_member_nick_area);
        if (this.q == 1) {
            r3(viewInflate);
            i4(this.k0, 0);
            i4(this.E, 0);
            f4(this.E, new q());
            GroupInfoItem groupInfoItem = this.x;
            if (groupInfoItem != null && groupInfoItem.getGroupExtTypeFromExtension() == 1) {
                i4(this.E, 8);
                if (this.J.getVisibility() == 8) {
                    i4(this.F, 8);
                    i4(viewInflate.findViewById(R.id.groupInfoDesTv), 8);
                }
            }
            i4(this.M, 0);
            f4(this.M, new r());
            i4(this.h0, 0);
            f4(this.h0, new s());
        }
        f4(this.i0, new t());
        f4(this.k0, new u());
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.zhiding_checkbox);
        this.z = checkBox;
        e4(checkBox, new v());
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.id.miandaorao_checkbox);
        this.A = checkBox2;
        e4(checkBox2, new w());
        CheckBox checkBox3 = (CheckBox) viewInflate.findViewById(R.id.group_show_members_nick_name_checkbox);
        this.g0 = checkBox3;
        e4(checkBox3, new x());
        CheckBox checkBox4 = (CheckBox) viewInflate.findViewById(R.id.save_checkbox);
        this.B = checkBox4;
        e4(checkBox4, new y());
        View viewFindViewById = viewInflate.findViewById(R.id.single_chat_photo);
        this.l0 = viewFindViewById;
        f4(viewFindViewById, new z());
        return viewInflate;
    }

    public final View B3() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_activity_chat_info_foot_view, (ViewGroup) null);
        this.J = viewInflate.findViewById(R.id.group_cate_area);
        this.K = (TextView) viewInflate.findViewById(R.id.group_type_tv);
        this.L = viewInflate.findViewById(R.id.group_type_icon);
        if (oc0.f()) {
            i4(viewInflate.findViewById(R.id.show_member_nick_area), 8);
        }
        this.m0 = viewInflate.findViewById(R.id.ai_pay_layout);
        ContactInfoItem contactInfoItem = this.w;
        if (contactInfoItem != null && v8.C(contactInfoItem.getUid())) {
            i4(this.m0, 0);
            f4(this.m0, new c0());
        }
        f4(this.J, new d0());
        u4();
        this.H = (TextView) viewInflate.findViewById(R.id.group_name);
        this.C = viewInflate.findViewById(R.id.group_name_area);
        this.E = viewInflate.findViewById(R.id.group_qrcode);
        this.F = viewInflate.findViewById(R.id.group_l1);
        this.G = viewInflate.findViewById(R.id.no_disturb_area);
        this.h0 = viewInflate.findViewById(R.id.quit_group_btn);
        this.i0 = viewInflate.findViewById(R.id.delete_chat_message);
        this.j0 = viewInflate.findViewById(R.id.report_chat);
        this.k0 = viewInflate.findViewById(R.id.report_group);
        this.M = viewInflate.findViewById(R.id.group_member_nick_name_area);
        this.e0 = (TextView) viewInflate.findViewById(R.id.group_member_nick_name);
        this.f0 = viewInflate.findViewById(R.id.show_member_nick_area);
        this.n0 = (ViewGroup) viewInflate.findViewById(R.id.group_chat_member_count);
        this.o0 = (TextView) viewInflate.findViewById(R.id.group_chat_member_count_tv);
        if (this.q == 1) {
            i4(this.k0, 0);
            i4(this.j0, 8);
            i4(viewInflate.findViewById(R.id.divider0), 0);
            i4(this.n0, 0);
            f4(this.n0, new e0());
            i4(viewInflate.findViewById(R.id.group_member_count_area), 8);
            i4(this.C, 0);
            f4(this.C, new f0());
            i4(this.E, 0);
            GroupInfoItem groupInfoItem = this.x;
            if (groupInfoItem != null && groupInfoItem.getGroupExtTypeFromExtension() == 1) {
                i4(this.E, 8);
            }
            f4(this.E, new h0());
            i4(viewInflate.findViewById(R.id.divider2), 0);
            i4(viewInflate.findViewById(R.id.divider3), 0);
            i4(viewInflate.findViewById(R.id.divider3_top), 0);
            i4(viewInflate.findViewById(R.id.divider3_bottom), 0);
            i4(this.M, 0);
            f4(this.M, new i0());
            i4(this.h0, 0);
            f4(this.h0, new j0());
        } else {
            i4(this.k0, 8);
            i4(this.j0, 0);
            i4(viewInflate.findViewById(R.id.divider0), 8);
            i4(this.n0, 8);
            i4(viewInflate.findViewById(R.id.group_member_count_area), 8);
            i4(this.C, 8);
            i4(this.E, 8);
            i4(this.h0, 8);
            i4(this.F, 8);
            i4(viewInflate.findViewById(R.id.top_gap_gl), 0);
            i4(viewInflate.findViewById(R.id.divider1), 8);
            i4(viewInflate.findViewById(R.id.divider3), 8);
            i4(viewInflate.findViewById(R.id.divider3_top), 8);
            i4(viewInflate.findViewById(R.id.divider3_bottom), 8);
            i4(viewInflate.findViewById(R.id.divider4), 8);
            i4(viewInflate.findViewById(R.id.save_group_contact_container), 8);
            i4(this.M, 8);
            i4(this.f0, 8);
            ContactInfoItem contactInfoItem2 = this.w;
            if (contactInfoItem2 != null && contactInfoItem2.getUid() != null && this.w.getUid().equals(AccountUtils.p(AppContext.getContext()))) {
                i4(this.G, 8);
            }
        }
        f4(this.i0, new k0());
        f4(this.j0, new l0());
        f4(this.k0, new m0());
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.zhiding_checkbox);
        this.z = checkBox;
        e4(checkBox, new n0());
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.id.miandaorao_checkbox);
        this.A = checkBox2;
        e4(checkBox2, new o0());
        CheckBox checkBox3 = (CheckBox) viewInflate.findViewById(R.id.group_show_members_nick_name_checkbox);
        this.g0 = checkBox3;
        e4(checkBox3, new p0());
        CheckBox checkBox4 = (CheckBox) viewInflate.findViewById(R.id.save_checkbox);
        this.B = checkBox4;
        e4(checkBox4, new q0());
        View viewFindViewById = viewInflate.findViewById(R.id.single_chat_photo);
        this.l0 = viewFindViewById;
        f4(viewFindViewById, new t0());
        return viewInflate;
    }

    public final void C3(int i2) {
        String string = getResources().getString(R.string.chat_info);
        if (this.q == 1) {
            string = getResources().getString(R.string.chat_info_with_number, Integer.valueOf(i2));
            this.Y = (FrameLayout) this.r.findViewById(R.id.fl_notice);
            if (f3()) {
                i4(this.Y, 0);
                this.Z = (TextView) this.r.findViewById(R.id.tv_notice_number);
                f4(this.Y, new l1());
                if (!this.X0) {
                    a4();
                }
            }
        }
        TextView textView = (TextView) this.r.findViewById(R.id.title);
        if (textView != null) {
            textView.setText(string);
        }
    }

    public final void D3() {
        this.r = initToolbar(-1);
        C3(0);
        setSupportActionBar(this.r);
    }

    public final void E3() {
        this.u = (ListView) findViewById(R.id.list);
        View viewT3 = t3();
        this.s = viewT3;
        this.u.addFooterView(viewT3);
        if (H3()) {
            View viewU3 = u3();
            this.t = viewU3;
            this.u.addHeaderView(viewU3);
        }
        com.zenmen.palmchat.groupchat.a aVar = new com.zenmen.palmchat.groupchat.a(this, this.q, this.x, this, H3());
        this.v = aVar;
        aVar.f(x3(null));
        this.u.setAdapter((ListAdapter) this.v);
        ImageView imageView = (ImageView) findViewById(R.id.image_share);
        if (this.q == 1) {
            imageView.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: d30
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f16966a.Q3(view);
                }
            });
        }
        v3();
    }

    public final boolean F3() {
        GroupInfoItem groupInfoItem = this.x;
        boolean z2 = groupInfoItem != null && (groupInfoItem.getRoomType() == 1 || this.x.getRoomType() == 2);
        if (this.x != null) {
            Log.d(x1, "isCircleFunctionOpen: roomType = " + this.x.getRoomType());
        }
        return oc0.f() && z2;
    }

    public final boolean G3() {
        return this.x.getRoleType() == 3;
    }

    public final boolean H3() {
        return this.q == 1;
    }

    public final boolean I3() {
        return false;
    }

    public final void J3(ArrayList<String> arrayList, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        l03 l03Var = new l03(this.u0, this.t0);
        this.O0 = l03Var;
        try {
            l03Var.n(arrayList, this.x.getGroupId(), i2);
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
            hideBaseProgressBar();
        }
    }

    public final void V3(Intent intent) {
        this.q = intent.getIntExtra("chat_type", 0);
        Parcelable parcelableExtra = intent.getParcelableExtra("info_item");
        if (parcelableExtra instanceof ContactInfoItem) {
            this.w = (ContactInfoItem) intent.getParcelableExtra("info_item");
        } else if (parcelableExtra instanceof GroupInfoItem) {
            this.x = (GroupInfoItem) intent.getParcelableExtra("info_item");
        }
        updateCurrentPageInfo(this, new q1());
    }

    public void W3(ArrayList<ContactInfoItem> arrayList) {
        com.zenmen.palmchat.groupchat.a aVar = this.v;
        if (aVar != null) {
            aVar.f(arrayList);
        }
        if (this.q == 1) {
            C3(this.p1);
            TextView textView = this.o0;
            if (textView != null) {
                textView.setText(getString(R.string.hotchat_member_count, Integer.valueOf(this.p1)));
            }
            TextView textView2 = this.U0;
            if (textView2 != null) {
                textView2.setText(getString(R.string.circlechat_member_count, Integer.valueOf(this.p1)));
            }
            TextView textView3 = this.l1;
            if (textView3 != null) {
                textView3.setText(getString(R.string.hotchat_member_count, Integer.valueOf(this.p1)));
            }
            v4();
        }
        hideBaseProgressBar();
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: X3, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (loader.getId() == 1 && cursor != null) {
            x4(cursor);
            return;
        }
        if (loader.getId() != 2 || cursor == null || !cursor.moveToNext()) {
            if (loader.getId() == 3 && cursor != null && cursor.moveToNext()) {
                this.w1 = true;
                z4(cursor.getInt(cursor.getColumnIndex("thread_priority")) == 100);
                t4(cursor.getInt(cursor.getColumnIndex("thread_nodisturb")) == 1);
                y4(cursor.getInt(cursor.getColumnIndex("thread_show_members_nick_name")) == 1);
                this.v1 = cursor.getInt(cursor.getColumnIndex("thread_blacklist")) > 0;
                this.w1 = false;
                return;
            }
            return;
        }
        this.x.setGroupId(cursor.getString(cursor.getColumnIndex("group_id")));
        this.x.setGroupOwner(cursor.getString(cursor.getColumnIndex("owner")));
        this.x.setGroupName(cursor.getString(cursor.getColumnIndex("name")));
        this.x.setGroupLocalName(cursor.getString(cursor.getColumnIndex("local_name")));
        this.x.setGroupHeadImgUrl(cursor.getString(cursor.getColumnIndex("headImgUrl")));
        int i2 = cursor.getInt(cursor.getColumnIndex("type"));
        this.x.setGroupType(i2);
        String string = cursor.getString(cursor.getColumnIndex("group_extra_info"));
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                this.x.setRoomType(jSONObject.optInt("roomType", 0));
                this.x.setCover(jSONObject.optString("cover", ""));
                this.x.setRecmdSwitch(jSONObject.optInt("recmdSwitch", 1));
                if (jSONObject.has("addFriendSwitch")) {
                    this.x.setAddFriendSwitch(jSONObject.optInt("addFriendSwitch", 1));
                } else {
                    this.x.setAddFriendSwitch(1);
                }
                this.x.setAccessSwitch(jSONObject.optInt("accessSwitch", 1));
                this.x.setDiffuse(jSONObject.optInt("diffuse", 0));
                this.x.setApplyStatus(jSONObject.optInt("applyStatus", 0));
                this.x.setRoleType(jSONObject.optInt("roleType", 3));
                this.x.setPlace(jSONObject.optString("place", ""));
                this.x.setRnumber(jSONObject.optString("rnumber", ""));
                this.x.setCateName(jSONObject.optString("cateName", ""));
                this.x.setDescribe(jSONObject.optString("describe", ""));
                this.x.setRemarkName(jSONObject.optString("remarkName", ""));
                this.x.setAddType(jSONObject.optInt("addType", ye2.f22183a));
                this.x.setInviteSwitch(jSONObject.optInt("inviteSwitch", ye2.b));
                this.x.setInviteCheckSwitch(jSONObject.optInt("inviteCheckSwitch", ye2.c));
                this.x.setWelContent(jSONObject.optString(" welContent", ""));
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tagNames");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    String[] strArr = new String[jSONArrayOptJSONArray.length()];
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                        strArr[i3] = jSONArrayOptJSONArray.optString(i3);
                    }
                    this.x.setTagNames(strArr);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("tags");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    String[] strArr2 = new String[jSONArrayOptJSONArray2.length()];
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i4);
                        if (jSONObject2 == null || !jSONObject2.has("tagName")) {
                            strArr2[i4] = "";
                        } else {
                            strArr2[i4] = jSONObject2.optString("tagName");
                        }
                    }
                    this.x.setTags(strArr2);
                }
                this.x.setCreateTimestamp(jSONObject.optLong("createTimestamp", 0L));
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("tools");
                if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() <= 0) {
                    this.x.setTools(null);
                } else {
                    DatingGroupToolBeans datingGroupToolBeans = new DatingGroupToolBeans();
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray3.length(); i5++) {
                        JSONObject jSONObject3 = jSONArrayOptJSONArray3.getJSONObject(i5);
                        DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean = new DatingGroupToolBeans.DatingGroupToolBean();
                        String strOptString = jSONObject3.optString("id");
                        String strOptString2 = jSONObject3.optString("toolName");
                        String strOptString3 = jSONObject3.optString("icon");
                        String strOptString4 = jSONObject3.optString("toolPage");
                        int iOptInt = jSONObject3.optInt("isSystem", 0);
                        int iOptInt2 = jSONObject3.optInt("systemToolClass", 0);
                        datingGroupToolBean.setId(strOptString);
                        datingGroupToolBean.setToolName(strOptString2);
                        datingGroupToolBean.setIcon(strOptString3);
                        datingGroupToolBean.setToolPage(strOptString4);
                        datingGroupToolBean.setIsSystem(iOptInt);
                        datingGroupToolBean.setSystemToolClass(iOptInt2);
                        datingGroupToolBeans.addToolsBean(datingGroupToolBean);
                    }
                    this.x.setTools(datingGroupToolBeans);
                }
            } catch (Exception unused) {
            }
        }
        this.x.setGroupExInfo(string);
        c4(this.B, i2 == 1);
        w4();
        u4();
        s4();
    }

    public final void Y3() {
        this.H0 = false;
        this.v.g(false);
        this.v.notifyDataSetChanged();
    }

    public final void Z3() {
        GroupInfoItem groupInfoItem = this.x;
        if (groupInfoItem != null && groupInfoItem.getGroupExtTypeFromExtension() == 1) {
            LogUtil.uploadInfoImmediate("qhb807", new a0());
        }
        vq4 vq4Var = new vq4(this.y0, this.x0);
        this.J0 = vq4Var;
        try {
            vq4Var.n(this.x.getGroupId());
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
            hideBaseProgressBar();
        }
    }

    public final void a4() {
        if (hx3.m(this)) {
            this.X0 = true;
            c70.R().k(this.x.getGroupId(), new b0());
        }
    }

    public final void b4(View view, int i2) {
        if (view != null) {
            view.setBackgroundResource(i2);
        }
    }

    public final void c4(CompoundButton compoundButton, boolean z2) {
        if (compoundButton != null) {
            compoundButton.setChecked(z2);
        }
    }

    public final void d3() {
        String nickName = null;
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_dialog_change_group_nickname, (ViewGroup) null);
        EditText editText = (EditText) viewInflate.findViewById(R.id.edit_text);
        d4(editText, 32);
        ContactInfoItem contactInfoItem = this.y;
        if (contactInfoItem == null || TextUtils.isEmpty(contactInfoItem.getGroupRemarkName())) {
            ContactInfoItem contactInfoItem2 = this.y;
            if (contactInfoItem2 != null && !TextUtils.isEmpty(contactInfoItem2.getNickName())) {
                nickName = this.y.getNickName();
            }
        } else {
            nickName = this.y.getGroupRemarkName();
        }
        if (!TextUtils.isEmpty(nickName)) {
            editText.setText(nickName);
            editText.setSelection(editText.getText().length());
        }
        editText.requestFocus();
        new sd3(this).T(R.string.group_member_nick_name).p(viewInflate, false).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new u0(editText)).e().show();
        KeyboardKt.a(editText, this, Keyboard$SHOW_FLAG.IMPLICIT, 0L);
    }

    public final void d4(EditText editText, int i2) {
        editText.addTextChangedListener(new v0(editText, i2));
    }

    public final void e3(int i2, String str, int i3) {
        if (i2 == 0) {
            i65 i65Var = new i65(this.C0, this.B0);
            this.M0 = i65Var;
            try {
                i65Var.n(str, i3);
                showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
                return;
            } catch (DaoException e2) {
                e2.printStackTrace();
                hideBaseProgressBar();
                return;
            }
        }
        k65 k65Var = new k65(this.C0, this.B0);
        this.N0 = k65Var;
        try {
            k65Var.n(str, i3);
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e3) {
            e3.printStackTrace();
            hideBaseProgressBar();
        }
    }

    public final void e4(CompoundButton compoundButton, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (compoundButton != null) {
            compoundButton.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public final boolean f3() {
        GroupInfoItem groupInfoItem = this.x;
        if (groupInfoItem != null) {
            return groupInfoItem.getRoleType() == 1 || this.x.getRoleType() == 2;
        }
        return false;
    }

    public final void f4(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public final void g3(ArrayList<ContactInfoItem> arrayList, String str) {
        qa0.i().n(this, new t1(arrayList, str));
    }

    public final void g4(TextView textView, int i2) {
        if (textView != null) {
            textView.setText(i2);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 116;
    }

    public final void h3() {
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        new u1().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void h4(TextView textView, CharSequence charSequence) {
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void i3(ArrayList<ContactInfoItem> arrayList, String str) {
        if ((this.x.getRoomType() == 1 || this.x.getRoomType() == 2) && this.x.getApplyStatus() == 1 && G3()) {
            g3(arrayList, str);
        } else {
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            new r1(arrayList, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public final void i4(View view, int i2) {
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public final String j3() {
        GroupInfoItem groupInfoItem;
        int i2 = this.q;
        if (i2 == 0) {
            ContactInfoItem contactInfoItem = this.w;
            if (contactInfoItem != null) {
                return contactInfoItem.getChatId();
            }
        } else if (i2 == 1 && (groupInfoItem = this.x) != null) {
            return groupInfoItem.getChatId();
        }
        return "";
    }

    public final void j4() {
        MessageVo threadBizType = MessageVo.buildNameCardMessage(xn3.a(), (String) null, this.x, 0, ir5.b()).setThreadBizType(this, 1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(threadBizType);
        Intent intent = new Intent(this, (Class<?>) SendMessageActivity.class);
        intent.putExtra("message_vo_list", arrayList);
        intent.putExtra("extra_from", 2);
        intent.putExtra("extra_is_show_group", false);
        intent.addFlags(268435456);
        startActivity(intent);
        HashMap map = new HashMap();
        map.put("fromtype", 1);
        GroupInfoItem groupInfoItem = this.x;
        map.put("rid", groupInfoItem == null ? "" : groupInfoItem.getGroupId());
        oc0.h("lx_group_profile_share_click1_type", map);
    }

    public final String k3(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(bo0.r().l(strArr[i2]).getNameForShow());
                if (i2 != length - 1) {
                    sb.append(getString(R.string.name_divider));
                }
            }
        }
        return sb.toString();
    }

    public final void k4(ArrayList<ContactInfoItem> arrayList, String[] strArr) {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_dialog_add_friend_content, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.count);
        EditText editText = (EditText) viewInflate.findViewById(R.id.edit_text);
        editText.addTextChangedListener(new w1(editText, textView));
        new sd3(this).p(viewInflate, false).T(R.string.string_add_friend_title).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new y1(strArr, arrayList, editText)).e().show();
    }

    public final String l3() {
        GroupInfoItem groupInfoItem = this.x;
        String strOptString = null;
        if (groupInfoItem == null) {
            return null;
        }
        String groupExInfo = groupInfoItem.getGroupExInfo();
        if (TextUtils.isEmpty(groupExInfo)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupExInfo);
            String strOptString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.x.cw);
            strOptString = jSONObject.optString("cateName");
            this.b1 = strOptString2;
            this.a1 = strOptString;
            return strOptString;
        } catch (Exception e2) {
            e2.printStackTrace();
            return strOptString;
        }
    }

    public final void l4() {
        new sd3(this).k(getString(R.string.group_max_dialog_text)).O(R.string.alert_dialog_ok).Q();
    }

    public final void m3() {
        if (l50.a()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            GroupInfoItem groupInfoItem = this.x;
            if (groupInfoItem != null) {
                jSONObject.put("rid", groupInfoItem.getGroupId());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String string = jSONObject.toString();
        z1 z1Var = new z1(string);
        a2 a2Var = new a2(string);
        showBaseProgressBar();
        HashMap map = new HashMap();
        GroupInfoItem groupInfoItem2 = this.x;
        if (groupInfoItem2 != null) {
            map.put("roomId", groupInfoItem2.getGroupId());
        }
        try {
            new j92(z1Var, a2Var, map).n();
        } catch (DaoException e3) {
            e3.printStackTrace();
        }
    }

    public final void m4(ArrayList<ContactInfoItem> arrayList, String[] strArr) {
        new sd3(this).T(R.string.string_add_member_failed_title).k(getString(R.string.string_add_member_failed_content, k3(strArr))).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new v1(arrayList, strArr)).e().show();
    }

    public final void n3(Object obj) {
        if (obj instanceof DatingGroupToolBeans.DatingGroupToolBean) {
            DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean = (DatingGroupToolBeans.DatingGroupToolBean) obj;
            if (datingGroupToolBean.getIsSystem() != 0) {
                if (datingGroupToolBean.getIsSystem() == 1) {
                    Toast.makeText(this, "暂不支持的群工具", 0).show();
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.setClass(this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", datingGroupToolBean.getToolPage());
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    public final void o3() {
        Intent intent = new Intent(this, (Class<?>) GroupChatInitActivity.class);
        ArrayList<ContactInfoItem> arrayList = this.q1;
        if (arrayList != null && arrayList.size() == 1) {
            intent.putParcelableArrayListExtra("init_members", this.q1);
        }
        intent.putExtra("group_info_item", this.x);
        intent.putExtra("group_choose_contact", true);
        startActivityForResult(intent, 1);
    }

    public final void o4() {
        sy5.e(this, R.string.send_failed, 0).g();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1) {
            if (intent != null) {
                this.Q0 = intent.getParcelableArrayListExtra("add_group_member_result");
                this.R0 = intent.getStringExtra("add_group_member_id_result");
                ArrayList<ContactInfoItem> arrayList = this.Q0;
                if (arrayList != null && arrayList.size() > 0) {
                    i3(this.Q0, this.R0);
                    return;
                } else {
                    if (intent.getBooleanExtra("add_group_member_beyoud_result", false)) {
                        l4();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (i2 == 2 && i3 == -1 && this.q == 0) {
            setResult(-1);
            finish();
            return;
        }
        if (i2 == 3 && i3 == -1) {
            if (intent != null) {
                if (!intent.getBooleanExtra("groupMemberAdd", false)) {
                    J3(intent.getStringArrayListExtra("delete_list"), intent.getIntExtra("delete_type", 0));
                    return;
                }
                this.Q0 = intent.getParcelableArrayListExtra("add_group_member_result");
                this.R0 = intent.getStringExtra("add_group_member_id_result");
                ArrayList<ContactInfoItem> arrayList2 = this.Q0;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    i3(this.Q0, this.R0);
                    return;
                } else {
                    if (intent.getBooleanExtra("add_group_member_beyoud_result", false)) {
                        l4();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (i2 == 7 && i3 == -1) {
            String stringExtra = intent.getStringExtra("media_pick_photo_key");
            if (k86.I(stringExtra)) {
                this.p0 = stringExtra;
                return;
            }
            return;
        }
        if (i2 == 4 && i3 == -1) {
            if (intent == null || (stringArrayListExtra = intent.getStringArrayListExtra("delete_list")) == null || stringArrayListExtra.size() <= 0) {
                return;
            }
            w3();
            return;
        }
        if (i2 == 10 && intent != null) {
            String stringExtra2 = intent.getStringExtra("key_group_remark");
            this.Y0 = stringExtra2;
            this.x.setRemarkName(stringExtra2);
            return;
        }
        if (i2 == 12 && i3 == -1) {
            GroupInfoItem groupInfoItem = (GroupInfoItem) intent.getParcelableExtra("key_group_info");
            if (groupInfoItem != null) {
                this.x.setAddType(groupInfoItem.getAddType());
                this.x.setInviteSwitch(groupInfoItem.getInviteSwitch());
                this.x.setInviteCheckSwitch(groupInfoItem.getInviteCheckSwitch());
                this.x.setRecmdSwitch(groupInfoItem.getRecmdSwitch());
                return;
            }
            return;
        }
        if (i2 == 100) {
            i4(this.Z, 8);
            return;
        }
        if (i2 == 987 && i3 == -1 && intent != null) {
            String stringExtra3 = intent.getStringExtra("circleName");
            GroupInfoItem groupInfoItem2 = this.x;
            if (groupInfoItem2 != null) {
                groupInfoItem2.setGroupName(stringExtra3);
                w4();
            }
        }
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        runOnUiThread(new w0());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        V3(getIntent());
        setContentView(R.layout.layout_activity_chat_info);
        D3();
        E3();
        w4();
        UI.c(this, 3, null, this);
        w3();
        bo0.r().i().j(this);
        this.d1 = new k80(this.x);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0078  */
    @Override // defpackage.pm2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        GroupInfoItem groupInfoItem;
        String chatId;
        GroupInfoItem groupInfoItem2;
        GroupInfoItem groupInfoItem3;
        if (i2 == 1 && (groupInfoItem3 = this.x) != null && !TextUtils.isEmpty(groupInfoItem3.getGroupId())) {
            return new CursorLoader(this, je2.f18392a, null, "group_id=? and group_member_state=?", new String[]{this.x.getGroupId(), Integer.toString(0)}, null);
        }
        if (i2 == 2 && (groupInfoItem2 = this.x) != null && !TextUtils.isEmpty(groupInfoItem2.getGroupId())) {
            return new CursorLoader(this, DBUriManager.b(ye2.class, this.x), null, "group_id=?", new String[]{this.x.getGroupId()}, null);
        }
        if (i2 != 3) {
            return null;
        }
        int i3 = this.q;
        if (i3 == 0) {
            ContactInfoItem contactInfoItem = this.w;
            chatId = contactInfoItem != null ? DomainHelper.l(contactInfoItem) : "";
        } else if (i3 == 1 && (groupInfoItem = this.x) != null) {
            chatId = groupInfoItem.getChatId();
        }
        return new CursorLoader(this, dx5.f17178a, null, "contact_relate=?", new String[]{chatId}, null);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        hideBaseProgressBar();
        b56 b56Var = this.I0;
        if (b56Var != null) {
            b56Var.onCancel();
        }
        vq4 vq4Var = this.J0;
        if (vq4Var != null) {
            vq4Var.onCancel();
        }
        f25 f25Var = this.K0;
        if (f25Var != null) {
            f25Var.onCancel();
        }
        l65 l65Var = this.L0;
        if (l65Var != null) {
            l65Var.onCancel();
        }
        i65 i65Var = this.M0;
        if (i65Var != null) {
            i65Var.onCancel();
        }
        k65 k65Var = this.N0;
        if (k65Var != null) {
            k65Var.onCancel();
        }
        l03 l03Var = this.O0;
        if (l03Var != null) {
            l03Var.onCancel();
        }
        ih ihVar = this.P0;
        if (ihVar != null) {
            ihVar.onCancel();
        }
        bo0.r().i().l(this);
        getSupportLoaderManager().destroyLoader(1);
        getSupportLoaderManager().destroyLoader(2);
        getSupportLoaderManager().destroyLoader(3);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        UI.a(this);
    }

    public final void p3(boolean z2) {
        int i2;
        if (z2) {
            GroupInfoItem groupInfoItem = this.x;
            i2 = (groupInfoItem == null || groupInfoItem.getRoomType() == 0) ? 400 : 410;
        } else {
            i2 = 300;
        }
        CordovaWebActivity.u2(this, z2, i2, z2 ? this.x : this.w, z2 ? 6 : 1);
    }

    public final void p4() {
        new sd3(this).k(getString(R.string.group_invite_dialog_content_text)).K(R.string.alert_dialog_cancel).O(R.string.group_invite_text).f(new s1()).e().show();
    }

    public final void q3(ContactInfoItem contactInfoItem) {
        String nickName;
        Intent intent = new Intent(this, (Class<?>) m66.c());
        ContactInfoItem contactInfoItemM792clone = contactInfoItem.m792clone();
        if (this.q == 1) {
            intent.putExtra("group_id", this.x.getGroupId());
            intent.putExtra("group_chat_info", this.x);
            intent.putExtra("from", 6);
            ContactInfoItem contactInfoItem2 = this.y;
            if (contactInfoItem2 == null || TextUtils.isEmpty(contactInfoItem2.getGroupRemarkName())) {
                ContactInfoItem contactInfoItem3 = this.y;
                nickName = (contactInfoItem3 == null || TextUtils.isEmpty(contactInfoItem3.getNickName())) ? "" : this.y.getNickName();
            } else {
                nickName = this.y.getGroupRemarkName();
            }
            intent.putExtra("groupchat_name", this.x.getGroupNameDisplay(nickName));
            contactInfoItemM792clone.setGroupRemarkName(contactInfoItem.getGroupRemarkName());
        } else {
            intent.putExtra("from", 5);
        }
        intent.putExtra("user_item_info", contactInfoItemM792clone);
        startActivityForResult(intent, 2);
    }

    public final void r3(View view) {
        this.T = view.findViewById(R.id.layout_circle_app);
        this.V = view.findViewById(R.id.group_cate_privilage);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.circle_allow_see_history_checkbox);
        this.W = checkBox;
        e4(checkBox, new s0());
        f4(this.V, new m1());
        if (!F3()) {
            i4(this.T, 0);
            return;
        }
        i4(this.T, 0);
        GroupInfoItem groupInfoItem = this.x;
        if (groupInfoItem == null || !(groupInfoItem.getRoleType() == 1 || this.x.getRoleType() == 2)) {
            i4(this.V, 8);
        } else {
            i4(this.V, 0);
        }
    }

    public final void r4() {
        sy5.e(this, R.string.send_success, 0).g();
    }

    public final void s3(View view) {
        this.R = view.findViewById(R.id.layout_circle_settings_upgrade);
        this.N = view.findViewById(R.id.circle_name_area);
        this.Q = (SocialPortraitView) view.findViewById(R.id.circleIconIv);
        this.U0 = (TextView) view.findViewById(R.id.circle_group_mem_num);
        this.O = (TextView) view.findViewById(R.id.circle_name);
        this.P = (TextView) view.findViewById(R.id.circle_desc);
        if (I3()) {
            i4(this.R, 0);
            f4(this.R, new View.OnClickListener() { // from class: i30
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f18095a.K3(view2);
                }
            });
        } else {
            i4(this.R, 8);
        }
        f4(this.N, new r0());
    }

    public final void s4() {
        GroupInfoItem groupInfoItem;
        if (this.e1 == null) {
            return;
        }
        if (!oc0.f() || (groupInfoItem = this.x) == null || groupInfoItem.getRoomType() <= 0 || this.x.getGroupState() != 0) {
            this.e1.setVisibility(8);
            return;
        }
        if (this.x.getRoleType() < 3) {
            this.h1.setVisibility(0);
            this.e1.setVisibility(0);
            this.f1.setOnClickListener(new View.OnClickListener() { // from class: y20
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f22099a.R3(view);
                }
            });
        } else {
            this.h1.setVisibility(8);
            this.f1.setOnClickListener(null);
            this.e1.setVisibility(8);
        }
        DatingGroupToolBeans tools = this.x.getTools();
        this.g1.setVisibility(8);
        this.i1.setVisibility(4);
        this.j1.setVisibility(4);
        this.k1.setVisibility(4);
        this.i1.setTag(null);
        this.j1.setTag(null);
        this.k1.setTag(null);
        if (tools != null && tools.getToolBeans() != null && !tools.getToolBeans().isEmpty()) {
            this.e1.setVisibility(0);
            this.g1.setVisibility(0);
            List<DatingGroupToolBeans.DatingGroupToolBean> toolBeans = tools.getToolBeans();
            this.i1.setVisibility(0);
            this.i1.bindData(toolBeans.get(0));
            this.i1.setTag(toolBeans.get(0));
            if (toolBeans.size() > 1) {
                this.j1.setVisibility(0);
                this.j1.bindData(toolBeans.get(1));
                this.j1.setTag(toolBeans.get(1));
            }
            if (toolBeans.size() > 2) {
                this.k1.setVisibility(0);
                this.k1.bindData(toolBeans.get(2));
                this.k1.setTag(toolBeans.get(2));
            }
        }
        this.i1.setOnClickListener(new View.OnClickListener() { // from class: a30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1142a.S3(view);
            }
        });
        this.j1.setOnClickListener(new View.OnClickListener() { // from class: b30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1635a.T3(view);
            }
        });
        this.k1.setOnClickListener(new View.OnClickListener() { // from class: c30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1885a.U3(view);
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i2, @Nullable Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
        UI.a(this);
    }

    public final View t3() {
        return this.q == 1 ? y3() : y3();
    }

    public final void t4(boolean z2) {
        c4(this.A, z2);
        this.t1 = z2;
    }

    public final View u3() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_activity_chat_info_head_vew, (ViewGroup) null);
        this.C = viewInflate.findViewById(R.id.group_name_area);
        this.l1 = (TextView) viewInflate.findViewById(R.id.group_chat_member_count_tv);
        s3(viewInflate);
        SocialPortraitView socialPortraitView = (SocialPortraitView) viewInflate.findViewById(R.id.groupIconIv);
        this.I = socialPortraitView;
        socialPortraitView.changeShapeType(3);
        this.I.setDegreeForRoundRectangle(24, 24);
        this.H = (TextView) viewInflate.findViewById(R.id.group_name);
        f4(this.C, new l());
        if (F3()) {
            i4(this.C, 8);
            i4(this.N, 0);
        } else {
            i4(this.C, 0);
            i4(this.N, 8);
        }
        f4((RelativeLayout) viewInflate.findViewById(R.id.group_chat_member_count), new g0());
        return viewInflate;
    }

    public final void u4() {
        GroupInfoItem groupInfoItem = this.x;
        if (groupInfoItem == null || this.J == null) {
            return;
        }
        if (!(groupInfoItem.getGroupOwner() != null && this.x.getGroupOwner().equals(AccountUtils.p(this)))) {
            i4(this.J, 8);
            return;
        }
        String strL3 = l3();
        if (TextUtils.isEmpty(strL3)) {
            i4(this.K, 8);
            i4(this.L, 0);
        } else {
            i4(this.K, 0);
            h4(this.K, strL3);
            i4(this.L, 8);
        }
    }

    public final void v3() {
        this.t0 = new x0();
        this.u0 = new y0();
        this.v0 = new z0();
        this.w0 = new a1();
        this.D0 = new b1();
        this.E0 = new c1();
        this.z0 = new d1();
        this.A0 = new e1();
        this.x0 = new f1();
        this.y0 = new g1();
        this.B0 = new h1();
        this.C0 = new i1();
        this.F0 = new j1();
        this.G0 = new k1();
    }

    public final void v4() {
        ContactInfoItem contactInfoItem = this.y;
        if (contactInfoItem != null && !TextUtils.isEmpty(contactInfoItem.getGroupRemarkName())) {
            h4(this.e0, this.y.getGroupRemarkName());
            return;
        }
        ContactInfoItem contactInfoItem2 = this.y;
        if (contactInfoItem2 == null || TextUtils.isEmpty(contactInfoItem2.getNickName())) {
            g4(this.e0, R.string.group_member_nick_name);
        } else {
            h4(this.e0, this.y.getNickName());
        }
    }

    public final void w3() {
        if (this.q == 1) {
            showBaseProgressBar(AppContext.getContext().getString(R.string.reading_data), false);
            UI.c(this, 2, null, this);
            UI.c(this, 1, null, this);
            cb0.c().e(this.x.getGroupId(), 1, 10, new k());
        }
    }

    public final void w4() {
        GroupInfoItem groupInfoItem = this.x;
        if (groupInfoItem != null) {
            if (TextUtils.isEmpty(groupInfoItem.getGroupName())) {
                h4(this.H, this.x.getGroupLocalName());
                TextView textView = this.W0;
                if (textView != null) {
                    textView.setText(this.x.getGroupLocalName());
                }
                TextView textView2 = this.c1;
                if (textView2 != null) {
                    textView2.setText(this.x.getRemarkName());
                }
                h4(this.O, this.x.getGroupLocalName());
            } else {
                h4(this.H, this.x.getGroupName());
                TextView textView3 = this.W0;
                if (textView3 != null) {
                    textView3.setText(this.x.getGroupName());
                }
                TextView textView4 = this.c1;
                if (textView4 != null) {
                    textView4.setText(this.x.getRemarkName());
                }
                h4(this.O, this.x.getGroupName());
            }
            if (!TextUtils.isEmpty(this.x.getDescribe())) {
                h4(this.P, this.x.getDescribe());
            } else if (this.x.getRoleType() == 3) {
                h4(this.P, "群主很懒，还没有填写群介绍~");
            } else {
                h4(this.P, "介绍一下，让更多人了解群~");
            }
            if (this.I != null) {
                gr2.j().h(this.x.getGroupHeadImgUrl(), this.I, bq6.s());
                if (this.Q != null) {
                    gr2.j().h(this.x.getGroupHeadImgUrl(), this.Q, bq6.s());
                }
            }
        }
    }

    public final ArrayList<ContactInfoItem> x3(Cursor cursor) {
        int i2;
        ArrayList<ContactInfoItem> arrayList = new ArrayList<>();
        int i3 = this.q;
        if (i3 == 0) {
            ContactInfoItem contactInfoItem = this.w;
            if (contactInfoItem != null) {
                arrayList.add(contactInfoItem);
                this.q1.clear();
                this.q1.add(this.w);
            }
        } else if (i3 == 1 && cursor != null) {
            this.p1 = cursor.getCount();
            try {
                this.q1.clear();
                cursor.moveToPosition(-1);
                while (true) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    ContactInfoItem contactInfoItemA = ie2.a(cursor);
                    if (contactInfoItemA.getIsGroupOwner() == 1) {
                        this.q1.add(0, contactInfoItemA);
                    } else {
                        this.q1.add(contactInfoItemA);
                    }
                    if (contactInfoItemA.getUid().equals(AccountUtils.p(AppContext.getContext()))) {
                        this.y = contactInfoItemA;
                    }
                }
                int iMin = this.x.getGroupOwner().equals(AccountUtils.p(AppContext.getContext())) ? 38 : 39;
                if (F3()) {
                    int i4 = 3;
                    if (this.x.getRoleType() == 3) {
                        i4 = this.x.getInviteSwitch() == 0 ? 5 : 4;
                    }
                    iMin = Math.min(iMin, i4);
                }
                Collections.sort(this.q1, new o1());
                for (i2 = 0; i2 < iMin; i2++) {
                    if (i2 >= this.q1.size()) {
                        break;
                    }
                    arrayList.add(this.q1.get(i2));
                }
            } catch (Exception e2) {
                LogUtil.e(x1, e2);
            }
        }
        return arrayList;
    }

    public final void x4(Cursor cursor) {
        new n1(cursor).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final View y3() {
        return H3() ? F3() ? z3() : A3() : B3();
    }

    public final void y4(boolean z2) {
        c4(this.g0, z2);
        this.u1 = z2;
    }

    @Override // com.zenmen.palmchat.groupchat.a.d
    public void z(a.c cVar) {
        int iB = cVar.b();
        ContactInfoItem contactInfoItemA = cVar.a();
        if (this.H0) {
            if (iB != 0) {
                Y3();
                return;
            } else {
                if (AccountUtils.p(AppContext.getContext()).equals(contactInfoItemA.getUid())) {
                    return;
                }
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(contactInfoItemA.getUid());
                J3(arrayList, 0);
                return;
            }
        }
        if (iB == 0) {
            q3(contactInfoItemA);
            return;
        }
        if (iB == 1) {
            o3();
            return;
        }
        if (iB == 2) {
            Intent intent = new Intent();
            intent.setClass(this, GroupMemberListActivity.class);
            intent.putExtra("type_add", false);
            intent.putExtra("groupitem", this.x);
            startActivityForResult(intent, 3);
        }
    }

    public final View z3() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_activity_chat_info_foot_view_new, (ViewGroup) null);
        this.S = viewInflate.findViewById(R.id.layout_circle_setting_note);
        this.V0 = (TextView) viewInflate.findViewById(R.id.circle_setting_note_content);
        this.Z0 = (TextView) viewInflate.findViewById(R.id.circle_note_auditing_status);
        this.U = viewInflate.findViewById(R.id.group_remark);
        this.c1 = (TextView) viewInflate.findViewById(R.id.circle_remark_name);
        this.W0 = (TextView) viewInflate.findViewById(R.id.group_name);
        i4(this.S, 0);
        if (oc0.f()) {
            i4(viewInflate.findViewById(R.id.show_member_nick_area), 8);
        }
        f4(this.S, new View.OnClickListener() { // from class: e30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatInfoActivity.L3(view);
            }
        });
        f4(this.U, new x1());
        this.n0 = (ViewGroup) viewInflate.findViewById(R.id.group_chat_member_count);
        this.o0 = (TextView) viewInflate.findViewById(R.id.group_chat_member_count_tv);
        f4(this.n0, new b2());
        this.J = viewInflate.findViewById(R.id.group_cate_area);
        this.K = (TextView) viewInflate.findViewById(R.id.group_type_tv);
        this.L = viewInflate.findViewById(R.id.group_type_icon);
        f4(this.J, new c2());
        u4();
        View viewFindViewById = viewInflate.findViewById(R.id.group_info);
        this.E = viewInflate.findViewById(R.id.group_qrcode);
        this.F = viewInflate.findViewById(R.id.group_l1);
        this.G = viewInflate.findViewById(R.id.no_disturb_area);
        this.h0 = viewInflate.findViewById(R.id.quit_group_btn);
        this.i0 = viewInflate.findViewById(R.id.delete_chat_message);
        this.k0 = viewInflate.findViewById(R.id.report_group);
        this.M = viewInflate.findViewById(R.id.group_member_nick_name_area);
        this.e0 = (TextView) viewInflate.findViewById(R.id.group_member_nick_name);
        this.f0 = viewInflate.findViewById(R.id.show_member_nick_area);
        i4(viewFindViewById, 8);
        if (this.q == 1) {
            r3(viewInflate);
            i4(this.k0, 0);
            f4(this.E, new a());
            i4(this.M, 0);
            f4(this.M, new b());
            i4(this.h0, 0);
            f4(this.h0, new c());
        }
        f4(this.i0, new d());
        f4(this.k0, new e());
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.zhiding_checkbox);
        this.z = checkBox;
        e4(checkBox, new f());
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.id.miandaorao_checkbox);
        this.A = checkBox2;
        e4(checkBox2, new g());
        CheckBox checkBox3 = (CheckBox) viewInflate.findViewById(R.id.group_show_members_nick_name_checkbox);
        this.g0 = checkBox3;
        e4(checkBox3, new h());
        CheckBox checkBox4 = (CheckBox) viewInflate.findViewById(R.id.save_checkbox);
        this.B = checkBox4;
        e4(checkBox4, new i());
        View viewFindViewById2 = viewInflate.findViewById(R.id.single_chat_photo);
        this.l0 = viewFindViewById2;
        f4(viewFindViewById2, new j());
        f4(this.W0, new m());
        this.m1 = (LinearLayout) viewInflate.findViewById(R.id.lin_notice);
        this.n1 = (LinearLayout) viewInflate.findViewById(R.id.lin_image);
        this.o1 = (LinearLayout) viewInflate.findViewById(R.id.lin_tool);
        f4(this.m1, new View.OnClickListener() { // from class: f30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17424a.M3(view);
            }
        });
        f4(this.n1, new View.OnClickListener() { // from class: g30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17642a.N3(view);
            }
        });
        f4(this.o1, new View.OnClickListener() { // from class: h30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17866a.O3(view);
            }
        });
        return viewInflate;
    }

    public final void z4(boolean z2) {
        c4(this.z, z2);
        this.s1 = z2;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f0 implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class b extends MaterialDialog.e {
            public b() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                String string = materialDialog.k().getText().toString();
                if (string.equals(ChatInfoActivity.this.x.getGroupName())) {
                    return;
                }
                if (!dt2.a(string)) {
                    sy5.e(AppContext.getContext(), R.string.group_name_empty_alert, 0).g();
                    return;
                }
                ChatInfoActivity.this.I0 = new b56(ChatInfoActivity.this.w0, ChatInfoActivity.this.v0);
                try {
                    ChatInfoActivity.this.I0.n(ChatInfoActivity.this.x.getGroupId(), string);
                    ChatInfoActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
                } catch (DaoException e) {
                    e.printStackTrace();
                    ChatInfoActivity.this.hideBaseProgressBar();
                }
            }
        }

        public f0() {
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0053 A[PHI: r5
          0x0053: PHI (r5v33 java.lang.String) = (r5v25 java.lang.String), (r5v19 java.lang.String) binds: [B:23:0x007a, B:13:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String groupRemarkName;
            int memberCount = ChatInfoActivity.this.x.getMemberCount();
            String groupOwner = ChatInfoActivity.this.x.getGroupOwner();
            if (memberCount < 100 || ChatInfoActivity.this.x.getGroupOwner().equals(AccountUtils.p(AppContext.getContext()))) {
                MaterialDialog materialDialogE = new sd3(ChatInfoActivity.this).T(R.string.group_name).B(null, null, new c()).f(new b()).a0(R.color.text_color_green).K(R.string.alert_dialog_cancel).e();
                if (!TextUtils.isEmpty(ChatInfoActivity.this.x.getGroupName())) {
                    materialDialogE.k().setText(ChatInfoActivity.this.x.getGroupName());
                }
                materialDialogE.show();
                ChatInfoActivity.this.d4(materialDialogE.k(), 32);
                return;
            }
            ContactInfoItem contactInfoItemL = bo0.r().l(groupOwner);
            String str = "";
            String remarkName = contactInfoItemL != null ? contactInfoItemL.getRemarkName() : "";
            if (!bo0.r().w(groupOwner) || TextUtils.isEmpty(remarkName)) {
                ContactInfoItem contactInfoItem = (ContactInfoItem) ChatInfoActivity.this.q1.get(0);
                if (contactInfoItem != null) {
                    groupRemarkName = contactInfoItem.getGroupRemarkName();
                    remarkName = contactInfoItem.getNickName();
                } else {
                    remarkName = "";
                    groupRemarkName = remarkName;
                }
                if (!TextUtils.isEmpty(groupRemarkName)) {
                    str = groupRemarkName;
                } else if (!TextUtils.isEmpty(remarkName)) {
                    str = remarkName;
                }
            }
            new sd3(ChatInfoActivity.this).k(ChatInfoActivity.this.getString(R.string.too_many_group_member, str)).f(new a()).O(R.string.get_it).e().show();
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements MaterialDialog.f {
            public c() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.f
            public void a(MaterialDialog materialDialog, CharSequence charSequence) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class b extends MaterialDialog.e {
            public b() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                String string = materialDialog.k().getText().toString();
                if (string.equals(ChatInfoActivity.this.x.getGroupName())) {
                    return;
                }
                if (!dt2.a(string)) {
                    sy5.e(AppContext.getContext(), R.string.group_name_empty_alert, 0).g();
                    return;
                }
                ChatInfoActivity.this.I0 = new b56(ChatInfoActivity.this.w0, ChatInfoActivity.this.v0);
                try {
                    ChatInfoActivity.this.I0.n(ChatInfoActivity.this.x.getGroupId(), string);
                    ChatInfoActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
                } catch (DaoException e) {
                    e.printStackTrace();
                    ChatInfoActivity.this.hideBaseProgressBar();
                }
            }
        }

        public l() {
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0053 A[PHI: r5
          0x0053: PHI (r5v33 java.lang.String) = (r5v25 java.lang.String), (r5v19 java.lang.String) binds: [B:23:0x007a, B:13:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String groupRemarkName;
            int memberCount = ChatInfoActivity.this.x.getMemberCount();
            String groupOwner = ChatInfoActivity.this.x.getGroupOwner();
            if (memberCount < 100 || ChatInfoActivity.this.x.getGroupOwner().equals(AccountUtils.p(AppContext.getContext()))) {
                MaterialDialog materialDialogE = new sd3(ChatInfoActivity.this).T(R.string.group_name).B(null, null, new c()).f(new b()).a0(R.color.text_color_green).K(R.string.alert_dialog_cancel).e();
                if (!TextUtils.isEmpty(ChatInfoActivity.this.x.getGroupName())) {
                    materialDialogE.k().setText(ChatInfoActivity.this.x.getGroupName());
                }
                materialDialogE.show();
                ChatInfoActivity.this.d4(materialDialogE.k(), 32);
                return;
            }
            ContactInfoItem contactInfoItemL = bo0.r().l(groupOwner);
            String str = "";
            String remarkName = contactInfoItemL != null ? contactInfoItemL.getRemarkName() : "";
            if (!bo0.r().w(groupOwner) || TextUtils.isEmpty(remarkName)) {
                ContactInfoItem contactInfoItem = (ContactInfoItem) ChatInfoActivity.this.q1.get(0);
                if (contactInfoItem != null) {
                    groupRemarkName = contactInfoItem.getGroupRemarkName();
                    remarkName = contactInfoItem.getNickName();
                } else {
                    remarkName = "";
                    groupRemarkName = remarkName;
                }
                if (!TextUtils.isEmpty(groupRemarkName)) {
                    str = groupRemarkName;
                } else if (!TextUtils.isEmpty(remarkName)) {
                    str = remarkName;
                }
            }
            new sd3(ChatInfoActivity.this).k(ChatInfoActivity.this.getString(R.string.too_many_group_member, str)).f(new a()).O(R.string.get_it).e().show();
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements MaterialDialog.f {
            public c() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.f
            public void a(MaterialDialog materialDialog, CharSequence charSequence) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s0 implements CompoundButton.OnCheckedChangeListener {
        public s0() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            c70.R().B0(ChatInfoActivity.this.x.getGroupId(), ChatInfoActivity.this.W.isChecked(), new a());
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse<Boolean>> {
            public a() {
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse<Boolean> baseResponse) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v0 implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f14206a;
        public final /* synthetic */ int b;

        public v0(EditText editText, int i) {
            this.f14206a = editText;
            this.b = i;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            dt2.d(this.f14206a, charSequence, this.b);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w1 implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f14210a;
        public final /* synthetic */ TextView b;

        public w1(EditText editText, TextView textView) {
            this.f14210a = editText;
            this.b = textView;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int length = this.f14210a.getText() != null ? this.f14210a.getText().length() : 0;
            this.b.setText((50 - length) + "");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static /* synthetic */ void L3(View view) {
    }

    public static /* synthetic */ void P3(View view) {
    }

    public void onCircleQuickEntranceLayoutClick(View view) {
    }

    public void onCircleToolsLayoutClick(View view) {
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    @Override // com.zenmen.palmchat.groupchat.a.d
    public void t0(a.c cVar) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {

            /* JADX INFO: renamed from: com.zenmen.palmchat.groupchat.ChatInfoActivity$m$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1059a extends wi0<BaseResponse> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f14172a;

                public C1059a(String str) {
                    this.f14172a = str;
                }

                @Override // defpackage.wi0
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public void a(BaseResponse baseResponse) {
                    ChatInfoActivity.this.hideBaseProgressBar();
                    if (baseResponse.getResultCode() != 0) {
                        ry5.a(baseResponse.getErrorMsg());
                        return;
                    }
                    ChatInfoActivity.this.x.setGroupName(this.f14172a);
                    ChatInfoActivity.this.w4();
                    c70.R().C0(false, new String[0]);
                }
            }

            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                String string = materialDialog.k().getText().toString();
                if (string.equals(ChatInfoActivity.this.x.getGroupName())) {
                    return;
                }
                if (!dt2.a(string)) {
                    sy5.e(AppContext.getContext(), R.string.group_name_empty_alert, 0).g();
                    return;
                }
                HashMap map = new HashMap();
                map.put(az.at, 0);
                map.put("rid", ChatInfoActivity.this.x.getGroupId());
                oc0.h("lx_group_edit_name_show", map);
                c70.R().v0(ChatInfoActivity.this.x.getGroupId(), string, new C1059a(string));
                ChatInfoActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            }
        }

        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (oc0.f() && oc0.b()) {
                ChatInfoActivity chatInfoActivity = ChatInfoActivity.this;
                CircleNameModifyActivity.K1(chatInfoActivity, chatInfoActivity.x);
                HashMap map = new HashMap();
                map.put(az.at, 0);
                map.put("rid", ChatInfoActivity.this.x.getGroupId());
                oc0.h("lx_group_edit_name_show", map);
                return;
            }
            MaterialDialog materialDialogE = new sd3(ChatInfoActivity.this).T(R.string.group_name).B(null, null, new b()).f(new a()).a0(R.color.text_color_green).K(R.string.alert_dialog_cancel).e();
            if (!TextUtils.isEmpty(ChatInfoActivity.this.x.getGroupName())) {
                materialDialogE.k().setText(ChatInfoActivity.this.x.getGroupName());
            }
            materialDialogE.show();
            HashMap map2 = new HashMap();
            map2.put(az.at, 0);
            if (ChatInfoActivity.this.x != null) {
                map2.put("rid", ChatInfoActivity.this.x.getGroupId());
            }
            oc0.h("lx_group_edit_name_show", map2);
            ChatInfoActivity.this.d4(materialDialogE.k(), 32);
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements MaterialDialog.f {
            public b() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.f
            public void a(MaterialDialog materialDialog, CharSequence charSequence) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r1 extends AsyncTask<Void, Void, GroupModifyResultVo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14190a;
        public final /* synthetic */ String b;

        public r1(ArrayList arrayList, String str) {
            this.f14190a = arrayList;
            this.b = str;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupModifyResultVo doInBackground(Void... voidArr) {
            try {
                return new o7(null, null).n(this.f14190a, this.b);
            } catch (DaoException unused) {
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(GroupModifyResultVo groupModifyResultVo) {
            super.onPostExecute(groupModifyResultVo);
            ChatInfoActivity.this.hideBaseProgressBar();
            if (groupModifyResultVo == null) {
                ChatInfoActivity.this.o4();
                return;
            }
            int i = groupModifyResultVo.resultCode;
            if (i == 0) {
                sy5.e(ChatInfoActivity.this, R.string.send_success, 0).g();
                return;
            }
            if (i == 4001 || i == 4002) {
                ChatInfoActivity.this.m4(this.f14190a, groupModifyResultVo.members);
                return;
            }
            if (i == 4016) {
                ChatInfoActivity.this.p4();
                return;
            }
            if (i == 4026 || i == 4027 || i == 4035) {
                de2.a(ChatInfoActivity.this, groupModifyResultVo, this.b, new a());
                return;
            }
            if (i == 4015) {
                ChatInfoActivity.this.l4();
                return;
            }
            if (i == 5061) {
                ChatInfoActivity.this.g3(this.f14190a, this.b);
                return;
            }
            if (i == 5082) {
                wc1.a(ChatInfoActivity.this, groupModifyResultVo.errorMsg);
            } else if (TextUtils.isEmpty(groupModifyResultVo.errorMsg)) {
                ChatInfoActivity.this.o4();
            } else {
                ChatInfoActivity.n4(groupModifyResultVo.errorMsg, ChatInfoActivity.this);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements SPWalletUtils.BindCardCallback {
            public a() {
            }

            @Override // com.zenmen.palmchat.redpacket.pay.SPWalletUtils.BindCardCallback
            public void onFail(int i, String str, Object obj) {
            }

            @Override // com.zenmen.palmchat.redpacket.pay.SPWalletUtils.BindCardCallback
            public void onSuccess(int i, String str, Object obj) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z1 implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14219a;

        public z1(String str) {
            this.f14219a = str;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            ChatInfoActivity.this.hideBaseProgressBar();
            try {
                int i = jSONObject.getInt("resultCode");
                if (i == 0) {
                    LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "1", this.f14219a);
                    if (ChatInfoActivity.this.x == null || !oc0.f() || ChatInfoActivity.this.x.getRoomType() == 0) {
                        Intent intent = new Intent(ChatInfoActivity.this, (Class<?>) GroupQRCodeActivity.class);
                        intent.putExtra(com.umeng.analytics.pro.f.K, ChatInfoActivity.this.x);
                        intent.putExtra("extra_qr_data", jSONObject.toString());
                        ChatInfoActivity.this.startActivity(intent);
                    } else {
                        Intent intent2 = new Intent(ChatInfoActivity.this, (Class<?>) CircleQRCodeActivity.class);
                        intent2.putExtra("key_group_info", ChatInfoActivity.this.x);
                        intent2.putExtra("from_source", 0);
                        ChatInfoActivity.this.startActivity(intent2);
                    }
                } else if (i == 4022) {
                    LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "2", this.f14219a + "errorMsg:" + jSONObject.optString(MediationConstant.KEY_ERROR_MSG));
                    if (ChatInfoActivity.this.x == null || !oc0.f() || ChatInfoActivity.this.x.getRoomType() == 0) {
                        Intent intent3 = new Intent(ChatInfoActivity.this, (Class<?>) GroupQRCodeActivity.class);
                        intent3.putExtra(com.umeng.analytics.pro.f.K, ChatInfoActivity.this.x);
                        intent3.putExtra("extra_qr_data", jSONObject.toString());
                        ChatInfoActivity.this.startActivity(intent3);
                    } else {
                        Intent intent4 = new Intent(ChatInfoActivity.this, (Class<?>) CircleQRCodeActivity.class);
                        intent4.putExtra("key_group_info", ChatInfoActivity.this.x);
                        intent4.putExtra("from_source", 0);
                        ChatInfoActivity.this.startActivity(intent4);
                    }
                } else if (i == 4031 || i == 4036) {
                    de2.a(ChatInfoActivity.this, GroupModifyResultVo.buildFromJsonObject(jSONObject), ChatInfoActivity.this.x.getGroupId(), new a());
                } else {
                    sy5.e(ChatInfoActivity.this, R.string.send_failed, 0).g();
                    String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                    LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "2", this.f14219a + "errorMsg:" + strOptString);
                }
            } catch (JSONException e) {
                LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "2", this.f14219a + "JSONException");
                e.printStackTrace();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements SPWalletUtils.BindCardCallback {
            public a() {
            }

            @Override // com.zenmen.palmchat.redpacket.pay.SPWalletUtils.BindCardCallback
            public void onFail(int i, String str, Object obj) {
            }

            @Override // com.zenmen.palmchat.redpacket.pay.SPWalletUtils.BindCardCallback
            public void onSuccess(int i, String str, Object obj) {
            }
        }
    }
}
