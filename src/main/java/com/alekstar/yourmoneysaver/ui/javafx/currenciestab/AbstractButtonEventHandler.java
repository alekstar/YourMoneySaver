package com.alekstar.yourmoneysaver.ui.javafx.currenciestab;

import javafx.event.EventHandler;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * This event handler handles mouse clicking and pressing ENTER button
 *
 */
public abstract class AbstractButtonEventHandler implements
        EventHandler<InputEvent> {
    private boolean isAcceptibleEvent(InputEvent event) {
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

    @Override
    final public void handle(InputEvent event) {
        if (!isAcceptibleEvent(event)) {
            return;
        }
        executeAction();
    }

    /**
     * At this method should be action which will be executed after button is
     * clicked or press ENTER, when it is in focus
     */
    abstract protected void executeAction();
}
