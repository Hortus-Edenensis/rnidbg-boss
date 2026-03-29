package com.zenmen.palmchat.circle.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.widget.ClearEditText;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.bq6;
import defpackage.c70;
import defpackage.gr2;
import defpackage.hx3;
import defpackage.k80;
import defpackage.sy5;
import defpackage.wi0;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleGroupRemarkActivity extends BaseActionBarActivity {
    public final int q = 32;
    public ClearEditText r;
    public TextView s;
    public ImageView t;
    public GroupInfoItem u;
    public String v;
    public k80 w;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleGroupRemarkActivity.this.H1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13171a;

        public c(String str) {
            this.f13171a = str;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleGroupRemarkActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() == 0) {
                c70.R().C0(false, new String[0]);
                Intent intent = new Intent();
                intent.putExtra("key_group_remark", this.f13171a);
                CircleGroupRemarkActivity.this.setResult(-1, intent);
                CircleGroupRemarkActivity.this.finish();
                return;
            }
            if (CircleGroupRemarkActivity.this.w.d(CircleGroupRemarkActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                return;
            }
            if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                sy5.e(CircleGroupRemarkActivity.this, R.string.send_failed, 0).g();
            } else {
                sy5.f(CircleGroupRemarkActivity.this, baseResponse.getErrorMsg(), 0).g();
            }
        }
    }

    public static void G1(Activity activity, GroupInfoItem groupInfoItem, String str, int i) {
        Intent intent = new Intent(activity, (Class<?>) CircleGroupRemarkActivity.class);
        intent.putExtra("key_group_info", groupInfoItem);
        intent.putExtra("key_group_remark_info", str);
        activity.startActivityForResult(intent, i);
    }

    public final void D1() {
        Intent intent = getIntent();
        this.u = (GroupInfoItem) intent.getParcelableExtra("key_group_info");
        this.v = intent.getStringExtra("key_group_remark_info");
        updateViews();
    }

    public final void E1() {
        this.s = (TextView) findViewById(R.id.tv_save);
        this.t = (ImageView) findViewById(R.id.iv_head);
        ClearEditText clearEditText = (ClearEditText) findViewById(R.id.edit);
        this.r = clearEditText;
        KeyboardKt.a(clearEditText, this, Keyboard$SHOW_FLAG.IMPLICIT, 200L);
        this.r.setClearDrawable(R.drawable.ic_edittext_clear_gray, R.drawable.ic_edittext_clear_gray);
        this.r.addTextChangedListener(new a());
        this.s.setOnClickListener(new b());
    }

    public final void F1() {
        setSupportActionBar(initToolbar(R.string.group_anthor_name));
    }

    public final void H1() {
        if (!hx3.m(this)) {
            sy5.h(this, getString(R.string.network_error), 0);
            return;
        }
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        String string = this.r.getText().toString();
        c70.R().y0(this.u.getGroupId(), string, new c(string));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_group_remark);
        F1();
        E1();
        D1();
        this.w = new k80(this.u);
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
        GroupInfoItem groupInfoItem = this.u;
        if (groupInfoItem != null && !TextUtils.isEmpty(groupInfoItem.getGroupHeadImgUrl())) {
            gr2.j().h(this.u.getGroupHeadImgUrl(), this.t, bq6.s());
        }
        if (!TextUtils.isEmpty(this.v)) {
            this.r.setText(this.v);
        }
        GroupInfoItem groupInfoItem2 = this.u;
        if (groupInfoItem2 == null || TextUtils.isEmpty(groupInfoItem2.getRemarkName())) {
            return;
        }
        this.r.setText(this.u.getRemarkName());
        ClearEditText clearEditText = this.r;
        clearEditText.setSelection(clearEditText.getText().length());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int length;
            String string = CircleGroupRemarkActivity.this.r.getText().toString();
            if (string != null) {
                try {
                    length = string.getBytes("GBK").length;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    length = 0;
                }
            } else {
                length = 0;
            }
            if (length > 32) {
                char[] charArray = string.toCharArray();
                StringBuilder sb = new StringBuilder();
                int length2 = 0;
                for (char c : charArray) {
                    try {
                        length2 += String.valueOf(c).getBytes("GBK").length;
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                    if (length2 > 32) {
                        break;
                    }
                    sb.append(c);
                }
                CircleGroupRemarkActivity.this.r.setText(sb);
                Selection.setSelection(CircleGroupRemarkActivity.this.r.getEditableText(), sb.length());
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
