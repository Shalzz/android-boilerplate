package com.shaleenjain.androidboilerplate.injection.component;

import dagger.Subcomponent;
import com.shaleenjain.androidboilerplate.injection.PerActivity;
import com.shaleenjain.androidboilerplate.injection.module.ActivityModule;
import com.shaleenjain.androidboilerplate.ui.main.MainActivity;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
