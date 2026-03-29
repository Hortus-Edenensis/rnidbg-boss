package defpackage;

import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.conversations.recallbar.bean.RecallBarEvent;
import com.zenmen.palmchat.conversations.recallbar.view.RecallBar;
import com.zenmen.palmchat.conversations.threadbubble.bean.ThreadsBubbleEvent;
import com.zenmen.palmchat.conversations.threadbubble.view.ThreadsBubbleWidget;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ex5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadsBubbleWidget f17387a;
    public RecallBar b;
    public boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ex5.this.h();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ex5.this.b == null || !"tab_msg".equals(MainTabsActivity.y2())) {
                return;
            }
            ex5.this.b.update();
        }
    }

    public ex5() {
        ds0.a().c(this);
    }

    public void c(ThreadsBubbleWidget threadsBubbleWidget, RecallBar recallBar) {
        this.f17387a = threadsBubbleWidget;
        this.b = recallBar;
    }

    public void d() {
        try {
            ds0.a().d(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ThreadsBubbleWidget threadsBubbleWidget = this.f17387a;
        if (threadsBubbleWidget != null) {
            threadsBubbleWidget.destroy();
            this.f17387a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    public void e() {
        this.c = false;
    }

    public void f() {
        h();
        this.c = true;
    }

    public void g() {
        RecallBar recallBar = this.b;
        if (recallBar != null) {
            recallBar.update();
        }
    }

    public final void h() {
        ThreadsBubbleWidget threadsBubbleWidget = this.f17387a;
        if (threadsBubbleWidget != null) {
            threadsBubbleWidget.update();
        }
        if (this.b == null || !"tab_msg".equals(MainTabsActivity.y2())) {
            return;
        }
        this.b.update();
    }

    @qm5
    public void receivedRecallBarEvent(RecallBarEvent recallBarEvent) {
        ThreadsBubbleWidget threadsBubbleWidget = this.f17387a;
        if (threadsBubbleWidget == null || !this.c) {
            return;
        }
        threadsBubbleWidget.post(new b());
    }

    @qm5
    public void receivedThreadsBubbleEvent(ThreadsBubbleEvent threadsBubbleEvent) {
        ThreadsBubbleWidget threadsBubbleWidget = this.f17387a;
        if (threadsBubbleWidget == null || !this.c) {
            return;
        }
        threadsBubbleWidget.post(new a());
    }
}
