package com.zenmen.palmchat.paidservices.voicematch;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.zenmen.palmchat.R;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f14914a;
        public final /* synthetic */ PopupWindow b;

        public a(c cVar, PopupWindow popupWindow) {
            this.f14914a = cVar;
            this.b = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f14914a.a();
            this.b.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.paidservices.voicematch.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1090b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f14915a;
        public final /* synthetic */ PopupWindow b;

        public ViewOnClickListenerC1090b(c cVar, PopupWindow popupWindow) {
            this.f14915a = cVar;
            this.b = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f14915a.b();
            this.b.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a();

        void b();
    }

    public static PopupWindow a(Activity activity, View view, boolean z, c cVar) {
        View viewInflate = activity.getLayoutInflater().inflate(z ? R.layout.layout_popup_voice_match_menu_black : R.layout.layout_popup_voice_match_menu, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        viewInflate.findViewById(R.id.rule).setOnClickListener(new a(cVar, popupWindow));
        viewInflate.findViewById(R.id.setting).setOnClickListener(new ViewOnClickListenerC1090b(cVar, popupWindow));
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        viewInflate.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        popupWindow.showAsDropDown(view, -me1.b(activity, 24), 0);
        popupWindow.update();
        return popupWindow;
    }
}
