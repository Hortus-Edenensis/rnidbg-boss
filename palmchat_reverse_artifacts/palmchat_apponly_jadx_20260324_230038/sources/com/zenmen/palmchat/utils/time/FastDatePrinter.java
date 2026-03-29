package com.zenmen.palmchat.utils.time;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class FastDatePrinter implements Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final ConcurrentMap<g, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient d[] mRules;
    private final TimeZone mTimeZone;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f15748a;

        public a(char c) {
            this.f15748a = c;
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.f15748a);
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public int estimateLength() {
            return 1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b extends d {
        void a(StringBuffer stringBuffer, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15749a;
        public final int b;

        public c(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.f15749a = i;
            this.b = i2;
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.b
        public final void a(StringBuffer stringBuffer, int i) {
            if (i < 100) {
                int i2 = this.b;
                while (true) {
                    i2--;
                    if (i2 < 2) {
                        stringBuffer.append((char) ((i / 10) + 48));
                        stringBuffer.append((char) ((i % 10) + 48));
                        return;
                    }
                    stringBuffer.append('0');
                }
            } else {
                int length = i < 1000 ? 3 : Integer.toString(i).length();
                int i3 = this.b;
                while (true) {
                    i3--;
                    if (i3 < length) {
                        stringBuffer.append(Integer.toString(i));
                        return;
                    }
                    stringBuffer.append('0');
                }
            }
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            a(stringBuffer, calendar.get(this.f15749a));
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public int estimateLength() {
            return 4;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void b(StringBuffer stringBuffer, Calendar calendar);

        int estimateLength();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15750a;

        public e(String str) {
            this.f15750a = str;
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.f15750a);
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public int estimateLength() {
            return this.f15750a.length();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15751a;
        public final String[] b;

        public f(int i, String[] strArr) {
            this.f15751a = i;
            this.b = strArr;
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.b[calendar.get(this.f15751a)]);
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public int estimateLength() {
            int length = this.b.length;
            int i = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i;
                }
                int length2 = this.b[length].length();
                if (length2 > i) {
                    i = length2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TimeZone f15752a;
        public final int b;
        public final Locale c;

        public g(TimeZone timeZone, boolean z, int i, Locale locale) {
            this.f15752a = timeZone;
            if (z) {
                this.b = Integer.MIN_VALUE | i;
            } else {
                this.b = i;
            }
            this.c = locale;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f15752a.equals(gVar.f15752a) && this.b == gVar.b && this.c.equals(gVar.c);
        }

        public int hashCode() {
            return (((this.b * 31) + this.c.hashCode()) * 31) + this.f15752a.hashCode();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Locale f15753a;
        public final int b;
        public final String c;
        public final String d;

        public h(TimeZone timeZone, Locale locale, int i) {
            this.f15753a = locale;
            this.b = i;
            this.c = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i, locale);
            this.d = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i, locale);
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            TimeZone timeZone = calendar.getTimeZone();
            if (!timeZone.useDaylightTime() || calendar.get(16) == 0) {
                stringBuffer.append(FastDatePrinter.getTimeZoneDisplay(timeZone, false, this.b, this.f15753a));
            } else {
                stringBuffer.append(FastDatePrinter.getTimeZoneDisplay(timeZone, true, this.b, this.f15753a));
            }
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public int estimateLength() {
            return Math.max(this.c.length(), this.d.length());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i implements d {
        public static final i b = new i(true);
        public static final i c = new i(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f15754a;

        public i(boolean z) {
            this.f15754a = z;
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(15) + calendar.get(16);
            if (i < 0) {
                stringBuffer.append('-');
                i = -i;
            } else {
                stringBuffer.append('+');
            }
            int i2 = i / 3600000;
            stringBuffer.append((char) ((i2 / 10) + 48));
            stringBuffer.append((char) ((i2 % 10) + 48));
            if (this.f15754a) {
                stringBuffer.append(':');
            }
            int i3 = (i / 60000) - (i2 * 60);
            stringBuffer.append((char) ((i3 / 10) + 48));
            stringBuffer.append((char) ((i3 % 10) + 48));
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public int estimateLength() {
            return 5;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class j implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f15755a;

        public j(b bVar) {
            this.f15755a = bVar;
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.b
        public void a(StringBuffer stringBuffer, int i) {
            this.f15755a.a(stringBuffer, i);
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            int leastMaximum = calendar.get(10);
            if (leastMaximum == 0) {
                leastMaximum = calendar.getLeastMaximum(10) + 1;
            }
            this.f15755a.a(stringBuffer, leastMaximum);
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public int estimateLength() {
            return this.f15755a.estimateLength();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f15756a;

        public k(b bVar) {
            this.f15756a = bVar;
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.b
        public void a(StringBuffer stringBuffer, int i) {
            this.f15756a.a(stringBuffer, i);
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            int maximum = calendar.get(11);
            if (maximum == 0) {
                maximum = calendar.getMaximum(11) + 1;
            }
            this.f15756a.a(stringBuffer, maximum);
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public int estimateLength() {
            return this.f15756a.estimateLength();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class l implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f15757a = new l();

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.b
        public final void a(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            a(stringBuffer, calendar.get(2) + 1);
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public int estimateLength() {
            return 2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class m implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15758a;

        public m(int i) {
            this.f15758a = i;
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.b
        public final void a(StringBuffer stringBuffer, int i) {
            if (i >= 100) {
                stringBuffer.append(Integer.toString(i));
            } else {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
            }
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            a(stringBuffer, calendar.get(this.f15758a));
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public int estimateLength() {
            return 2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class n implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f15759a = new n();

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.b
        public final void a(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            a(stringBuffer, calendar.get(1) % 100);
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public int estimateLength() {
            return 2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class o implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f15760a = new o();

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.b
        public final void a(StringBuffer stringBuffer, int i) {
            if (i < 10) {
                stringBuffer.append((char) (i + 48));
            } else {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
            }
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            a(stringBuffer, calendar.get(2) + 1);
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public int estimateLength() {
            return 2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class p implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15761a;

        public p(int i) {
            this.f15761a = i;
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.b
        public final void a(StringBuffer stringBuffer, int i) {
            if (i < 10) {
                stringBuffer.append((char) (i + 48));
            } else if (i >= 100) {
                stringBuffer.append(Integer.toString(i));
            } else {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
            }
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public void b(StringBuffer stringBuffer, Calendar calendar) {
            a(stringBuffer, calendar.get(this.f15761a));
        }

        @Override // com.zenmen.palmchat.utils.time.FastDatePrinter.d
        public int estimateLength() {
            return 4;
        }
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    private String applyRulesToString(Calendar calendar) {
        return applyRules(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public static String getTimeZoneDisplay(TimeZone timeZone, boolean z, int i2, Locale locale) {
        g gVar = new g(timeZone, z, i2, locale);
        ConcurrentMap<g, String> concurrentMap = cTimeZoneDisplayCache;
        String str = concurrentMap.get(gVar);
        if (str != null) {
            return str;
        }
        String displayName = timeZone.getDisplayName(z, i2, locale);
        String strPutIfAbsent = concurrentMap.putIfAbsent(gVar, displayName);
        return strPutIfAbsent != null ? strPutIfAbsent : displayName;
    }

    private void init() {
        List<d> pattern = parsePattern();
        d[] dVarArr = (d[]) pattern.toArray(new d[pattern.size()]);
        this.mRules = dVarArr;
        int length = dVarArr.length;
        int iEstimateLength = 0;
        while (true) {
            length--;
            if (length < 0) {
                this.mMaxLengthEstimate = iEstimateLength;
                return;
            }
            iEstimateLength += this.mRules[length].estimateLength();
        }
    }

    private GregorianCalendar newCalendar() {
        return new GregorianCalendar(this.mTimeZone, this.mLocale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        init();
    }

    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        for (d dVar : this.mRules) {
            dVar.b(stringBuffer, calendar);
        }
        return stringBuffer;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        return this.mPattern.equals(fastDatePrinter.mPattern) && this.mTimeZone.equals(fastDatePrinter.mTimeZone) && this.mLocale.equals(fastDatePrinter.mLocale);
    }

    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        sb.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    public List<d> parsePattern() {
        d dVarSelectNumberRule;
        d hVar;
        d hVar2;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int[] iArr = new int[1];
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            iArr[i2] = i3;
            String token = parseToken(this.mPattern, iArr);
            int i4 = iArr[i2];
            int length2 = token.length();
            if (length2 == 0) {
                return arrayList;
            }
            char cCharAt = token.charAt(i2);
            if (cCharAt != 'y') {
                if (cCharAt != 'z') {
                    switch (cCharAt) {
                        case '\'':
                            String strSubstring = token.substring(1);
                            hVar2 = strSubstring.length() != 1 ? new e(strSubstring) : new a(strSubstring.charAt(0));
                            break;
                        case 'K':
                            hVar2 = selectNumberRule(10, length2);
                            break;
                        case 'M':
                            hVar2 = length2 < 4 ? length2 != 3 ? length2 != 2 ? o.f15760a : l.f15757a : new f(2, shortMonths) : new f(2, months);
                            break;
                        case 'S':
                            hVar2 = selectNumberRule(14, length2);
                            break;
                        case 'W':
                            hVar2 = selectNumberRule(4, length2);
                            break;
                        case 'Z':
                            hVar2 = length2 != 1 ? i.b : i.c;
                            break;
                        case 'a':
                            hVar2 = new f(9, amPmStrings);
                            break;
                        case 'd':
                            hVar2 = selectNumberRule(5, length2);
                            break;
                        case 'h':
                            hVar2 = new j(selectNumberRule(10, length2));
                            break;
                        case 'k':
                            dVarSelectNumberRule = new k(selectNumberRule(11, length2));
                            break;
                        case 'm':
                            hVar2 = selectNumberRule(12, length2);
                            break;
                        case 's':
                            hVar2 = selectNumberRule(13, length2);
                            break;
                        case 'w':
                            hVar2 = selectNumberRule(3, length2);
                            break;
                        default:
                            switch (cCharAt) {
                                case 'D':
                                    hVar2 = selectNumberRule(6, length2);
                                    break;
                                case 'E':
                                    hVar2 = new f(7, length2 < 4 ? shortWeekdays : weekdays);
                                    break;
                                case 'F':
                                    hVar2 = selectNumberRule(8, length2);
                                    break;
                                case 'G':
                                    hVar2 = new f(0, eras);
                                    break;
                                case 'H':
                                    hVar2 = selectNumberRule(11, length2);
                                    break;
                                default:
                                    throw new IllegalArgumentException("Illegal pattern component: " + token);
                            }
                            break;
                    }
                } else if (length2 >= 4) {
                    hVar2 = new h(this.mTimeZone, this.mLocale, 1);
                } else {
                    hVar = new h(this.mTimeZone, this.mLocale, 0);
                    dVarSelectNumberRule = hVar;
                }
                dVarSelectNumberRule = hVar2;
            } else if (length2 == 2) {
                hVar = n.f15759a;
                dVarSelectNumberRule = hVar;
            } else {
                if (length2 < 4) {
                    length2 = 4;
                }
                dVarSelectNumberRule = selectNumberRule(1, length2);
            }
            arrayList.add(dVarSelectNumberRule);
            i3 = i4 + 1;
            i2 = 0;
        }
        return arrayList;
    }

    public String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i2 = iArr[0];
        int length = str.length();
        char cCharAt = str.charAt(i2);
        if ((cCharAt < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z')) {
            sb.append('\'');
            boolean z = false;
            while (i2 < length) {
                char cCharAt2 = str.charAt(i2);
                if (cCharAt2 != '\'') {
                    if (!z && ((cCharAt2 >= 'A' && cCharAt2 <= 'Z') || (cCharAt2 >= 'a' && cCharAt2 <= 'z'))) {
                        i2--;
                        break;
                    }
                    sb.append(cCharAt2);
                } else {
                    int i3 = i2 + 1;
                    if (i3 >= length || str.charAt(i3) != '\'') {
                        z = !z;
                    } else {
                        sb.append(cCharAt2);
                        i2 = i3;
                    }
                }
                i2++;
            }
        } else {
            sb.append(cCharAt);
            while (true) {
                int i4 = i2 + 1;
                if (i4 >= length || str.charAt(i4) != cCharAt) {
                    break;
                }
                sb.append(cCharAt);
                i2 = i4;
            }
        }
        iArr[0] = i2;
        return sb.toString();
    }

    public b selectNumberRule(int i2, int i3) {
        return i3 != 1 ? i3 != 2 ? new c(i2, i3) : new m(i2) : new p(i2);
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
    }

    public String format(long j2) {
        GregorianCalendar gregorianCalendarNewCalendar = newCalendar();
        gregorianCalendarNewCalendar.setTimeInMillis(j2);
        return applyRulesToString(gregorianCalendarNewCalendar);
    }

    public String format(Date date) {
        GregorianCalendar gregorianCalendarNewCalendar = newCalendar();
        gregorianCalendarNewCalendar.setTime(date);
        return applyRulesToString(gregorianCalendarNewCalendar);
    }

    public String format(Calendar calendar) {
        return format(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public StringBuffer format(long j2, StringBuffer stringBuffer) {
        return format(new Date(j2), stringBuffer);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        GregorianCalendar gregorianCalendarNewCalendar = newCalendar();
        gregorianCalendarNewCalendar.setTime(date);
        return applyRules(gregorianCalendarNewCalendar, stringBuffer);
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return applyRules(calendar, stringBuffer);
    }
}
