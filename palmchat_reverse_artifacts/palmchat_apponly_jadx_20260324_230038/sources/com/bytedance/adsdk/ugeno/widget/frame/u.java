package com.bytedance.adsdk.ugeno.widget.frame;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.nr.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends com.bytedance.adsdk.ugeno.nr.u<UGFrameLayout> {
    private UGFrameLayout ki;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.widget.frame.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0175u extends u.C0171u {
        protected int z;

        public C0175u(com.bytedance.adsdk.ugeno.nr.u uVar) {
            super(uVar);
            this.z = -1;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:4:0x000e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int nr(String str) {
            str.hashCode();
            switch (str) {
                case "bottom":
                    return 80;
                case "center":
                    return 17;
                case "center_vertical":
                    return 16;
                case "top":
                    return 48;
                case "left":
                    return 3;
                case "right":
                    return 5;
                case "center_horizontal":
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.nr.u.C0171u
        /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams u() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.u, (int) this.nr);
            layoutParams.leftMargin = (int) this.iz;
            layoutParams.rightMargin = (int) this.x;
            layoutParams.topMargin = (int) this.n;
            layoutParams.bottomMargin = (int) this.f5036a;
            layoutParams.gravity = this.z;
            return layoutParams;
        }

        @Override // com.bytedance.adsdk.ugeno.nr.u.C0171u
        public void u(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.u(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.z = u(str2);
            }
        }

        private int u(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\|")) == null || strArrSplit.length <= 0) {
                return -1;
            }
            int iNr = 0;
            for (String str2 : strArrSplit) {
                iNr |= nr(str2);
            }
            return iNr;
        }
    }

    public u(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: ay, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout u() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.nr);
        this.ki = uGFrameLayout;
        uGFrameLayout.u(this);
        return this.ki;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u
    public u.C0171u n() {
        return new C0175u(this);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u, com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        this.ki.setEventMap(this.tr);
        super.nr();
    }
}
