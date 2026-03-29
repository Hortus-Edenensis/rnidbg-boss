package defpackage;

import android.content.Intent;
import android.text.TextUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.baidu.location.LocationConst;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.circle.bean.CircleApplyGroupType;
import com.zenmen.palmchat.circle.bean.CircleGrabRedPacketBean;
import com.zenmen.palmchat.circle.bean.CircleRedPacketInfoBean;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.coupon.info.CircleCouponInfoActivity;
import com.zenmen.palmchat.circle.ui.CircleApplyGroupActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import defpackage.vb0;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class h70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameworkBaseActivity f17883a;
    public vb0 b;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<CircleGrabRedPacketBean>> {

        /* JADX INFO: renamed from: h70$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1205a extends MaterialDialog.e {
            public C1205a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleGrabRedPacketBean> baseResponse) {
            CircleApplyGroupType addModeResult;
            h70.this.i();
            if (baseResponse.getResultCode() == 0 || baseResponse.getResultCode() == 4001 || baseResponse.getResultCode() == 4006) {
                if (baseResponse.getData() != null) {
                    h70.this.n(baseResponse.getData().getRoomId());
                }
            } else if (baseResponse.getResultCode() == 4027 || baseResponse.getResultCode() == 5077) {
                new sd3(h70.this.f17883a).k(baseResponse.getErrorMsg()).O(R.string.red_packet_timeout_know).f(new C1205a()).e().show();
            } else if (baseResponse.getData() == null || (addModeResult = baseResponse.getData().getAddModeResult()) == null || addModeResult.getAddType() != 2) {
                h70.this.m(baseResponse.getErrorMsg());
            } else {
                CircleApplyGroupActivity.J1(h70.this.f17883a, addModeResult, 10, "");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse<CircleRedPacketInfoBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoucherRedPacketVo f17886a;
        public final /* synthetic */ MessageVo b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements vb0.a {

            /* JADX INFO: renamed from: h70$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1206a extends wi0<BaseResponse<CircleGrabRedPacketBean>> {
                public C1206a() {
                }

                @Override // defpackage.wi0
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public void a(BaseResponse<CircleGrabRedPacketBean> baseResponse) {
                    if (h70.this.b != null && h70.this.b.isShowing()) {
                        h70.this.b.dismiss();
                    }
                    if (baseResponse.getResultCode() != 0 || baseResponse.getData() == null) {
                        h70.this.m(baseResponse.getErrorMsg());
                        return;
                    }
                    if (baseResponse.getData().isReceiveStatus()) {
                        b bVar = b.this;
                        h70.this.q(bVar.b, 2);
                        b bVar2 = b.this;
                        h70 h70Var = h70.this;
                        VoucherRedPacketVo voucherRedPacketVo = bVar2.f17886a;
                        h70Var.o(voucherRedPacketVo.couponId, voucherRedPacketVo.vcode);
                        return;
                    }
                    if (baseResponse.getData().isExpire()) {
                        b bVar3 = b.this;
                        h70.this.q(bVar3.b, 3);
                        h70.this.m("红包已过期");
                    } else if (baseResponse.getData().isReceiveAll()) {
                        b bVar4 = b.this;
                        h70.this.q(bVar4.b, 1);
                        h70.this.m("红包已领完");
                    } else {
                        b bVar5 = b.this;
                        h70.this.q(bVar5.b, 0);
                        h70.this.m(baseResponse.getErrorMsg());
                    }
                }
            }

            public a() {
            }

            @Override // vb0.a
            public void a() {
                h70.this.b.j();
                c70 c70VarR = c70.R();
                VoucherRedPacketVo voucherRedPacketVo = b.this.f17886a;
                c70VarR.a0(voucherRedPacketVo.couponId, voucherRedPacketVo.vcode, false, new C1206a());
            }

            @Override // vb0.a
            public void b() {
                b bVar = b.this;
                h70 h70Var = h70.this;
                VoucherRedPacketVo voucherRedPacketVo = bVar.f17886a;
                h70Var.o(voucherRedPacketVo.couponId, voucherRedPacketVo.vcode);
            }
        }

        public b(VoucherRedPacketVo voucherRedPacketVo, MessageVo messageVo) {
            this.f17886a = voucherRedPacketVo;
            this.b = messageVo;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleRedPacketInfoBean> baseResponse) {
            h70.this.i();
            HashMap map = new HashMap();
            map.put("type", Integer.valueOf(this.f17886a.couponType));
            if (baseResponse.getResultCode() != 0) {
                h70.this.m(baseResponse.getErrorMsg());
                oc0.h("lx_group_ticket_click", map);
                return;
            }
            CircleRedPacketInfoBean data = baseResponse.getData();
            if (data == null) {
                h70.this.m("数据为空");
                oc0.h("lx_group_ticket_click", map);
                return;
            }
            map.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, Integer.valueOf(data.getReceiveStatus()));
            map.put("packet", Integer.valueOf(data.getExpireStatus()));
            oc0.h("lx_group_ticket_click", map);
            if (data.isReceiveStatus()) {
                h70.this.q(this.b, 2);
                h70 h70Var = h70.this;
                VoucherRedPacketVo voucherRedPacketVo = this.f17886a;
                h70Var.o(voucherRedPacketVo.couponId, voucherRedPacketVo.vcode);
                return;
            }
            if (data.isExpire()) {
                h70.this.q(this.b, 3);
            } else if (data.getReceiveAll()) {
                h70.this.q(this.b, 1);
            } else {
                h70.this.q(this.b, 0);
            }
            if (h70.this.j()) {
                return;
            }
            if (h70.this.b == null) {
                h70.this.b = new vb0(h70.this.f17883a);
            }
            h70.this.b.i(new a());
            if (h70.this.b.isShowing()) {
                h70.this.b.dismiss();
            }
            h70.this.b.l(baseResponse.getData());
            h70.this.b.show();
        }
    }

    public h70(FrameworkBaseActivity frameworkBaseActivity) {
        this.f17883a = frameworkBaseActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(GroupInfoItem groupInfoItem) {
        if (groupInfoItem == null || j()) {
            return;
        }
        Intent intent = new Intent(this.f17883a, (Class<?>) ChatterActivity.class);
        intent.putExtra("chat_item", groupInfoItem);
        intent.putExtra("fromType", 10);
        k86.X(intent);
        this.f17883a.startActivity(intent);
    }

    public void g(MessageVo messageVo) {
        if (messageVo == null) {
            m("");
            return;
        }
        VoucherRedPacketVo voucherRedPacketVoBuildFromMessageVo = VoucherRedPacketVo.buildFromMessageVo(messageVo);
        p();
        if (voucherRedPacketVoBuildFromMessageVo != null) {
            c70.R().Y(voucherRedPacketVoBuildFromMessageVo.couponId, voucherRedPacketVoBuildFromMessageVo.vcode, new b(voucherRedPacketVoBuildFromMessageVo, messageVo));
        } else {
            i();
            m("消息异常");
        }
    }

    public void h(String str, String str2) {
        p();
        c70.R().a0(str, str2, true, new a());
    }

    public void i() {
        if (j()) {
            return;
        }
        this.f17883a.hideBaseProgressBar();
    }

    public final boolean j() {
        FrameworkBaseActivity frameworkBaseActivity = this.f17883a;
        return frameworkBaseActivity == null || frameworkBaseActivity.isFinishing() || this.f17883a.isDestroyed();
    }

    public void l() {
        this.f17883a = null;
    }

    public void m(String str) {
        if (j()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f17883a.getString(R.string.send_failed);
        }
        sy5.f(this.f17883a, str, 0).g();
    }

    public void n(String str) {
        if (j() || TextUtils.isEmpty(str)) {
            return;
        }
        c70.R().K(str, new dv0() { // from class: g70
            @Override // defpackage.dv0
            public final void onResponse(Object obj) {
                this.f17674a.k((GroupInfoItem) obj);
            }
        });
    }

    public void o(String str, String str2) {
        if (j()) {
            return;
        }
        CircleCouponInfoActivity.J1(this.f17883a, str, str2);
    }

    public void p() {
        if (j()) {
            return;
        }
        this.f17883a.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
    }

    public final void q(MessageVo messageVo, int i) {
        ku4.b(messageVo, i);
    }
}
