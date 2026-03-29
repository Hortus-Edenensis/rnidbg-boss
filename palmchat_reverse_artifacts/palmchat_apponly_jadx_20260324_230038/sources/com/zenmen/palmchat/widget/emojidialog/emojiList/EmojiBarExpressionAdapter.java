package com.zenmen.palmchat.widget.emojidialog.emojiList;

import android.content.Context;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import defpackage.vl1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class EmojiBarExpressionAdapter extends BaseRecyclerAdapter<String> {
    public EmojiBarExpressionAdapter(Context context) {
        super(context, R$layout.lx_emoji_image_row_expression);
    }

    @Override // com.zenmen.palmchat.widget.emojidialog.emojiList.BaseRecyclerAdapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void b(RecyclerViewHolder recyclerViewHolder, int i, String str) {
        try {
            recyclerViewHolder.n(R$id.iv_expression, vl1.h(vl1.f().get(str)));
        } catch (OutOfMemoryError unused) {
        }
    }
}
