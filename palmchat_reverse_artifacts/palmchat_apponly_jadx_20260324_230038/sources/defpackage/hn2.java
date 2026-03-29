package defpackage;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.ui.widget.commentwidget.CommentWidget;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface hn2 {
    void C(@Nullable View view, int i, long j, CommentWidget commentWidget);

    void U(int i, List<Comment> list);

    void d0(@NonNull Feed feed);

    int o();
}
