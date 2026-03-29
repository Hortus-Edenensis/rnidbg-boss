package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.oplus.log.core.e;
import com.ss.android.ttvecamera.TECameraResult;
import com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto;
import defpackage.l77;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class z27 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mw6 f22327a;
    public b37 b;
    public cw6 c = new lw6();
    public int d = 0;
    public g e;
    public h f;
    public String g;
    public dw6 h;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements l77.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f22328a;

        public a(d dVar) {
            this.f22328a = dVar;
        }

        @Override // l77.c
        public final void a(int i, File file) {
            z27.this.k(this.f22328a, i, file);
        }

        @Override // l77.c
        public final void a(int i, String str) {
            z27.this.y(this.f22328a, i, str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f22329a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements l77.c {
            public a() {
            }

            @Override // l77.c
            public final void a(int i, File file) {
                b bVar = b.this;
                z27.this.g(bVar.f22329a, i, file);
            }

            @Override // l77.c
            public final void a(int i, String str) {
                b bVar = b.this;
                z27.this.x(bVar.f22329a, i, str);
            }
        }

        public b(c cVar) {
            this.f22329a = cVar;
        }

        @Override // com.oplus.log.core.e.b
        public final void a() {
            c cVar = this.f22329a;
            l77.b(cVar.c, cVar.d, z27.this.b, z27.this.g, this.f22329a.f, new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22331a;
        public String b;
        public long c;
        public long d;
        public boolean e;
        public String f;
        public String g;
        public String h;
        public String i;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22332a;
        public String b;
        public long c;
        public long d;
        public boolean e;
        public String f;

        public d(String str, long j, long j2, boolean z, String str2, String str3) {
            this.f22332a = str;
            this.c = j;
            this.d = j2;
            this.e = z;
            this.f = str2;
            this.b = str3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22333a;
        public String b;
        public f c;

        public e(String str, String str2) {
            this.b = str;
            this.f22333a = str2;
        }

        public void a(f fVar) {
            this.c = fVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a(UserTraceConfigDto userTraceConfigDto);

        void a(String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends Handler {
        public g(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Object obj = message.obj;
            if (obj instanceof d) {
                z27.this.i((d) obj);
            } else if (obj instanceof c) {
                z27.this.e((c) obj);
            } else if (obj instanceof e) {
                e eVar = (e) obj;
                z27.this.z(eVar.b, eVar.f22333a, eVar.c);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h {
        void a();

        void a(String str);
    }

    public z27(b37 b37Var) {
        this.g = null;
        this.b = b37Var == null ? new b37() : b37Var;
        this.g = this.b.q() + File.separator + ".zip";
        if (this.b.v() != null) {
            this.f22327a = this.b.v();
        }
        b();
    }

    public final void b() {
        HandlerThread handlerThread = new HandlerThread(getClass().getName());
        handlerThread.start();
        this.e = new g(handlerThread.getLooper());
    }

    public void c(dw6 dw6Var) {
        if (dw6Var != null) {
            this.h = dw6Var;
        }
    }

    public final void d(r17 r17Var) {
        this.d = 0;
        l77.d(this.g);
    }

    public final void e(c cVar) {
        if (cVar.e && !g47.e()) {
            this.c.b("report_log_info", "upload task need wifi connect");
            h(cVar, -121, "upload task need wifi connect");
            return;
        }
        try {
            dw6 dw6Var = this.h;
            if (dw6Var != null) {
                dw6Var.a(new b(cVar));
            }
        } catch (Exception e2) {
            x(cVar, -1, e2.toString());
        }
    }

    public void f(c cVar, int i) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = cVar;
        this.e.sendMessageDelayed(messageObtain, i);
    }

    public final void g(c cVar, int i, File file) {
        c cVar2;
        String str;
        String str2;
        String str3;
        String str4 = this.f22327a == null ? "report upload fail : HttpDelegate is null" : "";
        if (cVar == null) {
            str4 = "report upload fail : reportBody is null";
        }
        if (file == null) {
            str4 = "report upload fail : file is null";
        }
        if (!TextUtils.isEmpty(str4)) {
            this.c.c("report_log_info", str4);
            return;
        }
        try {
            try {
                try {
                    str = "report_log_info";
                    try {
                        try {
                            String strG = sd7.g(cVar.f22331a, cVar.f, file.getName(), i, "", cVar.b, this.b.a(), this.b.g(), TextUtils.isEmpty(this.b.j()) ? o17.d(o17.a()) : this.b.j(), cVar.g, cVar.h, cVar.d, this.g, cVar.i, this.c);
                            this.c.a("NearX-HLog", "doReportUpload Code: ".concat(String.valueOf(strG)));
                            r17 r17VarA = this.f22327a.a(strG, file);
                            if (r17VarA != null && r17VarA.a() == 200) {
                                d(r17VarA);
                                return;
                            }
                            if (r17VarA == null) {
                                str3 = "report upload error:response is null";
                            } else {
                                str3 = "report upload error:response code is " + r17VarA.a() + ", msg is " + r17VarA.b();
                            }
                            cVar2 = cVar;
                            try {
                                x(cVar2, -110, str3);
                            } catch (IOException e2) {
                                e = e2;
                                str2 = str;
                                x(cVar2, TECameraResult.TER_BUFFER_EMPTY, e.toString());
                                this.c.c(str2, "report upload network io exception:" + e.toString());
                                if (k17.k()) {
                                    e.printStackTrace();
                                }
                            } catch (Exception e3) {
                                e = e3;
                                x(cVar2, TECameraResult.TER_BUFFER_EMPTY, e.toString());
                                this.c.c(str, "report upload network exception:" + e.toString());
                                if (k17.k()) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (IOException e4) {
                            e = e4;
                            cVar2 = cVar;
                        } catch (Exception e5) {
                            e = e5;
                            cVar2 = cVar;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        cVar2 = cVar;
                    } catch (Exception e7) {
                        e = e7;
                        cVar2 = cVar;
                    }
                } catch (IOException e8) {
                    e = e8;
                    cVar2 = cVar;
                    str = "report_log_info";
                }
            } catch (IOException e9) {
                e = e9;
                cVar2 = cVar;
                str2 = "report_log_info";
            }
        } catch (Exception e10) {
            e = e10;
            cVar2 = cVar;
            str = "report_log_info";
        }
    }

    public final void h(c cVar, int i, String str) {
        if (this.f22327a == null) {
            this.c.c("report_log_info", "upload code error : HttpDelegate is null");
            return;
        }
        if (cVar == null) {
            this.c.c("report_log_info", "upload code error : UploadBody is null");
            return;
        }
        try {
            String strG = sd7.g(cVar.f22331a, cVar.f, "", i, str, cVar.b, this.b.a(), this.b.g(), TextUtils.isEmpty(this.b.j()) ? o17.d(o17.a()) : this.b.j(), cVar.g, cVar.h, cVar.d, this.g, cVar.i, this.c);
            this.c.a("NearX-HLog", "reportUpload Error Code: ".concat(String.valueOf(strG)));
            this.f22327a.a(strG);
        } catch (Exception e2) {
            this.c.c("report_log_info", "upload code error:" + e2.toString());
        }
    }

    public final void i(d dVar) {
        if (dVar.e && !g47.e()) {
            this.c.b("upload_log_info", "upload task need wifi connect");
            l(dVar, -121, "upload task need wifi connect");
            h hVar = this.f;
            if (hVar != null) {
                hVar.a("upload task need wifi connect");
                return;
            }
            return;
        }
        try {
            dw6 dw6Var = this.h;
            if (dw6Var != null) {
                dw6Var.a();
            }
            l77.b(dVar.c, dVar.d, this.b, this.g, dVar.f, new a(dVar));
        } catch (Exception e2) {
            y(dVar, -1, e2.toString());
        }
    }

    public void j(d dVar, int i) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = dVar;
        this.e.sendMessageDelayed(messageObtain, i);
    }

    public final void k(d dVar, int i, File file) {
        String str;
        String str2 = this.f22327a == null ? "upload fail : HttpDelegate is null" : "";
        if (dVar == null) {
            str2 = "upload fail : uploadBody is null";
        }
        if (file == null) {
            str2 = "upload fail : file is null";
        }
        if (!TextUtils.isEmpty(str2)) {
            this.c.c("upload_log_info", str2);
            h hVar = this.f;
            if (hVar != null) {
                hVar.a(str2);
                return;
            }
            return;
        }
        try {
            String strF = sd7.f(dVar.f22332a, dVar.f, file.getName(), i, "", dVar.b, this.b.a(), this.b.g(), TextUtils.isEmpty(this.b.j()) ? o17.d(o17.a()) : this.b.j());
            this.c.a("NearX-HLog", "doUpload Code: ".concat(String.valueOf(strF)));
            r17 r17VarA = this.f22327a.a(strF, file);
            if (r17VarA != null && r17VarA.a() == 200) {
                w();
                return;
            }
            if (r17VarA == null) {
                str = "upload error:response is null";
            } else {
                str = "upload error:response code is " + r17VarA.a() + ", msg is " + r17VarA.b();
            }
            y(dVar, -110, str);
        } catch (IOException e2) {
            y(dVar, TECameraResult.TER_BUFFER_EMPTY, e2.toString());
            this.c.c("upload_log_info", "upload network io exception:" + e2.toString());
            if (k17.k()) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            y(dVar, TECameraResult.TER_BUFFER_EMPTY, e3.toString());
            this.c.c("upload_log_info", "upload network exception:" + e3.toString());
            if (k17.k()) {
                e3.printStackTrace();
            }
        }
    }

    public final void l(d dVar, int i, String str) {
        cw6 cw6Var;
        String str2;
        if (this.f22327a == null) {
            cw6Var = this.c;
            str2 = "upload code error : HttpDelegate is null";
        } else {
            if (dVar != null) {
                try {
                    String strF = sd7.f(dVar.f22332a, dVar.f, "", i, str, dVar.b, this.b.a(), this.b.g(), TextUtils.isEmpty(this.b.j()) ? o17.d(o17.a()) : this.b.j());
                    this.c.a("NearX-HLog", "upload Error Code: ".concat(String.valueOf(strF)));
                    this.f22327a.a(strF);
                    return;
                } catch (Exception e2) {
                    this.c.c("upload_log_info", "upload code error:" + e2.toString());
                    if (k17.k()) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            cw6Var = this.c;
            str2 = "upload code error : UploadBody is null";
        }
        cw6Var.c("upload_log_info", str2);
    }

    public void m(h hVar) {
        this.f = hVar;
    }

    public void u(String str, String str2, f fVar) {
        e eVar = new e(str, str2);
        eVar.a(fVar);
        Message messageObtain = Message.obtain();
        messageObtain.obj = eVar;
        this.e.sendMessage(messageObtain);
    }

    public final void w() {
        this.d = 0;
        l77.d(this.g);
        h hVar = this.f;
        if (hVar != null) {
            hVar.a();
        }
    }

    public final void x(c cVar, int i, String str) {
        l77.d(this.g);
        int i2 = this.d;
        if (i2 >= 3) {
            this.c.b("report_log_info", "report upload failed");
            this.d = 0;
            h(cVar, i, str);
        } else {
            int i3 = i2 + 1;
            this.d = i3;
            f(cVar, i3 * 2000);
        }
    }

    public final void y(d dVar, int i, String str) {
        l77.d(this.g);
        int i2 = this.d;
        if (i2 < 3) {
            int i3 = i2 + 1;
            this.d = i3;
            j(dVar, i3 * 2000);
        } else {
            this.c.b("upload_log_info", "upload failed");
            this.d = 0;
            h hVar = this.f;
            if (hVar != null) {
                hVar.a("run out of retry:".concat(String.valueOf(str)));
            }
            l(dVar, i, str);
        }
    }

    public final void z(String str, String str2, f fVar) {
        if (this.f22327a == null) {
            this.c.c("upload_log_info", "check upload failed : HttpDelegate is null");
            return;
        }
        try {
            String strE = sd7.e(str, str2, this.b.a(), this.b.g(), TextUtils.isEmpty(this.b.j()) ? o17.d(o17.a()) : this.b.j());
            this.c.a("NearX-HLog", "doUploadChecker: ".concat(String.valueOf(strE)));
            UserTraceConfigDto userTraceConfigDtoB = this.f22327a.b(strE);
            if (userTraceConfigDtoB == null || (TextUtils.isEmpty(userTraceConfigDtoB.getImei()) && TextUtils.isEmpty(userTraceConfigDtoB.getOpenId()))) {
                if (fVar != null) {
                    fVar.a("userTraceConfigDto or device id is empty");
                }
            } else if (fVar != null) {
                this.c.b("upload_log_info", "need upload log");
                fVar.a(userTraceConfigDtoB);
            }
        } catch (Exception e2) {
            if (fVar != null) {
                fVar.a(e2.toString());
            }
        }
    }
}
