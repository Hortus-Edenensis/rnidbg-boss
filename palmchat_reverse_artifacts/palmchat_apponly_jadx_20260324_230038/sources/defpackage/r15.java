package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class r15 extends Handler {
    public static Looper c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<ContentResolver> f20375a;
    public Handler b;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Uri f20376a;
        public Handler b;
        public String[] c;
        public String d;
        public String[] e;
        public String f;
        public Object g;
        public Object h;
        public ContentValues i;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ContentResolver contentResolver = r15.this.f20375a.get();
            if (contentResolver == null) {
                return;
            }
            a aVar = (a) message.obj;
            int i = message.what;
            int i2 = message.arg1;
            Cursor cursor = null;
            if (i2 == 1) {
                try {
                    Cursor cursorQuery = contentResolver.query(aVar.f20376a, aVar.c, aVar.d, aVar.e, aVar.f);
                    if (cursorQuery != null) {
                        cursorQuery.getCount();
                    }
                    cursor = cursorQuery;
                } catch (Exception e) {
                    Log.w("SafeAsyncQueryHandler", "Exception thrown during handling EVENT_ARG_QUERY", e);
                }
                aVar.g = cursor;
            } else if (i2 == 2) {
                try {
                    aVar.g = contentResolver.insert(aVar.f20376a, aVar.i);
                } catch (Exception e2) {
                    Log.w("SafeAsyncQueryHandler", "Exception thrown during handling EVENT_ARG_INSERT", e2);
                    aVar.g = null;
                }
            } else if (i2 == 3) {
                try {
                    aVar.g = Integer.valueOf(contentResolver.update(aVar.f20376a, aVar.i, aVar.d, aVar.e));
                } catch (Exception e3) {
                    Log.w("SafeAsyncQueryHandler", "Exception thrown during handling EVENT_ARG_UPDATE", e3);
                    aVar.g = -1;
                }
            } else if (i2 == 4) {
                try {
                    aVar.g = Integer.valueOf(contentResolver.delete(aVar.f20376a, aVar.d, aVar.e));
                } catch (Exception e4) {
                    Log.w("SafeAsyncQueryHandler", "Exception thrown during handling EVENT_ARG_DELETE", e4);
                    aVar.g = -1;
                }
            }
            Message messageObtainMessage = aVar.b.obtainMessage(i);
            messageObtainMessage.obj = aVar;
            messageObtainMessage.arg1 = message.arg1;
            messageObtainMessage.sendToTarget();
        }
    }

    public r15(ContentResolver contentResolver) {
        this.f20375a = new WeakReference<>(contentResolver);
        synchronized (r15.class) {
            if (c == null) {
                HandlerThread handlerThreadA = lg2.a("AsyncQueryWorker");
                handlerThreadA.start();
                c = handlerThreadA.getLooper();
            }
        }
        this.b = b(c);
    }

    public final void a(int i) {
        this.b.removeMessages(i);
    }

    public Handler b(Looper looper) {
        return new b(looper);
    }

    public final void g(int i, Object obj, Uri uri, String str, String[] strArr) {
        Message messageObtainMessage = this.b.obtainMessage(i);
        messageObtainMessage.arg1 = 4;
        a aVar = new a();
        aVar.b = this;
        aVar.f20376a = uri;
        aVar.h = obj;
        aVar.d = str;
        aVar.e = strArr;
        messageObtainMessage.obj = aVar;
        this.b.sendMessage(messageObtainMessage);
    }

    public final void h(int i, Object obj, Uri uri, ContentValues contentValues) {
        Message messageObtainMessage = this.b.obtainMessage(i);
        messageObtainMessage.arg1 = 2;
        a aVar = new a();
        aVar.b = this;
        aVar.f20376a = uri;
        aVar.h = obj;
        aVar.i = contentValues;
        messageObtainMessage.obj = aVar;
        this.b.sendMessage(messageObtainMessage);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = (a) message.obj;
        int i = message.what;
        int i2 = message.arg1;
        if (i2 == 1) {
            e(i, aVar.h, (Cursor) aVar.g);
            return;
        }
        if (i2 == 2) {
            d(i, aVar.h, (Uri) aVar.g);
        } else if (i2 == 3) {
            f(i, aVar.h, ((Integer) aVar.g).intValue());
        } else {
            if (i2 != 4) {
                return;
            }
            c(i, aVar.h, ((Integer) aVar.g).intValue());
        }
    }

    public void i(int i, Object obj, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Message messageObtainMessage = this.b.obtainMessage(i);
        messageObtainMessage.arg1 = 1;
        a aVar = new a();
        aVar.b = this;
        aVar.f20376a = uri;
        aVar.c = strArr;
        aVar.d = str;
        aVar.e = strArr2;
        aVar.f = str2;
        aVar.h = obj;
        messageObtainMessage.obj = aVar;
        this.b.sendMessage(messageObtainMessage);
    }

    public final void j(int i, Object obj, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Message messageObtainMessage = this.b.obtainMessage(i);
        messageObtainMessage.arg1 = 3;
        a aVar = new a();
        aVar.b = this;
        aVar.f20376a = uri;
        aVar.h = obj;
        aVar.i = contentValues;
        aVar.d = str;
        aVar.e = strArr;
        messageObtainMessage.obj = aVar;
        this.b.sendMessage(messageObtainMessage);
    }

    public void c(int i, Object obj, int i2) {
    }

    public void d(int i, Object obj, Uri uri) {
    }

    public void e(int i, Object obj, Cursor cursor) {
    }

    public void f(int i, Object obj, int i2) {
    }
}
