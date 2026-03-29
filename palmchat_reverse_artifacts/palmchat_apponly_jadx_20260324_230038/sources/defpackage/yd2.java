package defpackage;

import android.content.Context;
import android.content.Intent;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import defpackage.fk2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class yd2 implements fk2 {
    @Override // defpackage.fk2
    public Intent a(Context context, fk2.a aVar) {
        String string = aVar.a().getString("group_id");
        Intent intent = new Intent(context, (Class<?>) ChatterActivity.class);
        GroupInfoItem groupInfoItem = new GroupInfoItem();
        groupInfoItem.setGroupId(string);
        intent.putExtra("chat_item", groupInfoItem);
        intent.putExtra("chat_need_back_to_main", false);
        return intent;
    }
}
