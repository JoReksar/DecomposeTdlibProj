/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ */

#ifndef _Included_com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ
#define _Included_com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ
 * Method:    tdJsonClientCreate
 * Signature: ()I
 */
JNIEXPORT jlong JNICALL Java_com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ_tdJsonClientCreate
  (JNIEnv *, jclass);

/*
 * Class:     com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ
 * Method:    tdJsonClientSend
 * Signature: (ILjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ_tdJsonClientSend
  (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ
 * Method:    tdJsonClientReceive
 * Signature: (ID)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ_tdJsonClientReceive
  (JNIEnv *, jclass, jlong, jdouble);

/*
 * Class:     com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ
 * Method:    tdJsonClientDestroy
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ_tdJsonClientDestroy
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ
 * Method:    tdJsonClientExecute
 * Signature: (ILjava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_joreksar_tdlibfeatureandroid_TdlibFeatureNativeJ_tdJsonClientExecute
  (JNIEnv *, jclass, jlong, jstring);

#ifdef __cplusplus
}
#endif
#endif
