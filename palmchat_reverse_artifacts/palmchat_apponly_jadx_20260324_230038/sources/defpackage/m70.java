package defpackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import defpackage.m70;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class m70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, Boolean> f19148a = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f19149a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;

        public a(b bVar, JSONObject jSONObject, String str, Context context) {
            this.f19149a = bVar;
            this.b = jSONObject;
            this.c = str;
            this.d = context;
        }

        public static /* synthetic */ void c(b bVar, JSONObject jSONObject, BaseResponse baseResponse, Context context, String str, GroupInfoItem groupInfoItem) {
            if (groupInfoItem != null) {
                if (bVar != null) {
                    bVar.onFinish(baseResponse.getResultCode(), baseResponse.getErrorMsg(), jSONObject);
                }
                Intent intent = new Intent(context, (Class<?>) ChatterActivity.class);
                intent.putExtra("chat_item", groupInfoItem);
                intent.putExtra("chat_need_back_to_main", false);
                context.startActivity(intent);
            } else if (bVar != null) {
                bVar.onFinish(-3, "未查询到群信息", jSONObject);
            }
            m70.f19148a.remove(str);
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(final BaseResponse baseResponse) {
            if (baseResponse == null) {
                b bVar = this.f19149a;
                if (bVar != null) {
                    bVar.onFinish(-2, "接口异常", this.b);
                }
                m70.f19148a.remove(this.c);
                return;
            }
            if (baseResponse.getResultCode() != 0 && baseResponse.getResultCode() != 4001 && baseResponse.getResultCode() != 4006) {
                b bVar2 = this.f19149a;
                if (bVar2 != null) {
                    bVar2.onFinish(baseResponse.getResultCode(), baseResponse.getErrorMsg(), this.b);
                }
                m70.f19148a.remove(this.c);
                return;
            }
            c70 c70VarR = c70.R();
            final String str = this.c;
            final b bVar3 = this.f19149a;
            final JSONObject jSONObject = this.b;
            final Context context = this.d;
            c70VarR.K(str, new dv0() { // from class: l70
                @Override // defpackage.dv0
                public final void onResponse(Object obj) {
                    m70.a.c(bVar3, jSONObject, baseResponse, context, str, (GroupInfoItem) obj);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onFinish(int i, String str, JSONObject jSONObject);

        void onStart();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d A[Catch: all -> 0x0067, TRY_ENTER, TryCatch #1 {, blocks: (B:5:0x0005, B:6:0x0008, B:7:0x0013, B:11:0x001d, B:14:0x0025, B:17:0x002d, B:19:0x0035, B:22:0x0045, B:25:0x004d, B:10:0x001a), top: B:33:0x0005, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void b(Context context, JSONObject jSONObject, b bVar) {
        String strOptString;
        JSONObject jSONObject2;
        if (bVar != null) {
            bVar.onStart();
            strOptString = jSONObject.optString("roomId");
            jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("roomId", strOptString);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(strOptString)) {
                if (bVar != null) {
                    bVar.onFinish(-1, "roomId为空", jSONObject2);
                }
                return;
            } else if (f19148a.containsKey(strOptString) && f19148a.get(strOptString).booleanValue()) {
                if (bVar != null) {
                    bVar.onFinish(-4, "等待上次请求结束", jSONObject2);
                }
                return;
            } else {
                f19148a.put(strOptString, Boolean.TRUE);
                c70.R().j(strOptString, 7, "", "", new a(bVar, jSONObject2, strOptString, context));
                return;
            }
        }
        strOptString = jSONObject.optString("roomId");
        jSONObject2 = new JSONObject();
        jSONObject2.put("roomId", strOptString);
        if (!TextUtils.isEmpty(strOptString)) {
        }
    }
}
