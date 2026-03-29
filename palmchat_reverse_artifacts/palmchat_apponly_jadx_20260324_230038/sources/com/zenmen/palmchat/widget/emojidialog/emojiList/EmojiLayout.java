package com.zenmen.palmchat.widget.emojidialog.emojiList;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.widget.emojidialog.emojiList.BaseRecyclerAdapter;
import defpackage.v64;
import defpackage.vl1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class EmojiLayout extends LinearLayout {
    private String deleteIconName;
    private View deleteView;
    private LinearLayout edittextBarLlFaceContainer;
    private LinearLayout edittextBarMore;
    private v64 emojiClickListener;
    private EmojiBarExpressionAdapter emojiExpressionAdapter;
    private RecyclerView emojiRecyclerView;
    private View emojiScrollView;
    private int numColumns;
    private int numRows;
    private int pageCount;
    private List<String> reslist;
    private List<String> reslistBar;
    private int richMarginBottom;
    private int richMarginTop;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EmojiLayout.a(EmojiLayout.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements BaseRecyclerAdapter.b {
        public b() {
        }

        @Override // com.zenmen.palmchat.widget.emojidialog.emojiList.BaseRecyclerAdapter.b
        public void a(View view, int i) {
            EmojiLayout.this.emojiExpressionAdapter.d(i);
            EmojiLayout.a(EmojiLayout.this);
        }
    }

    public EmojiLayout(Context context, v64 v64Var) {
        super(context);
        this.reslist = new ArrayList();
        this.reslistBar = new ArrayList();
        this.deleteIconName = "[emoji_delete]";
        this.numColumns = 7;
        this.numRows = 4;
        this.pageCount = (7 * 4) - 1;
        init(context, null);
    }

    public static /* bridge */ /* synthetic */ v64 a(EmojiLayout emojiLayout) {
        emojiLayout.getClass();
        return null;
    }

    private int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R$layout.lx_layout_emoji_container, (ViewGroup) this, true);
        if (isInEditMode()) {
            return;
        }
        View viewFindViewById = findViewById(R$id.videosdk_emoji_delete);
        this.deleteView = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        this.emojiScrollView = findViewById(R$id.emojiScrollView);
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.emojiRecyclerView);
        this.emojiRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 7));
        this.edittextBarLlFaceContainer = (LinearLayout) findViewById(R$id.edittext_bar_ll_face_container);
        this.edittextBarMore = (LinearLayout) findViewById(R$id.edittext_bar_more);
        this.richMarginBottom = dip2px(getContext(), 2.0f);
        this.richMarginTop = dip2px(getContext(), 8.0f);
        this.numColumns = 7;
        this.numRows = 4;
        this.pageCount = (7 * 4) - 1;
        initViews();
        EmojiBarExpressionAdapter emojiBarExpressionAdapter = new EmojiBarExpressionAdapter(getContext());
        this.emojiExpressionAdapter = emojiBarExpressionAdapter;
        emojiBarExpressionAdapter.g(new b());
        this.emojiExpressionAdapter.c(this.reslist);
        this.emojiRecyclerView.setAdapter(this.emojiExpressionAdapter);
    }

    private void initViews() {
        Iterator<Map.Entry<String, String>> it = vl1.f().entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (!this.deleteIconName.equals(key)) {
                this.reslist.add(key);
            }
        }
    }

    public LinearLayout getEdittextBarLlFaceContainer() {
        return this.edittextBarLlFaceContainer;
    }

    public LinearLayout getEdittextBarMore() {
        return this.edittextBarMore;
    }

    public void hiddenAll() {
        this.emojiScrollView.setVisibility(8);
    }

    public void hideKeyboard() {
        Activity activity = (Activity) getContext();
        if (activity.getWindow().getAttributes().softInputMode == 2 || activity.getCurrentFocus() == null) {
            return;
        }
        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
    }
}
