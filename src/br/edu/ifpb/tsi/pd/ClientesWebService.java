/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tsi.pd;

import br.edu.ifpb.tsi.pd.model.Cliente;
import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Professor
 */
@WebService(serviceName = "ClientesWebService")
public class ClientesWebService {

    private Map<String,Cliente> clientes = new HashMap<String,Cliente>();
    
    public ClientesWebService(){
        clientes.put("1", new Cliente("1","Marisa"));
        clientes.put("2", new Cliente("2","Teresa"));
        clientes.put("3", new Cliente("3","Joao"));
    }
    
    @WebMethod(operationName = "buscaClientePorCPF")
    public Cliente getCliente(@WebParam(name = "cpf")String cpf){
        return clientes.get(cpf);
    }
    
    @WebMethod(operationName = "insereCliente")
    public Cliente addCliente(@WebParam(name = "cliente")Cliente cliente){
        if (!clientes.containsKey(cliente.getCpf()))
            clientes.put(cliente.getCpf(), cliente);
        return cliente;
    }
    
    @WebMethod(exclude = true)
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
