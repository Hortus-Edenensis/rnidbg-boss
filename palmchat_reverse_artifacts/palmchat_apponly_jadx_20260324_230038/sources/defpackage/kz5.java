package defpackage;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.traceroutePing.TraceActivity;
import com.zenmen.palmchat.utils.traceroutePing.TracerouteContainer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class kz5 {
    public static Runnable i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TracerouteContainer f18860a;
    public int b;
    public int c;
    public String d;
    public String e;
    public float f;
    public TraceActivity g;
    public Handler h;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends AsyncTask<Void, Void, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f18861a;
        public int b;

        /* JADX INFO: renamed from: kz5$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1241a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Exception f18862a;

            public RunnableC1241a(Exception exc) {
                this.f18862a = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.d(this.f18862a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Exception f18863a;

            public b(Exception exc) {
                this.f18863a = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.d(this.f18863a);
            }
        }

        public a(int i) {
            this.b = i;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... voidArr) {
            TracerouteContainer tracerouteContainer;
            if (!kz5.this.u()) {
                return kz5.this.g.getString(R.string.no_connectivity);
            }
            try {
                String strC = c(kz5.this.d);
                String strV = kz5.this.v(strC);
                if (!strC.contains("100%") || strC.contains("exceed")) {
                    tracerouteContainer = new TracerouteContainer("", strV, kz5.this.b == this.b ? Float.parseFloat(kz5.this.x(strC)) : kz5.this.f, true);
                } else {
                    tracerouteContainer = new TracerouteContainer("", strV, kz5.this.f, false);
                }
                InetAddress byName = InetAddress.getByName(tracerouteContainer.getIp());
                String hostName = byName.getHostName();
                String canonicalHostName = byName.getCanonicalHostName();
                tracerouteContainer.setHostname(hostName);
                kz5.this.f18860a = tracerouteContainer;
                Log.d("TraceroutePing", "hostname : " + hostName);
                Log.d("TraceroutePing", "canonicalHostname : " + canonicalHostName);
                Log.d("TraceroutePing", tracerouteContainer.toString());
                if (!strV.equals(kz5.this.e) || kz5.this.b == this.b) {
                    kz5.this.g.g(tracerouteContainer);
                }
                return strC;
            } catch (Exception e) {
                kz5.this.g.runOnUiThread(new RunnableC1241a(e));
                return "";
            }
        }

        @SuppressLint({"NewApi"})
        public final String c(String str) throws Exception {
            String str2 = String.format("ping -c 1 -t %d ", Integer.valueOf(kz5.this.b));
            Log.d("TraceroutePing", "Will launch : " + str2 + str);
            long jNanoTime = System.nanoTime();
            kz5.this.f = 0.0f;
            kz5 kz5Var = kz5.this;
            kz5Var.new b(this, kz5Var.b).execute(new Void[0]);
            Process processExec = Runtime.getRuntime().exec(str2 + str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
            String str3 = "";
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                str3 = str3 + line + "\n";
                if (line.contains(HttpHeaders.FROM) || line.contains("from")) {
                    kz5.this.f = (System.nanoTime() - jNanoTime) / 1000000.0f;
                }
            }
            processExec.destroy();
            if (str3.equals("")) {
                throw new IllegalArgumentException();
            }
            if (kz5.this.b == 1) {
                kz5 kz5Var2 = kz5.this;
                kz5Var2.e = kz5Var2.w(str3);
            }
            return str3;
        }

        public final void d(Exception exc) {
            Log.e("TraceroutePing", exc.toString());
            if (exc instanceof IllegalArgumentException) {
                sy5.f(kz5.this.g, kz5.this.g.getString(R.string.no_ping), 0).g();
            } else {
                sy5.f(kz5.this.g, kz5.this.g.getString(R.string.error), 0).g();
            }
            kz5.this.g.i();
            kz5.this.c++;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            if (!this.f18861a) {
                try {
                    if (!"".equals(str)) {
                        if (kz5.this.g.getString(R.string.no_connectivity).equals(str)) {
                            sy5.f(kz5.this.g, kz5.this.g.getString(R.string.no_connectivity), 0).g();
                        } else {
                            Log.d("TraceroutePing", str);
                            if (kz5.this.f18860a != null && kz5.this.f18860a.getIp().equals(kz5.this.e)) {
                                int i = kz5.this.b;
                                int i2 = this.b;
                                if (i < i2) {
                                    kz5.this.b = i2;
                                    kz5.this.new a(this.b).execute(new Void[0]);
                                } else {
                                    kz5.this.g.i();
                                }
                            } else if (kz5.this.b < this.b) {
                                kz5.this.b++;
                                kz5.this.new a(this.b).execute(new Void[0]);
                            }
                        }
                    }
                    kz5.this.c++;
                } catch (Exception e) {
                    kz5.this.g.runOnUiThread(new b(e));
                }
            }
            super.onPostExecute(str);
        }

        public void f(boolean z) {
            this.f18861a = z;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AsyncTask<Void, Void, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f18864a;
        public int b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f18864a != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(b.this.b);
                    sb.append(" task.isFinished()");
                    sb.append(kz5.this.c);
                    sb.append(" ");
                    sb.append(b.this.b == kz5.this.c);
                    Log.e("TraceroutePing", sb.toString());
                    if (b.this.b == kz5.this.c) {
                        sy5.f(kz5.this.g, kz5.this.g.getString(R.string.timeout), 0).g();
                        b.this.f18864a.f(true);
                        b.this.f18864a.cancel(true);
                        kz5.this.g.i();
                    }
                }
            }
        }

        public b(a aVar, int i) {
            this.f18864a = aVar;
            this.b = i;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            return null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r5) {
            if (kz5.this.h == null) {
                kz5.this.h = new Handler();
            }
            if (kz5.i != null) {
                kz5.this.h.removeCallbacks(kz5.i);
            }
            kz5.i = new a();
            kz5.this.h.postDelayed(kz5.i, 30000L);
            super.onPostExecute(r5);
        }
    }

    public kz5(TraceActivity traceActivity) {
        this.g = traceActivity;
    }

    public void t(String str, int i2) {
        this.b = 1;
        this.c = 0;
        this.d = str;
        new a(i2).execute(new Void[0]);
    }

    public boolean u() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.g.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final String v(String str) {
        if (!str.contains(HttpHeaders.FROM)) {
            return str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        }
        String strSubstring = str.substring(str.indexOf(HttpHeaders.FROM) + 5);
        if (strSubstring.contains("(")) {
            return strSubstring.substring(strSubstring.indexOf("(") + 1, strSubstring.indexOf(")"));
        }
        String strSubstring2 = strSubstring.substring(0, strSubstring.indexOf("\n"));
        return strSubstring2.substring(0, strSubstring2.contains(":") ? strSubstring2.indexOf(":") : strSubstring2.indexOf(" "));
    }

    public final String w(String str) {
        if (!str.contains("PING")) {
            return "";
        }
        return str.substring(str.indexOf("(") + 1, str.indexOf(")"));
    }

    public final String x(String str) {
        if (!str.contains("time=")) {
            return "";
        }
        String strSubstring = str.substring(str.indexOf("time=") + 5);
        return strSubstring.substring(0, strSubstring.indexOf(" "));
    }
}
