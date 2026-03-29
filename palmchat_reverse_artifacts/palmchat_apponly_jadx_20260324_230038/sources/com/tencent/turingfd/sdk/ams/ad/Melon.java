package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Melon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10723a = Cfinally.a(Cfinally.A0);
    public static final String b = Cfinally.a(Cfinally.B0);
    public static boolean c = false;

    public static void a(Context context, Hickory hickory) {
        try {
            if (c) {
                return;
            }
            c = true;
            long jA = hickory.a(context, "502");
            int iMyUid = Process.myUid();
            if (jA == 0 || iMyUid == 0 || iMyUid == jA) {
                return;
            }
            hickory.a(context, "101", "", true);
            hickory.b(context, 0L);
            HashMap map = new HashMap();
            map.put("901", "");
            Hickory.a(context, map);
            new File(a(context)).delete();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(Context context) {
        File dir = context.getDir(f10723a, 0);
        if (dir == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dir.getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("1");
        File file = new File(sb.toString());
        if (!file.exists() && !file.mkdirs()) {
            return "";
        }
        return file.getAbsolutePath() + str + b;
    }
}
