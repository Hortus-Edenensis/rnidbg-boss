package com.zenmen.palmchat.circle.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.az;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.label.bean.RoomTag;
import com.zenmen.palmchat.circle.label.ui.CircleLabelActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.groupchat.GroupQRCodeActivity;
import com.zenmen.palmchat.groupchat.dao.GroupModifyResultVo;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationSelectActivity;
import com.zenmen.palmchat.redpacket.pay.SPWalletUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.a46;
import defpackage.bq6;
import defpackage.c70;
import defpackage.de2;
import defpackage.dt2;
import defpackage.dv0;
import defpackage.gr2;
import defpackage.j56;
import defpackage.j70;
import defpackage.j92;
import defpackage.je1;
import defpackage.k80;
import defpackage.k86;
import defpackage.l50;
import defpackage.oc0;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.v4;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleEditDetailActivity extends BaseActionBarActivity {
    public TextView A;
    public ImageView B;
    public LinearLayout C;
    public TextView E;
    public LinearLayout F;
    public TextView G;
    public ViewGroup H;
    public ViewGroup I;
    public View J;
    public List<TextView> K;
    public String L;
    public GroupInfoItem M;
    public ContactInfoItem N;
    public je1 O;
    public k80 P;
    public boolean Q;
    public View R;
    public TextView S;
    public String T;
    public String U;
    public LinearLayout q;
    public TextView r;
    public LinearLayout s;
    public EffectiveShapeView t;
    public LinearLayout u;
    public EffectiveShapeView v;
    public TextView w;
    public LinearLayout x;
    public TextView y;
    public LinearLayout z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements j56 {

        /* JADX INFO: renamed from: com.zenmen.palmchat.circle.ui.CircleEditDetailActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1012a extends wi0<BaseResponse> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13116a;

            public C1012a(String str) {
                this.f13116a = str;
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                CircleEditDetailActivity.this.hideBaseProgressBar();
                c70.R().C0(false, new String[0]);
                if (baseResponse.getResultCode() == 0) {
                    sy5.e(CircleEditDetailActivity.this, R.string.circle_avatar_upload_success, 0).g();
                    if (CircleEditDetailActivity.this.M != null) {
                        CircleEditDetailActivity.this.M.setGroupHeadImgUrl(this.f13116a);
                    }
                    CircleEditDetailActivity.this.updateViews();
                    CircleEditDetailActivity.this.Q = true;
                    return;
                }
                if (CircleEditDetailActivity.this.P.d(CircleEditDetailActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleEditDetailActivity.this, R.string.circle_avatar_upload_fail, 0).g();
                } else {
                    sy5.f(CircleEditDetailActivity.this, baseResponse.getErrorMsg(), 0).g();
                }
            }
        }

        public a() {
        }

        @Override // defpackage.j56
        public void onFailed(Throwable th) {
            CircleEditDetailActivity.this.hideBaseProgressBar();
            sy5.e(CircleEditDetailActivity.this, R.string.circle_avatar_upload_fail, 0).g();
        }

        @Override // defpackage.j56
        public void onSuccess(String str, String str2) {
            c70.R().s0(CircleEditDetailActivity.this.L, str2, new C1012a(str));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements j56 {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13118a;

            public a(String str) {
                this.f13118a = str;
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                CircleEditDetailActivity.this.hideBaseProgressBar();
                c70.R().C0(false, new String[0]);
                if (baseResponse.getResultCode() == 0) {
                    sy5.e(CircleEditDetailActivity.this, R.string.circle_cover_upload_success, 0).g();
                    if (CircleEditDetailActivity.this.M != null) {
                        CircleEditDetailActivity.this.M.setCover(this.f13118a);
                    }
                    CircleEditDetailActivity.this.updateViews();
                    CircleEditDetailActivity.this.Q = true;
                    return;
                }
                if (CircleEditDetailActivity.this.P.d(CircleEditDetailActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleEditDetailActivity.this, R.string.circle_cover_upload_fail, 0).g();
                } else {
                    sy5.f(CircleEditDetailActivity.this, baseResponse.getErrorMsg(), 0).g();
                }
            }
        }

        public b() {
        }

        @Override // defpackage.j56
        public void onFailed(Throwable th) {
            CircleEditDetailActivity.this.hideBaseProgressBar();
            sy5.e(CircleEditDetailActivity.this, R.string.circle_cover_upload_fail, 0).g();
        }

        @Override // defpackage.j56
        public void onSuccess(String str, String str2) {
            c70.R().t0(CircleEditDetailActivity.this.L, str2, new a(str));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13119a;

        public c(String str) {
            this.f13119a = str;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleEditDetailActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() != 0) {
                if (CircleEditDetailActivity.this.P.d(CircleEditDetailActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                sy5.e(CircleEditDetailActivity.this, R.string.send_failed, 0).g();
            } else {
                c70.R().C0(false, new String[0]);
                if (CircleEditDetailActivity.this.M != null) {
                    CircleEditDetailActivity.this.M.setPlace(this.f13119a);
                }
                CircleEditDetailActivity.this.updateViews();
                CircleEditDetailActivity.this.Q = true;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13121a;

            public a(String str) {
                this.f13121a = str;
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                CircleEditDetailActivity.this.hideBaseProgressBar();
                if (baseResponse.getResultCode() == 0) {
                    CircleEditDetailActivity.this.M.setGroupName(this.f13121a);
                    CircleEditDetailActivity.this.updateViews();
                    c70.R().C0(false, new String[0]);
                    CircleEditDetailActivity.this.Q = true;
                }
            }
        }

        public d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            String string = materialDialog.k().getText().toString();
            if (string.equals(CircleEditDetailActivity.this.M.getGroupName())) {
                return;
            }
            if (!dt2.a(string)) {
                sy5.e(AppContext.getContext(), R.string.group_name_empty_alert, 0).g();
            } else {
                c70.R().v0(CircleEditDetailActivity.this.L, string, new a(string));
                CircleEditDetailActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13125a;

        public g(String str) {
            this.f13125a = str;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            CircleEditDetailActivity.this.hideBaseProgressBar();
            sy5.e(CircleEditDetailActivity.this, R.string.send_failed, 0).g();
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "2", this.f13125a + "errorMsg:" + volleyError.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(GroupInfoItem groupInfoItem) {
        if (groupInfoItem == null) {
            return;
        }
        this.M = groupInfoItem;
        updateViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y1(ContactInfoItem contactInfoItem) {
        this.N = contactInfoItem;
        updateViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(View view) {
        GroupInfoItem groupInfoItem = this.M;
        if (groupInfoItem == null || groupInfoItem.getGroupOwner() == null || !this.M.getGroupOwner().equals(AccountUtils.p(this))) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) CircleCateSelectActivity.class);
        intent.putExtra("extra_from", 1);
        intent.putExtra("extra_room_id", this.M.getGroupId());
        intent.putExtra("extra_selected_cate_name", this.T);
        intent.putExtra("extra_selected_cate_id", this.U);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a2(View view) {
        Q1();
        HashMap map = new HashMap();
        map.put(az.at, 1);
        GroupInfoItem groupInfoItem = this.M;
        if (groupInfoItem != null) {
            map.put("rid", groupInfoItem.getGroupId());
        }
        oc0.h("lx_group_edit_name_show", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b2(View view) {
        BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_AVATAR_IMAGE);
        HashMap map = new HashMap();
        GroupInfoItem groupInfoItem = this.M;
        if (groupInfoItem != null) {
            map.put("rid", groupInfoItem.getGroupId());
        }
        oc0.h("lx_group_edit_avatar_click", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(View view) {
        BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_COVER_IMAGE);
        HashMap map = new HashMap();
        GroupInfoItem groupInfoItem = this.M;
        if (groupInfoItem != null) {
            map.put("rid", groupInfoItem.getGroupId());
        }
        oc0.h("lx_group_edit_cover_click", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(View view) {
        BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_LOCATION);
        HashMap map = new HashMap();
        GroupInfoItem groupInfoItem = this.M;
        if (groupInfoItem != null) {
            map.put("rid", groupInfoItem.getGroupId());
        }
        oc0.h("lx_group_edit_place_click", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2(View view) {
        S1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f2(View view) {
        R1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g2(View view) {
        Intent intent = new Intent();
        intent.setClass(this, CircleEditDescActivity.class);
        intent.putExtra(j70.f18338a, this.L);
        GroupInfoItem groupInfoItem = this.M;
        if (groupInfoItem != null) {
            intent.putExtra(j70.h, groupInfoItem.getDescribe());
        }
        startActivityForResult(intent, 54);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h2(View view) {
        GroupInfoItem groupInfoItem = this.M;
        if (groupInfoItem != null) {
            CircleLabelActivity.X1(this, groupInfoItem, 55);
        }
    }

    public final void Q1() {
        if (oc0.f() && oc0.b()) {
            CircleNameModifyActivity.K1(this, this.M);
            return;
        }
        MaterialDialog materialDialogE = new sd3(this).T(R.string.group_name).B(null, null, new e()).f(new d()).a0(R.color.text_color_green).K(R.string.alert_dialog_cancel).e();
        if (!TextUtils.isEmpty(this.M.getGroupName())) {
            materialDialogE.k().setText(this.M.getGroupName());
        }
        materialDialogE.show();
        i2(materialDialogE.k(), 32);
    }

    public final void R1() {
        GroupInfoItem groupInfoItem = this.M;
        ContactInfoItem contactInfoItem = this.N;
        CircleGroupRemarkActivity.G1(this, groupInfoItem, contactInfoItem == null ? "" : contactInfoItem.getRoomRemark(), 53);
    }

    public final void S1() {
        if (l50.a() || this.M == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rid", this.M.getGroupId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String string = jSONObject.toString();
        f fVar = new f(string);
        g gVar = new g(string);
        showBaseProgressBar();
        HashMap map = new HashMap();
        GroupInfoItem groupInfoItem = this.M;
        if (groupInfoItem != null) {
            map.put("roomId", groupInfoItem.getGroupId());
        }
        try {
            new j92(fVar, gVar, map).n();
        } catch (DaoException e3) {
            e3.printStackTrace();
        }
    }

    public final boolean T1() {
        Intent intent = getIntent();
        this.L = intent.getStringExtra(j70.f18338a);
        this.M = (GroupInfoItem) intent.getParcelableExtra("key_group_info");
        this.T = intent.getStringExtra("extra_selected_cate_name");
        this.U = intent.getStringExtra("extra_selected_cate_id");
        GroupInfoItem groupInfoItem = this.M;
        if (groupInfoItem != null) {
            this.L = groupInfoItem.getGroupId();
        }
        return TextUtils.isEmpty(this.L);
    }

    public final void U1() {
        if (this.M == null) {
            c70.R().K(this.L, new dv0() { // from class: w80
                @Override // defpackage.dv0
                public final void onResponse(Object obj) {
                    this.f21635a.X1((GroupInfoItem) obj);
                }
            });
        }
        c70.R().N(this.L, v4.e(this), new dv0() { // from class: n80
            @Override // defpackage.dv0
            public final void onResponse(Object obj) {
                this.f19457a.Y1((ContactInfoItem) obj);
            }
        });
    }

    public final void V1() {
        this.q.setOnClickListener(new View.OnClickListener() { // from class: m80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19158a.a2(view);
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() { // from class: o80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19710a.b2(view);
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() { // from class: p80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19959a.c2(view);
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() { // from class: q80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20200a.d2(view);
            }
        });
        this.z.setOnClickListener(new View.OnClickListener() { // from class: r80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20413a.e2(view);
            }
        });
        this.C.setOnClickListener(new View.OnClickListener() { // from class: s80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20679a.f2(view);
            }
        });
        this.C.setVisibility(8);
        this.F.setOnClickListener(new View.OnClickListener() { // from class: t80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20921a.g2(view);
            }
        });
        this.H.setOnClickListener(new View.OnClickListener() { // from class: u80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21157a.h2(view);
            }
        });
        this.R.setOnClickListener(new View.OnClickListener() { // from class: v80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21380a.Z1(view);
            }
        });
    }

    public final void W1() {
        j2();
        this.q = (LinearLayout) findViewById(R.id.circle_edit_group_name);
        this.r = (TextView) findViewById(R.id.circle_edit_group_name_content);
        this.s = (LinearLayout) findViewById(R.id.circle_edit_group_avatar);
        this.t = (EffectiveShapeView) findViewById(R.id.circle_edit_group_avatar_image);
        this.u = (LinearLayout) findViewById(R.id.circle_edit_group_background);
        this.v = (EffectiveShapeView) findViewById(R.id.circle_edit_group_background_image);
        this.w = (TextView) findViewById(R.id.circle_edit_group_background_content);
        this.x = (LinearLayout) findViewById(R.id.circle_edit_group_location);
        this.y = (TextView) findViewById(R.id.circle_edit_group_location_content);
        this.z = (LinearLayout) findViewById(R.id.circle_edit_group_number);
        this.A = (TextView) findViewById(R.id.circle_edit_group_number_content);
        this.B = (ImageView) findViewById(R.id.circle_edit_group_number_qrcode);
        this.C = (LinearLayout) findViewById(R.id.circle_edit_group_remarks);
        this.E = (TextView) findViewById(R.id.circle_edit_group_remarks_content);
        this.F = (LinearLayout) findViewById(R.id.circle_edit_group_description);
        this.G = (TextView) findViewById(R.id.circle_edit_group_description_content);
        this.R = findViewById(R.id.circle_edit_group_cate);
        this.S = (TextView) findViewById(R.id.circle_edit_group_cate_content);
        this.H = (ViewGroup) findViewById(R.id.circle_edit_group_tags);
        this.J = findViewById(R.id.circle_edit_group_tags_no_setting);
        this.I = (ViewGroup) findViewById(R.id.circle_edit_group_tags_flow);
        List<TextView> list = this.K;
        if (list == null) {
            this.K = new ArrayList();
        } else {
            list.clear();
        }
        this.K.add((TextView) findViewById(R.id.circle_edit_group_tag1));
        this.K.add((TextView) findViewById(R.id.circle_edit_group_tag2));
        this.K.add((TextView) findViewById(R.id.circle_edit_group_tag3));
        this.O = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.circle_detail_default_cover).A(R.drawable.circle_detail_default_cover).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(R.drawable.circle_detail_default_cover).r();
        this.v.setDegreeForRoundRectangle(a46.b(this, 4.0f), a46.b(this, 4.0f));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        if (this.Q) {
            Intent intent = new Intent();
            intent.putExtra("key_group_info", this.M);
            setResult(-1, intent);
        } else {
            setResult(0);
        }
        super.finish();
    }

    public final void i2(EditText editText, int i) {
        editText.addTextChangedListener(new h(editText, i));
    }

    public final void j2() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.settings_item_edit_profile);
        setSupportActionBar(toolbarInitToolbar);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.settings_item_edit_profile);
        ((TextView) toolbarInitToolbar.findViewById(R.id.action_button)).setVisibility(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String[] strArr;
        super.onActivityResult(i, i2, intent);
        if (i == 50 && i2 == -1) {
            String stringExtra = intent.getStringExtra("media_pick_photo_key");
            if (k86.I(stringExtra)) {
                showBaseProgressBar(getString(R.string.settings_uploading), false);
                c70.R().H0(stringExtra, new a());
                return;
            }
            return;
        }
        if (i == 51 && i2 == -1) {
            String stringExtra2 = intent.getStringExtra("media_pick_photo_key");
            if (k86.I(stringExtra2)) {
                showBaseProgressBar(getString(R.string.settings_uploading_cover), false);
                c70.R().H0(stringExtra2, new b());
                return;
            }
            return;
        }
        if (i == 52 && i2 == -1) {
            LocationEx locationEx = (LocationEx) intent.getParcelableExtra("location");
            if (locationEx != null) {
                String address = locationEx.getAddress();
                String name = locationEx.getName();
                showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
                c70.R().x0(this.L, address, name, locationEx.getCoorType(), String.valueOf(locationEx.getLongitude()), String.valueOf(locationEx.getLatitude()), new c(address));
                return;
            }
            return;
        }
        if (i == 53 && intent != null) {
            String stringExtra3 = intent.getStringExtra("key_group_remark");
            if (this.N == null || TextUtils.isEmpty(stringExtra3)) {
                return;
            }
            this.N.setRoomRemark(stringExtra3);
            this.E.setText(this.N.getRoomRemark());
            GroupInfoItem groupInfoItem = this.M;
            if (groupInfoItem != null) {
                groupInfoItem.setRemarkName(stringExtra3);
            }
            this.Q = true;
            return;
        }
        if (i == 54 && i2 == -1) {
            String stringExtra4 = intent.getStringExtra(LxAdDLManager.ITEM_DESC);
            GroupInfoItem groupInfoItem2 = this.M;
            if (groupInfoItem2 != null) {
                groupInfoItem2.setDescribe(stringExtra4);
            }
            updateViews();
            this.Q = true;
            return;
        }
        if (i == 987 && i2 == -1) {
            String stringExtra5 = intent.getStringExtra("circleName");
            GroupInfoItem groupInfoItem3 = this.M;
            if (groupInfoItem3 != null) {
                groupInfoItem3.setGroupName(stringExtra5);
            }
            updateViews();
            this.Q = true;
            return;
        }
        if (i == 55 && i2 == -1) {
            List<RoomTag> listG1 = CircleLabelActivity.G1(intent);
            if (listG1 == null || listG1.isEmpty()) {
                strArr = null;
            } else {
                strArr = new String[listG1.size()];
                for (int i3 = 0; i3 < listG1.size(); i3++) {
                    strArr[i3] = listG1.get(i3).tagName;
                }
            }
            GroupInfoItem groupInfoItem4 = this.M;
            if (groupInfoItem4 != null) {
                groupInfoItem4.setTags(strArr);
            }
            updateViews();
            this.Q = true;
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_edit_detail);
        if (T1()) {
            finish();
            return;
        }
        W1();
        V1();
        U1();
        this.P = new k80(this.L);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_LOCATION) {
            Intent intent = new Intent();
            intent.setClass(this, LocationSelectActivity.class);
            intent.putExtra("enable_map_drag", true);
            startActivityForResult(intent, 52);
            return;
        }
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_AVATAR_IMAGE) {
            Intent intent2 = new Intent(this, (Class<?>) MediaPickActivity.class);
            intent2.putExtra("select_mode_key", 1);
            intent2.putExtra("from", "from_person_info");
            startActivityForResult(intent2, 50);
            return;
        }
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_COVER_IMAGE) {
            Intent intent3 = new Intent(this, (Class<?>) MediaPickActivity.class);
            intent3.putExtra("select_mode_key", 1);
            intent3.putExtra("from", "from_person_info");
            intent3.putExtra("crop_ratio", 2.748f);
            startActivityForResult(intent3, 51);
        }
    }

    public final void updateViews() {
        GroupInfoItem groupInfoItem = this.M;
        if (groupInfoItem != null) {
            if (TextUtils.isEmpty(groupInfoItem.getGroupName())) {
                this.r.setText(R.string.string_no_setting);
            } else {
                this.r.setText(this.M.getGroupName());
            }
            gr2.j().h(this.M.getGroupHeadImgUrl(), this.t, bq6.s());
            if (TextUtils.isEmpty(this.M.getCover())) {
                this.w.setText(R.string.string_no_setting);
                this.w.setVisibility(0);
                this.v.setVisibility(8);
            } else {
                this.w.setVisibility(8);
                this.v.setVisibility(0);
                gr2.j().h(this.M.getCover(), this.v, this.O);
            }
            if (TextUtils.isEmpty(this.M.getPlace())) {
                this.y.setText(R.string.string_no_setting);
            } else {
                this.y.setText(this.M.getPlace());
            }
            if (TextUtils.isEmpty(this.M.getRnumber())) {
                this.A.setText(R.string.string_no_setting);
            } else {
                this.A.setText(this.M.getRnumber());
            }
            if (TextUtils.isEmpty(this.M.getDescribe())) {
                this.G.setText("介绍一下吧，让更多人了解你的群~");
            } else {
                this.G.setText(this.M.getDescribe());
            }
            if (oc0.c()) {
                this.H.setVisibility(0);
                if (this.M.getTags() == null || this.M.getTags().length <= 0) {
                    this.J.setVisibility(0);
                    this.I.setVisibility(8);
                } else {
                    this.J.setVisibility(8);
                    this.I.setVisibility(0);
                    Iterator<TextView> it = this.K.iterator();
                    while (it.hasNext()) {
                        it.next().setVisibility(8);
                    }
                    for (int i = 0; i < Math.min(this.M.getTags().length, this.K.size()); i++) {
                        if (!TextUtils.isEmpty(this.M.getTags()[i])) {
                            this.K.get(i).setVisibility(0);
                            this.K.get(i).setText(this.M.getTags()[i]);
                        }
                    }
                }
            } else {
                this.H.setVisibility(8);
            }
            String cateName = this.M.getCateName();
            if (TextUtils.isEmpty(cateName)) {
                this.S.setText(R.string.string_no_setting);
            } else {
                this.S.setText(cateName);
            }
        }
        ContactInfoItem contactInfoItem = this.N;
        if (contactInfoItem != null) {
            if (TextUtils.isEmpty(contactInfoItem.getRoomRemark())) {
                this.E.setText(R.string.string_no_setting);
            } else {
                this.E.setText(this.N.getRoomRemark());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f13126a;
        public final /* synthetic */ int b;

        public h(EditText editText, int i) {
            this.f13126a = editText;
            this.b = i;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            dt2.d(this.f13126a, charSequence, this.b);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements MaterialDialog.f {
        public e() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.f
        public void a(MaterialDialog materialDialog, CharSequence charSequence) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13123a;

        public f(String str) {
            this.f13123a = str;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            CircleEditDetailActivity.this.hideBaseProgressBar();
            try {
                int i = jSONObject.getInt("resultCode");
                if (i == 0) {
                    LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "1", this.f13123a);
                    if (!oc0.f() || CircleEditDetailActivity.this.M.getRoomType() == 0) {
                        Intent intent = new Intent(CircleEditDetailActivity.this, (Class<?>) GroupQRCodeActivity.class);
                        intent.putExtra(com.umeng.analytics.pro.f.K, CircleEditDetailActivity.this.M);
                        intent.putExtra("extra_qr_data", jSONObject.toString());
                        CircleEditDetailActivity.this.startActivity(intent);
                    } else {
                        Intent intent2 = new Intent(CircleEditDetailActivity.this, (Class<?>) CircleQRCodeActivity.class);
                        intent2.putExtra("key_group_info", CircleEditDetailActivity.this.M);
                        intent2.putExtra("from_source", 2);
                        CircleEditDetailActivity.this.startActivity(intent2);
                    }
                } else if (i == 4022) {
                    LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "2", this.f13123a + "errorMsg:" + jSONObject.optString(MediationConstant.KEY_ERROR_MSG));
                    if (!oc0.f() || CircleEditDetailActivity.this.M.getRoomType() == 0) {
                        Intent intent3 = new Intent(CircleEditDetailActivity.this, (Class<?>) GroupQRCodeActivity.class);
                        intent3.putExtra(com.umeng.analytics.pro.f.K, CircleEditDetailActivity.this.M);
                        intent3.putExtra("extra_qr_data", jSONObject.toString());
                        CircleEditDetailActivity.this.startActivity(intent3);
                    } else {
                        Intent intent4 = new Intent(CircleEditDetailActivity.this, (Class<?>) CircleQRCodeActivity.class);
                        intent4.putExtra("key_group_info", CircleEditDetailActivity.this.M);
                        intent4.putExtra("from_source", 2);
                        CircleEditDetailActivity.this.startActivity(intent4);
                    }
                } else if (i == 4031 || i == 4036) {
                    de2.a(CircleEditDetailActivity.this, GroupModifyResultVo.buildFromJsonObject(jSONObject), CircleEditDetailActivity.this.M.getGroupId(), new a());
                } else {
                    sy5.e(CircleEditDetailActivity.this, R.string.send_failed, 0).g();
                    String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                    LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "2", this.f13123a + "errorMsg:" + strOptString);
                }
            } catch (JSONException e) {
                LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "5201", "1", "2", this.f13123a + "JSONException");
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
