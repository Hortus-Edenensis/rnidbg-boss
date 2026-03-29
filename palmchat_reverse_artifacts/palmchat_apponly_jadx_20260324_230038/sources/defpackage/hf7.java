package defpackage;

import android.text.TextUtils;
import com.zm.fda.Z200O.ZZ00Z;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class hf7 {
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004b: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:76), block:B:25:0x004b */
    public static JSONArray a(String str) throws Throwable {
        Closeable closeable;
        BufferedReader bufferedReader;
        Closeable closeable2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                bufferedReader = new BufferedReader(new FileReader(str));
                try {
                    File file = new File(str);
                    if (file.length() > ZZ00Z.y) {
                        bufferedReader.skip(file.length() - ZZ00Z.y);
                    }
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            wf7.a(bufferedReader);
                            return jSONArray;
                        }
                        jSONArray.put(line);
                    }
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    wf7.a(bufferedReader);
                    return null;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                wf7.a(closeable2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
        }
    }

    public static JSONArray b(String str) {
        try {
            return a(vb7.a(str, x97.o().getLogcatDumpCount(), x97.o().getLogcatLevel()).getAbsolutePath());
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
            return null;
        }
    }
}
