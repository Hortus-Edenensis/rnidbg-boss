package defpackage;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.groupvideochat.vo.UserInfo;
import com.zenmen.palmchat.chat.groupvideochat.vo.VoiceCmd;
import com.zenmen.palmchat.chat.groupvideochat.vo.VoiceCmdExt;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.lxvoip.LxVoipManager;
import com.zenmen.palmchat.modulemanager.module.LXRTCModule;
import com.zenmen.palmchat.rtc.bean.RoomInfo;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class xe2 implements pm2<Cursor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f21935a;
    public View b;
    public TextView c;
    public View d;
    public RelativeLayout e;
    public TextView f;
    public TextView g;
    public LinearLayout h;
    public ChatterActivity i;
    public ChatItem j;
    public LayoutInflater k;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public VoiceCmd p;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            xe2.this.i(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            xe2.this.i(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterActivity f21938a;
        public final /* synthetic */ ChatItem b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements rx<LXBaseNetBean<RoomInfo>> {
            public a() {
            }

            @Override // defpackage.rx
            public void onResult(boolean z, LXBaseNetBean<RoomInfo> lXBaseNetBean, Exception exc) {
                List<UserInfo> list;
                if (z) {
                    if (!lXBaseNetBean.isSuccess()) {
                        if (lXBaseNetBean.resultCode == 2000) {
                            zh.k(AppContext.getContext().getContentResolver()).g(0, null, DBUriManager.b(ho3.class, c.this.b), "data1=? and msg_type=?", new String[]{c.this.b.getChatId(), Integer.toString(49)});
                            return;
                        }
                        return;
                    }
                    ArrayList<RoomUserInfo> arrayList = new ArrayList<>();
                    com.zenmen.palmchat.chat.groupvideochat.vo.RoomInfo roomInfo = xe2.this.p.roomInfo;
                    if (roomInfo != null && (list = roomInfo.userList) != null) {
                        Iterator<UserInfo> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(UserInfo.convert(it.next()));
                        }
                    }
                    RoomInfo roomInfo2 = lXBaseNetBean.data;
                    roomInfo2.sdkResult.userList = arrayList;
                    RoomSDKInfo roomSDKInfo = roomInfo2.sdkResult;
                    c cVar = c.this;
                    roomSDKInfo.groupId = xe2.this.p.groupId;
                    roomInfo2.sdkResult.callSTime = roomInfo2.callSTime;
                    LXRTCModule.joinRoom(cVar.f21938a, roomInfo2.sdkResult);
                }
            }
        }

        public c(ChatterActivity chatterActivity, ChatItem chatItem) {
            this.f21938a = chatterActivity;
            this.b = chatItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                VoiceCmd voiceCmd = xe2.this.p;
                if (voiceCmd.type == 1) {
                    ww.b(voiceCmd.groupId, "muc.youni", 0, voiceCmd.roomId, new a());
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator<UserInfo> it = xe2.this.p.roomInfo.userList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().uid);
                    }
                    VoiceCmd voiceCmd2 = xe2.this.p;
                    wa6.i(voiceCmd2.groupId, voiceCmd2.roomId, voiceCmd2.roomToken, arrayList, voiceCmd2.tag);
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                xe2.this.i(false);
                throw th;
            }
            xe2.this.i(false);
        }
    }

    public final void b(boolean z, String str, VoiceCmd voiceCmd) {
        LogUtil.i("GroupVideoChatUIHelper", "checkChatRoomExist start" + z);
        if (!z || this.n) {
            return;
        }
        if (voiceCmd != null && voiceCmd.msgType == 0 && !TextUtils.isEmpty(str) && this.j != null) {
            LogUtil.i("GroupVideoChatUIHelper", "checkChatRoomExist process");
            new k50(this.j).o(str, voiceCmd);
        }
        this.n = true;
    }

    public final VoiceCmd c() {
        try {
            new JSONObject("{\"voiceCmd\":{\"creatorId\":\"0\",\"groupId\":\"497062786\",\"msgType\":0,\"roomId\":\"562954566107136\",\"roomInfo\":{\"userList\":[{\"cid\":\"0\",\"status\":0,\"uid\":\"0\"},{\"cid\":\"0\",\"status\":0,\"uid\":\"4736580105535488\"},{\"cid\":\"0\",\"status\":0,\"uid\":\"4431218930663424\"}]},\"roomToken\":\"2914139323\"}}").optJSONObject("voiceCmd");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return VoiceCmdExt.parseFromExt("{\"voiceCmd\":{\"creatorId\":\"0\",\"groupId\":\"497062786\",\"msgType\":0,\"roomId\":\"562954566107136\",\"roomInfo\":{\"userList\":[{\"cid\":\"0\",\"status\":0,\"uid\":\"0\"},{\"cid\":\"0\",\"status\":0,\"uid\":\"4736580105535488\"},{\"cid\":\"0\",\"status\":0,\"uid\":\"4431218930663424\"}]},\"roomToken\":\"2914139323\"}}").voiceCmd;
    }

    public void d() {
        View view = this.b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public boolean e() {
        com.zenmen.palmchat.chat.groupvideochat.vo.RoomInfo roomInfo;
        List<UserInfo> list;
        VoiceCmd voiceCmd = this.p;
        return (voiceCmd == null || voiceCmd.msgType != 0 || (roomInfo = voiceCmd.roomInfo) == null || (list = roomInfo.userList) == null || list.size() <= 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(ChatterActivity chatterActivity, ChatItem chatItem) {
        boolean z;
        this.i = chatterActivity;
        this.j = chatItem;
        RelativeLayout relativeLayout = (RelativeLayout) chatterActivity.findViewById(R.id.groupVideoChatLayout);
        this.f21935a = relativeLayout;
        relativeLayout.setVisibility(8);
        LayoutInflater layoutInflater = chatterActivity.getLayoutInflater();
        this.k = layoutInflater;
        View viewInflate = layoutInflater.inflate(R.layout.group_chat_video_bar, (ViewGroup) null);
        this.f = (TextView) viewInflate.findViewById(R.id.joinTV);
        this.g = (TextView) viewInflate.findViewById(R.id.cancelTV);
        this.h = (LinearLayout) viewInflate.findViewById(R.id.member_layout);
        this.e = (RelativeLayout) viewInflate.findViewById(R.id.group_video_detail_layout);
        this.c = (TextView) viewInflate.findViewById(R.id.group_video_text_des);
        View viewFindViewById = viewInflate.findViewById(R.id.group_video_text_layout);
        this.d = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        this.g.setOnClickListener(new b());
        this.f.setOnClickListener(new c(chatterActivity, chatItem));
        this.f21935a.addView(viewInflate, new RelativeLayout.LayoutParams(-1, -2));
        this.b = viewInflate;
        if (chatItem != null) {
            z = chatItem.getChatType() == 1;
        }
        this.o = z;
        if (z) {
            UI.c(chatterActivity, 168168, null, this);
        }
    }

    public void g() {
        if (this.o) {
            this.i.getSupportLoaderManager().destroyLoader(168168);
        }
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        VoiceCmd voiceCmd;
        LogUtil.i("GroupVideoChatUIHelper", "onLoadFinished ");
        if (cursor == null) {
            k(true, null, null, null);
            return;
        }
        if (cursor.getCount() <= 0) {
            k(true, null, null, null);
            return;
        }
        if (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("packet_id"));
            String string2 = cursor.getString(cursor.getColumnIndex(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE));
            String string3 = cursor.getString(cursor.getColumnIndex("msg_extend"));
            LogUtil.i("GroupVideoChatUIHelper", "msg:" + string2 + " " + string3);
            VoiceCmdExt fromExt = VoiceCmdExt.parseFromExt(string3);
            if (fromExt == null || (voiceCmd = fromExt.voiceCmd) == null) {
                k(true, string, null, null);
            } else {
                k(true, string, voiceCmd, string2);
            }
        }
    }

    public final void i(boolean z) {
        this.l = z;
        if (!z) {
            this.e.setVisibility(8);
            this.d.setVisibility(0);
        } else {
            this.e.setVisibility(0);
            this.d.setVisibility(8);
            VoiceCmd voiceCmd = this.p;
            wa6.g(voiceCmd.groupId, voiceCmd.roomId, voiceCmd.roomInfo.userList);
        }
    }

    public void j() {
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final void k(boolean z, String str, VoiceCmd voiceCmd, String str2) {
        com.zenmen.palmchat.chat.groupvideochat.vo.RoomInfo roomInfo;
        List<UserInfo> list;
        List<UserInfo> list2;
        ContactInfoItem contactInfoItem;
        if (this.o) {
            if (this.m) {
                voiceCmd = c();
            }
            b(z, str, voiceCmd);
            this.p = voiceCmd;
            if (voiceCmd != null) {
                try {
                    if (voiceCmd.msgType != 1 && voiceCmd.expire != 0 && !wa6.f() && !LxVoipManager.b().g() && ((wa6.e(voiceCmd.roomId) || voiceCmd.type != 0) && (roomInfo = voiceCmd.roomInfo) != null && (list = roomInfo.userList) != null && list.size() != 0)) {
                        this.f21935a.setVisibility(0);
                        this.h.removeAllViews();
                        com.zenmen.palmchat.chat.groupvideochat.vo.RoomInfo roomInfo2 = voiceCmd.roomInfo;
                        if (roomInfo2 != null && roomInfo2.userList.size() > 0) {
                            for (UserInfo userInfo : voiceCmd.roomInfo.userList) {
                                String iconURL = null;
                                ImageView imageView = (ImageView) this.k.inflate(R.layout.group_chat_video_bar_item, (ViewGroup) null);
                                int iB = me1.b(this.i, 34);
                                this.h.addView(imageView, new LinearLayout.LayoutParams(iB, iB));
                                if (this.i.u3() != null && (contactInfoItem = this.i.u3().get(userInfo.uid)) != null) {
                                    iconURL = contactInfoItem.getIconURL();
                                }
                                gr2.j().h(iconURL, imageView, bq6.s());
                            }
                        }
                        com.zenmen.palmchat.chat.groupvideochat.vo.RoomInfo roomInfo3 = voiceCmd.roomInfo;
                        if (roomInfo3 != null && (list2 = roomInfo3.userList) != null) {
                            this.c.setText(this.i.getString(R.string.string_group_video_chat_des, Integer.valueOf(list2.size())));
                        }
                        i(this.l);
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            this.f21935a.setVisibility(8);
            this.l = false;
        }
    }

    public void l() {
        k(false, null, this.p, null);
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this.i, DBUriManager.b(ho3.class, this.j), null, "data1=? and msg_type=?", new String[]{this.j.getChatId(), Integer.toString(49)}, "date DESC limit 1");
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
