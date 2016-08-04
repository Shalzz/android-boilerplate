package in.eightbitlabs.androidboilerplate.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import in.eightbitlabs.androidboilerplate.data.DataManager;
import in.eightbitlabs.androidboilerplate.data.SyncService;
import in.eightbitlabs.androidboilerplate.data.local.DatabaseHelper;
import in.eightbitlabs.androidboilerplate.data.local.PreferencesHelper;
import in.eightbitlabs.androidboilerplate.data.remote.RibotsService;
import in.eightbitlabs.androidboilerplate.injection.ApplicationContext;
import in.eightbitlabs.androidboilerplate.injection.module.ApplicationModule;
import in.eightbitlabs.androidboilerplate.util.RxEventBus;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SyncService syncService);

    @ApplicationContext Context context();
    Application application();
    RibotsService ribotsService();
    PreferencesHelper preferencesHelper();
    DatabaseHelper databaseHelper();
    DataManager dataManager();
    RxEventBus eventBus();

}
