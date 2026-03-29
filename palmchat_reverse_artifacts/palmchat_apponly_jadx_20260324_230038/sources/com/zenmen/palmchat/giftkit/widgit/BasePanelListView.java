package com.zenmen.palmchat.giftkit.widgit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zenmen.giftkit.R$anim;
import com.zenmen.giftkit.R$id;
import com.zenmen.giftkit.R$layout;
import com.zenmen.palmchat.giftkit.bean.BasePanelItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BasePanelListView<T extends BasePanelItem> extends RelativeLayout implements View.OnClickListener {
    protected BasePanelListView<T>.a adapter;
    protected List<T> mData;
    protected int mLastPosition;
    private Animation mSelectedAnim;
    protected T mSelectedPanelItem;
    protected View mSelectedView;
    protected boolean mShowError;
    protected int panelId;
    protected int uiType;

    /* JADX INFO: compiled from: SearchBox */
    public abstract class a extends BaseAdapter implements View.OnClickListener {

        /* JADX INFO: renamed from: com.zenmen.palmchat.giftkit.widgit.BasePanelListView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1057a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public RedDeleteLineText f14088a;
            public TextView b;
            public TextView c;
            public ImageView d;
            public RelativeLayout e;
            public CircleProgressView f;
            public ImageView g;
            public TextView h;
            public ImageView i;
            public TextView j;
            public TextView k;
            public T l;

            public C1057a() {
            }
        }

        public a() {
        }

        public final View a(View view) {
            C1057a c1057a = new C1057a();
            c1057a.c = (TextView) view.findViewById(R$id.tv_name);
            c1057a.f14088a = (RedDeleteLineText) view.findViewById(R$id.tv_money);
            c1057a.b = (TextView) view.findViewById(R$id.tv_discount);
            c1057a.d = (ImageView) view.findViewById(R$id.tv_icon);
            c1057a.e = (RelativeLayout) view.findViewById(R$id.rl_continue);
            c1057a.f = (CircleProgressView) view.findViewById(R$id.pg_continue);
            c1057a.g = (ImageView) view.findViewById(R$id.iv_check);
            c1057a.h = (TextView) view.findViewById(R$id.tv_hit_number);
            c1057a.i = (ImageView) view.findViewById(R$id.iv_money);
            c1057a.j = (TextView) view.findViewById(R$id.tv_tag);
            c1057a.k = (TextView) view.findViewById(R$id.tv_num);
            view.setTag(c1057a);
            return view;
        }

        public abstract void b(int i, View view, BasePanelListView<T>.a.C1057a c1057a, T t);

        @Override // android.widget.Adapter
        public int getCount() {
            List<T> list = BasePanelListView.this.mData;
            if (list == null || list.size() == 0) {
                return 0;
            }
            int size = BasePanelListView.this.mData.size() / 8;
            return BasePanelListView.this.mData.size() % 8 != 0 ? size + 1 : size;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return BasePanelListView.this.mData.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate;
            List arrayList;
            if (view == null) {
                arrayList = new ArrayList();
                viewInflate = LayoutInflater.from(BasePanelListView.this.getContext()).inflate(BasePanelListView.this.uiType == 0 ? R$layout.layout_gift_viewflow_item_light : R$layout.layout_gift_viewflow_item_dark, (ViewGroup) null);
                arrayList.add(a(viewInflate.findViewById(R$id.v0)));
                arrayList.add(a(viewInflate.findViewById(R$id.v1)));
                arrayList.add(a(viewInflate.findViewById(R$id.v2)));
                arrayList.add(a(viewInflate.findViewById(R$id.v3)));
                arrayList.add(a(viewInflate.findViewById(R$id.v4)));
                arrayList.add(a(viewInflate.findViewById(R$id.v5)));
                arrayList.add(a(viewInflate.findViewById(R$id.v6)));
                arrayList.add(a(viewInflate.findViewById(R$id.v7)));
                viewInflate.setTag(arrayList);
            } else {
                viewInflate = view;
                arrayList = (List) view.getTag();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setVisibility(4);
            }
            int i2 = i * 8;
            int iMin = Math.min(i2 + 8, BasePanelListView.this.mData.size());
            int i3 = 0;
            while (i2 < iMin) {
                ((View) arrayList.get(i3)).setVisibility(0);
                b(i2, (View) arrayList.get(i3), (C1057a) ((View) arrayList.get(i3)).getTag(), BasePanelListView.this.mData.get(i2));
                i3++;
                i2++;
            }
            viewInflate.setVisibility(0);
            return viewInflate;
        }
    }

    public BasePanelListView(Context context, int i, int i2, T t) {
        super(context);
        this.mLastPosition = -1;
        this.uiType = i;
        this.panelId = i2;
        this.mSelectedPanelItem = t;
    }

    public void createView(Context context) {
        setOnClickListener(this);
    }

    public int getItemCount() {
        List<T> list = this.mData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public boolean isShowError() {
        return this.mShowError;
    }

    public void startSelectedAnim(View view) {
        if (view == null) {
            return;
        }
        if (this.mSelectedAnim == null) {
            this.mSelectedAnim = AnimationUtils.loadAnimation(getContext(), R$anim.anim_gift_selected);
        }
        view.startAnimation(this.mSelectedAnim);
    }

    public abstract void update(boolean z);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
