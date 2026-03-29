package com.tencent.matrix.batterycanary.utils;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class LinkStart {
    private static final int PAD_LIMIT = 8192;
    Session mCurrent;
    boolean mIsFinished;
    final Session mRoot;
    final Ticker mTicker;

    /* JADX INFO: compiled from: SearchBox */
    public static class NanoTicker implements Ticker {
        @Override // com.tencent.matrix.batterycanary.utils.LinkStart.Ticker
        @SuppressLint({"ObsoleteSdkInt"})
        public long currentTime() {
            return SystemClock.elapsedRealtimeNanos();
        }

        @Override // com.tencent.matrix.batterycanary.utils.LinkStart.Ticker
        public long getInterval(long j, long j2) {
            return j2 - j;
        }

        @Override // com.tencent.matrix.batterycanary.utils.LinkStart.Ticker
        public TimeUnit getUnit() {
            return TimeUnit.NANOSECONDS;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class Session {
        private static final int MAX_TITLE_LENGTH = 30;
        private static final String PREFIX = "----";
        List<Session> children;
        long endTime;
        String name;
        Session parent;
        int path = 0;
        long startTime;

        public Session(String str) {
            this.name = str;
        }

        public void addChild(Session session) {
            if (this.children == null) {
                this.children = new LinkedList();
            }
            this.children.add(session);
        }

        public Session attach(Session session) {
            this.parent = session;
            return this;
        }

        public Session end() {
            this.endTime = LinkStart.this.mTicker.currentTime();
            return this;
        }

        public Session enter(String str) {
            if (this.parent == null) {
                throw new IllegalStateException("this method need a nonnull parent.");
            }
            Session sessionAttach = LinkStart.this.new Session(str).attach(this.parent);
            sessionAttach.startTime = LinkStart.this.mTicker.currentTime();
            sessionAttach.path = this.path;
            this.parent.addChild(sessionAttach);
            return sessionAttach;
        }

        public Session insert(String str) {
            Session sessionAttach = LinkStart.this.new Session(str).attach(this);
            sessionAttach.startTime = LinkStart.this.mTicker.currentTime();
            sessionAttach.path = this.path + 1;
            addChild(sessionAttach);
            return sessionAttach;
        }

        @NonNull
        public String toString() {
            String strValueOf;
            int i = this.path;
            String strRepeat = i > 0 ? LinkStart.repeat("----", i) : "";
            long j = this.startTime;
            if (j == 0) {
                strValueOf = "losing record of bgn time";
            } else {
                long j2 = this.endTime;
                strValueOf = j2 == 0 ? "losing record of end time" : String.valueOf(LinkStart.this.mTicker.getInterval(j, j2));
            }
            String strSubstring = this.name;
            if (strSubstring.length() > 30) {
                strSubstring = this.name.substring(0, 29);
            } else if (this.name.length() < 30) {
                strSubstring = this.name + LinkStart.repeat(" ", 30 - this.name.length());
            }
            return HiAnalyticsConstant.REPORT_VAL_SEPARATOR + strRepeat + " " + strSubstring + " : " + strValueOf;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SystemClockMillisTicker implements Ticker {
        @Override // com.tencent.matrix.batterycanary.utils.LinkStart.Ticker
        public long currentTime() {
            return SystemClock.elapsedRealtime();
        }

        @Override // com.tencent.matrix.batterycanary.utils.LinkStart.Ticker
        public long getInterval(long j, long j2) {
            return j2 - j;
        }

        @Override // com.tencent.matrix.batterycanary.utils.LinkStart.Ticker
        public TimeUnit getUnit() {
            return TimeUnit.MILLISECONDS;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SystemMillisTicker implements Ticker {
        @Override // com.tencent.matrix.batterycanary.utils.LinkStart.Ticker
        public long currentTime() {
            return System.currentTimeMillis();
        }

        @Override // com.tencent.matrix.batterycanary.utils.LinkStart.Ticker
        public long getInterval(long j, long j2) {
            return j2 - j;
        }

        @Override // com.tencent.matrix.batterycanary.utils.LinkStart.Ticker
        public TimeUnit getUnit() {
            return TimeUnit.MILLISECONDS;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Ticker {
        long currentTime();

        long getInterval(long j, long j2);

        TimeUnit getUnit();
    }

    public LinkStart() {
        this(new SystemClockMillisTicker());
    }

    private void buildString(Session session, StringBuilder sb) {
        sb.append(session.toString());
        sb.append("\n");
        if (session.children != null) {
            for (int i = 0; i < session.children.size(); i++) {
                buildString(session.children.get(i), sb);
            }
        }
    }

    public static String repeat(char c, int i) {
        if (i <= 0) {
            return "";
        }
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    public void end(Session session) {
        session.end();
        this.mCurrent = session;
    }

    public Session enter(String str) {
        if (this.mIsFinished) {
            throw new IllegalStateException("this link already is finished.");
        }
        Session session = this.mCurrent;
        if (session == this.mRoot) {
            throw new IllegalStateException("root session can not have peer.");
        }
        Session sessionEnter = session.enter(str);
        this.mCurrent = sessionEnter;
        return sessionEnter;
    }

    public void finish() {
        this.mRoot.end();
        this.mIsFinished = true;
    }

    public Session getCurrent() {
        return this.mCurrent;
    }

    public Session insert(String str) {
        if (this.mIsFinished) {
            throw new IllegalStateException("this link already is finished.");
        }
        Session sessionInsert = this.mCurrent.insert(str);
        this.mCurrent = sessionInsert;
        return sessionInsert;
    }

    public void setCurrent(Session session) {
        this.mCurrent = session;
    }

    public LinkStart start() {
        this.mIsFinished = false;
        this.mRoot.startTime = this.mTicker.currentTime();
        return this;
    }

    @NonNull
    public String toString() {
        if (!this.mIsFinished) {
            return "watch cat is not finished yet.";
        }
        StringBuilder sb = new StringBuilder("watch cat, time unit = " + this.mTicker.getUnit() + "\n");
        buildString(this.mRoot, sb);
        return sb.toString();
    }

    public LinkStart(Ticker ticker) {
        this.mIsFinished = true;
        this.mTicker = ticker;
        Session session = new Session("WatchCat");
        this.mRoot = session;
        this.mCurrent = session;
    }

    public static String repeat(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i <= 0) {
            return "";
        }
        int length = str.length();
        if (i == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i <= 8192) {
            return repeat(str.charAt(0), i);
        }
        int i2 = length * i;
        if (length == 1) {
            return repeat(str.charAt(0), i);
        }
        if (length != 2) {
            StringBuilder sb = new StringBuilder(i2);
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(str);
            }
            return sb.toString();
        }
        char cCharAt = str.charAt(0);
        char cCharAt2 = str.charAt(1);
        char[] cArr = new char[i2];
        for (int i4 = (i * 2) - 2; i4 >= 0; i4 = (i4 - 1) - 1) {
            cArr[i4] = cCharAt;
            cArr[i4 + 1] = cCharAt2;
        }
        return new String(cArr);
    }
}
