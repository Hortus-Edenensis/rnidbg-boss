package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.my.fx.nr.iz;
import com.bytedance.sdk.openadsdk.widget.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends BaseAdapter {
    private u b;
    private final Context fx;
    private final List<iz> nr;
    private boolean pn;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.u u;

    /* JADX INFO: compiled from: SearchBox */
    public class nr {
        FrameLayout b;
        FlowLayout fx;
        TextView nr;
        ImageView u;

        private nr() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(int i, iz izVar);
    }

    public pn(Context context, List<iz> list, boolean z, com.bytedance.sdk.openadsdk.core.dislike.ui.u uVar) {
        this.pn = z;
        this.u = uVar;
        this.nr = list == null ? new ArrayList(0) : new ArrayList(list);
        this.fx = context != null ? context.getApplicationContext() : context;
    }

    private TextView nr() {
        TextView textView = new TextView(this.fx);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        com.bytedance.sdk.openadsdk.core.dislike.u.b bVarNr = com.bytedance.sdk.openadsdk.core.dislike.u.u.nr();
        marginLayoutParams.setMargins(0, 0, bVarNr.u(this.fx, 8.0f), bVarNr.u(this.fx, 8.0f));
        textView.setLayoutParams(marginLayoutParams);
        int iU = bVarNr.u(this.fx, 21.0f);
        int iU2 = bVarNr.u(this.fx, 6.0f);
        textView.setPadding(iU, iU2, iU, iU2);
        GradientDrawable gradientDrawableU = u(Color.parseColor("#0A161823"));
        gradientDrawableU.setCornerRadius(bVarNr.u(this.fx, 4.0f));
        textView.setBackground(gradientDrawableU);
        textView.setTextColor(Color.parseColor("#BF161823"));
        textView.setTextSize(14.0f);
        textView.setAlpha(0.75f);
        return textView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<iz> list = this.nr;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.nr.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View viewNr;
        nr nrVar;
        FrameLayout frameLayout;
        com.bytedance.sdk.openadsdk.core.dislike.ui.u uVar;
        String str;
        if (view == null) {
            nrVar = new nr();
            viewNr = com.bytedance.sdk.openadsdk.res.b.nr(this.fx, this.pn);
            nrVar.nr = (TextView) viewNr.findViewById(2047279094);
            nrVar.fx = (FlowLayout) viewNr.findViewById(2047279092);
            if (this.pn) {
                nrVar.u = (ImageView) viewNr.findViewById(2047279093);
                nrVar.b = (FrameLayout) viewNr.findViewById(2047279091);
            }
            viewNr.setTag(nrVar);
        } else {
            viewNr = view;
            nrVar = (nr) view.getTag();
        }
        iz izVar = this.nr.get(i);
        String strU = izVar.u();
        ImageView imageView = nrVar.u;
        if (imageView != null && strU != null && (uVar = this.u) != null) {
            switch (strU) {
                case "4:1":
                    str = "bu_fd_no_interest";
                    break;
                case "6:0":
                    str = "bu_fd_report";
                    break;
                case "7:1":
                    str = "bu_fd_no_close";
                    break;
                default:
                    str = "bu_fd_other";
                    break;
            }
            uVar.u(imageView, "dislike/" + str + ".png");
        }
        FrameLayout frameLayout2 = nrVar.b;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        nrVar.nr.setText(izVar.nr());
        if (izVar.x()) {
            nrVar.fx.removeAllViews();
            List<iz> listB = izVar.b();
            for (int i2 = 0; i2 < listB.size(); i2++) {
                final iz izVar2 = listB.get(i2);
                TextView textViewNr = nr();
                textViewNr.setText(izVar2.nr());
                textViewNr.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.pn.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (pn.this.b != null) {
                            pn.this.b.u(i, izVar2);
                        }
                    }
                });
                nrVar.fx.addView(textViewNr);
            }
            nrVar.fx.setVisibility(0);
        } else if ("99:1".equals(izVar.u()) && this.pn && (frameLayout = nrVar.b) != null) {
            frameLayout.removeAllViews();
            nrVar.b.setVisibility(0);
            nrVar.b.addView(u(i, izVar));
            nrVar.fx.setVisibility(8);
        } else {
            nrVar.nr.setBackground(u());
            nrVar.fx.setVisibility(8);
        }
        return viewNr;
    }

    private StateListDrawable u() {
        GradientDrawable gradientDrawableU = u(Color.parseColor("#FDE6E6E6"));
        GradientDrawable gradientDrawableU2 = u(Color.parseColor("#FDFFFFFF"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawableU);
        stateListDrawable.addState(new int[0], gradientDrawableU2);
        return stateListDrawable;
    }

    private GradientDrawable u(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    private View u(final int i, final iz izVar) {
        com.bytedance.sdk.openadsdk.core.dislike.u.b bVarNr = com.bytedance.sdk.openadsdk.core.dislike.u.u.nr();
        LinearLayout linearLayout = new LinearLayout(this.fx);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        TextView textView = new TextView(this.fx);
        textView.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        textView.setTextSize(14.0f);
        textView.setText("无法关闭、展示异常等问题，需复制广告ID，在应用内反馈上报问题");
        textView.setTextColor(Color.parseColor("#80161823"));
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(this.fx);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.pn.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pn.this.b != null) {
                    pn.this.b.u(i, izVar);
                }
            }
        });
        textView2.setText("点击复制广告ID");
        textView2.setTextColor(Color.parseColor("#161823"));
        textView2.setTextSize(14.0f);
        textView2.setGravity(17);
        GradientDrawable gradientDrawableU = u(Color.parseColor("#0A161823"));
        gradientDrawableU.setCornerRadius(bVarNr.u(this.fx, 4.0f));
        textView2.setBackground(gradientDrawableU);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, bVarNr.u(this.fx, 32.0f));
        layoutParams.setMargins(0, bVarNr.u(this.fx, 12.0f), 0, bVarNr.u(this.fx, 12.0f));
        linearLayout.addView(textView2, layoutParams);
        linearLayout.setClickable(false);
        return linearLayout;
    }

    public void u(u uVar) {
        this.b = uVar;
    }

    public void u(List<iz> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.nr.clear();
        this.nr.addAll(list);
        notifyDataSetChanged();
    }
}
