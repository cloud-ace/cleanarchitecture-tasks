package jp.cloudace.tech.clean.demo.tasks.views;

import jp.cloudace.tech.clean.demo.tasks.presenters.viewmodels.Color;
import jp.cloudace.tech.clean.demo.tasks.presenters.viewmodels.PrintViewModel;
import jp.cloudace.tech.clean.demo.tasks.presenters.views.PrintView;

public class CommandLineView implements PrintView {

    private static final String DECORATION_RESET = "\033[0m";

    @Override
    public void print(PrintViewModel viewModel) {

        String colorDecoration = toColorString(viewModel.getMessageColor());

        System.out.print(colorDecoration);
        viewModel.getMessages().forEach(System.out::println);
        System.out.print(DECORATION_RESET);

    }

    private static String toColorString(Color color) {

        if (color == null) {
            return "";
        }

        switch (color) {
            case RED:
                return "\033[0;31m";
            case GREEN:
                return "\033[0;32m";
            default:
                return "";
        }
    }

}
