package com.zenmen.palmchat.circle.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.circle.bean.CircleTagItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationSelectActivity;
import com.zenmen.palmchat.widget.TagContainerLayout;
import defpackage.bq6;
import defpackage.c70;
import defpackage.dt2;
import defpackage.dv0;
import defpackage.gr2;
import defpackage.j56;
import defpackage.j70;
import defpackage.je1;
import defpackage.k86;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.wi0;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Deprecated
public class CircleEditDetailActivityOld extends BaseActionBarActivity {
    public TextView A;
    public TagContainerLayout B;
    public TextView C;
    public View E;
    public String F;
    public GroupInfoItem G;
    public TextView q;
    public ImageView r;
    public ImageView s;
    public ImageView t;
    public ImageView u;
    public TextView v;
    public ImageView w;
    public TextView x;
    public ImageView y;
    public TextView z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements j56 {

        /* JADX INFO: renamed from: com.zenmen.palmchat.circle.ui.CircleEditDetailActivityOld$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1013a extends wi0<BaseResponse> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13128a;

            public C1013a(String str) {
                this.f13128a = str;
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                CircleEditDetailActivityOld.this.hideBaseProgressBar();
                c70.R().C0(false, new String[0]);
                if (baseResponse.getResultCode() == 0) {
                    sy5.e(CircleEditDetailActivityOld.this, R.string.circle_avatar_upload_success, 0).g();
                    CircleEditDetailActivityOld.this.G.setCover(this.f13128a);
                    CircleEditDetailActivityOld.this.updateViews();
                } else if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleEditDetailActivityOld.this, R.string.circle_avatar_upload_fail, 0).g();
                } else {
                    sy5.f(CircleEditDetailActivityOld.this, baseResponse.getErrorMsg(), 0).g();
                }
            }
        }

        public a() {
        }

        @Override // defpackage.j56
        public void onFailed(Throwable th) {
            CircleEditDetailActivityOld.this.hideBaseProgressBar();
            sy5.e(CircleEditDetailActivityOld.this, R.string.circle_avatar_upload_fail, 0).g();
        }

        @Override // defpackage.j56
        public void onSuccess(String str, String str2) {
            c70.R().t0(CircleEditDetailActivityOld.this.F, str2, new C1013a(str));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13129a;

        public b(String str) {
            this.f13129a = str;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleEditDetailActivityOld.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() != 0) {
                sy5.e(CircleEditDetailActivityOld.this, R.string.send_failed, 0).g();
                return;
            }
            c70.R().C0(false, new String[0]);
            CircleEditDetailActivityOld.this.G.setPlace(this.f13129a);
            CircleEditDetailActivityOld.this.updateViews();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13131a;

            public a(String str) {
                this.f13131a = str;
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                CircleEditDetailActivityOld.this.hideBaseProgressBar();
                if (baseResponse.getResultCode() == 0) {
                    CircleEditDetailActivityOld.this.G.setGroupName(this.f13131a);
                    CircleEditDetailActivityOld.this.updateViews();
                    c70.R().C0(false, new String[0]);
                }
            }
        }

        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            String string = materialDialog.k().getText().toString();
            if (string.equals(CircleEditDetailActivityOld.this.G.getGroupName())) {
                return;
            }
            if (!dt2.a(string)) {
                sy5.e(AppContext.getContext(), R.string.group_name_empty_alert, 0).g();
            } else {
                c70.R().v0(CircleEditDetailActivityOld.this.F, string, new a(string));
                CircleEditDetailActivityOld.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleEditDetailActivityOld.this.G1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(CircleEditDetailActivityOld.this, CircleEditDescActivity.class);
            intent.putExtra(j70.f18338a, CircleEditDetailActivityOld.this.F);
            CircleEditDetailActivityOld.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(CircleEditDetailActivityOld.this, (Class<?>) MediaPickActivity.class);
            intent.putExtra("select_mode_key", 1);
            intent.putExtra("from", "from_person_info");
            CircleEditDetailActivityOld.this.startActivityForResult(intent, 50);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(CircleEditDetailActivityOld.this, (Class<?>) MediaPickActivity.class);
            intent.putExtra("select_mode_key", 1);
            intent.putExtra("from", "from_person_info");
            CircleEditDetailActivityOld.this.startActivityForResult(intent, 51);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(CircleEditDetailActivityOld.this, LocationSelectActivity.class);
            intent.putExtra("enable_map_drag", true);
            CircleEditDetailActivityOld.this.startActivityForResult(intent, 52);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(CircleEditDetailActivityOld.this, (Class<?>) CircleCateSelectActivity.class);
            intent.putExtra("extra_room_id", CircleEditDetailActivityOld.this.F);
            intent.putExtra("extra_selected_cate_name", CircleEditDetailActivityOld.this.A.getText());
            intent.putExtra("extra_selected_cate_id", "");
            intent.putExtra("extra_from", 1);
            CircleEditDetailActivityOld.this.startActivityForResult(intent, 53);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(CircleEditDetailActivityOld.this, (Class<?>) CircleSelectTagActivity.class);
            intent.putExtra(j70.f18338a, CircleEditDetailActivityOld.this.F);
            CircleEditDetailActivityOld.this.startActivityForResult(intent, 54);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleEditDetailActivityOld.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements j56 {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13143a;

            public a(String str) {
                this.f13143a = str;
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                CircleEditDetailActivityOld.this.hideBaseProgressBar();
                c70.R().C0(false, new String[0]);
                if (baseResponse.getResultCode() == 0) {
                    sy5.e(CircleEditDetailActivityOld.this, R.string.circle_avatar_upload_success, 0).g();
                    CircleEditDetailActivityOld.this.G.setGroupHeadImgUrl(this.f13143a);
                    CircleEditDetailActivityOld.this.updateViews();
                } else if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleEditDetailActivityOld.this, R.string.circle_avatar_upload_fail, 0).g();
                } else {
                    sy5.f(CircleEditDetailActivityOld.this, baseResponse.getErrorMsg(), 0).g();
                }
            }
        }

        public n() {
        }

        @Override // defpackage.j56
        public void onFailed(Throwable th) {
            CircleEditDetailActivityOld.this.hideBaseProgressBar();
            sy5.e(CircleEditDetailActivityOld.this, R.string.circle_avatar_upload_fail, 0).g();
        }

        @Override // defpackage.j56
        public void onSuccess(String str, String str2) {
            c70.R().s0(CircleEditDetailActivityOld.this.F, str2, new a(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H1(GroupInfoItem groupInfoItem) {
        if (groupInfoItem == null) {
            return;
        }
        this.G = groupInfoItem;
        updateViews();
    }

    public final void G1() {
        MaterialDialog materialDialogE = new sd3(this).T(R.string.group_name).B(null, null, new d()).f(new c()).a0(R.color.text_color_green).K(R.string.alert_dialog_cancel).e();
        if (!TextUtils.isEmpty(this.G.getGroupName())) {
            materialDialogE.k().setText(this.G.getGroupName());
        }
        materialDialogE.show();
        I1(materialDialogE.k(), 32);
    }

    public final void I1(EditText editText, int i2) {
        editText.addTextChangedListener(new e(editText, i2));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String[] strArr;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 50 && i3 == -1) {
            String stringExtra = intent.getStringExtra("media_pick_photo_key");
            if (k86.I(stringExtra)) {
                showBaseProgressBar(getString(R.string.settings_uploading), false);
                c70.R().H0(stringExtra, new n());
                return;
            }
            return;
        }
        if (i2 == 51 && i3 == -1) {
            String stringExtra2 = intent.getStringExtra("media_pick_photo_key");
            if (k86.I(stringExtra2)) {
                showBaseProgressBar(getString(R.string.settings_uploading), false);
                c70.R().H0(stringExtra2, new a());
                return;
            }
            return;
        }
        if (i2 == 52 && i3 == -1) {
            LocationEx locationEx = (LocationEx) intent.getParcelableExtra("location");
            if (locationEx != null) {
                String address = locationEx.getAddress();
                if (address.length() > 15) {
                    address = address.substring(0, 12) + "...";
                }
                String str = address;
                showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
                c70.R().w0(this.F, str, locationEx.getCoorType(), String.valueOf(locationEx.getLongitude()), String.valueOf(locationEx.getLatitude()), new b(str));
                return;
            }
            return;
        }
        if (i3 == -1 && 53 == i2) {
            if (intent == null || !intent.hasExtra("cateName")) {
                return;
            }
            this.G.setCateName(intent.getStringExtra("cateName"));
            updateViews();
            return;
        }
        if (i3 == -1 && 55 == i2) {
            if (intent == null || !intent.hasExtra(LxAdDLManager.ITEM_DESC)) {
                return;
            }
            this.G.setDescribe(intent.getStringExtra(LxAdDLManager.ITEM_DESC));
            updateViews();
            return;
        }
        if (i3 == -1 && 54 == i2 && intent != null && intent.hasExtra("circle_tag_list")) {
            ArrayList arrayList = (ArrayList) intent.getSerializableExtra("circle_tag_list");
            if (arrayList != null) {
                int size = arrayList.size();
                strArr = new String[size];
                for (int i4 = 0; i4 < size; i4++) {
                    strArr[i4] = ((CircleTagItem) arrayList.get(i4)).getTagName();
                }
            } else {
                strArr = null;
            }
            this.G.setTagNames(strArr);
            updateViews();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_edit_detail_old);
        setSupportActionBar(initToolbar("编辑群资料"));
        String stringExtra = getIntent().getStringExtra(j70.f18338a);
        this.F = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        this.q = (TextView) findViewById(R.id.circle_edit_detail_name);
        this.r = (ImageView) findViewById(R.id.circle_edit_detail_name_status);
        findViewById(R.id.layout_circle_edit_groupname).setOnClickListener(new f());
        this.x = (TextView) findViewById(R.id.circle_edit_detail_desc);
        this.y = (ImageView) findViewById(R.id.circle_edit_detail_desc_status);
        findViewById(R.id.layout_circle_edit_groupdesc).setOnClickListener(new g());
        this.s = (ImageView) findViewById(R.id.circle_edit_detail_head);
        this.t = (ImageView) findViewById(R.id.circle_edit_detail_head_status);
        findViewById(R.id.layout_circle_edit_groupicon).setOnClickListener(new h());
        this.u = (ImageView) findViewById(R.id.circle_edit_detail_cover);
        this.v = (TextView) findViewById(R.id.circle_edit_detail_cover_empty);
        this.w = (ImageView) findViewById(R.id.circle_edit_detail_cover_status);
        findViewById(R.id.layout_circle_edit_groupcover).setOnClickListener(new i());
        this.z = (TextView) findViewById(R.id.circle_edit_detail_loc);
        findViewById(R.id.layout_circle_edit_grouploc).setOnClickListener(new j());
        this.A = (TextView) findViewById(R.id.circle_edit_detail_category);
        findViewById(R.id.layout_circle_edit_groupcatogery).setOnClickListener(new k());
        View viewFindViewById = findViewById(R.id.layout_circle_edit_grouptag);
        this.B = (TagContainerLayout) findViewById(R.id.circle_edit_detail_tag);
        this.C = (TextView) findViewById(R.id.circle_edit_detail_tag_empty);
        viewFindViewById.setOnClickListener(new l());
        View viewFindViewById2 = findViewById(R.id.circle_eidt_detail_finish);
        this.E = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new m());
        c70.R().K(this.F, new dv0() { // from class: x80
            @Override // defpackage.dv0
            public final void onResponse(Object obj) {
                this.f21900a.H1((GroupInfoItem) obj);
            }
        });
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null || !intent.hasExtra("cateName")) {
            return;
        }
        String stringExtra = intent.getStringExtra("cateName");
        intent.getStringExtra("cateId");
        this.A.setText(stringExtra);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public final void updateViews() {
        GroupInfoItem groupInfoItem = this.G;
        if (groupInfoItem == null) {
            return;
        }
        if (TextUtils.isEmpty(groupInfoItem.getGroupName())) {
            this.q.setText("未设置");
        } else {
            this.q.setText(this.G.getGroupName());
        }
        gr2.j().h(this.G.getGroupHeadImgUrl(), this.s, bq6.s());
        if (TextUtils.isEmpty(this.G.getCover())) {
            this.v.setText("未设置");
            this.v.setVisibility(0);
            this.u.setVisibility(8);
        } else {
            this.v.setVisibility(8);
            this.u.setVisibility(0);
            gr2.j().h(this.G.getCover(), this.u, new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.circle_detail_default_cover).A(R.drawable.circle_detail_default_cover).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(R.drawable.circle_detail_default_cover).r());
        }
        if (TextUtils.isEmpty(this.G.getPlace())) {
            this.z.setText("未设置");
        } else {
            this.z.setText(this.G.getPlace());
        }
        if (TextUtils.isEmpty(this.G.getCateForShow())) {
            this.A.setText(R.string.not_set);
        } else {
            this.A.setText(this.G.getCateForShow());
        }
        if (this.G.getTagNames() == null || this.G.getTagNames().length <= 0) {
            this.C.setText(R.string.not_set);
            this.C.setVisibility(0);
            this.B.setVisibility(8);
        } else {
            this.C.setVisibility(8);
            this.B.setVisibility(0);
            this.B.setTags(this.G.getTagNames());
        }
        if (!TextUtils.isEmpty(this.G.getDescribe())) {
            this.x.setText(this.G.getDescribe());
        } else {
            this.x.setText(this.G.getDescribe());
            this.x.setText("介绍一下吧，让更多人了解你的群~");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f13133a;
        public final /* synthetic */ int b;

        public e(EditText editText, int i) {
            this.f13133a = editText;
            this.b = i;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            dt2.d(this.f13133a, charSequence, this.b);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements MaterialDialog.f {
        public d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.f
        public void a(MaterialDialog materialDialog, CharSequence charSequence) {
        }
    }
}
