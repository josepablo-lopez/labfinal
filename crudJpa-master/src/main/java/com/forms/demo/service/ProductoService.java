package com.forms.demo.service;

import com.forms.demo.modelo.Producto;
import com.forms.demo.modeloDAO.IProducto;
import com.forms.demo.serviceInterface.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProducto dao;

    @Override
    public List<Producto> listar() {
        return (List<Producto>) dao.findAll();
    }

    @Override
    public Optional<Producto> listarId(int id) {
        return dao.findById(id);
    }

    @Override
    public int save(Producto p) {
       int res=0;
        Producto per=dao.save(p);
            if(!per.equals(null)) {
                res=1;
            }
        return res;
    }

    @Override
    public void delete(int id) {
        dao.deleteById(id);
    }
}
