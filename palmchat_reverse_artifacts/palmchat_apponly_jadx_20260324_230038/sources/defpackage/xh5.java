package defpackage;

import com.zenmen.palmchat.friendcircle.bean.SquareSimpleComment;
import com.zenmen.palmchat.greendao.model.Comment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class xh5 {
    public static List<SquareSimpleComment> a(List<Comment> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Comment comment : list) {
            SquareSimpleComment squareSimpleComment = new SquareSimpleComment();
            squareSimpleComment.id = comment.getId().longValue();
            squareSimpleComment.content = comment.getContent();
            squareSimpleComment.fromUid = comment.getFromUid();
            arrayList.add(squareSimpleComment);
        }
        return arrayList;
    }
}
