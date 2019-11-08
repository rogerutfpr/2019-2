package com.example.app.negocio;

import com.example.app.negocio.dominio.ClienteDTO;
import com.example.app.negocio.excecao.ObjetoJaExisteException;
import com.example.app.persistencia.ClienteDAO;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClienteNegocio implements INegocio<ClienteDTO>{
    
    private final ClienteDAO clienteDAO;

    @Override
    public void incluir(ClienteDTO cliente) throws ObjetoJaExisteException {

        if (clienteDAO.findByNome(cliente.getNome()).isPresent())
            throw new ObjetoJaExisteException();
        
        clienteDAO.save(ClienteDTO.EntityFromDTO(cliente));
    }

    @Override
    public Set<ClienteDTO> listar() {
        return ClienteDTO.DTOsFromEntities(clienteDAO.findAll());
    }
    
    
    
    
    
    
    
//    private Set<ClienteDTO> lista;
//
//    public ClienteNegocio() {
//        lista = new HashSet<>();
//    }
//
//    @Override
//    public void incluir(ClienteDTO cliente) throws ObjetoJaExisteException {
//        if (!lista.add(cliente))
//            throw new ObjetoJaExisteException();
//    }
//
//    @Override
//    public Set<ClienteDTO> listar() {
//        return lista;
//    }
}
