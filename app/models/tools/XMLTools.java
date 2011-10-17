package models.tools;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class XMLTools {
    private XMLTools() {}
 
    /**
     * Serialisation d'un objet dans un fichier
     * @param object objet a serialiser
     * @param filename chemin du fichier
     */
    public static void encodeToFile(Object object, String fileName) throws FileNotFoundException,
 IOException {
        // ouverture de l'encodeur vers le fichier
        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));
        try {
            // serialisation de l'objet
            encoder.writeObject(object);
            encoder.flush();
        } finally {
            // fermeture de l'encodeur
            encoder.close();
        }
    }
    
    /**
     * Serialisation d'un objet dans un fichier
     * @param object objet a serialiser
     * @param filename chemin du fichier
     */
    public static Object decodeToFile(String fileName) throws FileNotFoundException,
 IOException {

    	Object returnObject;
        // ouverture du d�codeur vers le fichier
        XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
        try {
            // serialisation de l'objet
        	returnObject=decoder.readObject();

        } finally {
            // fermeture du d�codeur
        	decoder.close();
        }
        return returnObject;
    }

}