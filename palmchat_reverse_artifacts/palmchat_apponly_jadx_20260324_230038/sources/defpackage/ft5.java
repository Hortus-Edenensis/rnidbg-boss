package defpackage;

import com.zenmen.palmchat.task1v1.TaskTipBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ft5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f17594a = "ft5";
    public static final String b = nl0.z + "/userem.query.taskTip.v1";

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f17595a;

        public a(b bVar) {
            this.f17595a = bVar;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            b bVar = this.f17595a;
            if (bVar != null) {
                bVar.onFail(exc);
            }
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.i(ft5.f17594a, "======get task 1v1 info:" + jSONObject);
            if (jSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            int iOptInt = jSONObject.optInt("resultCode", -1);
            if (iOptInt != 0) {
                onFail(new Exception("code is wrong:" + iOptInt));
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            TaskTipBean taskTipBean = new TaskTipBean();
            taskTipBean.squareFromType = jSONObjectOptJSONObject.optInt("squareFromType");
            taskTipBean.squareTip = jSONObjectOptJSONObject.optString("squareTip");
            taskTipBean.basicDataTip = jSONObjectOptJSONObject.optString("basicDataTip");
            taskTipBean.interestTip = jSONObjectOptJSONObject.optString("interestTip");
            b bVar = this.f17595a;
            if (bVar != null) {
                bVar.a(taskTipBean);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(TaskTipBean taskTipBean);

        void onFail(Exception exc);
    }

    public static void b(int i, b bVar) {
        try {
            if (q42.a()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("scene", i);
                zw4.f(b, 1, jSONObject, new a(bVar));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long c(String str) {
        try {
            JSONObject config = vs0.a().getConfig("1V1RequestFreqConfig");
            if (config != null) {
                return ((long) config.optInt(str, 1)) * 60000;
            }
            return 60000L;
        } catch (Exception e) {
            e.printStackTrace();
            return 60000L;
        }
    }
}
