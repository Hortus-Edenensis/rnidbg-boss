package com.zenmen.palmchat.contacts.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.widget.a;
import com.zenmen.palmchat.databinding.PopupEnergyTipBinding;
import defpackage.az2;
import defpackage.b05;
import defpackage.q05;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class EnergyTipPopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13733a;
    public PopupWindow b;
    public PopupEnergyTipBinding c;
    public boolean d = false;
    public Handler e = new Handler(Looper.getMainLooper());
    public com.zenmen.palmchat.contacts.widget.a f = com.zenmen.palmchat.contacts.widget.a.a();
    public ContactInfoItem g;

    /* JADX INFO: compiled from: SearchBox */
    public enum AlignType {
        LEFT,
        RIGHT
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            EnergyTipPopupWindow.this.d = false;
            if (EnergyTipPopupWindow.this.e != null) {
                EnergyTipPopupWindow.this.e.removeCallbacksAndMessages(null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b05.a("能量气泡自动消失");
            EnergyTipPopupWindow.this.g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EnergyTipPopupWindow.this.e();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            EnergyTipPopupWindow.this.c.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            EnergyTipPopupWindow.this.e();
        }
    }

    public EnergyTipPopupWindow(Context context) {
        this.f13733a = context;
        h();
    }

    public final void e() {
        TextView textView;
        PopupEnergyTipBinding popupEnergyTipBinding = this.c;
        if (popupEnergyTipBinding == null || (textView = popupEnergyTipBinding.b) == null || popupEnergyTipBinding.f13914a == null) {
            return;
        }
        int height = textView.getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.b.getLayoutParams();
        int i = height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        ViewGroup.LayoutParams layoutParams = this.c.f13914a.getLayoutParams();
        layoutParams.height = i;
        this.c.f13914a.setLayoutParams(layoutParams);
    }

    public final boolean f() {
        com.zenmen.palmchat.contacts.widget.a aVar = this.f;
        if (aVar == null || aVar.d == null) {
            b05.a("ProfileEnergyConfig或bubble配置为空，使用默认配置");
            return true;
        }
        long jLongValue = ((Long) q05.k("KEY_ENERGY_BUBBLE_LATEST_SHOW_TIME", 0L)).longValue();
        int iIntValue = (jLongValue <= 0 || !q05.q(jLongValue)) ? 0 : ((Integer) q05.k("KEY_ENERGY_BUBBLE_TODAY_SHOW_COUNT", 0)).intValue();
        int i = this.f.d.d;
        if (iIntValue >= i) {
            b05.a("能量气泡当天显示次数已达到上限：" + iIntValue + "/" + i);
            return false;
        }
        int iIntValue2 = ((Integer) q05.k("KEY_ENERGY_BUBBLE_TOTAL_SHOW_COUNT", 0)).intValue();
        int i2 = this.f.d.c;
        if (iIntValue2 >= i2) {
            b05.a("能量气泡总显示次数已达到上限：" + iIntValue2 + "/" + i2);
            return false;
        }
        b05.a("能量气泡可以显示，当天次数：" + iIntValue + "/" + i + "，总次数：" + iIntValue2 + "/" + i2);
        return true;
    }

    public void g() {
        PopupWindow popupWindow = this.b;
        if (popupWindow == null || !this.d) {
            return;
        }
        popupWindow.dismiss();
        this.d = false;
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void h() {
        a.C1036a c1036a;
        this.c = (PopupEnergyTipBinding) DataBindingUtil.inflate(LayoutInflater.from(this.f13733a), R.layout.popup_energy_tip, null, false);
        PopupWindow popupWindow = new PopupWindow(this.c.getRoot(), -2, -2, true);
        this.b = popupWindow;
        popupWindow.setOutsideTouchable(true);
        this.b.setFocusable(true);
        this.b.setOnDismissListener(new a());
        com.zenmen.palmchat.contacts.widget.a aVar = this.f;
        m((aVar == null || (c1036a = aVar.d) == null) ? "能量越高，曝光和打招呼机会越多" : c1036a.f13743a);
        n();
    }

    public final void i() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jLongValue = ((Long) q05.k("KEY_ENERGY_BUBBLE_LATEST_SHOW_TIME", 0L)).longValue();
        q05.w("KEY_ENERGY_BUBBLE_LATEST_SHOW_TIME", Long.valueOf(jCurrentTimeMillis));
        int iIntValue = (jLongValue <= 0 || !q05.q(jLongValue)) ? 1 : ((Integer) q05.k("KEY_ENERGY_BUBBLE_TODAY_SHOW_COUNT", 0)).intValue() + 1;
        q05.w("KEY_ENERGY_BUBBLE_TODAY_SHOW_COUNT", Integer.valueOf(iIntValue));
        int iIntValue2 = ((Integer) q05.k("KEY_ENERGY_BUBBLE_TOTAL_SHOW_COUNT", 0)).intValue() + 1;
        q05.w("KEY_ENERGY_BUBBLE_TOTAL_SHOW_COUNT", Integer.valueOf(iIntValue2));
        b05.a("记录能量气泡显示：时间=" + jCurrentTimeMillis + "，当天次数=" + iIntValue + "，总次数=" + iIntValue2);
    }

    public void j() {
        PopupWindow popupWindow = this.b;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.b.dismiss();
        }
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.e = null;
        }
        this.b = null;
        this.c = null;
        this.f13733a = null;
        this.f = null;
        this.g = null;
    }

    public final void k() {
        a.C1036a c1036a;
        if (this.g == null) {
            b05.a("currentContactInfoItem为空，无法打点profile_energy_bubble_show");
            return;
        }
        HashMap map = new HashMap();
        map.put("show_bubble", this.g.getUid());
        com.zenmen.palmchat.contacts.widget.a aVar = this.f;
        map.put("copywriting", (aVar == null || (c1036a = aVar.d) == null) ? "能量越高，曝光和打招呼机会越多" : c1036a.f13743a);
        q05.a("profile_energy_bubble_show", 1, map);
        b05.a("打点profile_energy_bubble_show：" + az2.c(map));
    }

    public void l(ContactInfoItem contactInfoItem) {
        this.g = contactInfoItem;
    }

    public void m(String str) {
        TextView textView;
        PopupEnergyTipBinding popupEnergyTipBinding = this.c;
        if (popupEnergyTipBinding == null || (textView = popupEnergyTipBinding.b) == null) {
            return;
        }
        textView.setText(str);
        this.c.b.post(new c());
    }

    public final void n() {
        TextView textView;
        PopupEnergyTipBinding popupEnergyTipBinding = this.c;
        if (popupEnergyTipBinding == null || (textView = popupEnergyTipBinding.b) == null || popupEnergyTipBinding.f13914a == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new d());
    }

    public void o(View view) {
        if (this.b == null || this.d) {
            return;
        }
        if (!f()) {
            b05.a("能量气泡显示次数已达限制，不显示");
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.b.showAtLocation(view, 0, iArr[0], iArr[1] + view.getHeight());
        this.d = true;
        k();
        i();
        q();
    }

    public void p(View view) {
        if (this.b == null || this.d) {
            return;
        }
        if (!f()) {
            b05.a("能量气泡显示次数已达限制，不显示");
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.c.getRoot().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.b.showAtLocation(view, 0, (iArr[0] + view.getWidth()) - this.c.getRoot().getMeasuredWidth(), iArr[1] + view.getHeight());
        this.d = true;
        k();
        i();
        q();
    }

    public final void q() {
        a.C1036a c1036a;
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        com.zenmen.palmchat.contacts.widget.a aVar = this.f;
        b05.a("启动能量气泡自动消失定时器，" + ((aVar == null || (c1036a = aVar.d) == null) ? 5 : c1036a.b) + "秒后消失");
        Handler handler2 = this.e;
        if (handler2 != null) {
            handler2.postDelayed(new b(), r0 * 1000);
        }
    }

    public void r(View view) {
        if (this.d) {
            g();
        } else {
            p(view);
        }
    }
}
