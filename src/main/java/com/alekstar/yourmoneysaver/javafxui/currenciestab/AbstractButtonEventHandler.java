package com.alekstar.yourmoneysaver.javafxui.currenciestab;

import javafx.event.EventHandler;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public abstract class AbstractButtonEventHandler implements
        EventHandler<InputEvent> {
    protected boolean isAcceptibleEvent(InputEvent event) {
        if (!isAcceptibleEventType(event)) {
            return false;
        }
        if (event instanceof MouseEvent) {
            MouseEvent mouseEvent = (MouseEvent) event;
            if (!isAcceptibleMouseEvent(mouseEvent)) {
                return false;
            }
        }
        if (event instanceof KeyEvent) {
            KeyEvent keyEvent = (KeyEvent) event;
            if (!isAcceptibleKeyEvent(keyEvent)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAcceptibleEventType(InputEvent event) {
        if (!(event instanceof MouseEvent) && !(event instanceof KeyEvent)) {
            return false;
        }
        return true;
    }

    private boolean isAcceptibleMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != MouseButton.PRIMARY) {
            return false;
        }
        if (mouseEvent.getEventType() != MouseEvent.MOUSE_CLICKED) {
            return false;
        }
        return true;
    }

    private boolean isAcceptibleKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getCode() != KeyCode.ENTER) {
            return false;
        }
        return true;
    }
}
