package com.zenmen.palmchat.widget.picker.wheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.framework.R$styleable;
import com.zenmen.palmchat.widget.picker.model.DatePickData;
import com.zenmen.palmchat.widget.picker.model.PickerData;
import com.zenmen.palmchat.widget.picker.wheel.WheelPicker;
import defpackage.dn0;
import defpackage.v4;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class DateWheelPicker extends LinearLayout {
    private static final int DEFAULT_DAY = 1;
    private static final int DEFAULT_MONTH = 1;
    private ArrayList<DatePickData> arry_days;
    private ArrayList<DatePickData> arry_months;
    private ArrayList<DatePickData> arry_years;
    private int currentDay;
    private int currentMonth;
    private int currentYear;
    private View customView;
    private int day;
    private boolean issetdata;
    private d listener;
    private int month;
    private int selectDay;
    private int selectMonth;
    private int selectYear;
    private WheelPicker wvDay;
    private WheelPicker wvMonth;
    private WheelPicker wvYear;
    private static final int DEFAULT_YEAR = new Random().nextInt(10) + 1990;
    private static int YEAR_MAX = 100;
    private static int YEAR_MIN = 18;
    private static int VISIBLE_WHEEL_ITEMS = 7;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements WheelPicker.a {
        public a() {
        }

        @Override // com.zenmen.palmchat.widget.picker.wheel.WheelPicker.a
        public void a(WheelPicker wheelPicker, PickerData pickerData, int i) {
            DateWheelPicker.this.selectYear = pickerData.getId();
            DateWheelPicker dateWheelPicker = DateWheelPicker.this;
            dateWheelPicker.currentYear = dateWheelPicker.selectYear;
            DateWheelPicker dateWheelPicker2 = DateWheelPicker.this;
            dateWheelPicker2.setYear(dateWheelPicker2.currentYear);
            DateWheelPicker dateWheelPicker3 = DateWheelPicker.this;
            dateWheelPicker3.initMonths(dateWheelPicker3.month);
            DateWheelPicker.this.wvMonth.setData(DateWheelPicker.this.arry_months);
            DateWheelPicker.this.wvMonth.setSelectedItemPosition(0, false);
            DateWheelPicker dateWheelPicker4 = DateWheelPicker.this;
            dateWheelPicker4.selectMonth = dateWheelPicker4.wvMonth.getData().get(0).id;
            DateWheelPicker dateWheelPicker5 = DateWheelPicker.this;
            dateWheelPicker5.calDays(dateWheelPicker5.currentYear, DateWheelPicker.this.selectMonth);
            DateWheelPicker dateWheelPicker6 = DateWheelPicker.this;
            dateWheelPicker6.initDays(dateWheelPicker6.day);
            DateWheelPicker.this.wvDay.setData(DateWheelPicker.this.arry_days);
            DateWheelPicker.this.wvDay.setSelectedItemPosition(0, false);
            DateWheelPicker dateWheelPicker7 = DateWheelPicker.this;
            dateWheelPicker7.selectDay = dateWheelPicker7.wvDay.getData().get(0).id;
            if (DateWheelPicker.this.listener != null) {
                DateWheelPicker.this.listener.b();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements WheelPicker.a {
        public b() {
        }

        @Override // com.zenmen.palmchat.widget.picker.wheel.WheelPicker.a
        public void a(WheelPicker wheelPicker, PickerData pickerData, int i) {
            DateWheelPicker.this.selectMonth = pickerData.id;
            DateWheelPicker dateWheelPicker = DateWheelPicker.this;
            dateWheelPicker.calDays(dateWheelPicker.selectYear, DateWheelPicker.this.selectMonth);
            DateWheelPicker dateWheelPicker2 = DateWheelPicker.this;
            dateWheelPicker2.initDays(dateWheelPicker2.day);
            DateWheelPicker.this.wvDay.setData(DateWheelPicker.this.arry_days);
            DateWheelPicker.this.wvDay.setSelectedItemPosition(0, false);
            DateWheelPicker dateWheelPicker3 = DateWheelPicker.this;
            dateWheelPicker3.selectDay = dateWheelPicker3.wvDay.getData().get(0).id;
            if (DateWheelPicker.this.listener != null) {
                DateWheelPicker.this.listener.a();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements WheelPicker.a {
        public c() {
        }

        @Override // com.zenmen.palmchat.widget.picker.wheel.WheelPicker.a
        public void a(WheelPicker wheelPicker, PickerData pickerData, int i) {
            DateWheelPicker.this.selectDay = pickerData.id;
            if (DateWheelPicker.this.listener != null) {
                DateWheelPicker.this.listener.c();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a();

        void b();

        void c();
    }

    public DateWheelPicker(@NonNull Context context) {
        this(context, null);
    }

    private void onCreateView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_wheel_date, (ViewGroup) this, true);
        this.customView = viewInflate;
        this.wvYear = (WheelPicker) viewInflate.findViewById(R$id.wv_birth_year);
        this.wvMonth = (WheelPicker) this.customView.findViewById(R$id.wv_birth_month);
        this.wvDay = (WheelPicker) this.customView.findViewById(R$id.wv_birth_day);
        if (!this.issetdata) {
            initData();
        }
        initYears();
        this.wvYear.setData(this.arry_years);
        this.wvYear.setVisibleItemCount(VISIBLE_WHEEL_ITEMS);
        this.wvYear.setSelectedItemPosition(setYear(this.currentYear), false);
        initMonths(this.month);
        this.wvMonth.setData(this.arry_months);
        this.wvMonth.setVisibleItemCount(VISIBLE_WHEEL_ITEMS);
        this.wvMonth.setSelectedItemPosition(setMonth(this.currentMonth), false);
        initDays(this.day);
        this.wvDay.setData(this.arry_days);
        this.wvDay.setVisibleItemCount(VISIBLE_WHEEL_ITEMS);
        this.wvDay.setSelectedItemPosition(this.currentDay - 1, false);
        this.wvYear.setOnItemSelectedListener(new a());
        this.wvMonth.setOnItemSelectedListener(new b());
        this.wvDay.setOnItemSelectedListener(new c());
    }

    public void calDays(int i, int i2) {
        boolean z = i % 4 == 0 && (i % 100 != 0 || i % 400 == 0);
        for (int i3 = 1; i3 <= 12; i3++) {
            switch (i2) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    this.day = 31;
                    break;
                case 2:
                    if (z) {
                        this.day = 29;
                    } else {
                        this.day = 28;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    this.day = 30;
                    break;
            }
        }
        if (i == getYear() - YEAR_MIN && i2 == getMonth()) {
            this.day = getDay();
        }
    }

    public String getBirthday() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.selectYear);
        sb.append("-");
        if (this.selectMonth < 10) {
            sb.append("0");
        }
        sb.append(this.selectMonth);
        sb.append("-");
        if (this.selectDay < 10) {
            sb.append("0");
        }
        sb.append(this.selectDay);
        return sb.toString();
    }

    public View getCustomView() {
        return this.customView;
    }

    public int getDay() {
        return Calendar.getInstance().get(5);
    }

    public int getMonth() {
        return Calendar.getInstance().get(2) + 1;
    }

    public int getYear() {
        return Calendar.getInstance().get(1);
    }

    public void initData() {
        Date date;
        ContactInfoItem contactInfoItemA = dn0.a(v4.e(com.zenmen.palmchat.c.b()));
        if (contactInfoItemA == null || TextUtils.isEmpty(contactInfoItemA.getBirthday())) {
            setDate(DEFAULT_YEAR, 1, 1);
            this.currentMonth = 1;
            this.currentDay = 1;
            return;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(contactInfoItemA.getBirthday());
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        gregorianCalendar.setTime(date);
        setDate(gregorianCalendar.get(1), gregorianCalendar.get(2) + 1, gregorianCalendar.get(5));
        this.currentMonth = gregorianCalendar.get(2) + 1;
        this.currentDay = gregorianCalendar.get(5);
    }

    public void initDays(int i) {
        this.arry_days.clear();
        for (int i2 = 1; i2 <= i; i2++) {
            this.arry_days.add(new DatePickData(i2, i2 + "日"));
        }
    }

    public void initMonths(int i) {
        this.arry_months.clear();
        for (int i2 = 1; i2 <= i; i2++) {
            this.arry_months.add(new DatePickData(i2, i2 + "月"));
        }
    }

    public void initYears() {
        for (int year = getYear() - YEAR_MIN; year > getYear() - YEAR_MAX; year += -1) {
            this.arry_years.add(new DatePickData(year, year + "年"));
        }
    }

    public void reset() {
        setBirthday(new int[]{DEFAULT_YEAR, 1, 1});
    }

    public void setBirthday(int[] iArr) {
        if (iArr != null) {
            try {
                setDate(iArr[0], iArr[1], iArr[2]);
                this.wvYear.setSelectedItemPosition(setYear(this.currentYear), false);
                this.wvMonth.setSelectedItemPosition(setMonth(this.currentMonth), false);
                this.wvDay.setSelectedItemPosition(this.currentDay - 1, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setDate(int i, int i2, int i3) {
        this.selectYear = i;
        this.selectMonth = i2;
        this.selectDay = i3;
        this.issetdata = true;
        this.currentYear = i;
        this.currentMonth = i2;
        this.currentDay = i3;
        if (i == getYear() - YEAR_MIN) {
            this.month = getMonth();
        } else {
            this.month = 12;
        }
        calDays(i, i2);
    }

    public void setListener(d dVar) {
        this.listener = dVar;
    }

    public int setMonth(int i) {
        calDays(this.currentYear, i);
        int i2 = 0;
        for (int i3 = 1; i3 < this.month; i3++) {
            if (i == i3) {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    public int setYear(int i) {
        if (i != getYear() - YEAR_MIN) {
            this.month = 12;
        } else {
            this.month = getMonth();
        }
        int i2 = 0;
        for (int year = getYear() - YEAR_MIN; year > getYear() - YEAR_MAX; year--) {
            if (year == i) {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    public DateWheelPicker(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DateWheelPicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.arry_years = new ArrayList<>();
        this.arry_months = new ArrayList<>();
        this.arry_days = new ArrayList<>();
        this.currentYear = DEFAULT_YEAR;
        this.currentMonth = 1;
        this.currentDay = 1;
        this.issetdata = false;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DateWheelPicker);
            VISIBLE_WHEEL_ITEMS = typedArrayObtainStyledAttributes.getInteger(R$styleable.DateWheelPicker_wheel_items, 7);
            YEAR_MAX = typedArrayObtainStyledAttributes.getInteger(R$styleable.DateWheelPicker_year_max, 100);
            YEAR_MIN = typedArrayObtainStyledAttributes.getInteger(R$styleable.DateWheelPicker_year_min, 18);
            typedArrayObtainStyledAttributes.recycle();
        }
        onCreateView(context);
    }

    public void setSelectedTextColor(int i) {
    }

    public void setUnselectedTextColor(int i) {
    }
}
