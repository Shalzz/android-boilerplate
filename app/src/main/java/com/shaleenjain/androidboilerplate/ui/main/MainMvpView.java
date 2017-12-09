package com.shaleenjain.androidboilerplate.ui.main;

import java.util.List;

import com.shaleenjain.androidboilerplate.data.model.Ribot;
import com.shaleenjain.androidboilerplate.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void showLoading();

    void dismissLoading();

    void showRibots(List<Ribot> ribots);

    void showRibotsEmpty();

    void showError();

}
