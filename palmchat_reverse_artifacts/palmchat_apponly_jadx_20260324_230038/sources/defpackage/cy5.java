package defpackage;

import android.text.format.Time;
import com.zenmen.palmchat.friendcircle.R$string;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class cy5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SimpleDateFormat f16949a = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat b = new SimpleDateFormat("h:mm");
    public static SimpleDateFormat c = new SimpleDateFormat();
    public static SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    public static SimpleDateFormat e = new SimpleDateFormat("yyyy·MM·dd HH:mm:ss", Locale.getDefault());
    public static SimpleDateFormat f = new SimpleDateFormat("yyyy·MM·dd", Locale.getDefault());
    public static SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    public static String a(int i, int i2) {
        return kl5.b(i, Integer.valueOf(i2));
    }

    public static String b(long j) {
        return k(j) ? f16949a.format(Long.valueOf(j)) : l(j) ? new SimpleDateFormat("昨天 HH:mm").format(Long.valueOf(j)) : new SimpleDateFormat("yyyy年M月d日 HH:mm").format(Long.valueOf(j));
    }

    public static String c(long j) {
        return new SimpleDateFormat("M月d日HH:mm", Locale.getDefault()).format(new Date(j));
    }

    public static int d(long j, long j2) {
        int iRound = Math.round((j2 - j) / 86400000);
        if (iRound < 0) {
            return -1;
        }
        return iRound;
    }

    public static String e(long j) {
        return e.format(new Date(j));
    }

    public static String f(long j) {
        return f.format(new Date(j));
    }

    public static String g(long j) {
        long jCurrentTimeMillis = (System.currentTimeMillis() - j) / 1000;
        TimeZone timeZone = TimeZone.getDefault();
        int julianDay = Time.getJulianDay(ir5.b(), timeZone.getRawOffset()) - Time.getJulianDay(j, timeZone.getRawOffset());
        return jCurrentTimeMillis > 31536000 ? a(R$string.format_time_year, (int) (jCurrentTimeMillis / 31536000)) : jCurrentTimeMillis > 2592000 ? a(R$string.format_time_month, (int) (jCurrentTimeMillis / 2592000)) : julianDay >= 2 ? a(R$string.format_time_day, julianDay) : julianDay == 1 ? kl5.a(R$string.format_time_lastday) : jCurrentTimeMillis > 3600 ? a(R$string.format_time_hour, (int) (jCurrentTimeMillis / 3600)) : jCurrentTimeMillis > 60 ? a(R$string.format_time_minute, (int) (jCurrentTimeMillis / 60)) : jCurrentTimeMillis > 1 ? kl5.a(R$string.format_time_sec) : kl5.a(R$string.format_time_other);
    }

    public static String h(long j) {
        try {
            return g(d.parse(d.format(new Date(j))).getTime());
        } catch (ParseException e2) {
            e2.printStackTrace();
            return g(System.currentTimeMillis());
        }
    }

    public static String[] i(long j) {
        String str;
        String str2;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        int i2 = calendar.get(2) + 1;
        int i3 = calendar.get(5);
        String[] strArr = new String[3];
        String str3 = i + "年";
        if (i2 < 10) {
            str = "0" + i2 + "月";
        } else {
            str = i2 + "月";
        }
        if (i3 < 10) {
            str2 = "0" + i3;
        } else {
            str2 = i3 + "";
        }
        strArr[0] = str3;
        strArr[1] = str;
        strArr[2] = str2;
        return strArr;
    }

    public static boolean j(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        int i = calendar.get(1);
        int i2 = calendar.get(6);
        calendar.setTime(new Date(System.currentTimeMillis()));
        return i == calendar.get(1) && i2 == calendar.get(6);
    }

    @Deprecated
    public static boolean k(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return Calendar.getInstance().get(5) == calendar.get(5);
    }

    public static boolean l(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        Calendar calendar2 = Calendar.getInstance();
        return calendar2.get(1) == calendar.get(1) && calendar2.get(6) - calendar.get(6) == 1;
    }

    public static long m(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (ParseException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }
}
