package defpackage;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class xp5 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f22032a;

        public a(EditText editText) {
            this.f22032a = editText;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            int action = motionEvent.getAction() & 255;
            if (action == 1) {
                this.f22032a.setFocusable(true);
                this.f22032a.setFocusableInTouchMode(true);
                view.getParent().requestDisallowInterceptTouchEvent(false);
            } else if (action == 2) {
                this.f22032a.setFocusable(false);
            }
            return false;
        }
    }

    public static void a(EditText editText) {
        editText.setOnTouchListener(new a(editText));
    }
}
