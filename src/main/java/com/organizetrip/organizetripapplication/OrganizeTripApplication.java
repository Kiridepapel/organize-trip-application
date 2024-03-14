package com.organizetrip.organizetripapplication;
// import org.apache.http.HttpResponse;
// import org.apache.http.client.methods.HttpGet;
// import org.apache.http.impl.client.CloseableHttpClient;
// import org.apache.http.impl.client.HttpClients;
// import org.apache.http.util.EntityUtils;

import com.organizetrip.organizetripapplication.gui.MainFrame;

public class OrganizeTripApplication {

    public static void main(String[] args) {
        // Crea una instancia de WelcomeScreen
        MainFrame mainFrame = new MainFrame();
        // Hace visible el JFrame
        mainFrame.setVisible(true);

//        String query = "San marta";
//        query = query.replace(" ", "+"); // Reemplaza espacios por + para formatear la URL
//        
//        String url = "https://nominatim.openstreetmap.org/search?q=" + query + "&format=json&limit=1";
//
//        try (CloseableHttpClient client = HttpClients.createDefault()) {
//            HttpGet request = new HttpGet(url);
//            
//            // Es importante establecer un User-Agent adecuado cuando uses Nominatim
//            request.addHeader("User-Agent", "Mozilla/5.0");
//            
//            HttpResponse response = client.execute(request);
//            String jsonResponse = EntityUtils.toString(response.getEntity());
//
//            System.out.println(jsonResponse); // Imprime el resultado para que puedas analizarlo
//            // Aquí deberías parsear el JSON para extraer la latitud y longitud
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
