package br.edu.utfpr.cp.sa.appclientepais;

public class PaisNaoDefinidoException extends Exception {

    public PaisNaoDefinidoException() {
        super("País não pode ser nulo/vazio");
    }
    
}
