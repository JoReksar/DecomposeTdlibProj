cmake_minimum_required(VERSION 3.22.1)
project("tdlibFeatureAndroid")

link_directories(../jniLibs/${CMAKE_ANDROID_ARCH_ABI})

add_library(tdjniwrapper SHARED
        tdlibJniWrapper.cpp)

target_link_libraries(tdjniwrapper
    android
    log
    tdjson)