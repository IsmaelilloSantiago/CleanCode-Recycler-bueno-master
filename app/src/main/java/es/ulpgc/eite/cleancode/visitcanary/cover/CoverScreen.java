package es.ulpgc.eite.cleancode.visitcanary.cover;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.visitcanary.R;
import es.ulpgc.eite.cleancode.visitcanary.app.CatalogMediator;

public class CoverScreen {

    public static void configure(CoverContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String comenzar = context.get().getString(R.string.button);
        String titulo= context.get().getString(R.string.textview);

        CatalogMediator mediator = CatalogMediator.getInstance();

        CoverContract.Presenter presenter = new CoverPresenter(mediator);
        CoverContract.Model model = new CoverModel(comenzar,titulo);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}