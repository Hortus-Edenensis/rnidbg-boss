package com.zenmen.openapi.pay.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.R$id;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LxPayUnitedRadioGroup extends LinearLayout {
    private int mCheckedId;
    private CompoundButton.OnCheckedChangeListener mChildOnCheckedChangeListener;
    private b mHierarchyChangeListener;
    private c mOnCheckedChangeListener;
    private boolean mProtectFromCheckedChange;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (LxPayUnitedRadioGroup.this.mProtectFromCheckedChange) {
                return;
            }
            LxPayUnitedRadioGroup.this.mProtectFromCheckedChange = true;
            if (LxPayUnitedRadioGroup.this.mCheckedId != -1) {
                LxPayUnitedRadioGroup lxPayUnitedRadioGroup = LxPayUnitedRadioGroup.this;
                lxPayUnitedRadioGroup.setCheckedStateForView(lxPayUnitedRadioGroup.mCheckedId, false);
            }
            LxPayUnitedRadioGroup.this.mProtectFromCheckedChange = false;
            LxPayUnitedRadioGroup.this.setCheckedId(((ViewGroup) ((ViewGroup) compoundButton.getParent()).getParent()).getId());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ViewGroup.OnHierarchyChangeListener {
        public b() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        @RequiresApi(api = 17)
        public void onChildViewAdded(View view, View view2) {
            if (view == LxPayUnitedRadioGroup.this && (view2 instanceof LxPayUnitedSelectView)) {
                if (view2.getId() == -1) {
                    view2.setId(View.generateViewId());
                }
                ((RadioButton) ((LxPayUnitedSelectView) view2).findViewById(R$id.rb_select)).setOnCheckedChangeListener(LxPayUnitedRadioGroup.this.mChildOnCheckedChangeListener);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == LxPayUnitedRadioGroup.this && (view2 instanceof LxPayUnitedSelectView)) {
                ((RadioButton) ((LxPayUnitedSelectView) view2).findViewById(R$id.rb_select)).setOnCheckedChangeListener(null);
            }
        }

        public /* synthetic */ b(LxPayUnitedRadioGroup lxPayUnitedRadioGroup, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
    }

    public LxPayUnitedRadioGroup(Context context) {
        this(context, null);
    }

    private void init() {
        b bVar = new b(this, null);
        this.mHierarchyChangeListener = bVar;
        super.setOnHierarchyChangeListener(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i) {
        this.mCheckedId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedStateForView(int i, boolean z) {
        RadioButton radioButton;
        View viewFindViewById = findViewById(i);
        if (viewFindViewById == null || !(viewFindViewById instanceof LxPayUnitedSelectView) || (radioButton = (RadioButton) ((LxPayUnitedSelectView) viewFindViewById).findViewById(R$id.rb_select)) == null) {
            return;
        }
        radioButton.setChecked(z);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof LxPayUnitedSelectView) {
            LxPayUnitedSelectView lxPayUnitedSelectView = (LxPayUnitedSelectView) view;
            if (((RadioButton) lxPayUnitedSelectView.findViewById(R$id.rb_select)).isChecked()) {
                this.mProtectFromCheckedChange = true;
                int i2 = this.mCheckedId;
                if (i2 != -1) {
                    setCheckedStateForView(i2, false);
                }
                this.mProtectFromCheckedChange = false;
                setCheckedId(lxPayUnitedSelectView.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    public void check(int i) {
        if (i == -1 || i != this.mCheckedId) {
            int i2 = this.mCheckedId;
            if (i2 != -1) {
                setCheckedStateForView(i2, false);
            }
            if (i != -1) {
                setCheckedStateForView(i, true);
            }
            setCheckedId(i);
        }
    }

    public void clearCheck() {
        check(-1);
    }

    public int getCheckedRadioButtonId() {
        return this.mCheckedId;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.mCheckedId;
        if (i != -1) {
            this.mProtectFromCheckedChange = true;
            setCheckedStateForView(i, true);
            this.mProtectFromCheckedChange = false;
            setCheckedId(this.mCheckedId);
        }
    }

    public LxPayUnitedRadioGroup(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LxPayUnitedRadioGroup(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckedId = -1;
        this.mChildOnCheckedChangeListener = new a();
        init();
    }

    public void setOnCheckedChangeListener(c cVar) {
    }
}
