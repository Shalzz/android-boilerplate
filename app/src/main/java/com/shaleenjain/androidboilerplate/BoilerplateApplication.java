package com.shaleenjain.androidboilerplate;

import android.app.Application;
import android.content.Context;

import com.shaleenjain.androidboilerplate.injection.component.ApplicationComponent;
import com.shaleenjain.androidboilerplate.injection.component.DaggerApplicationComponent;
import com.shaleenjain.androidboilerplate.injection.module.ApplicationModule;

import timber.log.Timber;

public class BoilerplateApplication extends Application  {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

          // TODO: uncomment this when you have added the Bugsnag API key
//        Bugsnag.init(this);
//        Timber.plant(new BugsnagTree());

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static BoilerplateApplication get(Context context) {
        return (BoilerplateApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
