package com.zenmen.palmchat.publish;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.friendcircle.R$string;
import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponse;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.i9;
import defpackage.sd3;
import defpackage.tq3;
import defpackage.uq3;
import defpackage.yy2;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CommentActivity extends FrameworkBaseActivity {
    public EditText q;
    public TextView r;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommentActivity.this.G1();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(az.at, 3);
                jSONObject.put("type", 1);
            } catch (Exception unused) {
            }
            LogUtil.uploadInfoImmediate("M243", "1", null, jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements FeedNetDao.FeedNetListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        public c() {
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onFail(Exception exc) {
            CommentActivity.this.hideBaseProgressBar();
            uq3.a(CommentActivity.this);
            Log.d(FrameworkBaseActivity.TAG, "publishComment fail, error is " + exc.toString());
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
            CommentActivity.this.hideBaseProgressBar();
            if (yy2Var.f22300a) {
                tq3.e().j(netResponse.data);
                CommentActivity.this.finish();
                return;
            }
            LogUtil.i(FrameworkBaseActivity.TAG, "publishComment fail, resultCode is " + netResponse.resultCode);
            if (netResponse.resultCode == 1913) {
                new sd3(CommentActivity.this).j(R$string.feed_content_delete_error).O(R$string.string_publish_text_overflow_dialog_positive).f(new a()).e().show();
            } else {
                uq3.a(CommentActivity.this);
            }
        }
    }

    public final void D1() {
        initToolbar(R$id.toolbar, "", true);
        TextView textView = (TextView) getToolbar().findViewById(R$id.action_button);
        this.r = textView;
        textView.setText(R$string.media_pick_activity_send);
        ((TextView) getToolbar().findViewById(R$id.title)).setText("评论");
        this.r.setEnabled(false);
        this.r.setOnClickListener(new b());
    }

    public final void E1() {
        setContentView(R$layout.activity_comment);
        D1();
        EditText editText = (EditText) findViewById(R$id.edt_comment);
        this.q = editText;
        editText.setFocusable(true);
        this.q.addTextChangedListener(new a());
        KeyboardKt.e(this.q, Keyboard$SHOW_FLAG.DEFAULT, 200L);
    }

    public final boolean F1(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (cCharAt == ' ' || cCharAt == '\t' || cCharAt == '\n') {
                    i++;
                }
            }
            if (i < length) {
                return true;
            }
        }
        return false;
    }

    public final void G1() {
        String string = this.q.getText().toString();
        FeedBean feedBean = (FeedBean) getIntent().getParcelableExtra("extra_feed_bean");
        Feed feedE = i9.d().e(feedBean.getUid(), feedBean.getFeedId());
        if (feedE == null) {
            return;
        }
        showBaseProgressBar();
        FeedNetDao.publishComment(feedE.getFeedId(), 1, feedE.getUid(), null, 0L, string, feedE.getFeedSource(), feedE.getAdvId(), 0, 0, new c());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        E1();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (CommentActivity.this.F1(charSequence.toString())) {
                CommentActivity.this.r.setEnabled(true);
            } else {
                CommentActivity.this.r.setEnabled(false);
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
