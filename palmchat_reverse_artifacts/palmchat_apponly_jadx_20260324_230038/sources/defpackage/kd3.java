package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.flexbox.FlexboxLayout;
import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.volcengine.lxvertc.videocall.call.view.CallActivity;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.bridge.voicomatch.ContinueMatchEvent;
import com.zenmen.palmchat.framework.bridge.voicomatch.SkuItem;
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
import com.zenmen.palmchat.lxvoip.vertc.R$color;
import com.zenmen.palmchat.lxvoip.vertc.R$drawable;
import com.zenmen.palmchat.lxvoip.vertc.R$id;
import com.zenmen.palmchat.lxvoip.vertc.R$layout;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import defpackage.jy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class kd3 {
    public Activity i;
    public np2 j;
    public n0 k;
    public a0 l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18630a = false;
    public boolean b = false;
    public MaterialDialog c = null;
    public MaterialDialog d = null;
    public MaterialDialog e = null;
    public MaterialDialog f = null;
    public MaterialDialog g = null;
    public MaterialDialog h = null;
    public boolean m = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f18631a;

        public a(MaterialDialog materialDialog) {
            this.f18631a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18631a.cancel();
            kd3.this.l.d();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a0 {
        void a();

        void b();

        void c(String str);

        void d();

        void e();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f18632a;

        public b(MaterialDialog materialDialog) {
            this.f18632a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18632a.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f18633a;

        public c(MaterialDialog materialDialog) {
            this.f18633a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18633a.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f18634a;

        public d(MaterialDialog materialDialog) {
            this.f18634a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18634a.cancel();
            kd3.this.k.D();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            kd3.this.l.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (kd3.this.j.x().isVoiceMatch && kd3.this.j.x().canInviteVideo) {
                kd3.this.C();
            }
            kd3.this.l.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceMatchRiskEvent f18637a;

        public g(VoiceMatchRiskEvent voiceMatchRiskEvent) {
            this.f18637a = voiceMatchRiskEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            kd3.this.l.c(this.f18637a.riskInfo);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContinueMatchEvent f18638a;

        public h(ContinueMatchEvent continueMatchEvent) {
            this.f18638a = continueMatchEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            np2 np2Var = kd3.this.j;
            Activity activity = kd3.this.i;
            ContinueMatchEvent continueMatchEvent = this.f18638a;
            np2Var.m(activity, continueMatchEvent.from, continueMatchEvent.type != 1);
            kd3.this.i.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements io2<LXBaseNetBean<VoiceMatchEndCheckVo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18639a;

        public i(boolean z) {
            this.f18639a = z;
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<VoiceMatchEndCheckVo> lXBaseNetBean, Exception exc) {
            VoiceMatchEndCheckVo voiceMatchEndCheckVo;
            if (kd3.this.i == null || kd3.this.i.isFinishing()) {
                return;
            }
            kd3.this.l.e();
            if (z && lXBaseNetBean.isSuccess() && lXBaseNetBean.data != null) {
                boolean z2 = z && lXBaseNetBean.isSuccess() && (voiceMatchEndCheckVo = lXBaseNetBean.data) != null && voiceMatchEndCheckVo.slient;
                if (this.f18639a) {
                    kd3.this.y(true, lXBaseNetBean.data.getTitleForShow(), lXBaseNetBean.data.getSubTitleForShow());
                    return;
                }
                if (z2) {
                    kd3.this.y(false, lXBaseNetBean.data.getTitleForShow(), lXBaseNetBean.data.getSubTitleForShow());
                    return;
                }
                kd3 kd3Var = kd3.this;
                if (kd3Var.b) {
                    return;
                }
                kd3Var.j.f(lXBaseNetBean.data);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            kd3.this.l.e();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f18642a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                kd3.this.l.b();
            }
        }

        public l(MaterialDialog materialDialog) {
            this.f18642a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap<String, String> map = new HashMap<>();
            map.put("reportType", "click");
            map.put("inviteType", "2");
            map.put("clickType", "1");
            kd3.this.j.b("audioMatch_oncall_videoChatPopup", map);
            this.f18642a.cancel();
            Application applicationB = com.zenmen.palmchat.c.b();
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL;
            if (tg4.b(applicationB, permissionType.permissionList)) {
                kd3.this.j.E(true, new a());
            } else {
                BaseActivityPermissionDispatcher.b((FrameworkBaseActivity) kd3.this.i, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.AUDIO_MATCH_VIDEO);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceMatchSwitchEvent f18644a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements jy {
            public a() {
            }

            @Override // defpackage.jy
            public void a(jy.a aVar) {
                m mVar = m.this;
                kd3.this.E(mVar.f18644a);
            }
        }

        public m(VoiceMatchSwitchEvent voiceMatchSwitchEvent) {
            this.f18644a = voiceMatchSwitchEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i("MatchCommonUiHelper", "receiveSwitchEvent" + com.volcengine.lxvertc.videocall.call.a.t().r());
            if (com.volcengine.lxvertc.videocall.call.a.t().r() == VoipState.ONTHECALL) {
                com.volcengine.lxvertc.videocall.call.a.t().B(new a(), false);
            } else {
                kd3.this.E(this.f18644a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceMatchInviteVideoEvent f18646a;

        public n(VoiceMatchInviteVideoEvent voiceMatchInviteVideoEvent) {
            this.f18646a = voiceMatchInviteVideoEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            VoiceMatchInviteVideoEvent voiceMatchInviteVideoEvent = this.f18646a;
            if (voiceMatchInviteVideoEvent.invite) {
                kd3.this.l.b();
                kd3.this.v();
            } else if (voiceMatchInviteVideoEvent.deny) {
                ry5.a(" 对方已拒绝，语音再聊会，晚点再试试吧～");
                kd3.this.l.b();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            kd3.this.l.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceMatchChatStateChangeEvent f18648a;

        public p(VoiceMatchChatStateChangeEvent voiceMatchChatStateChangeEvent) {
            this.f18648a = voiceMatchChatStateChangeEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            VoiceMatchChatStateChangeEvent voiceMatchChatStateChangeEvent = this.f18648a;
            if (!voiceMatchChatStateChangeEvent.isUserPublishInfo) {
                if (voiceMatchChatStateChangeEvent.isUserInvitePublishInfo) {
                    kd3.this.A();
                }
            } else {
                kd3.this.l.b();
                if (kd3.this.j.y() && kd3.this.j.e()) {
                    return;
                }
                kd3.this.D();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q extends LXBottomSheetDialog {
        public final /* synthetic */ boolean h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap<String, String> map = new HashMap<>();
                map.put("reason", q.this.h ? "1" : "2");
                map.put("report_type", "click");
                map.put("clickType", "0");
                kd3.this.j.b("audioMatch_end_popup", map);
                q.this.dismiss();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap<String, String> map = new HashMap<>();
                map.put("reason", q.this.h ? "1" : "2");
                map.put("report_type", "click");
                map.put("clickType", "1");
                kd3.this.j.b("audioMatch_end_popup", map);
                kd3.this.t(VoiceMatchType.NORMAL);
                q.this.dismiss();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ VoiceMatchType f18651a;

            public c(VoiceMatchType voiceMatchType) {
                this.f18651a = voiceMatchType;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap<String, String> map = new HashMap<>();
                map.put("reason", q.this.h ? "1" : "2");
                map.put("report_type", "click");
                map.put("clickType", this.f18651a == VoiceMatchType.SAME_CITY ? "3" : "2");
                kd3.this.j.b("audioMatch_end_popup", map);
                kd3.this.t(this.f18651a);
                q.this.dismiss();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(Context context, boolean z, String str, String str2) {
            super(context);
            this.h = z;
            this.i = str;
            this.j = str2;
        }

        @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
        public View n() {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R$layout.layout_dialog_match_call_end_exit, (ViewGroup) null);
            viewGroup.findViewById(R$id.close).setOnClickListener(new a());
            TextView textView = (TextView) viewGroup.findViewById(R$id.title);
            TextView textView2 = (TextView) viewGroup.findViewById(R$id.sub_title);
            textView.setText(this.i);
            textView2.setText(this.j);
            VoiceMatchInfo voiceMatchInfoX = kd3.this.j.x();
            VoiceMatchType voiceMatchTypeBuildFromType = VoiceMatchType.buildFromType(voiceMatchInfoX.voiceMatchType.type);
            VoiceMatchType voiceMatchType = VoiceMatchType.FAST;
            VoiceMatchType voiceMatchType2 = VoiceMatchType.SAME_CITY;
            if (voiceMatchTypeBuildFromType == voiceMatchType2) {
                voiceMatchType = voiceMatchType2;
            }
            kd3.this.F(voiceMatchInfoX, VoiceMatchType.NORMAL, (TextView) viewGroup.findViewById(R$id.text1), (TextView) viewGroup.findViewById(R$id.subtext1));
            kd3.this.F(voiceMatchInfoX, voiceMatchType, (TextView) viewGroup.findViewById(R$id.text2), (TextView) viewGroup.findViewById(R$id.subtext2));
            viewGroup.findViewById(R$id.btnLayout1).setOnClickListener(new b());
            viewGroup.findViewById(R$id.btnLayout2).setOnClickListener(new c(voiceMatchType));
            return viewGroup;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r extends LXBottomSheetDialog {
        public final /* synthetic */ boolean h;
        public final /* synthetic */ List i;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r.this.dismiss();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlexboxLayout f18654a;

            /* JADX INFO: compiled from: SearchBox */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    r.this.dismiss();
                }
            }

            public c(FlexboxLayout flexboxLayout) {
                this.f18654a = flexboxLayout;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.f18654a.getChildCount(); i++) {
                    TextView textView = (TextView) this.f18654a.getChildAt(i);
                    if (textView.isSelected()) {
                        arrayList.add((Integer) textView.getTag());
                    }
                }
                if (arrayList.size() == 0) {
                    ry5.a("选中后再提交哦~");
                    return;
                }
                HashMap<String, String> map = new HashMap<>();
                map.put("report_type", "click");
                map.put("id", az2.c(arrayList));
                kd3.this.j.b("audioMatch_end_quickReport", map);
                kd3.this.j.G(arrayList, new a());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(Context context, boolean z, List list) {
            super(context);
            this.h = z;
            this.i = list;
        }

        @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
        public View n() {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R$layout.layout_dialog_match_call_end_comment, (ViewGroup) null);
            viewGroup.findViewById(R$id.close).setOnClickListener(new a());
            TextView textView = (TextView) viewGroup.findViewById(R$id.title);
            TextView textView2 = (TextView) viewGroup.findViewById(R$id.sub_title);
            if (this.h) {
                textView.setText("和你语音聊天的TA");
                textView2.setText("反馈后，下次匹配将为你减少此类用户推荐");
            } else {
                textView.setText("你主动结束对话的理由");
                textView2.setText("反馈后，下次匹配将为你减少此类用户推荐");
            }
            FlexboxLayout flexboxLayout = (FlexboxLayout) viewGroup.findViewById(R$id.commentLayout);
            int iB = me1.b(kd3.this.i, 8);
            int iB2 = me1.b(kd3.this.i, 6);
            int iB3 = me1.b(kd3.this.i, 28);
            for (VoiceMatchFeedbackVo.FeedbackItem feedbackItem : this.i) {
                TextView textView3 = new TextView(kd3.this.i);
                textView3.setText(feedbackItem.name);
                textView3.setTag(Integer.valueOf(feedbackItem.id));
                textView3.setTextColor(kd3.this.i.getResources().getColorStateList(R$color.voice_match_end_comment_item));
                textView3.setBackgroundResource(R$drawable.selector_voice_match_call_end_comment_item_bg);
                textView3.setTextSize(1, 14.0f);
                textView3.setSingleLine(true);
                textView3.setPadding(iB, 0, iB, 0);
                textView3.setGravity(17);
                textView3.setOnClickListener(new b());
                FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, iB3);
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = iB2;
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = iB2;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = iB2;
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = iB2;
                flexboxLayout.addView(textView3, layoutParams);
            }
            viewGroup.findViewById(R$id.btn).setOnClickListener(new c(flexboxLayout));
            return viewGroup;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements io2<LXBaseNetBean<VoiceMatchFeedbackVo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18656a;

        public s(boolean z) {
            this.f18656a = z;
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<VoiceMatchFeedbackVo> lXBaseNetBean, Exception exc) {
            VoiceMatchFeedbackVo voiceMatchFeedbackVo;
            if (kd3.this.i.isFinishing() || !z || lXBaseNetBean == null || !lXBaseNetBean.isSuccess() || (voiceMatchFeedbackVo = lXBaseNetBean.data) == null || voiceMatchFeedbackVo.feedbackTexts == null) {
                return;
            }
            kd3.this.x(this.f18656a, voiceMatchFeedbackVo.feedbackTexts);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f18657a;

        public t(MaterialDialog materialDialog) {
            this.f18657a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18657a.cancel();
            HashMap<String, String> map = new HashMap<>();
            map.put("reportType", "click");
            map.put("inviteType", "2");
            map.put("clickType", "2");
            kd3.this.j.b("audioMatch_oncall_videoChatPopup", map);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f18658a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                kd3.this.l.b();
            }
        }

        public u(MaterialDialog materialDialog) {
            this.f18658a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap<String, String> map = new HashMap<>();
            map.put("reportType", "view");
            map.put("inviteType", "1");
            map.put("clickType", "1");
            kd3.this.j.b("audioMatch_oncall_videoChatPopup", map);
            this.f18658a.cancel();
            kd3.this.j.E(false, new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f18660a;

        public v(MaterialDialog materialDialog) {
            this.f18660a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18660a.cancel();
            HashMap<String, String> map = new HashMap<>();
            map.put("reportType", "view");
            map.put("inviteType", "1");
            map.put("clickType", "2");
            kd3.this.j.b("audioMatch_oncall_videoChatPopup", map);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f18661a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                kd3.this.l.b();
            }
        }

        public w(MaterialDialog materialDialog) {
            this.f18661a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap<String, String> map = new HashMap<>();
            map.put("reportType", "click");
            map.put("clickType", "1");
            map.put("answerType", kd3.this.j.e() ? "1" : "2");
            kd3.this.j.b("audioMatch_videoChat_get", map);
            this.f18661a.cancel();
            Application applicationB = com.zenmen.palmchat.c.b();
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL;
            if (tg4.b(applicationB, permissionType.permissionList)) {
                kd3.this.j.D(new a());
            } else {
                BaseActivityPermissionDispatcher.b((FrameworkBaseActivity) kd3.this.i, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.AUDIO_MATCH_VIDEO);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f18663a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                kd3.this.l.b();
            }
        }

        public x(MaterialDialog materialDialog) {
            this.f18663a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            kd3.this.j.p(new a());
            this.f18663a.cancel();
            HashMap<String, String> map = new HashMap<>();
            map.put("reportType", "click");
            map.put("clickType", "2");
            map.put("answerType", kd3.this.j.e() ? "1" : "2");
            kd3.this.j.b("audioMatch_videoChat_get", map);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f18665a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                kd3.this.l.b();
            }
        }

        public y(MaterialDialog materialDialog) {
            this.f18665a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18665a.cancel();
            HashMap<String, String> map = new HashMap<>();
            map.put("reason", "2");
            kd3.this.j.b("audioMatch_oncall_public", map);
            kd3.this.j.q(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f18667a;

        public z(MaterialDialog materialDialog) {
            this.f18667a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18667a.cancel();
        }
    }

    public kd3(Activity activity, np2 np2Var, n0 n0Var, a0 a0Var) {
        this.i = activity;
        this.j = np2Var;
        this.k = n0Var;
        this.l = a0Var;
    }

    public final void A() {
        MaterialDialog materialDialogE = new sd3(this.i).h(true).c(0).v(true).o(R$layout.layout_dialog_voice_match_cancel, false).e();
        View viewJ = materialDialogE.j();
        if (viewJ != null) {
            ((TextView) viewJ.findViewById(R$id.content)).setText("ta觉得聊的挺投缘，邀请你公开身份，看看你的资料");
            TextView textView = (TextView) viewJ.findViewById(R$id.confirm);
            textView.setText("公开身份");
            textView.setOnClickListener(new y(materialDialogE));
            TextView textView2 = (TextView) viewJ.findViewById(R$id.cancel);
            textView2.setText("再想想");
            textView2.setOnClickListener(new z(materialDialogE));
        }
        materialDialogE.c(false);
        materialDialogE.show();
        this.f = materialDialogE;
    }

    public final void B() {
        HashMap<String, String> map = new HashMap<>();
        map.put("reportType", "view");
        map.put("inviteType", "1");
        this.j.b("audioMatch_oncall_videoChatPopup", map);
        MaterialDialog materialDialogE = new sd3(this.i).h(true).c(0).v(true).o(R$layout.layout_dialog_voice_match_cancel, false).e();
        View viewJ = materialDialogE.j();
        if (viewJ != null) {
            String str = this.j.i().getVideoChatConfig().inviteConfirm;
            SkuItem skuItem = this.j.x().getSkuItem(VoiceMatchType.INVITE_VIDEO);
            if (skuItem != null) {
                if (skuItem.remainingQuantity > 0) {
                    str = str + "（剩余" + skuItem.remainingQuantity + "张）";
                } else {
                    str = str + "（" + skuItem.price + "连信豆）";
                }
            }
            ((TextView) viewJ.findViewById(R$id.content)).setText(str);
            TextView textView = (TextView) viewJ.findViewById(R$id.confirm);
            textView.setText("确认");
            textView.setOnClickListener(new u(materialDialogE));
            TextView textView2 = (TextView) viewJ.findViewById(R$id.cancel);
            textView2.setText("再想想");
            textView2.setOnClickListener(new v(materialDialogE));
        }
        materialDialogE.c(false);
        materialDialogE.show();
        this.c = materialDialogE;
    }

    public final void C() {
        HashMap<String, String> map = new HashMap<>();
        map.put("reportType", "view");
        map.put("inviteType", "2");
        this.j.b("audioMatch_oncall_videoChatPopup", map);
        MaterialDialog materialDialogE = new sd3(this.i).h(true).c(0).v(true).o(R$layout.layout_dialog_voice_match_invite_confirm, false).e();
        View viewJ = materialDialogE.j();
        if (viewJ != null) {
            ((TextView) viewJ.findViewById(R$id.content)).setText(this.j.i().getVideoChatConfig().openInvite);
            TextView textView = (TextView) viewJ.findViewById(R$id.price);
            View viewFindViewById = viewJ.findViewById(R$id.price_iv);
            SkuItem skuItem = this.j.x().getSkuItem(VoiceMatchType.INVITE_VIDEO);
            if (skuItem != null) {
                if (skuItem.remainingQuantity > 0) {
                    viewFindViewById.setVisibility(8);
                    textView.setText("（剩余" + skuItem.remainingQuantity + "张）");
                } else {
                    viewFindViewById.setVisibility(0);
                    textView.setText("" + skuItem.price);
                }
            }
            viewJ.findViewById(R$id.confirmLayout).setOnClickListener(new l(materialDialogE));
            viewJ.findViewById(R$id.close).setOnClickListener(new t(materialDialogE));
        }
        materialDialogE.c(false);
        materialDialogE.show();
        this.d = materialDialogE;
    }

    public final void D() {
        if (this.m) {
            return;
        }
        this.m = true;
        MaterialDialog materialDialogE = new sd3(this.i).h(true).v(true).c(0).o(R$layout.layout_dialog_voice_match_cancel, false).e();
        View viewJ = materialDialogE.j();
        if (viewJ != null) {
            ((TextView) viewJ.findViewById(R$id.content)).setText("对方公开了身份，点击头像可查看ta的资料");
            TextView textView = (TextView) viewJ.findViewById(R$id.confirm);
            textView.setText("看ta资料");
            textView.setOnClickListener(new a(materialDialogE));
            TextView textView2 = (TextView) viewJ.findViewById(R$id.cancel);
            textView2.setText("暂不查看");
            textView2.setOnClickListener(new b(materialDialogE));
        }
        materialDialogE.c(false);
        materialDialogE.show();
        this.g = materialDialogE;
    }

    public final void E(VoiceMatchSwitchEvent voiceMatchSwitchEvent) {
        LogUtil.i("MatchCommonUiHelper", "switchImp start" + voiceMatchSwitchEvent.info);
        this.f18630a = true;
        this.i.finish();
        VoiceMatchInfo voiceMatchInfo = (VoiceMatchInfo) az2.a(voiceMatchSwitchEvent.info, VoiceMatchInfo.class);
        if (voiceMatchInfo != null) {
            RoomSDKInfo roomSDKInfo = voiceMatchInfo.chattinginfo;
            Activity activity = this.i;
            CallType callType = CallType.VIDEO;
            String strA = eg5.c().a();
            String str = roomSDKInfo.groupId;
            ArrayList<RoomUserInfo> arrayList = roomSDKInfo.userList;
            CallActivity.T1(activity, callType, strA, str, arrayList, arrayList.get(0).nickName, voiceMatchSwitchEvent.info);
        }
    }

    public final void F(VoiceMatchInfo voiceMatchInfo, VoiceMatchType voiceMatchType, TextView textView, TextView textView2) {
        String str;
        SkuItem skuItem = voiceMatchInfo.getSkuItem(voiceMatchType);
        if (skuItem != null) {
            textView.setText(skuItem.name);
            if (voiceMatchType == VoiceMatchType.NORMAL) {
                str = "今日剩余" + skuItem.remainingQuantity + "次";
            } else if (skuItem.remainingQuantity > 0) {
                str = "剩余" + skuItem.remainingQuantity + "次";
            } else {
                str = skuItem.price + "连信豆/次";
            }
            textView2.setText(str);
        }
    }

    public void m() {
        MaterialDialog materialDialog = this.f;
        if (materialDialog != null && materialDialog.isShowing()) {
            this.f.dismiss();
        }
        MaterialDialog materialDialog2 = this.g;
        if (materialDialog2 != null && materialDialog2.isShowing()) {
            this.g.dismiss();
        }
        MaterialDialog materialDialog3 = this.h;
        if (materialDialog3 != null && materialDialog3.isShowing()) {
            this.h.dismiss();
        }
        MaterialDialog materialDialog4 = this.c;
        if (materialDialog4 != null && materialDialog4.isShowing()) {
            this.c.dismiss();
        }
        MaterialDialog materialDialog5 = this.d;
        if (materialDialog5 != null && materialDialog5.isShowing()) {
            this.d.dismiss();
        }
        MaterialDialog materialDialog6 = this.e;
        if (materialDialog6 == null || !materialDialog6.isShowing()) {
            return;
        }
        this.e.dismiss();
    }

    public void n(boolean z2, boolean z3, long j2) {
        if (this.j.x().isVoiceMatch) {
            this.j.n(z3, j2, new i(z3));
        } else if (z3) {
            this.j.o(new j());
        }
    }

    public void o() {
        ds0.a().c(this);
    }

    public void p() {
        try {
            ds0.a().d(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void q() {
        if (this.j.y() && this.j.e()) {
            this.k.D();
        } else {
            z();
        }
    }

    public void r() {
        e eVar = new e();
        if (this.j.e()) {
            if (this.j.h()) {
                return;
            }
            this.j.onEvent("audioMatch_oncall_invite");
            this.j.k(eVar);
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("reason", "1");
        this.j.b("audioMatch_oncall_public", map);
        this.j.q(new f());
    }

    @qm5
    public void receiveContinueMatchEvent(ContinueMatchEvent continueMatchEvent) {
        this.i.runOnUiThread(new h(continueMatchEvent));
    }

    @qm5
    public void receiveRiskEvent(VoiceMatchRiskEvent voiceMatchRiskEvent) {
        this.i.runOnUiThread(new g(voiceMatchRiskEvent));
    }

    @qm5
    public void receiveStateChangeEvent(VoiceMatchChatStateChangeEvent voiceMatchChatStateChangeEvent) {
        this.i.runOnUiThread(new p(voiceMatchChatStateChangeEvent));
    }

    @qm5
    public void receiveSwitchEvent(VoiceMatchSwitchEvent voiceMatchSwitchEvent) {
        this.b = true;
        this.i.runOnUiThread(new m(voiceMatchSwitchEvent));
    }

    @qm5
    public void receiveVoiceMatchInviteVideoEvent(VoiceMatchInviteVideoEvent voiceMatchInviteVideoEvent) {
        this.i.runOnUiThread(new n(voiceMatchInviteVideoEvent));
    }

    @qm5
    public void receiveVoiceMatchVideoCancelEvent(VoiceMatchVideoCancelEvent voiceMatchVideoCancelEvent) {
        this.i.runOnUiThread(new o());
    }

    public void s() {
        HashMap<String, String> map = new HashMap<>();
        map.put("reportType", "click");
        map.put("clickType", this.j.B() ? "2" : "1");
        this.j.b("audioMatch_oncall_videoChatButton", map);
        if (this.j.B()) {
            Application applicationB = com.zenmen.palmchat.c.b();
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL;
            if (tg4.b(applicationB, permissionType.permissionList)) {
                this.j.D(new k());
                return;
            } else {
                BaseActivityPermissionDispatcher.b((FrameworkBaseActivity) this.i, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.AUDIO_MATCH_VIDEO);
                return;
            }
        }
        if (!this.j.e()) {
            ry5.a("公开自己的身份之后才可以邀请对方视频哦～");
            return;
        }
        if (this.j.r()) {
            return;
        }
        Application applicationB2 = com.zenmen.palmchat.c.b();
        BaseActivityPermissionDispatcher.PermissionType permissionType2 = BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL;
        if (tg4.b(applicationB2, permissionType2.permissionList)) {
            B();
        } else {
            BaseActivityPermissionDispatcher.b((FrameworkBaseActivity) this.i, permissionType2, BaseActivityPermissionDispatcher.PermissionUsage.AUDIO_MATCH_VIDEO);
        }
    }

    public void t(VoiceMatchType voiceMatchType) {
        HashMap<String, String> map = new HashMap<>();
        map.put("retryType", String.valueOf(voiceMatchType.type));
        this.j.b("audioMatch_end_retry", map);
        u(voiceMatchType.type);
    }

    public final void u(int i2) {
        this.j.u(this.i, i2, !r0.x().isVoiceMatch);
        this.i.finish();
    }

    public final void v() {
        HashMap<String, String> map = new HashMap<>();
        map.put("reportType", "view");
        map.put("answerType", this.j.e() ? "1" : "2");
        this.j.b("audioMatch_videoChat_get", map);
        MaterialDialog materialDialogE = new sd3(this.i).h(true).c(0).v(true).o(R$layout.layout_dialog_voice_match_cancel, false).e();
        View viewJ = materialDialogE.j();
        if (viewJ != null) {
            VoiceMatchConfig voiceMatchConfigI = this.j.i();
            ((TextView) viewJ.findViewById(R$id.content)).setText(this.j.e() ? voiceMatchConfigI.getVideoChatConfig().answerPopup : voiceMatchConfigI.getVideoChatConfig().answerOpenPopup);
            TextView textView = (TextView) viewJ.findViewById(R$id.confirm);
            textView.setText(voiceMatchConfigI.accept_video_confim);
            textView.setOnClickListener(new w(materialDialogE));
            TextView textView2 = (TextView) viewJ.findViewById(R$id.cancel);
            textView2.setText(voiceMatchConfigI.accept_video_deny);
            textView2.setOnClickListener(new x(materialDialogE));
        }
        materialDialogE.c(false);
        materialDialogE.show();
        this.e = materialDialogE;
    }

    public void w(boolean z2) {
        if (this.j.x().isVoiceMatch) {
            this.j.A(new s(z2));
        }
    }

    public final void x(boolean z2, List<VoiceMatchFeedbackVo.FeedbackItem> list) {
        HashMap<String, String> map = new HashMap<>();
        map.put("report_type", "view");
        this.j.b("audioMatch_end_quickReport", map);
        r rVar = new r(this.i, z2, list);
        rVar.x(3);
        rVar.show();
    }

    public final void y(boolean z2, String str, String str2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("reason", z2 ? "1" : "2");
        map.put("report_type", "view");
        this.j.b("audioMatch_end_popup", map);
        q qVar = new q(this.i, z2, str, str2);
        qVar.x(3);
        qVar.show();
    }

    public final void z() {
        MaterialDialog materialDialogE = new sd3(this.i).h(true).v(true).c(0).o(R$layout.layout_dialog_voice_match_with_des_cancel, false).e();
        View viewJ = materialDialogE.j();
        if (viewJ != null) {
            ((TextView) viewJ.findViewById(R$id.confirm)).setOnClickListener(new c(materialDialogE));
            ((TextView) viewJ.findViewById(R$id.cancel)).setOnClickListener(new d(materialDialogE));
        }
        materialDialogE.c(false);
        materialDialogE.show();
        this.h = materialDialogE;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
