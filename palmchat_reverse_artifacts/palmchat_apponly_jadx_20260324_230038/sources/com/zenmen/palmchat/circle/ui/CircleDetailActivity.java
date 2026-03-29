package com.zenmen.palmchat.circle.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.baidu.location.LocationConst;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.photoview.PhotoViewActivity;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.circle.bean.CircleApplyGroupType;
import com.zenmen.palmchat.circle.bean.CircleRecommendItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.label.bean.RoomTag;
import com.zenmen.palmchat.circle.label.ui.CircleLabelActivity;
import com.zenmen.palmchat.circle.ui.view.CircleExpandTextView;
import com.zenmen.palmchat.circle.ui.view.CircleFixedRatioImageView;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.groupchat.GroupQRCodeActivity;
import com.zenmen.palmchat.groupchat.dao.GroupModifyResultVo;
import com.zenmen.palmchat.redpacket.pay.SPWalletUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.c70;
import defpackage.de2;
import defpackage.dv0;
import defpackage.gr2;
import defpackage.ir5;
import defpackage.iv0;
import defpackage.j56;
import defpackage.j70;
import defpackage.j92;
import defpackage.je1;
import defpackage.k86;
import defpackage.l50;
import defpackage.oc0;
import defpackage.ry5;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.v4;
import defpackage.wi0;
import defpackage.xn3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleDetailActivity extends BaseActionBarActivity {
    public ImageView A;
    public TextView B;
    public CircleExpandTextView C;
    public ImageView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public TextView I;
    public TextView J;
    public View K;
    public ViewGroup L;
    public ViewGroup M;
    public View N;
    public View O;
    public List<TextView> P;
    public String Q;
    public GroupInfoItem R;
    public ContactInfoItem U;
    public je1 V;
    public CircleApplyGroupType W;
    public TextView X;
    public TextView Y;
    public TextView Z;
    public TextView e0;
    public String g0;
    public String h0;
    public String j0;
    public int o0;
    public LinearLayout p0;
    public CircleFixedRatioImageView q0;
    public CircleFixedRatioImageView r;
    public ImageView s;
    public EffectiveShapeView t;
    public LinearLayout u;
    public TextView v;
    public TextView w;
    public TextView x;
    public LinearLayout y;
    public TextView z;
    public final int q = 2;
    public int S = 0;
    public int T = -1;
    public List<TextView> f0 = new ArrayList();
    public int i0 = 0;
    public boolean k0 = true;
    public boolean l0 = false;
    public boolean m0 = false;
    public boolean n0 = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: com.zenmen.palmchat.circle.ui.CircleDetailActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1011a extends MaterialDialog.e {
            public C1011a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleDetailActivity.this.hideBaseProgressBar();
            if (baseResponse == null) {
                return;
            }
            if (baseResponse.getResultCode() != 0 && baseResponse.getResultCode() != 4001 && baseResponse.getResultCode() != 4006) {
                if (baseResponse.getResultCode() == 4027 || baseResponse.getResultCode() == 5077) {
                    new sd3(CircleDetailActivity.this).k(baseResponse.getErrorMsg()).O(R.string.red_packet_timeout_know).f(new C1011a()).e().show();
                    return;
                } else {
                    sy5.f(CircleDetailActivity.this, baseResponse.getErrorMsg(), 0).g();
                    return;
                }
            }
            Intent intent = new Intent(CircleDetailActivity.this, (Class<?>) ChatterActivity.class);
            intent.putExtra("chat_item", CircleDetailActivity.this.R);
            if (CircleDetailActivity.this.k0) {
                k86.X(intent);
            } else {
                intent.putExtra("chat_need_back_to_main", CircleDetailActivity.this.k0);
            }
            CircleDetailActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements CircleExpandTextView.a {
        public b() {
        }

        @Override // com.zenmen.palmchat.circle.ui.view.CircleExpandTextView.a
        public void a() {
            CircleDetailActivity.this.E.setVisibility(0);
        }

        @Override // com.zenmen.palmchat.circle.ui.view.CircleExpandTextView.a
        public void b() {
            CircleDetailActivity.this.E.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13108a;

        public d(String str) {
            this.f13108a = str;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            CircleDetailActivity.this.hideBaseProgressBar();
            sy5.e(CircleDetailActivity.this, R.string.send_failed, 0).g();
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "2", this.f13108a + "errorMsg:" + volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends wi0<BaseResponse<CircleRecommendItem>> {
        public e() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleRecommendItem> baseResponse) {
            CircleDetailActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() != 0 || baseResponse.getData() == null) {
                return;
            }
            CircleDetailActivity.this.R = baseResponse.getData().copyForGroupInfoItem();
            CircleDetailActivity.this.updateViews();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends wi0<BaseResponse<CircleApplyGroupType>> {
        public f() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleApplyGroupType> baseResponse) {
            CircleDetailActivity.this.W = baseResponse.getData();
            if (CircleDetailActivity.this.W == null || CircleDetailActivity.this.W.getAddType() != 1) {
                return;
            }
            CircleDetailActivity.this.I.setText(CircleDetailActivity.this.getString(R.string.group_detail_action));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements j56 {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13112a;

            public a(String str) {
                this.f13112a = str;
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                CircleDetailActivity.this.hideBaseProgressBar();
                c70.R().C0(false, new String[0]);
                if (baseResponse.getResultCode() == 0) {
                    sy5.e(CircleDetailActivity.this, R.string.circle_cover_upload_success, 0).g();
                    CircleDetailActivity.this.R.setCover(this.f13112a);
                    CircleDetailActivity.this.updateViews();
                } else if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleDetailActivity.this, R.string.circle_cover_upload_fail, 0).g();
                } else {
                    sy5.f(CircleDetailActivity.this, baseResponse.getErrorMsg(), 0).g();
                }
            }
        }

        public g() {
        }

        @Override // defpackage.j56
        public void onFailed(Throwable th) {
            CircleDetailActivity.this.hideBaseProgressBar();
            sy5.e(CircleDetailActivity.this, R.string.circle_cover_upload_fail, 0).g();
        }

        @Override // defpackage.j56
        public void onSuccess(String str, String str2) {
            c70.R().t0(CircleDetailActivity.this.Q, str2, new a(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(View view) {
        GroupInfoItem groupInfoItem = this.R;
        if (groupInfoItem != null) {
            CircleLabelActivity.X1(this, groupInfoItem, 52);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2(View view) {
        GroupInfoItem groupInfoItem = this.R;
        if (groupInfoItem != null) {
            s2(groupInfoItem.getGroupHeadImgUrl(), this.R.getGroupHeadImgUrl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f2(View view) {
        GroupInfoItem groupInfoItem = this.R;
        if (groupInfoItem != null) {
            if (!TextUtils.isEmpty(groupInfoItem.getCover())) {
                s2(this.R.getCover(), this.R.getCover());
            } else if (this.l0) {
                BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_COVER_IMAGE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g2(View view) {
        Intent intent = new Intent();
        intent.setClass(this, CircleEditDetailActivity.class);
        GroupInfoItem groupInfoItem = this.R;
        if (groupInfoItem != null) {
            intent.putExtra("key_group_info", groupInfoItem);
        } else {
            intent.putExtra(j70.f18338a, this.Q);
        }
        startActivityForResult(intent, 53);
        HashMap map = new HashMap();
        GroupInfoItem groupInfoItem2 = this.R;
        if (groupInfoItem2 != null) {
            map.put("rid", groupInfoItem2.getGroupId());
        }
        oc0.h("lx_group_profile_edit_click", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h2(View view) {
        if (this.T == 1) {
            Intent intent = new Intent(this, (Class<?>) ChatterActivity.class);
            intent.putExtra("chat_item", this.R);
            intent.putExtra("fromType", 6);
            boolean z = this.k0;
            if (z) {
                k86.X(intent);
            } else {
                intent.putExtra("chat_need_back_to_main", z);
            }
            startActivity(intent);
            HashMap map = new HashMap();
            GroupInfoItem groupInfoItem = this.R;
            if (groupInfoItem != null) {
                map.put("rid", groupInfoItem.getGroupId());
            }
            oc0.h("lx_group_profile_chat_click", map);
            return;
        }
        HashMap map2 = new HashMap();
        map2.put("fromtype", Integer.valueOf(Z1()));
        GroupInfoItem groupInfoItem2 = this.R;
        if (groupInfoItem2 != null) {
            map2.put("rid", groupInfoItem2.getGroupId());
        }
        CircleApplyGroupType circleApplyGroupType = this.W;
        if (circleApplyGroupType != null) {
            int addType = circleApplyGroupType.getAddType();
            if (addType == 1) {
                map2.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, 1);
            } else if (addType == 2) {
                map2.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, 2);
            } else if (addType == 3) {
                map2.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, 0);
            }
        }
        oc0.h("lx_group_profile_join_click", map2);
        CircleApplyGroupType circleApplyGroupType2 = this.W;
        if (circleApplyGroupType2 != null) {
            int addType2 = circleApplyGroupType2.getAddType();
            if (addType2 == 1) {
                showBaseProgressBar();
                c70.R().j(this.Q, this.i0, "", this.j0, new a());
                return;
            } else if (addType2 == 2) {
                CircleApplyGroupActivity.J1(this, this.W, this.i0, this.j0);
                return;
            }
        }
        ry5.a("暂不允许加入");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(View view) {
        MessageVo threadBizType = MessageVo.buildNameCardMessage(xn3.a(), (String) null, this.R, 0, ir5.b()).setThreadBizType(this, 1);
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
        map.put("rid", this.Q);
        oc0.h("lx_group_profile_share_click1_type", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j2(View view) {
        Y1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(View view) {
        this.C.setMaxLineCount(Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(View view) {
        if (this.E.getVisibility() == 0) {
            this.C.setMaxLineCount(Integer.MAX_VALUE);
        } else {
            this.C.setMaxLineCount(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(View view) {
        Intent intent = new Intent();
        intent.setClass(this, CircleEditDetailActivity.class);
        GroupInfoItem groupInfoItem = this.R;
        if (groupInfoItem != null) {
            intent.putExtra("key_group_info", groupInfoItem);
        } else {
            intent.putExtra(j70.f18338a, this.Q);
        }
        intent.putExtra("extra_selected_cate_name", this.g0);
        intent.putExtra("extra_selected_cate_id", this.h0);
        startActivityForResult(intent, 53);
        HashMap map = new HashMap();
        GroupInfoItem groupInfoItem2 = this.R;
        if (groupInfoItem2 != null) {
            map.put("rid", groupInfoItem2.getGroupId());
        }
        oc0.h("lx_group_profile_edit_click", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2(String str, GroupInfoItem groupInfoItem) {
        if (groupInfoItem != null) {
            hideBaseProgressBar();
            this.R = groupInfoItem;
            updateViews();
        } else if (this.R == null) {
            c70.R().F(str, new e());
        } else {
            hideBaseProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o2(List list) {
        if (list == null || this.S != 0) {
            return;
        }
        this.S = list.size();
        updateViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p2(ContactInfoItem contactInfoItem) {
        this.U = contactInfoItem;
        int i = contactInfoItem != null ? 1 : 0;
        if (i != this.T) {
            this.T = i;
            updateViews();
            if (this.T == 0) {
                c70.R().C(this.Q, new f());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q2() {
        GroupInfoItem groupInfoItem;
        if (isFinishing() || (groupInfoItem = this.R) == null) {
            return;
        }
        this.v.setText(groupInfoItem.getNameForShow());
    }

    public final void Y1() {
        if (l50.a() || this.R == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rid", this.R.getGroupId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String string = jSONObject.toString();
        c cVar = new c(string);
        d dVar = new d(string);
        showBaseProgressBar();
        HashMap map = new HashMap();
        GroupInfoItem groupInfoItem = this.R;
        if (groupInfoItem != null) {
            map.put("roomId", groupInfoItem.getGroupId());
        }
        try {
            new j92(cVar, dVar, map).n();
        } catch (DaoException e3) {
            e3.printStackTrace();
        }
    }

    public final int Z1() {
        int i = this.i0;
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 5;
        }
        if (i == 3) {
            int i2 = this.o0;
            if (i2 == 101) {
                return 101;
            }
            if (i2 == 102) {
                return 102;
            }
        } else {
            if (i == 4) {
                return 4;
            }
            if (i == 5 || i == 6) {
                return -1;
            }
            if (i == 8) {
                return 6;
            }
            if (i == 9) {
                return 7;
            }
            if (i == 11) {
                return 8;
            }
        }
        return 0;
    }

    public final void a2() {
        this.s.setOnClickListener(new View.OnClickListener() { // from class: u70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21153a.c2(view);
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() { // from class: a80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1167a.e2(view);
            }
        });
        this.r.setOnClickListener(new View.OnClickListener() { // from class: b80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1663a.f2(view);
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() { // from class: c80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1914a.g2(view);
            }
        });
        this.I.setOnClickListener(new View.OnClickListener() { // from class: d80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f16994a.h2(view);
            }
        });
        this.H.setOnClickListener(new View.OnClickListener() { // from class: e80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17231a.i2(view);
            }
        });
        this.A.setOnClickListener(new View.OnClickListener() { // from class: f80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17477a.j2(view);
            }
        });
        this.C.setMaxLineCount(2);
        this.C.setCallback(new b());
        this.E.setOnClickListener(new View.OnClickListener() { // from class: g80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17677a.k2(view);
            }
        });
        this.C.setOnClickListener(new View.OnClickListener() { // from class: h80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17893a.l2(view);
            }
        });
        this.L.setOnClickListener(new View.OnClickListener() { // from class: i80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18121a.d2(view);
            }
        });
    }

    public final void b2() {
        this.r = (CircleFixedRatioImageView) findViewById(R.id.circle_detail_cover);
        this.s = (ImageView) findViewById(R.id.circle_detail_title_back);
        this.t = (EffectiveShapeView) findViewById(R.id.circle_detail_avatar);
        this.u = (LinearLayout) findViewById(R.id.circle_detail_edit);
        this.v = (TextView) findViewById(R.id.circle_detail_name);
        this.w = (TextView) findViewById(R.id.circle_detail_code);
        this.x = (TextView) findViewById(R.id.circle_detail_count);
        this.y = (LinearLayout) findViewById(R.id.circle_detail_time);
        this.z = (TextView) findViewById(R.id.circle_detail_time_desc);
        this.A = (ImageView) findViewById(R.id.circle_detail_qrcode_add);
        this.B = (TextView) findViewById(R.id.circle_detail_desc);
        this.C = (CircleExpandTextView) findViewById(R.id.circle_detail_desc_content);
        this.E = (ImageView) findViewById(R.id.circle_detail_desc_arrow);
        this.F = (TextView) findViewById(R.id.circle_detail_location_desc);
        this.G = (TextView) findViewById(R.id.circle_detail_location);
        this.H = (TextView) findViewById(R.id.circle_detail_share);
        this.I = (TextView) findViewById(R.id.circle_detail_join);
        this.J = (TextView) findViewById(R.id.circle_detail_sort_name);
        this.K = findViewById(R.id.circle_detail_div_tags);
        this.L = (ViewGroup) findViewById(R.id.circle_detail_tags);
        this.N = findViewById(R.id.circle_detail_tags_no_setting);
        this.M = (ViewGroup) findViewById(R.id.circle_detail_tags_flow);
        this.O = findViewById(R.id.circle_detail_tags_arrow);
        this.p0 = (LinearLayout) findViewById(R.id.lin_edit);
        this.q0 = (CircleFixedRatioImageView) findViewById(R.id.circle_cover);
        List<TextView> list = this.P;
        if (list == null) {
            this.P = new ArrayList();
        } else {
            list.clear();
        }
        this.P.add((TextView) findViewById(R.id.circle_detail_tag1));
        this.P.add((TextView) findViewById(R.id.circle_detail_tag2));
        this.P.add((TextView) findViewById(R.id.circle_detail_tag3));
        this.p0.setOnClickListener(new View.OnClickListener() { // from class: z70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22371a.m2(view);
            }
        });
        this.X = (TextView) findViewById(R.id.text_member_count);
        this.Y = (TextView) findViewById(R.id.text_tags1);
        this.Z = (TextView) findViewById(R.id.text_tags2);
        this.e0 = (TextView) findViewById(R.id.text_tags3);
        this.f0.add(this.Y);
        this.f0.add(this.Z);
        this.f0.add(this.e0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        GroupInfoItem groupInfoItem;
        String[] strArr;
        super.onActivityResult(i, i2, intent);
        if (i == 51 && i2 == -1) {
            String stringExtra = intent.getStringExtra("media_pick_photo_key");
            if (k86.I(stringExtra)) {
                showBaseProgressBar(getString(R.string.settings_uploading_cover), false);
                c70.R().H0(stringExtra, new g());
                return;
            }
            return;
        }
        if (i != 52 || i2 != -1) {
            if (i == 53 && i2 == -1 && (groupInfoItem = (GroupInfoItem) intent.getParcelableExtra("key_group_info")) != null) {
                this.R = groupInfoItem;
                updateViews();
                return;
            }
            return;
        }
        List<RoomTag> listG1 = CircleLabelActivity.G1(intent);
        if (listG1 == null || listG1.isEmpty()) {
            strArr = null;
        } else {
            strArr = new String[listG1.size()];
            for (int i3 = 0; i3 < listG1.size(); i3++) {
                strArr[i3] = listG1.get(i3).tagName;
            }
        }
        this.R.setTags(strArr);
        updateViews();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_detail);
        t2(this);
        Intent intent = getIntent();
        this.R = (GroupInfoItem) intent.getParcelableExtra("key_group_info");
        this.i0 = intent.getIntExtra("key_apply_group_source", 0);
        this.o0 = intent.getIntExtra("fromtype", 0);
        this.k0 = intent.getBooleanExtra("chat_need_back_to_main", true);
        this.g0 = intent.getStringExtra("extra_selected_cate_name");
        this.h0 = intent.getStringExtra("extra_selected_cate_id");
        this.j0 = intent.getStringExtra("join_circle_extra_data");
        if (this.i0 == 0) {
            throw new IllegalArgumentException("缺少applyGroupSource参数");
        }
        GroupInfoItem groupInfoItem = this.R;
        if (groupInfoItem != null) {
            this.Q = groupInfoItem.getGroupId();
        } else {
            this.Q = intent.getStringExtra(j70.f18338a);
        }
        if (TextUtils.isEmpty(this.Q)) {
            finish();
            return;
        }
        this.V = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(R.drawable.circle_detail_default_cover).r();
        b2();
        a2();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_COVER_IMAGE) {
            Intent intent = new Intent(this, (Class<?>) MediaPickActivity.class);
            intent.putExtra("select_mode_key", 1);
            intent.putExtra("from", "from_person_info");
            intent.putExtra("crop_ratio", 2.748f);
            startActivityForResult(intent, 51);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (isFinishing()) {
            return;
        }
        r2(this.Q);
    }

    public final void r2(final String str) {
        if (this.R == null) {
            showBaseProgressBar(R.string.loading, false);
            c70.R().K(str, new dv0() { // from class: w70
                @Override // defpackage.dv0
                public final void onResponse(Object obj) {
                    this.f21632a.n2(str, (GroupInfoItem) obj);
                }
            });
        }
        c70.R().M(str, new dv0() { // from class: x70
            @Override // defpackage.dv0
            public final void onResponse(Object obj) {
                this.f21892a.o2((List) obj);
            }
        });
        c70.R().N(this.Q, v4.e(this), new dv0() { // from class: y70
            @Override // defpackage.dv0
            public final void onResponse(Object obj) {
                this.f22152a.p2((ContactInfoItem) obj);
            }
        });
    }

    public final void s2(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, PhotoViewActivity.class);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        MediaItem mediaItem = new MediaItem();
        mediaItem.fileFullPath = str;
        mediaItem.thumbnailPath = str2;
        arrayList.add(mediaItem);
        intent.putParcelableArrayListExtra("mediaList", arrayList);
        intent.putExtra("selectIndex", 0);
        intent.putExtra("from_portrait", true);
        intent.putExtra("from_user_portrait", true);
        intent.putExtra("show_mode", 0);
        startActivity(intent);
    }

    public final void t2(Activity activity) {
        Window window = activity.getWindow();
        window.setStatusBarColor(0);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    public final void u2() {
        if (!this.n0 || this.R == null || this.T == -1) {
            return;
        }
        this.n0 = false;
        HashMap map = new HashMap();
        map.put("fromtype", Integer.valueOf(Z1()));
        map.put("member", Integer.valueOf(this.T));
        GroupInfoItem groupInfoItem = this.R;
        if (groupInfoItem != null) {
            map.put("rid", groupInfoItem.getGroupId());
        }
        oc0.h("lx_group_profile_show", map);
    }

    @SuppressLint({"SetTextI18n"})
    public final void updateViews() {
        if (this.R == null) {
            return;
        }
        u2();
        ContactInfoItem contactInfoItem = this.U;
        if (contactInfoItem != null) {
            boolean z = contactInfoItem.getRoleType() == 1;
            this.m0 = z;
            this.l0 = z || this.U.getRoleType() == 2;
        } else {
            String groupOwner = this.R.getGroupOwner();
            this.m0 = !TextUtils.isEmpty(groupOwner) && groupOwner.equals(v4.e(this));
        }
        this.p0.setVisibility((this.l0 || this.m0) ? 0 : 8);
        if (this.T == 1) {
            this.I.setText(getString(R.string.circle_send_message));
        } else if (this.R.getAddType() == 1) {
            this.I.setText(getString(R.string.group_detail_action));
        } else {
            this.I.setText(getString(R.string.circle_join_proposal));
        }
        this.v.setText("");
        if (TextUtils.isEmpty(this.R.getCateName())) {
            this.w.setVisibility(8);
        } else {
            this.w.setText(this.R.getCateName());
            this.w.setVisibility(0);
        }
        this.w.post(new Runnable() { // from class: v70
            @Override // java.lang.Runnable
            public final void run() {
                this.f21369a.q2();
            }
        });
        int memberCount = this.R.getMemberCount();
        TextView textView = this.x;
        String string = getString(R.string.circle_count_people);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(memberCount == 0 ? this.S : memberCount);
        textView.setText(String.format(string, objArr));
        this.z.setText(iv0.a(this.R.getCreateTimestamp(), "yyyy年MM月dd日"));
        if (TextUtils.isEmpty(this.R.getDescribe())) {
            this.C.setExpandText(this.m0 ? "介绍一下吧，让更多人了解你的群~" : "群主很懒，还没有写群介绍哦~");
        } else {
            this.C.setExpandText(this.R.getDescribe());
        }
        if (TextUtils.isEmpty(this.R.getPlace())) {
            this.G.setText(R.string.string_no_setting);
        } else {
            this.G.setText(this.R.getPlace());
        }
        gr2.j().h(this.R.getGroupHeadImgUrl(), this.t, bq6.s());
        if (this.l0 || !TextUtils.isEmpty(this.R.getCover())) {
            gr2.j().h(this.R.getCover(), this.r, this.V);
        } else {
            this.r.setBackgroundColor(getResources().getColor(R.color.color_999999));
        }
        if (TextUtils.isEmpty(this.R.getCover())) {
            this.q0.setVisibility(8);
        } else {
            this.q0.setVisibility(0);
        }
        if (oc0.c()) {
            if (TextUtils.isEmpty(this.R.getCateName())) {
                this.J.setVisibility(8);
            } else {
                this.J.setText(this.R.getCateName());
            }
            this.K.setVisibility(0);
            this.O.setVisibility(this.u.getVisibility());
            if (this.R.getTags() == null || this.R.getTags().length <= 0) {
                this.M.setVisibility(8);
                this.N.setVisibility(0);
            } else {
                this.M.setVisibility(0);
                this.N.setVisibility(8);
                Iterator<TextView> it = this.P.iterator();
                while (it.hasNext()) {
                    it.next().setVisibility(8);
                }
                for (int i = 0; i < Math.min(this.R.getTags().length, this.P.size()); i++) {
                    if (!TextUtils.isEmpty(this.R.getTags()[i])) {
                        this.P.get(i).setVisibility(0);
                        this.P.get(i).setText(this.R.getTags()[i]);
                    }
                }
            }
        } else {
            this.J.setVisibility(8);
            this.K.setVisibility(8);
            this.L.setVisibility(8);
        }
        TextView textView2 = this.X;
        if (memberCount == 0) {
            memberCount = this.S;
        }
        textView2.setText(String.valueOf(memberCount));
        if (this.R.getTags() == null || this.R.getTags().length <= 0) {
            return;
        }
        String[] tags = this.R.getTags();
        for (int i2 = 0; i2 < tags.length && i2 < this.f0.size(); i2++) {
            this.f0.get(i2).setVisibility(0);
            this.f0.get(i2).setText(tags[i2]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13106a;

        public c(String str) {
            this.f13106a = str;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            CircleDetailActivity.this.hideBaseProgressBar();
            try {
                int i = jSONObject.getInt("resultCode");
                if (i == 0) {
                    LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "1", this.f13106a);
                    if (!oc0.f() || CircleDetailActivity.this.R.getRoomType() == 0) {
                        Intent intent = new Intent(CircleDetailActivity.this, (Class<?>) GroupQRCodeActivity.class);
                        intent.putExtra(com.umeng.analytics.pro.f.K, CircleDetailActivity.this.R);
                        intent.putExtra("extra_qr_data", jSONObject.toString());
                        CircleDetailActivity.this.startActivity(intent);
                    } else {
                        Intent intent2 = new Intent(CircleDetailActivity.this, (Class<?>) CircleQRCodeActivity.class);
                        intent2.putExtra("key_group_info", CircleDetailActivity.this.R);
                        intent2.putExtra("from_source", 1);
                        CircleDetailActivity.this.startActivity(intent2);
                    }
                } else if (i == 4022) {
                    LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "2", this.f13106a + "errorMsg:" + jSONObject.optString(MediationConstant.KEY_ERROR_MSG));
                    if (!oc0.f() || CircleDetailActivity.this.R.getRoomType() == 0) {
                        Intent intent3 = new Intent(CircleDetailActivity.this, (Class<?>) GroupQRCodeActivity.class);
                        intent3.putExtra(com.umeng.analytics.pro.f.K, CircleDetailActivity.this.R);
                        intent3.putExtra("extra_qr_data", jSONObject.toString());
                        CircleDetailActivity.this.startActivity(intent3);
                    } else {
                        Intent intent4 = new Intent(CircleDetailActivity.this, (Class<?>) CircleQRCodeActivity.class);
                        intent4.putExtra("key_group_info", CircleDetailActivity.this.R);
                        intent4.putExtra("from_source", 1);
                        CircleDetailActivity.this.startActivity(intent4);
                    }
                } else if (i == 4031 || i == 4036) {
                    de2.a(CircleDetailActivity.this, GroupModifyResultVo.buildFromJsonObject(jSONObject), CircleDetailActivity.this.R.getGroupId(), new a());
                } else {
                    sy5.e(CircleDetailActivity.this, R.string.send_failed, 0).g();
                    String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                    LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "2", this.f13106a + "errorMsg:" + strOptString);
                }
            } catch (JSONException e) {
                LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "2", this.f13106a + "JSONException");
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
