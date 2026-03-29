package defpackage;

import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class g90 {
    public static void a(MessageVo messageVo, GroupInfoItem groupInfoItem, String str) {
        if (messageVo == null || groupInfoItem == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("rid", groupInfoItem.getGroupId());
        map.put("mid", messageVo.mid);
        map.put("newuid", DomainHelper.q(messageVo.from));
        map.put("type", str);
        oc0.h("lx_groupchat_hi_click", map);
    }

    public static void b(MessageVo messageVo, GroupInfoItem groupInfoItem) {
        if (messageVo == null || groupInfoItem == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("rid", groupInfoItem.getGroupId());
        map.put("mid", messageVo.mid);
        map.put("newuid", DomainHelper.q(messageVo.from));
        oc0.h("lx_groupchat_hi_show", map);
    }

    public static void c(MessageVo messageVo, GroupInfoItem groupInfoItem, String str) {
        if (messageVo == null || groupInfoItem == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("rid", groupInfoItem.getGroupId());
        map.put("mid", messageVo.mid);
        map.put("photouid", str);
        oc0.h("lx_groupchat_photo_click", map);
    }

    public static void d(MessageVo messageVo, GroupInfoItem groupInfoItem) {
        if (messageVo == null || groupInfoItem == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("rid", groupInfoItem.getGroupId());
        map.put("mid", messageVo.mid);
        oc0.h("lx_groupchat_photo_show", map);
    }

    public static void e(MessageVo messageVo, GroupInfoItem groupInfoItem) {
        if (messageVo == null || groupInfoItem == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("rid", groupInfoItem.getGroupId());
        map.put("mid", messageVo.mid);
        oc0.h("lx_groupchat_script_click", map);
    }
}
