package com.opos.mobad.ui.feedback;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.opos.mobad.ui.feedback.b.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    private Context b;
    private b c;
    private com.opos.mobad.ui.feedback.b.a d;
    private com.opos.mobad.ui.feedback.b.b e;
    private String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10256a = "以后将减少此类推荐";
    private c g = new c() { // from class: com.opos.mobad.ui.feedback.a.2
        @Override // com.opos.mobad.ui.feedback.b.c
        public void a() {
            if (a.this.d != null) {
                a.this.d.dismiss();
            }
        }

        @Override // com.opos.mobad.ui.feedback.b.c
        public void b() {
            if (a.this.c != null) {
                a.this.c.b(true);
            }
        }

        @Override // com.opos.mobad.ui.feedback.b.c
        public void a(int i) {
            if (a.this.c != null) {
                a.this.c.a(i);
            }
            if (i != com.opos.mobad.ui.feedback.a.a.TAG_BLOCK_CONTENT.a()) {
                if (a.this.d != null) {
                    a.this.d.dismiss();
                }
                if (i != com.opos.mobad.ui.feedback.a.a.TAG_CONTENT_COMPLAINT.a()) {
                    Toast.makeText(a.this.b, "以后将减少此类推荐", 1).show();
                } else if (a.this.c != null) {
                    a.this.c.b(false);
                }
            }
        }
    };

    public a(Context context, b bVar) {
        this.b = context.getApplicationContext();
        this.c = bVar;
        com.opos.mobad.ui.feedback.b.a aVar = new com.opos.mobad.ui.feedback.b.a(context);
        this.d = aVar;
        aVar.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.opos.mobad.ui.feedback.a.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (a.this.c != null) {
                    a.this.c.a(false);
                }
            }
        });
    }

    public void a() {
        com.opos.cmn.an.f.a.b("FeedBackPresenter", "destroy() mFeedBackPopWindow=", this.d);
        com.opos.mobad.ui.feedback.b.a aVar = this.d;
        if (aVar != null) {
            aVar.dismiss();
            this.d.setOnDismissListener(null);
            this.d = null;
        }
        com.opos.mobad.ui.feedback.b.b bVar = this.e;
        if (bVar != null) {
            bVar.b();
        }
        this.c = null;
    }

    public boolean b(View view) {
        if (view != null) {
            Rect rect = new Rect();
            view.getLocalVisibleRect(rect);
            com.opos.cmn.an.f.a.b("FeedBackPresenter", "isMeetSize viewArea =" + rect.toString());
            if (rect.width() >= com.opos.cmn.an.h.f.a.a(view.getContext(), 320.0f) && rect.height() >= com.opos.cmn.an.h.f.a.a(view.getContext(), 320.0f)) {
                return true;
            }
        }
        com.opos.cmn.an.f.a.b("FeedBackPresenter", "decorView is not meet Size with FeedBackContent");
        return false;
    }

    public void a(View view) {
        if (view != null) {
            try {
                if (b(view.getRootView())) {
                    com.opos.mobad.ui.feedback.b.b bVar = this.e;
                    if (bVar != null) {
                        bVar.b();
                    }
                    com.opos.mobad.ui.feedback.b.b bVar2 = new com.opos.mobad.ui.feedback.b.b(this.b, this.g, this.f);
                    this.e = bVar2;
                    com.opos.mobad.ui.feedback.b.a aVar = this.d;
                    if (aVar != null) {
                        aVar.a(bVar2.a(), -1, -1, view);
                        return;
                    }
                    return;
                }
            } catch (Exception unused) {
            }
        }
        b bVar3 = this.c;
        if (bVar3 != null) {
            bVar3.a(true);
        }
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public void a(String str) {
        this.f = str;
    }
}
