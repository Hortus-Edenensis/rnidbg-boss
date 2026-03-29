package defpackage;

import android.app.Activity;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingChatCardInfo;
import com.zenmen.palmchat.chat.fragment.a;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public interface p40 {
    HashMap<String, ContactInfoItem> b();

    AiGreetingChatCardInfo c();

    a e();

    boolean f();

    ContactInfoItem g(MessageVo messageVo);

    Activity getActivity();

    GroupInfoItem getGroupItem();

    ChatterAdapter.g h();

    List<String> i();

    List<SquareFeed> j();

    ChatterAdapter.h o();

    List<String> q();
}
