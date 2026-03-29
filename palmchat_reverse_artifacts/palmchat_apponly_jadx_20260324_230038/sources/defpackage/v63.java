package defpackage;

import android.text.TextUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.login.InitActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class v63 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog.e f21364a;

        public a(MaterialDialog.e eVar) {
            this.f21364a = eVar;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            this.f21364a.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            LogUtil.onImmediateClickEvent("con11", null, null);
            this.f21364a.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f21365a;
        public String b;
        public String c;
        public String d;
        public String e;

        public b() {
            this.f21365a = false;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
    }

    public static b a() {
        b bVar = new b();
        JSONObject jSONObjectM = ts0.o().m();
        LogUtil.i("LoginContactPermissionDialogHelper", "getContactPermissionConfig=" + jSONObjectM);
        if (jSONObjectM != null) {
            String strOptString = jSONObjectM.optString("ABCTest");
            bVar.f21365a = strOptString != null && strOptString.equalsIgnoreCase("c");
            try {
                JSONObject jSONObject = new JSONObject(jSONObjectM.optString("info"));
                bVar.b = jSONObject.optString("TitleContent");
                bVar.c = jSONObject.optString("TextContent");
                bVar.d = jSONObject.optString("positiveText");
                bVar.e = jSONObject.optString("negativeText");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return bVar;
    }

    public static boolean b() {
        return false;
    }

    public static void c(InitActivity initActivity, MaterialDialog.e eVar) {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "init_has_show_contact_request", Boolean.TRUE);
        LogUtil.onImmediateClickEvent("con1", null, null);
        b bVarA = a();
        new sd3(initActivity).U(bVarA.b).k(bVarA.c).P(TextUtils.isEmpty(bVarA.d) ? initActivity.getString(R.string.string_share_yes) : bVarA.d).L(TextUtils.isEmpty(bVarA.e) ? initActivity.getString(R.string.string_share_no) : bVarA.e).f(new a(eVar)).h(false).Q();
    }
}
