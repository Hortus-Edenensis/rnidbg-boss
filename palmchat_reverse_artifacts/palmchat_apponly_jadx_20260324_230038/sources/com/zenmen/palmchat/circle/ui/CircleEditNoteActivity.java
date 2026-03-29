package com.zenmen.palmchat.circle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.widget.ZXCheckBox;
import defpackage.ag5;
import defpackage.bo0;
import defpackage.c70;
import defpackage.cb0;
import defpackage.hc2;
import defpackage.j56;
import defpackage.j70;
import defpackage.k80;
import defpackage.k86;
import defpackage.l50;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.wi0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleEditNoteActivity extends BaseActionBarActivity {
    public String A;
    public k80 B;
    public Toolbar r;
    public TextView s;
    public EditText t;
    public ImageView u;
    public TextView v;
    public CheckBox w;
    public CircleNoticeItem x;
    public final int q = 1;
    public boolean y = false;
    public boolean z = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ZXCheckBox.a {
        public a() {
        }

        @Override // com.zenmen.palmchat.widget.ZXCheckBox.a
        public void b(CompoundButton compoundButton, boolean z, boolean z2) {
            CircleEditNoteActivity.this.z = true;
            CircleEditNoteActivity.this.updateViews();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(CircleEditNoteActivity.this, (Class<?>) MediaPickActivity.class);
            intent.putExtra("select_mode_key", 1);
            intent.putExtra("from", "from_person_info");
            CircleEditNoteActivity.this.startActivityForResult(intent, 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (k86.I(CircleEditNoteActivity.this.A)) {
                CircleEditNoteActivity.this.K1();
            } else {
                CircleEditNoteActivity.this.J1(null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements j56 {
        public e() {
        }

        @Override // defpackage.j56
        public void onFailed(Throwable th) {
            CircleEditNoteActivity.this.hideBaseProgressBar();
            sy5.e(CircleEditNoteActivity.this, R.string.send_failed, 0).g();
        }

        @Override // defpackage.j56
        public void onSuccess(String str, String str2) {
            CircleEditNoteActivity.this.J1(str2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends wi0<BaseResponse<Long>> {
        public f() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<Long> baseResponse) {
            CircleEditNoteActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() != 0) {
                if (CircleEditNoteActivity.this.B.d(CircleEditNoteActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleEditNoteActivity.this, R.string.send_failed, 0).g();
                    return;
                } else {
                    sy5.f(CircleEditNoteActivity.this, baseResponse.getErrorMsg(), 0).g();
                    return;
                }
            }
            c70.R().C0(false, new String[0]);
            CircleEditNoteActivity.this.x.setNoticeId(baseResponse.getData().longValue());
            CircleEditNoteActivity.this.x.setContent(CircleEditNoteActivity.this.t.getText().toString());
            CircleEditNoteActivity.this.x.setMediaType(1);
            if (!TextUtils.isEmpty(CircleEditNoteActivity.this.A)) {
                CircleEditNoteActivity.this.x.setMediaUrl(CircleEditNoteActivity.this.A);
            }
            CircleEditNoteActivity.this.x.setConfirm(CircleEditNoteActivity.this.w.isChecked() ? 1 : 0);
            CircleEditNoteActivity.this.x.setReleaseTime(System.currentTimeMillis());
            Intent intent = new Intent();
            intent.putExtra(j70.f, CircleEditNoteActivity.this.x);
            CircleEditNoteActivity.this.setResult(-1, intent);
            CircleEditNoteActivity.this.finish();
        }
    }

    public final void J1(String str) {
        if (this.t.getText().length() > 2000) {
            new sd3(this).k("群公告字数太多，请重新编辑。").O(R.string.circle_ok).Q();
            return;
        }
        showBaseProgressBar();
        cb0 cb0VarC = cb0.c();
        String rid = this.x.getRid();
        String string = this.t.getText().toString();
        boolean zIsChecked = this.w.isChecked();
        cb0VarC.a(rid, string, 1, str, zIsChecked ? 1 : 0, 0, 1, new f());
    }

    public final void K1() {
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        c70.R().H0(this.A, new e());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("media_pick_photo_key");
            this.A = stringExtra;
            if (k86.I(stringExtra)) {
                this.z = true;
            }
            updateViews();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_edit_note);
        ag5.f(this);
        Toolbar toolbarInitToolbar = initToolbar("");
        this.r = toolbarInitToolbar;
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText("编辑群公告");
        setSupportActionBar(this.r);
        TextView textView = (TextView) this.r.findViewById(R.id.action_button);
        this.s = textView;
        textView.setText(R.string.circle_publish);
        this.t = (EditText) findViewById(R.id.circle_edit_note_input);
        this.v = (TextView) findViewById(R.id.circle_edit_note_count);
        this.u = (ImageView) findViewById(R.id.circle_edit_note_img);
        this.w = (CheckBox) findViewById(R.id.circle_edit_note_confirm);
        CircleNoticeItem circleNoticeItem = (CircleNoticeItem) getIntent().getParcelableExtra(j70.f);
        this.x = circleNoticeItem;
        if (circleNoticeItem == null) {
            String stringExtra = getIntent().getStringExtra(j70.f18338a);
            if (TextUtils.isEmpty(stringExtra)) {
                finish();
                return;
            }
            this.y = true;
            CircleNoticeItem circleNoticeItem2 = new CircleNoticeItem();
            this.x = circleNoticeItem2;
            circleNoticeItem2.setRid(stringExtra);
            this.x.setConfirm(0);
            this.x.setToTop(0);
            this.x.setTopChatWindow(0);
            String strP = AccountUtils.p(AppContext.getContext());
            ContactInfoItem contactInfoItemL = bo0.r().l(strP);
            if (contactInfoItemL != null) {
                this.x.setAuthorId(strP);
                this.x.setAuthorNickname(contactInfoItemL.getNickName());
            }
        }
        this.w.setChecked(this.x.getConfirm() == 1);
        this.t.setText(this.x.getContent());
        EditText editText = this.t;
        editText.setSelection(editText.getText().length());
        this.w.setOnCheckedChangeListener(new a());
        this.t.addTextChangedListener(new b());
        this.u.setOnClickListener(new c());
        this.s.setOnClickListener(new d());
        updateViews();
        this.B = new k80(getIntent().getStringExtra(j70.f18338a));
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
        if (this.x == null) {
            return;
        }
        int length = this.t.getText().length();
        if (length > 2000) {
            this.v.setText(Html.fromHtml("<font color='#FFF4B14'>" + length + "</font>/2000"));
        } else {
            this.v.setText(length + "/2000");
        }
        String mediaUrl = k86.I(this.A) ? this.A : (this.x.getMediaType() != 1 || TextUtils.isEmpty(this.x.getMediaUrl())) ? null : this.x.getMediaUrl();
        if (TextUtils.isEmpty(mediaUrl)) {
            this.u.setImageResource(R.drawable.circle_add_pic);
        } else {
            hc2.b(this).load(mediaUrl).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(this.u);
        }
        if (!this.z || (TextUtils.isEmpty(this.t.getText()) && TextUtils.isEmpty(mediaUrl))) {
            this.s.setEnabled(false);
        } else {
            this.s.setEnabled(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CircleEditNoteActivity.this.z = true;
            CircleEditNoteActivity.this.updateViews();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
