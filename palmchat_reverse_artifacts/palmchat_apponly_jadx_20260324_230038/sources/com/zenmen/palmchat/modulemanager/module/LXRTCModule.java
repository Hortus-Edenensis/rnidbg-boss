package com.zenmen.palmchat.modulemanager.module;

import android.app.Activity;
import android.app.Application;
import android.os.Message;
import android.util.Pair;
import com.zenmen.media.roomchatdemo.videocallgroup.d;
import com.zenmen.media.roomchatdemo.videocallgroup.userInfo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.lxvoip.LxVoipManager;
import com.zenmen.palmchat.rtc.bean.RoomInfo;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import defpackage.fu5;
import defpackage.rx;
import defpackage.ww;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXRTCModule extends AbsModule {
    public static void joinRoom(FrameworkBaseActivity frameworkBaseActivity, RoomSDKInfo roomSDKInfo) {
        if (BaseActivityPermissionDispatcher.b(frameworkBaseActivity, BaseActivityPermissionDispatcher.PermissionType.GROUP_AUDIO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_AUDIO_CALL)) {
            LxVoipManager.b().e("groupChat");
            LxVoipManager.b().h(frameworkBaseActivity, true, roomSDKInfo);
        }
    }

    public static void startGroupCall(final Activity activity, final String str, List<Long> list, Message message) {
        List<userInfo> listQ = d.P().Q();
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (Long l : list) {
            arrayList.add(String.valueOf(l));
            RoomUserInfo roomUserInfo = new RoomUserInfo();
            roomUserInfo.uid = String.valueOf(l);
            Iterator<userInfo> it = listQ.iterator();
            while (true) {
                if (it.hasNext()) {
                    userInfo next = it.next();
                    if (next.id == l.longValue()) {
                        roomUserInfo.headImg = next.iconurl;
                        roomUserInfo.nickName = next.name;
                        break;
                    }
                }
            }
            arrayList2.add(roomUserInfo);
        }
        ww.a(str, "muc.youni", 0, 0, arrayList, new rx<LXBaseNetBean<RoomInfo>>() { // from class: com.zenmen.palmchat.modulemanager.module.LXRTCModule.1
            @Override // defpackage.rx
            public void onResult(boolean z, LXBaseNetBean<RoomInfo> lXBaseNetBean, Exception exc) {
                RoomInfo roomInfo;
                if (z && lXBaseNetBean.isSuccess() && (roomInfo = lXBaseNetBean.data) != null && roomInfo.sdkType == 1) {
                    LxVoipManager.b().e("groupChat");
                    RoomInfo roomInfo2 = lXBaseNetBean.data;
                    roomInfo2.sdkResult.userList = arrayList2;
                    roomInfo2.sdkResult.groupId = str;
                    LxVoipManager.b().m(activity, lXBaseNetBean.data.sdkResult, LxVoipManager.CallMediaType.CALL_MEDIA_TYPE_AUDIO);
                }
            }
        });
    }

    public static void startSingleCall(final Activity activity, final ChatItem chatItem, final boolean z) {
        Pair<String, Integer> pairJ = fu5.j(chatItem.getBizType());
        ArrayList arrayList = new ArrayList();
        arrayList.add(chatItem.getChatId());
        ww.a("", (String) pairJ.first, ((Integer) pairJ.second).intValue(), z ? 1 : 0, arrayList, new rx<LXBaseNetBean<RoomInfo>>() { // from class: com.zenmen.palmchat.modulemanager.module.LXRTCModule.2
            @Override // defpackage.rx
            public void onResult(boolean z2, LXBaseNetBean<RoomInfo> lXBaseNetBean, Exception exc) {
                RoomInfo roomInfo;
                if (z2 && lXBaseNetBean.isSuccess() && (roomInfo = lXBaseNetBean.data) != null && roomInfo.sdkType == 1) {
                    LxVoipManager.b().e("1v1Chat");
                    ArrayList<RoomUserInfo> arrayList2 = new ArrayList<>();
                    RoomUserInfo roomUserInfo = new RoomUserInfo();
                    roomUserInfo.uid = chatItem.getChatId();
                    roomUserInfo.nickName = chatItem.getChatName();
                    roomUserInfo.headImg = chatItem.getIconURL();
                    arrayList2.add(roomUserInfo);
                    lXBaseNetBean.data.sdkResult.userList = arrayList2;
                    LxVoipManager.b().m(activity, lXBaseNetBean.data.sdkResult, z ? LxVoipManager.CallMediaType.CALL_MEDIA_TYPE_VIDEO : LxVoipManager.CallMediaType.CALL_MEDIA_TYPE_AUDIO);
                }
            }
        });
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public boolean isNeedCheckPrivacyAgree() {
        return true;
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public boolean isOnlyInitOnMainProcess() {
        return true;
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationCreate(Application application) {
        LxVoipManager.b().d(application);
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }
}
