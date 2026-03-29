package com.zenmen.square.comment.ui;

import android.content.Context;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.square.comment.model.CommentViewModel;
import com.zenmen.square.comment.struct.UnitedException;
import com.zenmen.square.comment.ui.CommentAdapter;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.cw4;
import defpackage.mi0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface b {
    void a(mi0 mi0Var, CommentViewModel commentViewModel, int i);

    void b(UnitedException unitedException);

    SquareFeed c();

    void d(CommentAdapter.CommentViewHolder commentViewHolder, Boolean bool, CommentViewModel commentViewModel, String str);

    void e(CommentViewModel commentViewModel, int i, cw4 cw4Var);

    void f(BaseNetBean baseNetBean, CommentViewModel commentViewModel, int i);

    void g(CommentViewModel commentViewModel, int i);

    int h(CommentViewModel commentViewModel, int i);

    void i(mi0 mi0Var);

    Context j();

    void k(int i, String str);

    void l(CommentViewModel commentViewModel, int i);
}
