package com.example.supermercasa.ServicioInterno;

public class Email {

    private String destinatario;
    private String origen;
    private String mensaje;
    private String asunto;

    public Email(String destinatario, String asunto, String mensaje) {
        this.destinatario = destinatario;
        this.origen = "supermercasa.33@outlook.es";
        this.mensaje = mensaje;
        this.asunto = asunto;
    }

    public Email(String destinatario,  String asunto) {
        this.destinatario = destinatario;
        this.origen = "supermercasa.33@outlook.es";
        this.asunto = asunto;
    }


    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

}
