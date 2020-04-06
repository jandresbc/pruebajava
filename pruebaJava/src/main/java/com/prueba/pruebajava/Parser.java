package com.prueba.pruebajava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
* This class is thread safe.
*/
public class Parser {
    private File file;
    //La clase le hacía falta la funcion constructura public static main()
    public static void main(String[] args){
        //String var = getContent();
    }
    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public String getContent() throws IOException {
        FileInputStream i = new FileInputStream(file);
        String output = "";
        int data;
        while ((data = i.read()) > 0) {
            output += (char) data;
        }
        i.close();//Se abre un archivo pero nunca se cierra.
        return output;
    }

    public String getContentWithoutUnicode() throws IOException {
        FileInputStream i = new FileInputStream(file);
        String output = "";
        int data;
        while ((data = i.read()) > 0) {
            if (data < 0x80) {
                output += (char) data;
            }
        }
        i.close();//Se abre un archivo pero nunca se cierra.
        return output;
    }
    public void saveContent(String content) {
        //-- FileOutputStream o = new FileOutputStream(file); // Este codigo no debe estar fuera del try ya que si ocurre un error no sabría como comportarse.
        try {
            FileOutputStream o = new FileOutputStream(file);
            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
            o.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}