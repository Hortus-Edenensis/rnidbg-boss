package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class zm4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f22448a = false;
    public static int b = 123;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends h {
        @Override // zm4.h
        public void a(Dialog dialog) {
            super.a(dialog);
            dialog.dismiss();
            LogUtil.uploadInfoImmediate("res242", "1", null, x63.f());
            zn6.d("lx_client_login_res242", null, x63.f());
        }

        @Override // zm4.h
        public void b(Dialog dialog) {
            super.b(dialog);
            LogUtil.uploadInfoImmediate("res241", "1", null, x63.f());
            zn6.d("lx_client_login_res241", null, x63.f());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends i {
        public final /* synthetic */ URLSpan b;
        public final /* synthetic */ Activity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Activity activity, URLSpan uRLSpan, Activity activity2) {
            super(activity);
            this.b = uRLSpan;
            this.c = activity2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Activity activityA = a();
            if (activityA == null || this.b.getURL() == null) {
                return;
            }
            String url = this.b.getURL();
            LogUtil.i("PrivacyController", "URL-click:" + url);
            if ("agreement".equals(url)) {
                zm4.i(activityA, ym4.c());
                return;
            }
            if ("privacy".equals(url)) {
                zm4.i(activityA, ym4.e());
                return;
            }
            if ("shareList".equals(url)) {
                zm4.i(activityA, tj2.v());
                return;
            }
            if ("cPrivacy".equals(url)) {
                zm4.i(activityA, tj2.c());
            } else if ("thirdParty".equals(url)) {
                zm4.i(activityA, tj2.y());
            } else if ("briefagreement".equals(url)) {
                zm4.i(activityA, tj2.b());
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            LogUtil.i("PrivacyController", "updateDrawState");
            textPaint.setColor(this.c.getResources().getColor(R.color.Ga));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f22449a;
        public final /* synthetic */ h b;
        public final /* synthetic */ int c;

        public c(Dialog dialog, h hVar, int i) {
            this.f22449a = dialog;
            this.b = hVar;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f22449a.dismiss();
            this.b.b(this.f22449a);
            SPUtil.f14322a.t(SPUtil.SCENE.PRIVACY_DIALOG, "key_privacy_dialog_version" + this.c, 2);
            zm4.f22448a = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f22450a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ int c;

        public d(h hVar, Dialog dialog, int i) {
            this.f22450a = hVar;
            this.b = dialog;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f22450a.a(this.b);
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.PRIVACY_DIALOG;
            sPUtil.t(scene, "key_privacy_dialog_version" + this.c, 1);
            sPUtil.t(scene, "key_privacy_dialog_version" + this.c + "*" + ac1.f, 1);
            zm4.f22448a = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f22451a;

        public e(TextView textView) {
            this.f22451a = textView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == zm4.b) {
                String string = this.f22451a.getText().toString();
                if (string.contains("s")) {
                    int i = Integer.parseInt(string.substring(4, 5));
                    if (i <= 1) {
                        this.f22451a.setText("不同意");
                        this.f22451a.setEnabled(true);
                        return;
                    }
                    this.f22451a.setText("不同意(" + (i - 1) + "s)");
                    sendEmptyMessageDelayed(zm4.b, 1000L);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends i {
        public final /* synthetic */ URLSpan b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Activity d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Activity activity, URLSpan uRLSpan, int i, Activity activity2) {
            super(activity);
            this.b = uRLSpan;
            this.c = i;
            this.d = activity2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Activity activityA = a();
            if (activityA == null || this.b.getURL() == null) {
                return;
            }
            String url = this.b.getURL();
            LogUtil.i("PrivacyController", "URL-click:" + url);
            if ("agreement".equals(url)) {
                zm4.i(activityA, ym4.c());
            } else if ("privacy".equals(url)) {
                zm4.i(activityA, ym4.e());
            } else if ("cmccPrivacy".equals(url)) {
                zm4.i(activityA, "https://wap.cmpassport.com/resources/html/contract.html");
            } else if ("unicomPrivacy".equals(url)) {
                zm4.i(activityA, "https://opencloud.wostore.cn/authz/resource/html/disclaimer.html?fromsdk=true");
            } else if ("ctPrivacy".equals(url)) {
                zm4.i(activityA, "https://e.189.cn/sdk/agreement/detail.do?hidetop=true");
            }
            HashMap<String, Object> mapE = x63.e(this.c);
            mapE.put("page", "checkbox");
            mapE.put("type", url);
            LogUtil.uploadInfoImmediate("lx_client_login_agreement_linkclick", mapE);
            zn6.j("lx_client_login_agreement_linkclick", "click", mapE);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            LogUtil.i("PrivacyController", "updateDrawState");
            textPaint.setColor(this.d.getResources().getColor(R.color.Ga));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends i {
        public final /* synthetic */ URLSpan b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Activity d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Activity activity, URLSpan uRLSpan, int i, Activity activity2) {
            super(activity);
            this.b = uRLSpan;
            this.c = i;
            this.d = activity2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Activity activityA = a();
            if (activityA == null || this.b.getURL() == null) {
                return;
            }
            String url = this.b.getURL();
            LogUtil.i("PrivacyController", "URL-click:" + url);
            if ("agreement".equals(url)) {
                zm4.i(activityA, ym4.c());
            } else if ("privacy".equals(url)) {
                zm4.i(activityA, ym4.e());
            } else if ("cmccPrivacy".equals(url)) {
                zm4.i(activityA, "https://wap.cmpassport.com/resources/html/contract.html");
            } else if ("unicomPrivacy".equals(url)) {
                zm4.i(activityA, "https://opencloud.wostore.cn/authz/resource/html/disclaimer.html?fromsdk=true");
            } else if ("ctPrivacy".equals(url)) {
                zm4.i(activityA, "https://e.189.cn/sdk/agreement/detail.do?hidetop=true");
            }
            HashMap<String, Object> mapE = x63.e(this.c);
            mapE.put("page", "pop");
            mapE.put("type", url);
            LogUtil.uploadInfoImmediate("lx_client_login_agreement_linkclick", mapE);
            zn6.j("lx_client_login_agreement_linkclick", "click", mapE);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            LogUtil.i("PrivacyController", "updateDrawState");
            textPaint.setColor(this.d.getResources().getColor(R.color.Ga));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class i extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<Activity> f22452a;

        public i(Activity activity) {
            this.f22452a = new WeakReference<>(activity);
        }

        public Activity a() {
            return this.f22452a.get();
        }
    }

    public static SpannableStringBuilder d(Activity activity, int i2) {
        String string = activity.getResources().getString(R.string.login_agreement_text);
        String string2 = activity.getResources().getString(R.string.login_privacy_text);
        String string3 = activity.getResources().getString(R.string.login_cmcc_privacy_text);
        String string4 = activity.getResources().getString(R.string.login_unicom_privacy_text);
        String string5 = activity.getResources().getString(R.string.login_ct_privacy_text);
        Spanned spannedFromHtml = Html.fromHtml((i2 == 1 ? activity.getResources().getString(R.string.login_op_privacy_des, string3) : i2 == 2 ? activity.getResources().getString(R.string.login_op_privacy_des, string4) : i2 == 3 ? activity.getResources().getString(R.string.login_op_privacy_des, string5) : activity.getResources().getString(R.string.login_privacy_des)).replaceAll(string, "<a href='agreement'>" + string + "</a>").replaceAll(string2, "<a href='privacy'>" + string2 + "</a>").replaceAll(string3, "<a href='cmccPrivacy'>" + string3 + "</a>").replaceAll(string4, "<a href='unicomPrivacy'>" + string4 + "</a>").replaceAll(string5, "<a href='ctPrivacy'>" + string5 + "</a>"));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
        try {
            for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spannedFromHtml.length(), URLSpan.class)) {
                spannableStringBuilder.setSpan(new f(activity, uRLSpan, i2, activity), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
                spannableStringBuilder.removeSpan(uRLSpan);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder e(Activity activity, int i2) {
        String string = activity.getResources().getString(R.string.login_agreement_text);
        String string2 = activity.getResources().getString(R.string.login_privacy_text);
        String string3 = activity.getResources().getString(R.string.login_cmcc_privacy_text);
        String string4 = activity.getResources().getString(R.string.login_unicom_privacy_text);
        String string5 = activity.getResources().getString(R.string.login_ct_privacy_text);
        String strConcat = ("<a href='agreement'>" + string + "</a>").concat(" ").concat("<a href='privacy'>" + string2 + "</a>");
        if (i2 == 1) {
            strConcat = strConcat.concat(" ").concat("<a href='cmccPrivacy'>" + string3 + "</a>");
        } else if (i2 == 2) {
            strConcat = strConcat.concat(" ").concat("<a href='unicomPrivacy'>" + string4 + "</a>");
        } else if (i2 == 3) {
            strConcat = strConcat.concat(" ").concat("<a href='ctPrivacy'>" + string5 + "</a>");
        }
        Spanned spannedFromHtml = Html.fromHtml(strConcat);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
        try {
            for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spannedFromHtml.length(), URLSpan.class)) {
                spannableStringBuilder.setSpan(new g(activity, uRLSpan, i2, activity), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
                spannableStringBuilder.removeSpan(uRLSpan);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return spannableStringBuilder;
    }

    public static boolean f() {
        return f22448a;
    }

    public static void g(Activity activity, boolean z, h hVar) {
        int iD = ym4.d(true);
        LogUtil.i("PrivacyController", "showPrivacyDialog version" + iD);
        String string = activity.getResources().getString(R.string.privacy_dialog_content);
        String string2 = activity.getResources().getString(R.string.privacy_dialog_agreement_link);
        String string3 = activity.getResources().getString(R.string.privacy_dialog_privacy_link);
        String string4 = activity.getResources().getString(R.string.privacy_dialog_sharelist_link);
        String string5 = activity.getResources().getString(R.string.privacy_dialog_agreement_link_brief);
        String string6 = activity.getResources().getString(R.string.privacy_dialog_cprivacy_link);
        Spanned spannedFromHtml = Html.fromHtml(string.replaceAll(string2, "<a href='agreement'>" + string2 + "</a>").replaceAll(string3, "<a href='privacy'>" + string3 + "</a>").replaceAll(string4, "<a href='thirdParty'>" + string4 + "</a>").replaceAll(string6, "<a href='cPrivacy'>" + string6 + "</a>").replaceAll(string5, "<a href='briefagreement'>" + string5 + "</a>"));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
        try {
            for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spannedFromHtml.length(), URLSpan.class)) {
                spannableStringBuilder.setSpan(new b(activity, uRLSpan, activity), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
                spannableStringBuilder.removeSpan(uRLSpan);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Dialog dialog = new Dialog(activity, R.style.dark_dialog);
        dialog.setContentView(R.layout.layout_privacy_dialog);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        TextView textView = (TextView) dialog.findViewById(R.id.content_text);
        textView.setText(spannableStringBuilder);
        ((TextView) dialog.findViewById(R.id.btn_agree)).setOnClickListener(new c(dialog, hVar, iD));
        TextView textView2 = (TextView) dialog.findViewById(R.id.btn_deny);
        textView2.setOnClickListener(new d(hVar, dialog, iD));
        if (z) {
            textView2.setEnabled(false);
            textView2.setAllCaps(false);
            textView2.setText("不同意(3s)");
            new e(textView2).sendEmptyMessageDelayed(b, 1000L);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(activity.getResources().getColor(android.R.color.transparent));
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.6f;
        window.setAttributes(attributes);
        dialog.show();
    }

    public static boolean h(Activity activity) {
        int iD = ym4.d(true);
        LogUtil.i("PrivacyController", "showPrivacyDialogOnMain " + iD);
        if (iD > 0) {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.PRIVACY_DIALOG;
            int iF = sPUtil.f(scene, "key_privacy_dialog_version" + iD, 0);
            int iF2 = sPUtil.f(scene, "key_privacy_dialog_version" + iD + "*" + ac1.f, 0);
            LogUtil.i("PrivacyController", "showPrivacyDialogOnMain " + iF + " " + iF2);
            if ((iF == 0 || (iF == 1 && iF2 == 0)) && !f22448a) {
                f22448a = true;
                g(activity, true, new a());
                LogUtil.uploadInfoImmediate("res240", "1", null, x63.f());
                zn6.d("lx_client_login_res240", null, x63.f());
                return true;
            }
        }
        return false;
    }

    public static void i(Activity activity, String str) {
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

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class h {
        public void a(Dialog dialog) {
        }

        public void b(Dialog dialog) {
        }
    }
}
