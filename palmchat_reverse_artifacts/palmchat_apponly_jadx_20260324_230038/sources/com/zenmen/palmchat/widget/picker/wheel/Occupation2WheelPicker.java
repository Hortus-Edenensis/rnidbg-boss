package com.zenmen.palmchat.widget.picker.wheel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.extinfo.model.ExtInfoData;
import com.zenmen.palmchat.extinfo.model.OccupationData;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.widget.picker.model.PickerData;
import com.zenmen.palmchat.widget.picker.wheel.WheelPicker;
import defpackage.hs1;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Occupation2WheelPicker extends LinearLayout {
    private View customView;
    private WheelPicker.a mOnItemSelectedListener;
    private WheelPicker wheelJob;
    private WheelPicker wheelOccupation;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements WheelPicker.a {
        public a() {
        }

        @Override // com.zenmen.palmchat.widget.picker.wheel.WheelPicker.a
        public void a(WheelPicker wheelPicker, PickerData pickerData, int i) {
            if (pickerData == null || !(pickerData instanceof OccupationData)) {
                return;
            }
            List<ExtInfoData> list = ((OccupationData) pickerData).jobs;
            if (list == null || list.isEmpty()) {
                Occupation2WheelPicker.this.wheelJob.setVisibility(4);
                Occupation2WheelPicker.this.mOnItemSelectedListener.a(Occupation2WheelPicker.this.wheelJob, pickerData, -1);
                return;
            }
            Occupation2WheelPicker.this.wheelJob.setVisibility(0);
            Occupation2WheelPicker.this.wheelJob.setData(list);
            Occupation2WheelPicker.this.wheelJob.setSelectedItemPosition(0, false);
            if (Occupation2WheelPicker.this.mOnItemSelectedListener != null) {
                Occupation2WheelPicker.this.mOnItemSelectedListener.a(Occupation2WheelPicker.this.wheelJob, list.get(0), 0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements WheelPicker.a {
        public b() {
        }

        @Override // com.zenmen.palmchat.widget.picker.wheel.WheelPicker.a
        public void a(WheelPicker wheelPicker, PickerData pickerData, int i) {
            if (Occupation2WheelPicker.this.mOnItemSelectedListener != null) {
                Occupation2WheelPicker.this.mOnItemSelectedListener.a(wheelPicker, pickerData, i);
            }
        }
    }

    public Occupation2WheelPicker(@NonNull Context context) {
        this(context, null);
    }

    private void onCreateView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_occupation2_picker, (ViewGroup) this, true);
        this.customView = viewInflate;
        WheelPicker wheelPicker = (WheelPicker) viewInflate.findViewById(R$id.wheel_occupation);
        this.wheelOccupation = wheelPicker;
        wheelPicker.setData(hs1.e().i());
        this.wheelOccupation.setOnItemSelectedListener(new a());
        WheelPicker wheelPicker2 = (WheelPicker) this.customView.findViewById(R$id.wheel_job);
        this.wheelJob = wheelPicker2;
        wheelPicker2.setOnItemSelectedListener(new b());
        this.wheelJob.setVisibility(4);
    }

    public void setOnItemSelectedListener(WheelPicker.a aVar) {
        this.mOnItemSelectedListener = aVar;
    }

    public void setPickerId(int i) {
        WheelPicker wheelPicker = this.wheelOccupation;
        if (wheelPicker == null || wheelPicker.getData() == null) {
            return;
        }
        for (int i2 = 0; i2 < this.wheelOccupation.getData().size(); i2++) {
            OccupationData occupationData = (OccupationData) this.wheelOccupation.getData().get(i2);
            if (occupationData.id == (i / 100) * 100) {
                this.wheelOccupation.setSelectedItemPosition(i2, false);
                List<ExtInfoData> list = occupationData.jobs;
                if (list != null && !list.isEmpty()) {
                    this.wheelJob.setVisibility(0);
                    this.wheelJob.setData(occupationData.jobs);
                    if (occupationData.id != i) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= occupationData.jobs.size()) {
                                break;
                            }
                            if (occupationData.jobs.get(i3).id == i) {
                                this.wheelJob.setSelectedItemPosition(i3, false);
                                break;
                            }
                            i3++;
                        }
                    }
                    int selectedItemPosition = this.wheelJob.getSelectedItemPosition();
                    WheelPicker.a aVar = this.mOnItemSelectedListener;
                    if (aVar != null) {
                        aVar.a(this.wheelJob, occupationData.jobs.get(selectedItemPosition), selectedItemPosition);
                        return;
                    }
                    return;
                }
                this.wheelJob.setVisibility(4);
            }
        }
    }

    public Occupation2WheelPicker(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Occupation2WheelPicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        onCreateView(context);
    }
}
