package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.zenmen.palmchat.fileupload.blockupload.CancellationHandler;
import com.zenmen.palmchat.fileupload.dao.BlockVo;
import com.zenmen.palmchat.fileupload.dao.FileUploadCheckDao;
import com.zenmen.palmchat.fileupload.dao.MultiPartSingleFileUploadDao;
import com.zenmen.palmchat.fileupload.dao.UploadResultVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class nu1 implements kn2 {
    public static final String x = "nu1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19603a;
    public String b;
    public File c;
    public String d;
    public String e;
    public int f;
    public int g;
    public String h;
    public Context i;
    public a56 j;
    public ThreadPoolExecutor k;
    public FileUploadCheckDao.CheckVO l;
    public lu1 m;
    public float n;
    public float o;
    public long p;
    public long q;
    public boolean r;
    public boolean s;
    public String t;
    public boolean u;
    public Object v;
    public CancellationHandler w;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements lu1 {

        /* JADX INFO: renamed from: nu1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1253a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ UploadResultVo f19605a;

            public C1253a(UploadResultVo uploadResultVo) {
                this.f19605a = uploadResultVo;
                put("action", LogUtil.VALUE_FILE_UPLOAD);
                put("status", "success");
                put("detail", uploadResultVo.toString());
                put("type", Integer.valueOf(nu1.this.f));
                put("fileName", nu1.this.d);
                put("fileSize", Long.valueOf(nu1.this.c.length()));
                put("isHd", Integer.valueOf(nu1.this.g));
                put("md5", nu1.this.p());
                put("mid", nu1.this.h);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", LogUtil.VALUE_FILE_UPLOAD);
                put("status", "fail");
                put("type", Integer.valueOf(nu1.this.f));
                put("fileName", nu1.this.d);
                put("fileSize", Long.valueOf(nu1.this.c.length()));
                put("isHd", Integer.valueOf(nu1.this.g));
                put("md5", nu1.this.p());
                put("mid", nu1.this.h);
            }
        }

        public a() {
        }

        @Override // defpackage.lu1
        public void a(int i, UploadResultVo uploadResultVo, String str, Exception exc) {
            LogUtil.i(nu1.x, "onComplete status=" + i + " response=" + str);
            if (nu1.this.j != null) {
                if (i == 0) {
                    LogUtil.i(nu1.x, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new C1253a(uploadResultVo), (Throwable) null);
                    nu1.this.v(false, i);
                    uploadResultVo.setMd5(nu1.this.p());
                    nu1.this.j.b(uploadResultVo);
                } else if (i == 1) {
                    LogUtil.i(nu1.x, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new b(), exc);
                    nu1.this.j.a(exc);
                    nu1.this.w.cancel();
                }
                if (i == 3 && nu1.this.q() == nu1.this.c.length()) {
                    nu1.this.r();
                }
                if (i == 2) {
                    nu1.this.v(true, i);
                }
                if (i == 5) {
                    nu1.this.v(false, i);
                }
            }
        }

        @Override // defpackage.lu1
        public void b(int i, int i2, int i3) {
            nu1.this.v(true, -1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f19607a;

        public b(boolean z) {
            this.f19607a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (nu1.this.w.isCancelled()) {
                return;
            }
            nu1.this.u(this.f19607a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("action", LogUtil.VALUE_FILE_UPLOAD);
            put("status", "start");
            put("type", Integer.valueOf(nu1.this.f));
            put("fileName", nu1.this.d);
            put("fileSize", Long.valueOf(nu1.this.c.length()));
            put("isHd", Integer.valueOf(nu1.this.g));
            put("mid", nu1.this.h);
            put("md5", nu1.this.p());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("action", LogUtil.VALUE_FILE_UPLOAD);
            put("status", "start_check");
            put("type", Integer.valueOf(nu1.this.f));
            put("fileName", nu1.this.d);
            put("fileSize", Long.valueOf(nu1.this.c.length()));
            put("isHd", Integer.valueOf(nu1.this.g));
            put("mid", nu1.this.h);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put("action", LogUtil.VALUE_FILE_UPLOAD);
            put("status", "check_finish");
            put("type", Integer.valueOf(nu1.this.f));
            put("fileName", nu1.this.d);
            put("fileSize", Long.valueOf(nu1.this.c.length()));
            put("isHd", Integer.valueOf(nu1.this.g));
            put("mid", nu1.this.h);
            put("md5", nu1.this.p());
            put("checkResult", Integer.valueOf(nu1.this.l.type == 2 ? 1 : 0));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {
        public f() {
            put("action", LogUtil.VALUE_FILE_UPLOAD);
            put("status", "start_upload_single");
            put("type", Integer.valueOf(nu1.this.f));
            put("fileName", nu1.this.d);
            put("fileSize", Long.valueOf(nu1.this.c.length()));
            put("isHd", Integer.valueOf(nu1.this.g));
            put("mid", nu1.this.h);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f19612a;
        public final /* synthetic */ long b;

        public g(long j, long j2) {
            this.f19612a = j;
            this.b = j2;
            put("action", LogUtil.VALUE_FILE_UPLOAD);
            put("status", "finish_upload_file");
            put("duration", Long.valueOf(j - j2));
            put("type", Integer.valueOf(nu1.this.f));
            put("fileName", nu1.this.d);
            put("fileSize", Long.valueOf(nu1.this.c.length()));
            put("isHd", Integer.valueOf(nu1.this.g));
            put("mid", nu1.this.h);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements CancellationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f19613a = false;

        public h() {
        }

        @Override // com.zenmen.palmchat.fileupload.blockupload.CancellationHandler
        public void cancel() {
            this.f19613a = true;
        }

        @Override // com.zenmen.palmchat.fileupload.blockupload.CancellationHandler
        public boolean isCancelled() {
            return this.f19613a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i implements tl2 {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public UploadResultVo f19614a;
        public Exception b;

        public j() {
        }
    }

    public nu1(File file, int i2, boolean z, String str, a56 a56Var, ExecutorService executorService, String str2, Context context, int i3, String str3) {
        this.e = "";
        this.m = new a();
        this.n = 0.0f;
        this.o = 0.01f;
        this.p = 1000L;
        this.q = 0L;
        this.r = false;
        this.s = false;
        this.u = true;
        this.v = new Object();
        this.w = new h();
        this.c = file;
        this.d = str;
        this.j = a56Var;
        if (i2 == 4) {
            this.r = true;
            i2 = 0;
        }
        this.f = i2;
        this.g = z ? 1 : 0;
        this.k = (ThreadPoolExecutor) executorService;
        this.h = str2;
        this.i = context;
        this.f19603a = i3;
        this.b = str3;
        this.s = mu1.a();
    }

    @Override // defpackage.kn2
    public void a(boolean z) {
        try {
            this.k.submit(new b(z));
        } catch (RejectedExecutionException e2) {
            this.m.a(1, null, null, e2);
        }
    }

    @Override // defpackage.zy
    public void cancel() {
        this.w.cancel();
    }

    public final String p() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = rb3.b(this.c);
        }
        return this.e;
    }

    public final int q() {
        ArrayList<BlockVo> arrayList;
        FileUploadCheckDao.CheckVO checkVO = this.l;
        int i2 = 0;
        if (checkVO != null && (arrayList = checkVO.blockVOs) != null) {
            for (BlockVo blockVo : arrayList) {
                i2 += blockVo.offset;
                LogUtil.i(x, "getUploadProgress +=" + blockVo.offset);
            }
        }
        LogUtil.i(x, "getUploadProgress=" + i2);
        return i2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v4 ??, still in use, count: 1, list:
          (r0v4 ?? I:com.zenmen.palmchat.fileupload.dao.FileUploadMkfileDao) from 0x005e: INVOKE (r15v6 ?? I:com.zenmen.palmchat.fileupload.dao.UploadResultVo) = (r0v4 ?? I:com.zenmen.palmchat.fileupload.dao.FileUploadMkfileDao) VIRTUAL call: com.zenmen.palmchat.fileupload.dao.FileUploadMkfileDao.mkFile():com.zenmen.palmchat.fileupload.dao.UploadResultVo A[Catch: Exception -> 0x0080, MD:():com.zenmen.palmchat.fileupload.dao.UploadResultVo throws java.lang.Exception (m), TRY_LEAVE] (LINE:95)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public final com.zenmen.palmchat.fileupload.dao.UploadResultVo r() {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = defpackage.nu1.x
            java.lang.String r2 = "mkFile"
            com.zenmen.palmchat.utils.log.LogUtil.i(r0, r2)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            com.zenmen.palmchat.fileupload.dao.FileUploadCheckDao$CheckVO r0 = r1.l
            if (r0 == 0) goto L2a
            java.util.ArrayList<com.zenmen.palmchat.fileupload.dao.BlockVo> r0 = r0.blockVOs
            java.util.Iterator r0 = r0.iterator()
        L18:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L2a
            java.lang.Object r2 = r0.next()
            com.zenmen.palmchat.fileupload.dao.BlockVo r2 = (com.zenmen.palmchat.fileupload.dao.BlockVo) r2
            java.lang.String r2 = r2.blockId
            r5.add(r2)
            goto L18
        L2a:
            com.zenmen.palmchat.fileupload.dao.FileUploadMkfileDao r0 = new com.zenmen.palmchat.fileupload.dao.FileUploadMkfileDao     // Catch: java.lang.Exception -> L80
            java.lang.String r4 = r1.t     // Catch: java.lang.Exception -> L80
            java.lang.String r6 = r19.p()     // Catch: java.lang.Exception -> L80
            int r7 = r1.f     // Catch: java.lang.Exception -> L80
            int r8 = r1.g     // Catch: java.lang.Exception -> L80
            java.io.File r3 = r1.c     // Catch: java.lang.Exception -> L80
            long r9 = r3.length()     // Catch: java.lang.Exception -> L80
            java.lang.String r11 = r1.d     // Catch: java.lang.Exception -> L80
            java.io.File r3 = r1.c     // Catch: java.lang.Exception -> L80
            long r12 = defpackage.cr0.a(r3)     // Catch: java.lang.Exception -> L80
            java.lang.String r14 = r1.h     // Catch: java.lang.Exception -> L80
            int r3 = r1.f19603a     // Catch: java.lang.Exception -> L80
            com.zenmen.palmchat.fileupload.dao.FileUploadCheckDao$CheckVO r15 = r1.l     // Catch: java.lang.Exception -> L80
            java.lang.String r15 = r15.upToken     // Catch: java.lang.Exception -> L80
            java.lang.String r2 = r1.b     // Catch: java.lang.Exception -> L80
            r17 = r2
            boolean r2 = r1.s     // Catch: java.lang.Exception -> L80
            r18 = r3
            r3 = r0
            r16 = r15
            r15 = r18
            r18 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r11, r12, r14, r15, r16, r17, r18)     // Catch: java.lang.Exception -> L80
            com.zenmen.palmchat.fileupload.dao.UploadResultVo r15 = r0.mkFile()     // Catch: java.lang.Exception -> L80
            if (r15 == 0) goto L6f
            lu1 r0 = r1.m     // Catch: java.lang.Exception -> L6c
            r2 = 0
            r3 = 0
            r0.a(r2, r15, r3, r3)     // Catch: java.lang.Exception -> L7e
            goto L8c
        L6c:
            r0 = move-exception
            r3 = 0
            goto L83
        L6f:
            r3 = 0
            lu1 r0 = r1.m     // Catch: java.lang.Exception -> L7e
            java.lang.Exception r2 = new java.lang.Exception     // Catch: java.lang.Exception -> L7e
            java.lang.String r4 = "mkFile resultVo is null"
            r2.<init>(r4)     // Catch: java.lang.Exception -> L7e
            r4 = 1
            r0.a(r4, r3, r3, r2)     // Catch: java.lang.Exception -> L7e
            goto L8c
        L7e:
            r0 = move-exception
            goto L83
        L80:
            r0 = move-exception
            r3 = 0
            r15 = r3
        L83:
            r0.printStackTrace()
            lu1 r2 = r1.m
            r4 = 1
            r2.a(r4, r3, r3, r0)
        L8c:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nu1.r():com.zenmen.palmchat.fileupload.dao.UploadResultVo");
    }

    public void s(boolean z) {
        this.u = z;
    }

    public void t(String str) {
        this.t = str;
    }

    public final void u(boolean z) {
        String str = x;
        LogUtil.LogType logType = LogUtil.LogType.LOG_TYPE_QA_NORMAL;
        LogUtil.i(str, logType, 3, new c(), (Throwable) null);
        if (this.i != null) {
            com.zenmen.palmchat.messaging.b.d().c().z(60000L);
        }
        if (z) {
            LogUtil.i(str, 3, new f(), (Throwable) null);
            j jVarX = x();
            UploadResultVo uploadResultVo = jVarX.f19614a;
            if (uploadResultVo != null) {
                this.m.a(0, uploadResultVo, null, null);
                return;
            } else {
                this.m.a(1, null, null, jVarX.b);
                return;
            }
        }
        LogUtil.i(str, 3, new d(), (Throwable) null);
        try {
            FileUploadCheckDao.CheckVO checkVOCheckSync = new FileUploadCheckDao(p(), this.f, this.c.length(), this.h, this.f19603a, this.r, this.s, this.b, this.u).checkSync();
            this.l = checkVOCheckSync;
            if (checkVOCheckSync == null) {
                this.m.a(1, null, null, new Exception("check failed,checkVO is null"));
            } else {
                LogUtil.i(str, logType, 3, new e(), (Throwable) null);
                w();
            }
        } catch (Exception e2) {
            this.m.a(1, null, null, e2);
        }
    }

    public final void v(boolean z, int i2) {
        if (z) {
            if (Math.abs(this.q - ir5.b()) >= this.p) {
                this.q = ir5.b();
                float fQ = (q() / this.c.length()) * 0.98f;
                if (fQ - this.n >= this.o) {
                    this.n = fQ;
                    this.j.onProgress((int) (fQ * 100.0f), (int) (this.c.length() * this.n));
                    return;
                }
                return;
            }
            return;
        }
        if (i2 == 5) {
            this.n = 0.01f;
            this.q = ir5.b();
            this.j.onProgress((int) (this.n * 100.0f), (int) (this.c.length() * this.n));
        } else if (i2 == 0) {
            this.n = 1.0f;
            this.q = ir5.b();
            this.j.onProgress((int) (this.n * 100.0f), (int) (this.c.length() * this.n));
        }
    }

    public final void w() {
        ArrayList<BlockVo> arrayList;
        BlockVo blockVo;
        FileUploadCheckDao.CheckVO checkVO = this.l;
        int i2 = 0;
        if (checkVO.type == 2) {
            this.m.a(0, checkVO.uploadResultVo, null, null);
            return;
        }
        this.m.a(5, checkVO.uploadResultVo, null, null);
        long length = this.c.length();
        int i3 = this.l.blockSize;
        int i4 = (int) (((length + ((long) i3)) - 1) / ((long) i3));
        ArrayList<BlockVo> arrayList2 = new ArrayList<>();
        for (int i5 = 0; i5 < i4; i5++) {
            ArrayList<BlockVo> arrayList3 = this.l.blockVOs;
            if (arrayList3 != null) {
                Iterator<BlockVo> it = arrayList3.iterator();
                while (it.hasNext()) {
                    blockVo = it.next();
                    if (blockVo.index == i5) {
                        break;
                    }
                }
                blockVo = null;
            } else {
                blockVo = null;
            }
            if (blockVo == null) {
                blockVo = new BlockVo();
                blockVo.index = i5;
                blockVo.offset = 0;
                long length2 = this.c.length();
                int i6 = this.l.blockSize;
                blockVo.size = Math.min((int) (length2 - ((long) (i5 * i6))), i6);
            }
            FileUploadCheckDao.CheckVO checkVO2 = this.l;
            blockVo.chunkSize = checkVO2.chunkSize;
            blockVo.paramSize = checkVO2.blockSize;
            arrayList2.add(blockVo);
        }
        this.l.blockVOs = arrayList2;
        if (q() == this.c.length()) {
            r();
            return;
        }
        long jB = ir5.b();
        while (i2 < i4) {
            BlockVo blockVo2 = arrayList2.get(i2);
            if (this.w.isCancelled() || blockVo2.offset == blockVo2.size) {
                arrayList = arrayList2;
            } else {
                arrayList = arrayList2;
                new cu(this.c, p(), this.m, this.w, blockVo2, this.h, this.f19603a, this.l.upToken, this.s, this.b).e();
            }
            i2++;
            arrayList2 = arrayList;
        }
        LogUtil.i(x, 3, new g(ir5.b(), jB), (Throwable) null);
    }

    public final j x() {
        j jVarY = y();
        for (int i2 = 0; i2 < 2 && jVarY.f19614a == null; i2++) {
            z(5000L);
            jVarY = y();
        }
        return jVarY;
    }

    public final j y() {
        LogUtil.i(x, "uploadSingleSegmentImp start");
        j jVar = new j();
        try {
            FileUploadCheckDao.CheckVO checkVOCheckSync = new FileUploadCheckDao(p(), this.f, this.c.length(), this.h, this.f19603a, this.r, this.s, this.b, this.u).checkSync(false);
            if (checkVOCheckSync != null) {
                int i2 = checkVOCheckSync.type;
                if (i2 == 2) {
                    jVar.f19614a = checkVOCheckSync.uploadResultVo;
                } else if (i2 == 1 || i2 == 0) {
                    UploadResultVo uploadResultVoUpload = new MultiPartSingleFileUploadDao(p(), this.f, this.g, this.c.length(), this.d, cr0.a(this.c), this.c, this.f19603a, this.b, checkVOCheckSync.upToken, this.s).upload();
                    jVar.f19614a = uploadResultVoUpload;
                    if (uploadResultVoUpload == null) {
                        jVar.b = new Exception("MultiPartSingleFileUploadDao resultVo is null");
                    }
                }
            } else {
                jVar.b = new Exception("FileUploadCheckDao resultVo is null");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            jVar.b = e2;
        }
        LogUtil.i(x, "uploadSingleSegmentImp end ex=" + jVar.b);
        return jVar;
    }

    public final void z(long j2) {
        synchronized (this.v) {
            try {
                this.v.wait(j2);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public nu1(File file, int i2, boolean z, String str, a56 a56Var, ExecutorService executorService, String str2, Context context, String str3) {
        this(file, i2, z, str, a56Var, executorService, str2, context, 0, str3);
    }

    public nu1(File file, int i2, String str, a56 a56Var, ExecutorService executorService, String str2, Context context, String str3) {
        this(file, i2, false, str, a56Var, executorService, str2, context, 0, str3);
    }
}
