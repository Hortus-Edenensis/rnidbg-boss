package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.bq;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingConfig;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingInfo;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingStateInfo;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.zm4;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b9 {
    public static volatile b9 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AiGreetingStateInfo f1667a = new AiGreetingStateInfo();
    public AiGreetingConfig b = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends zm4.i {
        public final /* synthetic */ URLSpan b;
        public final /* synthetic */ Activity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Activity activity, URLSpan uRLSpan, Activity activity2) {
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
            LogUtil.i("AiGreetingManager", "URL-click:" + url);
            if ("agreement".equals(url)) {
                Intent intent = new Intent();
                intent.setClass(activityA, CordovaWebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("web_url", "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-13-4-ec4c3cdee4df46d887674d1308f87644-sxrvlj");
                bundle.putBoolean("web_show_right_menu", false);
                bundle.putInt("BackgroundColor", -1);
                intent.putExtra("needCheckAccount", false);
                intent.putExtras(bundle);
                activityA.startActivity(intent);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            LogUtil.i("AiGreetingManager", "updateDrawState");
            textPaint.setColor(this.c.getResources().getColor(R.color.Ga));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog.e f1668a;

        public b(MaterialDialog.e eVar) {
            this.f1668a = eVar;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            this.f1668a.onNegative(materialDialog);
            HashMap map = new HashMap();
            map.put("action", "cancel");
            zn6.i("AiChat_authorize_pop", map);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            HashMap map = new HashMap();
            map.put("action", "agree");
            zn6.i("AiChat_authorize_pop", map);
            b9.d().a();
            this.f1668a.onPositive(materialDialog);
        }
    }

    public static HashMap<String, String> b(ChatItem chatItem) {
        HashMap<String, String> map = new HashMap<>();
        if (chatItem != null) {
            String str = DomainHelper.m(chatItem).domain;
            int i = DomainHelper.i(chatItem);
            map.put(RemoteMessageConst.TO, chatItem.getChatId());
            map.put("domain", str);
            map.put("bizType", String.valueOf(i));
        }
        return map;
    }

    public static b9 d() {
        if (c == null) {
            synchronized (b9.class) {
                if (c == null) {
                    c = new b9();
                }
            }
        }
        return c;
    }

    public static boolean j() {
        return t66.h().f("LX-67350", false) && !TeenagersModeManager.a().d();
    }

    public void a() {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_ai_greeting_privacy_agree"), Boolean.TRUE);
    }

    public AiGreetingConfig c() {
        if (this.b == null) {
            JSONObject config = vs0.a().getConfig("aigreet_quickpanel");
            if (config != null) {
                this.b = (AiGreetingConfig) az2.a(config.toString(), AiGreetingConfig.class);
            }
            if (this.b == null) {
                this.b = new AiGreetingConfig();
            }
        }
        return this.b;
    }

    public int e() {
        return f().remainCount;
    }

    public AiGreetingStateInfo f() {
        return this.f1667a;
    }

    public boolean g() {
        return SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, k86.a("key_ai_greeting_privacy_agree"), false);
    }

    public boolean h() {
        return !yg4.a(AppContext.getContext().getTrayPreferences().b(k86.w(), 0), 8388608);
    }

    public boolean i() {
        return !yg4.a(AppContext.getContext().getTrayPreferences().b(k86.w(), 0), 4194304);
    }

    public void k(ChatItem chatItem, int i, List<MessageVo> list, io2<LXBaseNetBean<AiGreetingInfo>> io2Var) {
        a9.e(chatItem, i, list, io2Var);
    }

    public void l(Activity activity, MaterialDialog.e eVar) {
        String strReplaceAll = "授权“AI帮聊”，实时为您提供聊天建议。如需使用，需同意AI帮聊相关用户协议《AI帮聊用户服务协议》".replaceAll("《AI帮聊用户服务协议》", "<a href='agreement'>《AI帮聊用户服务协议》</a>");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Html.fromHtml(strReplaceAll));
        try {
            for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, strReplaceAll.length(), URLSpan.class)) {
                spannableStringBuilder.setSpan(new a(activity, uRLSpan, activity), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
                spannableStringBuilder.removeSpan(uRLSpan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new sd3(activity).k(spannableStringBuilder).P("同意").L("取消").f(new b(eVar)).e().show();
        HashMap map = new HashMap();
        map.put("action", bq.b.V);
        zn6.i("AiChat_authorize_pop", map);
    }

    public void m(int i, int i2, SkuConfig skuConfig) {
        AiGreetingStateInfo aiGreetingStateInfo = this.f1667a;
        aiGreetingStateInfo.remainCount = i2;
        aiGreetingStateInfo.remainDay = i;
        if (skuConfig != null) {
            aiGreetingStateInfo.skuConfig = skuConfig;
        }
    }
}
