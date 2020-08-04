package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("lwaG3MkLSEeoVFrcYcnJCPC2MQgCDQqvupyvIHv2")
                .clientKey("GGgfbiARSsrpEhF02ZgBLe7TStH1NwpuTGxxeAnh")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
