package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.square.comment.model.CommentModel;
import com.zenmen.square.comment.model.CommentViewModel;
import com.zenmen.square.comment.model.ResultBean;
import com.zenmen.square.comment.struct.CommentItem;
import com.zenmen.square.comment.struct.CommentReplyItem;
import com.zenmen.square.comment.struct.SquareCommentBean;
import com.zenmen.square.comment.ui.CommentAdapter;
import com.zenmen.square.comment.ui.CommentDialog;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.et2;
import defpackage.nq3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ti0 implements nq3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20994a = new Object();
    public SquareFeed b;
    public ResultBean c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnDismissListener f20995a;

        public a(DialogInterface.OnDismissListener onDismissListener) {
            this.f20995a = onDismissListener;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnDismissListener onDismissListener = this.f20995a;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(CommentViewModel commentViewModel, int i);

        void b(CommentViewModel commentViewModel, int i);

        void c(CommentViewModel commentViewModel, int i);

        void d(CommentAdapter.CommentViewHolder commentViewHolder, CommentViewModel commentViewModel, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static ti0 f20997a = new ti0();
    }

    public static ti0 c() {
        return d.f20997a;
    }

    @Override // nq3.a
    public void a(Activity activity, Feed feed, int i, int i2, nq3.b bVar) {
        f(activity, SquareFeed.convertToSquareFeed(feed), null, i, i2, bVar);
    }

    @Override // nq3.a
    public void b(Context context, Feed feed, int i, int i2) {
        d(context, SquareFeed.convertToSquareFeed(feed), i, i2);
    }

    public void d(Context context, SquareFeed squareFeed, int i, int i2) {
        e(context, squareFeed, i, i2, null, null);
    }

    public void e(Context context, SquareFeed squareFeed, int i, int i2, LXBottomSheetDialog.c cVar, DialogInterface.OnDismissListener onDismissListener) {
        if (context == null) {
            return;
        }
        if (((context instanceof Activity) && ((Activity) context).isFinishing()) || squareFeed.hiddenDiscussion) {
            return;
        }
        qj5.m(squareFeed, i);
        CommentDialog commentDialog = new CommentDialog(context, squareFeed);
        commentDialog.u(cVar);
        commentDialog.w(false);
        commentDialog.v(0.7f);
        commentDialog.setOnDismissListener(new a(onDismissListener));
        if (squareFeed != this.b) {
            this.c = new ResultBean();
            this.b = squareFeed;
        }
        try {
            commentDialog.d0(new ResultBean(), i2, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void f(Activity activity, SquareFeed squareFeed, SquareCommentBean squareCommentBean, int i, int i2, nq3.b bVar) {
        CommentViewModel commentViewModel;
        et2 et2Var = new et2(activity, null, new oi0(activity, squareFeed).h(), squareFeed);
        et2Var.h(bVar);
        et2Var.c(new b());
        et2Var.f(squareFeed.businessFrom == 1 ? new qq3(activity, i) : new CommentModel());
        if (squareCommentBean != null) {
            squareCommentBean.businessFrom = squareFeed.businessFrom;
            commentViewModel = squareCommentBean.discussionType == 1 ? new CommentViewModel(0, CommentItem.fromCommentInfo(squareCommentBean), null) : new CommentViewModel(1, null, CommentReplyItem.fromReplyInfo(squareCommentBean));
        } else {
            commentViewModel = null;
        }
        if (squareFeed != this.b) {
            this.c = new ResultBean();
            this.b = squareFeed;
        }
        ResultBean resultBean = this.c;
        et2Var.i(resultBean, resultBean.commentContent, commentViewModel, -1, i2, false, i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements et2.c {
        public b() {
        }

        @Override // et2.c
        public void onDismiss() {
        }

        @Override // et2.c
        public void onShow() {
        }
    }
}
