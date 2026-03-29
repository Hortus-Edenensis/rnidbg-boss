package com.bytedance.sdk.component.a.nr;

import android.text.TextUtils;
import com.bytedance.sdk.component.nr.u.iz;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.s;
import com.bytedance.sdk.component.utils.k;
import com.efs.sdk.base.Constants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends b {
    public File nr;
    public File u;

    public nr(l lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean iz(Map<String, String> map) {
        if (TextUtils.equals(map.get(HttpHeaders.ACCEPT_RANGES), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get(HttpHeaders.CONTENT_RANGE);
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(Map<String, String> map) {
        return TextUtils.equals(map.get("Content-Encoding"), Constants.CP_GZIP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn() {
        try {
            this.u.delete();
        } catch (Throwable unused) {
        }
        try {
            this.nr.delete();
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long x(Map<String, String> map) {
        String str = map.containsKey("content-length") ? map.get("content-length") : map.containsKey("Content-Length") ? map.get("Content-Length") : null;
        if (TextUtils.isEmpty(str) || str == null) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public nr(l lVar, String str, String str2, String str3) {
        super(lVar);
        u(str);
        u(str2, str3);
    }

    public void u(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.u = new File(str, str2);
        this.nr = new File(str, str2 + ".temp");
    }

    public void u(final com.bytedance.sdk.component.a.u.u uVar) {
        File file = this.u;
        if (file == null || this.nr == null) {
            if (uVar != null) {
                uVar.u(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.u.length() != 0 && uVar != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.a.nr nrVar = new com.bytedance.sdk.component.a.nr(true, 200, "Success", null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            nrVar.u(this.u);
            uVar.u(this, nrVar);
            return;
        }
        long length = this.nr.length();
        final long j = length >= 0 ? length : 0L;
        s.u uVar2 = new s.u();
        uVar2.u((Object) nr());
        nr(HttpHeaders.RANGE, "bytes=" + j + "-");
        if (TextUtils.isEmpty(this.iz)) {
            uVar.u(this, new IOException("Url is Empty"));
            return;
        }
        try {
            uVar2.u(this.iz);
            u(uVar2);
            this.fx.u(uVar2.u().nr()).u(new com.bytedance.sdk.component.nr.u.fx() { // from class: com.bytedance.sdk.component.a.nr.nr.1
                @Override // com.bytedance.sdk.component.nr.u.fx
                public void onFailure(com.bytedance.sdk.component.nr.u.nr nrVar2, IOException iOException) {
                    com.bytedance.sdk.component.a.u.u uVar3 = uVar;
                    if (uVar3 != null) {
                        uVar3.u(nr.this, iOException);
                    }
                    nr.this.pn();
                }

                /* JADX WARN: Removed duplicated region for block: B:125:0x0183 A[EDGE_INSN: B:125:0x0183->B:63:0x0183 BREAK  A[LOOP:1: B:51:0x014e->B:62:0x017f], SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:53:0x0158 A[Catch: all -> 0x0204, TryCatch #4 {all -> 0x0204, blocks: (B:45:0x012f, B:47:0x013d, B:49:0x0141, B:50:0x0147, B:51:0x014e, B:53:0x0158, B:55:0x0166, B:60:0x0173, B:65:0x0188, B:68:0x0194, B:70:0x019e, B:72:0x01aa, B:74:0x01b6, B:75:0x01c5, B:76:0x01d4, B:80:0x01f0), top: B:114:0x012f }] */
                /* JADX WARN: Removed duplicated region for block: B:65:0x0188 A[Catch: all -> 0x0204, TryCatch #4 {all -> 0x0204, blocks: (B:45:0x012f, B:47:0x013d, B:49:0x0141, B:50:0x0147, B:51:0x014e, B:53:0x0158, B:55:0x0166, B:60:0x0173, B:65:0x0188, B:68:0x0194, B:70:0x019e, B:72:0x01aa, B:74:0x01b6, B:75:0x01c5, B:76:0x01d4, B:80:0x01f0), top: B:114:0x012f }] */
                /* JADX WARN: Removed duplicated region for block: B:76:0x01d4 A[Catch: all -> 0x0204, TryCatch #4 {all -> 0x0204, blocks: (B:45:0x012f, B:47:0x013d, B:49:0x0141, B:50:0x0147, B:51:0x014e, B:53:0x0158, B:55:0x0166, B:60:0x0173, B:65:0x0188, B:68:0x0194, B:70:0x019e, B:72:0x01aa, B:74:0x01b6, B:75:0x01c5, B:76:0x01d4, B:80:0x01f0), top: B:114:0x012f }] */
                /* JADX WARN: Removed duplicated region for block: B:78:0x01ed  */
                /* JADX WARN: Removed duplicated region for block: B:79:0x01ef  */
                @Override // com.bytedance.sdk.component.nr.u.fx
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResponse(com.bytedance.sdk.component.nr.u.nr nrVar2, my myVar) throws IOException {
                    RandomAccessFile randomAccessFile;
                    long j2;
                    InputStream inputStreamFx;
                    byte[] bArr;
                    int i;
                    int i2;
                    if (uVar == null) {
                        return;
                    }
                    HashMap map = new HashMap();
                    if (myVar == null) {
                        return;
                    }
                    iz izVarX = myVar.x();
                    if (izVarX != null) {
                        for (int i3 = 0; i3 < izVarX.u(); i3++) {
                            map.put(izVarX.u(i3), izVarX.nr(i3));
                        }
                    }
                    com.bytedance.sdk.component.a.nr nrVar3 = new com.bytedance.sdk.component.a.nr(myVar.b(), myVar.fx(), myVar.pn(), map, null, myVar.nr(), myVar.u());
                    if (!myVar.b()) {
                        uVar.u(nr.this, nrVar3);
                        return;
                    }
                    long jU = myVar.iz().u();
                    if (jU <= 0) {
                        jU = nr.x(map);
                    }
                    boolean zIz = nr.iz(map);
                    int i4 = -1;
                    if (zIz) {
                        jU += j;
                        String str = (String) map.get(HttpHeaders.CONTENT_RANGE);
                        if (!TextUtils.isEmpty(str)) {
                            String str2 = "bytes " + j + "-" + (jU - 1);
                            if (TextUtils.indexOf(str, str2) == -1) {
                                nr.this.pn();
                                uVar.u(nr.this, new IOException("The Content-Range Header is invalid Assume[" + str2 + "] vs Real[" + str + "], please remove the temporary file [" + nr.this.nr + "]."));
                                return;
                            }
                        }
                    }
                    String str3 = "Rename fail";
                    if (jU > 0 && nr.this.nr.exists() && nr.this.nr.length() == jU) {
                        nr nrVar4 = nr.this;
                        if (!nrVar4.nr.renameTo(nrVar4.u)) {
                            uVar.u(nr.this, new IOException("Rename fail"));
                            return;
                        } else {
                            nrVar3.u(nr.this.u);
                            uVar.u(nr.this, nrVar3);
                            return;
                        }
                    }
                    InputStream inputStream = null;
                    try {
                        randomAccessFile = new RandomAccessFile(nr.this.nr, "rw");
                    } catch (Throwable unused) {
                        randomAccessFile = null;
                    }
                    if (!zIz) {
                        randomAccessFile.setLength(0L);
                        j2 = 0;
                        inputStreamFx = myVar.iz().fx();
                        if (nr.n(map)) {
                            inputStreamFx = new GZIPInputStream(inputStreamFx);
                        }
                        bArr = new byte[16384];
                        long j3 = 0;
                        i = 0;
                        while (true) {
                            i2 = inputStreamFx.read(bArr, i, 16384 - i);
                            boolean z = true;
                            if (i2 != i4) {
                            }
                            str3 = str;
                            i4 = -1;
                        }
                        String str4 = str3;
                        if (!zIz) {
                        }
                        if (jU <= 0) {
                            com.bytedance.sdk.component.a.u.u uVar3 = uVar;
                            nr nrVar5 = nr.this;
                            StringBuilder sb = new StringBuilder(" tempFile.length() == fileSize is");
                            sb.append(nr.this.nr.length() != jU);
                            uVar3.u(nrVar5, new IOException(sb.toString()));
                        }
                        inputStreamFx.close();
                        randomAccessFile.close();
                    }
                    randomAccessFile.seek(j);
                    j2 = j;
                    try {
                        inputStreamFx = myVar.iz().fx();
                        if (nr.n(map) && !(inputStreamFx instanceof GZIPInputStream)) {
                            inputStreamFx = new GZIPInputStream(inputStreamFx);
                        }
                        bArr = new byte[16384];
                        long j32 = 0;
                        i = 0;
                        while (true) {
                            i2 = inputStreamFx.read(bArr, i, 16384 - i);
                            boolean z2 = true;
                            if (i2 != i4) {
                                break;
                            }
                            i += i2;
                            String str5 = str3;
                            j32 += (long) i2;
                            if (j32 % 16384 != 0 && j32 != jU - j) {
                                z2 = false;
                            }
                            if (z2) {
                                randomAccessFile.seek(j2);
                                randomAccessFile.write(bArr, 0, i);
                                j2 += (long) i;
                                i = 0;
                            }
                            str3 = str5;
                            i4 = -1;
                        }
                        String str42 = str3;
                        if (!zIz) {
                            jU = nr.this.nr.length();
                        }
                        if (jU <= 0 && nr.this.nr.exists() && nr.this.nr.length() == jU) {
                            nr nrVar6 = nr.this;
                            if (nrVar6.nr.renameTo(nrVar6.u)) {
                                nrVar3.u(nr.this.u);
                                uVar.u(nr.this, nrVar3);
                            } else {
                                uVar.u(nr.this, new IOException(str42));
                            }
                        } else {
                            com.bytedance.sdk.component.a.u.u uVar32 = uVar;
                            nr nrVar52 = nr.this;
                            StringBuilder sb2 = new StringBuilder(" tempFile.length() == fileSize is");
                            sb2.append(nr.this.nr.length() != jU);
                            uVar32.u(nrVar52, new IOException(sb2.toString()));
                        }
                        try {
                            inputStreamFx.close();
                        } catch (Throwable unused2) {
                        }
                        try {
                            randomAccessFile.close();
                        } catch (Throwable unused3) {
                        }
                    } catch (Throwable th) {
                        try {
                            uVar.u(nr.this, new IOException(th.getMessage()));
                            if (!zIz) {
                                nr.this.pn();
                            }
                            if (0 != 0) {
                                try {
                                    inputStream.close();
                                } catch (Throwable unused4) {
                                }
                            }
                            try {
                                randomAccessFile.close();
                            } catch (Throwable unused5) {
                            }
                        } finally {
                        }
                    }
                }
            });
        } catch (IllegalArgumentException unused) {
            uVar.u(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0221 A[Catch: all -> 0x0216, TryCatch #18 {all -> 0x0216, blocks: (B:87:0x01ec, B:94:0x020e, B:105:0x022b, B:107:0x0233, B:109:0x023d, B:111:0x0247, B:115:0x0253, B:119:0x026f, B:123:0x0283, B:102:0x0221), top: B:211:0x01ec }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x020c A[EDGE_INSN: B:213:0x020c->B:93:0x020c BREAK  A[LOOP:1: B:73:0x01c4->B:89:0x01fd], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020e A[Catch: all -> 0x0216, TryCatch #18 {all -> 0x0216, blocks: (B:87:0x01ec, B:94:0x020e, B:105:0x022b, B:107:0x0233, B:109:0x023d, B:111:0x0247, B:115:0x0253, B:119:0x026f, B:123:0x0283, B:102:0x0221), top: B:211:0x01ec }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0218  */
    @Override // com.bytedance.sdk.component.a.nr.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.bytedance.sdk.component.a.nr u() {
        long j;
        RandomAccessFile randomAccessFile;
        long j2;
        Throwable th;
        byte[] bArr;
        int i;
        long j3;
        int i2;
        InputStream inputStream;
        long j4;
        File file = this.u;
        if (file != null && this.nr != null) {
            if (file.exists() && this.u.length() != 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.bytedance.sdk.component.a.nr nrVar = new com.bytedance.sdk.component.a.nr(true, 200, "Success", null, null, jCurrentTimeMillis, jCurrentTimeMillis);
                nrVar.u(this.u);
                return nrVar;
            }
            long length = this.nr.length();
            if (length < 0) {
                length = 0;
            }
            s.u uVar = new s.u();
            uVar.u((Object) nr());
            nr(HttpHeaders.RANGE, "bytes=" + length + "-");
            if (TextUtils.isEmpty(this.iz)) {
                k.nr("DownloadExecutor", "execute: Url is Empty");
                return new com.bytedance.sdk.component.a.nr(false, -9, "url is Empty", null, null, 0L, 0L);
            }
            try {
                uVar.u(this.iz);
                u(uVar);
                try {
                    my myVarNr = this.fx.u(uVar.u().nr()).nr();
                    if (myVarNr != null && myVarNr.b()) {
                        HashMap map = new HashMap();
                        iz izVarX = myVarNr.x();
                        if (izVarX != null) {
                            for (int i3 = 0; i3 < izVarX.u(); i3++) {
                                map.put(izVarX.u(i3), izVarX.nr(i3));
                            }
                        }
                        com.bytedance.sdk.component.a.nr nrVar2 = new com.bytedance.sdk.component.a.nr(myVarNr.b(), myVarNr.fx(), myVarNr.pn(), map, null, myVarNr.nr(), myVarNr.u());
                        long jU = myVarNr.iz().u();
                        if (jU <= 0) {
                            jU = x(map);
                        }
                        long length2 = this.nr.length();
                        boolean zIz = iz(map);
                        if (zIz) {
                            jU += length2;
                            String str = (String) map.get(HttpHeaders.CONTENT_RANGE);
                            if (!TextUtils.isEmpty(str)) {
                                if (TextUtils.indexOf(str, "bytes " + length2 + "-" + (jU - 1)) == -1) {
                                    pn();
                                    return new com.bytedance.sdk.component.a.nr(false, -7, "realRangeValue failed", null, null, 0L, 0L);
                                }
                            }
                            j = 0;
                        } else {
                            j = 0;
                        }
                        if (jU > j && this.nr.exists() && this.nr.length() == jU) {
                            if (this.nr.renameTo(this.u)) {
                                nrVar2.u(this.u);
                                return nrVar2;
                            }
                            return new com.bytedance.sdk.component.a.nr(false, -6, "rename failed", null, null, 0L, 0L);
                        }
                        InputStream inputStreamFx = null;
                        try {
                            randomAccessFile = new RandomAccessFile(this.nr, "rw");
                        } catch (Throwable unused) {
                            randomAccessFile = null;
                        }
                        if (zIz) {
                            randomAccessFile.seek(length);
                            j2 = length;
                            try {
                                inputStreamFx = myVarNr.iz().fx();
                                if (n(map) && !(inputStreamFx instanceof GZIPInputStream)) {
                                    inputStreamFx = new GZIPInputStream(inputStreamFx);
                                }
                                try {
                                    bArr = new byte[16384];
                                    i = 0;
                                    j3 = 0;
                                    while (true) {
                                        i2 = inputStreamFx.read(bArr, i, 16384 - i);
                                        inputStream = inputStreamFx;
                                        if (i2 != -1) {
                                            break;
                                        }
                                        i += i2;
                                        RandomAccessFile randomAccessFile2 = randomAccessFile;
                                        long j5 = j3 + ((long) i2);
                                        try {
                                            if (j5 % 16384 == 0 || j5 == jU - length) {
                                                randomAccessFile = randomAccessFile2;
                                                try {
                                                    randomAccessFile.seek(j2);
                                                    randomAccessFile.write(bArr, 0, i);
                                                    j4 = j5;
                                                    j2 += (long) i;
                                                    i = 0;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    th = th;
                                                    inputStreamFx = inputStream;
                                                    if (!zIz) {
                                                    }
                                                    com.bytedance.sdk.component.a.nr nrVar3 = new com.bytedance.sdk.component.a.nr(false, -3, "Error occured when FileRequest.parseHttpResponse", null, null, 0L, 0L, th);
                                                    if (inputStreamFx != null) {
                                                    }
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Throwable unused2) {
                                                    }
                                                    return nrVar3;
                                                }
                                            } else {
                                                j4 = j5;
                                                randomAccessFile = randomAccessFile2;
                                            }
                                            inputStreamFx = inputStream;
                                            j3 = j4;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            randomAccessFile = randomAccessFile2;
                                        }
                                    }
                                    if (i2 == 0) {
                                        randomAccessFile.seek(j2);
                                        randomAccessFile.write(bArr, 0, i);
                                    }
                                    if (zIz || length == 0) {
                                        jU = this.nr.length();
                                    }
                                    if (jU <= 0 && this.nr.exists() && this.nr.length() == jU) {
                                        if (this.nr.renameTo(this.u)) {
                                            nrVar2.u(this.u);
                                            try {
                                                inputStream.close();
                                            } catch (Throwable unused3) {
                                            }
                                            try {
                                                randomAccessFile.close();
                                            } catch (Throwable unused4) {
                                            }
                                            return nrVar2;
                                        }
                                        com.bytedance.sdk.component.a.nr nrVar4 = new com.bytedance.sdk.component.a.nr(false, -5, "rename failed", null, null, 0L, 0L);
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused5) {
                                        }
                                        try {
                                            randomAccessFile.close();
                                        } catch (Throwable unused6) {
                                        }
                                        return nrVar4;
                                    }
                                    StringBuilder sb = new StringBuilder(" tempFile.length() == fileSize is");
                                    sb.append(this.nr.length() != jU);
                                    com.bytedance.sdk.component.a.nr nrVar5 = new com.bytedance.sdk.component.a.nr(false, -4, sb.toString(), null, null, 0L, 0L);
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused7) {
                                    }
                                    try {
                                        randomAccessFile.close();
                                    } catch (Throwable unused8) {
                                    }
                                    return nrVar5;
                                } catch (Throwable th4) {
                                    th = th4;
                                    th = th;
                                    if (!zIz) {
                                        try {
                                            pn();
                                        } finally {
                                        }
                                    }
                                    com.bytedance.sdk.component.a.nr nrVar32 = new com.bytedance.sdk.component.a.nr(false, -3, "Error occured when FileRequest.parseHttpResponse", null, null, 0L, 0L, th);
                                    if (inputStreamFx != null) {
                                        try {
                                            inputStreamFx.close();
                                        } catch (Throwable unused9) {
                                        }
                                    }
                                    randomAccessFile.close();
                                    return nrVar32;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } else {
                            randomAccessFile.setLength(0L);
                            j2 = 0;
                            inputStreamFx = myVarNr.iz().fx();
                            if (n(map)) {
                                inputStreamFx = new GZIPInputStream(inputStreamFx);
                            }
                            bArr = new byte[16384];
                            i = 0;
                            j3 = 0;
                            while (true) {
                                i2 = inputStreamFx.read(bArr, i, 16384 - i);
                                inputStream = inputStreamFx;
                                if (i2 != -1) {
                                }
                                inputStreamFx = inputStream;
                                j3 = j4;
                            }
                            if (i2 == 0) {
                            }
                            if (zIz) {
                                jU = this.nr.length();
                            }
                            if (jU <= 0) {
                            }
                            StringBuilder sb2 = new StringBuilder(" tempFile.length() == fileSize is");
                            sb2.append(this.nr.length() != jU);
                            com.bytedance.sdk.component.a.nr nrVar52 = new com.bytedance.sdk.component.a.nr(false, -4, sb2.toString(), null, null, 0L, 0L);
                            inputStream.close();
                            randomAccessFile.close();
                            return nrVar52;
                        }
                    } else {
                        return new com.bytedance.sdk.component.a.nr(false, myVarNr == null ? -2 : myVarNr.fx(), myVarNr == null ? "ok response is null" : myVarNr.pn(), null, null, 0L, 0L);
                    }
                } catch (IOException e) {
                    pn();
                    return new com.bytedance.sdk.component.a.nr(false, -1, e.getMessage(), null, null, 0L, 0L, e);
                }
            } catch (IllegalArgumentException unused10) {
                k.nr("DownloadExecutor", "Url is not a valid HTTP or HTTPS URL");
                return new com.bytedance.sdk.component.a.nr(false, -8, "Url is not a valid HTTP or HTTPS URL", null, null, 0L, 0L);
            }
        } else {
            StringBuilder sb3 = new StringBuilder("file == null: ");
            sb3.append(this.u == null);
            sb3.append(" tempFile == null: ");
            sb3.append(this.nr == null);
            return new com.bytedance.sdk.component.a.nr(false, -10, sb3.toString(), null, null, 0L, 0L);
        }
    }
}
