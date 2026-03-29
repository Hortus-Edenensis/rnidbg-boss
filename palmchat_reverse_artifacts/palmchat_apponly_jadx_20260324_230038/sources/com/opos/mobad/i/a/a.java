package com.opos.mobad.i.a;

import android.content.Context;
import android.util.Log;
import com.opos.mobad.i.b;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a implements com.opos.mobad.i.d {
    private int a(long j) {
        long j2 = (j / 1048576) + ((long) (j % 1048576 == 0 ? 0 : 1));
        if (j2 > 5) {
            j2 = 5;
        }
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "getBlockNum=" + j2);
        return (int) j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(Context context, com.opos.mobad.i.a aVar, com.opos.cmn.func.a.a.e eVar) {
        boolean z;
        if (context == null || aVar == null) {
            z = false;
        } else {
            try {
                if (eVar != null) {
                    if (200 == eVar.f7934a) {
                        z = c(context, aVar, eVar);
                    } else {
                        Log.d("DownloadEngineImpl", "downloadNormalFile httpResponseEntity.getResponseCode()=" + eVar.f7934a);
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadEngineImpl", "", (Throwable) e);
            } finally {
                eVar.a();
            }
        }
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "downloadNormalFile downloadRequest=", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(z));
        return z;
    }

    private boolean c(Context context, com.opos.mobad.i.a aVar, com.opos.cmn.func.a.a.e eVar) {
        boolean zA = (context == null || aVar == null || eVar == null) ? false : a(d.a(context, aVar), d.b(context, aVar), eVar.c, eVar.d, aVar.b);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "saveNormalFile downloadRequest=", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(zA));
        return zA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0405 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0178 A[Catch: Exception -> 0x014e, all -> 0x0414, TRY_ENTER, TryCatch #21 {Exception -> 0x014e, blocks: (B:9:0x002d, B:11:0x0033, B:78:0x014a, B:86:0x0178, B:88:0x0184, B:89:0x0187, B:91:0x018d, B:92:0x0190, B:94:0x01b3, B:96:0x01c0, B:98:0x01e8, B:100:0x01f6, B:99:0x01ed, B:105:0x0221), top: B:251:0x002d }] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v32, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v33, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r11v42 */
    /* JADX WARN: Type inference failed for: r11v43 */
    /* JADX WARN: Type inference failed for: r11v44 */
    /* JADX WARN: Type inference failed for: r11v45 */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r11v47 */
    /* JADX WARN: Type inference failed for: r11v48 */
    /* JADX WARN: Type inference failed for: r11v49 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v50 */
    /* JADX WARN: Type inference failed for: r11v51 */
    /* JADX WARN: Type inference failed for: r11v52 */
    /* JADX WARN: Type inference failed for: r11v53 */
    /* JADX WARN: Type inference failed for: r11v54 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23, types: [com.opos.cmn.func.a.a.e] */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v37 */
    /* JADX WARN: Type inference failed for: r13v38 */
    /* JADX WARN: Type inference failed for: r13v39 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v40 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v33 */
    /* JADX WARN: Type inference failed for: r14v34 */
    /* JADX WARN: Type inference failed for: r14v35 */
    /* JADX WARN: Type inference failed for: r14v36 */
    /* JADX WARN: Type inference failed for: r14v37 */
    /* JADX WARN: Type inference failed for: r14v38 */
    /* JADX WARN: Type inference failed for: r14v39 */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v29 */
    /* JADX WARN: Type inference failed for: r15v30 */
    /* JADX WARN: Type inference failed for: r15v31, types: [com.opos.mobad.i.a] */
    /* JADX WARN: Type inference failed for: r15v32 */
    /* JADX WARN: Type inference failed for: r15v35 */
    /* JADX WARN: Type inference failed for: r15v36 */
    /* JADX WARN: Type inference failed for: r15v38 */
    /* JADX WARN: Type inference failed for: r15v39 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v40 */
    /* JADX WARN: Type inference failed for: r15v41 */
    /* JADX WARN: Type inference failed for: r15v42 */
    /* JADX WARN: Type inference failed for: r15v43 */
    /* JADX WARN: Type inference failed for: r15v44 */
    /* JADX WARN: Type inference failed for: r15v45 */
    /* JADX WARN: Type inference failed for: r15v46 */
    /* JADX WARN: Type inference failed for: r15v47 */
    /* JADX WARN: Type inference failed for: r15v48 */
    /* JADX WARN: Type inference failed for: r15v49 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v50 */
    /* JADX WARN: Type inference failed for: r15v51 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v10 */
    /* JADX WARN: Type inference failed for: r24v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r24v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r24v6 */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r24v9 */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.opos.mobad.i.a.a] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.opos.mobad.i.a.c[]] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.opos.mobad.i.a.c] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Runnable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean d(Context context, com.opos.mobad.i.a aVar, com.opos.cmn.func.a.a.e eVar) throws Throwable {
        ?? r11;
        ?? r15;
        ?? r12;
        ?? r13;
        boolean zB;
        Object obj;
        Object obj2;
        com.opos.mobad.i.a aVar2;
        ?? r122;
        ?? r152;
        ?? r14;
        ?? r112;
        ?? r132;
        File fileA;
        File fileB;
        File fileC;
        String str;
        String str2;
        String str3;
        String str4;
        File file;
        int iA;
        boolean z;
        long[] jArr;
        long[] jArr2;
        Throwable th;
        long[] jArr3;
        Throwable th2;
        long[] jArr4;
        File file2;
        File file3;
        long[] jArr5;
        ?? r113;
        ?? r142;
        ?? r123;
        ?? r24;
        File file4;
        char c;
        ?? r153;
        ?? r242;
        String str5;
        com.opos.mobad.i.a aVar3;
        Object obj3;
        char c2;
        ?? r154;
        ?? r143;
        ?? r124;
        ?? r114;
        ?? r155;
        ?? r144;
        char c3;
        ?? r125;
        ?? r115;
        long j;
        ?? r4;
        ?? r26;
        ?? r243;
        File file5;
        File file6;
        String str6 = "downloadLargeFile";
        if (context == null || aVar == null) {
            r11 = "DownloadEngineImpl";
            r15 = aVar;
            r12 = eVar;
            r13 = 2;
            zB = false;
        } else {
            try {
                if (eVar != null) {
                    try {
                        try {
                            fileA = d.a(context, aVar);
                            fileB = d.b(context, aVar);
                            fileC = d.c(context, aVar);
                            str = "startPos[";
                            str2 = "blockNum=";
                            r122 = "]=";
                        } catch (Exception e) {
                            e = e;
                            obj = "DownloadEngineImpl";
                            obj2 = "downloadLargeFile";
                            aVar2 = aVar;
                        }
                        if (com.opos.cmn.an.e.b.a.a(fileC)) {
                            try {
                                if (com.opos.cmn.an.e.b.a.a(fileB)) {
                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "tmpFile and posFile all exists.");
                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "read pos info from posFile.");
                                    try {
                                        FileInputStream fileInputStream = new FileInputStream(fileC);
                                        try {
                                            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                                            try {
                                                iA = dataInputStream.readInt();
                                                try {
                                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "blockNum=" + iA);
                                                    file = fileA;
                                                    try {
                                                        jArr3 = new long[iA];
                                                        try {
                                                            jArr = new long[iA];
                                                            int i = 0;
                                                            while (i < iA) {
                                                                try {
                                                                    jArr3[i] = dataInputStream.readLong();
                                                                    int i2 = iA;
                                                                    try {
                                                                        StringBuilder sb = new StringBuilder();
                                                                        sb.append(str);
                                                                        sb.append(i);
                                                                        sb.append("]=");
                                                                        str3 = str;
                                                                        str4 = str2;
                                                                        try {
                                                                            sb.append(jArr3[i]);
                                                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
                                                                            jArr[i] = dataInputStream.readLong();
                                                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "endPos[" + i + "]=" + jArr[i]);
                                                                            i++;
                                                                            iA = i2;
                                                                            str = str3;
                                                                            str2 = str4;
                                                                        } catch (Throwable th3) {
                                                                            th = th3;
                                                                            th2 = th;
                                                                            iA = i2;
                                                                            try {
                                                                                throw th2;
                                                                            } catch (Throwable th4) {
                                                                                try {
                                                                                    try {
                                                                                        dataInputStream.close();
                                                                                        throw th4;
                                                                                    } catch (Throwable th5) {
                                                                                        th2.addSuppressed(th5);
                                                                                        throw th4;
                                                                                    }
                                                                                } catch (Throwable th6) {
                                                                                    th = th6;
                                                                                    z = true;
                                                                                    try {
                                                                                        throw th;
                                                                                    } catch (Throwable th7) {
                                                                                        try {
                                                                                            fileInputStream.close();
                                                                                            throw th7;
                                                                                        } catch (Throwable th8) {
                                                                                            try {
                                                                                                th.addSuppressed(th8);
                                                                                                throw th7;
                                                                                            } catch (Exception e2) {
                                                                                                e = e2;
                                                                                                jArr2 = jArr3;
                                                                                                com.opos.cmn.an.f.a.a("DownloadEngineImpl", "downloadLargeFile", (Throwable) e);
                                                                                                jArr4 = jArr2;
                                                                                                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "needInitPosInfo=" + z);
                                                                                                if (z) {
                                                                                                }
                                                                                                file2 = fileB;
                                                                                                file3 = fileC;
                                                                                                jArr5 = jArr4;
                                                                                                if (iA <= 0) {
                                                                                                }
                                                                                                zB = false;
                                                                                                r112 = r113;
                                                                                                r122 = r123;
                                                                                                r132 = c;
                                                                                                r14 = r142;
                                                                                                r152 = r153;
                                                                                                r242 = r24;
                                                                                                if (zB) {
                                                                                                }
                                                                                                eVar.a();
                                                                                                r11 = r112;
                                                                                                r12 = r122;
                                                                                                r13 = r132;
                                                                                                r15 = r152;
                                                                                                ?? r0 = new Object[6];
                                                                                                r0[0] = "downloadLargeFile downloadRequest";
                                                                                                r0[1] = r15;
                                                                                                r0[r13] = "netResponse=";
                                                                                                r0[3] = r12;
                                                                                                r0[4] = "result=";
                                                                                                r0[5] = Boolean.valueOf(zB);
                                                                                                com.opos.cmn.an.f.a.b((String) r11, (Object[]) r0);
                                                                                                return zB;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } catch (Throwable th9) {
                                                                        th = th9;
                                                                        str3 = str;
                                                                        str4 = str2;
                                                                    }
                                                                } catch (Throwable th10) {
                                                                    str3 = str;
                                                                    str4 = str2;
                                                                    th2 = th10;
                                                                }
                                                            }
                                                            int i3 = iA;
                                                            str3 = str;
                                                            str4 = str2;
                                                            try {
                                                                dataInputStream.close();
                                                                try {
                                                                    fileInputStream.close();
                                                                    jArr4 = jArr3;
                                                                    iA = i3;
                                                                    z = false;
                                                                } catch (Exception e3) {
                                                                    e = e3;
                                                                    jArr2 = jArr3;
                                                                    iA = i3;
                                                                    z = false;
                                                                    com.opos.cmn.an.f.a.a("DownloadEngineImpl", "downloadLargeFile", (Throwable) e);
                                                                    jArr4 = jArr2;
                                                                }
                                                            } catch (Throwable th11) {
                                                                th = th11;
                                                                iA = i3;
                                                                z = false;
                                                                throw th;
                                                            }
                                                        } catch (Throwable th12) {
                                                            str3 = "startPos[";
                                                            str4 = "blockNum=";
                                                            th2 = th12;
                                                            jArr = null;
                                                        }
                                                    } catch (Throwable th13) {
                                                        th = th13;
                                                        str3 = "startPos[";
                                                        str4 = "blockNum=";
                                                        th2 = th;
                                                        jArr = null;
                                                        jArr3 = null;
                                                        throw th2;
                                                    }
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                    str3 = "startPos[";
                                                    str4 = "blockNum=";
                                                    file = fileA;
                                                }
                                            } catch (Throwable th15) {
                                                str3 = "startPos[";
                                                str4 = "blockNum=";
                                                file = fileA;
                                                th2 = th15;
                                                iA = 0;
                                            }
                                        } catch (Throwable th16) {
                                            str3 = "startPos[";
                                            str4 = "blockNum=";
                                            file = fileA;
                                            th = th16;
                                            iA = 0;
                                            z = true;
                                            jArr = null;
                                            jArr3 = null;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        str3 = "startPos[";
                                        str4 = "blockNum=";
                                        file = fileA;
                                        iA = 0;
                                        z = true;
                                        jArr = null;
                                        jArr2 = null;
                                    }
                                } else {
                                    str3 = "startPos[";
                                    str4 = "blockNum=";
                                    file = fileA;
                                    iA = 0;
                                    z = true;
                                    jArr = null;
                                    jArr4 = null;
                                }
                                try {
                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "needInitPosInfo=" + z);
                                    if (z) {
                                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "tmpFile or posFile not exists.");
                                        if (com.opos.cmn.an.e.b.a.a(fileC)) {
                                            com.opos.cmn.an.e.b.a.e(fileC);
                                        }
                                        if (com.opos.cmn.an.e.b.a.a(fileB)) {
                                            com.opos.cmn.an.e.b.a.e(fileB);
                                        }
                                        a(fileC);
                                        a(fileB);
                                        iA = a(eVar.d);
                                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", str4 + iA);
                                        if (iA > 1) {
                                            int iA2 = a(eVar.d, iA);
                                            jArr4 = new long[iA];
                                            jArr = new long[iA];
                                            int i4 = 0;
                                            while (i4 < iA) {
                                                jArr4[i4] = i4 * iA2;
                                                StringBuilder sb2 = new StringBuilder();
                                                String str7 = str3;
                                                sb2.append(str7);
                                                sb2.append(i4);
                                                sb2.append("]=");
                                                File file7 = fileB;
                                                File file8 = fileC;
                                                sb2.append(jArr4[i4]);
                                                com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb2.toString());
                                                if (i4 == iA - 1) {
                                                    jArr[i4] = eVar.d;
                                                } else {
                                                    jArr[i4] = ((i4 + 1) * iA2) - 1;
                                                }
                                                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "endPos[" + i4 + "]=" + jArr[i4]);
                                                i4++;
                                                str3 = str7;
                                                fileB = file7;
                                                fileC = file8;
                                            }
                                        }
                                    }
                                    file2 = fileB;
                                    file3 = fileC;
                                    jArr5 = jArr4;
                                } catch (Exception e5) {
                                    e = e5;
                                    aVar2 = aVar;
                                    obj = "DownloadEngineImpl";
                                    obj2 = "downloadLargeFile";
                                    r122 = eVar;
                                    r112 = obj;
                                    r14 = obj2;
                                    r152 = aVar2;
                                    r132 = 2;
                                    zB = false;
                                    com.opos.cmn.an.f.a.a((String) r112, (String) r14, (Throwable) e);
                                    eVar.a();
                                    r11 = r112;
                                    r12 = r122;
                                    r13 = r132;
                                    r15 = r152;
                                    ?? r02 = new Object[6];
                                    r02[0] = "downloadLargeFile downloadRequest";
                                    r02[1] = r15;
                                    r02[r13] = "netResponse=";
                                    r02[3] = r12;
                                    r02[4] = "result=";
                                    r02[5] = Boolean.valueOf(zB);
                                    com.opos.cmn.an.f.a.b((String) r11, (Object[]) r02);
                                    return zB;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                r152 = aVar;
                                r112 = "DownloadEngineImpl";
                                r14 = "downloadLargeFile";
                                r122 = eVar;
                                zB = false;
                                r132 = 2;
                                com.opos.cmn.an.f.a.a((String) r112, (String) r14, (Throwable) e);
                                eVar.a();
                                r11 = r112;
                                r12 = r122;
                                r13 = r132;
                                r15 = r152;
                                ?? r022 = new Object[6];
                                r022[0] = "downloadLargeFile downloadRequest";
                                r022[1] = r15;
                                r022[r13] = "netResponse=";
                                r022[3] = r12;
                                r022[4] = "result=";
                                r022[5] = Boolean.valueOf(zB);
                                com.opos.cmn.an.f.a.b((String) r11, (Object[]) r022);
                                return zB;
                            }
                            if (iA <= 0) {
                                if (1 == iA) {
                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "blockNum=1,just download as normal file.");
                                    zB = b(context, aVar, eVar);
                                    r112 = "DownloadEngineImpl";
                                    r14 = "downloadLargeFile";
                                    r122 = eVar;
                                    r242 = file2;
                                    file4 = file3;
                                    r132 = 2;
                                    r152 = aVar;
                                } else {
                                    CountDownLatch countDownLatch = new CountDownLatch(iA);
                                    r14 = 0;
                                    r112 = jArr4;
                                    r132 = new c[iA];
                                    r152 = file2;
                                    while (r14 < iA) {
                                        try {
                                            try {
                                                j = eVar.d;
                                                str5 = str6;
                                                r4 = r132;
                                                r26 = r14;
                                                r243 = r152;
                                                file5 = file3;
                                                file6 = file;
                                            } catch (Throwable th17) {
                                                th = th17;
                                                eVar.a();
                                                throw th;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            str5 = str6;
                                            r152 = aVar;
                                            r112 = "DownloadEngineImpl";
                                            r122 = eVar;
                                            r14 = str5;
                                            zB = false;
                                            r132 = 2;
                                            com.opos.cmn.an.f.a.a((String) r112, (String) r14, (Throwable) e);
                                            eVar.a();
                                            r11 = r112;
                                            r12 = r122;
                                            r13 = r132;
                                            r15 = r152;
                                            ?? r0222 = new Object[6];
                                            r0222[0] = "downloadLargeFile downloadRequest";
                                            r0222[1] = r15;
                                            r0222[r13] = "netResponse=";
                                            r0222[3] = r12;
                                            r0222[4] = "result=";
                                            r0222[5] = Boolean.valueOf(zB);
                                            com.opos.cmn.an.f.a.b((String) r11, (Object[]) r0222);
                                            return zB;
                                        }
                                        try {
                                            r4[r26 == true ? 1 : 0] = new c(context, aVar, j, jArr5[r14], jArr[r14], countDownLatch);
                                            r132 = r4;
                                            file3 = file5;
                                            file = file6;
                                            r152 = r243;
                                            str6 = str5;
                                            r112 = j;
                                            r14 = (r26 == true ? 1 : 0) + 1;
                                        } catch (Exception e8) {
                                            e = e8;
                                            r152 = aVar;
                                            r112 = "DownloadEngineImpl";
                                            r122 = eVar;
                                            r14 = str5;
                                            zB = false;
                                            r132 = 2;
                                            com.opos.cmn.an.f.a.a((String) r112, (String) r14, (Throwable) e);
                                            eVar.a();
                                            r11 = r112;
                                            r12 = r122;
                                            r13 = r132;
                                            r15 = r152;
                                            ?? r02222 = new Object[6];
                                            r02222[0] = "downloadLargeFile downloadRequest";
                                            r02222[1] = r15;
                                            r02222[r13] = "netResponse=";
                                            r02222[3] = r12;
                                            r02222[4] = "result=";
                                            r02222[5] = Boolean.valueOf(zB);
                                            com.opos.cmn.an.f.a.b((String) r11, (Object[]) r02222);
                                            return zB;
                                        }
                                    }
                                    str5 = str6;
                                    ?? r42 = r132;
                                    ?? r244 = r152;
                                    File file9 = file3;
                                    File file10 = file;
                                    try {
                                        b bVar = new b(file9, iA, r42);
                                        bVar.start();
                                        for (int i5 = 0; i5 < iA; i5++) {
                                            com.opos.cmn.an.j.b.e(r42[i5]);
                                        }
                                        try {
                                            countDownLatch.await();
                                        } catch (InterruptedException e9) {
                                            com.opos.cmn.an.f.a.a("DownloadEngineImpl", "countDownLatch.await()", (Throwable) e9);
                                        }
                                        int i6 = 0;
                                        for (int i7 = 0; i7 < iA; i7++) {
                                            if (r42[i7].c()) {
                                                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "dlThreads[" + i7 + "] download success.");
                                                i6++;
                                            } else {
                                                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "dlThreads[" + i7 + "] download fail.");
                                            }
                                        }
                                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "successCount=" + i6);
                                        bVar.a();
                                        try {
                                            if (i6 == iA) {
                                                Object[] objArr = new Object[2];
                                                objArr[0] = "successCount = blockNum,download success.";
                                                try {
                                                    objArr[1] = aVar;
                                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", objArr);
                                                    try {
                                                        if (com.opos.cmn.an.e.b.a.a(file10)) {
                                                            r112 = "DownloadEngineImpl";
                                                            r152 = aVar;
                                                            r122 = eVar;
                                                            r14 = str5;
                                                            r132 = 2;
                                                            c3 = 2;
                                                            c3 = 2;
                                                            c2 = 2;
                                                            try {
                                                                com.opos.cmn.an.f.a.b((String) r112, "target file exists.");
                                                                file4 = file9;
                                                                if (a(file10, r152.b, r122.d)) {
                                                                    com.opos.cmn.an.f.a.b((String) r112, "targetFile exists and valid, don't need rename!");
                                                                    r115 = r112;
                                                                    r125 = r122;
                                                                    r144 = r14;
                                                                    r155 = r152;
                                                                } else {
                                                                    com.opos.cmn.an.f.a.b((String) r112, "targetFile exists but not valid, rename it!");
                                                                    com.opos.cmn.an.e.b.a.e(file10);
                                                                    if (a(file10, r244, r152.b, r122.d)) {
                                                                        com.opos.cmn.an.f.a.b((String) r112, "target file not exists.");
                                                                        r115 = r112;
                                                                        r125 = r122;
                                                                        r144 = r14;
                                                                        r155 = r152;
                                                                    } else {
                                                                        com.opos.cmn.an.e.b.a.e((File) r244);
                                                                        r114 = r112;
                                                                        r124 = r122;
                                                                        r143 = r14;
                                                                        r154 = r152;
                                                                        com.opos.cmn.an.e.b.a.e(file4);
                                                                        r113 = r114;
                                                                        r123 = r124;
                                                                        c = c2;
                                                                        r142 = r143;
                                                                        r153 = r154;
                                                                        r24 = r244;
                                                                    }
                                                                }
                                                                zB = true;
                                                                r112 = r115;
                                                                r122 = r125;
                                                                r132 = c3;
                                                                r14 = r144;
                                                                r152 = r155;
                                                                r242 = r244;
                                                            } catch (Exception e10) {
                                                                e = e10;
                                                                zB = false;
                                                                com.opos.cmn.an.f.a.a((String) r112, (String) r14, (Throwable) e);
                                                                eVar.a();
                                                                r11 = r112;
                                                                r12 = r122;
                                                                r13 = r132;
                                                                r15 = r152;
                                                                ?? r022222 = new Object[6];
                                                                r022222[0] = "downloadLargeFile downloadRequest";
                                                                r022222[1] = r15;
                                                                r022222[r13] = "netResponse=";
                                                                r022222[3] = r12;
                                                                r022222[4] = "result=";
                                                                r022222[5] = Boolean.valueOf(zB);
                                                                com.opos.cmn.an.f.a.b((String) r11, (Object[]) r022222);
                                                                return zB;
                                                            }
                                                        } else {
                                                            try {
                                                                r112 = "DownloadEngineImpl";
                                                                r132 = 2;
                                                                r132 = 2;
                                                                c = 2;
                                                                r14 = str5;
                                                                r152 = aVar;
                                                                r122 = eVar;
                                                                try {
                                                                    if (a(file10, r244, aVar.b, eVar.d)) {
                                                                        com.opos.cmn.an.f.a.b((String) r112, "target file not exists.");
                                                                        file4 = file9;
                                                                        zB = true;
                                                                        r112 = r112;
                                                                        r122 = r122;
                                                                        r14 = r14;
                                                                        r152 = r152;
                                                                        r242 = r244;
                                                                    } else {
                                                                        com.opos.cmn.an.e.b.a.e((File) r244);
                                                                        com.opos.cmn.an.e.b.a.e(file9);
                                                                        file4 = file9;
                                                                        r113 = r112;
                                                                        r123 = r122;
                                                                        r142 = r14;
                                                                        r153 = r152;
                                                                        r24 = r244;
                                                                    }
                                                                } catch (Exception e11) {
                                                                    e = e11;
                                                                    zB = false;
                                                                    com.opos.cmn.an.f.a.a((String) r112, (String) r14, (Throwable) e);
                                                                    eVar.a();
                                                                    r11 = r112;
                                                                    r12 = r122;
                                                                    r13 = r132;
                                                                    r15 = r152;
                                                                    ?? r0222222 = new Object[6];
                                                                    r0222222[0] = "downloadLargeFile downloadRequest";
                                                                    r0222222[1] = r15;
                                                                    r0222222[r13] = "netResponse=";
                                                                    r0222222[3] = r12;
                                                                    r0222222[4] = "result=";
                                                                    r0222222[5] = Boolean.valueOf(zB);
                                                                    com.opos.cmn.an.f.a.b((String) r11, (Object[]) r0222222);
                                                                    return zB;
                                                                }
                                                            } catch (Exception e12) {
                                                                e = e12;
                                                                r112 = "DownloadEngineImpl";
                                                                r152 = aVar;
                                                                r122 = eVar;
                                                                r14 = str5;
                                                                r132 = 2;
                                                            } catch (Throwable th18) {
                                                                th = th18;
                                                                eVar.a();
                                                                throw th;
                                                            }
                                                        }
                                                    } catch (Throwable th19) {
                                                        th = th19;
                                                    }
                                                } catch (Exception e13) {
                                                    e = e13;
                                                    obj3 = "DownloadEngineImpl";
                                                    aVar3 = aVar;
                                                    r122 = eVar;
                                                    r14 = str5;
                                                    r112 = obj3;
                                                    r152 = aVar3;
                                                    r132 = 2;
                                                    zB = false;
                                                    com.opos.cmn.an.f.a.a((String) r112, (String) r14, (Throwable) e);
                                                    eVar.a();
                                                    r11 = r112;
                                                    r12 = r122;
                                                    r13 = r132;
                                                    r15 = r152;
                                                    ?? r02222222 = new Object[6];
                                                    r02222222[0] = "downloadLargeFile downloadRequest";
                                                    r02222222[1] = r15;
                                                    r02222222[r13] = "netResponse=";
                                                    r02222222[3] = r12;
                                                    r02222222[4] = "result=";
                                                    r02222222[5] = Boolean.valueOf(zB);
                                                    com.opos.cmn.an.f.a.b((String) r11, (Object[]) r02222222);
                                                    return zB;
                                                }
                                            } else {
                                                com.opos.mobad.i.a aVar4 = aVar;
                                                String str8 = "DownloadEngineImpl";
                                                com.opos.cmn.func.a.a.e eVar2 = eVar;
                                                file4 = file9;
                                                String str9 = str5;
                                                c2 = 2;
                                                c3 = 2;
                                                com.opos.cmn.an.f.a.b(str8, "successCount != blockNum,maybe target file has download success,try it.", aVar4);
                                                if (a(file10, aVar4.b, eVar2.d)) {
                                                    com.opos.cmn.an.f.a.b(str8, "target file exists and valid,don't need rename.", aVar4);
                                                    r115 = str8;
                                                    r125 = eVar2;
                                                    r144 = str9;
                                                    r155 = aVar4;
                                                    zB = true;
                                                    r112 = r115;
                                                    r122 = r125;
                                                    r132 = c3;
                                                    r14 = r144;
                                                    r152 = r155;
                                                    r242 = r244;
                                                } else {
                                                    com.opos.cmn.an.e.b.a.e((File) r244);
                                                    r114 = str8;
                                                    r124 = eVar2;
                                                    r143 = str9;
                                                    r154 = aVar4;
                                                    com.opos.cmn.an.e.b.a.e(file4);
                                                    r113 = r114;
                                                    r123 = r124;
                                                    c = c2;
                                                    r142 = r143;
                                                    r153 = r154;
                                                    r24 = r244;
                                                }
                                            }
                                        } catch (Exception e14) {
                                            e = e14;
                                        }
                                    } catch (Exception e15) {
                                        e = e15;
                                        aVar3 = aVar;
                                        obj3 = "DownloadEngineImpl";
                                    }
                                }
                                if (zB) {
                                    try {
                                        com.opos.cmn.an.e.b.a.e((File) r242);
                                        com.opos.cmn.an.e.b.a.e(file4);
                                    } catch (Exception e16) {
                                        e = e16;
                                        com.opos.cmn.an.f.a.a((String) r112, (String) r14, (Throwable) e);
                                    }
                                }
                                eVar.a();
                                r11 = r112;
                                r12 = r122;
                                r13 = r132;
                                r15 = r152;
                            } else {
                                r113 = "DownloadEngineImpl";
                                r142 = "downloadLargeFile";
                                r123 = eVar;
                                r24 = file2;
                                file4 = file3;
                                c = 2;
                                r153 = aVar;
                            }
                            zB = false;
                            r112 = r113;
                            r122 = r123;
                            r132 = c;
                            r14 = r142;
                            r152 = r153;
                            r242 = r24;
                            if (zB) {
                            }
                            eVar.a();
                            r11 = r112;
                            r12 = r122;
                            r13 = r132;
                            r15 = r152;
                        }
                    } catch (Throwable th20) {
                        th = th20;
                    }
                }
            } catch (Throwable th21) {
                th = th21;
            }
        }
        ?? r022222222 = new Object[6];
        r022222222[0] = "downloadLargeFile downloadRequest";
        r022222222[1] = r15;
        r022222222[r13] = "netResponse=";
        r022222222[3] = r12;
        r022222222[4] = "result=";
        r022222222[5] = Boolean.valueOf(zB);
        com.opos.cmn.an.f.a.b((String) r11, (Object[]) r022222222);
        return zB;
    }

    private int a(long j, int i) {
        long j2 = 5 == i ? j / 5 : 1048576L;
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "getBlockSize=" + j2);
        return (int) j2;
    }

    @Override // com.opos.mobad.i.d
    public com.opos.mobad.i.b a(Context context, com.opos.mobad.i.a aVar) {
        boolean zA;
        b.a aVar2 = new b.a();
        if (context != null && aVar != null) {
            com.opos.cmn.func.a.a.e eVarA = com.opos.cmn.func.a.a.b.a().a(context, aVar.f8924a);
            long j = eVarA != null ? eVarA.d : 0L;
            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download contentLength=" + j);
            aVar2.a(j);
            if (a(context, aVar, j)) {
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file exists!don't need download again.fileInfo=" + a(aVar));
                zA = true;
            } else {
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target not exists,start download it now.fileInfo=" + a(aVar));
                if (a(aVar.c)) {
                    String str = aVar.d + ".lk";
                    a(str);
                    e eVar = new e(str);
                    try {
                        if (!eVar.a()) {
                            zA = false;
                        } else if (a(context, aVar, j)) {
                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file exists!don't need download again.fileInfo=" + a(aVar));
                            zA = true;
                        } else {
                            zA = a(context, aVar, eVarA);
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.a("DownloadEngineImpl", "", (Throwable) e);
                        zA = false;
                    } finally {
                        eVar.b();
                        com.opos.cmn.an.e.b.a.d(str);
                    }
                } else {
                    zA = a(context, aVar, eVarA);
                }
            }
            aVar2.a(zA);
            com.opos.mobad.i.b bVarA = aVar2.a();
            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download downloadRequest=", aVar, "downloadResponse=", bVarA);
            return bVarA;
        }
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "context or downloadRequest  is null.");
        zA = false;
        aVar2.a(zA);
        com.opos.mobad.i.b bVarA2 = aVar2.a();
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download downloadRequest=", aVar, "downloadResponse=", bVarA2);
        return bVarA2;
    }

    private String a(com.opos.mobad.i.a aVar) {
        if (aVar != null) {
            int i = aVar.c;
            if (i == 0) {
                return aVar.d;
            }
            if (i == 1) {
                return aVar.g;
            }
            if (i == 2) {
                return aVar.f + File.separator + aVar.g;
            }
        }
        return "";
    }

    private void a(File file) {
        if (file == null || com.opos.cmn.an.e.b.a.a(file)) {
            return;
        }
        if (!com.opos.cmn.an.e.b.a.b(com.opos.cmn.an.e.b.a.d(file))) {
            com.opos.cmn.an.e.b.a.c(file);
        }
        com.opos.cmn.an.e.b.a.f(file);
    }

    private void a(String str) {
        if (com.opos.cmn.an.d.b.a(str)) {
            return;
        }
        a(new File(str));
    }

    private boolean a(int i) {
        boolean z = i == 0;
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "needLockFile result=" + z);
        return z;
    }

    private boolean a(Context context, com.opos.mobad.i.a aVar, long j) {
        boolean zA;
        if (context == null || aVar == null) {
            zA = false;
        } else {
            try {
                zA = a(d.a(context, aVar), aVar.b, j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadEngineImpl", "verifyFileIntegrity", (Throwable) e);
                zA = false;
            }
        }
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "verifyFileIntegrity downloadRequest=", aVar, "contentLength=", Long.valueOf(j), "result=", Boolean.valueOf(zA));
        return zA;
    }

    private boolean a(Context context, com.opos.mobad.i.a aVar, com.opos.cmn.func.a.a.e eVar) {
        if (context != null && aVar != null && eVar != null) {
            try {
                if (eVar.d >= 1048576) {
                    com.opos.cmn.func.a.a.a aVar2 = eVar.f;
                    String strA = aVar2 != null ? aVar2.a(HttpHeaders.ACCEPT_RANGES) : "";
                    StringBuilder sb = new StringBuilder();
                    sb.append("download acceptRange=");
                    sb.append(strA != null ? strA : "");
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
                    if (!com.opos.cmn.an.d.b.a(strA)) {
                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "server support multi thread download ");
                        return d(context, aVar, eVar);
                    }
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "server don't support multi thread download,download as normal file.");
                } else {
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download normal file=" + aVar.d);
                }
                return b(context, aVar, eVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadEngineImpl", "download", (Throwable) e);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e A[Catch: all -> 0x0088, TryCatch #0 {all -> 0x0088, blocks: (B:6:0x0009, B:8:0x000f, B:10:0x002e, B:11:0x0039, B:13:0x0058, B:14:0x0074), top: B:26:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(File file, File file2, InputStream inputStream, long j, String str) {
        boolean zA = false;
        if (file != null && file2 != null && inputStream != null) {
            try {
            } finally {
                try {
                } finally {
                }
            }
            if (!com.opos.cmn.an.e.b.a.a(file)) {
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file not exists." + file.getAbsolutePath());
                if (com.opos.cmn.an.e.b.a.a(inputStream, file2)) {
                    zA = a(file, file2, str, j);
                }
            } else {
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file exists." + file.getAbsolutePath());
                if (a(file, str, j)) {
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "targetFile exists and valid, don't need rename!" + file.getAbsolutePath());
                    zA = true;
                } else {
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "targetFile exists but not valid, rename tmp file!");
                    com.opos.cmn.an.e.b.a.e(file);
                    if (com.opos.cmn.an.e.b.a.a(inputStream, file2)) {
                    }
                }
            }
        }
        return zA;
    }

    private boolean a(File file, File file2, String str, long j) {
        boolean z = file != null && file2 != null && a(file2, str, j) && com.opos.cmn.an.e.b.a.a(file2, file);
        StringBuilder sb = new StringBuilder();
        sb.append("verifyTmpFileAndRename destFile=");
        sb.append(file != null ? file.getAbsolutePath() : com.igexin.push.core.b.m);
        sb.append(",tmpFile=");
        sb.append(file2 != null ? file2.getAbsolutePath() : com.igexin.push.core.b.m);
        sb.append(",md5=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append("contentLength=");
        sb.append(j);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
        return z;
    }

    private boolean a(File file, String str) {
        boolean zEquals = !com.opos.cmn.an.d.b.a(str) ? com.opos.cmn.an.b.c.a(file).equals(str) : true;
        StringBuilder sb = new StringBuilder();
        sb.append("verifyFileIntegrity filePath=");
        sb.append(file != null ? file.getAbsolutePath() : com.igexin.push.core.b.m);
        sb.append(",md5=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(zEquals);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
        return zEquals;
    }

    private boolean a(File file, String str, long j) {
        boolean z = true;
        if (j <= 0 ? !com.opos.cmn.an.e.b.a.a(file) || !a(file, str) : j != com.opos.cmn.an.e.b.a.g(file) || !a(file, str)) {
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("verifyFileIntegrity filePath=");
        sb.append(file != null ? file.getAbsolutePath() : com.igexin.push.core.b.m);
        sb.append(",md5=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",contentLength=");
        sb.append(j);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
        return z;
    }
}
