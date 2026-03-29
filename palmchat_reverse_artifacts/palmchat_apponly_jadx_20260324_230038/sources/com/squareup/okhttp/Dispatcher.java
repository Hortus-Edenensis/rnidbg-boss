package com.squareup.okhttp;

import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.http.ResponseHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class Dispatcher {
    private final ThreadPoolExecutor executorService = new ThreadPoolExecutor(8, 8, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Map<Object, List<Job>> enqueuedJobs = new LinkedHashMap();

    /* JADX INFO: compiled from: SearchBox */
    public static class RealResponseBody extends Response.Body {
        private final InputStream in;
        private final ResponseHeaders responseHeaders;

        public RealResponseBody(ResponseHeaders responseHeaders, InputStream inputStream) {
            this.responseHeaders = responseHeaders;
            this.in = inputStream;
        }

        @Override // com.squareup.okhttp.Response.Body
        public InputStream byteStream() throws IOException {
            return this.in;
        }

        @Override // com.squareup.okhttp.Response.Body
        public long contentLength() {
            return this.responseHeaders.getContentLength();
        }

        @Override // com.squareup.okhttp.Response.Body
        public MediaType contentType() {
            String contentType = this.responseHeaders.getContentType();
            if (contentType != null) {
                return MediaType.parse(contentType);
            }
            return null;
        }

        @Override // com.squareup.okhttp.Response.Body
        public boolean ready() throws IOException {
            return true;
        }
    }

    public synchronized void cancel(Object obj) {
        List<Job> listRemove = this.enqueuedJobs.remove(obj);
        if (listRemove == null) {
            return;
        }
        Iterator<Job> it = listRemove.iterator();
        while (it.hasNext()) {
            this.executorService.remove(it.next());
        }
    }

    public synchronized void enqueue(OkHttpClient okHttpClient, Request request, Response.Receiver receiver) {
        Job job = new Job(this, okHttpClient, request, receiver);
        List<Job> arrayList = this.enqueuedJobs.get(request.tag());
        if (arrayList == null) {
            arrayList = new ArrayList<>(2);
            this.enqueuedJobs.put(request.tag(), arrayList);
        }
        arrayList.add(job);
        this.executorService.execute(job);
    }

    public synchronized void finished(Job job) {
        List<Job> list = this.enqueuedJobs.get(job.tag());
        if (list != null) {
            list.remove(job);
        }
    }
}
