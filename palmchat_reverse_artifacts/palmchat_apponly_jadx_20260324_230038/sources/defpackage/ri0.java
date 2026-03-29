package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ClickableSpan;
import android.text.style.ReplacementSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.zenmen.square.R$color;
import com.zenmen.square.R$string;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ri0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SimpleDateFormat f20483a = new SimpleDateFormat("HH:mm");

    /* JADX INFO: compiled from: SearchBox */
    public class a extends b {
        public final /* synthetic */ View.OnClickListener b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, View.OnClickListener onClickListener) {
            super(i);
            this.b = onClickListener;
        }

        @Override // ri0.b, android.text.style.ClickableSpan
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends ReplacementSpan {
        public static final int c = tn.b(com.zenmen.palmchat.c.b(), 3);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f20485a;
        public final int b;

        public c(Drawable drawable, int i) {
            this.f20485a = drawable;
            this.b = i;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            canvas.save();
            int i6 = this.b;
            if (i6 == 0) {
                i4 = i5;
            } else if (100 == i6) {
                i4 = i5 - ((i5 - i4) / 2);
            }
            canvas.translate(f + c, i4 - this.f20485a.getBounds().bottom);
            this.f20485a.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            Rect bounds = this.f20485a.getBounds();
            if (fontMetricsInt != null) {
                int i3 = -bounds.bottom;
                fontMetricsInt.ascent = i3;
                fontMetricsInt.descent = 0;
                fontMetricsInt.top = i3;
                fontMetricsInt.bottom = 0;
            }
            return bounds.right + (c * 2);
        }
    }

    public static SpannableString a(Context context, String str, String str2, String str3, View.OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(str2)) {
            str = "回复 " + str2 + "：" + str;
        }
        SpannableString spannableString = new SpannableString(str + str3);
        if (!TextUtils.isEmpty(str2)) {
            spannableString.setSpan(new a(pe6.b(context, R$color.square_color_6683c0), onClickListener), 3, str2.length() + 3, 33);
        }
        if (!TextUtils.isEmpty(str3)) {
            pu5 pu5Var = new pu5(context);
            pu5Var.c(str3);
            pu5Var.g(12.0f);
            pu5Var.d(Layout.Alignment.ALIGN_CENTER);
            pu5Var.e(pe6.b(context, R$color.square_color_8A8B90));
            pu5Var.setBounds(0, 0, pu5Var.getIntrinsicWidth(), pu5Var.getIntrinsicHeight());
            spannableString.setSpan(new c(pu5Var, 100), str.length(), str.length() + str3.length(), 33);
        }
        return spannableString;
    }

    public static String b(int i) {
        String strValueOf = String.valueOf(i);
        if (i < 10000) {
            return strValueOf;
        }
        int i2 = i / 10000;
        return i2 + "." + ((i - (i2 * 10000)) / 1000) + RXScreenCaptureService.KEY_WIDTH;
    }

    public static String c(Context context, long j) {
        String str;
        Settings.System.getString(context.getContentResolver(), "time_12_24");
        zk5.e(context.getResources().getConfiguration().locale.toString(), "zh_CN");
        TimeZone timeZone = TimeZone.getDefault();
        int julianDay = Time.getJulianDay(System.currentTimeMillis(), timeZone.getRawOffset()) - Time.getJulianDay(j, timeZone.getRawOffset());
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(2);
        calendar.setTimeZone(timeZone);
        calendar.setTimeInMillis(j);
        calendar.get(3);
        calendar.get(7);
        int i = calendar.get(1);
        calendar.get(11);
        String str2 = f20483a.format(Long.valueOf(j));
        if (julianDay == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            if (jCurrentTimeMillis <= 0) {
                return str2;
            }
            if (jCurrentTimeMillis < 60000) {
                return context.getString(R$string.square_date_rightnow);
            }
            if (jCurrentTimeMillis < 3600000) {
                return ((jCurrentTimeMillis / 60) / 1000) + context.getString(R$string.square_date_minutes);
            }
            if (jCurrentTimeMillis >= 86400000) {
                return str2;
            }
            return (((jCurrentTimeMillis / 60) / 60) / 1000) + context.getString(R$string.square_date_hours);
        }
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.get(3);
        if (calendar.get(1) != i) {
            str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        } else if (julianDay == 1) {
            str = context.getString(R$string.square_yesterday) + " " + str2;
        } else if (julianDay > 1 && julianDay <= 3) {
            str = julianDay + context.getString(R$string.square_date_day);
        } else {
            if (julianDay <= 3 && julianDay >= 0) {
                return str2;
            }
            str = new SimpleDateFormat("MM-dd").format(Long.valueOf(j));
        }
        return str;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20484a;

        public b(int i) {
            this.f20484a = i;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f20484a);
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
        }
    }
}
