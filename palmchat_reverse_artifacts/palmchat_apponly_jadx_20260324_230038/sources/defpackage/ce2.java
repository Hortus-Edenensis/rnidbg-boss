package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.circle.bean.CircleGreetBean;
import com.zenmen.palmchat.circle.bean.CircleGreetEvent;
import com.zenmen.palmchat.circle.bean.CircleGreetMember;
import com.zenmen.palmchat.database.DBUriManager;
import defpackage.n54;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class ce2 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends a41 {
        @Override // defpackage.ln2
        public boolean a(MessageProto.Message message) {
            return ce2.d(message);
        }

        @Override // defpackage.a41, defpackage.ln2
        public void d(MessageProto.Message message) {
            ce2.f(message);
        }
    }

    public static boolean c(List<CircleGreetMember.Member> list, String str) {
        if (list.isEmpty()) {
            return false;
        }
        Iterator<CircleGreetMember.Member> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().uid, str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(MessageProto.Message message) {
        return message.getType() == 56 && fu5.o(message) == 0;
    }

    public static /* synthetic */ void e(ContentResolver contentResolver, String str, String[] strArr, String str2, String str3, String str4, sm5 sm5Var) {
        Cursor cursorQuery = contentResolver.query(DBUriManager.a(ho3.class, 0), null, str, strArr, null);
        if (cursorQuery != null) {
            if (cursorQuery.moveToFirst()) {
                CircleGreetMember circleGreetMember = (CircleGreetMember) az2.a(cursorQuery.getString(cursorQuery.getColumnIndex("data1")), CircleGreetMember.class);
                if (circleGreetMember == null) {
                    circleGreetMember = new CircleGreetMember();
                    circleGreetMember.greetMembers = new ArrayList();
                }
                if (TextUtils.equals(str2, AccountUtils.p(AppContext.getContext()))) {
                    circleGreetMember.isGreeted = 1;
                }
                if (!c(circleGreetMember.greetMembers, str2)) {
                    CircleGreetMember.Member member = new CircleGreetMember.Member();
                    member.uid = str2;
                    circleGreetMember.greetMembers.add(member);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("data1", az2.c(circleGreetMember));
                    contentResolver.update(DBUriManager.a(ho3.class, 0), contentValues, str, strArr);
                    if (oc0.d()) {
                        if (TextUtils.equals(str3, AccountUtils.p(AppContext.getContext()))) {
                            o90.b(str4, 1);
                            contentResolver.notifyChange(dx5.f17178a, (ContentObserver) null, false);
                        }
                        ds0.a().b(new CircleGreetEvent(str4));
                    }
                }
            }
            cursorQuery.close();
        }
    }

    public static void f(MessageProto.Message message) {
        g(message);
    }

    public static void g(MessageProto.Message message) {
        CircleGreetBean circleGreetBean;
        CircleGreetBean.GreetGroup greetGroup;
        String extension = message.getExtension();
        if (TextUtils.isEmpty(extension) || (circleGreetBean = (CircleGreetBean) az2.a(extension, CircleGreetBean.class)) == null || (greetGroup = circleGreetBean.greet) == null) {
            return;
        }
        String str = greetGroup.mid;
        final String str2 = greetGroup.fromUid;
        final String str3 = greetGroup.toUid;
        final String str4 = greetGroup.roomId;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return;
        }
        final ContentResolver contentResolver = AppContext.getContext().getContentResolver();
        final String str5 = "packet_id=? and msg_type=?";
        final String[] strArr = {str, String.valueOf(24)};
        n54.a(new n54.a() { // from class: be2
            @Override // defpackage.c5
            public final void call(Object obj) {
                ce2.e(contentResolver, str5, strArr, str2, str3, str4, (sm5) obj);
            }
        }).u(b35.c()).p();
    }
}
