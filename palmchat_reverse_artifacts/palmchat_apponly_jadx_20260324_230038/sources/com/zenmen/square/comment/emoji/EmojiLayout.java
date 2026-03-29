package com.zenmen.square.comment.emoji;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$styleable;
import com.zenmen.square.comment.emoji.adapter.BaseRecyclerAdapter;
import com.zenmen.square.comment.emoji.adapter.EmojiBarExpressionAdapter;
import com.zenmen.square.comment.widget.RichEditText;
import defpackage.ql1;
import defpackage.xl1;
import defpackage.yn;
import defpackage.zk5;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class EmojiLayout extends LinearLayout {
    private String deleteIconName;
    private View deleteView;
    private RichEditText editTextEmoji;
    private LinearLayout edittextBarLlFaceContainer;
    private LinearLayout edittextBarMore;
    private RecyclerView emojiBar;
    private EmojiBarExpressionAdapter emojiBarExpressionAdapter;
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
            EmojiLayout.this.insertEmoji("square_emoji_delete", true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends GridLayoutManager {
        public b(Context context, int i) {
            super(context, i);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements BaseRecyclerAdapter.b {
        public c() {
        }

        @Override // com.zenmen.square.comment.emoji.adapter.BaseRecyclerAdapter.b
        public void a(View view, int i) {
            EmojiLayout.this.insertEmoji(EmojiLayout.this.emojiBarExpressionAdapter.e(i), false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements BaseRecyclerAdapter.b {
        public d() {
        }

        @Override // com.zenmen.square.comment.emoji.adapter.BaseRecyclerAdapter.b
        public void a(View view, int i) {
            EmojiLayout.this.insertEmoji(EmojiLayout.this.emojiExpressionAdapter.e(i), true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ql1 f16186a;

        public e(ql1 ql1Var) {
            this.f16186a = ql1Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            EmojiLayout.this.insertEmoji((String) this.f16186a.getItem(i), true);
        }
    }

    public EmojiLayout(Context context) {
        super(context);
        this.reslistBar = new ArrayList();
        this.deleteIconName = "square_emoji_delete";
        this.numColumns = 7;
        this.numRows = 4;
        this.pageCount = (7 * 4) - 1;
        init(context, null);
    }

    private int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private View getGridChildView(int i) {
        View viewInflate = View.inflate(getContext(), R$layout.square_expression_gridview, null);
        EmojiGridView emojiGridView = (EmojiGridView) viewInflate.findViewById(R$id.gridview);
        emojiGridView.setNumColumns(this.numColumns);
        ((LinearLayout.LayoutParams) emojiGridView.getLayoutParams()).setMargins(0, this.richMarginTop, 0, this.richMarginBottom);
        ArrayList arrayList = new ArrayList();
        int i2 = this.pageCount;
        int i3 = (i - 1) * i2;
        if (i2 + i3 >= this.reslist.size()) {
            List<String> list = this.reslist;
            arrayList.addAll(list.subList(i3, (list.size() - i3) + i3));
        } else {
            arrayList.addAll(this.reslist.subList(i3, this.pageCount + i3));
        }
        arrayList.add(this.deleteIconName);
        ql1 ql1Var = new ql1(getContext(), 1, arrayList);
        emojiGridView.setAdapter((ListAdapter) ql1Var);
        emojiGridView.setOnItemClickListener(new e(ql1Var));
        return viewInflate;
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R$layout.square_layout_emoji_container, (ViewGroup) this, true);
        if (isInEditMode()) {
            return;
        }
        View viewFindViewById = findViewById(R$id.videosdk_emoji_delete);
        this.deleteView = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        this.emojiScrollView = findViewById(R$id.emojiScrollView);
        this.emojiRecyclerView = (RecyclerView) findViewById(R$id.emojiRecyclerView);
        this.emojiBar = (RecyclerView) findViewById(R$id.emojiBar);
        b bVar = new b(getContext(), 8);
        this.emojiRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 7));
        this.emojiBar.setLayoutManager(bVar);
        this.edittextBarLlFaceContainer = (LinearLayout) findViewById(R$id.edittext_bar_ll_face_container);
        this.edittextBarMore = (LinearLayout) findViewById(R$id.edittext_bar_more);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SquareVEmojiLayout);
            String string = typedArrayObtainStyledAttributes.getString(R$styleable.SquareVEmojiLayout_square_emojiDeleteIconName);
            if (!TextUtils.isEmpty(string)) {
                this.deleteIconName = string;
            }
            this.richMarginBottom = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.SquareVEmojiLayout_square_emojiMarginBottom, dip2px(getContext(), 2.0f));
            this.richMarginTop = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.SquareVEmojiLayout_square_emojiMarginTop, dip2px(getContext(), 8.0f));
            this.numColumns = typedArrayObtainStyledAttributes.getInteger(R$styleable.SquareVEmojiLayout_square_emojiLayoutNumColumns, 7);
            int integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.SquareVEmojiLayout_square_emojiLayoutNumRows, 4);
            this.numRows = integer;
            this.pageCount = (this.numColumns * integer) - 1;
            typedArrayObtainStyledAttributes.recycle();
        }
        initViews();
        this.emojiBarExpressionAdapter = new EmojiBarExpressionAdapter(getContext());
        this.emojiExpressionAdapter = new EmojiBarExpressionAdapter(getContext());
        this.emojiBarExpressionAdapter.h(new c());
        this.emojiExpressionAdapter.h(new d());
        this.emojiExpressionAdapter.c(this.reslist);
        this.emojiBarExpressionAdapter.c(this.reslistBar);
        this.emojiBar.setAdapter(this.emojiBarExpressionAdapter);
        this.emojiRecyclerView.setAdapter(this.emojiExpressionAdapter);
    }

    private void initViews() {
        dip2px(getContext(), 5.0f);
        dip2px(getContext(), 5.0f);
        xl1.e(getContext());
        this.reslist = xl1.d();
        List<Map.Entry<String, Long>> listH = xl1.h();
        int i = 0;
        if (listH != null && listH.size() > 8) {
            for (int i2 = 0; i2 < 8; i2++) {
                this.reslistBar.add(listH.get(i2).getKey());
            }
        }
        int iCeil = (int) Math.ceil((this.reslist.size() * 1.0f) / this.pageCount);
        ArrayList arrayList = new ArrayList();
        while (i < iCeil) {
            i++;
            arrayList.add(getGridChildView(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertEmoji(String str, boolean z) {
        int selectionStart;
        int i;
        try {
            if (!zk5.d(this.deleteIconName, str)) {
                this.editTextEmoji.insertIcon(str);
                xl1.g(str);
            } else if (!TextUtils.isEmpty(this.editTextEmoji.getText()) && (selectionStart = this.editTextEmoji.getSelectionStart()) > 0) {
                String strSubstring = this.editTextEmoji.getText().toString().substring(0, selectionStart);
                int iLastIndexOf = strSubstring.lastIndexOf("[");
                int iLastIndexOf2 = strSubstring.lastIndexOf("]");
                if (iLastIndexOf == -1 || iLastIndexOf2 != selectionStart - 1) {
                    this.editTextEmoji.getEditableText().delete(selectionStart - 1, selectionStart);
                } else if (xl1.b(strSubstring.substring(iLastIndexOf, selectionStart).toString())) {
                    this.editTextEmoji.getEditableText().delete(iLastIndexOf, selectionStart);
                } else {
                    this.editTextEmoji.getEditableText().delete(i, selectionStart);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public RichEditText getEditTextEmoji() {
        return this.editTextEmoji;
    }

    public RichEditText getEditTextSmile() {
        return this.editTextEmoji;
    }

    public LinearLayout getEdittextBarLlFaceContainer() {
        return this.edittextBarLlFaceContainer;
    }

    public LinearLayout getEdittextBarMore() {
        return this.edittextBarMore;
    }

    public View getEmojiBar() {
        return this.emojiBar;
    }

    public void hiddenAll() {
        this.emojiBar.setVisibility(8);
        this.emojiScrollView.setVisibility(8);
    }

    public void hideEmojiKeyBoard() {
        yn.d(getContext(), this.editTextEmoji);
    }

    public void hideKeyboard() {
        Activity activity = (Activity) getContext();
        if (activity.getWindow().getAttributes().softInputMode == 2 || activity.getCurrentFocus() == null) {
            return;
        }
        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
    }

    public void setEditTextSmile(RichEditText richEditText) {
        this.editTextEmoji = richEditText;
    }

    public void showEmojiBar() {
        this.emojiBar.setVisibility(0);
        this.emojiScrollView.setVisibility(8);
        yn.e(getContext(), this.editTextEmoji);
    }

    public void showFullEmoji() {
        this.emojiBar.setVisibility(8);
        this.emojiScrollView.setVisibility(0);
    }

    public void showKeyboard() {
        this.editTextEmoji.requestFocus();
        ((InputMethodManager) this.editTextEmoji.getContext().getSystemService("input_method")).showSoftInput(this.editTextEmoji, 0);
    }

    public EmojiLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.reslistBar = new ArrayList();
        this.deleteIconName = "square_emoji_delete";
        this.numColumns = 7;
        this.numRows = 4;
        this.pageCount = (7 * 4) - 1;
        init(context, attributeSet);
    }

    public EmojiLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.reslistBar = new ArrayList();
        this.deleteIconName = "square_emoji_delete";
        this.numColumns = 7;
        this.numRows = 4;
        this.pageCount = (7 * 4) - 1;
        init(context, attributeSet);
    }
}
