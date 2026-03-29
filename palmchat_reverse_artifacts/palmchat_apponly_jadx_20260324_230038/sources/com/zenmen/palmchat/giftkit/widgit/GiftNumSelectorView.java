package com.zenmen.palmchat.giftkit.widgit;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.giftkit.R$drawable;
import com.zenmen.giftkit.R$id;
import com.zenmen.giftkit.R$layout;
import com.zenmen.giftkit.R$styleable;
import com.zenmen.palmchat.framework.R$style;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GiftNumSelectorView extends RelativeLayout implements View.OnClickListener {
    private b listener;
    private TextView num10Text;
    private TextView num188Text;
    private TextView num1Text;
    private TextView num30Text;
    private TextView num66Text;
    private View numMoreSelect;
    private TextView numMoreText;
    PopupWindow popupWindow;
    private View selectedView;
    private int uiType;
    private static final int[] popMenuIcons = {R$drawable.ic_gift_num_3344, R$drawable.ic_gift_num_1314, R$drawable.ic_gift_num_520};
    private static final String[] popMenuStr = {"生生世世", "一生一世", "我爱你"};
    private static final int[] popMenuNum = {3344, 1314, 520};

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onItemClicked(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(int i);
    }

    public GiftNumSelectorView(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int i = context.obtainStyledAttributes(attributeSet, R$styleable.GiftPanel).getInt(R$styleable.GiftPanel_ui_type, 0);
        this.uiType = i;
        View.inflate(context, i == 0 ? R$layout.layout_gift_num_selector_light : R$layout.layout_gift_num_selector_dark, this);
        initItems();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$0(int i) {
        this.listener.a(i);
        setNumber(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPop$1(a aVar, View view) {
        if (aVar != null) {
            aVar.onItemClicked(((Integer) view.getTag()).intValue());
        }
        this.popupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPop$2(View view) {
        this.popupWindow.dismiss();
    }

    private void setViewSelected(View view) {
        View view2 = this.selectedView;
        if (view == view2) {
            return;
        }
        if (view2 != null) {
            view2.setBackgroundColor(0);
            if (this.selectedView == this.numMoreSelect) {
                this.numMoreText.setText("更多");
                this.numMoreText.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.uiType == 0 ? R$drawable.ic_gift_num_more_light : R$drawable.ic_gift_num_more_dark, 0);
            }
        }
        this.selectedView = view;
        view.setBackgroundResource(this.uiType == 0 ? R$drawable.shape_e0e0e0_radius_16 : R$drawable.shape_54525f_radius_16);
    }

    public void initItems() {
        TextView textView = (TextView) findViewById(R$id.tv_num_1);
        this.num1Text = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R$id.tv_num_10);
        this.num10Text = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) findViewById(R$id.tv_num_30);
        this.num30Text = textView3;
        textView3.setOnClickListener(this);
        TextView textView4 = (TextView) findViewById(R$id.tv_num_66);
        this.num66Text = textView4;
        textView4.setOnClickListener(this);
        TextView textView5 = (TextView) findViewById(R$id.tv_num_188);
        this.num188Text = textView5;
        textView5.setOnClickListener(this);
        this.numMoreText = (TextView) findViewById(R$id.tv_num_select);
        View viewFindViewById = findViewById(R$id.rl_num_select);
        this.numMoreSelect = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.listener == null) {
            return;
        }
        int id = view.getId();
        if (id == R$id.rl_num_select) {
            showPop(view, new a() { // from class: hb2
                @Override // com.zenmen.palmchat.giftkit.widgit.GiftNumSelectorView.a
                public final void onItemClicked(int i) {
                    this.f17917a.lambda$onClick$0(i);
                }
            });
            return;
        }
        if (id == R$id.tv_num_1) {
            this.listener.a(1);
        } else if (id == R$id.tv_num_10) {
            this.listener.a(10);
        } else if (id == R$id.tv_num_30) {
            this.listener.a(30);
        } else if (id == R$id.tv_num_66) {
            this.listener.a(66);
        } else if (id == R$id.tv_num_188) {
            this.listener.a(188);
        }
        setViewSelected(view);
    }

    public void setNumber(int i) {
        if (i == 1) {
            setViewSelected(this.num1Text);
            return;
        }
        if (i == 10) {
            setViewSelected(this.num10Text);
            return;
        }
        if (i == 30) {
            setViewSelected(this.num30Text);
            return;
        }
        if (i == 66) {
            setViewSelected(this.num66Text);
            return;
        }
        if (i == 188) {
            setViewSelected(this.num188Text);
            return;
        }
        if (i > 0) {
            this.numMoreText.setText(i + "");
            this.numMoreText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            setViewSelected(this.numMoreSelect);
        }
    }

    public void setNumberSelectListener(b bVar) {
        this.listener = bVar;
    }

    public void showPop(View view, final a aVar) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_gift_num_pop_view, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.num_list);
        int i = 0;
        while (true) {
            int[] iArr = popMenuNum;
            if (i >= iArr.length) {
                viewInflate.setOnClickListener(new View.OnClickListener() { // from class: jb2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f18370a.lambda$showPop$2(view2);
                    }
                });
                PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
                this.popupWindow = popupWindow;
                popupWindow.setBackgroundDrawable(new ColorDrawable(0));
                this.popupWindow.setContentView(viewInflate);
                this.popupWindow.setOutsideTouchable(true);
                this.popupWindow.setFocusable(true);
                this.popupWindow.setAnimationStyle(R$style.AnimationPopMenuDialog);
                viewInflate.measure(0, 0);
                int measuredWidth = viewInflate.getMeasuredWidth();
                int[] iArr2 = new int[2];
                view.getLocationInWindow(iArr2);
                this.popupWindow.showAtLocation(view, 83, (iArr2[0] + (view.getWidth() / 2)) - (measuredWidth / 2), 0);
                return;
            }
            View viewInflate2 = View.inflate(getContext(), R$layout.layout_gift_num_pop_item, null);
            ImageView imageView = (ImageView) viewInflate2.findViewById(R$id.thumb);
            int[] iArr3 = popMenuIcons;
            if (iArr3 != null) {
                imageView.setImageResource(iArr3[i]);
            }
            ((TextView) viewInflate2.findViewById(R$id.title)).setText(popMenuStr[i]);
            viewInflate2.setOnClickListener(new View.OnClickListener() { // from class: ib2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f18143a.lambda$showPop$1(aVar, view2);
                }
            });
            viewInflate2.setTag(Integer.valueOf(iArr[i]));
            linearLayout.addView(viewInflate2);
            i++;
        }
    }

    public GiftNumSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GiftNumSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    @RequiresApi(api = 21)
    public GiftNumSelectorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet);
    }
}
