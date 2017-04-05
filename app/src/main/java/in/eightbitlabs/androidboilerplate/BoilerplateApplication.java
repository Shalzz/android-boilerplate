package in.eightbitlabs.androidboilerplate;

import android.app.Application;
import android.content.Context;

import com.bugsnag.android.Bugsnag;

import in.eightbitlabs.androidboilerplate.injection.component.ApplicationComponent;
import in.eightbitlabs.androidboilerplate.injection.component.DaggerApplicationComponent;
import in.eightbitlabs.androidboilerplate.injection.module.ApplicationModule;
import in.eightbitlabs.androidboilerplate.util.BugsnagTree;
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
