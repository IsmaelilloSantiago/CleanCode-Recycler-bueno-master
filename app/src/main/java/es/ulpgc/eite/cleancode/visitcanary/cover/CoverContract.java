package es.ulpgc.eite.cleancode.visitcanary.cover;

import java.lang.ref.WeakReference;

public interface CoverContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(CoverViewModel viewModel);

        void navigateToNextScreen();
        void activateButton();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void onResume();

        void onStart();
        void ButtonCliked();
        void onRestart();

        void onBackPressed();

        void onPause();

        void onDestroy();
    }

    interface Model {
        String getComenzar();
        String getTitulo();
        void onDataFromNextScreen(String data);

        void onRestartScreen(String data, String comenzar);


    }

}