package com.zenmen.palmchat.chat;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MessageCursorLoader extends AsyncTaskLoader<Cursor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Loader<Cursor>.ForceLoadContentObserver f12683a;
    public Uri b;
    public String[] c;
    public String d;
    public String[] e;
    public String f;
    public Cursor g;
    public b h;
    public c i;
    public int j;
    public int k;
    public String l;
    public boolean m;
    public long n;
    public boolean o;
    public int p;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f12684a;

        public a(boolean z) {
            this.f12684a = z;
            put("mid", MessageCursorLoader.this.h.b);
            put("type", Integer.valueOf(!z ? 1 : 0));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f12685a;
        public String b;
        public long c;

        public b(long j, String str) {
            this.f12685a = j;
            this.b = str;
        }

        public long a() {
            LogUtil.i("MessageCursorLoader", "FirstMessageInfo firstMessageId=" + this.f12685a + " firstMessageIdFromMid=" + this.c);
            long j = this.f12685a;
            if (j > 0) {
                return j;
            }
            long j2 = this.c;
            if (j2 > 0) {
                return j2;
            }
            return 0L;
        }

        public void b(long j) {
            LogUtil.i("MessageCursorLoader", "setFirstMessageIdFromMid id=" + j);
            this.c = j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum c {
        INIT_LOADING,
        NORMAL_LOADING,
        MORE_LOADING,
        UNREAD_LOADING
    }

    public MessageCursorLoader(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2, b bVar) {
        super(context);
        this.i = c.INIT_LOADING;
        this.j = 0;
        this.k = 0;
        this.l = "0";
        this.m = false;
        this.n = 0L;
        this.o = false;
        this.p = 0;
        this.f12683a = new Loader.ForceLoadContentObserver();
        this.b = uri;
        this.c = strArr;
        this.d = str;
        this.e = strArr2;
        this.f = str2;
        this.h = bVar;
        LogUtil.i("MessageCursorLoader_lag", "MessageCursorLoader create");
    }

    public int a() {
        return this.p;
    }

    public boolean b() {
        int i = this.j;
        return (i > 0 || this.p < 0) && i - this.k >= 0;
    }

    public final long c() {
        b bVar = this.h;
        if (bVar != null) {
            long j = bVar.f12685a;
            if (j <= 0 && bVar.b != null) {
                Cursor cursorQuery = getContext().getContentResolver().query(this.b, this.c, "packet_id = ?", new String[]{this.h.b}, null);
                if (cursorQuery != null) {
                    if (cursorQuery.moveToFirst()) {
                        j = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                        this.h.b(j);
                    }
                    cursorQuery.close();
                }
                LogUtil.uploadInfoImmediate("jump2NotifyMsg", new a(j > 0));
            }
            if (j > 0) {
                List listAsList = Arrays.asList(this.e);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(listAsList);
                arrayList.add(String.valueOf(j));
                String[] strArr = new String[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    strArr[i] = (String) arrayList.get(i);
                }
                Cursor cursorQuery2 = getContext().getContentResolver().query(this.b, this.c, this.d + " and _id >= ?", strArr, this.f);
                if (cursorQuery2 != null) {
                    j = cursorQuery2.getCount() > 18 ? j : 0L;
                    cursorQuery2.close();
                }
            }
        }
        return j;
    }

    public boolean d() {
        long jLongValue = Long.valueOf(this.l).longValue();
        LogUtil.i("MessageCursorLoader", "isFirstUnreadMessageLoaded" + this.n + "  " + jLongValue);
        long j = this.n;
        return j > 0 && jLongValue > 0 && jLongValue <= j;
    }

    @Override // androidx.loader.content.AsyncTaskLoader, androidx.loader.content.Loader
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.b);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.c));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.d);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.e));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.g);
    }

    public boolean e() {
        return this.m;
    }

    public boolean f() {
        return this.o;
    }

    public void g() {
        this.k = this.j + 18;
        this.i = c.MORE_LOADING;
        j(true);
    }

    public boolean h() {
        if (this.n <= 0 || d()) {
            return false;
        }
        this.i = c.UNREAD_LOADING;
        k(true);
        return true;
    }

    public void i(long j) {
        this.n = j;
    }

    public void j(boolean z) {
        this.m = z;
    }

    public void k(boolean z) {
        this.o = z;
    }

    @Override // androidx.loader.content.Loader
    public void onReset() {
        super.onReset();
        onStopLoading();
        Cursor cursor = this.g;
        if (cursor != null && !cursor.isClosed()) {
            this.g.close();
        }
        this.g = null;
    }

    @Override // androidx.loader.content.Loader
    public void onStartLoading() {
        Cursor cursor = this.g;
        if (cursor != null) {
            deliverResult(cursor);
        }
        if (takeContentChanged() || this.g == null) {
            forceLoad();
        }
    }

    @Override // androidx.loader.content.Loader
    public void onStopLoading() {
        cancelLoad();
    }

    @Override // androidx.loader.content.Loader
    public void deliverResult(Cursor cursor) {
        if (isReset()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.g;
        this.g = cursor;
        if (isStarted()) {
            super.deliverResult(cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        String[] strArr;
        String str;
        String[] strArr2;
        String str2;
        String[] strArr3;
        String str3;
        String[] strArr4;
        String str4;
        long j;
        LogUtil.i("MessageCursorLoader_lag", "MessageCursorLoader loadInBackground start");
        c cVar = this.i;
        int count = 0;
        if (cVar == c.INIT_LOADING) {
            long jC = c();
            if (jC > 0) {
                String[] strArr5 = this.c;
                String str5 = this.d + " and _id >= ?";
                List listAsList = Arrays.asList(this.e);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(listAsList);
                arrayList.add(String.valueOf(jC));
                String[] strArr6 = new String[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    strArr6[i] = (String) arrayList.get(i);
                }
                strArr = strArr5;
                str = str5;
                strArr2 = strArr6;
                str2 = this.f;
            } else {
                String[] strArr7 = this.c;
                String str6 = this.d;
                String[] strArr8 = this.e;
                strArr = strArr7;
                str = str6;
                str2 = this.f + " limit 18";
                strArr2 = strArr8;
            }
            j = jC;
        } else {
            if (cVar == c.NORMAL_LOADING) {
                strArr3 = this.c;
                str3 = this.d + " and _id >= ?";
                List listAsList2 = Arrays.asList(this.e);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(listAsList2);
                arrayList2.add(this.l);
                strArr4 = new String[arrayList2.size()];
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    strArr4[i2] = (String) arrayList2.get(i2);
                }
                str4 = this.f;
            } else {
                if (cVar == c.MORE_LOADING) {
                    String[] strArr9 = this.c;
                    String str7 = this.d;
                    String[] strArr10 = this.e;
                    strArr = strArr9;
                    str = str7;
                    str2 = this.f + " limit " + this.k;
                    strArr2 = strArr10;
                } else if (cVar == c.UNREAD_LOADING) {
                    strArr3 = this.c;
                    str3 = this.d + " and _id >= ?";
                    List listAsList3 = Arrays.asList(this.e);
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(listAsList3);
                    arrayList3.add(String.valueOf(this.n));
                    strArr4 = new String[arrayList3.size()];
                    for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                        strArr4[i3] = (String) arrayList3.get(i3);
                    }
                    str4 = this.f;
                } else {
                    strArr = null;
                    str = null;
                    strArr2 = null;
                    str2 = null;
                }
                j = 0;
            }
            strArr = strArr3;
            str = str3;
            strArr2 = strArr4;
            str2 = str4;
            j = 0;
        }
        Cursor cursorQuery = getContext().getContentResolver().query(this.b, strArr, str, strArr2, str2);
        if (cursorQuery != null) {
            count = cursorQuery.getCount();
            if (cursorQuery.moveToLast()) {
                this.l = cursorQuery.getString(cursorQuery.getColumnIndex("_id"));
            } else {
                this.l = "0";
            }
            cursorQuery.registerContentObserver(this.f12683a);
        }
        int i4 = count - this.j;
        this.p = i4;
        this.j = count;
        c cVar2 = this.i;
        if (cVar2 == c.INIT_LOADING) {
            if (j > 0) {
                this.k = count;
            } else {
                this.k = 18;
            }
        } else if (cVar2 == c.NORMAL_LOADING) {
            this.k += i4;
        } else if (cVar2 != c.MORE_LOADING && cVar2 == c.UNREAD_LOADING) {
            this.k = count;
        }
        this.i = c.NORMAL_LOADING;
        LogUtil.i("MessageCursorLoader_lag", "MessageCursorLoader loadInBackground end");
        return cursorQuery;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void onCanceled(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }
}
