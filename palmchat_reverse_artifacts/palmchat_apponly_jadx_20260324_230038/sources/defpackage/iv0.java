package defpackage;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class iv0 {
    public static String a(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static int[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str);
            if (date != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                return new int[]{calendar.get(1), calendar.get(2) + 1, calendar.get(5)};
            }
        } catch (ParseException unused) {
        }
        return null;
    }

    public static boolean c(Date date, Date date2, Date date3) {
        if (date != null && date2 != null && date3 != null) {
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(date2);
                Calendar calendar3 = Calendar.getInstance();
                calendar3.setTime(date3);
                if ((!calendar.after(calendar2) || !calendar.before(calendar3)) && date.compareTo(date2) != 0) {
                    if (date.compareTo(date3) != 0) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Date d(long j) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(j)));
        } catch (ParseException unused) {
            return null;
        }
    }

    public static Date e(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }
}
