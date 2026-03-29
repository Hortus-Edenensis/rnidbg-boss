package defpackage;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.is0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class hc3 {
    public static final String b = "hc3";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PopupWindow f17923a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f17924a;

        public a(Activity activity) {
            this.f17924a = activity;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
                return true;
            }
            hc3.this.b(this.f17924a);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ is0.f f17925a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Activity c;

        public b(is0.f fVar, String str, Activity activity) {
            this.f17925a = fVar;
            this.b = str;
            this.c = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            is0.f fVar = this.f17925a;
            if (fVar != null) {
                fVar.onItemClicked(((Integer) view.getTag()).intValue());
                if (this.b.equals("免费wifi") && ox3.a("key_wifi_fast")) {
                    ox3.e("key_wifi_fast");
                    r75.q(c.b(), "sp_click_wifi_time", ir5.b());
                }
            }
            hc3.this.b(this.c);
        }
    }

    public void a(Activity activity, Float f) {
        Window window;
        WindowManager.LayoutParams attributes;
        if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.alpha = f.floatValue();
        window.addFlags(2);
        window.setAttributes(attributes);
    }

    public void b(Activity activity) {
        LogUtil.i(b, "hidePopupMenu");
        PopupWindow popupWindow = this.f17923a;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.f17923a.dismiss();
        a(activity, Float.valueOf(1.0f));
    }

    public final void c(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    public void d(Activity activity, View view, String[] strArr, int[] iArr, is0.f fVar, PopupWindow.OnDismissListener onDismissListener, boolean z) {
        LogUtil.i(b, "showPopupMenu");
        a(activity, Float.valueOf(0.9f));
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.main_tab_menu_pop_layout, (ViewGroup) null);
        this.f17923a = new PopupWindow(viewInflate, -2, -2);
        viewInflate.setFocusable(true);
        viewInflate.setFocusableInTouchMode(true);
        viewInflate.setOnKeyListener(new a(activity));
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.menu_item_container);
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            View viewInflate2 = activity.getLayoutInflater().inflate(R.layout.item_popup_menu, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate2.findViewById(R.id.thumb);
            if (iArr != null) {
                imageView.setImageResource(iArr[i]);
            } else {
                imageView.setVisibility(8);
            }
            ((TextView) viewInflate2.findViewById(R.id.title)).setText(strArr[i]);
            String str = strArr[i];
            View viewFindViewById = viewInflate2.findViewById(R.id.reddot);
            if (z && str.equals("免费wifi")) {
                if (ox3.a("key_wifi_fast")) {
                    viewFindViewById.setVisibility(0);
                } else {
                    viewFindViewById.setVisibility(8);
                }
            }
            viewInflate2.setOnClickListener(new b(fVar, str, activity));
            viewInflate2.setTag(Integer.valueOf(i));
            viewInflate2.setTag(R.id.tag_first, strArr[i]);
            viewInflate2.findViewById(R.id.menu_sep).setVisibility(8);
            linearLayout.addView(viewInflate2);
        }
        this.f17923a.setBackgroundDrawable(new ColorDrawable(0));
        this.f17923a.setAnimationStyle(R.style.AnimationPopMenuDialog);
        this.f17923a.setContentView(viewInflate);
        this.f17923a.setOutsideTouchable(false);
        this.f17923a.setFocusable(true);
        this.f17923a.setOnDismissListener(onDismissListener);
        if (!this.f17923a.isShowing()) {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i2 = rect.top;
            c(viewInflate);
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            try {
                this.f17923a.showAtLocation(view, 0, ((iArr2[0] + view.getWidth()) - viewInflate.getMeasuredWidth()) - me1.b(activity, 8), activity.getResources().getDimensionPixelOffset(R.dimen.title_bar_height) + i2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f17923a.update();
    }
}
