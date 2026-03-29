package defpackage;

import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.ReadState;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.paidservices.readstate.guide.ReadStateGuideManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class lt4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile lt4 f19074a;

    public static lt4 d() {
        if (f19074a == null) {
            synchronized (lt4.class) {
                if (f19074a == null) {
                    f19074a = new lt4();
                }
            }
        }
        return f19074a;
    }

    public static boolean g() {
        return t66.h().f("LX-65385", false);
    }

    public static boolean h(MessageVo messageVo) {
        int i;
        return messageVo != null && ((i = messageVo.mimeType) == 1 || i == 2 || i == 14 || i == 4 || i == 3 || i == 35 || i == 7 || i == 9 || i == 6 || i == 28 || i == 30);
    }

    public final MessageVo a(MessageVo messageVo) {
        MessageVo messageVo2 = new MessageVo();
        messageVo2.time = 0L;
        messageVo2.mimeType = 12345;
        messageVo2.text = "test";
        messageVo2.versionId = messageVo.versionId;
        return messageVo2;
    }

    public final void b(ChatItem chatItem, MessageVo messageVo) {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        if (messageVo.versionId > sPUtil.k(scene, "key_read_state_chat_last_read_version" + chatItem.getChatId(), 0L)) {
            sPUtil.v(scene, "key_read_state_chat_last_read_version" + chatItem.getChatId(), Long.valueOf(messageVo.versionId));
            try {
                LogUtil.i("ReadStateManager", "checkAndSendReadStateMsg msg=" + messageVo.text + " version = " + messageVo.versionId);
                ch.s().u().r(MessageVo.buildReadStatusMessage(chatItem.getChatId()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final String c(MessageProto.Message message) {
        RichMsgVo richMsgVo;
        ReadState readState;
        String extension = message.getExtension();
        if (extension == null || (richMsgVo = (RichMsgVo) az2.a(extension, RichMsgVo.class)) == null || (readState = richMsgVo.readState) == null) {
            return null;
        }
        return readState.fromUid;
    }

    public long e(String str) {
        return SPUtil.f14322a.i(SPUtil.SCENE.APP_COMMON, k86.a("key_read_state_fuid_version" + str), 0L);
    }

    public boolean f(ChatItem chatItem, long j) {
        if (j == 0) {
            return false;
        }
        long jE = e(chatItem.getChatId());
        return jE > 0 && jE >= j;
    }

    public void i(MessageProto.Message message) {
        try {
            if (ReadStateGuideManager.e().d().cmdSwitch) {
                String strC = c(message);
                long version = message.getVersion();
                LogUtil.i("ReadStateManager", "process fuid=" + strC + " version =" + version);
                SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_read_state_fuid_version" + strC), Long.valueOf(version));
                if (g() && fg6.d(AppContext.getContext())) {
                    ch.s().a0(strC);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i("ReadStateManager", "process error", e);
        }
    }

    public void j(ChatItem chatItem, ArrayList<MessageVo> arrayList, boolean z, boolean z2) {
        try {
            k(chatItem, arrayList, z, z2);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i("ReadStateManager", "processReadStateMsg error", e);
        }
    }

    public final void k(ChatItem chatItem, ArrayList<MessageVo> arrayList, boolean z, boolean z2) {
        MessageVo messageVo;
        long jB = ir5.b();
        if ((chatItem instanceof ContactInfoItem) && !a65.c(chatItem) && !a65.e(chatItem)) {
            int iK = (g() && z) ? ReadStateGuideManager.e().k(chatItem) : 0;
            if (arrayList != null && arrayList.size() > 0) {
                MessageVo messageVo2 = null;
                if (g()) {
                    int size = arrayList.size() - 1;
                    while (size >= 0) {
                        messageVo = arrayList.get(size);
                        if (h(messageVo)) {
                            boolean z3 = messageVo.isSend;
                            if (z3 && messageVo.status == 2) {
                                break;
                            } else if (!z3) {
                                break;
                            }
                        }
                        size--;
                    }
                    size = -1;
                    messageVo = null;
                    if (size >= 0) {
                        LogUtil.i("ReadStateManager", "insertReadStateMsg");
                        arrayList.add(size + 1, a(messageVo));
                        if (z) {
                            ReadStateGuideManager.e().c(chatItem, iK);
                        }
                    }
                    ReadStateGuideManager.e().b(chatItem, arrayList);
                }
                if (ReadStateGuideManager.e().d().cmdSwitch && !z2) {
                    int size2 = arrayList.size() - 1;
                    while (true) {
                        if (size2 < 0) {
                            break;
                        }
                        MessageVo messageVo3 = arrayList.get(size2);
                        if (h(messageVo3) && !messageVo3.isSend) {
                            messageVo2 = messageVo3;
                            break;
                        }
                        size2--;
                    }
                    if (messageVo2 != null) {
                        b(chatItem, messageVo2);
                    }
                }
            }
        }
        LogUtil.i("ReadStateManager", "processTime =" + ir5.e(jB));
    }
}
