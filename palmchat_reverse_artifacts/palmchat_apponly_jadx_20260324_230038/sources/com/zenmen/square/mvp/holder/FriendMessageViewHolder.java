package com.zenmen.square.mvp.holder;

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
import com.zenmen.square.databinding.LayoutSquareFriendMsgItemBinding;
import com.zenmen.square.mvp.SquareDataBindingComponent;
import com.zenmen.square.mvp.model.bean.PlaceFeed;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.a46;
import defpackage.cy5;
import defpackage.gr2;
import defpackage.je1;
import defpackage.k86;
import defpackage.m42;
import defpackage.qj5;
import defpackage.tq3;
import defpackage.vl1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FriendMessageViewHolder extends BaseViewHolder<PlaceFeed, LayoutSquareFriendMsgItemBinding, m42> implements View.OnClickListener {
    public je1 f;

    /* JADX INFO: compiled from: SearchBox */
    public static class FriendViewHolderComponent extends SquareDataBindingComponent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FriendMessageViewHolder f16432a;

        public FriendViewHolderComponent(FriendMessageViewHolder friendMessageViewHolder) {
            this.f16432a = friendMessageViewHolder;
        }

        @Override // com.zenmen.square.mvp.SquareDataBindingComponent, androidx.databinding.DataBindingComponent
        public FriendMessageViewHolder getFriendMessageViewHolder() {
            return this.f16432a;
        }
    }

    public FriendMessageViewHolder(View view) {
        super(view);
        this.f = null;
        this.f = a46.j(view.getContext(), 4.0f, R$drawable.icon_default_thumbnail);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [DB extends androidx.databinding.ViewDataBinding, androidx.databinding.ViewDataBinding] */
    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        ?? Inflate = DataBindingUtil.inflate(LayoutInflater.from(this.itemView.getContext()), R$layout.layout_square_friend_msg_item, (ViewGroup) this.itemView, false, new FriendViewHolderComponent(this));
        this.d = Inflate;
        ((ViewGroup) this.itemView).addView(((LayoutSquareFriendMsgItemBinding) Inflate).getRoot());
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void l(PlaceFeed placeFeed, int i) {
        ((LayoutSquareFriendMsgItemBinding) this.d).p(placeFeed);
        ((LayoutSquareFriendMsgItemBinding) this.d).q(this);
        ((LayoutSquareFriendMsgItemBinding) this.d).executePendingBindings();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DB db = this.d;
        if (view == ((LayoutSquareFriendMsgItemBinding) db).e) {
            ((m42) this.e).C(getAdapterPosition(), ((LayoutSquareFriendMsgItemBinding) this.d).o(), ((LayoutSquareFriendMsgItemBinding) this.d).d);
            SquareFeed squareFeed = new SquareFeed();
            squareFeed.id = ((LayoutSquareFriendMsgItemBinding) this.d).o().feed.getId();
            qj5.u(((m42) this.e).o(), squareFeed);
            return;
        }
        if (view == ((LayoutSquareFriendMsgItemBinding) db).c) {
            ((m42) this.e).A(getAdapterPosition(), ((LayoutSquareFriendMsgItemBinding) this.d).o());
            return;
        }
        if (view == ((LayoutSquareFriendMsgItemBinding) db).l) {
            ((m42) this.e).B(((LayoutSquareFriendMsgItemBinding) db).o());
            qj5.J("pagenewslist_friendschatcli", ((LayoutSquareFriendMsgItemBinding) this.d).o().feed.getId(), ((LayoutSquareFriendMsgItemBinding) this.d).o().comment.getFromUid(), null, ((m42) this.e).o());
        } else if (view == ((LayoutSquareFriendMsgItemBinding) db).k) {
            ((m42) this.e).D(((LayoutSquareFriendMsgItemBinding) db).o());
            qj5.J("pagenewslist_replycli", ((LayoutSquareFriendMsgItemBinding) this.d).o().feed.getId(), ((LayoutSquareFriendMsgItemBinding) this.d).o().comment.getFromUid(), null, ((m42) this.e).o());
        }
    }

    @BindingAdapter({"setContentText"})
    public void p(TextView textView, PlaceFeed placeFeed) {
        if (!TextUtils.isEmpty(placeFeed.thumbnail)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        try {
            textView.setText(vl1.c(new JSONObject(placeFeed.feed.getContent()).optString("text").trim(), textView.getContext(), vl1.j));
        } catch (JSONException e) {
            e.printStackTrace();
            textView.setText(vl1.c(placeFeed.feed.getContent(), textView.getContext(), vl1.j));
        }
    }

    @BindingAdapter({"setFriendAvatar"})
    public void q(ImageView imageView, PlaceFeed placeFeed) {
        gr2.j().h(k86.p(placeFeed.comment.getCommentCreatorAvatar()), imageView, a46.l());
    }

    @BindingAdapter({"setFriendMessageSummary"})
    public void r(TextView textView, PlaceFeed placeFeed) {
        if (placeFeed.comment.getType() == tq3.d) {
            textView.setVisibility(0);
            ((LayoutSquareFriendMsgItemBinding) this.d).g.setVisibility(8);
            ((LayoutSquareFriendMsgItemBinding) this.d).k.setVisibility(8);
            if (placeFeed.isSelfFeed()) {
                textView.setText(R$string.square_praise_feed);
                return;
            } else {
                textView.setText(R$string.square_praise_feed_other);
                return;
            }
        }
        if (TextUtils.equals(textView.getContext().getString(R$string.square_comment_delete_prompt), placeFeed.comment.getCommentContent())) {
            ((LayoutSquareFriendMsgItemBinding) this.d).g.setVisibility(0);
            textView.setVisibility(8);
            ((LayoutSquareFriendMsgItemBinding) this.d).k.setVisibility(8);
            return;
        }
        ((LayoutSquareFriendMsgItemBinding) this.d).k.setVisibility(0);
        textView.setVisibility(0);
        ((LayoutSquareFriendMsgItemBinding) this.d).g.setVisibility(8);
        if (!TextUtils.isEmpty(((LayoutSquareFriendMsgItemBinding) this.d).o().noticeTitle)) {
            textView.setText(vl1.c(((LayoutSquareFriendMsgItemBinding) this.d).o().noticeTitle, textView.getContext(), vl1.h));
            return;
        }
        String string = textView.getContext().getString(R$string.square_comment_feed_self);
        if (!placeFeed.isSelfFeed()) {
            string = textView.getContext().getString(R$string.square_comment_feed_other);
        }
        textView.setText(vl1.c(string + ((LayoutSquareFriendMsgItemBinding) this.d).o().comment.getCommentContent(), textView.getContext(), vl1.h));
    }

    @BindingAdapter({"setMessageThumbnail"})
    public void s(ImageView imageView, PlaceFeed placeFeed) {
        imageView.setImageDrawable(null);
        if (TextUtils.isEmpty(placeFeed.thumbnail)) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            gr2.j().h(placeFeed.thumbnail, imageView, this.f);
        }
    }

    @BindingAdapter({"setMessageTime"})
    public void t(TextView textView, PlaceFeed placeFeed) {
        textView.setText(cy5.g(placeFeed.comment.getCreateDt().longValue()));
    }

    @BindingAdapter({"setVideoCover"})
    public void u(ImageView imageView, int i) {
        if (i == 3 || i == 6) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }
}
