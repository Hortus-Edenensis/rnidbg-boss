package com.zenmen.square.mvp.holder;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.databinding.LayoutSquareInteractItemBinding;
import com.zenmen.square.mvp.SquareDataBindingComponent;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareInteractBean;
import com.zenmen.square.mvp.model.bean.SquareInteractDetail;
import defpackage.a46;
import defpackage.cy5;
import defpackage.gr2;
import defpackage.je1;
import defpackage.k86;
import defpackage.l50;
import defpackage.qj5;
import defpackage.tn;
import defpackage.vl1;
import defpackage.xl1;
import defpackage.yi5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareInteractViewHolder extends BaseViewHolder<SquareInteractBean, LayoutSquareInteractItemBinding, yi5> implements View.OnClickListener {
    public int f;
    public je1 g;

    /* JADX INFO: compiled from: SearchBox */
    public class InteractItemBindingComponent extends SquareDataBindingComponent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SquareInteractViewHolder f16448a;

        public InteractItemBindingComponent(SquareInteractViewHolder squareInteractViewHolder) {
            this.f16448a = squareInteractViewHolder;
        }

        @Override // com.zenmen.square.mvp.SquareDataBindingComponent, androidx.databinding.DataBindingComponent
        public SquareInteractViewHolder getSquareInteractViewHolder() {
            return this.f16448a;
        }
    }

    public SquareInteractViewHolder(View view) {
        super(view);
        this.g = null;
        this.f = tn.b(view.getContext(), 20);
        this.g = a46.j(view.getContext(), 4.0f, R$drawable.icon_default_thumbnail);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [DB extends androidx.databinding.ViewDataBinding, androidx.databinding.ViewDataBinding] */
    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        ?? Inflate = DataBindingUtil.inflate(LayoutInflater.from(this.itemView.getContext()), R$layout.layout_square_interact_item, (ViewGroup) this.itemView, false, new InteractItemBindingComponent(this));
        this.d = Inflate;
        ((ViewGroup) this.itemView).addView(((LayoutSquareInteractItemBinding) Inflate).getRoot());
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void l(SquareInteractBean squareInteractBean, int i) {
        if (squareInteractBean == null || squareInteractBean.singleInteract == null) {
            return;
        }
        ((LayoutSquareInteractItemBinding) this.d).p(squareInteractBean);
        ((LayoutSquareInteractItemBinding) this.d).q(this);
        ((LayoutSquareInteractItemBinding) this.d).executePendingBindings();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (l50.a()) {
            return;
        }
        SquareInteractDetail squareInteractDetail = ((LayoutSquareInteractItemBinding) this.d).o().singleInteract;
        DB db = this.d;
        if (view == ((LayoutSquareInteractItemBinding) db).g) {
            if (((LayoutSquareInteractItemBinding) db).o().ifAggregation) {
                ((yi5) this.e).E(((LayoutSquareInteractItemBinding) this.d).o());
                return;
            }
            ((yi5) this.e).C(getAdapterPosition(), ((LayoutSquareInteractItemBinding) this.d).o());
            SquareFeed squareFeed = new SquareFeed();
            squareFeed.id = ((LayoutSquareInteractItemBinding) this.d).o().singleInteract.feedId;
            qj5.u(((yi5) this.e).o(), squareFeed);
            return;
        }
        if (view == ((LayoutSquareInteractItemBinding) db).d) {
            ((yi5) this.e).A(getAdapterPosition(), squareInteractDetail);
            return;
        }
        if (view == ((LayoutSquareInteractItemBinding) db).n) {
            ((yi5) this.e).B(squareInteractDetail);
            if (((LayoutSquareInteractItemBinding) this.d).o().singleInteract.isFriend) {
                qj5.J("pagenewslist_friendschatcli", ((LayoutSquareInteractItemBinding) this.d).o().singleInteract.feedId, null, ((LayoutSquareInteractItemBinding) this.d).o().singleInteract.exFromUid, ((yi5) this.e).o());
                return;
            } else {
                qj5.J("pagenewslist_chat", ((LayoutSquareInteractItemBinding) this.d).o().singleInteract.feedId, null, ((LayoutSquareInteractItemBinding) this.d).o().singleInteract.exFromUid, ((yi5) this.e).o());
                return;
            }
        }
        if (view == ((LayoutSquareInteractItemBinding) db).m) {
            ((yi5) this.e).D(squareInteractDetail);
            qj5.J("pagenewslist_replycli", ((LayoutSquareInteractItemBinding) this.d).o().singleInteract.feedId, null, ((LayoutSquareInteractItemBinding) this.d).o().singleInteract.exFromUid, ((yi5) this.e).o());
        } else if (view == ((LayoutSquareInteractItemBinding) db).b) {
            ((yi5) this.e).C(getAdapterPosition(), ((LayoutSquareInteractItemBinding) this.d).o());
            SquareFeed squareFeed2 = new SquareFeed();
            squareFeed2.id = ((LayoutSquareInteractItemBinding) this.d).o().singleInteract.feedId;
            qj5.u(((yi5) this.e).o(), squareFeed2);
        }
    }

    @BindingAdapter({"interactAvatar"})
    public void p(ImageView imageView, String str) {
        gr2.j().h(k86.p(str), imageView, a46.l());
    }

    @BindingAdapter({"interactTime"})
    public void q(TextView textView, SquareInteractBean squareInteractBean) {
        textView.setText(cy5.g(squareInteractBean.singleInteract.createTime));
    }

    @BindingAdapter({"setFriendLabel"})
    public void r(TextView textView, SquareInteractBean squareInteractBean) {
        SquareInteractDetail squareInteractDetail = squareInteractBean.singleInteract;
        if (squareInteractDetail != null) {
            textView.setVisibility(squareInteractDetail.isFriend ? 0 : 8);
        }
    }

    @BindingAdapter({"interactText"})
    public void s(TextView textView, SquareInteractBean squareInteractBean) {
        SquareInteractDetail squareInteractDetail = squareInteractBean.singleInteract;
        if (squareInteractDetail.feedType != 1 || TextUtils.isEmpty(squareInteractDetail.feedContent)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(vl1.c(squareInteractBean.singleInteract.feedContent.trim(), textView.getContext(), vl1.j));
        }
    }

    @BindingAdapter({"interactNestAvatar"})
    public void t(View view, SquareInteractBean squareInteractBean) {
        if (!squareInteractBean.ifAggregation) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
            ((LayoutSquareInteractItemBinding) this.d).f.setInteractInfo(squareInteractBean);
        }
    }

    @BindingAdapter({"setReply"})
    public void u(TextView textView, SquareInteractBean squareInteractBean) {
        if (!squareInteractBean.ifAggregation) {
            SquareInteractDetail squareInteractDetail = squareInteractBean.singleInteract;
            if (!squareInteractDetail.hiddenDiscussion) {
                if (squareInteractDetail != null) {
                    int i = squareInteractDetail.noticeType;
                    if (i == 1 || i == 2 || squareInteractDetail.discussionStatus == 2) {
                        textView.setVisibility(8);
                        return;
                    } else {
                        textView.setVisibility(0);
                        return;
                    }
                }
                return;
            }
        }
        textView.setVisibility(8);
    }

    @BindingAdapter({"setSayHi"})
    public void v(TextView textView, SquareInteractBean squareInteractBean) {
        SquareInteractDetail squareInteractDetail = squareInteractBean.singleInteract;
        if (squareInteractDetail != null) {
            textView.setText(squareInteractDetail.isFriend ? R$string.square_btn_go_priv_chat : R$string.square_btn_go_say_hi);
        }
    }

    @BindingAdapter({"interactSummary"})
    public void w(TextView textView, SquareInteractBean squareInteractBean) {
        if (squareInteractBean.ifAggregation) {
            ((LayoutSquareInteractItemBinding) this.d).i.setVisibility(8);
            textView.setVisibility(0);
            int i = squareInteractBean.aggregationNoticeType;
            if (i == 1) {
                textView.setText(String.format("等%d人赞了你的评论", Long.valueOf(squareInteractBean.counts)));
                return;
            }
            if (i == 2) {
                textView.setText(String.format("等%d人赞了你的动态", Long.valueOf(squareInteractBean.counts)));
                return;
            } else {
                if (i == 3 || i == 4) {
                    textView.setText(String.format("等人发布了%d条评论", Long.valueOf(squareInteractBean.counts)));
                    return;
                }
                return;
            }
        }
        SquareInteractDetail squareInteractDetail = squareInteractBean.singleInteract;
        if (squareInteractDetail == null) {
            return;
        }
        if (squareInteractDetail.discussionStatus == 2) {
            ((LayoutSquareInteractItemBinding) this.d).i.setVisibility(0);
            textView.setVisibility(8);
            return;
        }
        ((LayoutSquareInteractItemBinding) this.d).i.setVisibility(8);
        textView.setVisibility(0);
        int i2 = squareInteractDetail.noticeType;
        SpannableString spannableString = new SpannableString(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "" : String.format("评论了你：%s", squareInteractDetail.discussionContent) : String.format("回复了你：%s", squareInteractDetail.discussionContent) : "赞了你的动态" : "赞了你的评论");
        xl1.a(textView.getContext(), this.f, 0, spannableString);
        textView.setText(spannableString);
    }

    @BindingAdapter({"interactThumbnail"})
    public void x(ImageView imageView, SquareInteractBean squareInteractBean) {
        if (TextUtils.isEmpty(squareInteractBean.singleInteract.thumbnailUrl) || squareInteractBean.singleInteract.feedType == 1) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setVisibility(0);
        imageView.setImageDrawable(null);
        gr2.j().h(squareInteractBean.singleInteract.thumbnailUrl, imageView, this.g);
    }
}
