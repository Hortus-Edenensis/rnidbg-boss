package com.zenmen.palmchat.widget.picker.multi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.extinfo.model.ExtInfoData;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.widget.picker.model.PickerData;
import com.zenmen.palmchat.widget.picker.multi.adapter.IntentionAdapter;
import defpackage.hs1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class IntentionPicker extends FrameLayout {
    private static final int SELECTED_MAX = 3;
    private IntentionAdapter intentionAdapter;
    private RecyclerView intentionRecycler;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f16044a;
        public PickerData b;

        public PickerData a() {
            return this.b;
        }

        public boolean b() {
            return this.f16044a;
        }

        public void c(PickerData pickerData) {
            this.b = pickerData;
        }

        public void d(boolean z) {
            this.f16044a = z;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(ArrayList<Integer> arrayList);
    }

    public IntentionPicker(Context context) {
        super(context);
        init(null, 0);
    }

    private List<a> getMultiPickerList(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        for (ExtInfoData extInfoData : hs1.e().g()) {
            a aVar = new a();
            aVar.c(extInfoData);
            if (list != null && list.contains(Integer.valueOf(aVar.a().getId()))) {
                aVar.d(true);
            }
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public void bind(b bVar, List<Integer> list) {
        LayoutInflater.from(getContext()).inflate(R$layout.view_intention_picker, this);
        this.intentionRecycler = (RecyclerView) findViewById(R$id.intention_recycler);
        this.intentionRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        IntentionAdapter intentionAdapter = new IntentionAdapter(getContext(), getMultiPickerList(list));
        this.intentionAdapter = intentionAdapter;
        intentionAdapter.g(bVar);
        this.intentionAdapter.h(3);
        if (list != null) {
            this.intentionAdapter.b(list);
        }
        this.intentionRecycler.setAdapter(this.intentionAdapter);
    }

    public IntentionPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public IntentionPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
    }
}
