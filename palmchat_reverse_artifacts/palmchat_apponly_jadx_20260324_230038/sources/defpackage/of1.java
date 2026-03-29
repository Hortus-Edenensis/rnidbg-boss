package defpackage;

import android.content.ContentValues;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bq;
import com.igexin.push.core.b;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class of1 extends ed5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<il2> f19752a;
    public MessageVo b;
    public int c;

    public of1(WeakReference<il2> weakReference, MessageVo messageVo, int i) {
        this.f19752a = weakReference;
        this.b = messageVo;
        this.c = i;
    }

    public final void a(String str, int i) {
        if (this.b == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("data1", str);
        contentValues.put("msg_sending_progress", Integer.valueOf(i));
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, this.b.contactRelate), contentValues, "data2=?", new String[]{this.b.data2});
    }

    public final void b(int i) {
        if (this.b == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("msg_sending_progress", Integer.valueOf(i));
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, this.b.contactRelate), contentValues, "data2=?", new String[]{this.b.data2});
    }

    public final void c(int i) {
        if (this.b == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("attach_status", Integer.valueOf(i));
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, this.b.contactRelate), contentValues, "data2=?", new String[]{this.b.data2});
    }

    public final void d(int i, String str, int i2) {
        if (this.b == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("attach_status", Integer.valueOf(i));
        contentValues.put("data1", str);
        contentValues.put("msg_sending_progress", Integer.valueOf(i2));
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, this.b.contactRelate), contentValues, "data2=?", new String[]{this.b.data2});
    }

    @Override // defpackage.ed5, defpackage.il2
    public void onError(int i, String str) {
        if (i == 101) {
            return;
        }
        c(zs0.a(i) ? 5 : 0);
        if (this.f19752a.get() != null) {
            this.f19752a.get().onError(i, str);
        }
    }

    @Override // defpackage.ed5, defpackage.il2
    public void onFinish(File file) {
        if (file != null && file.exists()) {
            a(file.getAbsolutePath(), (int) file.length());
        }
        if (TextUtils.isEmpty(this.b.data5) || this.b.data5.equals(rb3.b(file)) || this.b.data5.equals(b.m)) {
            c(2);
        } else {
            c(0);
        }
        if (this.f19752a.get() != null) {
            this.f19752a.get().onFinish(file);
        }
    }

    @Override // defpackage.ed5, defpackage.il2
    public void onProgress(int i) {
        if (i >= this.c) {
            LogUtil.d(bq.f.s, "download length exceed,file size is:" + this.c);
            i = this.c;
        }
        b(i);
        if (this.f19752a.get() != null) {
            this.f19752a.get().onProgress(i);
        }
    }

    @Override // defpackage.ed5, defpackage.il2
    public void onStart(String str, String str2, int i) {
        d(1, "", 0);
        if (this.f19752a.get() != null) {
            this.f19752a.get().onStart(str, str2, i);
        }
    }

    @Override // defpackage.ed5, defpackage.il2
    public void onStop(int i) {
        c(3);
        if (this.f19752a.get() != null) {
            this.f19752a.get().onStop(i);
        }
    }
}
