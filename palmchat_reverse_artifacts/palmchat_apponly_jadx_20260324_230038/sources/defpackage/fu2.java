package defpackage;

import android.app.Activity;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.InputItemManager;
import com.zenmen.palmchat.chat.gift.ShowChatGiftPanelEvent;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class fu2 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {
        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            ds0.a().b(new ShowChatGiftPanelEvent(null, null));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f17599a;
        public boolean b;
        public float c;
        public int d;

        public b(boolean z, boolean z2, float f) {
            this.f17599a = z;
            this.b = z2;
            this.c = f;
        }
    }

    public static boolean a(float f, MessageVo messageVo) {
        int i;
        return messageVo == null || !((i = messageVo.mimeType) == 2 || i == 14 || i == 4 || i == 6) || f >= gu2.a().chatwindow_alert_pic;
    }

    public static boolean b(ContactInfoItem contactInfoItem, float f) {
        return !gu2.f() || contactInfoItem == null || h(contactInfoItem) >= f;
    }

    public static boolean c(String str, ArrayList<MessageVo> arrayList) {
        ContactInfoItem contactInfoItemL;
        if (!gu2.f() || (contactInfoItemL = bo0.r().l(str)) == null) {
            return true;
        }
        Iterator<MessageVo> it = arrayList.iterator();
        while (it.hasNext()) {
            if (!a(h(contactInfoItemL), it.next())) {
                return false;
            }
        }
        return true;
    }

    public static b d(ChatterActivity chatterActivity, InputItemManager.InputItemType inputItemType) {
        b bVar;
        b bVar2 = new b(true, false, 0.0f);
        float fW3 = chatterActivity.w3();
        if (!gu2.f()) {
            if (inputItemType != InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL) {
                return bVar2;
            }
            b bVar3 = fg6.d(AppContext.getContext()) ? new b(true, true, 0.0f) : new b(false, false, 0.0f);
            bVar3.d = 2;
            return bVar3;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_AUDIO) {
            if (fW3 < gu2.a().chatwindow_alert_audio && gu2.a().chatwindow_alert_audio != -1.0f) {
                bVar2 = new b(false, false, gu2.a().chatwindow_alert_audio);
            }
            bVar2.d = 3;
            return bVar2;
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_IMAGE || inputItemType == InputItemManager.InputItemType.INPUT_ITEM_EXPRESSION || inputItemType == InputItemManager.InputItemType.INPUT_ITEM_CAMERA || inputItemType == InputItemManager.InputItemType.INPUT_ITEM_FILE) {
            if (fW3 < gu2.a().chatwindow_alert_pic && gu2.a().chatwindow_alert_pic != -1.0f) {
                bVar2 = new b(false, false, gu2.a().chatwindow_alert_pic);
            }
            bVar2.d = 1;
            return bVar2;
        }
        if (inputItemType != InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL) {
            return bVar2;
        }
        if (!fg6.d(AppContext.getContext())) {
            if (fW3 < gu2.a().chatwindow_alert_call && gu2.a().chatwindow_alert_call != -1.0f) {
                bVar = new b(false, false, gu2.a().chatwindow_alert_call);
            }
            bVar2.d = 2;
            return bVar2;
        }
        bVar = new b(true, true, gu2.a().chatwindow_alert_call);
        bVar2 = bVar;
        bVar2.d = 2;
        return bVar2;
    }

    public static boolean e(Activity activity, InputItemManager.InputItemType inputItemType) {
        return f(activity, inputItemType).f17599a;
    }

    public static b f(Activity activity, InputItemManager.InputItemType inputItemType) {
        b bVar = new b(true, false, 0.0f);
        if (!(activity instanceof ChatterActivity)) {
            return bVar;
        }
        ChatterActivity chatterActivity = (ChatterActivity) activity;
        b bVarD = d(chatterActivity, inputItemType);
        iu2.a(chatterActivity.o3(), bVarD);
        return bVarD;
    }

    public static boolean g(Activity activity, InputItemManager.InputItemType inputItemType) {
        b bVarF = f(activity, inputItemType);
        if (!bVarF.f17599a) {
            j(activity, bVarF.c, inputItemType);
        }
        return bVarF.f17599a;
    }

    public static float h(ChatItem chatItem) {
        if (!(chatItem instanceof ContactInfoItem)) {
            return 2.1474836E9f;
        }
        ContactInfoItem contactInfoItem = (ContactInfoItem) chatItem;
        if ((v8.h() && v8.C(contactInfoItem.getUid())) || a65.c(contactInfoItem)) {
            return 2.1474836E9f;
        }
        return contactInfoItem.getIntimacyScore();
    }

    public static float i(ArrayList<MessageVo> arrayList) {
        float f = -1.0f;
        if (gu2.f() && arrayList != null && arrayList.size() > 0) {
            Iterator<MessageVo> it = arrayList.iterator();
            while (it.hasNext()) {
                int i = it.next().mimeType;
                if (i == 2 || i == 14 || i == 4 || i == 6) {
                    f = gu2.a().chatwindow_alert_pic;
                }
            }
        }
        return f;
    }

    public static void j(Activity activity, float f, InputItemManager.InputItemType inputItemType) {
        if (activity instanceof ChatterActivity) {
            ChatItem chatItemO3 = ((ChatterActivity) activity).o3();
            if (chatItemO3 instanceof ContactInfoItem) {
                ContactInfoItem contactInfoItem = (ContactInfoItem) chatItemO3;
                if (System.currentTimeMillis() - ((Long) q05.k("KEY_SHOW_INTIMACY_GUID_LASTTIME" + chatItemO3.getChatId(), 0L)).longValue() > 300000) {
                    ba.c().e(contactInfoItem);
                    q05.w("KEY_SHOW_INTIMACY_GUID_LASTTIME" + chatItemO3.getChatId(), Long.valueOf(System.currentTimeMillis()));
                }
            }
        }
        k(activity, f);
    }

    public static void k(Activity activity, float f) {
        new sd3(activity).k("你们的亲密度需要到达" + gu2.b(f, false) + "度才可使用该功能。送礼物和聊天都可使关系快速升温！").P("立即升温").L("放弃").f(new a()).e().show();
    }
}
