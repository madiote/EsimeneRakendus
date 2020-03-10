#include <jni.h>
#include <random>
// Traditional c++ function
auto randomNumber(int start, int end){
    std::random_device r;
    std::default_random_engine en(r());
    std::uniform_int_distribution<int> dist(start, end);
    return dist(en);
}
// JNI wrapper function
extern "C" JNIEXPORT jint JNICALL
Java_com_tlu_esimenerakendus_MainActivity_randomDice(
        JNIEnv* env,
        jobject /* this */) {
    return randomNumber(1, 6);
}

