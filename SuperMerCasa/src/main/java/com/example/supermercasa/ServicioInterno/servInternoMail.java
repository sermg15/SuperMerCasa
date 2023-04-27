package com.example.supermercasa.ServicioInterno;

import com.example.supermercasa.Entidades.Pedido;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.supermercasa.Entidades.Usuario;

@Service
public class servInternoMail  {
    private static final String MAIL_SERVICE_URL = "http://localhost:8445";
    public static boolean sendRegisterEmail(Usuario user) {
        try {
            Email email = new Email(user.getEmail(), "Registro Supermercasa","¡Gracias "+ user.getNombreUsuario() + " por ser parte de Supermercasa! :)");
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Void> res = restTemplate.postForEntity(MAIL_SERVICE_URL + "/email", email, Void.class);

            if(res.getStatusCode() == HttpStatus.CREATED) {
                System.out.println("Enviado correctamente");
                return true;
            }else{
                System.out.println("Error enviando:"+ res.getStatusCode());
                return false;
            }
        }catch (Exception e) {
            System.out.println("Error enviando:"+ e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean sendPedidoEmail(Usuario user, Pedido pedido) {
        try {
            Email email = new Email(user.getEmail(), "Pedido en Supermercasa","¡Gracias "+user.getNombreUsuario()+" por realizar tu pedido con Supermercasa :) <br />" +
                    "Aquí tienes tu lista de la compra: <br />"+ pedido.printPedido());
            HttpEntity<Email> httpEntity = new HttpEntity<>(email);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Void> res =restTemplate.postForEntity(MAIL_SERVICE_URL+"/email", httpEntity, Void.class);

            if(res.getStatusCode() == HttpStatus.CREATED) {
                System.out.println("Enviado correctamente");
                return true;
            }else{
                System.out.println("Error enviando:"+ res.getStatusCode());
                return false;
            }
        }catch (Exception e) {
            System.out.println("Error enviando:"+ e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}