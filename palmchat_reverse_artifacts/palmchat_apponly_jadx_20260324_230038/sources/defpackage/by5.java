package defpackage;

import android.content.Context;
import android.provider.Settings;
import android.text.format.Time;
import com.zenmen.palmchat.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class by5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SimpleDateFormat f1854a = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat b = new SimpleDateFormat("h:mm");

    public static long a(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static String b(long j, Context context, int i) {
        int i2;
        String string = Settings.System.getString(context.getContentResolver(), "time_12_24");
        boolean z = string != null && string.equals("24");
        boolean zEquals = context.getResources().getConfiguration().locale.toString().equals("zh_CN");
        TimeZone timeZone = TimeZone.getDefault();
        int julianDay = Time.getJulianDay(ir5.b(), timeZone.getRawOffset()) - Time.getJulianDay(j, timeZone.getRawOffset());
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(2);
        calendar.setTimeZone(timeZone);
        calendar.setTimeInMillis(j);
        int i3 = calendar.get(3);
        int i4 = calendar.get(7);
        int i5 = calendar.get(1);
        int i6 = calendar.get(11);
        StringBuilder sb = new StringBuilder(z ? f1854a.format(Long.valueOf(j)) : b.format(Long.valueOf(j)));
        if (!z) {
            if (zEquals) {
                sb.insert(0, i(context, i6) + " ");
            } else {
                sb.insert(sb.length(), " " + i(context, i6));
            }
        }
        if (julianDay != 0) {
            calendar.setTimeInMillis(ir5.b());
            int i7 = calendar.get(3);
            int i8 = calendar.get(1);
            if (i == 0) {
                i2 = 0;
                sb.delete(0, sb.length());
            } else {
                i2 = 0;
                sb.insert(0, " ");
            }
            if (i8 != i5) {
                sb.insert(i2, new SimpleDateFormat(context.getString(R.string.list_date_format_with_year)).format(Long.valueOf(j)));
            } else if (julianDay == 1) {
                sb.insert(i2, context.getString(R.string.list_yesterday));
            } else if (julianDay < 0) {
                sb.insert(i2, new SimpleDateFormat(context.getString(R.string.list_date_format)).format(Long.valueOf(j)));
            } else if (i3 == i7) {
                sb.insert(i2, j(context, i4));
            } else if (zEquals) {
                sb.insert(i2, new SimpleDateFormat(context.getString(R.string.list_date_format)).format(Long.valueOf(j)));
            } else {
                sb.insert(i2, new SimpleDateFormat(context.getString(R.string.list_date_format_with_year)).format(Long.valueOf(j)));
            }
        }
        return sb.toString();
    }

    public static long c(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        return (calendar2.getTime().getTime() - calendar.getTime().getTime()) / 86400000;
    }

    public static String d(long j, Context context) {
        return b(j, context, 1);
    }

    public static String e(long j, Context context) {
        return b(j, context, 0);
    }

    public static long f(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(5, calendar.get(5) + i);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        return calendar.getTimeInMillis();
    }

    public static long g(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, calendar.get(11) + i);
        return calendar.getTimeInMillis();
    }

    public static String h(long j) {
        return new SimpleDateFormat("MM月dd日  HH:mm:ss").format(new Date(j));
    }

    public static String i(Context context, int i) {
        return (i < 0 || i >= 6) ? (i < 6 || i >= 12) ? (i < 12 || i >= 13) ? (i < 13 || i >= 18) ? context.getString(R.string.list_time_evening) : context.getString(R.string.list_time_afternoon) : context.getString(R.string.list_time_noon) : context.getString(R.string.list_time_morning) : context.getString(R.string.list_time_before_dawn);
    }

    public static String j(Context context, int i) {
        switch (i) {
            case 2:
                return context.getString(R.string.list_monday);
            case 3:
                return context.getString(R.string.list_tuesday);
            case 4:
                return context.getString(R.string.list_wednesday);
            case 5:
                return context.getString(R.string.list_thursday);
            case 6:
                return context.getString(R.string.list_friday);
            case 7:
                return context.getString(R.string.list_saturday);
            default:
                return null;
        }
    }

    public static boolean k(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        int i2 = calendar.get(6);
        calendar.setTimeInMillis(System.currentTimeMillis());
        return i == calendar.get(1) && i2 == calendar.get(6);
    }

    public static void l(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        f1854a = new SimpleDateFormat("HH:mm", locale);
        b = new SimpleDateFormat("h:mm", locale);
    }
}
