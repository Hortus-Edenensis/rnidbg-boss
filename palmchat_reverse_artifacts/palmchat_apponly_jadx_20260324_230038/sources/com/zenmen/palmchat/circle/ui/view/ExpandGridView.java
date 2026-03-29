package com.zenmen.palmchat.circle.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.zenmen.palmchat.circle.bean.ExpandFirstLevelData;
import com.zenmen.palmchat.circle.bean.ExpandSecondLevelData;
import com.zenmen.palmchat.circle.ui.view.FirstLevelRelativeLayout;
import defpackage.me1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ExpandGridView extends LinearLayout {
    private String Tag;
    private int currentSelectFirstLevelIndex;
    private List<FirstLevelRelativeLayout> firstLevelViewRelativeLayoutList;
    private int mColumnNum;
    private Context mContext;
    private int mLeft;
    private List<ExpandFirstLevelData> mListData;
    public b mOnFirstLevelItemClickedListener;
    private c mOnSecondLevelItemClickedListener;
    private int mRight;
    private int mSecondLevelCloumSpace;
    private int mSecondLevelGridViewPadding;
    private int mSecondLevelNumCloum;
    private String mSecondSelectedColor;
    private String mSecondUnSelectedColor;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FirstLevelRelativeLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FirstLevelRelativeLayout f13298a;

        public a(FirstLevelRelativeLayout firstLevelRelativeLayout) {
            this.f13298a = firstLevelRelativeLayout;
        }

        @Override // com.zenmen.palmchat.circle.ui.view.FirstLevelRelativeLayout.b
        public void a(ExpandFirstLevelData expandFirstLevelData, View view) {
            ExpandGridView.this.closeAllItem();
            if (expandFirstLevelData.parentId == ExpandGridView.this.currentSelectFirstLevelIndex) {
                ExpandGridView.this.currentSelectFirstLevelIndex = -1;
            } else {
                this.f13298a.openGridView(expandFirstLevelData, view);
                ExpandGridView.this.currentSelectFirstLevelIndex = expandFirstLevelData.parentId;
            }
            ExpandGridView.this.getClass();
        }

        @Override // com.zenmen.palmchat.circle.ui.view.FirstLevelRelativeLayout.b
        public void b(ExpandSecondLevelData expandSecondLevelData) {
            ExpandGridView.b(ExpandGridView.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
    }

    public ExpandGridView(Context context) {
        super(context);
        this.Tag = "ExpandGridView";
        this.mColumnNum = 3;
        this.currentSelectFirstLevelIndex = -1;
        this.firstLevelViewRelativeLayoutList = new ArrayList();
        this.mSecondLevelNumCloum = 3;
        this.mSecondSelectedColor = "#ff552e";
        this.mSecondUnSelectedColor = "#666666";
        init(context);
    }

    public static /* bridge */ /* synthetic */ c b(ExpandGridView expandGridView) {
        expandGridView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeAllItem() {
        for (int i = 0; i < this.firstLevelViewRelativeLayoutList.size(); i++) {
            this.firstLevelViewRelativeLayoutList.get(i).closeGridView();
        }
    }

    private void fillFirstItem() {
        removeAllViews();
        List<ExpandFirstLevelData> list = this.mListData;
        if (list == null || list.size() <= 0) {
            Log.e(this.Tag, "fillFirstItem()=>mListData==null");
            return;
        }
        int size = this.mListData.size() / this.mColumnNum;
        if (this.mListData.size() % this.mColumnNum > 0) {
            size++;
        }
        for (int i = 0; i < size; i++) {
            FirstLevelRelativeLayout firstLevelRelativeLayout = new FirstLevelRelativeLayout(this.mContext);
            firstLevelRelativeLayout.setPadding(0, me1.b(this.mContext, 23), 0, 0);
            firstLevelRelativeLayout.setNumCloum(this.mSecondLevelNumCloum);
            firstLevelRelativeLayout.setItemSpace(this.mLeft, this.mRight);
            firstLevelRelativeLayout.setSecondLevelClomunSpace(this.mSecondLevelCloumSpace);
            firstLevelRelativeLayout.setSecondLevelGridViewPadding(this.mSecondLevelGridViewPadding);
            addView(firstLevelRelativeLayout);
            firstLevelRelativeLayout.setSecondLevelTextViewColor(this.mSecondSelectedColor, this.mSecondUnSelectedColor);
            firstLevelRelativeLayout.setOnFirstItemClickListener(new a(firstLevelRelativeLayout));
            firstLevelRelativeLayout.setData(i, this.mColumnNum, this.mListData);
            this.firstLevelViewRelativeLayoutList.add(firstLevelRelativeLayout);
        }
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
        setGravity(1);
    }

    public void clearFirstLevelButtonState() {
        this.currentSelectFirstLevelIndex = -1;
    }

    public void clearSecondLevelButtonState() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof FirstLevelRelativeLayout) {
                ((FirstLevelRelativeLayout) childAt).clearSecondLevelButtonState();
            }
        }
    }

    public void setColumnNum(int i) {
        this.mColumnNum = i;
    }

    public void setCurrentSelectFirstLevelIndex(int i) {
        this.currentSelectFirstLevelIndex = i;
    }

    public void setFirstLevelClomunSpace(int i, int i2) {
        this.mLeft = i;
        this.mRight = i2;
    }

    public void setListData(List<ExpandFirstLevelData> list) {
        this.mListData = list;
        fillFirstItem();
    }

    public void setSecondLevelClomunSpace(int i) {
        this.mSecondLevelCloumSpace = i;
    }

    public void setSecondLevelGridViewPadding(int i) {
        this.mSecondLevelGridViewPadding = i;
    }

    public void setSecondLevelNumCloum(int i) {
        this.mSecondLevelNumCloum = i;
    }

    public void setSecondLevelTextViewColor(String str, String str2) {
        this.mSecondSelectedColor = str;
        this.mSecondUnSelectedColor = str2;
    }

    public ExpandGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Tag = "ExpandGridView";
        this.mColumnNum = 3;
        this.currentSelectFirstLevelIndex = -1;
        this.firstLevelViewRelativeLayoutList = new ArrayList();
        this.mSecondLevelNumCloum = 3;
        this.mSecondSelectedColor = "#ff552e";
        this.mSecondUnSelectedColor = "#666666";
        init(context);
    }

    public ExpandGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Tag = "ExpandGridView";
        this.mColumnNum = 3;
        this.currentSelectFirstLevelIndex = -1;
        this.firstLevelViewRelativeLayoutList = new ArrayList();
        this.mSecondLevelNumCloum = 3;
        this.mSecondSelectedColor = "#ff552e";
        this.mSecondUnSelectedColor = "#666666";
        init(context);
    }

    public void setOnFirstLevelItemClickedListener(b bVar) {
    }

    public void setOnSecondLevelItemClickedListener(c cVar) {
    }
}
