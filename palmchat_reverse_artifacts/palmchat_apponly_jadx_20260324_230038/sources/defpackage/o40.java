package defpackage;

import android.content.Context;
import android.view.View;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.contacts.ContactInfoItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public interface o40 {
    int a();

    View b(Context context, MessageVo messageVo);

    <T extends if6> T c(View view);

    void d(int i);

    void e(ChatterAdapter.h hVar);

    void f(Context context, ChatItem chatItem);

    void g(int i);

    int getViewTypeCount();

    void h(p40 p40Var);

    void i(ContactInfoItem contactInfoItem);

    int j(boolean z, int i, MessageVo messageVo);

    void k(ChatItem chatItem);

    <T extends if6> void l(T t, MessageVo messageVo);

    int m(boolean z, int i, MessageVo messageVo);
}
