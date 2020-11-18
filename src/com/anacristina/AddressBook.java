package com.anacristina;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Scanner;

public class AddressBook {
    private static HashMap<String,String> contactos = new HashMap<String, String>();
    public static void load() throws IOException{
        String separator = FileSystems.getDefault().getSeparator();
        String filename = String.format("com.anacristina.contactos",separator, separator, separator);
        Path path = Paths.get(filename);
        ArrayList<String>lines =new ArrayList<>();
        if (!Files.exists(path)){
            File file = new File(String.valueOf(path));
            file.createNewFile();
        }
        lines = (ArrayList<String>) Files.readAllLines(path);
        for (var contacto: lines){
            var informacion = contacto.split(",");
            contactos.put(informacion[0].trim(), informacion[1].trim());
        }
    }

public static void save() throws IOException{
    String separator = FileSystems.getDefault().getSeparator();
    String filename = String.format("com.anacristina.contactos", separator,separator,separator);
    Path path = Paths.get(filename);
    ArrayList<String>save = new ArrayList<>();
    for (var contacto: contactos.entrySet()){
        save.add(contacto.getKey()+","+contacto.getValue());
        }
    Files.write(path,save);
    }
    public void lista (){
    for (var contacto: contactos.entrySet()){
        System.out.println(String.format(" Nombre: %s, Numero: %s", contacto.getKey(),contacto.getValue()));
    }
}
public static void create(String telefono, String nombre) throws IOException{
    contactos.put( telefono,nombre);
    save();
    load();
}
public static void delete (String telefono) throws IOException{
    var p = contactos.remove(telefono);
    save();
    load();
}
}