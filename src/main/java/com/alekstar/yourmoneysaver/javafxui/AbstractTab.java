package com.alekstar.yourmoneysaver.javafxui;

import javafx.scene.control.Tab;
import javafx.stage.Stage;

import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;

public abstract class AbstractTab {
    Stage parentWindow;
    Tab tab;

    protected AbstractTab(Stage parentWindow) {
        setParentWidnow(parentWindow);
        setTab(new Tab());
        getTab().setClosable(false);
        getTab().setText(defineName());
    }

    protected Stage getParentWindow() {
        return parentWindow;
    }

    protected void setParentWidnow(Stage parentWindow) {
        if (parentWindow == null) {
            throw new ArgumentIsNullException("parentWidnow");
        }
        this.parentWindow = parentWindow;
    }

    public Tab getTab() {
        return this.tab;
    }

    protected void setTab(Tab tab) {
        if (tab == null) {
            throw new ArgumentIsNullException("tab");
        }
        this.tab = tab;
    }

    abstract protected String defineName();

    abstract protected void constructTab();
}
