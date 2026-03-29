package com.zenmen.square.mvp.holder;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$layout;
import com.zenmen.square.databinding.LayoutSquareNestTopicFeedItemBinding;
import com.zenmen.square.mvp.SquareDataBindingComponent;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.a46;
import defpackage.ai5;
import defpackage.cy5;
import defpackage.hw3;
import defpackage.k86;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NestTopicFeedViewHolder extends BaseViewHolder<SquareFeed, LayoutSquareNestTopicFeedItemBinding, hw3> implements View.OnClickListener {
    public static int h;
    public float f;
    public String g;

    /* JADX INFO: compiled from: SearchBox */
    public class NestTopicFeedItemBindingComponent extends SquareDataBindingComponent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NestTopicFeedViewHolder f16443a;

        public NestTopicFeedItemBindingComponent(NestTopicFeedViewHolder nestTopicFeedViewHolder) {
            this.f16443a = nestTopicFeedViewHolder;
        }

        @Override // com.zenmen.square.mvp.SquareDataBindingComponent, androidx.databinding.DataBindingComponent
        public NestTopicFeedViewHolder getNestTopicFeedViewHolder() {
            return this.f16443a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f16444a;
        public final /* synthetic */ String b;

        public a(ImageView imageView, String str) {
            this.f16444a = imageView;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a46.u(a46.h(this.f16444a, k86.p(this.b)), this.f16444a, R$drawable.bg_feed_item_loading);
        }
    }

    public NestTopicFeedViewHolder(View view) {
        super(view);
        this.f = 100.0f;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [DB extends androidx.databinding.ViewDataBinding, androidx.databinding.ViewDataBinding] */
    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        ?? Inflate = DataBindingUtil.inflate(LayoutInflater.from(this.itemView.getContext()), R$layout.layout_square_nest_topic_feed_item, (ViewGroup) this.itemView, false, new NestTopicFeedItemBindingComponent(this));
        this.d = Inflate;
        ((ViewGroup) this.itemView).addView(((LayoutSquareNestTopicFeedItemBinding) Inflate).getRoot());
        ((LayoutSquareNestTopicFeedItemBinding) this.d).getRoot().setOnClickListener(this);
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void l(SquareFeed squareFeed, int i) {
        ((LayoutSquareNestTopicFeedItemBinding) this.d).p(squareFeed);
        ((LayoutSquareNestTopicFeedItemBinding) this.d).executePendingBindings();
        ((hw3) this.e).A(squareFeed);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((hw3) this.e).Q(((LayoutSquareNestTopicFeedItemBinding) this.d).o(), ((LayoutSquareNestTopicFeedItemBinding) this.d).c);
    }

    public final String p(SquareFeed squareFeed) {
        List<Media> list;
        int i = squareFeed.feedType;
        if (i == 3) {
            List<Media> list2 = squareFeed.mediaList;
            if (list2 == null || list2.isEmpty()) {
                return null;
            }
            return squareFeed.mediaList.get(0).thumbUrl;
        }
        if (i != 2 || (list = squareFeed.mediaList) == null || list.isEmpty()) {
            return null;
        }
        return squareFeed.mediaList.get(0).url;
    }

    public final void q(ImageView imageView, String str) {
        imageView.setVisibility(0);
        imageView.setImageResource(R$drawable.bg_feed_item_loading);
        v(imageView, ((LayoutSquareNestTopicFeedItemBinding) this.d).o().mediaList.get(0));
        imageView.post(new a(imageView, str));
    }

    public void r(TextView textView, long j) {
        textView.setText(cy5.e(j));
    }

    @BindingAdapter({"showLabel"})
    public void s(View view, SquareFeed squareFeed) {
        long j;
        String str;
        boolean z;
        List<Media> list = squareFeed.mediaList;
        Media media = (list == null || list.isEmpty()) ? null : squareFeed.mediaList.get(0);
        if (media == null || media.getPicSource() != 0) {
            j = squareFeed.createTime;
            str = squareFeed.location;
            z = false;
        } else {
            j = media.shootingTime;
            str = media.location;
            z = true;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) ((LayoutSquareNestTopicFeedItemBinding) this.d).b.getLayoutParams();
        if (j == 0 && TextUtils.isEmpty(str)) {
            ((LayoutSquareNestTopicFeedItemBinding) this.d).f.setVisibility(8);
            return;
        }
        ((LayoutSquareNestTopicFeedItemBinding) this.d).b.setImageResource(z ? R$drawable.icon_square_remember : R$drawable.icon_feed_location);
        ((LayoutSquareNestTopicFeedItemBinding) this.d).j.setVisibility(j == 0 ? 8 : 0);
        ((LayoutSquareNestTopicFeedItemBinding) this.d).k.setVisibility(TextUtils.isEmpty(str) ? 4 : 0);
        ((LayoutSquareNestTopicFeedItemBinding) this.d).b.setVisibility((!z && TextUtils.isEmpty(str)) ? 8 : 0);
        if (TextUtils.isEmpty(str) && z) {
            layoutParams.topToTop = ((LayoutSquareNestTopicFeedItemBinding) this.d).j.getId();
            layoutParams.bottomToBottom = ((LayoutSquareNestTopicFeedItemBinding) this.d).j.getId();
        } else {
            layoutParams.topToTop = ((LayoutSquareNestTopicFeedItemBinding) this.d).k.getId();
            layoutParams.bottomToBottom = ((LayoutSquareNestTopicFeedItemBinding) this.d).k.getId();
        }
        ((LayoutSquareNestTopicFeedItemBinding) this.d).b.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(str)) {
            ((LayoutSquareNestTopicFeedItemBinding) this.d).k.setText(squareFeed.location);
        }
        if (j > 0) {
            r(((LayoutSquareNestTopicFeedItemBinding) this.d).j, j);
        }
        if (squareFeed.feedType == 1) {
            ((LayoutSquareNestTopicFeedItemBinding) this.d).k.setTextColor(Color.parseColor("#222222"));
            ((LayoutSquareNestTopicFeedItemBinding) this.d).j.setTextColor(Color.parseColor("#222222"));
            ((LayoutSquareNestTopicFeedItemBinding) this.d).e.setVisibility(8);
        } else {
            ((LayoutSquareNestTopicFeedItemBinding) this.d).k.setTextColor(Color.parseColor("#f0FFFFFF"));
            ((LayoutSquareNestTopicFeedItemBinding) this.d).j.setTextColor(Color.parseColor("#f0FFFFFF"));
            ((LayoutSquareNestTopicFeedItemBinding) this.d).e.setVisibility(0);
        }
        DB db = this.d;
        ((LayoutSquareNestTopicFeedItemBinding) db).k.setLayoutParams(((LayoutSquareNestTopicFeedItemBinding) db).k.getLayoutParams());
    }

    @BindingAdapter({"setTopicMedia"})
    public void t(ConstraintLayout constraintLayout, SquareFeed squareFeed) {
        if (squareFeed.feedType == 3) {
            ((LayoutSquareNestTopicFeedItemBinding) this.d).h.setVisibility(0);
        } else {
            ((LayoutSquareNestTopicFeedItemBinding) this.d).h.setVisibility(8);
        }
        ((LayoutSquareNestTopicFeedItemBinding) this.d).c.setVisibility(0);
        int i = squareFeed.feedType;
        if (i != 2 && i != 3) {
            if (i == 1) {
                u();
                return;
            }
            return;
        }
        String strP = p(squareFeed);
        if (TextUtils.isEmpty(strP) || TextUtils.equals(this.g, strP)) {
            return;
        }
        this.g = strP;
        ai5.k().h();
        ((LayoutSquareNestTopicFeedItemBinding) this.d).i.setVisibility(8);
        q(((LayoutSquareNestTopicFeedItemBinding) this.d).c, squareFeed.mediaList.get(0).url);
    }

    public void u() {
        w(((LayoutSquareNestTopicFeedItemBinding) this.d).c);
        ((LayoutSquareNestTopicFeedItemBinding) this.d).c.setBackgroundResource(R$drawable.shape_feed_text_bg_8);
        ((LayoutSquareNestTopicFeedItemBinding) this.d).c.setImageDrawable(null);
        ((LayoutSquareNestTopicFeedItemBinding) this.d).i.setVisibility(0);
        DB db = this.d;
        ((LayoutSquareNestTopicFeedItemBinding) db).i.setText(((LayoutSquareNestTopicFeedItemBinding) db).o().content);
    }

    public ViewGroup.LayoutParams v(View view, Media media) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        if (h == 0) {
            h = (a46.m(this.itemView.getContext()).x / 2) - a46.b(view.getContext(), 16.0f);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).width = h;
        if (media.getHeight() > media.getWidth()) {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = (h / 3) * 4;
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = (h / 4) * 3;
        }
        view.setLayoutParams(layoutParams);
        return layoutParams;
    }

    public void w(View view) {
        if (h == 0) {
            h = (a46.m(this.itemView.getContext()).x / 2) - a46.b(view.getContext(), 16.0f);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        int i = h;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (i / 3) * 4;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = i;
        view.setLayoutParams(layoutParams);
    }
}
