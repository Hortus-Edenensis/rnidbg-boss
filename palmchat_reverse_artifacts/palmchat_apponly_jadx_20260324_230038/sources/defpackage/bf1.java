package defpackage;

import com.zenmen.palmchat.giftkit.play.GiftPlayVo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class bf1 extends jq<String, String> {
    public final long d;
    public final String e;

    public bf1(String str, long j, String str2) {
        super(str);
        this.d = j;
        this.e = str2;
    }

    @Override // defpackage.jq
    /* JADX INFO: renamed from: d */
    public void i() {
        new g13(new Runnable() { // from class: af1
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f1218a.l();
            }
        }).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006e A[Catch: Exception -> 0x006a, TRY_LEAVE, TryCatch #3 {Exception -> 0x006a, blocks: (B:40:0x0066, B:44:0x006e), top: B:51:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.InputStream, java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [bf1, jq] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l() throws Throwable {
        HttpURLConnection httpURLConnection;
        ?? inputStream = 0;
        inputStream = 0;
        try {
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.e).openConnection();
                    try {
                        inputStream = httpURLConnection.getInputStream();
                        File fileM = m(inputStream);
                        if (fileM != null && fileM.length() > 0) {
                            h(fileM.getAbsolutePath());
                            if (inputStream != 0) {
                                try {
                                    inputStream.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            httpURLConnection.disconnect();
                            return;
                        }
                        if (inputStream != 0) {
                            inputStream.close();
                        }
                        httpURLConnection.disconnect();
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (inputStream != 0) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            throw th;
                        }
                    }
                    if (0 != 0) {
                        inputStream.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                }
                if (0 != 0) {
                }
                throw th;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        g("downLoad failed");
    }

    public final File m(InputStream inputStream) throws Throwable {
        File file;
        byte[] bArr;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    file = new File(GiftPlayVo.getGiftAnimationLocalPath(this.d));
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Exception e2) {
                    e = e2;
                    file = null;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (file.createNewFile()) {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                bArr = new byte[4096];
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = fileOutputStream2;
                e.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return file;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                fileOutputStream2.write(bArr, 0, i);
                return file;
            }
            fileOutputStream2.flush();
            fileOutputStream = fileOutputStream2;
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        return file;
    }
}
