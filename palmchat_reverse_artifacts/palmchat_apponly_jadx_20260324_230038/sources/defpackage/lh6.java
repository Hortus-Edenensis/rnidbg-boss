package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.opos.mobad.activity.VideoActivity;
import com.qq.e.comm.constants.ErrorCode;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.AudioMatchCmdVo;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.bridge.voicomatch.SkuItem;
import com.zenmen.palmchat.framework.bridge.voicomatch.SkuItem2;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchChatStateChangeEvent;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchConfig;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchEndCheckVo;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchFeedbackVo;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchInfo;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchInviteVideoEvent;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchRiskEvent;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchSwitchEvent;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchType;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchVideoCancelEvent;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.lxvoip.LxVoipManager;
import com.zenmen.palmchat.modulemanager.lifecircle.AppLifeCircleManager;
import com.zenmen.palmchat.paidservices.voicematch.VoiceMatchActivity;
import com.zenmen.palmchat.paidservices.voicematch.VoiceMatchState;
import com.zenmen.palmchat.paidservices.voicematch.vo.VoiceMatchReportLeaveVo;
import com.zenmen.palmchat.paidservices.voicematch.vo.VoiceMatchResult;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.nb3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class lh6 implements np2 {
    public static lh6 r = new lh6();
    public VoiceMatchConfig d;
    public VoiceMatchConfig e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VoiceMatchState f18982a = VoiceMatchState.IDEL;
    public LinkedHashSet<mh6> b = new LinkedHashSet<>();
    public VoiceMatchInfo c = new VoiceMatchInfo();
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public int l = 0;
    public int m = 0;
    public ArrayList<String> n = new ArrayList<>();
    public nd3 o = new nd3();
    public boolean p = false;
    public boolean q = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<VoiceMatchResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceMatchType f18983a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Runnable d;

        /* JADX INFO: renamed from: lh6$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1242a implements nb3.c {
            public C1242a() {
            }

            @Override // nb3.c
            public void a(int i, String str, Object obj) {
                a aVar;
                VoiceMatchType voiceMatchType;
                if (i != 0 || (voiceMatchType = (aVar = a.this).f18983a) == VoiceMatchType.NORMAL) {
                    return;
                }
                lh6.this.C0(voiceMatchType);
            }
        }

        public a(VoiceMatchType voiceMatchType, boolean z, int i, Runnable runnable) {
            this.f18983a = voiceMatchType;
            this.b = z;
            this.c = i;
            this.d = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(Long.MAX_VALUE);
            if (locationExI != null) {
                map.put("longitude", Double.valueOf(locationExI.getLongitude()));
                map.put("latitude", Double.valueOf(locationExI.getLatitude()));
                map.put("cityCode", locationExI.getCityCode());
            }
            map.put("skuId", Integer.valueOf(this.f18983a.type));
            map.put("joinSource", Integer.valueOf(lh6.this.c.from == 2 ? 1 : 0));
            return sw4.b(1, nl0.z + (lh6.this.c.isVoiceMatch ? "/rtc.audio.matching.join.v2" : "/rtc.vm.join.v1"), map).f(true);
        }

        /* JADX WARN: Removed duplicated region for block: B:62:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0165  */
        @Override // defpackage.io2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResult(boolean z, LXBaseNetBean<VoiceMatchResult> lXBaseNetBean, Exception exc) {
            VoiceMatchInfo voiceMatchInfoConvert2VoiceMatchInfo;
            VoiceMatchResult voiceMatchResult;
            VoiceMatchResult voiceMatchResult2;
            lh6.this.p = false;
            if (this.b != lh6.this.c.isVoiceMatch || lh6.this.t()) {
                LogUtil.i("VoiceMatchManager", "TABNOTMATCH 1!!!");
                return;
            }
            if (!z || lXBaseNetBean == null || !lXBaseNetBean.isSuccess() || (voiceMatchResult2 = lXBaseNetBean.data) == null) {
                voiceMatchInfoConvert2VoiceMatchInfo = VoiceMatchResult.convert2VoiceMatchInfo(lXBaseNetBean != null ? lXBaseNetBean.data : null, lXBaseNetBean != null ? lXBaseNetBean.resultCode : -1);
            } else {
                voiceMatchInfoConvert2VoiceMatchInfo = VoiceMatchResult.convert2VoiceMatchInfo(voiceMatchResult2, 0);
            }
            if (z && lXBaseNetBean != null && (voiceMatchResult = lXBaseNetBean.data) != null) {
                lh6.this.o.d(voiceMatchResult);
            }
            List<SkuItem> list = voiceMatchInfoConvert2VoiceMatchInfo.skus;
            if (list == null || list.size() == 0) {
                voiceMatchInfoConvert2VoiceMatchInfo.skus = lh6.this.c.skus;
            }
            voiceMatchInfoConvert2VoiceMatchInfo.from = lh6.this.c.from;
            voiceMatchInfoConvert2VoiceMatchInfo.subPageFrom = lh6.this.c.subPageFrom;
            voiceMatchInfoConvert2VoiceMatchInfo.isVoiceMatch = lh6.this.c.isVoiceMatch;
            VoiceMatchState voiceMatchStateB0 = lh6.this.b0();
            VoiceMatchState voiceMatchState = VoiceMatchState.MATCHING;
            if (voiceMatchStateB0 == voiceMatchState) {
                voiceMatchInfoConvert2VoiceMatchInfo.startMatchTime = lh6.this.c.startMatchTime;
            }
            if (voiceMatchInfoConvert2VoiceMatchInfo.startMatchTime == 0) {
                voiceMatchInfoConvert2VoiceMatchInfo.startMatchTime = ir5.b();
            }
            lh6.this.c = voiceMatchInfoConvert2VoiceMatchInfo;
            SkuItem skuItem = voiceMatchInfoConvert2VoiceMatchInfo.getSkuItem(VoiceMatchType.FAST);
            VoiceMatchType voiceMatchType = VoiceMatchType.NORMAL;
            SkuItem skuItem2 = voiceMatchInfoConvert2VoiceMatchInfo.getSkuItem(voiceMatchType);
            VoiceMatchType voiceMatchType2 = VoiceMatchType.SAME_CITY;
            SkuItem skuItem3 = voiceMatchInfoConvert2VoiceMatchInfo.getSkuItem(voiceMatchType2);
            lh6.this.c.voiceMatchType = this.f18983a;
            if (lh6.this.c.errorCode == 0) {
                if (this.f18983a != voiceMatchType) {
                    lh6.this.y0(VoiceMatchState.PROPMATCHING);
                } else {
                    lh6.this.y0(voiceMatchState);
                }
            } else if (lh6.this.c.needRecharge()) {
                int i = 150207;
                if (lh6.this.c.isVoiceMatch) {
                    int i2 = this.c;
                    if (i2 == 2) {
                        i = this.f18983a == voiceMatchType2 ? 150105 : 150104;
                    } else if (i2 == 1) {
                        i = 150103;
                    } else if (i2 == 0) {
                        i = this.f18983a == voiceMatchType2 ? 150102 : 150101;
                    } else if (i2 != 3) {
                    }
                } else {
                    int i3 = this.c;
                    if (i3 == 2) {
                        i = this.f18983a == voiceMatchType2 ? 150205 : 150204;
                    } else if (i3 == 1) {
                        i = 150203;
                    } else if (i3 == 0) {
                        i = this.f18983a == voiceMatchType2 ? 150202 : 150201;
                    } else if (i3 != 3) {
                    }
                }
                nb3.k(AppContext.getContext(), of2.e(lh6.this.c.isVoiceMatch ? 1501 : AVMDLDataLoader.KeyIsIsTestSpeedVersion, i, ""), skuItem != null ? skuItem.price : 0, new C1242a());
            } else {
                lh6.this.y0(VoiceMatchState.ERROR);
            }
            HashMap<String, String> mapU = lh6.this.U();
            mapU.put("result", lh6.this.c.errorCode == 0 ? "1" : "0");
            mapU.put("code", String.valueOf(lh6.this.c.errorCode));
            if (lh6.this.c.errorCode == 0) {
                mapU.put("freenum", String.valueOf(skuItem2 != null ? skuItem2.remainingQuantity : 0));
                mapU.put("speedupnum", String.valueOf(skuItem != null ? skuItem.remainingQuantity : 0));
                mapU.put("speedupstatus", (skuItem == null || skuItem.remainingBuyQuantity <= 0) ? "0" : "1");
                mapU.put("localview", skuItem3 == null ? "0" : "1");
                mapU.put("localnum", String.valueOf(skuItem3 != null ? skuItem3.remainingQuantity : 0));
            }
            zn6.i("audioMatch_request_result", mapU);
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioMatchCmdVo f18985a;

        public b(AudioMatchCmdVo audioMatchCmdVo) {
            this.f18985a = audioMatchCmdVo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (lh6.V().e0() || lh6.this.p) {
                Activity currentResumedActivity = AppLifeCircleManager.getInstance().getCurrentResumedActivity();
                lh6.this.c.chattinginfo = this.f18985a.convert2RoomSDKInfo();
                lh6.this.c.skus = this.f18985a.skus;
                lh6.this.c.autoOpenIdMinutes = this.f18985a.autoOpenIDMinutes;
                lh6.this.c.currentLevel = this.f18985a.level;
                if (currentResumedActivity == null || !(currentResumedActivity instanceof VoiceMatchActivity)) {
                    return;
                }
                RoomUserInfo matchUserInfo = lh6.this.c.getMatchUserInfo();
                HashMap<String, String> mapU = lh6.this.U();
                mapU.put("duration", String.valueOf(ir5.e(lh6.this.c.startMatchTime)));
                if (matchUserInfo != null) {
                    mapU.put("fuid", matchUserInfo.uid);
                }
                zn6.i("audioMatch_success", mapU);
                lh6.this.c.isVoiceMatch = this.f18985a.mediaType == 0;
                lh6.this.y0(VoiceMatchState.CHAT);
                LxVoipManager.b().e(this.f18985a.mediaType == 0 ? "audioMatch" : "videoMatch");
                LxVoipManager.b().h(currentResumedActivity, this.f18985a.mediaType == 0, lh6.this.c.chattinginfo);
                currentResumedActivity.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f18986a;
        public final /* synthetic */ iy b;

        public c(ContactInfoItem contactInfoItem, iy iyVar) {
            this.f18986a = contactInfoItem;
            this.b = iyVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContactInfoItem contactInfoItemA = dn0.a(this.f18986a.getUid());
            if (contactInfoItemA == null) {
                this.f18986a.setFriendType(1);
                AppContext.getContext().getContentResolver().insert(ho0.f18003a, nn0.a(this.f18986a));
            }
            if (contactInfoItemA == null || contactInfoItemA.getIsStranger()) {
                this.f18986a.setBizType(lh6.this.c.isVoiceMatch ? 5034 : ErrorCode.DOWNLOADED_NOT_INSTALL_APK_NULL);
            }
            MessageVo messageVoG = u0.g(this.f18986a);
            messageVoG.text = AppContext.getContext().getString(this.b.d == LxVoipManager.CallMediaType.CALL_MEDIA_TYPE_VIDEO ? R.string.message_type_video_call : R.string.message_type_voice_call);
            messageVoG.mimeType = 30;
            messageVoG.status = 2;
            iy iyVar = this.b;
            messageVoG.isSend = iyVar.c;
            messageVoG.isRead = iyVar.f;
            messageVoG.extention = "";
            messageVoG.data1 = iyVar.e;
            messageVoG.data2 = String.valueOf(iyVar.d != LxVoipManager.CallMediaType.CALL_MEDIA_TYPE_AUDIO ? 0 : 1);
            messageVoG.data3 = String.valueOf(this.b.g);
            messageVoG.bizType = this.f18986a.getBizType();
            messageVoG.versionId = com.zenmen.palmchat.database.b.o(this.b.b);
            com.zenmen.palmchat.database.b.t(messageVoG);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends go2<LXBaseNetBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18987a;

        public d(Runnable runnable) {
            this.f18987a = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            RoomUserInfo matchUserInfo = lh6.this.c.getMatchUserInfo();
            if (matchUserInfo != null) {
                map.put("roomId", lh6.this.c.chattinginfo.roomId);
                map.put("fuid", matchUserInfo.uid);
                map.put("openIDType", 3);
            }
            return sw4.b(1, nl0.z + "/rtc.audio.matching.open.id.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
            if (z && lXBaseNetBean.isSuccess()) {
                LogUtil.i("VoiceMatchManager", "checkNeedAutoOpenProfile");
                lh6.this.h = true;
                this.f18987a.run();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18988a;

        public e(Runnable runnable) {
            this.f18988a = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            if (lh6.this.c.chattinginfo != null && lh6.this.c.getMatchUserInfo() != null) {
                map.put("roomId", lh6.this.c.chattinginfo.roomId);
                map.put("fuid", lh6.this.c.getMatchUserInfo().uid);
            }
            map.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, 2);
            return sw4.b(1, nl0.z + "/rtc.vm.action.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            if (z && lXBaseNetBean != null && lXBaseNetBean.isSuccess()) {
                this.f18988a.run();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18989a;

        public f(Runnable runnable) {
            this.f18989a = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            if (lh6.this.c.chattinginfo != null && lh6.this.c.getMatchUserInfo() != null) {
                map.put("roomId", lh6.this.c.chattinginfo.roomId);
                map.put("fuid", lh6.this.c.getMatchUserInfo().uid);
            }
            map.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, 3);
            return sw4.b(1, nl0.z + "/rtc.vm.action.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            if (z && lXBaseNetBean != null && lXBaseNetBean.isSuccess()) {
                lh6.this.k = false;
                this.f18989a.run();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends go2<LXBaseNetBean<String>> {
        public g() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            if (lh6.this.c.chattinginfo != null && lh6.this.c.getMatchUserInfo() != null) {
                map.put("roomId", lh6.this.c.chattinginfo.roomId);
                map.put("fuid", lh6.this.c.getMatchUserInfo().uid);
            }
            map.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, 4);
            return sw4.b(1, nl0.z + "/rtc.vm.action.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            if (!z || lXBaseNetBean == null) {
                return;
            }
            lXBaseNetBean.isSuccess();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends go2<LXBaseNetBean<SkuItem2>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18991a;

        public h(Runnable runnable) {
            this.f18991a = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            if (lh6.this.c.getMatchUserInfo() != null) {
                map.put("fuid", lh6.this.c.getMatchUserInfo().uid);
            }
            return sw4.b(1, nl0.z + "/rtc.vm.invite.btn.show.v1", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<SkuItem2> lXBaseNetBean, Exception exc) {
            SkuItem2 skuItem2;
            if (z && lXBaseNetBean.isSuccess() && (skuItem2 = lXBaseNetBean.data) != null && skuItem2.displayStatus) {
                if (lh6.this.c.skus != null) {
                    lh6.this.c.skus.add(lXBaseNetBean.data.convert2SkuItem());
                }
                lh6.this.c.canInviteVideo = true;
                this.f18991a.run();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends go2<LXBaseNetBean<VoiceMatchEndCheckVo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18992a;
        public final /* synthetic */ long b;
        public final /* synthetic */ io2 c;

        public i(boolean z, long j, io2 io2Var) {
            this.f18992a = z;
            this.b = j;
            this.c = io2Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("exitType", Integer.valueOf(this.f18992a ? 1 : 2));
            map.put("duration", Long.valueOf(this.b));
            RoomUserInfo matchUserInfo = lh6.this.c.getMatchUserInfo();
            if (matchUserInfo != null) {
                map.put("fuid", matchUserInfo.uid);
                map.put("matchType", Integer.valueOf(lh6.this.c.voiceMatchType.type));
                map.put("roomId", lh6.this.c.chattinginfo.roomId);
            }
            return sw4.b(1, nl0.z + "/rtc.am.exit.v2", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<VoiceMatchEndCheckVo> lXBaseNetBean, Exception exc) {
            if (z && lXBaseNetBean.isSuccess()) {
                lh6.this.c.skus = lXBaseNetBean.data.skus;
            }
            this.c.onResult(z, lXBaseNetBean, exc);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends go2<LXBaseNetBean<VoiceMatchFeedbackVo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ io2 f18993a;

        public j(io2 io2Var) {
            this.f18993a = io2Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            RoomUserInfo matchUserInfo = lh6.this.c.getMatchUserInfo();
            if (matchUserInfo != null) {
                map.put("fuid", matchUserInfo.uid);
                map.put("matchType", Integer.valueOf(lh6.this.c.voiceMatchType.type));
                map.put("roomId", lh6.this.c.chattinginfo.roomId);
            }
            return sw4.b(1, nl0.z + "/rtc.am.feedback.text.show.v1", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<VoiceMatchFeedbackVo> lXBaseNetBean, Exception exc) {
            if (z && lXBaseNetBean.isSuccess()) {
                this.f18993a.onResult(z, lXBaseNetBean, exc);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends go2<LXBaseNetBean<VoiceMatchFeedbackVo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f18994a;
        public final /* synthetic */ Runnable b;

        public k(List list, Runnable runnable) {
            this.f18994a = list;
            this.b = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            RoomUserInfo matchUserInfo = lh6.this.c.getMatchUserInfo();
            if (matchUserInfo != null) {
                map.put("fuid", matchUserInfo.uid);
                map.put("matchType", Integer.valueOf(lh6.this.c.voiceMatchType.type));
                map.put("roomId", lh6.this.c.chattinginfo.roomId);
            }
            map.put("types", this.f18994a);
            return sw4.b(1, nl0.z + "/rtc.am.feedback.v1", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<VoiceMatchFeedbackVo> lXBaseNetBean, Exception exc) {
            if (z && lXBaseNetBean.isSuccess()) {
                this.b.run();
            }
            if (lXBaseNetBean == null || TextUtils.isEmpty(lXBaseNetBean.errorMsg)) {
                return;
            }
            ry5.a(lXBaseNetBean.errorMsg);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18995a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements nb3.c {
            public a() {
            }

            @Override // nb3.c
            public void a(int i, String str, Object obj) {
                if (lh6.this.t()) {
                    LxVoipManager.b().l(lh6.this.x());
                }
            }
        }

        public l(Runnable runnable) {
            this.f18995a = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            if (lh6.this.c.chattinginfo != null && lh6.this.c.getMatchUserInfo() != null) {
                map.put("roomId", lh6.this.c.chattinginfo.roomId);
                map.put("fuid", lh6.this.c.getMatchUserInfo().uid);
            }
            map.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, 1);
            return sw4.b(1, nl0.z + "/rtc.vm.action.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            if (!z || lXBaseNetBean == null) {
                return;
            }
            if (lXBaseNetBean.resultCode == 1022) {
                nb3.k(AppContext.getContext(), of2.e(AVMDLDataLoader.KeyIsIsTestSpeedVersion, 150206, ""), lh6.this.c.getSkuItem(VoiceMatchType.INVITE_VIDEO) != null ? r4.price : 0, new a());
            } else if (lXBaseNetBean.isSuccess()) {
                lh6.this.j = true;
                lh6.this.onEvent("audioMatch_videoChat_request");
            }
            this.f18995a.run();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceMatchType f18997a;

        public m(VoiceMatchType voiceMatchType) {
            this.f18997a = voiceMatchType;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (lh6.this.b != null) {
                Iterator it = lh6.this.b.iterator();
                while (it.hasNext()) {
                    ((mh6) it.next()).c(this.f18997a);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n extends go2<LXBaseNetBean<VoiceMatchResult>> {
        public n() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(Long.MAX_VALUE);
            if (locationExI != null) {
                map.put("longitude", Double.valueOf(locationExI.getLongitude()));
                map.put("latitude", Double.valueOf(locationExI.getLatitude()));
                map.put("cityCode", locationExI.getCityCode());
            }
            return sw4.b(1, nl0.z + "/rtc.vm.sku.show.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<VoiceMatchResult> lXBaseNetBean, Exception exc) {
            VoiceMatchInfo voiceMatchInfoConvert2VoiceMatchInfo;
            VoiceMatchResult voiceMatchResult;
            if (lh6.this.c.isVoiceMatch || lh6.this.t()) {
                LogUtil.i("VoiceMatchManager", "TABNOTMATCH 2!!!");
                return;
            }
            if (!z || lXBaseNetBean == null || !lXBaseNetBean.isSuccess() || (voiceMatchResult = lXBaseNetBean.data) == null) {
                voiceMatchInfoConvert2VoiceMatchInfo = VoiceMatchResult.convert2VoiceMatchInfo(lXBaseNetBean != null ? lXBaseNetBean.data : null, lXBaseNetBean != null ? lXBaseNetBean.resultCode : -2);
            } else {
                voiceMatchInfoConvert2VoiceMatchInfo = VoiceMatchResult.convert2VoiceMatchInfo(voiceMatchResult, 0);
            }
            voiceMatchInfoConvert2VoiceMatchInfo.from = lh6.this.c.from;
            voiceMatchInfoConvert2VoiceMatchInfo.subPageFrom = lh6.this.c.subPageFrom;
            voiceMatchInfoConvert2VoiceMatchInfo.isVoiceMatch = lh6.this.c.isVoiceMatch;
            lh6.this.c = voiceMatchInfoConvert2VoiceMatchInfo;
            if (lh6.this.c.errorCode != 0) {
                lh6.this.y0(VoiceMatchState.ERROR);
                return;
            }
            VoiceMatchState voiceMatchStateB0 = lh6.this.b0();
            VoiceMatchState voiceMatchState = VoiceMatchState.IDEL;
            if (voiceMatchStateB0 == voiceMatchState || lh6.this.b0() == VoiceMatchState.ERROR) {
                lh6.this.z0(voiceMatchState, false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o extends go2<LXBaseNetBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18999a;

        public o(Runnable runnable) {
            this.f18999a = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            RoomUserInfo matchUserInfo = lh6.this.c.getMatchUserInfo();
            if (matchUserInfo != null) {
                map.put("roomId", lh6.this.c.chattinginfo.roomId);
                map.put("fuid", matchUserInfo.uid);
                map.put("openIDType", 1);
            }
            return sw4.b(1, nl0.z + "/rtc.audio.matching.open.id.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
            if (z && lXBaseNetBean.isSuccess()) {
                lh6.this.h = true;
                if (lh6.this.g) {
                    lh6.this.n.add(lh6.this.i().openprofile.manullyopen);
                }
                this.f18999a.run();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p extends go2<LXBaseNetBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f19000a;

        public p(Runnable runnable) {
            this.f19000a = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            RoomUserInfo matchUserInfo = lh6.this.c.getMatchUserInfo();
            if (matchUserInfo != null) {
                map.put("roomId", lh6.this.c.chattinginfo.roomId);
                map.put("fuid", matchUserInfo.uid);
                map.put("openIDType", 2);
            }
            return sw4.b(1, nl0.z + "/rtc.audio.matching.open.id.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
            if (z && lXBaseNetBean.isSuccess()) {
                lh6.this.i = true;
                this.f19000a.run();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f19001a;

        public q(Runnable runnable) {
            this.f19001a = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, nl0.z + "/rtc.audio.matching.random.text.v1", new HashMap()).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            if (z && lXBaseNetBean.isSuccess() && !TextUtils.isEmpty(lXBaseNetBean.data)) {
                lh6.this.n.add("[随机话题]" + lXBaseNetBean.data);
                this.f19001a.run();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r extends go2<LXBaseNetBean<VoiceMatchResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f19002a;
        public final /* synthetic */ Runnable b;

        public r(boolean z, Runnable runnable) {
            this.f19002a = z;
            this.b = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            RoomUserInfo matchUserInfo = lh6.this.c.getMatchUserInfo();
            if (matchUserInfo != null) {
                map.put("fuid", matchUserInfo.uid);
                map.put("roomId", lh6.this.c.chattinginfo.roomId);
            }
            map.put("type", Integer.valueOf(this.f19002a ? 2 : 1));
            StringBuilder sb = new StringBuilder();
            sb.append(nl0.z);
            sb.append(lh6.this.c.isVoiceMatch ? "/rtc.audio.matching.comment.v1" : "/rtc.vm.comment.v1");
            return sw4.b(1, sb.toString(), map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<VoiceMatchResult> lXBaseNetBean, Exception exc) {
            if (this.f19002a) {
                sy5.h(AppContext.getContext(), "已收到反馈，继续匹配遇见更多美好吧~", 1);
            } else if (!lh6.this.c.isVoiceMatch) {
                sy5.h(AppContext.getContext(), "已收到反馈，我们会密切关注对方行为", 1);
            }
            this.b.run();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s extends go2<LXBaseNetBean<VoiceMatchReportLeaveVo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f19003a;

        public s(Runnable runnable) {
            this.f19003a = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            RoomUserInfo matchUserInfo = lh6.this.c.getMatchUserInfo();
            if (matchUserInfo != null) {
                map.put("fuid", matchUserInfo.uid);
                map.put("matchType", Integer.valueOf(lh6.this.c.voiceMatchType.type));
                map.put("roomId", lh6.this.c.chattinginfo.roomId);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(nl0.z);
            sb.append(lh6.this.c.isVoiceMatch ? "/rtc.audio.matching.exit.v1" : "/rtc.vm.exit.v1");
            return sw4.b(1, sb.toString(), map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<VoiceMatchReportLeaveVo> lXBaseNetBean, Exception exc) {
            if (z && lXBaseNetBean.isSuccess()) {
                lh6.this.c.skus = lXBaseNetBean.data.skus;
                this.f19003a.run();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioMatchCmdVo f19004a;

        public t(AudioMatchCmdVo audioMatchCmdVo) {
            this.f19004a = audioMatchCmdVo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (lh6.V().e0() || lh6.this.p) {
                lh6.this.c.title = this.f19004a.title;
                lh6.this.c.subTitle = this.f19004a.subTitle;
                lh6.this.y0(VoiceMatchState.MATCHFAIL);
            }
        }
    }

    public static lh6 V() {
        return r;
    }

    public static boolean f0() {
        return t66.h().g("LX-66001");
    }

    public static boolean g0() {
        return t66.h().g("LX-62188");
    }

    @Override // defpackage.np2
    public void A(io2<LXBaseNetBean<VoiceMatchFeedbackVo>> io2Var) {
        zw4.e(new j(io2Var));
    }

    public void A0(int i2) {
        this.c.subPageFrom = i2;
    }

    @Override // defpackage.np2
    public boolean B() {
        return this.k;
    }

    public void B0(boolean z) {
        this.c.isVoiceMatch = z;
    }

    @Override // defpackage.np2
    public void C() {
        RoomUserInfo matchUserInfo = x().getMatchUserInfo();
        if (matchUserInfo != null) {
            int i2 = x().isVoiceMatch ? 5034 : ErrorCode.DOWNLOADED_NOT_INSTALL_APK_NULL;
            ContactInfoItem contactInfoItemL = bo0.r().l(matchUserInfo.uid);
            if (contactInfoItemL != null && !contactInfoItemL.getIsStranger()) {
                i2 = 0;
            }
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) m66.c());
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            contactInfoItem.setUid(matchUserInfo.uid);
            contactInfoItem.setNickName(matchUserInfo.nickName);
            contactInfoItem.setIconURL(matchUserInfo.headImg);
            contactInfoItem.setBizType(i2);
            intent.putExtra("from", 5);
            intent.putExtra("user_item_info", contactInfoItem);
            intent.putExtra("extra_can_chat", true);
            intent.putExtra("thread_biz_type", i2);
            intent.addFlags(335544320);
            AppContext.getContext().startActivity(intent);
        }
    }

    public void C0(VoiceMatchType voiceMatchType) {
        F0(voiceMatchType, 0, null);
    }

    @Override // defpackage.np2
    public void D(Runnable runnable) {
        zw4.e(new e(runnable));
    }

    public void D0(VoiceMatchType voiceMatchType, int i2) {
        F0(voiceMatchType, i2, null);
    }

    @Override // defpackage.np2
    public void E(boolean z, Runnable runnable) {
        zw4.e(new l(runnable));
    }

    public void E0(VoiceMatchType voiceMatchType, int i2, Runnable runnable) {
        F0(voiceMatchType, i2, runnable);
    }

    @Override // defpackage.np2
    public void F() {
        LogUtil.e("VoiceMatchManager", "resetState");
        this.f18982a = VoiceMatchState.IDEL;
        this.h = false;
        this.g = false;
        this.i = false;
        this.f = false;
        VoiceMatchInfo voiceMatchInfo = this.c;
        boolean z = voiceMatchInfo.isVoiceMatch;
        int i2 = voiceMatchInfo.subPageFrom;
        int i3 = voiceMatchInfo.from;
        VoiceMatchInfo voiceMatchInfo2 = new VoiceMatchInfo();
        this.c = voiceMatchInfo2;
        voiceMatchInfo2.isVoiceMatch = z;
        voiceMatchInfo2.subPageFrom = i2;
        voiceMatchInfo2.from = i3;
        this.j = false;
        this.k = false;
        this.l = 0;
        this.m = 0;
        this.n.clear();
    }

    public final void F0(VoiceMatchType voiceMatchType, int i2, Runnable runnable) {
        LogUtil.i("VoiceMatchManager", "startMatchImp " + this.p + "matchType=" + voiceMatchType);
        if (voiceMatchType == VoiceMatchType.SAME_CITY && com.zenmen.palmchat.location.d.g().i(86400000L) == null) {
            LinkedHashSet<mh6> linkedHashSet = this.b;
            if (linkedHashSet != null) {
                Iterator<mh6> it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    it.next().b();
                }
                return;
            }
            return;
        }
        if (this.p) {
            return;
        }
        this.p = true;
        HashMap<String, String> mapU = U();
        mapU.put("type", String.valueOf(voiceMatchType.type));
        zn6.i("audioMatch_request", mapU);
        zw4.e(new a(voiceMatchType, this.c.isVoiceMatch, i2, runnable));
    }

    @Override // defpackage.np2
    public void G(List<Integer> list, Runnable runnable) {
        zw4.e(new k(list, runnable));
    }

    public void G0(int i2) {
        VoiceMatchState voiceMatchStateB0 = b0();
        VoiceMatchState voiceMatchState = VoiceMatchState.IDEL;
        if (voiceMatchStateB0 != voiceMatchState) {
            HashMap<String, String> mapU = U();
            mapU.put("duration", String.valueOf(ir5.e(this.c.startMatchTime)));
            mapU.put("reason", "" + i2);
            zn6.i("audioMatch_stop", mapU);
            y0(voiceMatchState);
            zw4.e(new u());
        }
    }

    public void H0() {
        G0(101);
    }

    public void I0(AudioMatchCmdVo audioMatchCmdVo) {
        SkuItem skuItem = this.c.getSkuItem(VoiceMatchType.SAME_CITY);
        HashMap<String, String> mapU = U();
        mapU.put("duration", String.valueOf(ir5.e(this.c.startMatchTime)));
        mapU.put("localview", skuItem != null ? "1" : "0");
        mapU.put("localnum", String.valueOf(skuItem != null ? skuItem.remainingQuantity : 0));
        zn6.i("audioMatch_fail", mapU);
        u93.c(new t(audioMatchCmdVo));
    }

    public void J0(mh6 mh6Var) {
        this.b.remove(mh6Var);
    }

    public void K0() {
        ds0.a().b(new VoiceMatchVideoCancelEvent());
    }

    public HashMap<String, String> U() {
        HashMap<String, String> map = new HashMap<>();
        map.put(EventParams.KEY_GROUP, t66.h().e("LX-62188", ""));
        map.put("subPage", this.c.isVoiceMatch ? "1" : "2");
        map.put("videoGroup", t66.h().e("LX-66001", ""));
        map.put("subPageFrom", String.valueOf(this.c.subPageFrom));
        map.put("from", String.valueOf(this.c.from));
        if (b0() != VoiceMatchState.IDEL) {
            map.put("matchid", this.c.matchid);
            map.put("type", String.valueOf(this.c.voiceMatchType.type));
            if (this.c.getMatchUserInfo() != null) {
                map.put("fuid", this.c.getMatchUserInfo().uid);
            }
            RoomSDKInfo roomSDKInfo = this.c.chattinginfo;
            if (roomSDKInfo != null) {
                map.put("roomId", roomSDKInfo.roomId);
            }
        }
        return map;
    }

    public ArrayList<String> W() {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strArr = this.c.title;
        if (strArr == null || strArr.length <= 0) {
            arrayList.add("超多声音好听的小姐姐在等你聊天");
        } else {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return arrayList;
    }

    public ArrayList<String> X() {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strArr = this.c.subTitle;
        if (strArr == null || strArr.length <= 0) {
            arrayList.add("语音匹配成功后仅展示基础信息，聊天超安全");
        } else {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return arrayList;
    }

    public String Y() {
        String str = null;
        int length = 0;
        for (String str2 : X()) {
            if (str2.length() > length) {
                length = str2.length();
                str = str2;
            }
        }
        return str;
    }

    public String Z() {
        ArrayList<String> arrayListW = W();
        String str = arrayListW.get(this.l % arrayListW.size());
        this.l++;
        return str;
    }

    @Override // defpackage.np2
    public void a() {
        zw4.e(new g());
    }

    public String a0() {
        ArrayList<String> arrayListX = X();
        String str = arrayListX.get(this.m % arrayListX.size());
        this.m++;
        return str;
    }

    @Override // defpackage.np2
    public void b(String str, HashMap<String, String> map) {
        HashMap<String, String> mapU = U();
        mapU.putAll(map);
        zn6.i(str, mapU);
    }

    public VoiceMatchState b0() {
        return this.f18982a;
    }

    @Override // defpackage.np2
    public void c(Runnable runnable) {
        if (f0()) {
            zw4.e(new h(runnable));
        }
    }

    public VoiceMatchConfig c0(boolean z) {
        if (z) {
            if (this.d == null) {
                DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.AUDIOMATCH);
                if (dynamicConfig != null && dynamicConfig.isEnable()) {
                    this.d = (VoiceMatchConfig) dynamicConfig.parseExtra(VoiceMatchConfig.class);
                }
                if (this.d == null) {
                    this.d = new VoiceMatchConfig();
                }
            }
            return this.d;
        }
        if (this.e == null) {
            DynamicItem dynamicConfig2 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.VIDEOMATCH);
            if (dynamicConfig2 != null && dynamicConfig2.isEnable()) {
                this.e = (VoiceMatchConfig) dynamicConfig2.parseExtra(VoiceMatchConfig.class);
            }
            if (this.e == null) {
                this.e = VoiceMatchConfig.buildVideoConfig();
            }
        }
        return this.e;
    }

    @Override // defpackage.np2
    public boolean d() {
        return this.q;
    }

    public void d0(iy iyVar) {
        RoomUserInfo matchUserInfo = this.c.getMatchUserInfo();
        if (this.g && this.h && matchUserInfo != null) {
            u93.e(new c(matchUserInfo.convert2ContactInfoItem(), iyVar));
        }
    }

    @Override // defpackage.np2
    public boolean e() {
        return this.h;
    }

    public boolean e0() {
        return b0() == VoiceMatchState.MATCHING || b0() == VoiceMatchState.PROPMATCHING;
    }

    @Override // defpackage.np2
    public void f(VoiceMatchEndCheckVo voiceMatchEndCheckVo) {
        this.o.a(voiceMatchEndCheckVo);
    }

    @Override // defpackage.np2
    public void g(Runnable runnable) {
        VoiceMatchInfo voiceMatchInfo = this.c;
        if (voiceMatchInfo.hasTriggerAutoOpenProfile) {
            return;
        }
        voiceMatchInfo.hasTriggerAutoOpenProfile = true;
        if (this.h && this.g) {
            return;
        }
        zw4.e(new d(runnable));
    }

    @Override // defpackage.np2
    public boolean h() {
        return this.i;
    }

    public boolean h0() {
        return this.c.isVoiceMatch;
    }

    @Override // defpackage.np2
    public VoiceMatchConfig i() {
        return c0(this.c.isVoiceMatch);
    }

    public void i0(Activity activity, int i2, Integer num) {
        LogUtil.i("VoiceMatchManager", "jump2Match getState()=" + b0() + "subPage =" + num);
        if (t()) {
            LxVoipManager.b().l(x());
            return;
        }
        if (com.zenmen.palmchat.videocall.c.f() || activity == null) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) VoiceMatchActivity.class);
        intent.putExtra(VoiceMatchActivity.C, i2);
        if (num != null) {
            intent.putExtra(VoiceMatchActivity.E, num.intValue() == 2);
        }
        activity.startActivity(intent);
    }

    @Override // defpackage.np2
    public void j(VoiceMatchInfo voiceMatchInfo) {
        if (voiceMatchInfo != null) {
            VoiceMatchInfo voiceMatchInfo2 = this.c;
            voiceMatchInfo2.isVoiceMatch = false;
            voiceMatchInfo2.chattinginfo = voiceMatchInfo.chattinginfo;
            voiceMatchInfo2.skus = voiceMatchInfo.skus;
            this.h = true;
            this.g = true;
            this.n.clear();
        }
    }

    public void j0(String str, HashMap<String, Object> map) {
        HashMap map2 = new HashMap();
        map2.putAll(U());
        map2.putAll(map);
        zn6.j(str, null, map2);
    }

    @Override // defpackage.np2
    public void k(Runnable runnable) {
        zw4.e(new p(runnable));
    }

    public void k0() {
        this.c.errorCode = VoiceMatchInfo.ERROR_LOCATION_FAIL;
        y0(VoiceMatchState.ERROR);
    }

    @Override // defpackage.np2
    public void l(boolean z) {
        this.q = z;
    }

    public void l0() {
        F();
        LxVoipManager.b().j();
    }

    @Override // defpackage.np2
    public void m(Activity activity, int i2, boolean z) {
        VoiceMatchState voiceMatchStateB0 = b0();
        VoiceMatchState voiceMatchState = VoiceMatchState.IDEL;
        if (voiceMatchStateB0 != voiceMatchState) {
            y0(voiceMatchState);
        }
        Intent intent = new Intent(activity, (Class<?>) VoiceMatchActivity.class);
        intent.putExtra(VoiceMatchActivity.B, VoiceMatchType.NORMAL.type);
        intent.putExtra(VoiceMatchActivity.C, i2);
        intent.putExtra(VoiceMatchActivity.E, z);
        activity.startActivity(intent);
    }

    public void m0(AudioMatchCmdVo audioMatchCmdVo) {
        u93.b(0, new b(audioMatchCmdVo));
    }

    @Override // defpackage.np2
    public void n(boolean z, long j2, io2<LXBaseNetBean<VoiceMatchEndCheckVo>> io2Var) {
        zw4.e(new i(z, j2, io2Var));
    }

    public void n0(VoiceMatchType voiceMatchType) {
        if (this.b != null) {
            u93.c(new m(voiceMatchType));
        }
    }

    @Override // defpackage.np2
    public void o(Runnable runnable) {
        zw4.e(new s(runnable));
    }

    public void o0(boolean z, String str) {
        LogUtil.i("VoiceMatchManager", "onReceivePublish" + z + " body=" + str + " isSelfPublishInfo=" + this.h + " isChattingUserPublishInfo=" + this.g);
        this.g = true;
        if (z) {
            this.h = true;
        }
        if (this.h && !this.f) {
            this.f = true;
            String strReplace = i().openprofile.autoopen_v2.replace("x", String.valueOf(x().getAutoOpenIdMinutes()));
            ArrayList<String> arrayList = this.n;
            if (!z) {
                strReplace = i().openprofile.manullyopen;
            }
            arrayList.add(strReplace);
        }
        ds0.a().b(new VoiceMatchChatStateChangeEvent(true, false));
    }

    @Override // defpackage.np2
    public void onEvent(String str) {
        zn6.i(str, U());
    }

    @Override // defpackage.np2
    public void p(Runnable runnable) {
        zw4.e(new f(runnable));
    }

    public void p0() {
        ds0.a().b(new VoiceMatchChatStateChangeEvent(false, true));
    }

    @Override // defpackage.np2
    public void q(Runnable runnable) {
        zw4.e(new o(runnable));
    }

    public void q0(AudioMatchCmdVo audioMatchCmdVo) {
        VoiceMatchInfo voiceMatchInfo = new VoiceMatchInfo();
        voiceMatchInfo.chattinginfo = audioMatchCmdVo.convert2RoomSDKInfo();
        voiceMatchInfo.skus = audioMatchCmdVo.skus;
        String str = audioMatchCmdVo.inviteUid;
        voiceMatchInfo.isInvitedVideo = (str == null || str.equals(v4.e(com.zenmen.palmchat.c.b()))) ? false : true;
        ds0.a().b(new VoiceMatchSwitchEvent(az2.c(voiceMatchInfo)));
    }

    @Override // defpackage.np2
    public boolean r() {
        return this.j;
    }

    public void r0() {
        this.k = true;
        ds0.a().b(new VoiceMatchInviteVideoEvent(true, false));
    }

    @Override // defpackage.np2
    public void report() {
        RoomUserInfo matchUserInfo = x().getMatchUserInfo();
        Activity currentResumedActivity = AppLifeCircleManager.getInstance().getCurrentResumedActivity();
        if (matchUserInfo == null || currentResumedActivity == null) {
            return;
        }
        int i2 = V().h0() ? 9 : 10;
        HashMap map = new HashMap();
        if (x().chattinginfo != null) {
            map.put("roomId", x().chattinginfo.roomId);
        }
        map.put("roomType", V().h0() ? "1" : "2");
        CordovaWebActivity.w2(com.zenmen.palmchat.c.b(), 11, i2, matchUserInfo.convert2ContactInfoItem(), map, V().h0() ? 11 : 12);
    }

    @Override // defpackage.np2
    public void s() {
        LogUtil.e("VoiceMatchManager", "checkResetStateOnCallEnd  " + V().b0());
        if (b0() == VoiceMatchState.CHAT) {
            F();
        }
    }

    public void s0() {
        this.j = false;
        ds0.a().b(new VoiceMatchInviteVideoEvent(false, true));
    }

    @Override // defpackage.np2
    public boolean t() {
        return b0() == VoiceMatchState.CHAT;
    }

    public void t0(String str) {
        ds0.a().b(new VoiceMatchRiskEvent(str));
    }

    @Override // defpackage.np2
    public void u(Activity activity, int i2, boolean z) {
        VoiceMatchState voiceMatchStateB0 = b0();
        VoiceMatchState voiceMatchState = VoiceMatchState.IDEL;
        if (voiceMatchStateB0 != voiceMatchState) {
            y0(voiceMatchState);
        }
        Intent intent = new Intent(activity, (Class<?>) VoiceMatchActivity.class);
        intent.putExtra(VoiceMatchActivity.B, i2);
        intent.putExtra(VoiceMatchActivity.C, 3);
        intent.putExtra(VoiceMatchActivity.E, z);
        activity.startActivity(intent);
    }

    public final void u0() {
        LinkedHashSet<mh6> linkedHashSet = this.b;
        if (linkedHashSet != null) {
            Iterator<mh6> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                it.next().a(this.f18982a);
            }
        }
    }

    @Override // defpackage.np2
    public List<String> v() {
        if (this.n.size() == 0) {
            if (TextUtils.isEmpty(i().notice)) {
                this.n.add("安全提示：语音聊天过程中请文明发言，平台将严厉打击擦边色情、诋毁诽谤等恶意行为！");
            } else {
                this.n.add(i().notice);
            }
        }
        return this.n;
    }

    public void v0(mh6 mh6Var) {
        this.b.clear();
        this.b.add(mh6Var);
    }

    @Override // defpackage.np2
    public void w(Runnable runnable) {
        zw4.e(new q(runnable));
    }

    public void w0() {
        zw4.e(new n());
    }

    @Override // defpackage.np2
    public VoiceMatchInfo x() {
        return this.c;
    }

    public void x0(int i2) {
        this.c.from = i2;
    }

    @Override // defpackage.np2
    public boolean y() {
        return this.g;
    }

    public final void y0(VoiceMatchState voiceMatchState) {
        z0(voiceMatchState, true);
    }

    @Override // defpackage.np2
    public void z(boolean z, Runnable runnable) {
        VoiceMatchInfo voiceMatchInfo = this.c;
        int i2 = voiceMatchInfo.commentState;
        if (i2 != 0) {
            if (z != (i2 == 1)) {
                sy5.h(AppContext.getContext(), "不可以反悔哦", 1);
                return;
            }
            return;
        }
        voiceMatchInfo.commentState = z ? 1 : 2;
        HashMap<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(z ? 2 : 1);
        map.put("reviewType", sb.toString());
        b("audioMatch_end_review", map);
        zw4.e(new r(z, runnable));
    }

    public final void z0(VoiceMatchState voiceMatchState, boolean z) {
        LogUtil.e("VoiceMatchManager", "setState " + voiceMatchState + " needResetState=" + z + " this=" + this);
        this.f18982a = voiceMatchState;
        if (voiceMatchState == VoiceMatchState.IDEL && z) {
            F();
        }
        u0();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u extends go2<LXBaseNetBean> {
        public u() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(nl0.z);
            sb.append(lh6.this.c.isVoiceMatch ? "/rtc.audio.matching.end.v1" : "/rtc.vm.end.v1");
            return sw4.b(1, sb.toString(), map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
        }
    }
}
