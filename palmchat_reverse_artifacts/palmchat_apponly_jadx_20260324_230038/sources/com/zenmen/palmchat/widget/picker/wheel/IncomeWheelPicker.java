package com.zenmen.palmchat.widget.picker.wheel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.widget.picker.model.PickerData;
import com.zenmen.palmchat.widget.picker.wheel.WheelPicker;
import defpackage.hs1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class IncomeWheelPicker extends LinearLayout {
    private View customView;
    private WheelPicker.a mOnItemSelectedListener;
    private WheelPicker wheelPicker;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements WheelPicker.a {
        public a() {
        }

        @Override // com.zenmen.palmchat.widget.picker.wheel.WheelPicker.a
        public void a(WheelPicker wheelPicker, PickerData pickerData, int i) {
            if (IncomeWheelPicker.this.mOnItemSelectedListener != null) {
                IncomeWheelPicker.this.mOnItemSelectedListener.a(wheelPicker, pickerData, i);
            }
        }
    }

    public IncomeWheelPicker(@NonNull Context context) {
        this(context, null);
    }

    private void onCreateView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_wheel_picker, (ViewGroup) this, true);
        this.customView = viewInflate;
        WheelPicker wheelPicker = (WheelPicker) viewInflate.findViewById(R$id.wheel_picker);
        this.wheelPicker = wheelPicker;
        wheelPicker.setData(hs1.e().c());
        this.wheelPicker.setOnItemSelectedListener(new a());
    }

    public void setOnItemSelectedListener(WheelPicker.a aVar) {
        this.mOnItemSelectedListener = aVar;
    }

    public void setPickerId(int i) {
        WheelPicker wheelPicker = this.wheelPicker;
        if (wheelPicker == null || wheelPicker.getData() == null) {
            return;
        }
        for (int i2 = 0; i2 < this.wheelPicker.getData().size(); i2++) {
            if (this.wheelPicker.getData().get(i2).id == i) {
                this.wheelPicker.setSelectedItemPosition(i2, false);
                return;
            }
        }
    }

    public IncomeWheelPicker(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IncomeWheelPicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        onCreateView(context);
    }
}
