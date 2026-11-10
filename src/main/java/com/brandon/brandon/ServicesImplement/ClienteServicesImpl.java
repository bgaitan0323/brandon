package com.brandon.brandon.ServicesImplement;

import com.brandon.brandon.dtos.ClienteDto;
import com.brandon.brandon.dtos.ClienteDtOResponse;
import com.brandon.brandon.mappers.ClienteMapper;
import com.brandon.brandon.models.Cliente;
import com.brandon.brandon.models.TiposCliente;
import com.brandon.brandon.repositoryes.ClienteRepository;
import com.brandon.brandon.repositoryes.TiposClienteRepository;
import com.brandon.brandon.services.ClienteServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServicesImpl implements ClienteServices {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final TiposClienteRepository tiposClienteRepository;

    // registrar un nuevo cliente
    @Override
    public ClienteDtOResponse guardar(ClienteDto clienteDto) {
        Cliente cliente = clienteMapper.toCliente(clienteDto);
        cliente.setTiposCliente(buscarTipo(clienteDto));
        Cliente guardado = clienteRepository.save(cliente);
        return clienteMapper.toDto(guardado);
    }

    // listar todos los clientes
    @Override
    public List<ClienteDtOResponse> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    // consultar cliente por id
    @Override
    public ClienteDtOResponse consultarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
        return clienteMapper.toDto(cliente);
    }

    // actualizar un cliente
    @Override
    public ClienteDtOResponse actualizar(Long id, ClienteDto clienteDto) {
        Cliente existente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));

        // atributos de usuario
        existente.setNom(clienteDto.getNombres());
        existente.setApe(clienteDto.getApellidos());
        existente.setDir(clienteDto.getDireccion());
        existente.setTel(clienteDto.getTelefono());
        // atributos de cliente
        existente.setTipoCliente(clienteDto.getTipCli());
        existente.setTipoClienteNum(clienteDto.getTipCli());
        existente.setTiposCliente(buscarTipo(clienteDto));
        existente.setPuntos(clienteDto.getPuntos());

        Cliente actualizado = clienteRepository.save(existente);
        return clienteMapper.toDto(actualizado);
    }

    // eliminar un cliente
    @Override
    public void eliminar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado con id: " + id);
        }
        clienteRepository.deleteById(id);
    }

    // busca en tipos_cliente la fila que coincide con el enum
    private TiposCliente buscarTipo(ClienteDto dto) {
        if (dto.getTipCli() == null) {
            return null;
        }
        return tiposClienteRepository.findByNombre(dto.getTipCli().name())
                .orElseThrow(() -> new RuntimeException(
                        "Tipo de cliente no existe en tipos_cliente: " + dto.getTipCli()));
    }
}