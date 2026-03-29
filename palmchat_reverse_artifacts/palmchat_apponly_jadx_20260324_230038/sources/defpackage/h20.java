package defpackage;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.MessageCursorLoader;
import com.zenmen.palmchat.chat.fragment.SimpleChatFragment;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class h20 implements pm2<Cursor> {
    public static final String e = "h20";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17856a;
    public boolean b = true;
    public MessageCursorLoader c = null;
    public final SimpleChatFragment d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h20.this.d.B0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f17858a;
        public final /* synthetic */ int b;

        public b(ListView listView, int i) {
            this.f17858a = listView;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17858a.setSelection(this.b + 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f17859a;

        public c(ListView listView) {
            this.f17859a = listView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17859a.smoothScrollToPosition(1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h20.this.d.z1();
        }
    }

    public h20(SimpleChatFragment simpleChatFragment) {
        this.d = simpleChatFragment;
    }

    public MessageCursorLoader b() {
        return this.c;
    }

    public final int c() {
        long jA = this.d.Q0().a();
        if (jA > 0) {
            for (int i = 0; i < this.d.O0().I().size(); i++) {
                if (this.d.O0().I().get(i)._id == jA) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        String str;
        SimpleChatFragment simpleChatFragment = this.d;
        if (simpleChatFragment == null) {
            return;
        }
        ListView listViewW0 = simpleChatFragment.W0();
        ChatterAdapter chatterAdapterO0 = this.d.O0();
        if (listViewW0 == null || chatterAdapterO0 == null) {
            return;
        }
        if (loader.getId() == 1 && cursor != null) {
            LogUtil.i("MessageCursorLoader_lag", "MessageCursorLoader onLoadFinished ");
            LogUtil.d(e, "onLoadFinished count:" + cursor.getCount());
            if (chatterAdapterO0.getCount() > 0) {
                this.f17856a = chatterAdapterO0.getItem(chatterAdapterO0.getCount() - 1).mid;
            }
            if (chatterAdapterO0.getCount() > cursor.getCount()) {
                listViewW0.postDelayed(new a(), 200L);
            }
            MessageCursorLoader messageCursorLoader = this.c;
            chatterAdapterO0.z0(cursor, messageCursorLoader != null && messageCursorLoader.b());
            this.d.X0().e(chatterAdapterO0.I());
            if (this.b) {
                int iC = c();
                if (iC < 0) {
                    this.d.D1();
                } else if (chatterAdapterO0.getCount() > 0) {
                    listViewW0.post(new b(listViewW0, iC));
                }
                this.b = false;
            }
            if (this.c != null) {
                ProgressBar progressBarT0 = this.d.T0();
                if (this.c.b()) {
                    progressBarT0.setVisibility(0);
                } else {
                    progressBarT0.setVisibility(8);
                }
                if (this.c.e()) {
                    if (this.c.a() > 0) {
                        listViewW0.setSelectionFromTop(this.c.a() + 1, this.d.R0().getHeight());
                    }
                    this.c.j(false);
                }
                if (this.c.f()) {
                    if (this.c.a() > 0) {
                        listViewW0.postDelayed(new c(listViewW0), 200L);
                    }
                    this.c.k(false);
                    listViewW0.setTranscriptMode(1);
                }
            }
        } else if (loader.getId() == 4 && cursor != null && this.d.S0() != null) {
            this.d.S0().p3(pt1.b(cursor));
        }
        if (chatterAdapterO0.getCount() > 0 && (str = chatterAdapterO0.getItem(chatterAdapterO0.getCount() - 1).mid) != null && !str.equals(this.f17856a) && chatterAdapterO0.getItem(chatterAdapterO0.getCount() - 1).isSend) {
            this.d.D1();
        }
        listViewW0.postDelayed(new d(), 1000L);
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String str;
        String[] strArr;
        LogUtil.i(e, "onCreateLoader id" + i);
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            return new CursorLoader(AppContext.getContext(), qt1.f20317a, null, null, null, "_id ASC");
        }
        if (this.d.L0().getChatType() == 0) {
            str = "contact_relate=?";
            strArr = new String[]{DomainHelper.a(this.d.L0(), false)};
        } else if (this.d.L0().getChatType() == 1) {
            boolean zC = com.zenmen.palmchat.database.a.c();
            String str2 = "contact_relate" + com.zenmen.palmchat.database.a.b(zC);
            strArr = new String[]{DomainHelper.e(this.d.L0()) + com.zenmen.palmchat.database.a.a(zC)};
            str = str2;
        } else {
            str = null;
            strArr = null;
        }
        MessageCursorLoader messageCursorLoader = new MessageCursorLoader(AppContext.getContext(), DBUriManager.b(ho3.class, this.d.L0()), null, str, strArr, "_id DESC ", this.d.Q0());
        this.c = messageCursorLoader;
        return messageCursorLoader;
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
        LogUtil.i(e, "onLoaderReset");
        if (this.d.O0() != null) {
            this.d.O0().z0(null, false);
        }
    }
}
