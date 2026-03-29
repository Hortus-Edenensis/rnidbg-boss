package com.zenmen.square.comment.emoji.adapter;

import android.content.Context;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import defpackage.xl1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class EmojiBarExpressionAdapter extends BaseRecyclerAdapter<String> {
    public EmojiBarExpressionAdapter(Context context) {
        super(context, R$layout.square_emoji_image_row_expression);
    }

    @Override // com.zenmen.square.comment.emoji.adapter.BaseRecyclerAdapter
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void b(RecyclerViewHolder recyclerViewHolder, int i, String str) {
        recyclerViewHolder.n(R$id.iv_expression, xl1.c(str));
    }
}
