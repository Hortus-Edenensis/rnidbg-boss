package defpackage;

import android.content.ContentValues;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.protobuf.GeneratedMessageLite;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.g;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.media.AudioDownloader;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.smallvideo.VideoSDKPushReceiver;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wt4 implements ib4 {
    public static final String b = "wt4";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MessageProto.Message f21792a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("action", "msg_process_packet");
            put("status", LogUtil.VALUE_INSERTDB);
            put("mid", wt4.this.f21792a.getMid());
            put("type", Integer.valueOf(wt4.this.f21792a.getType()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("action", "msg_process_packet");
            put("status", "fail");
            put("mid", wt4.this.f21792a.getMid());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("action", "msg_process_packet");
            put("status", LogUtil.VALUE_INSERTDB);
            put("mid", wt4.this.f21792a.getMid());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("action", "sync");
            put("status", "start");
            put("reason", "cmd_sync");
            put("mid", wt4.this.f21792a.getMid());
        }
    }

    @Override // defpackage.ib4
    public void a(GeneratedMessageLite generatedMessageLite) {
        if (generatedMessageLite == null) {
            return;
        }
        MessageProto.Message message = (MessageProto.Message) generatedMessageLite;
        this.f21792a = message;
        int type = message.getType();
        LogUtil.d("logmsg", "receivedPacket: " + az2.c(generatedMessageLite));
        if (type == 1 || type == 2 || type == 14 || type == 3 || type == 4 || type == 6 || type == 7 || type == 16 || type == 22 || type == 17 || type == 9 || type == 10001 || type == 44 || type == 28 || type == 10000 || type == 10002 || type == 8 || type == 49 || type == 10005 || type == 52 || type == 53 || ((type == 24 && oc0.d()) || ((type == 56 && oc0.d()) || ds3.c().b(this.f21792a) != null))) {
            f(false);
        } else if (type == 10 || type == 12 || type == 101 || type == 13 || type == 20 || type == 21) {
            d();
        } else if (type == 18) {
            c();
        } else if (type == 19) {
            e();
        } else if (type == 122) {
            VideoSDKPushReceiver.onMsg(this.f21792a);
        } else if (type != 11 && type != 5) {
            if (type == 30) {
                if (this.f21792a.getVersion() == 0 || TextUtils.isEmpty(this.f21792a.getSyncKey())) {
                    ap4.t(this.f21792a, true, false);
                } else {
                    f(false);
                }
            } else if (type == 43) {
                LogUtil.d("tang", this.f21792a.getExtension());
                if (fu5.o(this.f21792a) == 1) {
                    TextUtils.isEmpty(this.f21792a.getExtension());
                }
            } else {
                f(true);
            }
        }
        xa3.e("receive", this.f21792a);
    }

    public final void c() {
        int iO = fu5.o(this.f21792a);
        LogUtil.d("TripNearByTag", "ReceivedMessageProcessor processCMDMessage subType " + iO);
        if (iO == 0) {
            LogUtil.i(b, 3, new d(), (Throwable) null);
            iq5.d().g(false, new String[0]);
        } else if (iO == 1) {
            AppContext.getContext().sendLocalBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_KICKOUT));
        } else if (iO == 2) {
            sk5.d(true);
        }
    }

    public final void d() {
        LogUtil.i(b, "processContactRequestMessagePacket");
        MessageProto.Message message = this.f21792a;
        if (mb4.e(message, message.getMid(), "receive_sync")) {
            return;
        }
        try {
            if (jo6.a("LX-8223", false) && this.f21792a.getType() == 20 && fu5.o(this.f21792a) == 25) {
                List<ContentValues> listB = rn0.b(this.f21792a, false);
                int size = listB.size();
                ContentValues[] contentValuesArr = new ContentValues[size];
                for (int i = 0; i < listB.size(); i++) {
                    contentValuesArr[i] = listB.get(i);
                }
                if (size > 0) {
                    dv.a("insertRecommendCommonFrds", vn0.f21483a, contentValuesArr, true);
                    ap4.f(new Pair(contentValuesArr[size - 1], null), false);
                }
            } else {
                ContentValues contentValuesA = rn0.a(this.f21792a, false);
                rn0.i(contentValuesA);
                ap4.f(new Pair(contentValuesA, this.f21792a.getExtension()), false);
            }
            LogUtil.i(b, 3, new c(), (Throwable) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void e() {
        Intent intent = new Intent();
        intent.setAction(mo3.g);
        intent.putExtra("from", this.f21792a.getFrom());
        intent.putExtra(SharePluginInfo.ISSUE_SUB_TYPE, fu5.o(this.f21792a));
        LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
    }

    public final void f(boolean z) {
        LogUtil.i("lognotify", "processMessagePacket: mPacket = " + this.f21792a);
        MessageProto.Message message = this.f21792a;
        if (mb4.e(message, message.getMid(), "receive_sync")) {
            return;
        }
        try {
            com.zenmen.palmchat.database.b.x(this.f21792a);
            String str = b;
            LogUtil.i(str, 3, new a(), (Throwable) null);
            d20.l(this.f21792a);
            String mid = this.f21792a.getMid();
            if (!TextUtils.isEmpty(mid) && mid.contains("square") && this.f21792a.getType() == 1) {
                ds0.a().b(new oj5());
            }
            if (this.f21792a.getType() == 3) {
                AudioDownloader.getInstance().downloadAudioFileByMessageId(MessageVo.buildFromMessageProtoForTmpUse(this.f21792a), false);
            }
            if (VideoSDKPushReceiver.onMsg(this.f21792a) || ds3.c().d(this.f21792a)) {
                return;
            }
            if (this.f21792a.getType() == 30) {
                ap4.t(this.f21792a, true, false);
                return;
            }
            if (this.f21792a.getType() == 49) {
                Intent intent = new Intent();
                intent.setAction(mo3.e);
                LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
                return;
            }
            if (this.f21792a.getType() == 102) {
                sq3.o().E(AppContext.getContext(), this.f21792a);
                z = false;
            }
            if (this.f21792a.getType() == 50) {
                return;
            }
            if (this.f21792a.getType() == 42) {
                if (!f46.f(this.f21792a) && !f46.g(this.f21792a)) {
                    if (f46.e(this.f21792a)) {
                        Intent intent2 = new Intent();
                        intent2.setAction(mo3.n);
                        LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent2);
                        return;
                    }
                    return;
                }
                LogUtil.i("UnReadStatusSyncManager", "processClearMomentCmd socket ");
                f46.h(this.f21792a);
                return;
            }
            if (this.f21792a.getType() == 8) {
                LogUtil.i(str, "DialogMessage mPacket = " + this.f21792a);
                LogUtil.d("logmatch", "receivedMessage:" + this.f21792a);
                ad1.h().k(this.f21792a);
                return;
            }
            if (this.f21792a.getType() == 44) {
                LogUtil.i(str, "MESSAGE_TYPE_UPDATE_VIDEO_COVER mPacket = " + this.f21792a);
                return;
            }
            if (this.f21792a.getType() != 45 && this.f21792a.getType() != 46 && (this.f21792a.getType() != 47 || (fu5.o(this.f21792a) != 11 && fu5.o(this.f21792a) != 12 && fu5.o(this.f21792a) != 13 && fu5.o(this.f21792a) != 41 && fu5.o(this.f21792a) != 32))) {
                if (this.f21792a.getType() == 47 && fu5.o(this.f21792a) == 21) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f21792a);
                    ag2.c().d(arrayList);
                    return;
                }
                if (this.f21792a.getType() == 47 && fu5.o(this.f21792a) == 23) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(this.f21792a);
                    vx3.c().d(arrayList2);
                    return;
                }
                if (this.f21792a.getType() == 47) {
                    LogUtil.i(str, "ContactPush mPacket = " + this.f21792a);
                    qn0.a().e(this.f21792a);
                    return;
                }
                if (this.f21792a.getType() == 54) {
                    LogUtil.i(str, "float view mPacket = " + this.f21792a);
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(this.f21792a);
                    tx1.b().c(arrayList3);
                    return;
                }
                if (!z && !mb4.j(this.f21792a.getExtension()) && !DomainHelper.r(this.f21792a.getFrom())) {
                    LogUtil.i("lognotify", "sendBroadcast: mPacket = " + this.f21792a);
                    Intent intent3 = new Intent();
                    intent3.setAction(mo3.d);
                    intent3.putExtra("key_packet_extension", this.f21792a.getExtension());
                    intent3.putExtra("key_mid", this.f21792a.getMid());
                    intent3.putExtra("key_mimetype", this.f21792a.getType());
                    intent3.putExtra("key_subtype", fu5.o(this.f21792a));
                    intent3.putExtra("key_from", this.f21792a.getFrom());
                    intent3.putExtra("key_body", this.f21792a.getBody());
                    if (this.f21792a.getType() == 10001) {
                        String strA = wn3.a(this.f21792a);
                        if (!TextUtils.isEmpty(strA)) {
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(strA);
                            intent3.putExtra("key_message_recall_list", arrayList4);
                        }
                    }
                    LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent3);
                    g.u(this.f21792a.getFrom(), this.f21792a.getMid(), this.f21792a.getType(), this.f21792a.getExtension());
                    a65.g(this.f21792a, "socket");
                    return;
                }
                return;
            }
            ArrayList arrayList5 = new ArrayList();
            arrayList5.add(this.f21792a);
            cp4.a().b(arrayList5);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i(b, 3, new b(), e);
        }
    }
}
