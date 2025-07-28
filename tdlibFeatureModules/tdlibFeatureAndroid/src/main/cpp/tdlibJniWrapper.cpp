#include <jni.h>
#include "tdlibJniWrapper.h"

extern "C" {

    void* td_json_client_create();

    void td_json_client_send(void* client, const char *request);

    const char* td_json_client_receive(void* client, double timeout);

    const char* td_json_client_execute(void* client, const char *request);

    void td_json_client_destroy(void* client);
}

#ifdef __cplusplus
extern "C" {
#endif

    jlong asJLong(void* ptr) {
        return reinterpret_cast<jlong>(ptr);
    }

    void* asVoid(jlong ptr) {
        return reinterpret_cast<void*>(ptr);
    }

    /*
     * Class:     com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ
     * Method:    tdJsonClientCreate
     * Signature: ()I
     */
    JNIEXPORT jlong JNICALL Java_com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ_tdJsonClientCreate
            (JNIEnv*, jclass) {
        return asJLong(td_json_client_create());
    }

    /*
     * Class:     com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ
     * Method:    tdJsonClientSend
     * Signature: (ILjava/lang/String;)V
     */
    JNIEXPORT void JNICALL Java_com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ_tdJsonClientSend
    (JNIEnv* jniEnv, jclass, jlong client, jstring request) {

        const char* nativeRequest = jniEnv->GetStringUTFChars(request, nullptr);
        td_json_client_send(asVoid(client), nativeRequest);
        jniEnv->ReleaseStringUTFChars(request, nativeRequest);
    }

    /*
     * Class:     com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ
     * Method:    tdJsonClientReceive
     * Signature: (ID)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ_tdJsonClientReceive
            (JNIEnv* jniEnv, jclass, jlong client, jdouble timeout) {

        const char* nativeResponse = td_json_client_receive(asVoid(client), timeout);
        return jniEnv->NewStringUTF(nativeResponse);
    }

    /*
     * Class:     com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ
     * Method:    tdJsonClientDestroy
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ_tdJsonClientDestroy
    (JNIEnv*, jclass, jlong client) {

        td_json_client_destroy(asVoid(client));
    }

    /*
     * Class:     com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ
     * Method:    tdJsonClientExecute
     * Signature: (ILjava/lang/String;)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ_tdJsonClientExecute
            (JNIEnv* jniEnv, jclass, jlong client, jstring request) {

        const char* nativeRequest = jniEnv->GetStringUTFChars(request, nullptr);
        const char* nativeResponse = td_json_client_execute(asVoid(client), nativeRequest);
        jniEnv->ReleaseStringUTFChars(request, nativeRequest);
        return jniEnv->NewStringUTF(nativeResponse);
    }

#ifdef __cplusplus
}
#endif
