package cn.fly.verify;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.fly.verify.common.exception.VerifyException;
import cn.fly.verify.pure.entity.PreVerifyResult;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile q f2426a;
    private Handler b;
    private HashMap<String, Integer> c;

    /* JADX INFO: renamed from: cn.fly.verify.q$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 extends Handler {
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            final Message message2 = new Message();
            message2.copyFrom(message);
            new ar() { // from class: cn.fly.verify.q.1.1
                @Override // cn.fly.verify.ar
                public void a() {
                    f.a().a("receive message " + message2);
                    Message message3 = message2;
                    int i = message3.what;
                    Bundle data = message3.getData();
                    if (data != null) {
                        final String string = data.getString("operator");
                        final String string2 = data.getString("id");
                        final String string3 = data.getString("secret");
                        final int i2 = data.getInt("multi");
                        Integer numValueOf = data.containsKey("channel") ? Integer.valueOf(data.getInt("channel")) : null;
                        String string4 = data.containsKey("channelAccount") ? data.getString("channelAccount") : null;
                        final e eVar = new e(g.PREVERIFY);
                        eVar.a((Integer) 2);
                        s sVarA = as.a(null, i, string2, string3, i2, numValueOf, string4, eVar);
                        if (sVarA != null) {
                            final Integer num = numValueOf;
                            final String str = string4;
                            sVarA.a(true, new cn.fly.verify.common.callback.b() { // from class: cn.fly.verify.q.1.1.1
                                @Override // cn.fly.verify.common.callback.b
                                public void a(VerifyException verifyException) {
                                }

                                @Override // cn.fly.verify.common.callback.b
                                public void a(Object obj) {
                                    e eVar2 = eVar;
                                    if (eVar2 != null) {
                                        eVar2.a(string, string2);
                                    }
                                    if (obj instanceof PreVerifyResult) {
                                        q.this.a(string, string2, string3, i2, num, str, ((PreVerifyResult) obj).getExpireAt());
                                    }
                                }
                            });
                        }
                    }
                }
            }.b();
        }
    }

    private q() {
        try {
            HashMap<String, Integer> map = new HashMap<>();
            this.c = map;
            map.put("CMCC", 1);
            this.c.put("CUCC", 2);
            this.c.put("CTCC", 4);
            this.c.put("CUXW", 3);
            this.b = new AnonymousClass1(Looper.getMainLooper());
        } catch (Throwable th) {
            f.a().a(th);
        }
    }

    public static q a() {
        if (f2426a == null) {
            synchronized (q.class) {
                if (f2426a == null) {
                    f2426a = new q();
                }
            }
        }
        return f2426a;
    }

    public void a(String str) {
        try {
            Handler handler = this.b;
            if (handler != null) {
                handler.removeMessages(this.c.get(str).intValue());
                f.a().a("cancel: " + str);
            }
        } catch (Throwable th) {
            f.a().a(th);
        }
    }

    public void a(String str, String str2, String str3, int i, Integer num, String str4, long j) {
        try {
            Handler handler = this.b;
            if (handler != null) {
                handler.removeMessages(this.c.get(str).intValue());
                Message messageObtain = Message.obtain();
                messageObtain.what = this.c.get(str).intValue();
                messageObtain.getData().putString("operator", str);
                messageObtain.getData().putString("id", str2);
                messageObtain.getData().putString("secret", str3);
                messageObtain.getData().putInt("multi", i);
                if (num != null) {
                    messageObtain.getData().putInt("channel", num.intValue());
                }
                if (str4 != null) {
                    messageObtain.getData().putString("channelAccount", str4);
                }
                long jCurrentTimeMillis = j - System.currentTimeMillis();
                if (jCurrentTimeMillis < 0) {
                    jCurrentTimeMillis = 3600000;
                }
                this.b.sendMessageDelayed(messageObtain, jCurrentTimeMillis);
                f.a().a("submit: " + str + ", " + str2 + ", " + j);
            }
        } catch (Throwable th) {
            f.a().a(th);
        }
    }
}
