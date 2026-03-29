package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.picker.model.DatePickData;
import com.zenmen.palmchat.widget.picker.model.PickerData;
import com.zenmen.palmchat.widget.picker.wheel.WheelPicker;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class sw1 extends Dialog {
    public static int n = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f20856a;
    public WheelPicker b;
    public WheelPicker c;
    public ArrayList<DatePickData> d;
    public ArrayList<DatePickData> e;
    public r16 f;
    public View g;
    public View h;
    public String i;
    public String j;
    public int k;
    public int l;
    public int m;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            sw1.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (sw1.this.f != null) {
                sw1.this.f.a(sw1.this.i, sw1.this.j, sw1.this.k, sw1.this.l, ew1.p("明天".equals(sw1.this.i), sw1.this.j));
            }
            sw1.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements WheelPicker.a {
        public c() {
        }

        @Override // com.zenmen.palmchat.widget.picker.wheel.WheelPicker.a
        public void a(WheelPicker wheelPicker, PickerData pickerData, int i) {
            if (sw1.this.m != i) {
                sw1.this.m = i;
                sw1.this.k = i;
                sw1.this.l = 0;
                sw1.this.n(i);
                sw1.this.c.setSelectedItemPosition(sw1.this.l, false);
                if (pickerData != null) {
                    sw1.this.i = pickerData.name;
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements WheelPicker.a {
        public d() {
        }

        @Override // com.zenmen.palmchat.widget.picker.wheel.WheelPicker.a
        public void a(WheelPicker wheelPicker, PickerData pickerData, int i) {
            sw1.this.l = i;
            if (pickerData != null) {
                sw1.this.j = pickerData.name;
            }
        }
    }

    public sw1(@NonNull Context context, r16 r16Var, int i, int i2) {
        super(context, R.style.tripFullScreenDialog);
        this.f20856a = null;
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
        this.g = null;
        this.h = null;
        this.i = "";
        this.j = "";
        this.k = 0;
        this.l = 0;
        this.m = -1;
        setCanceledOnTouchOutside(false);
        this.f = r16Var;
        this.k = i;
        this.m = i;
        this.l = i2;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.map_trip_time_dialog, (ViewGroup) null);
        this.f20856a = viewGroup;
        View viewFindViewById = viewGroup.findViewById(R.id.trip_release_info_time_close);
        this.g = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        View viewFindViewById2 = this.f20856a.findViewById(R.id.trip_map_release_info_button);
        this.h = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new b());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    public final void n(int i) {
        if (i == 1) {
            this.c.setData(this.e);
            this.j = this.e.get(this.l).name;
        } else {
            this.c.setData(this.d);
            this.j = this.d.get(this.l).name;
        }
    }

    public final void o() {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        HashMap<String, ArrayList<String>> mapA = ew1.A();
        if (mapA == null) {
            dismiss();
            return;
        }
        this.b = (WheelPicker) this.f20856a.findViewById(R.id.wv_time_day);
        this.c = (WheelPicker) this.f20856a.findViewById(R.id.wv_time_hour);
        ArrayList arrayList3 = new ArrayList();
        if (mapA.containsKey("timeToday") && (arrayList2 = mapA.get("timeToday")) != null && arrayList2.size() > 0) {
            arrayList3.add(new DatePickData(0, "今天"));
            for (int i = 0; i < arrayList2.size(); i++) {
                this.d.add(new DatePickData(i, arrayList2.get(i)));
            }
        }
        if (mapA.containsKey("timeTomorrow") && (arrayList = mapA.get("timeTomorrow")) != null && arrayList.size() > 0) {
            arrayList3.add(new DatePickData(0, "明天"));
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                this.e.add(new DatePickData(i2, arrayList.get(i2)));
            }
        }
        if (arrayList3.size() > 0) {
            this.b.setVisibility(0);
            this.b.setData(arrayList3);
            this.b.setVisibleItemCount(n);
            this.b.setSelectedItemPosition(this.k, false);
            this.i = ((DatePickData) arrayList3.get(this.k)).name;
            this.b.setOnItemSelectedListener(new c());
            this.c.setVisibility(0);
            n(this.k);
            this.c.setVisibleItemCount(n);
            this.c.setSelectedItemPosition(this.l, false);
            this.c.setOnItemSelectedListener(new d());
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f20856a);
        o();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Exception unused) {
        }
    }
}
