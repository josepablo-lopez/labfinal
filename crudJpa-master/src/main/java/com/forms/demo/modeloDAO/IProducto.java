package com.forms.demo.modeloDAO;

import com.forms.demo.modelo.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProducto extends CrudRepository<Producto, Integer> {
}
