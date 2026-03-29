package defpackage;

import android.text.TextUtils;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.fileupload.dao.UploadResultVo;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.qp4;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class s03 implements bm2 {

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Response.Listener<JSONObject>, Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wi0 f20642a;
        public boolean b;

        public b(wi0 wi0Var, boolean z) {
            this.f20642a = wi0Var;
            this.b = z;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            Type[] actualTypeArguments;
            try {
                LogUtil.d("LXHttp", "response: --> " + jSONObject.toString());
                Type[] actualTypeArguments2 = ((ParameterizedType) this.f20642a.getClass().getGenericSuperclass()).getActualTypeArguments();
                if (actualTypeArguments2 != null && actualTypeArguments2.length > 0) {
                    Type type = actualTypeArguments2[0];
                    com.zenmen.palmchat.circle.bridge.http.Response response = (com.zenmen.palmchat.circle.bridge.http.Response) az2.b(jSONObject.toString(), type);
                    if (response != null) {
                        if ((type instanceof ParameterizedType) && !this.b && (actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments()) != null && actualTypeArguments.length > 0) {
                            Object objB = az2.b(jSONObject.toString(), actualTypeArguments[0]);
                            if (objB != null) {
                                response.setData(objB);
                            }
                        }
                        this.f20642a.a(response);
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f20642a.a(new BaseResponse(-1, ""));
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f20642a.a(new BaseResponse(-1, ""));
        }
    }

    @Override // defpackage.bm2
    public void a(ad0 ad0Var, pw4 pw4Var, wi0 wi0Var) {
        try {
            String strZ = k86.Z(ad0Var.a() + pw4Var.b());
            LogUtil.d("LXHttp", "url: --> " + strZ + "   body-->  " + pw4Var.a());
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            b bVar = new b(wi0Var, pw4Var.c());
            normalRequestQueue.add(new EncryptedJsonRequest(1, strZ, pw4Var.a(), bVar, bVar));
        } catch (Exception unused) {
            wi0Var.a(new BaseResponse(-1, ""));
        }
    }

    @Override // defpackage.bm2
    public void b(String str, j56 j56Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        zo4.e(arrayList, false, 0, new a(j56Var), 3);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements qp4.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j56 f20639a;

        /* JADX INFO: renamed from: s03$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1274a implements b5 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f20640a;

            public C1274a(ArrayList arrayList) {
                this.f20640a = arrayList;
            }

            @Override // defpackage.b5
            public void call() {
                ArrayList arrayList = this.f20640a;
                if (arrayList == null || arrayList.size() <= 0) {
                    a.this.f20639a.onFailed(new Throwable("vos is empty"));
                } else {
                    a.this.f20639a.onSuccess(((UploadResultVo) this.f20640a.get(0)).url, ((UploadResultVo) this.f20640a.get(0)).saveKey);
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements b5 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Exception f20641a;

            public b(Exception exc) {
                this.f20641a = exc;
            }

            @Override // defpackage.b5
            public void call() {
                a.this.f20639a.onFailed(this.f20641a);
            }
        }

        public a(j56 j56Var) {
            this.f20639a = j56Var;
        }

        @Override // qp4.f
        public void a(Exception exc) {
            if (this.f20639a != null) {
                wc.a().a().a(new b(exc));
            }
        }

        @Override // qp4.f
        public void b(ArrayList<UploadResultVo> arrayList) {
            if (this.f20639a != null) {
                wc.a().a().a(new C1274a(arrayList));
            }
        }

        @Override // qp4.f
        public void c(UploadResultVo uploadResultVo) {
        }

        @Override // qp4.f
        public void onProgress(int i, int i2) {
        }
    }
}
