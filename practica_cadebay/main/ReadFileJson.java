package main;
import java.io.FileReader;

import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.util.Map.Entry;

public class ReadFileJson {
    public static void main(String args[]) throws java.io.IOException {
        JsonParser parser = new JsonParser();
        FileReader fr = new FileReader("data.json");
        JsonElement datos = parser.parse(fr);
        //dumpJSONElement(datos);
        getElements(datos);
    }
 
    public static void dumpJSONElement(JsonElement elemento) {
    	
    	System.out.println("******DATOS*****: " + elemento);
        if (elemento.isJsonObject()) {
            System.out.println("Es objeto");
            JsonObject obj = elemento.getAsJsonObject();
            java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
            java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
            while (iter.hasNext()) {
                java.util.Map.Entry<String,JsonElement> entrada = iter.next();
                System.out.println("Clave: " + entrada.getKey());
                System.out.println("Valor:");
                dumpJSONElement(entrada.getValue());
            }
     
        } else if (elemento.isJsonArray()) {
            JsonArray array = elemento.getAsJsonArray();
            System.out.println("Es array. Numero de elementos: " + array.size());
            java.util.Iterator<JsonElement> iter = array.iterator();
            while (iter.hasNext()) {
                JsonElement entrada = iter.next();
                dumpJSONElement(entrada);
            }
        } else if (elemento.isJsonPrimitive()) {
            System.out.println("Es primitiva");
            JsonPrimitive valor = elemento.getAsJsonPrimitive();
            if (valor.isBoolean()) {
                System.out.println("Es booleano: " + valor.getAsBoolean());
                
            } else if (valor.isNumber()) {
                System.out.println("Es numero: " + valor.getAsNumber());
            } else if (valor.isString()) {
                System.out.println("Es texto: " + valor.getAsString());
            }
        } else if (elemento.isJsonNull()) {
            System.out.println("Es NULL");
        } else {
            System.out.println("Es otra cosa");
        }
    }
    
    public static void getElements(JsonElement elemento){
    	System.out.println("******DATOS*****: " + elemento);
    	JsonArray array = elemento.getAsJsonArray();
    	System.out.println("****** Longitud de la cadena *****: " + array.size());
    	for(int y=0; y < array.size(); y++) {
    		if(elemento.isJsonPrimitive()) {
    			System.out.println("+++++ Dentro de If elemento ++++" + elemento);
    			JsonPrimitive valor = elemento.getAsJsonPrimitive();
    			if(valor.isBoolean()){
    				
    				System.out.println("****** DATOS SEGUNDA FUNC *****: " + array.getAsJsonArray());
    				
    			}
    			
    		}
    		
    	}
    	
    }
}