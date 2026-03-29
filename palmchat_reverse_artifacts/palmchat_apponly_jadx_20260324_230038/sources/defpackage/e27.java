package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e27 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17206a;
    public BlockingQueue<String> b;
    public volatile boolean c = false;
    public Handler d;

    public e27(Context context, Handler handler, BlockingQueue<String> blockingQueue) {
        this.f17206a = context;
        this.d = handler;
        this.b = blockingQueue;
    }

    public final boolean a(String str) {
        double dRandom = Math.random();
        String[] strArr = bx6.b;
        String str2 = strArr[(int) (dRandom * ((double) strArr.length))];
        yw6.a("startActivity packageName : " + str);
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setAction(str + str2);
            intent.addFlags(268435456);
            intent.putExtra("from_packageName", this.f17206a.getPackageName());
            ax6.a(this.f17206a, intent);
            return true;
        } catch (Exception e) {
            yw6.b(e.getMessage());
            return false;
        }
    }

    public final boolean b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("content://");
            sb.append(str);
            sb.append(".wft.provider/share");
            return this.f17206a.getContentResolver().call(Uri.parse(sb.toString()), "Query", this.f17206a.getPackageName(), (Bundle) null) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Process.setThreadPriority(10);
        while (true) {
            try {
                String strTake = this.b.take();
                boolean zA = a(strTake);
                Thread.sleep(3000L);
                if (zA && b(strTake) && (handler = this.d) != null) {
                    Message messageObtainMessage = handler.obtainMessage();
                    messageObtainMessage.what = 100;
                    messageObtainMessage.obj = strTake;
                    this.d.sendMessage(messageObtainMessage);
                }
            } catch (InterruptedException unused) {
                if (this.c) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
