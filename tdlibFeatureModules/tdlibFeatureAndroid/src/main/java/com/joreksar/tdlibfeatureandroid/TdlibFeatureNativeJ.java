package com.joreksar.tdlibfeatureandroid;

public class TdlibFeatureNativeJ {
    
    static {
        System.loadLibrary("tdjniwrapper");
    }

    public static native long tdJsonClientCreate();

    public static native void tdJsonClientSend(long client, String request);

    public static native String tdJsonClientReceive(long client, double timeout);

    public static native void tdJsonClientDestroy(long client);

    public static native String tdJsonClientExecute(long client, String request);
}
