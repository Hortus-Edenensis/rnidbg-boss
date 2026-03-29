package defpackage;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.FileRecorder;
import com.qiniu.android.storage.KeyGenerator;
import com.qiniu.android.storage.UpCancellationSignal;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UpProgressHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;
import com.qiniu.android.storage.serverConfig.ServerConfigMonitor;
import com.zenmen.palmchat.fileupload.blockupload.CancellationHandler;
import com.zenmen.palmchat.fileupload.dao.UploadResultVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class pp4 {
    public static final String g = nl0.g + "/feed-media/v5/check";
    public static final String h = nl0.g + "/feed-media/v5/forward";
    public static final String i = nl0.g + "/feed-media/v5/transform";
    public static final String j = nl0.h + "/meeyou-media/check";
    public static final String k = nl0.b + "/room/v5/qiniu/token";
    public static UploadManager l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f20064a;
    public String b = "";
    public int c;
    public int d;
    public a56 e;
    public CancellationHandler f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements UpCompletionHandler {
        public a() {
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void complete(String str, ResponseInfo responseInfo, JSONObject jSONObject) {
            JSONObject jSONObject2;
            UploadResultVo uploadResultVo;
            Exception e;
            JSONObject jSONObject3;
            LogUtil.i("QiniuFileUploader", "onComplete jsonData=" + jSONObject);
            UploadResultVo uploadResultVo2 = null;
            if (responseInfo != null && responseInfo.isOK() && (jSONObject2 = responseInfo.response) != null) {
                try {
                    jSONObject3 = jSONObject2.getJSONObject("data");
                } catch (Exception e2) {
                    uploadResultVo = null;
                    e = e2;
                }
                if (jSONObject3 != null) {
                    String string = jSONObject3.getString("accessUrl");
                    String string2 = jSONObject3.getString("saveKey");
                    if (!TextUtils.isEmpty(string2)) {
                        uploadResultVo = new UploadResultVo();
                        try {
                            uploadResultVo.url = string;
                            uploadResultVo.saveKey = string2;
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                        }
                        uploadResultVo2 = uploadResultVo;
                    }
                }
            }
            if (uploadResultVo2 != null) {
                pp4.this.e.onProgress(100, (int) pp4.this.f20064a.length());
                pp4.this.e.b(uploadResultVo2);
                return;
            }
            pp4.this.e.a(new Exception(responseInfo.error + "json=" + jSONObject));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements KeyGenerator {
        @Override // com.qiniu.android.storage.KeyGenerator
        public String gen(String str, File file) {
            return file.lastModified() + "+" + file.length() + "_._" + ((Object) new StringBuffer(file.getAbsolutePath()).reverse());
        }

        @Override // com.qiniu.android.storage.KeyGenerator
        public String gen(String str, String str2) {
            return str + str2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i("QiniuFileUploader", "endMonitor");
            try {
                ServerConfigMonitor.endMonitor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends yw4 {
        public d() {
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            pp4.this.e.a(exc);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            pp4.this.e.onProgress(0, 0);
            if (pp4.this.f.isCancelled()) {
                pp4.this.e.a(new Exception("upload canceled"));
            } else if (yy2Var.f22300a) {
                pp4.this.i(UploadResultVo.buildFromJsonObject(jSONObject.optJSONObject("data")));
            } else {
                pp4.this.e.a(new Exception(yy2Var.toString()));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends yw4 {
        public e() {
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            pp4.this.e.a(exc);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            pp4.this.e.onProgress(0, 0);
            if (pp4.this.f.isCancelled()) {
                pp4.this.e.a(new Exception("upload canceled"));
            } else if (!yy2Var.f22300a || jSONObject == null) {
                pp4.this.e.a(new Exception(yy2Var.toString()));
            } else {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                pp4.this.j(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("qiNiuToken") : null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements UpCancellationSignal {
        public f() {
        }

        @Override // com.qiniu.android.http.CancellationHandler
        public boolean isCancelled() {
            return pp4.this.f.isCancelled();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements UpProgressHandler {
        public g() {
        }

        @Override // com.qiniu.android.storage.UpProgressHandler
        public void progress(String str, double d) {
            LogUtil.i("QiniuFileUploader", "onProgress percent=" + d);
            pp4.this.e.onProgress((int) (100.0d * d), (int) (((double) pp4.this.f20064a.length()) * d));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements UpCompletionHandler {
        public h() {
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void complete(String str, ResponseInfo responseInfo, JSONObject jSONObject) {
            LogUtil.i("QiniuFileUploader", "onProgress complete");
            UploadResultVo uploadResultVoBuildFromJsonObject = jSONObject != null ? UploadResultVo.buildFromJsonObject(jSONObject.optJSONObject("data")) : null;
            if (responseInfo.isOK() && uploadResultVoBuildFromJsonObject != null) {
                pp4.this.e.onProgress(100, (int) pp4.this.f20064a.length());
                pp4.this.e.b(uploadResultVoBuildFromJsonObject);
                return;
            }
            pp4.this.e.a(new Exception(responseInfo.error + "json=" + jSONObject));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements UpCancellationSignal {
        public i() {
        }

        @Override // com.qiniu.android.http.CancellationHandler
        public boolean isCancelled() {
            return pp4.this.f.isCancelled();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements UpProgressHandler {
        public j() {
        }

        @Override // com.qiniu.android.storage.UpProgressHandler
        public void progress(String str, double d) {
            LogUtil.i("QiniuFileUploader", "onProgress percent=" + d);
            pp4.this.e.onProgress((int) (100.0d * d), (int) (((double) pp4.this.f20064a.length()) * d));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k implements tl2 {
        public void a(File file, int i, a56 a56Var, CancellationHandler cancellationHandler, int i2) {
            if (i2 == 3) {
                new pp4(file, i, a56Var, cancellationHandler, i2).l();
            } else {
                new pp4(file, i, a56Var, cancellationHandler, i2).k();
            }
        }
    }

    public pp4(File file, int i2, a56 a56Var, CancellationHandler cancellationHandler, int i3) {
        this.f20064a = file;
        this.c = i2;
        this.e = a56Var;
        this.f = cancellationHandler;
        this.d = i3;
    }

    public static UploadManager g() {
        if (l == null) {
            h();
        }
        return l;
    }

    public static void h() {
        FileRecorder fileRecorder;
        LogUtil.i("QiniuFileUploader", "initUploadManager");
        try {
            fileRecorder = new FileRecorder(pu1.n);
        } catch (IOException e2) {
            e2.printStackTrace();
            fileRecorder = null;
        }
        try {
            l = new UploadManager(new Configuration.Builder().chunkSize(262144).connectTimeout(10).useHttps(true).responseTimeout(60).recorder(fileRecorder, new b()).zone(FixedZone.zone0).build());
            u93.b(20000, new c());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final String f() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = rb3.b(this.f20064a);
        }
        return this.b;
    }

    public final void i(UploadResultVo uploadResultVo) {
        if (uploadResultVo.exists) {
            this.e.b(uploadResultVo);
        } else {
            if (TextUtils.isEmpty(uploadResultVo.cdnToken)) {
                this.e.a(new Exception("cdnToken is null"));
                return;
            }
            g().put(this.f20064a, uploadResultVo.cdnKey, uploadResultVo.cdnToken, new h(), new UploadOptions(null, null, false, new g(), new f()));
        }
    }

    public final void j(String str) {
        if (TextUtils.isEmpty(str)) {
            this.e.a(new Exception("cdnToken is null"));
            return;
        }
        g().put(this.f20064a, (String) null, str, new a(), new UploadOptions(null, null, false, new j(), new i()));
    }

    public void k() {
        d dVar = new d();
        if (this.f20064a == null) {
            LogUtil.i("QiniuFileUploader", "upload , file is null");
            return;
        }
        String str = g;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TKDownloadReason.KSAD_TK_NET, hx3.h());
            jSONObject.put("type", this.c);
            jSONObject.put("fsize", this.f20064a.length());
            jSONObject.put("fhash", f());
            jSONObject.put("hdFlag", 0);
            jSONObject.put(RemoteMessageConst.TO, v4.e(com.zenmen.palmchat.c.b()) + "@youni");
            if (this.d == 2) {
                jSONObject.put("bizType", 6);
            }
            if (this.d == 4) {
                jSONObject.put("bizType", 9);
            }
            if (this.d == 5) {
                jSONObject.put("bizType", 10);
            }
            if (this.d == 6) {
                jSONObject.put("bizType", 11);
            }
            if (this.d == 7) {
                jSONObject.put("bizType", 12);
            }
            LogUtil.json("logmedia", jSONObject.toString(), "request " + str);
            zw4.f(str, 1, jSONObject, dVar);
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public void l() {
        e eVar = new e();
        if (this.f20064a == null) {
            LogUtil.i("QiniuFileUploader", "upload , file is null");
            return;
        }
        try {
            zw4.f(k, 1, new JSONObject(), eVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
