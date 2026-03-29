package ms.bz.bd.c.Pgl;

import android.content.res.AssetManager;
import com.umeng.analytics.pro.dn;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import ms.bz.bd.c.Pgl.pblz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
final class v0 extends pblz.pgla {
    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object b(long j, String str, Object obj) throws Throwable {
        InputStream inputStreamOpen;
        String str2 = str;
        AssetManager assets = pblw.b().a().getAssets();
        if (!str2.startsWith((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "213293", new byte[]{109}))) {
            str2 = ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7e5859", new byte[]{104})) + str2;
        }
        String[] list = assets.list("");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.length; i++) {
            if (list[i].endsWith(str2)) {
                String str3 = list[i];
                String absolutePath = File.createTempFile((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "510a94", new byte[]{41, 32, 70, dn.k, 18}), "").getAbsolutePath();
                FileOutputStream fileOutputStream = null;
                try {
                    inputStreamOpen = assets.open(str3);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(absolutePath);
                        try {
                            byte[] bArr = new byte[256];
                            long j2 = 0;
                            while (true) {
                                int i2 = inputStreamOpen.read(bArr);
                                if (i2 <= 0) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, i2);
                                j2 += (long) i2;
                            }
                            fileOutputStream2.flush();
                            if (j2 > 0) {
                                arrayList.add(absolutePath);
                            }
                            pblo.a(inputStreamOpen);
                            pblo.a(fileOutputStream2);
                        } catch (IOException unused) {
                            fileOutputStream = fileOutputStream2;
                            pblo.a(inputStreamOpen);
                            pblo.a(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            pblo.a(inputStreamOpen);
                            pblo.a(fileOutputStream);
                            throw th;
                        }
                    } catch (IOException unused2) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException unused3) {
                    inputStreamOpen = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamOpen = null;
                }
            }
        }
        return arrayList.toArray(new String[0]);
    }
}
