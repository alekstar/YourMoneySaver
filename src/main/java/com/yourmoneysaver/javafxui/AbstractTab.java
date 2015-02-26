package com.yourmoneysaver.javafxui;

import com.yourmoneysaver.exceptions.ArgumentIsNullException;

import javafx.scene.control.Tab;
import javafx.stage.Stage;

public abstract class AbstractTab {
    Stage parentWindow;
    Tab tab;

    protected AbstractTab(Stage parentWindow) {
        setParentWidnow(parentWindow);
        setTab(new Tab());
        getTab().setClosable(false);
        getTab().setText(defineName());
        constructTab();
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
