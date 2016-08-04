package in.eightbitlabs.androidboilerplate.ui.main;

import java.util.List;

import in.eightbitlabs.androidboilerplate.data.model.Ribot;
import in.eightbitlabs.androidboilerplate.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void showRibots(List<Ribot> ribots);

    void showRibotsEmpty();

    void showError();

}
