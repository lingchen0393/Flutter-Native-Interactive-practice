/**
 * 此MainActivity为，在启动flutter项目的同时自动启动
 */

package com.example.android_interaction_demo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import io.flutter.Log;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.view.FlutterView;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends FlutterActivity {

    /**
     * 进行自定义的插件，android_flutter_plugin1，由flutter中的onPressed触发
     */
    private static final String CHANNEL = "android_flutter_plugin1";
    static MethodChannel methodChannel;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//    @Override
//    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
//
//        Log.i("TAG", "222222222222222");
//        GeneratedPluginRegistrant.registerWith(flutterEngine);
////getFlutterView()已经被删除  ，使用flutterEngine.getDartExecutor().getBinaryMessenger()替换
//        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(),
//                CHANNEL).setMethodCallHandler(new MethodChannel.MethodCallHandler(){
//
//    @Override
//    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
//            if (call.method.equals("interaction")) {
//                Log.i("TAG", "222222222222222");
//                Intent intent = new Intent(MainActivity.this, SplashActivity.class);
//                MainActivity.this.startActivity(intent);
//                result.success("Success!");
//            } else {
//                result.notImplemented();
//            }
//        }
//
//    });
//}
//}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        Log.i("TAG", "222222222222222");
        new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(),CHANNEL).setMethodCallHandler(
                new MethodChannel.MethodCallHandler() {

                    @Override
                    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {

                        if(call.method.equals("interaction")) {
                            Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                            MainActivity.this.startActivity(intent);
                            result.success("Success!");
                        } else {
                            result.notImplemented();
                        }
                    }
                }
        );
        GeneratedPluginRegistrant.registerWith(this);
    }
}


//    @Override
//    public void configureFlutterEngine(FlutterEngine flutterEngine){
//        Log.i("TAG", "222222222222222");
//        /**
//         * 注册
//         */
//        GeneratedPluginRegistrant.registerWith(flutterEngine);
//        new MethodChannel(flutterEngine.getDartExecutor(), CHANNEL).setMethodCallHandler(
//                new MethodChannel.MethodCallHandler() {
//                    @Override
//                    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
//                        if(call.method.equals("interaction")) {
//                            Log.i("TAG", "222222222222222");
//                            Intent intent = new Intent(MainActivity.this, SplashActivity.class);
//                            MainActivity.this.startActivity(intent);
//                            result.success("Success!");
//                        } else {
//                            result.notImplemented();
//                        }
//                    }
//                }
//        );
//    }
//
//}

