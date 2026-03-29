package com.zenmen.palmchat.update;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.zenmen.palmchat.update.UpdateManager;
import com.zenmen.palmchat.update.b;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.c56;
import defpackage.dt0;
import defpackage.ed5;
import defpackage.pu1;
import defpackage.rb3;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a implements com.zenmen.palmchat.update.b {
    public static final String d = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b.a f15681a;
    public Context b;
    public c56 c;

    /* JADX INFO: renamed from: com.zenmen.palmchat.update.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1118a implements Response.Listener<JSONObject> {
        public C1118a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.json("logupdate", jSONObject.toString(), "checkUpdate");
            try {
                if (jSONObject.getInt("resultCode") == 0) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        if (a.this.f15681a != null) {
                            a.this.f15681a.b(0, UpdateInfo.buildFromJson(jSONObjectOptJSONObject));
                        } else if (a.this.f15681a != null) {
                            a.this.f15681a.b(1, new UpdateInfo());
                        }
                    }
                } else if (a.this.f15681a != null) {
                    a.this.f15681a.b(1, new UpdateInfo());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.i(a.d, "error=" + volleyError.toString());
            if (a.this.f15681a != null) {
                a.this.f15681a.b(1, new UpdateInfo());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends ed5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UpdateInfo f15684a;

        public c(UpdateInfo updateInfo) {
            this.f15684a = updateInfo;
        }

        @Override // defpackage.ed5, defpackage.il2
        public void onError(int i, String str) {
            LogUtil.i(a.d, "onError:" + str);
            if (i == 101 || a.this.f15681a == null) {
                return;
            }
            a.this.f15681a.c(1, null, this.f15684a);
        }

        @Override // defpackage.ed5, defpackage.il2
        public void onFinish(File file) throws Throwable {
            if (a.this.f15681a != null) {
                File fileI = a.this.i(file, this.f15684a);
                if (fileI == null) {
                    a.this.f15681a.c(1, fileI, this.f15684a);
                } else {
                    a.this.f15681a.c(0, fileI, this.f15684a);
                }
            }
        }

        @Override // defpackage.ed5, defpackage.il2
        public void onProgress(int i) {
            if (a.this.f15681a != null) {
                a.this.f15681a.a((int) ((i / this.f15684a.psize) * 100.0f));
            }
        }
    }

    public a(Context context) {
        this.b = context;
    }

    @Override // com.zenmen.palmchat.update.b
    public void a(UpdateInfo updateInfo) {
        dt0.l(this.b, Volley.getUserAgent()).e(updateInfo.downloadUrl, pu1.n(), updateInfo.vname + ".apk.temp", new c(updateInfo));
    }

    @Override // com.zenmen.palmchat.update.b
    public void b(UpdateInfo updateInfo) {
        String str = updateInfo.vname;
        dt0.l(this.b, Volley.getUserAgent()).h(updateInfo.downloadUrl);
    }

    @Override // com.zenmen.palmchat.update.b
    public void c(b.a aVar) {
        this.f15681a = aVar;
    }

    @Override // com.zenmen.palmchat.update.b
    public void d(Context context, int i, UpdateManager.UpdateScene updateScene) {
        if (LogUtil.isDDBG()) {
            LogUtil.d(d, "checkUpdate begin");
        }
        c56 c56Var = new c56(new C1118a(), new b());
        this.c = c56Var;
        try {
            c56Var.o(i, updateScene);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void h(String str) {
        File file = new File(pu1.r(str) + ".temp");
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public final File i(File file, UpdateInfo updateInfo) throws Throwable {
        File[] fileArrListFiles;
        if (file == null || !file.canRead() || TextUtils.isEmpty(updateInfo.pmd5)) {
            file = null;
        } else {
            String strB = rb3.b(file);
            if (LogUtil.isDDBG()) {
                String str = d;
                LogUtil.d(str, "tmp file md5 = " + strB);
                LogUtil.d(str, "info md5 = " + updateInfo.pmd5);
                LogUtil.d(str, "file size  = " + file.length());
            }
            if (!updateInfo.pmd5.equals(strB)) {
                if (LogUtil.isDDBG()) {
                    LogUtil.d(d, "md5 check failed");
                }
                PreferenceManager.getDefaultSharedPreferences(this.b).edit().remove("update_versioncode").apply();
                h(updateInfo.vname);
                return null;
            }
        }
        if (file != null) {
            File file2 = new File(pu1.q());
            if (file2.exists() && (fileArrListFiles = file2.listFiles()) != null) {
                for (int i = 0; i < fileArrListFiles.length; i++) {
                    if (fileArrListFiles[i].getName().equals(file.getName())) {
                        fileArrListFiles[i].renameTo(new File(pu1.r(updateInfo.vname)));
                    } else {
                        try {
                            if (fileArrListFiles[i].exists()) {
                                fileArrListFiles[i].delete();
                            }
                        } catch (SecurityException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        File file3 = new File(pu1.r(updateInfo.vname));
        LogUtil.d(d, "file = " + file3);
        if (file3.exists()) {
            return file3;
        }
        return null;
    }
}
