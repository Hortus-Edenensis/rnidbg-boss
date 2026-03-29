package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.JsonSyntaxException;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.circle.greet.CircleGreetView;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wh extends SimpleChatViewAdapter {
    public HashMap<String, n90> i = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f21699a;

        public a(MessageVo messageVo) {
            this.f21699a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatterAdapter.h hVarO = wh.this.r().o();
            if (hVarO != null) {
                hVarO.H(this.f21699a, null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f21700a;

        public b(MessageVo messageVo) {
            this.f21700a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ChatterAdapter.h hVarO = wh.this.r().o();
            if (hVarO == null) {
                return true;
            }
            hVarO.m(this.f21700a, null);
            return true;
        }
    }

    @Override // defpackage.o40
    public int a() {
        return 28;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        View viewInflate;
        int i = messageVo.mimeType;
        boolean z = messageVo.isSend;
        if (i == 22) {
            viewInflate = this.e.inflate(z ? R.layout.list_item_chat_right_voucher_redpacket : R.layout.list_item_chat_left_voucher_redpacket, (ViewGroup) null);
        } else {
            if (i != 24) {
                return null;
            }
            viewInflate = this.e.inflate(z ? R.layout.list_item_greet_right : R.layout.list_item_greet_left, (ViewGroup) null);
        }
        return viewInflate;
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 4;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        h50 h50Var = (h50) t;
        int i = messageVo.mimeType;
        if (i == 22) {
            x(messageVo, h50Var);
        } else {
            if (i != 24) {
                return;
            }
            w(messageVo, h50Var);
        }
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        if (i == 22) {
            return z ? 29 : 28;
        }
        if (i != 24) {
            return -1;
        }
        return z ? 31 : 30;
    }

    public final void w(MessageVo messageVo, h50 h50Var) {
        ViewGroup viewGroup = h50Var.e0;
        if (viewGroup == null || viewGroup.findViewById(R.id.greet_new_comer) == null) {
            return;
        }
        CircleGreetView circleGreetView = (CircleGreetView) h50Var.e0.findViewById(R.id.greet_new_comer);
        circleGreetView.setContractInfo(r().b());
        circleGreetView.setChatItemListener(r().o());
        try {
            circleGreetView.update(messageVo, r().getGroupItem(), this.i);
        } catch (JsonSyntaxException unused) {
        }
    }

    public final void x(MessageVo messageVo, h50 h50Var) {
        int i;
        int i2;
        int i3;
        VoucherRedPacketVo voucherRedPacketVoBuildFromMessageVo = VoucherRedPacketVo.buildFromMessageVo(messageVo);
        if (voucherRedPacketVoBuildFromMessageVo != null) {
            h50Var.R.setText(voucherRedPacketVoBuildFromMessageVo.remark);
        }
        int iA = ku4.a(messageVo);
        if (iA == 0) {
            h50Var.B0.setImageResource(R.drawable.icon_voucher_redpacket_thumb_init);
        } else {
            h50Var.B0.setImageResource(R.drawable.icon_voucher_redpacket_thumb_init);
        }
        if (iA != 0) {
            if (messageVo.isSend) {
                h50Var.U.setBackgroundResource(R.drawable.icon_voucher_redpacket_open_right);
            } else {
                h50Var.U.setBackgroundResource(R.drawable.icon_voucher_redpacket_open_left);
            }
        } else if (messageVo.isSend) {
            h50Var.U.setBackgroundResource(R.drawable.icon_voucher_redpacket_normal_right);
        } else {
            h50Var.U.setBackgroundResource(R.drawable.icon_voucher_redpacket_normal_left);
        }
        h50Var.U.setPadding(0, 0, 0, 0);
        if (iA != 0) {
            if (iA != 1) {
                if (iA != 2) {
                    if (iA == 3) {
                        h50Var.S.setText(R.string.circle_voucher_red_packet_expired);
                    }
                } else if (voucherRedPacketVoBuildFromMessageVo == null || (!((i3 = voucherRedPacketVoBuildFromMessageVo.couponType) == 3 || i3 == 4) || TextUtils.equals(AccountUtils.p(this.f), voucherRedPacketVoBuildFromMessageVo.specificUid))) {
                    h50Var.S.setText(R.string.circle_voucher_red_packet_grabbed);
                } else {
                    h50Var.S.setText(this.f.getString(R.string.circle_voucher_red_packet_grabbed_spec, voucherRedPacketVoBuildFromMessageVo.specificNickname));
                }
            } else if (voucherRedPacketVoBuildFromMessageVo == null || !((i2 = voucherRedPacketVoBuildFromMessageVo.couponType) == 3 || i2 == 4)) {
                h50Var.S.setText(R.string.circle_voucher_red_packet_grabbed_done);
            } else {
                h50Var.S.setText(this.f.getString(R.string.circle_voucher_red_packet_grabbed_spec, voucherRedPacketVoBuildFromMessageVo.specificNickname));
            }
        } else if (voucherRedPacketVoBuildFromMessageVo == null || (!((i = voucherRedPacketVoBuildFromMessageVo.couponType) == 3 || i == 4) || TextUtils.equals(AccountUtils.p(this.f), voucherRedPacketVoBuildFromMessageVo.specificUid))) {
            h50Var.S.setText(R.string.circle_voucher_red_packet_ungrabbed);
        } else {
            h50Var.S.setText(this.f.getString(R.string.circle_voucher_red_packet_ungrabbed_spec, voucherRedPacketVoBuildFromMessageVo.specificNickname));
        }
        h50Var.D.setOnClickListener(new a(messageVo));
        h50Var.D.setOnLongClickListener(new b(messageVo));
    }

    @Override // defpackage.o40
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public h50 c(View view) {
        return h50.g(view);
    }
}
