package com.zenmen.palmchat.expression;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.widget.AutoResizeGifImageView;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.is0;
import defpackage.jr2;
import defpackage.k86;
import defpackage.mt2;
import defpackage.ot1;
import defpackage.pu1;
import defpackage.rb3;
import defpackage.sd1;
import defpackage.sy5;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ExpressionDetailActivity extends BaseActionBarActivity {
    public AutoResizeGifImageView q;
    public Toolbar s;
    public MessageVo r = null;
    public boolean t = false;
    public String u = null;
    public is0.f v = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class c implements is0.f {
        public c() {
        }

        @Override // is0.f
        public void onItemClicked(int i) throws Throwable {
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                ExpressionDetailActivity.this.K1();
            } else if (ExpressionDetailActivity.this.t) {
                ExpressionDetailActivity.this.G1();
            } else {
                sy5.e(ExpressionDetailActivity.this, R.string.downloading_before_forward, 0).g();
            }
        }
    }

    public final void G1() {
        Intent intent = new Intent();
        intent.setClass(this, SendMessageActivity.class);
        intent.putExtra("message_vo", this.r);
        startActivity(intent);
    }

    public final void H1() {
        Toolbar toolbarInitToolbar = initToolbar("");
        this.s = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void I1() {
        AutoResizeGifImageView autoResizeGifImageView = (AutoResizeGifImageView) findViewById(R.id.image);
        this.q = autoResizeGifImageView;
        MessageVo messageVo = this.r;
        if (messageVo == null) {
            finish();
            return;
        }
        if (messageVo.data4 != null) {
            autoResizeGifImageView.setShowOriginSize(true);
            this.q.setDisplaySize(ChatterAdapter.R(this.r.data4), ChatterAdapter.M(this.r.data4));
        }
        if (!TextUtils.isEmpty(this.r.data1) && new File(this.r.data1).exists()) {
            this.t = true;
        }
        if (this.t) {
            this.u = this.r.data1;
        } else {
            String strF = com.zenmen.palmchat.expression.a.f(this.r);
            if (!TextUtils.isEmpty(strF)) {
                File fileB = sd1.b(strF);
                if (fileB == null || !fileB.exists()) {
                    this.t = false;
                    gr2.j().i(strF, this.q, bq6.j(), new a(strF));
                } else {
                    this.u = fileB.getAbsolutePath();
                    this.t = true;
                }
            }
        }
        if (!this.t) {
            this.q.setRatio(1.0f);
            this.q.setImageResource(R.drawable.icon_express_detail_expired);
        } else {
            try {
                this.q.setImageDrawable(new pl.droidsonroids.gif.a(this.u));
            } catch (IOException unused) {
                gr2.j().i(k86.p(this.u), this.q, bq6.d(false), new b());
            }
        }
    }

    public final void J1() {
        this.r = (MessageVo) getIntent().getParcelableExtra("messageVo");
    }

    public final void K1() throws Throwable {
        String string = getString(R.string.string_add_expression_fail);
        if (this.t) {
            try {
                String str = pu1.k + File.separator + System.currentTimeMillis();
                File fileC = pu1.c(str);
                pu1.f(new File(this.u), fileC);
                ExpressionObject expressionObject = new ExpressionObject();
                expressionObject.path = str;
                expressionObject.coverPath = str;
                expressionObject.md5 = rb3.b(fileC);
                ot1.b(expressionObject);
                string = getString(R.string.string_add_expression_success);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        sy5.f(this, string, 0).g();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_expression_detail);
        J1();
        H1();
        I1();
        mt2.a(this, null);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user_info_detail, menu);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.menu_more) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (ot1.c(this.r.data4)) {
            showPopupMenu(this, this.s, new String[]{AppContext.getContext().getResources().getString(R.string.string_forward), AppContext.getContext().getResources().getString(R.string.string_add_expression)}, null, this.v, null);
        } else {
            showPopupMenu(this, this.s, new String[]{AppContext.getContext().getResources().getString(R.string.string_forward)}, null, this.v, null);
        }
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13928a;

        public a(String str) {
            this.f13928a = str;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            File fileB = sd1.b(this.f13928a);
            if (fileB == null || !fileB.exists()) {
                return;
            }
            String absolutePath = fileB.getAbsolutePath();
            ExpressionDetailActivity.this.t = true;
            ExpressionDetailActivity.this.u = fileB.getAbsolutePath();
            try {
                ExpressionDetailActivity.this.q.setImageDrawable(new pl.droidsonroids.gif.a(absolutePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements jr2 {
        public b() {
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }
}
