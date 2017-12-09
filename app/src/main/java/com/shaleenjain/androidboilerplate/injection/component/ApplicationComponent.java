package com.shaleenjain.androidboilerplate.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import com.shaleenjain.androidboilerplate.data.DataManager;
import com.shaleenjain.androidboilerplate.data.SyncService;
import com.shaleenjain.androidboilerplate.data.local.DatabaseHelper;
import com.shaleenjain.androidboilerplate.data.local.PreferencesHelper;
import com.shaleenjain.androidboilerplate.data.remote.RibotsService;
import com.shaleenjain.androidboilerplate.injection.ApplicationContext;
import com.shaleenjain.androidboilerplate.injection.module.ApplicationModule;
import com.shaleenjain.androidboilerplate.injection.module.NetworkModule;
import com.shaleenjain.androidboilerplate.util.RxEventBus;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
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
