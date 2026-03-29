package defpackage;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import defpackage.n54;
import defpackage.s90;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class s90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s90 f20683a = new s90();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ dv0 f20684a;

        public a(dv0 dv0Var) {
            this.f20684a = dv0Var;
        }

        public static /* synthetic */ void c(JSONObject jSONObject, BaseResponse baseResponse, sm5 sm5Var) {
            try {
                ap4.m(jSONObject, 0L, 0L);
                sm5Var.onNext(baseResponse);
                sm5Var.onCompleted();
            } catch (JSONException e) {
                e.printStackTrace();
                sm5Var.onError(new Throwable());
            }
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(final BaseResponse baseResponse) {
            if (baseResponse == null || baseResponse.getData() == null) {
                return;
            }
            try {
                final JSONObject jSONObject = new JSONObject();
                jSONObject.put("messages", new JSONArray(new Gson().toJson(baseResponse.getData())));
                uz4.c(new n54.a() { // from class: r90
                    @Override // defpackage.c5
                    public final void call(Object obj) {
                        s90.a.c(jSONObject, baseResponse, (sm5) obj);
                    }
                }, this.f20684a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static s90 a() {
        return f20683a;
    }

    public boolean b(String str) {
        return SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).getBoolean("key_circle_group_history_of_" + AccountUtils.p(AppContext.getContext()) + "_" + str, false);
    }

    public void c(String str) {
        SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).edit().putBoolean("key_circle_group_history_of_" + AccountUtils.p(AppContext.getContext()) + "_" + str, true).apply();
    }

    public void d(String str) {
        SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).edit().putBoolean("key_circle_group_history_of_" + AccountUtils.p(AppContext.getContext()) + "_" + str, false).apply();
    }

    public void e(String str, dv0<BaseResponse> dv0Var) {
        if (oc0.f() && oc0.a()) {
            String str2 = "key_circle_group_history_of_" + AccountUtils.p(AppContext.getContext()) + "_" + str;
            SharedPreferences sharedPreferencesM = SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE);
            if (sharedPreferencesM.getBoolean(str2, false)) {
                return;
            }
            c70.R().D0(str, new a(dv0Var));
            sharedPreferencesM.edit().putBoolean(str2, true).apply();
        }
    }
}
