package com.squareup.okhttp;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class Failure {
    private final Throwable exception;
    private final Request request;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private Throwable exception;
        private Request request;

        public Failure build() {
            return new Failure(this);
        }

        public Builder exception(Throwable th) {
            this.exception = th;
            return this;
        }

        public Builder request(Request request) {
            this.request = request;
            return this;
        }
    }

    public Throwable exception() {
        return this.exception;
    }

    public Request request() {
        return this.request;
    }

    private Failure(Builder builder) {
        this.request = builder.request;
        this.exception = builder.exception;
    }
}
