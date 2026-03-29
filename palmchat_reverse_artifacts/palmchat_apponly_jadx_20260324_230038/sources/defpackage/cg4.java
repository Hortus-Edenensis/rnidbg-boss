package defpackage;

import android.text.TextUtils;
import android.widget.ImageView;
import java.util.Calendar;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class cg4 {
    public static void a(String str, ImageView imageView, je1 je1Var) {
        gr2.j().h(str, imageView, je1Var);
    }

    public static boolean b(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        int i2 = calendar.get(6);
        calendar.setTimeInMillis(j2);
        return i == calendar.get(1) && i2 == calendar.get(6);
    }

    public static boolean c(long j, String str, long j2, String str2) {
        return (j > 0 && j == j2) || (!TextUtils.isEmpty(str) && TextUtils.equals(str, str2));
    }
}
