package com.zenmen.palmchat.circle.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.ExpandFirstLevelData;
import com.zenmen.palmchat.circle.bean.ExpandSecondLevelData;
import defpackage.pd2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FirstLevelRelativeLayout extends RelativeLayout implements AdapterView.OnItemClickListener {
    private LinearLayout mColumnDataLinerLayout;
    private Context mContext;
    private List<ExpandFirstLevelData> mExpandFirstLevelDataList;
    private pd2 mGridViewAdapter;
    private int mLeft;
    private int mNumCloum;
    private b mOnItemClickListener;
    private int mRight;
    private GridView mSecondLevelGridView;
    private String mSecondSelectedColor;
    private String mSecondUnSelectedColor;
    private List<FirstLevelItemView> mTextViewList;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ExpandFirstLevelData expandFirstLevelData = (ExpandFirstLevelData) view.getTag();
            if (FirstLevelRelativeLayout.this.mOnItemClickListener != null) {
                FirstLevelRelativeLayout.this.mOnItemClickListener.a(expandFirstLevelData, view);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(ExpandFirstLevelData expandFirstLevelData, View view);

        void b(ExpandSecondLevelData expandSecondLevelData);
    }

    public FirstLevelRelativeLayout(Context context) {
        super(context);
        this.mExpandFirstLevelDataList = new ArrayList();
        this.mTextViewList = new ArrayList();
        this.mNumCloum = 2;
        init(context);
    }

    private void delFirstLevelItemHeight(boolean z) {
        LinearLayout.LayoutParams layoutParams = z ? new LinearLayout.LayoutParams(-2, dip2px(this.mContext, 34.0f)) : new LinearLayout.LayoutParams(-2, dip2px(this.mContext, 34.0f));
        for (int i = 0; i < this.mColumnDataLinerLayout.getChildCount(); i++) {
            this.mColumnDataLinerLayout.getChildAt(i).setLayoutParams(layoutParams);
        }
    }

    private void fillItemData() {
        b bVar;
        pd2 pd2Var = new pd2(this.mContext);
        this.mGridViewAdapter = pd2Var;
        this.mSecondLevelGridView.setAdapter((ListAdapter) pd2Var);
        for (int i = 0; i < this.mExpandFirstLevelDataList.size(); i++) {
            ExpandFirstLevelData expandFirstLevelData = this.mExpandFirstLevelDataList.get(i);
            FirstLevelItemView firstLevelItemView = new FirstLevelItemView(this.mContext);
            firstLevelItemView.setText(expandFirstLevelData.cateName);
            firstLevelItemView.setUrlIcon(expandFirstLevelData.cateIcon);
            firstLevelItemView.setPadding(this.mLeft, 0, this.mRight, 0);
            firstLevelItemView.setSelectState(expandFirstLevelData.isSelected);
            this.mColumnDataLinerLayout.addView(firstLevelItemView);
            firstLevelItemView.setTag(expandFirstLevelData);
            firstLevelItemView.setOnClickListener(new a());
            if (expandFirstLevelData.isSelected && (bVar = this.mOnItemClickListener) != null) {
                bVar.a(expandFirstLevelData, firstLevelItemView);
            }
            this.mTextViewList.add(firstLevelItemView);
        }
        int size = this.mExpandFirstLevelDataList.size();
        int i2 = this.mNumCloum;
        int size2 = size < i2 ? i2 - this.mExpandFirstLevelDataList.size() : 0;
        for (int i3 = 0; i3 < size2; i3++) {
            FirstLevelItemView firstLevelItemView2 = new FirstLevelItemView(this.mContext);
            firstLevelItemView2.setPadding(this.mLeft, 0, this.mRight, 0);
            firstLevelItemView2.fillBlockView();
            this.mColumnDataLinerLayout.addView(firstLevelItemView2);
        }
        delFirstLevelItemHeight(false);
        this.mGridViewAdapter.f(this.mSecondSelectedColor, this.mSecondUnSelectedColor);
    }

    private void init(Context context) {
        this.mContext = context;
        View viewInflate = View.inflate(getContext(), R.layout.expand_item, this);
        this.mColumnDataLinerLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_column_data);
        GridView gridView = (GridView) viewInflate.findViewById(R.id.gv_second_item);
        this.mSecondLevelGridView = gridView;
        gridView.setOnItemClickListener(this);
    }

    private void setGridViewHeight(boolean z) {
        pd2 pd2Var = this.mGridViewAdapter;
        if (pd2Var == null) {
            return;
        }
        int iC = pd2Var.c() / this.mNumCloum;
        if (this.mGridViewAdapter.c() % this.mNumCloum != 0) {
            iC++;
        }
        View view = this.mGridViewAdapter.getView(0, null, this.mSecondLevelGridView);
        view.measure(0, 0);
        int measuredHeight = view.getMeasuredHeight() * iC;
        int i = iC - 1;
        if (i > 0) {
            measuredHeight += (this.mSecondLevelGridView.getHorizontalSpacing() + 5) * i;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mSecondLevelGridView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, measuredHeight);
        } else {
            layoutParams.height = measuredHeight;
            if (!z && measuredHeight > 0) {
                int iC2 = this.mGridViewAdapter.c();
                if (iC2 <= 3) {
                    layoutParams.height = dip2px(this.mContext, 50.0f);
                } else if (iC2 <= 6) {
                    layoutParams.height = dip2px(this.mContext, 100.0f);
                } else if (iC2 <= 9) {
                    layoutParams.height = dip2px(this.mContext, 150.0f);
                }
            }
        }
        this.mSecondLevelGridView.setLayoutParams(layoutParams);
    }

    public void clearSecondLevelButtonState() {
        List<ExpandSecondLevelData> listB = this.mGridViewAdapter.b();
        if (listB != null) {
            for (int i = 0; i < listB.size(); i++) {
                listB.get(i).isSelected = false;
            }
        }
        this.mGridViewAdapter.notifyDataSetChanged();
    }

    public void closeGridView() {
        for (int i = 0; i < this.mTextViewList.size(); i++) {
            this.mTextViewList.get(i).setSelectState(false);
        }
        if (this.mGridViewAdapter != null) {
            delFirstLevelItemHeight(false);
            this.mGridViewAdapter.a();
            this.mGridViewAdapter.notifyDataSetChanged();
            setGridViewHeight(true);
        }
    }

    public int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ExpandSecondLevelData expandSecondLevelData;
        if (this.mOnItemClickListener == null || (expandSecondLevelData = (ExpandSecondLevelData) view.getTag()) == null) {
            return;
        }
        expandSecondLevelData.isSelected = !expandSecondLevelData.isSelected;
        List<ExpandSecondLevelData> listB = this.mGridViewAdapter.b();
        if (listB != null) {
            for (int i2 = 0; i2 < listB.size(); i2++) {
                ExpandSecondLevelData expandSecondLevelData2 = listB.get(i2);
                if (expandSecondLevelData2.id != expandSecondLevelData.id) {
                    expandSecondLevelData2.isSelected = false;
                }
            }
        }
        this.mGridViewAdapter.notifyDataSetChanged();
        this.mOnItemClickListener.b(expandSecondLevelData);
    }

    public void openGridView(ExpandFirstLevelData expandFirstLevelData, View view) {
        if (this.mGridViewAdapter != null) {
            delFirstLevelItemHeight(true);
            this.mGridViewAdapter.e(expandFirstLevelData.secondCate);
            this.mGridViewAdapter.notifyDataSetChanged();
            ((FirstLevelItemView) view).setSelectState(true);
            setGridViewHeight(false);
        }
    }

    public void setData(int i, int i2, List<ExpandFirstLevelData> list) {
        this.mExpandFirstLevelDataList.clear();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (i * i2) + i3;
            if (i4 < list.size()) {
                ExpandFirstLevelData expandFirstLevelData = list.get(i4);
                expandFirstLevelData.parentId = i4;
                if (expandFirstLevelData.secondCate != null) {
                    for (int i5 = 0; i5 < expandFirstLevelData.secondCate.size(); i5++) {
                        boolean z = expandFirstLevelData.secondCate.get(i5).isSelected;
                    }
                }
                this.mExpandFirstLevelDataList.add(expandFirstLevelData);
            }
        }
        fillItemData();
        setGridViewHeight(false);
    }

    public void setItemSpace(int i, int i2) {
        this.mLeft = i;
        this.mRight = i2;
    }

    public void setNumCloum(int i) {
        this.mNumCloum = i;
        this.mSecondLevelGridView.setNumColumns(i);
    }

    public void setOnFirstItemClickListener(b bVar) {
        this.mOnItemClickListener = bVar;
    }

    public void setSecondLevelClomunSpace(int i) {
        this.mSecondLevelGridView.setHorizontalSpacing(i);
    }

    public void setSecondLevelGridViewPadding(int i) {
        this.mSecondLevelGridView.setPadding(i, 0, i, 0);
    }

    public void setSecondLevelTextViewColor(String str, String str2) {
        this.mSecondSelectedColor = str;
        this.mSecondUnSelectedColor = str2;
    }

    public FirstLevelRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mExpandFirstLevelDataList = new ArrayList();
        this.mTextViewList = new ArrayList();
        this.mNumCloum = 2;
        init(context);
    }

    public FirstLevelRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mExpandFirstLevelDataList = new ArrayList();
        this.mTextViewList = new ArrayList();
        this.mNumCloum = 2;
        init(context);
    }
}
