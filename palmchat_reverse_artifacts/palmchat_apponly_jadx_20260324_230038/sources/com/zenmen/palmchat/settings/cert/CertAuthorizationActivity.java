package com.zenmen.palmchat.settings.cert;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.e00;
import defpackage.l50;
import defpackage.sy5;
import defpackage.tj2;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CertAuthorizationActivity extends BaseActionBarActivity {
    public Toolbar q;
    public TextView r;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            SPUtil.f14322a.t(SPUtil.SCENE.CERT, "key_cert_has_authorization", Boolean.TRUE);
            CertAuthorizationActivity.this.C1();
            e00.a("authentication_authorization_confirm_click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e00.a("authentication_authorization_back_click");
            CertAuthorizationActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends d {
        public final /* synthetic */ URLSpan b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Activity activity, URLSpan uRLSpan) {
            super(activity);
            this.b = uRLSpan;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Activity activityA = a();
            if (activityA == null || this.b.getURL() == null) {
                return;
            }
            CertAuthorizationActivity.G1(activityA, tj2.d());
            e00.a("authentication_authorization_document_click");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            LogUtil.i(BaseActionBarActivity.TAG, "updateDrawState");
            textPaint.setColor(Color.parseColor("#2B94FA"));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class d extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<Activity> f15283a;

        public d(Activity activity) {
            this.f15283a = new WeakReference<>(activity);
        }

        public Activity a() {
            return this.f15283a.get();
        }
    }

    public static SpannableStringBuilder D1(Activity activity) {
        String string = activity.getResources().getString(R.string.string_cert_authorization_agreenment_text);
        Spanned spannedFromHtml = Html.fromHtml(activity.getResources().getString(R.string.string_cert_authorization_desc).replaceAll(string, "<a href='agreement'>" + string + "</a>"));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
        try {
            for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spannedFromHtml.length(), URLSpan.class)) {
                spannableStringBuilder.setSpan(new c(activity, uRLSpan), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
                spannableStringBuilder.removeSpan(uRLSpan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spannableStringBuilder;
    }

    public static void G1(Activity activity, String str) {
        LogUtil.onEvent("903", null, null, null);
        Intent intent = new Intent();
        intent.setClass(activity, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        intent.putExtra("needCheckAccount", false);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public final void C1() {
        BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.CAMERA, BaseActivityPermissionDispatcher.PermissionUsage.PEOPLE_MATCH_CAMERA);
    }

    public final void E1() {
        Toolbar toolbarInitToolbar = initToolbar("", false);
        this.q = toolbarInitToolbar;
        toolbarInitToolbar.setBackgroundResource(R.color.color_trans);
        Toolbar toolbar = this.q;
        toolbar.setPadding(0, toolbar.getPaddingTop(), 0, 0);
        setSupportActionBar(this.q);
        findViewById(R.id.back).setOnClickListener(new b());
    }

    public final void F1() {
        E1();
        TextView textView = (TextView) findViewById(R.id.cert_authorization_agreement);
        this.r = textView;
        textView.setText(D1(this));
        this.r.setMovementMethod(LinkMovementMethod.getInstance());
        this.r.setHighlightColor(getResources().getColor(android.R.color.transparent));
        findViewById(R.id.cert_authorization_to_cert).setOnClickListener(new a());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cert_authorization);
        e00.a("authentication_authorization_show");
        F1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        sy5.f(AppContext.getContext(), "请在手机“设置-应用-连信-权限”中开启相机权限。开启后，可以实时帮你完成认证操作。", 1).g();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        finish();
    }
}
