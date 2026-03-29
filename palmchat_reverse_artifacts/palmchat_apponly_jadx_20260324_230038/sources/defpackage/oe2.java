package defpackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleRecommendItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.CircleDetailActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.groupchat.GroupDetailActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import defpackage.bo2;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class oe2 extends bo2 {
    public Context c;
    public re2 d;
    public Response.Listener<JSONObject> e;
    public Response.ErrorListener f;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<CircleRecommendItem>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f19749a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            this.f19749a = context;
            this.b = str;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleRecommendItem> baseResponse) {
            Intent intent;
            oe2.this.f1790a.onFinish(true);
            if (baseResponse.getResultCode() != 0) {
                Toast.makeText(oe2.this.c, baseResponse.getErrorMsg(), 0).show();
                return;
            }
            CircleRecommendItem data = baseResponse.getData();
            if (data != null) {
                GroupInfoItem groupInfoItemCopyForGroupInfoItem = data.copyForGroupInfoItem();
                if (groupInfoItemCopyForGroupInfoItem.getRoomType() == 1 || groupInfoItemCopyForGroupInfoItem.getRoomType() == 2) {
                    Intent intent2 = new Intent(this.f19749a, (Class<?>) CircleDetailActivity.class);
                    intent2.putExtra("key_group_info", groupInfoItemCopyForGroupInfoItem);
                    intent2.putExtra("key_apply_group_source", 1);
                    intent2.putExtra("join_circle_extra_data", this.b);
                    intent = intent2;
                } else {
                    intent = new Intent(this.f19749a, (Class<?>) GroupDetailActivity.class);
                    intent.putExtra("group_qrcode", this.b);
                }
                this.f19749a.startActivity(intent);
            }
        }
    }

    public oe2(FrameworkBaseActivity frameworkBaseActivity, bo2.a aVar) {
        super(frameworkBaseActivity, aVar);
        this.c = frameworkBaseActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(String str, JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("resultCode", -1);
        String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG, "");
        if (iOptInt == 0) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            String strOptString2 = jSONObjectOptJSONObject.optString("roomId");
            if (jSONObjectOptJSONObject.optInt("roomType", 0) != 0) {
                f(this.b, strOptString2, str);
                return;
            }
            g(this.c, str);
        } else if (TextUtils.isEmpty(strOptString)) {
            Context context = this.c;
            Toast.makeText(context, context.getResources().getString(R.string.group_detail_network), 0).show();
        } else {
            Toast.makeText(this.c, strOptString, 0).show();
        }
        this.f1790a.onFinish(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(VolleyError volleyError) {
        this.f1790a.onFinish(true);
        Context context = this.c;
        Toast.makeText(context, context.getResources().getString(R.string.group_detail_network), 0).show();
    }

    @Override // defpackage.bo2
    public void a(String str) {
        e(str);
    }

    public final void e(String str) {
        re2 re2Var = this.d;
        if (re2Var != null) {
            re2Var.onCancel();
        }
        HashMap map = new HashMap();
        final String strSubstring = str.substring(12);
        map.put("qrCode", strSubstring);
        if (this.e == null) {
            this.e = new Response.Listener() { // from class: me2
                @Override // com.android.volley.Response.Listener
                public final void onResponse(Object obj) {
                    this.f19199a.h(strSubstring, (JSONObject) obj);
                }
            };
        }
        if (this.f == null) {
            this.f = new Response.ErrorListener() { // from class: ne2
                @Override // com.android.volley.Response.ErrorListener
                public final void onErrorResponse(VolleyError volleyError) {
                    this.f19498a.i(volleyError);
                }
            };
        }
        re2 re2Var2 = new re2(this.e, this.f, map);
        this.d = re2Var2;
        try {
            re2Var2.n();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public final void f(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.f1790a.onFinish(false);
        } else {
            c70.R().F(str, new a(context, str2));
        }
    }

    public final void g(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) GroupDetailActivity.class);
        intent.putExtra("group_qrcode", str);
        context.startActivity(intent);
    }
}
