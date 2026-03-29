package defpackage;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.zenmen.palmchat.fileupload.blockupload.CancellationHandler;
import com.zenmen.palmchat.fileupload.dao.UploadResultVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bn2;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qp4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f20287a;
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public ArrayList<UploadResultVo> f;
    public f g;
    public bn2.d h;
    public int i;
    public int j;
    public CancellationHandler k;
    public f l;
    public bn2.d m;

    /* JADX INFO: compiled from: SearchBox */
    public class c implements bn2.d {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f20291a;

            public a(int i) {
                this.f20291a = i;
                put("action", "send_feed");
                put("status", "video_zip_fail");
                put("type", 3);
                put("errorCode", Integer.valueOf(i));
                put(TKDownloadReason.KSAD_TK_NET, hx3.h());
            }
        }

        public c() {
        }

        @Override // bn2.d
        public void a(int i) {
            LogUtil.i("QiniuMultiFileUploader", "video onCompressPercentChanged, percent = " + i);
            if (qp4.this.h != null) {
                qp4.this.h.a(i);
            }
        }

        @Override // bn2.d
        public void b(boolean z, int i, String str) {
            LogUtil.i("QiniuMultiFileUploader", "video onCompressFinished, isSuccess = " + z);
            if (qp4.this.h != null) {
                qp4.this.h.b(z, i, str);
            }
            if (!z) {
                LogUtil.i("QiniuMultiFileUploader", LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(i), (Throwable) null);
                return;
            }
            File file = new File(str);
            if (file.exists()) {
                qp4.this.n(file);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20292a;

        public d(String str) {
            this.f20292a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            qp4.this.o(this.f20292a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements a56 {
        public e() {
        }

        @Override // defpackage.a56
        public void a(Exception exc) {
            qp4.this.l.a(exc);
        }

        @Override // defpackage.a56
        public void b(UploadResultVo uploadResultVo) {
            qp4.this.f.add(uploadResultVo);
            qp4.this.l.c(uploadResultVo);
            LogUtil.i("QiniuMultiFileUploader", "uploadWithQiniu onSuccess vo=" + uploadResultVo + " current size =" + qp4.this.f.size());
        }

        @Override // defpackage.a56
        public void onProgress(int i, int i2) {
            qp4.this.l.onProgress(i, i2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a(Exception exc);

        void b(ArrayList<UploadResultVo> arrayList);

        void c(UploadResultVo uploadResultVo);

        void onProgress(int i, int i2);
    }

    public qp4(List<String> list, f fVar, boolean z, int i) {
        this.e = 0;
        this.f = new ArrayList<>();
        this.g = null;
        this.h = null;
        this.j = 1;
        this.k = new a();
        this.l = new b();
        this.m = new c();
        this.f20287a = list;
        this.g = fVar;
        this.b = z;
        this.d = i;
    }

    public static /* synthetic */ int f(qp4 qp4Var) {
        int i = qp4Var.e;
        qp4Var.e = i + 1;
        return i;
    }

    public void l(int i) {
        this.j = i;
    }

    public void m() {
        List<String> list = this.f20287a;
        if (list == null || list.size() == 0) {
            return;
        }
        String str = this.f20287a.get(this.e);
        if (this.b) {
            new g13(new d(str)).start();
        } else {
            o(str);
        }
    }

    public final void n(File file) {
        ou1.b(file, this.d, new e(), this.k, this.j);
    }

    public final void o(String str) {
        File file;
        LogUtil.i("QiniuMultiFileUploader", "startUploadImp " + str);
        boolean z = this.b;
        if (z && this.d == 2) {
            tk3.a(str, this.m);
            file = null;
        } else if (!z || this.d != 0) {
            file = new File(str);
        } else if (this.i == 1) {
            file = xt.d(str, 40);
        } else {
            or2 or2VarM = xt.m(str);
            file = or2VarM.a() > or2VarM.b() * 2 ? xt.d(str, 40) : xt.c(str, false);
        }
        if (file == null || !file.exists()) {
            return;
        }
        n(file);
    }

    public qp4(List<String> list, f fVar, boolean z, int i, bn2.d dVar) {
        this.e = 0;
        this.f = new ArrayList<>();
        this.g = null;
        this.h = null;
        this.j = 1;
        this.k = new a();
        this.l = new b();
        this.m = new c();
        this.f20287a = list;
        this.g = fVar;
        this.h = dVar;
        this.b = z;
        this.d = i;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements f {
        public b() {
        }

        @Override // qp4.f
        public void a(Exception exc) {
            qp4.this.g.a(exc);
            LogUtil.i("QiniuMultiFileUploader", "multiFileUploadLisener onFailed " + exc);
        }

        @Override // qp4.f
        public void c(UploadResultVo uploadResultVo) {
            qp4.this.g.c(uploadResultVo);
            if (qp4.this.d == 2) {
                qp4.this.g.b(qp4.this.f);
                return;
            }
            qp4.f(qp4.this);
            if (qp4.this.c) {
                qp4.this.g.a(new Exception("upload canceled on onItemSuccess"));
            } else if (qp4.this.e < qp4.this.f20287a.size()) {
                qp4.this.m();
            } else {
                qp4.this.g.b(qp4.this.f);
            }
        }

        @Override // qp4.f
        public void onProgress(int i, int i2) {
            qp4.this.g.onProgress(i, i2);
        }

        @Override // qp4.f
        public void b(ArrayList<UploadResultVo> arrayList) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements CancellationHandler {
        public a() {
        }

        @Override // com.zenmen.palmchat.fileupload.blockupload.CancellationHandler
        public boolean isCancelled() {
            return qp4.this.c;
        }

        @Override // com.zenmen.palmchat.fileupload.blockupload.CancellationHandler
        public void cancel() {
        }
    }
}
