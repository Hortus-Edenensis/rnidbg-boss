package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.plugin.nr;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.io.encoding.Base64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pblf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19326a = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "7dd4d2", new byte[]{40, 103, 89, 67, 65, 41});

    public static int a(Context context) {
        InputStream inputStreamOpen;
        int i;
        String string;
        ByteArrayOutputStream byteArrayOutputStream;
        int i2 = 255;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(nr.u(context).getAbsolutePath());
            i = 0;
            sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c28df8", new byte[]{Base64.padSymbol}));
            String str = f19326a;
            sb.append(str);
            string = sb.toString();
            File file = new File(string);
            if (file.exists()) {
                i2 = 2;
                file.delete();
            }
            inputStreamOpen = context.getResources().getAssets().open(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            inputStreamOpen = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i3 = inputStreamOpen.read(bArr, 0, 4096);
                if (i3 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i3);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.close();
            if (byteArrayOutputStream.size() <= 0) {
                i = 3;
            } else if (!new File(string).exists()) {
                i = i2;
            }
            try {
                inputStreamOpen.close();
            } catch (Throwable unused3) {
            }
            try {
                byteArrayOutputStream.close();
                return i;
            } catch (Throwable unused4) {
                return i;
            }
        } catch (Throwable unused5) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dfaa43", new byte[]{116, 103, 45, 18});
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable unused6) {
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable unused7) {
                    }
                }
                return i2;
            } finally {
            }
        }
    }
}
