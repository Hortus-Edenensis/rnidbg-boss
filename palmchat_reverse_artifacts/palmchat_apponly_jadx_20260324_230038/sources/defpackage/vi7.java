package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.media3.common.C;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class vi7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f21456a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            vi7.c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f21457a;
        public String b;
        public long c;

        public b(String str) {
            String[] strArrSplit = str.split("\\s+");
            if (strArrSplit.length != 3) {
                n37.a();
                n37.b("NPTH_CATCH", new RuntimeException("err ProcessTrack line:" + str));
                return;
            }
            this.f21457a = strArrSplit[0];
            this.b = strArrSplit[1];
            try {
                this.c = Long.parseLong(strArrSplit[2]);
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", new RuntimeException("err ProcessTrack line:" + str, th));
            }
        }
    }

    public static File a(long j) {
        return new File(wi7.E(x97.m()), "apmlite/ProcessTrack/" + ((j - (j % 86400000)) / 86400000));
    }

    public static HashMap<String, b> b(long j, String str) throws Throwable {
        File file = new File(wi7.E(x97.m()), "apmlite/ProcessTrack/" + ((j - (j % 86400000)) / 86400000));
        String[] list = file.list();
        HashMap<String, b> map = new HashMap<>();
        if (list != null) {
            for (String str2 : list) {
                File file2 = new File(file, str2);
                long length = file2.length();
                try {
                    JSONArray jSONArrayH = re7.h(file2, length > 1048576 ? length - PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : 0L);
                    int length2 = jSONArrayH.length() - 1;
                    while (true) {
                        if (length2 >= 0) {
                            String strOptString = jSONArrayH.optString(length2);
                            if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith(str)) {
                                map.put(str2.replace('_', ':').replace(".txt", ""), new b(strOptString));
                                break;
                            }
                            length2--;
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
        return map;
    }

    public static void c() {
        File file;
        String[] list;
        if (kv6.k(x97.m()) && (list = (file = new File(wi7.E(x97.m()), "apmlite/ProcessTrack/")).list()) != null && list.length > 25) {
            Arrays.sort(list);
            for (int i = 0; i < list.length - 25; i++) {
                re7.r(new File(file, list[i]));
            }
        }
    }

    public static void d(String str, String str2) {
        try {
            File fileE = e();
            if (fileE != null) {
                re7.j(fileE, str + ' ' + str2 + ' ' + System.currentTimeMillis() + '\n', true);
            }
        } catch (Throwable unused) {
        }
    }

    public static File e() {
        if (f21456a == null) {
            String strM = kv6.m(x97.m());
            if (strM == null) {
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            f21456a = new File(wi7.E(x97.m()), "apmlite/ProcessTrack/" + ((jCurrentTimeMillis - (jCurrentTimeMillis % 86400000)) / 86400000) + '/' + strM.replace(':', '_') + ".txt");
            ih7.b().f(new a(), C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        }
        return f21456a;
    }
}
